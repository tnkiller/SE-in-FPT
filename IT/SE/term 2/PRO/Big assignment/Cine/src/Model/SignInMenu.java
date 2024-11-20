package Model;

import Controller.*;
import Model.customer.*;
import Model.employee.*;
import Model.film.*;
import Model.phongVe.*;
import Model.ve.*;
import View.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class SignInMenu {
    
    private ListCustomer listCustomer;
    private FilmList filmList;
    private ListLichChieu listLichChieu;
    private ListPhongChieu listPhongChieu;
    private ListVe listVe;
    private Customer currentCustomer;
    
    public SignInMenu(Customer i) throws ParseException {
        listCustomer = new ListCustomer();
        filmList = new FilmList();
        listLichChieu = new ListLichChieu();
        listPhongChieu = new ListPhongChieu();
        listVe = new ListVe();
        currentCustomer = i;
    }
    
    public void run() throws ParseException {
        String[] choice = {
            "Book ticket",
            "About account information",
            "Log out"
        };
        
        Menu subMenu = new Menu(" ---Welcome back my buddy---", choice) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                        bookTicket();
                    case 2 ->
                        viewAccountInfo();
                    case 3 ->
                        new LoginForCustomer().run();
                }
            }
        };
        subMenu.run();
    }
    
    private void bookTicket() throws ParseException {
//        boolean bookingTicket = true;
//        while (bookingTicket) {
        String[] options = {
            "Display movies ",
            "Select movie",
            "Back"
        };
        Menu menu = new Menu("Book Ticket", options) {
            @Override
            public void execute(int option) throws ParseException {
                switch (option) {
                    case 1 ->
                        listLichChieu.displayLichChieu();
                    case 2 -> {
                        listLichChieu.displayLichChieu();
                        selectMovie();
                    }
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
    private void selectMovie() throws ParseException {
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
    
    private void confirmTicketBooking(Film film, Lichchieu showtime, PhongChieu room) throws ParseException {
        String loaiVe = Validation.checkInputloaighe("Couple, VIP or Standard : ");
        int soLuongVe = Validation.checkInputInt("Enter number of ticket: ");
        System.out.println("Ticket Information:");
        System.out.println("Film: " + film.getTitle());
        System.out.println("Showtime: " + showtime.getNgayChieu() + " - " + showtime.getCaChieu());
        System.out.println("Screening Room: " + room.getTenPhong());
        
        boolean confirmBooking = Validation.checkInputYN("Do you want to book this numberOfTicket? (Y/N)");
        if (confirmBooking) {
            Ve newTicket = new Ve("##-##", loaiVe, 0, "123", soLuongVe, new Date(), currentCustomer, new Employee("ONLINE"));
            ThongTinVe ticketInfo = new ThongTinVe(newTicket, room, film, showtime);
            listVe.addNewTicket(newTicket);
            System.out.println("Ticket booked successfully!");
            new ListVe().saveDataOnline();
            System.out.println(ticketInfo);
        } else {
            System.out.println("Booking cancelled.");
        }
    }
    
    private void viewAccountInfo() throws ParseException {
        String[] options = {
            "View personal information",
            "Change password",
            "View purchased tickets",
            "Back"
        };
        Menu menu = new Menu("Account Information", options) {
            @Override
            public void execute(int option) throws ParseException {
                switch (option) {
                    case 1 ->
                        displayPersonalInfo();
                    case 2 ->
                        changePassword();
                    case 3 ->
                        viewPurchasedTickets();
                    case 4 -> {
                        System.out.println("Backed!");
                    }
                }
            }
        };
        menu.run();
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
    
}
