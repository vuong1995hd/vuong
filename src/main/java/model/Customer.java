package model;

public class Customer {
    private int id;
    private String name;
    private String code;
    private String schoolClass;
    private String address;
    private String birthDate;

    public Customer() {
    }

    public Customer(int id, String name, String code, String schoolClass, String address, String birthDate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.schoolClass = schoolClass;
        this.address = address;
        this.birthDate = birthDate;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
