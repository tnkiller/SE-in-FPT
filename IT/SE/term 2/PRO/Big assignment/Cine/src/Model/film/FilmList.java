package Model.film;

import View.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilmList {

    private ArrayList<Film> films;

    /*
    ----------------------------------------------------------------------------------------------------
     */

    public FilmList() throws ParseException {
        films = new ArrayList<>();
        loadData("movies.txt");
    }

    //    public void filmList() throws ParseException {
//        films = new ArrayList<>();
//        loadData("movies.txt"); // Đọc dữ liệu phim từ file
//    }
    public void runMain() throws ParseException {
        String[] mc = {
                "Display films",
                "Search film",
                "Add films",
                "Update title",
                "Exit"
        };

        AutoMenu au = new AutoMenu("", mc) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                            runFilmDisplayMenu();
                    case 2 ->
                            searchFilm();
                    case 3 ->
                            addNewFilm();
                    case 4 ->
                            updateFilmTitle();
                    case 5 ->
                            stop();
                    default -> {
                        System.out.println("Try again...");
                    }
                }
            }
        };
        au.run();
    }
    public void runforCus() throws ParseException {
        String[] mc = {
            "Display films",
            "Search film",
            "Exit"
        };
        
        AutoMenu au = new AutoMenu("", mc) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                        runFilmDisplayMenu();
                    case 2 ->
                        searchFilm();
                    case 3 ->
                        stop();
                    default -> {
                        System.out.println("Try again...");
                    }
                }
            }
        };
        au.run();
    }
    
    public void runforEmp() throws ParseException {
        String[] mc = {
                "Display films",
                "Search film",
                "Exit"
        };

        AutoMenu au = new AutoMenu("", mc) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                            runFilmDisplayMenu();
                    case 2 ->
                            searchFilm();
                    case 3 ->
                            stop();
                    default -> {
                        System.out.println("Try again...");
                    }
                }
            }
        };
        au.run();
    }

    // Hàm đọc dữ liệu phim từ file
    public void loadData(String fileName) throws ParseException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 6) {
                    films.add(new Film(details[0], details[1], details[2], details[3],
                            MovieFormat.valueOf(details[4]), GenreFilm.valueOf(details[5])));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FilmList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Hàm lưu dữ liệu phim vào file
    public void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("movies.txt"))) {
            for (Film film : films) {
                bw.write(film.getIdFilm() + ","
                        + film.getTitle() + ","
                        + film.getProducer() + ","
                        + film.getReleaseDate() + ","
                        + film.getDangFilm().name() + "," // Ghi tên enum cho dangFilm
                        + film.getTheLoaiFilm().name() + "\n");  // Ghi tên enum cho theLoaiFilm
            }
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(FilmList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Hàm thêm phim mới
    public void addNewFilm() throws ParseException {
        String id;
        while (true) {
            id = Validation.checkInputString("Enter Film ID: ");
            id = Validation.formatFilmId(id);
            if (id != null) {
                break; // ID hợp lệ, tiếp tục
            }
        }

        String title = Validation.checkInputString("Enter Film Title: ");
        String producer = Validation.checkInputString("Enter Producer: ");
        String releaseDate = Validation.checkInputString("Enter Release Date: ");

        // Lấy thông tin cho dangFilm
        MovieFormat dangFilm = chooseDangFilm();
        // Lấy thông tin cho theLoaiFilm
        GenreFilm theLoaiFilm = chooseTheLoaiFilm();

        var newFilm = new Film(id, title, producer, releaseDate, dangFilm, theLoaiFilm);
        films.add(newFilm);
        System.out.println("Film added successfully!");

        saveData();  // Lưu phim mới vào file
    }

    // Phương thức để cho phép người dùng chọn dangFilm
    private MovieFormat chooseDangFilm() {
        System.out.println("Select Film Format:");
        for (int i = 0; i < MovieFormat.values().length; i++) {
            System.out.println((i + 1) + ". " + MovieFormat.values()[i].getDescription());
        }
        int choice;
        while (true) {
            choice = Integer.parseInt(Validation.checkInputString("Enter your choice (number): "));
            if (choice > 0 && choice <= MovieFormat.values().length) {
                return MovieFormat.values()[choice - 1]; // Trả về giá trị được chọn
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }

    // Phương thức để cho phép người dùng chọn theLoaiFilm
    private GenreFilm chooseTheLoaiFilm() {
        System.out.println("Select Film Genre:");
        for (int i = 0; i < GenreFilm.values().length; i++) {
            System.out.println((i + 1) + ". " + GenreFilm.values()[i].getDescription());
        }
        int choice;
        while (true) {
            choice = Integer.parseInt(Validation.checkInputString("Enter your choice (number): "));
            if (choice > 0 && choice <= GenreFilm.values().length) {
                return GenreFilm.values()[choice - 1]; // Trả về giá trị được chọn
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }

    // Hàm cập nhật tiêu đề phim
    public void updateFilmTitle() {
        String id;
        while (true) {
            id = Validation.checkInputString("Enter Film ID to update: ");
            id = Validation.formatFilmId(id);
            if (id != null) {
                break; // ID hợp lệ, tiếp tục
            }
        }

        for (Film film : films) {
            if (film.getIdFilm().equals(id)) {
                String newTitle = Validation.checkInputString("Enter new title: ");
                film.setTitle(newTitle);
                System.out.println("Film title updated successfully!");
                saveData();  // Lưu thay đổi vào file
                return;
            }
        }
        System.out.println("Film not found.");
    }

    // Tạo AutoMenu để tìm kiếm phim
    public void searchFilm() throws ParseException {
        String[] searchOptions = {
                "Search by Film ID",
                "Search by Film Title",
                "Search by Producer",
                "Back"
        };
        AutoMenu searchMenu = new AutoMenu("Select search option:", searchOptions) {
            @Override
            public void execute(int option) {
                switch (option) {
                    case 1 ->
                            searchById();
                    case 2 ->
                            searchByTitle();
                    case 3 ->
                            searchByProducer();
                    case 4 -> {
                        System.out.println("Returning to main menu...");
                        stop();

                    }
                    default ->
                            System.out.println("Invalid option! Try again.");
                }
            }
        };
        searchMenu.run();
    }

    // Tìm kiếm phim theo ID
    private void searchById() {
        String id;
        while (true) {
            id = Validation.checkInputString("Enter Film ID: ");
            id = Validation.formatFilmId(id);
            if (id != null) {
                break; // ID hợp lệ, tiếp tục
            }
        }

        for (Film film : films) {
            if (film.getIdFilm().equals(id)) {
                System.out.println("Film found: " + film);
                return;
            }
        }
        System.out.println("Film not found.");
    }

    //search theo id co doi tuong truyen vao
    public Film searchFilmById(String id) {
        for (Film film : films) {
            if (film.getIdFilm().equals(id)) {
                return film;
            }
        }
        return null;
    }

    // Tìm kiếm phim theo tiêu đề
    private void searchByTitle() {
        String title = Validation.checkInputString("Enter Film Title: ");
        for (Film film : films) {
            if (film.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Film found: " + film);
                return;
            }
        }
        System.out.println("Film not found.");
    }

    // Tìm kiếm phim theo nhà sản xuất
    private void searchByProducer() {
        String producer = Validation.checkInputString("Enter Producer: ");
        for (Film film : films) {
            if (film.getProducer().equalsIgnoreCase(producer)) {
                System.out.println("Film found: " + film);
                return;
            }
        }
        System.out.println("Film not found.");
    }

    // Tạo AutoMenu để tìm kiếm phim
    public void runFilmDisplayMenu() throws ParseException {
        String[] displayOptions = {
                "Display all films",
                "Display films by Film Format",
                "Display films by Film Genre",
                "Back"
        };

        AutoMenu displayMenu = new AutoMenu("Film Display Menu", displayOptions) {
            @Override
            public void execute(int option) {
                switch (option) {
                    case 1 ->
                            displayAllFilms();
                    case 2 -> {
                        MovieFormat dangFilm = chooseDangFilm();
                        displayFilmsByDangFilm(dangFilm);
                    }
                    case 3 -> {
                        GenreFilm theLoaiFilm = chooseTheLoaiFilm();
                        displayFilmsByTheLoaiFilm(theLoaiFilm);
                    }
                    case 4 -> {
                        System.out.println("Returning to previous menu...");
                        stop();
                    }
                    default ->
                            System.out.println("Invalid selection. Please try again.");
                }
            }

            private MovieFormat chooseDangFilm() {
                System.out.println("Select Dang Film:");
                for (int i = 0; i < MovieFormat.values().length; i++) {
                    System.out.println((i + 1) + ". " + MovieFormat.values()[i].getDescription());
                }
                System.out.print("Enter your choice: ");
                int choice = new Scanner(System.in).nextInt();
                return MovieFormat.values()[choice - 1];
            }

            private GenreFilm chooseTheLoaiFilm() {
                System.out.println("Select The Loai Film:");
                for (int i = 0; i < GenreFilm.values().length; i++) {
                    System.out.println((i + 1) + ". " + GenreFilm.values()[i].getDescription());
                }
                System.out.print("Enter your choice: ");
                int choice = new Scanner(System.in).nextInt();
                return GenreFilm.values()[choice - 1];
            }
        };

        displayMenu.run();
    }

    public void displayFilmsByDangFilm(MovieFormat dangFilm) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String header = String.format("%-10s | %-25s | %-15s | %-30s | %-20s | %-15s\n",
                "Film ID", "Film Format", "Genre", "Title", "Producer", "Release Date");

        String separator = new String(new char[header.length()]).replace("\0", "-") + "\n";
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        films.stream()
                .filter(film -> film.getDangFilm() == dangFilm)
                .forEach(System.out::println);
    }


    public void displayFilmsByTheLoaiFilm(GenreFilm theLoaiFilm) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String header = String.format("%-10s | %-25s | %-15s | %-30s | %-20s | %-15s\n",
                "Film ID", "Film Format", "Genre", "Title", "Producer", "Release Date");

        String separator = new String(new char[header.length()]).replace("\0", "-") + "\n";
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);
        films.stream()
                .filter(film -> film.getTheLoaiFilm() == theLoaiFilm)
                .forEach(System.out::println);
    }

    // Phương thức in tất cả phim hiện có
    public void displayAllFilms() {
        if (films.isEmpty()) {
            System.out.println("No films available.");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            String header = String.format("%-10s | %-25s | %-15s | %-30s | %-20s | %-15s\n",
                    "Film ID", "Film Format", "Genre", "Title", "Producer", "Release Date");

            String separator = new String(new char[header.length()]).replace("\0", "-") + "\n";
            System.out.println(separator);
            System.out.println(header);
            System.out.println(separator);
            films.forEach(System.out::println);
        }
    }

    private void displayMoviesByDate() {
        Date date = Validation.checkInputDate("Enter the date (dd/MM/yyyy):");
        displayFilmsByReleaseDate(date);
    }
    public void displayFilmsByGenre() {
        films.stream().filter(film -> film.getReleaseDate().compareTo(String.valueOf(new Date())) >= 0).forEach(System.out::println);
    }
    public void displayFilmsByFormat() {
        films.stream().filter(film -> film.getReleaseDate().compareTo(String.valueOf(new Date())) >= 0).forEach(System.out::println);
    }
    public void displayFilmsByReleaseDate(Date date) {
        films.stream().filter(film -> film.getReleaseDate().compareTo(String.valueOf(date)) >= 0).forEach(System.out::println);
    }

    // Tính toán và hiển thị các thông tin về mặt hàng (ví dụ: số lượng phim theo thể loại, số lượng phim theo định dạng, ...)
//    public void generateProductReport() {
//        System.out.println("Product Report:");
//    }
}