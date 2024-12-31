package controller;

import service.BookService;
import service.CategoryService;
import service.PublisherService;
import model.Book;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookController", urlPatterns = {"/books", "/books/add", "/books/edit", "/books/delete"})
public class BookController extends HttpServlet {
    private BookService bookService;
    private CategoryService categoryService;
    private PublisherService publisherService;

    @Override
    public void init() {
        bookService = new BookService();
        categoryService = new CategoryService();
        publisherService = new PublisherService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/books/add":
                    showAddForm(request, response);
                    break;
                case "/books/edit":
                    showEditForm(request, response);
                    break;
                case "/books/delete":
                    showDeleteForm(request, response);
                    break;
                default:
                    listBooks(request, response);
                    break;
            }
        } catch (SQLException | NumberFormatException ex) {
            handleException(request, response, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/books/add":
                    addBook(request, response);
                    break;
                case "/books/edit":
                    editBook(request, response);
                    break;
                case "/books/delete":
                    deleteBook(request, response);
                    break;
                default:
                    response.sendRedirect("books");
                    break;
            }
        } catch (SQLException | NumberFormatException ex) {
            handleException(request, response, ex);
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        try {
            List<Book> books = bookService.getAllBooks();
            if (books == null || books.isEmpty()) {
                request.setAttribute("message", "No books found");
            } else {
                request.setAttribute("books", books);
            }
            dispatcher = request.getRequestDispatcher("views/books/list.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error while listing books: " + e.getMessage());

            dispatcher.forward(request, response);
        }
    }


    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        request.setAttribute("categories", categoryService.getAllCategories());
        request.setAttribute("publishers", publisherService.getAllPublishers());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/books/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = parseId(request);
        Book book = bookService.getBookById(id);
        if (book == null) {
            request.setAttribute("errorMessage", "Book not found with ID: " + id);
            response.sendRedirect("books");
            return;
        }
        request.setAttribute("book", book);
        request.setAttribute("categories", categoryService.getAllCategories());
        request.setAttribute("publishers", publisherService.getAllPublishers());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/books/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = parseId(request);
        Book book = bookService.getBookById(id);
        if (book == null) {
            request.setAttribute("errorMessage", "Book not found with ID: " + id);
            response.sendRedirect("books");
            return;
        }
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/books/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String imagePath = request.getParameter("image"); // Assume file upload is handled elsewhere
        String status = request.getParameter("status");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int publisherId = Integer.parseInt(request.getParameter("publisherId"));

        Book newBook = new Book(0, name, description, imagePath, status, categoryId, publisherId);
        bookService.addBook(newBook);
        response.sendRedirect("books");
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = parseId(request);
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String imagePath = request.getParameter("image"); // Assume file upload is handled elsewhere
        String status = request.getParameter("status");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int publisherId = Integer.parseInt(request.getParameter("publisherId"));

        Book book = new Book(id, name, description, imagePath, status, categoryId, publisherId);
        bookService.updateBook(book);
        response.sendRedirect("books");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = parseId(request);
        bookService.deleteBook(id);
        response.sendRedirect("books");
    }

    private int parseId(HttpServletRequest request) {
        try {
            return Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID format.");
        }
    }

    private void handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) throws ServletException, IOException {
        ex.printStackTrace();
        request.setAttribute("errorMessage", ex.getMessage());
        RequestDispatcher dispatcher = request.getRequestDispatcher("error/error.jsp");
        dispatcher.forward(request, response);
    }
}
