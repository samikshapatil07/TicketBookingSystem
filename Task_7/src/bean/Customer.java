package bean;

public class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer() {}

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void displayCustomerDetails() {
        System.out.println("Customer: " + name + ", Email: " + email + ", Phone: " + phone);
    }
}
