package entity;

public class Customer {
    private int id;
    private String customerName;
    private String phoneNumber;

    public Customer(int id, String customerName, String phoneNumber) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
