package model;

public class Book {
    private int id;
    private String name;
    private String description;
    private String imagePath;
    private String status;
    private int categoryId;
    private int publisherId;

    public Book() {
    }

    public Book(int id, String name, String description, String imagePath, String status, int categoryId, int publisherId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.status = status;
        this.categoryId = categoryId;
        this.publisherId = publisherId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
}
