package Model.ve;

import Model.customer.Customer;
import Model.employee.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ve extends LoaiVe {

    Customer customer;
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

    public Ve(String maLoaiVe, String tenLoaiVe, long donGia, String codeTicket, int ticket, Date daySaleTicket, Customer customer, Employee employee) throws ParseException {
        super(maLoaiVe, tenLoaiVe, donGia);
        this.customer = customer;
        this.employee = employee;
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

    @Override
    public long getDonGia() {
        return super.getDonGia();
    }

    public void setDaySaleTicket(Date daySaleTicket) {
        this.daySaleTicket = daySaleTicket;
    }

    public int countPrice() {
        int totalRevenue = 0;

        totalRevenue += (int) (super.donGia * getNumberOfTicket());

        return totalRevenue;
    }

    @Override
    public String toString() {
        String header = String.format(
                "| %-15s | %-15s | %-10s | %-15s | %-10s | %-15s | %-15s | %-15s |\n",
                "Ticket Code", "Ticket Name", "Price", "Ticket ID", "Quantity", "Sale Date", "Customer", "Employee"
        );

        String separator = new String(new char[header.length()]).replace("\0", "-");

        String row = String.format(
                "| %-15s | %-15s | %-10d | %-15s | %-10d | %-15s | %-15s | %-15s |",
                getMaLoaiVe(), getTenLoaiVe(), getDonGia() * getNumberOfTicket(), getCodeTicket(), getNumberOfTicket(),
                new SimpleDateFormat("dd/MM/YYYY").format(getDaySaleTicket()), customer.getUserName(), employee.getUserName()
        );

        return row + "\n" + separator;
    }

}
