
package Model.phongVe;

import Model.film.FilmList;
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

public class ListLichChieu {
    private ArrayList<Lichchieu> lichChieus;
    private FilmList filmList;


    public ListLichChieu() {
        lichChieus = new ArrayList<>();
        
        loadLichChieuData("lichchieu.txt");
    }

    // Đọc dữ liệu lịch chiếu từ file
    private void loadLichChieuData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 6) {
                    Lichchieu lichChieu = new Lichchieu(details[0], details[1], Validation.changeStringToDate(details[2]), details[3], details[4],  Integer.parseInt(details[5]));
                    lichChieus.add(lichChieu);
                }
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ListLichChieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Lưu dữ liệu lịch chiếu vào file
    public void saveLichChieuData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("lichchieu.txt"))) {
            for (Lichchieu lichChieu : lichChieus) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                bw.write(lichChieu.getMaXuatChieu() + "," + dateFormat.format(lichChieu.getNgayChieu()) + "," + lichChieu.getCaChieu() + "," + lichChieu.getSoPhongChieu() + "," + lichChieu.getTienve() + "," + lichChieu.getIdFilm() + "\n");
            }
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ListLichChieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Thêm lịch chiếu mới
    public void addNewLichChieu(Lichchieu lichChieu) {
        lichChieus.add(lichChieu);
        saveLichChieuData();
    }

    // Cập nhật thông tin lịch chiếu
    public void updateLichChieu(String maXuatChieu, Lichchieu updatedLichChieu) {
        for (int i = 0; i < lichChieus.size(); i++) {
            if (lichChieus.get(i).getMaXuatChieu().equals(maXuatChieu)) {
                lichChieus.set(i, updatedLichChieu);
                saveLichChieuData();
                return;
            }
        }
        System.out.println("Showtimes not found.");
    }

    // Xóa lịch chiếu
    public void deleteLichChieu(String maXuatChieu) {
        for (int i = 0; i < lichChieus.size(); i++) {
            if (lichChieus.get(i).getMaXuatChieu().equals(maXuatChieu)) {
                lichChieus.remove(i);
                saveLichChieuData();
                System.out.println("Showtime has been successfully deleted.");
                return;
            }
        }
        System.out.println("Showtimes not found.");
    }

    // Tìm kiếm lịch chiếu
    public Lichchieu searchLichChieu(String maXuatChieu) {
        for (Lichchieu lichChieu : lichChieus) {
            if (lichChieu.getMaXuatChieu().equals(maXuatChieu)) {
                return lichChieu;
            }
        }
        return null;
    }

    // Hiển thị danh sách lịch chiếu
    public void displayLichChieu() {
        if (lichChieus.isEmpty()) {
            System.out.println("No showtimes available.");
        } else {
            System.out.println("Showtimes List:");
            for (Lichchieu lichChieu : lichChieus) {
                System.out.println("");
            }
        }
    }
    public void staffLichChieuInfo() throws ParseException {
//        boolean running = true;
//        while (running) {
            String[] options = {
                    "Find showtimes",
                    "View showtimes list","Back"
            };
            AutoMenu menu = new AutoMenu("Manage showtime information", options) {
                @Override
                public void execute(int option) {
                    switch (option) {

                        case 1:
                            searchLichChieuByCode();
                            break;
                        case 2:
                            displayLichChieuList();
                            break;
                        case 3:
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


    // Quản lý thông tin lịch chiếu
    public void manageLichChieuInfo() throws ParseException {
//        boolean running = true;
//        while (running) {
            String[] options = {
                    "Add new showtimes",
                    "Update showtime information",
                    "Delete showtimes",
                    "Find showtimes",
                    "View showtimes list","Back"
            };
            AutoMenu menu = new AutoMenu("Manage showtime information", options) {
                @Override
                public void execute(int option) {
                    switch (option) {
                        case 1:
                            addNewLichChieu();
                            break;
                        case 2:
                            updateLichChieuInfo();
                            break;
                        case 3:
                            deleteLichChieu();
                            break;
                        case 4:
                            searchLichChieuByCode();
                            break;
                        case 5:
                            displayLichChieuList();
                            break;
                        case 6:
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


    private void addNewLichChieu() {
        String maXuatChieu = Validation.checkInputString("Enter showtime code: ");
        String ngayChieuStr = Validation.checkInputString("Enter show date (dd/MM/yyyy): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayChieu;
        try {
            ngayChieu = dateFormat.parse(ngayChieuStr);
        } catch (ParseException e) {
            System.out.println("Error entering show date: " + e.getMessage());
            return;
        }
        String caChieu = Validation.checkInputString("Enter the projection: ");
        String soPhongChieu = Validation.checkInputString("Enter the screening room number: ");
        int tienVe = Validation.checkInputInt("Enter fare: ");
        String idFilm = Validation.checkInputString("Enter movie code: ");

        Lichchieu newLichChieu = new Lichchieu(idFilm,maXuatChieu, ngayChieu, caChieu, soPhongChieu, tienVe);
        addNewLichChieu(newLichChieu);
        System.out.println("New showtimes added successfully.");
    }

    private void updateLichChieuInfo() {
        String maXuatChieu = Validation.checkInputString("Enter the showtime code to be updated: ");
        Lichchieu lichChieu = searchLichChieu(maXuatChieu);
        if (lichChieu != null) {
            String newNgayChieuStr = Validation.checkInputString("Enter new show date (dd/MM/yyyy): ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date newNgayChieu;
            try {
                newNgayChieu = dateFormat.parse(newNgayChieuStr);
            } catch (ParseException e) {
                System.out.println("Error entering new show date: " + e.getMessage());
                return;
            }
            String newCaChieu = Validation.checkInputString("Enter new screening: ");
            String newSoPhongChieu = Validation.checkInputGender("Enter new screening room number: ");
            int newTienVe = Validation.checkInputInt("Enter new fare: ");
            String newIdFilm = Validation.checkInputString("Enter new movie code: ");

            Lichchieu updatedLichChieu = new Lichchieu(newIdFilm,maXuatChieu, newNgayChieu, newCaChieu, newSoPhongChieu, newTienVe );
            updateLichChieu(maXuatChieu, updatedLichChieu);
            System.out.println("Showtime information has been updated successfully..");
        } else {
            System.out.println("Showtimes not found.");
        }
    }

    private void deleteLichChieu() {
        String maXuatChieu = Validation.checkInputString("Enter the showtime code to delete: ");
        deleteLichChieu(maXuatChieu);
    }

    private void searchLichChieuByCode() {
        String maXuatChieu = Validation.checkInputString("Enter the showtime code you want to find: ");
        Lichchieu lichChieu = searchLichChieu(maXuatChieu);
        if (lichChieu != null) {
            System.out.println("Showtime information:");
            System.out.println(lichChieu);
        } else {
            System.out.println("Showtimes not found.");
        }
    }

    private void displayLichChieuList() {
        displayLichChieu();
    }
}