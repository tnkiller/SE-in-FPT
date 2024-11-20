package Model.ve;

import Model.customer.Customer;
import Model.employee.Employee;

import java.util.Date;

public class Ve extends LoaiVe   {
    Customer customer ;
    Employee employee;
    protected String codeTicket;
    protected int numberOfTicket;
    protected Date daySaleTicket;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Ve(String maLoaiVe, String tenLoaiVe, long donGia, String codeTicket, int ticket, Date daySaleTicket, Customer customer, Employee employee) {
        super(maLoaiVe, tenLoaiVe, donGia);
        this.customer = new Customer();
        this.employee = new Employee();
        this.codeTicket = codeTicket;
        this.numberOfTicket = ticket;
        this.daySaleTicket = daySaleTicket;
    }

//    public Ve( String codeTicket, int numberOfTicket, Date daySaleTicket) {
//        this.customer = new Customer();
//        this.employee = new Employee();
//        this.codeTicket = codeTicket;
//        this.numberOfTicket = numberOfTicket;
//        this.daySaleTicket = daySaleTicket;
//    }

    public Ve() {
    }

    public String getCodeTicket() {
        return codeTicket;
    }

    public void setCodeTicket(String codeTicket) {
        this.codeTicket = codeTicket;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }

    public void setNumberOfTicket(int numberOfTicket) {
        this.numberOfTicket = numberOfTicket;
    }

    public Date getDaySaleTicket() {
        return daySaleTicket;
    }

    public void setDaySaleTicket(Date daySaleTicket) {
        this.daySaleTicket = daySaleTicket;
    }
    public int countPrice() {
        System.out.println("Revenue Report:");
        int totalRevenue = 0;

            totalRevenue += (int) (getDonGia() * getNumberOfTicket());

        return totalRevenue;
    }
}
