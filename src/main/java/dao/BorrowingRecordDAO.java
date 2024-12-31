package dao;

import model.BorrowingRecord;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowingRecordDAO {
    private static final String INSERT_BORROWING = "INSERT INTO borrowing_records (customer_id, book_id, borrow_date, status) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_BORROWINGS = "SELECT * FROM borrowing_records";
    private static final String SELECT_BORROWING_BY_ID = "SELECT * FROM borrowing_records WHERE id = ?";
    private static final String UPDATE_BORROWING_STATUS = "UPDATE borrowing_records SET status = ?, return_date = ? WHERE id = ?";

    public void insertBorrowing(BorrowingRecord borrowingRecord) throws SQLException {
        DatabaseMetaData DBConnection = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BORROWING)) {
            preparedStatement.setInt(1, borrowingRecord.getCustomerId());
            preparedStatement.setInt(2, borrowingRecord.getBookId());
            preparedStatement.setString(3, borrowingRecord.getBorrowDate());
            preparedStatement.setString(4, borrowingRecord.getStatus());
            preparedStatement.executeUpdate();
        }
    }

    public List<BorrowingRecord> selectAllBorrowings() throws SQLException {
        List<BorrowingRecord> borrowings = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BORROWINGS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                borrowings.add(new BorrowingRecord(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getInt("book_id"),
                        rs.getString("borrow_date"),
                        rs.getString("return_date"),
                        rs.getString("status")
                ));
            }
        }
        return borrowings;
    }

    public BorrowingRecord selectBorrowing(int id) throws SQLException {
        BorrowingRecord borrowingRecord = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BORROWING_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                borrowingRecord = new BorrowingRecord(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getInt("book_id"),
                        rs.getString("borrow_date"),
                        rs.getString("return_date"),
                        rs.getString("status")
                );
            }
        }
        return borrowingRecord;
    }

    public boolean updateBorrowingStatus(int id, String status, String returnDate) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BORROWING_STATUS)) {
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, returnDate);
            preparedStatement.setInt(3, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public void deleteBorrowing(int id) {

    }
}
