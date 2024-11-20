/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *1
 * 1
 *
 * @author ADMIN
 */
public class CinemaManage {
    private ListCustomer listCustomer;
    private ListEmployee listEmployee;
    private FilmList filmList;
    private ListPhongChieu listPhongChieu;
    private ListLichChieu listLichChieu;
    private ListVe listVe;
    private LoaiVe loaiVe;

    public CinemaManage() throws ParseException {
        listCustomer = new ListCustomer();
        listEmployee = new ListEmployee();
        filmList = new FilmList();
        listPhongChieu = new ListPhongChieu();
        listLichChieu = new ListLichChieu();
        listVe = new ListVe();
        loaiVe = new LoaiVe();
    }

    public void run() throws ParseException {
        String[] options = {
                "Manage Film",
                "Manage Customer",
                "Employee Manager",
                "Manage Cinema Room",
                "Manage Schedule",
                "Manage Ticket","Exit"
        };
        AutoMenu menu = new AutoMenu("Manager Cinema", options) {
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
                        listEmployee.manageEmployeeInfo();
                        break;
                    case 4:
                        listPhongChieu.managePhongChieuInfo();
                        break;
                    case 5:
                        listLichChieu.manageLichChieuInfo();
                        break;
                    case 6:
                        listVe.manageTicketInfo();
                        break;
                    case 7:
                        System.out.println("Exited...");
                        new LoginForEmp().loginRun();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        };
        menu.run();
    }

    private void generateReports() {
        listVe.generateRevenueReport();
    }

    public static void main(String[] args) throws ParseException {
        new CinemaManage().run();
    }
}
