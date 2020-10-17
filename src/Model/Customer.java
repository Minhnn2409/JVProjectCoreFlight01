package Model;

public class Customer {
    private String customerName;
    private String gender;
    private int age;
    private String customerEmail;
    private String phoneNumber;
    private String nationality;
    private int customerNumber;
    private String customerAddress;

    public Customer() {
    }

    public Customer(String customerName, String gender, int age, String customerEmail, String phoneNumber, String nationality, int customerNumber, String customerAddress) {
        this.customerName = customerName;
        this.gender = gender;
        this.age = age;
        this.customerEmail = customerEmail;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.customerNumber = customerNumber;
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
