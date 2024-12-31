package service;

import dao.PublisherDAO;
import model.Publisher;

import java.sql.SQLException;
import java.util.List;

public class PublisherService {
    private PublisherDAO publisherDAO;

    public PublisherService() {
        publisherDAO = new PublisherDAO();
    }

    public List<Publisher> getAllPublishers() throws SQLException {
        return publisherDAO.selectAllPublishers();
    }

    public Publisher getPublisherById(int id) throws SQLException {
        return publisherDAO.selectPublisher(id);
    }

    public void addPublisher(Publisher publisher) throws SQLException {
        publisherDAO.insertPublisher(publisher);
    }

    public void updatePublisher(Publisher publisher) throws SQLException {
        publisherDAO.updatePublisher(publisher);
    }

    public void deletePublisher(int id) throws SQLException {
        publisherDAO.deletePublisher(id);
    }
}
