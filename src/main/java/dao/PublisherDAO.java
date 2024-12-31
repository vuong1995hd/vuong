package dao;

import model.Publisher;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO {
    private static final String SELECT_ALL = "SELECT * FROM publishers";
    private static final String SELECT_BY_ID = "SELECT * FROM publishers WHERE id = ?";
    private static final String INSERT = "INSERT INTO publishers (name) VALUES (?)";
    private static final String UPDATE = "UPDATE publishers SET name = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM publishers WHERE id = ?";

    public List<Publisher> selectAllPublishers() throws SQLException {
        List<Publisher> publishers = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                publishers.add(new Publisher(id, name));
            }
        }
        return publishers;
    }

    public Publisher selectPublisher(int id) throws SQLException {
        Publisher publisher = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                publisher = new Publisher(id, name);
            }
        }
        return publisher;
    }

    public void insertPublisher(Publisher publisher) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, publisher.getName());
            preparedStatement.executeUpdate();
        }
    }

    public void updatePublisher(Publisher publisher) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, publisher.getName());
            preparedStatement.setInt(2, publisher.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deletePublisher(int id) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
