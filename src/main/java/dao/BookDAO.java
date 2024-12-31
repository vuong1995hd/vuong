package dao;

import model.Book;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static final String INSERT_BOOK = "INSERT INTO books (name, description, image_path, status, category_id, publisher_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";
    private static final String UPDATE_BOOK = "UPDATE books SET name = ?, description = ?, image_path = ?, status = ?, category_id = ?, publisher_id = ? WHERE id = ?";

    /**
     * Insert a new book into the database
     */
    public void insertBook(Book book) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getDescription());
            preparedStatement.setString(3, book.getImagePath());
            preparedStatement.setString(4, book.getStatus());
            preparedStatement.setInt(5, book.getCategoryId());
            preparedStatement.setInt(6, book.getPublisherId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow exception to handle it in the calling code
        }
    }

    /**
     * Retrieve all books from the database
     */
    public List<Book> selectAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("image_path"),
                        rs.getString("status"),
                        rs.getInt("category_id"),
                        rs.getInt("publisher_id")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching books: " + e.getMessage());
            throw e;
        }
        return books;
    }


    /**
     * Retrieve a single book by its ID
     */
    public Book selectBook(int id) throws SQLException {
        Book book = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    book = new Book(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getString("image_path"),
                            rs.getString("status"),
                            rs.getInt("category_id"),
                            rs.getInt("publisher_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow exception to handle it in the calling code
        }
        return book;
    }

    /**
     * Delete a book by its ID
     */
    public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow exception to handle it in the calling code
        }
        return rowDeleted;
    }

    /**
     * Update a book in the database
     */
    public boolean updateBook(Book book) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getDescription());
            preparedStatement.setString(3, book.getImagePath());
            preparedStatement.setString(4, book.getStatus());
            preparedStatement.setInt(5, book.getCategoryId());
            preparedStatement.setInt(6, book.getPublisherId());
            preparedStatement.setInt(7, book.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow exception to handle it in the calling code
        }
        return rowUpdated;
    }
}
