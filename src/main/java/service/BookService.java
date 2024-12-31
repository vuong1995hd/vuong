package service;

import dao.BookDAO;
import model.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private final BookDAO bookDAO;

    // Constructor
    public BookService() {
        this.bookDAO = new BookDAO();
    }

    /**
     * Retrieve all books
     *
     * @return List of all books
     * @throws SQLException if a database access error occurs
     */
    public List<Book> getAllBooks() {
        try {
            return bookDAO.selectAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching all books", e);
        }
    }


    /**
     * Retrieve a book by its ID
     *
     * @param id Book ID
     * @return Book object or null if not found
     * @throws SQLException if a database access error occurs
     */
    public Book getBookById(int id) {
        try {
            return bookDAO.selectBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch book with ID: " + id, e);
        }
    }

    /**
     * Add a new book
     *
     * @param book Book object
     * @throws SQLException if a database access error occurs
     */
    public void addBook(Book book) {
        try {
            bookDAO.insertBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to add new book", e);
        }
    }

    /**
     * Update an existing book
     *
     * @param book Book object with updated data
     * @throws SQLException if a database access error occurs
     */
    public void updateBook(Book book) {
        try {
            bookDAO.updateBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update book with ID: " + book.getId(), e);
        }
    }

    /**
     * Delete a book by its ID
     *
     * @param id Book ID
     * @throws SQLException if a database access error occurs
     */
    public void deleteBook(int id) {
        try {
            bookDAO.deleteBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to delete book with ID: " + id, e);
        }
    }
}
