package Controller;

import Model.customer.ListCustomer;
import Model.employee.ListEmployee;
import Model.film.FilmList;
import Model.phongVe.ListPhongChieu;
import Model.phongVe.ListLichChieu;
import Model.ve.ListVe;
import Model.ve.LoaiVe;
import View.AutoMenu;

import java.text.ParseException;

/**
 *
 * @author Staff
 */
public class Staff_CinemaManage {
    private ListCustomer listCustomer;
    private ListEmployee listEmployee;
    private FilmList filmList;
    private ListPhongChieu listPhongChieu;
    private ListLichChieu listLichChieu;
    private ListVe listVe;
    private LoaiVe loaiVe;

    public Staff_CinemaManage() throws ParseException {
        listCustomer = new ListCustomer();
        listEmployee = new ListEmployee();
        filmList = new FilmList();
        listPhongChieu = new ListPhongChieu();
        listLichChieu = new ListLichChieu();
        listVe = new ListVe();
        loaiVe = new LoaiVe();
    }

    public void run() throws ParseException {
//        boolean running = true;
//        while (running) {
            String[] options = {
                    "Film management",
                    "Customer management",
                    "Room management",
                    "Session management",
                    "Ticket management","Exit"
            };
            AutoMenu menu = new AutoMenu("---Manager's for Staff---", options) {
                @Override
                public void execute(int option) throws ParseException {
                    switch (option) {
                        case 1:
                            filmList.runMain();
                            break;
                        case 2:
                            listCustomer.manageCustomerInfo();
                            break;
                        case 3:
                            listPhongChieu.staffPhongChieus();
                            break;
                        case 4:
                            listLichChieu.staffLichChieuInfo();
                            break;
                        case 5:
                            listVe.manageTicketInfo();
                            break;
                        case 6:
                            System.out.println("See you soon...");
                            new LoginForEmp().loginRun();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid selection. Please try again..");
                            break;
                    }
                }
            };
            menu.run();
        }


    private void generateReports() {
        listVe.generateRevenueReport();
//        listVe.generateExpenseReport();
//        filmList.generateProductReport();
    }

    public static void main(String[] args) throws ParseException {
        new Staff_CinemaManage().run();
    }
}
