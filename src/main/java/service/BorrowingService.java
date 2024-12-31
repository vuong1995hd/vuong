package service;

import dao.BorrowingRecordDAO;
import model.BorrowingRecord;

import java.sql.SQLException;
import java.util.List;

public class BorrowingService {
    private BorrowingRecordDAO borrowingRecordDAO;

    public BorrowingService() {
        borrowingRecordDAO = new BorrowingRecordDAO();
    }

    public List<BorrowingRecord> getAllBorrowings() throws SQLException {
        return borrowingRecordDAO.selectAllBorrowings();
    }

    public BorrowingRecord getBorrowingById(int id) throws SQLException {
        return borrowingRecordDAO.selectBorrowing(id);
    }

    public void addBorrowing(BorrowingRecord borrowing) throws SQLException {
        borrowingRecordDAO.insertBorrowing(borrowing);
    }

    public void updateBorrowingStatus(int id, String status, String returnDate) throws SQLException {
        borrowingRecordDAO.updateBorrowingStatus(id, status, returnDate);
    }

    public void deleteBorrowing(int id) throws SQLException {
        borrowingRecordDAO.deleteBorrowing(id);
    }
}
