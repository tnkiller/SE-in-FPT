
package Model.ve;

import Model.customer.Customer;
import Model.customer.ListCustomer;
import Model.employee.Employee;
import Model.film.FilmList;
import Model.phongVe.ListLichChieu;
import Model.phongVe.ListPhongChieu;
import View.AutoMenu;
import View.Validation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListVe {
    private ArrayList<Ve> tickets;
    private ListLichChieu listLichChieu;
    private ListPhongChieu listPhongChieu;
    private FilmList filmList;
    private ListCustomer listCustomer;
    private int nextTicketNumber = 1;
    public ListVe() throws ParseException {
        tickets = new ArrayList<>();
        listLichChieu = new ListLichChieu();
        listPhongChieu = new ListPhongChieu();
        filmList = new FilmList();
        ListCustomer ListCustomer = new ListCustomer();
        loadTicketData("ve.txt");    }


    // Đọc dữ liệu vé từ file
    private void loadTicketData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date daySaleTicket = dateFormat.parse(details[5]);
                    String maLoaiVe = details[0];
                    String codeTicket = details[3];
                    int nextNumber = Integer.parseInt(codeTicket.substring(2));
                    if (nextNumber >= nextTicketNumber) {
                        nextTicketNumber = nextNumber + 1;
                    }
                    tickets.add(new Ve(details[0], details[1], Long.parseLong(details[2]), details[3], Integer.parseInt(details[4]), daySaleTicket, new Customer(), new Employee()));
                }
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ListVe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Lưu dữ liệu vé vào file
    public void saveTicketData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ve.txt"))) {
            for (Ve ticket : tickets) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                bw.write(ticket.getMaLoaiVe() + "," + ticket.getTenLoaiVe() + "," + ticket.getDonGia() + "," + ticket.getCodeTicket() + "," + ticket.getNumberOfTicket() + "," + dateFormat.format(ticket.getDaySaleTicket()) + "," + ticket.getCustomer().getUserName() + "," + ticket.getEmployee().getUserName() + "\n");
            }
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ListVe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Thêm vé mới
    public void addNewTicket(Ve ticket) {
        tickets.add(ticket);
        saveTicketData();
    }
    private String generateUniqueTicketCode(String maLoaiVe) {
        String prefix = maLoaiVe.substring(0, 2).toUpperCase();
        String newTicketCode = prefix + String.format("%03d", nextTicketNumber);
        nextTicketNumber++;
        return newTicketCode;
    }
    // Cập nhật thông tin vé
    public void updateTicket(String codeTicket, Ve updatedTicket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getCodeTicket().equals(codeTicket)) {
                tickets.set(i, updatedTicket);
                saveTicketData();
                return;
            }
        }
        System.out.println("Ticket not found.");
    }

    // Xóa vé
    public void deleteTicket(String codeTicket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getCodeTicket().equals(codeTicket)) {
                tickets.remove(i);
                saveTicketData();
                System.out.println("Ticket has been deleted successfully.");
                return;
            }
        }
        System.out.println("Ticket not found.");
    }

    // Tìm kiếm vé
    public Ve searchTicket(String codeTicket) {
        for (Ve ticket : tickets) {
            if (ticket.getCodeTicket().equals(codeTicket)) {
                return ticket;
            }
        }
        return null;
    }

    // Hiển thị danh sách vé
    public void displayVe() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
        } else {
            System.out.println("Ticket List:");
            for (Ve ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    // Quản lý thông tin vé
    public void manageTicketInfo() throws ParseException {
//        boolean running = true;
//        while (running) {
            String[] options = {
                    "Add new numberOfTicket",
                    "Update numberOfTicket information",
                    "Delete numberOfTicket",
                    "Search for tickets","Back"
            };
            AutoMenu menu = new AutoMenu("Ticket information management", options) {
                @Override
                public void execute(int option) {
                    switch (option) {
                        case 1:
                            addNewTicket();
                            break;
                        case 2:
                            updateTicketInfo();
                            break;
                        case 3:
                            deleteTicket();
                            break;
                        case 4:
                            searchTicketByCode();
                            break;
                        case 5:
                            stop();
                            break;
                        default:
                            System.out.println("Invalid selection. Please try again..");
                            break;
                    }
                }
            };
            menu.run();
        }


    private void addNewTicket() {
        String maLoaiVe = Validation.checkInputString("Enter Ticket type code:(Start with s***) ");
        String tenLoaiVe = Validation.checkInputString("Enter Ticket type name: ");
        long donGia = Validation.checkInputInt("Enter price: ");
        String codeTicket = Validation.checkInputString("Enter Ticket code: ");
        int soVe = Validation.checkInputInt("Enter number of tickets: ");
        String daySaleTicketStr = Validation.checkInputString("Enter Ticket sale date (dd/MM/yyyy): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date daySaleTicket;
        try {
            daySaleTicket = dateFormat.parse(daySaleTicketStr);
        } catch (ParseException e) {
            System.out.println("Error entering numberOfTicket sale date: " + e.getMessage());
            return;
        }
        boolean ask=Validation.checkInputYN("Do you have member account (Y/N): ");
        if(ask){
            String customerUsername = Validation.checkInputString("Enter customer login name: ");
            Customer  customer;
            customer = ListCustomer.searchCustomer(customerUsername);
            if(customer!=null){
                System.out.println("Acount not exsit");
                Boolean createThanhVien= Validation.checkInputYN("Do you want to create member account ? (Y/N) :  ");
                if (createThanhVien){
                    listCustomer.addNewCustomer();
                    customer= listCustomer.getCustomers().getLast();
                    String employeeUsername = Validation.checkInputString("Enter staff login name: ");

                    Ve newTicket = new Ve(maLoaiVe, tenLoaiVe, donGia, codeTicket, soVe, daySaleTicket, new Customer(customer.getUserName()), new Employee(employeeUsername));
                    addNewTicket(newTicket);
                     int point = newTicket.countPrice()/10;
                     customer.setPoints(point);
                    System.out.println("New Ticket added successfully.");
                }else {
                String employeeUsername = Validation.checkInputString("Enter staff login name: ");

                Ve newTicket = new Ve(maLoaiVe, tenLoaiVe, donGia, codeTicket, soVe, daySaleTicket, new Customer("empty"), new Employee(employeeUsername));
                addNewTicket(newTicket);
                System.out.println("New Ticket added successfully.");
                }

            }else{

                String employeeUsername = Validation.checkInputString("Enter staff login name: ");

                Ve newTicket = new Ve(maLoaiVe, tenLoaiVe, donGia, codeTicket, soVe, daySaleTicket, new Customer(customer.getUserName()), new Employee(employeeUsername));
                addNewTicket(newTicket);
                int point = customer.getPoints()+( newTicket.countPrice()/10);
                customer.setPoints(point);
                System.out.println("New numberOfTicket added successfully.");

            }
        }

    }

    private void updateTicketInfo() {
        String codeTicket = Validation.checkInputString("Enter the numberOfTicket code to be updated: ");
        Ve ticket = searchTicket(codeTicket);
        if (ticket != null) {
            String newMaLoaiVe = Validation.checkInputString("Enter new numberOfTicket type code: ");
            String newTenLoaiVe = Validation.checkInputString("Enter new numberOfTicket type name: ");
            long newDonGia = Validation.checkInputInt("Enter new unit price: ");
            int newSoVe = Validation.checkInputInt("Enter new numberOfTicket quantity: ");
            String newDaySaleTicketStr = Validation.checkInputString("Enter new numberOfTicket sale date (dd/MM/yyyy): ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date newDaySaleTicket;
            try {
                newDaySaleTicket = dateFormat.parse(newDaySaleTicketStr);
            } catch (ParseException e) {
                System.out.println("Error entering new numberOfTicket sale date: " + e.getMessage());
                return;
            }
            String newCustomerUsername = Validation.checkInputString("Enter new customer login name: ");
            String newEmployeeUsername = Validation.checkInputString("Enter new staff login name: ");

            Ve updatedTicket = new Ve(newMaLoaiVe, newTenLoaiVe, newDonGia, codeTicket, newSoVe, newDaySaleTicket, new Customer(newCustomerUsername), new Employee(newEmployeeUsername));
            updateTicket(codeTicket, updatedTicket);
            System.out.println("Ticket information has been updated successfully.");
        } else {
            System.out.println("Ticket not found.");
        }
    }

    private void deleteTicket() {
        String codeTicket = Validation.checkInputString("Enter the numberOfTicket code to delete: ");
        deleteTicket(codeTicket);
    }

    private void searchTicketByCode() {
        String codeTicket = Validation.checkInputString("Enter the numberOfTicket code you are looking for: ");
        Ve ticket = searchTicket(codeTicket);
        if (ticket != null) {
            System.out.println("Ticket information:");
            System.out.println(ticket);
        } else {
            System.out.println("Ticket not found.");
        }
    }

    // Tạo báo cáo doanh thu

    public void generateRevenueReport() {
        System.out.println("Revenue Report:");
        long totalRevenue = 0;
        for (Ve ticket : tickets) {
            totalRevenue += ticket.getDonGia() * ticket.getNumberOfTicket();
        }
        System.out.println("Total Revenue: " + totalRevenue);
    }

    // Tạo báo cáo chi phí
    public void generateExpenseReport() {
        System.out.println("Expense Report:");
        // Tính toán và hiển thị các khoản chi phí (ví dụ: chi phí nhân công, chi phí vận hành, ...)
    }
    public ArrayList<Ve> getTicketsByCustomer(Customer customer) {
        ArrayList<Ve> customerTickets = new ArrayList<>();
        for (Ve ticket : tickets) {
            if (ticket.getCustomer().getUserName().equals(customer.getUserName())) {
                customerTickets.add(ticket);
            }
        }
        return customerTickets;
    }
    public void viewTolTalpricePurchasedTickets(Customer currentCustomer) {
        ArrayList<Ve> purchasedTickets = getTicketsByCustomer(currentCustomer);
        if (purchasedTickets.isEmpty()) {
            System.out.println("No purchased tickets found for this customer.");
        } else {
            System.out.println("Purchased Tickets:");
            for (Ve ticket : purchasedTickets) {
                ThongTinVe ticketInfo = new ThongTinVe(ticket, listPhongChieu.searchPhongChieu(ticket.getCodeTicket()), filmList.searchFilmById(ticket.getMaLoaiVe()), listLichChieu.searchLichChieu(ticket.getCodeTicket()));
                System.out.println(ticketInfo);
            }
        }
    }
    public void viewPurchasedTickets(Customer currentCustomer) {
        ArrayList<Ve> purchasedTickets = getTicketsByCustomer(currentCustomer);
        if (purchasedTickets.isEmpty()) {
            System.out.println("No purchased tickets found for this customer.");
        } else {
            System.out.println("Purchased Tickets:");
            for (Ve ticket : purchasedTickets) {
                ThongTinVe ticketInfo = new ThongTinVe(ticket, listPhongChieu.searchPhongChieu(ticket.getCodeTicket()), filmList.searchFilmById(ticket.getMaLoaiVe()), listLichChieu.searchLichChieu(ticket.getCodeTicket()));
                System.out.println(ticketInfo);
            }
        }
    }
}
