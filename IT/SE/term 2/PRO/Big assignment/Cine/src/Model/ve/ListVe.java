
package Model.ve;

import Model.customer.Customer;
import Model.customer.ListCustomer;
import Model.employee.ListEmployee;
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
    private ListEmployee listEmployee;
    private ListCustomer listCustomer;
    private int nextTicketNumber = 1;
    public ListVe() throws ParseException {
        tickets = new ArrayList<>();
        listLichChieu = new ListLichChieu();
        listPhongChieu = new ListPhongChieu();
        filmList = new FilmList();
         listCustomer = new ListCustomer();
        listEmployee = new ListEmployee();
        loadTicketData("ve.txt");
    }



    // Đọc dữ liệu vé từ file
    private void loadTicketData(String fileName)
    {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 8) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date daySaleTicket = dateFormat.parse(details[5]);
                    String maLoaiVe = details[0];
                    String codeTicket = details[3];
                    int nextNumber = Integer.parseInt(codeTicket.substring(2));
                    if (nextNumber >= nextTicketNumber) {
                        nextTicketNumber = nextNumber + 1;
                    }
                    tickets.add(new Ve(details[0], details[1], Long.parseLong(details[2]), details[3], Integer.parseInt(details[4]), daySaleTicket, listCustomer != null ? listCustomer.searchCustomer1(details[6]) : null,listEmployee.searchEmployee(details[7])));

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
    
    //lưu dữ liệu người dùng đặt vé ONLINE
    public void saveDataOnline() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ve.txt"))) {
            for (Ve ticket : tickets) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                bw.write(ticket.getMaLoaiVe() + "," + ticket.getTenLoaiVe() + "," + ticket.getDonGia() + "," + ticket.getCodeTicket() + "," + ticket.getNumberOfTicket() + "," + dateFormat.format(ticket.getDaySaleTicket()) + "," + ticket.getCustomer().getUserName() + "," + "ONLINE from app" + "\n");
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
                    "Add new Ticket",
                    "Update Ticket information",
                    "Delete Ticket",
                    "Search tickets by code","List ticket","Back"
            };
            AutoMenu menu = new AutoMenu("Ticket information management", options) {
                @Override
                public void execute(int option) throws ParseException {
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
                        case 6:
                            stop();
                            break;
                        case 5 :
                            displayTickets();
                            break;
                        default
                                :
                            System.out.println("Invalid selection. Please try again..");
                            break;
                    }
                }
            };
            menu.run();
        }


    private void addNewTicket() throws ParseException {
        String maLoaiVe = Validation.checkInputString("Enter Ticket type code:(Start with S***) ");
        String tenLoaiVe = Validation.checkInputloaighe("Enter Ticket type name: ");
        int donGia=0;
        String codeTicket = Validation.checkInputString("Enter Ticket code: ");
        int soVe = Validation.checkInputInt("Enter number of tickets: ");
        String daySaleTicketStr = Validation.checkInputString("Enter Ticket sale date (dd/MM/yyyy): ");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date daySaleTicket;
        try {
            daySaleTicket = dateFormat.parse(daySaleTicketStr);
        } catch (ParseException e) {
            System.out.println("Error entering Ticket sale date: " + e.getMessage());
            return;
        }

        boolean hasMemberAccount = Validation.checkInputYN("Do you have a member account (Y/N): ");
        String employeeUsername = Validation.checkInputString("Enter staff login name: ");

        if (hasMemberAccount) {
            String customerUsername = Validation.checkInputString("Enter customer login name: ");
            Customer customer = ListCustomer.searchCustomer(customerUsername);

            if (customer == null) {
                System.out.println("Account does not exist.");
                boolean createMember = Validation.checkInputYN("Do you want to create a member account? (Y/N): ");

                if (createMember) {
                    listCustomer.addNewCustomer();
                    customer = listCustomer.getCustomers().getLast();
                    Ve newTicket = new Ve(maLoaiVe, tenLoaiVe, donGia, codeTicket, soVe, daySaleTicket, listCustomer.searchCustomer1(customer.getUserName()), listEmployee.searchEmployee(employeeUsername));

                    addNewTicket(newTicket);
                    int points = newTicket.countPrice() / 10;
                    customer.setPoints(points);
                    System.out.println("New ticket added successfully with member account.");
                } else {
                    Ve newTicket = new Ve(maLoaiVe, tenLoaiVe, donGia, codeTicket, soVe, daySaleTicket, listCustomer.searchCustomer1("empty"), listEmployee.searchEmployee(employeeUsername));
                    addNewTicket(newTicket);
                    System.out.println("New ticket added successfully without member account.");
                }
            } else {
                Ve newTicket = new Ve(maLoaiVe, tenLoaiVe, donGia, codeTicket, soVe, daySaleTicket, listCustomer.searchCustomer1(customer.getUserName()), listEmployee.searchEmployee(employeeUsername));
                addNewTicket(newTicket);

                int points = customer.getPoints() + (newTicket.countPrice() / 10);
                customer.setPoints(points);
                System.out.println("New ticket added successfully for existing member account.");
            }
        } else {
            Ve newTicket = new Ve(maLoaiVe, tenLoaiVe, donGia, codeTicket, soVe, daySaleTicket, new Customer("empty"), listEmployee.searchEmployee(employeeUsername));
            addNewTicket(newTicket);
            System.out.println("New ticket added successfully without member account.");
        }
    }


    private void updateTicketInfo() throws ParseException {
        String codeTicket = Validation.checkInputString("Enter the Ticket code to be updated: ");
        Ve ticket = searchTicket(codeTicket);
        if (ticket != null) {
            String newMaLoaiVe = Validation.checkInputString("Enter new Ticket type code: ");
            String newTenLoaiVe = Validation.checkInputloaighe("Enter new Ticket type name: ");
            long newDonGia = Validation.checkInputInt("Enter new unit price: ");
            int newSoVe = Validation.checkInputInt("Enter new Ticket quantity: ");
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
            if (listEmployee.searchEmployee(newEmployeeUsername)!=null && listCustomer.searchCustomer1(newCustomerUsername)!=null){
            Ve updatedTicket = new Ve(newMaLoaiVe, newTenLoaiVe, newDonGia, codeTicket, newSoVe, newDaySaleTicket, listCustomer.searchCustomer1(newCustomerUsername), listEmployee.searchEmployee(newEmployeeUsername));
            updateTicket(codeTicket, updatedTicket);
            System.out.println("Ticket information has been updated successfully.");
            } else System.out.println("Ticket information hasn't  updated .");
        } else {
            System.out.println("Ticket not found.");
        }
    }

    private void deleteTicket() {
        String codeTicket = Validation.checkInputString("Enter the Ticket code to delete: ");
        deleteTicket(codeTicket);
    }

    private void searchTicketByCode() {
        String codeTicket = Validation.checkInputString("Enter the Ticket code you are looking for: ");
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
//    public void generateExpenseReport() {
//        System.out.println("Expense Report:");
//        // Tính toán và hiển thị các khoản chi phí (ví dụ: chi phí nhân công, chi phí vận hành, ...)
//    }
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
    public void displayTickets() {
        loadTicketData("ve.txt");
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
        } else {
            String header = String.format(
                    "| %-15s | %-15s | %-10s | %-15s | %-10s | %-15s | %-15s | %-15s |\n",
                    "Ticket Code", "Ticket Name", "Price", "Ticket ID", "Quantity", "Sale Date", "Customer", "Employee"
            );

            String separator = new String(new char[header.length()]).replace("\0", "-") + "\n";
            System.out.println(separator);
            System.out.println(header);
            System.out.println(separator);
            for (Ve ticket : tickets) {
                System.out.println(ticket);
            }

        }
    }
}
