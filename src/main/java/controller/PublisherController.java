package controller;

import model.Publisher;
import service.PublisherService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PublisherController", urlPatterns = {"/publishers", "/publishers/add", "/publishers/edit", "/publishers/delete"})
public class PublisherController extends HttpServlet {
    private PublisherService publisherService;

    @Override
    public void init() {
        publisherService = new PublisherService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/publishers/add":
                    showAddForm(request, response);
                    break;
                case "/publishers/edit":
                    showEditForm(request, response);
                    break;
                case "/publishers/delete":
                    showDeleteForm(request, response);
                    break;
                default:
                    listPublishers(request, response);
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
                case "/publishers/add":
                    addPublisher(request, response);
                    break;
                case "/publishers/edit":
                    editPublisher(request, response);
                    break;
                case "/publishers/delete":
                    deletePublisher(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPublishers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Publisher> publishers = publisherService.getAllPublishers();
        request.setAttribute("publishers", publishers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/publishers/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/publishers/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Publisher publisher = publisherService.getPublisherById(id);
        request.setAttribute("publisher", publisher);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/publishers/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Publisher publisher = publisherService.getPublisherById(id);
        request.setAttribute("publisher", publisher);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/publishers/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void addPublisher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        Publisher publisher = new Publisher(0, name);
        publisherService.addPublisher(publisher);
        response.sendRedirect("publishers");
    }

    private void editPublisher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Publisher publisher = new Publisher(id, name);
        publisherService.updatePublisher(publisher);
        response.sendRedirect("publishers");
    }

    private void deletePublisher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        publisherService.deletePublisher(id);
        response.sendRedirect("publishers");
    }
}
