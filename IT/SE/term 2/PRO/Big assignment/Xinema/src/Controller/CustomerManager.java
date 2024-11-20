package Controller;

import Model.customer.Customer;
import Model.customer.ListCustomer;
import Model.employee.Employee;
import Model.film.Film;
import Model.film.FilmList;
import Model.phongVe.Lichchieu;
import Model.phongVe.ListLichChieu;
import Model.phongVe.ListPhongChieu;
import Model.phongVe.PhongChieu;
import Model.ve.ListVe;
import Model.ve.ThongTinVe;
import Model.ve.Ve;
import View.AutoMenu;
import View.Validation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class CustomerManager {
    private ListCustomer listCustomer;
    private FilmList filmList;
    private ListLichChieu listLichChieu;
    private ListPhongChieu listPhongChieu;
    private ListVe listVe;
    private Customer currentCustomer;

    public CustomerManager() throws ParseException {
        listCustomer = new ListCustomer();
        filmList = new FilmList();
        listLichChieu = new ListLichChieu();
        listPhongChieu = new ListPhongChieu();
        listVe = new ListVe();
    }

    public void run() throws ParseException {
//        boolean running = true;
//        while (running) {
            String[] options = {
                    "Book Ticket",
                    "Account Information","Exit"

            };
            AutoMenu menu = new AutoMenu("Customer Menu", options) {
                @Override
                public void execute(int option) throws ParseException {
                    switch (option) {
                        case 1:
                            bookTicket();
                            break;
                        case 2:
                            viewAccountInfo();
                            break;
                        case 3:
                            new Login().loginRun();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid selection. Please try again.");
                            break;
                    }
                }
            };
            menu.run();
        }


    private void bookTicket() throws ParseException {
//        boolean bookingTicket = true;
//        while (bookingTicket) {
            String[] options = {
                    "Display movies ",
                    "Select movie",
                    "Back"
            };
            AutoMenu menu = new AutoMenu("Book Ticket", options) {
                @Override
                public void execute(int option) throws ParseException {
                    switch (option) {
                        case 1->
                             filmList.runforCus();

                        case 2->
                            selectMovie();

                        case 3->
                            stop();

                        default->
                            System.out.println("Invalid selection. Please try again.");

                    }
                }
            };
            menu.run();
        }



//    private void displayMoviesFromToday() {
//        Date today = new Date();
//        filmList.displayFilmsByReleaseDate(today);
//    }

//    private void displayMoviesByGenre() {
//        filmList.displayFilmsByGenre();
//    }
//
//    private void displayMoviesByFormat() {
//        filmList.displayFilmsByFormat();
//    }
//
//    private void displayMoviesByDate() {
//        Date date = Validation.checkInputDate("Enter the date (dd/MM/yyyy):");
//        filmList.displayFilmsByReleaseDate(date);
//    }

    private void selectMovie() {
        String filmId = Validation.checkInputString("Enter the film ID:");
        Film selectedFilm = filmList.searchFilmById(filmId);
        if (selectedFilm != null) {
            String showTimeCode = Validation.checkInputString("Enter the showtime code:");
            Lichchieu selectedShowtime = listLichChieu.searchLichChieu(showTimeCode);
            if (selectedShowtime != null) {
                PhongChieu selectedRoom = listPhongChieu.searchPhongChieu(selectedShowtime.getSoPhongChieu());
                if (selectedRoom != null) {
                    confirmTicketBooking(selectedFilm, selectedShowtime, selectedRoom);
                } else {
                    System.out.println("Screening room not found.");
                }
            } else {
                System.out.println("Showtime not found.");
            }
        } else {
            System.out.println("Film not found.");
        }
    }

    private void confirmTicketBooking(Film film, Lichchieu showtime, PhongChieu room) {
        String loaighe = Validation.checkInputloaighe("please chossen Couple or single : ");
        System.out.println("Ticket Information:");
        System.out.println("Film: " + film.getTitle());
        System.out.println("Showtime: " + showtime.getNgayChieu() + " - " + showtime.getCaChieu());
        System.out.println("Screening Room: " + room.getTenPhong());


        boolean confirmBooking = Validation.checkInputYN("Do you want to book this numberOfTicket? (Y/N)");
        if (confirmBooking) {
            Ve newTicket = new Ve("T001", loaighe+"Ticket", showtime.getTienve(), "ST001", 1, new Date(), currentCustomer, new Employee("SV123456"));
            ThongTinVe ticketInfo = new ThongTinVe(newTicket, room, film, showtime);
            listVe.addNewTicket(newTicket);
            System.out.println("Ticket booked successfully!");
            System.out.println(ticketInfo);
        } else {
            System.out.println("Booking cancelled.");
        }
    }

    private void viewAccountInfo() throws ParseException {
        boolean viewingAccountInfo = true;
        while (viewingAccountInfo) {
            String[] options = {
                    "View personal information",
                    "Change password",
                    "View purchased tickets",
                    "Logout"
            };
            AutoMenu menu = new AutoMenu("Account Information", options) {
                @Override
                public void execute(int option) throws ParseException {
                    switch (option) {
                        case 1:
                            displayPersonalInfo();
                            break;
                        case 2:
                            changePassword();
                            break;
                        case 3:
                            viewPurchasedTickets();
                            break;
                        case 4:
                            new Login().loginRun();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid selection. Please try again.");
                            break;
                    }
                }
            };
            menu.run();
        }
    }

    private void displayPersonalInfo() {
        System.out.println("Personal Information:");
        System.out.println("Name: " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName());
        System.out.println("Membership Level: " + currentCustomer.getCustomerLevel());
        System.out.println("Total Spending: " + viewTolTalSpendingPurchasedTickets());
        System.out.println("Reward Points: " + currentCustomer.getPoints());
        System.out.println("Points needed for next level: " + (10000 - currentCustomer.getPoints()));
    }

    public int viewTolTalSpendingPurchasedTickets() {
        int totalSpending = 0;
        ArrayList<Ve> purchasedTickets = listVe.getTicketsByCustomer(currentCustomer);
        for (Ve ve : purchasedTickets) {
            totalSpending += ve.countPrice();
        }
        return totalSpending;
    }


    private void changePassword() {
        String newPassword = Validation.checkInputPassword("Enter new password:");
        currentCustomer.setPassword(newPassword);
        listCustomer.updateCustomer(currentCustomer.getUserName(), currentCustomer);
        System.out.println("Password updated successfully.");
    }

    private void viewPurchasedTickets() {
        listVe.viewPurchasedTickets(currentCustomer);
    }

    public static void main(String[] args) throws ParseException {
        new CustomerManager().run();
    }
}
