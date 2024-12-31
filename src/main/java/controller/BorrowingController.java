package controller;

import service.BorrowingService;
import service.CustomerService;
import service.BookService;
import model.BorrowingRecord;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BorrowingController", urlPatterns = {"/borrowings", "/borrowings/add", "/borrowings/edit", "/borrowings/delete"})
public class BorrowingController extends HttpServlet {
    private BorrowingService borrowingService;
    private CustomerService customerService;
    private BookService bookService;

    @Override
    public void init() {
        borrowingService = new BorrowingService();
        customerService = new CustomerService();
        bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/borrowings/add":
                    showAddForm(request, response);
                    break;
                case "/borrowings/edit":
                    showEditForm(request, response);
                    break;
                case "/borrowings/delete":
                    showDeleteForm(request, response);
                    break;
                default:
                    listBorrowings(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/borrowings/add":
                    addBorrowing(request, response);
                    break;
                case "/borrowings/edit":
                    editBorrowing(request, response);
                    break;
                case "/borrowings/delete":
                    deleteBorrowing(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBorrowings(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<BorrowingRecord> borrowings = borrowingService.getAllBorrowings();
        request.setAttribute("borrowings", borrowings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/borrowings/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        request.setAttribute("customers", customerService.getAllCustomers());
        request.setAttribute("books", bookService.getAllBooks());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/borrowings/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BorrowingRecord borrowing = borrowingService.getBorrowingById(id);
        request.setAttribute("borrowing", borrowing);
        request.setAttribute("customers", customerService.getAllCustomers());
        request.setAttribute("books", bookService.getAllBooks());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/borrowings/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BorrowingRecord borrowing = borrowingService.getBorrowingById(id);
        request.setAttribute("borrowing", borrowing);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/borrowings/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void addBorrowing(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String borrowDate = request.getParameter("borrowDate");
        String status = "borrowing";

        BorrowingRecord newBorrowing = new BorrowingRecord(0, customerId, bookId, borrowDate, null, status);
        borrowingService.addBorrowing(newBorrowing);
        response.sendRedirect("borrowings");
    }

    private void editBorrowing(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        String returnDate = request.getParameter("returnDate");

        borrowingService.updateBorrowingStatus(id, status, returnDate);
        response.sendRedirect("borrowings");
    }

    private void deleteBorrowing(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        borrowingService.deleteBorrowing(id);
        response.sendRedirect("borrowings");
    }
}
