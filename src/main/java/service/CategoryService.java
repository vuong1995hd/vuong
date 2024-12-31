package service;

import dao.CategoryDAO;
import model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService() {
        categoryDAO = new CategoryDAO();
    }

    public List<Category> getAllCategories() throws SQLException {
        return categoryDAO.selectAllCategories();
    }

    public Category getCategoryById(int id) throws SQLException {
        return categoryDAO.selectCategory(id);
    }

    public void addCategory(Category category) throws SQLException {
        categoryDAO.insertCategory(category);
    }

    public void updateCategory(Category category) throws SQLException {
        categoryDAO.updateCategory(category);
    }

    public void deleteCategory(int id) throws SQLException {
        categoryDAO.deleteCategory(id);
    }
}
