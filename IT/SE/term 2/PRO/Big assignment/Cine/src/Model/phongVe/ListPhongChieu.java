package Model.phongVe;

import View.AutoMenu;
import View.Validation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListPhongChieu {
    private ArrayList<PhongChieu> phongChieus;

    public ListPhongChieu() {
        phongChieus = new ArrayList<>();
        loadPhongChieuData("phongchieu.txt");
    }

    // Đọc dữ liệu phòng chiếu từ file
    private void loadPhongChieuData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 2) {
                    PhongChieu phongChieu = new PhongChieu(details[0], details[1]);
                    phongChieus.add(phongChieu);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ListPhongChieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Lưu dữ liệu phòng chiếu vào file
    public void savePhongChieuData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("phongchieu.txt"))) {
            for (PhongChieu phongChieu : phongChieus) {
                bw.write(phongChieu.getIdPhong() + "," + phongChieu.getTenPhong() + "\n");
            }
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ListPhongChieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Thêm phòng chiếu mới
    public void addNewPhongChieu(PhongChieu phongChieu) {
        phongChieus.add(phongChieu);
        savePhongChieuData();
    }

    // Cập nhật thông tin phòng chiếu
    public void updatePhongChieu(String idPhong, PhongChieu updatedPhongChieu) {
        for (int i = 0; i < phongChieus.size(); i++) {
            if (phongChieus.get(i).getIdPhong().equals(idPhong)) {
                phongChieus.set(i, updatedPhongChieu);
                savePhongChieuData();
                return;
            }
        }
        System.out.println("Screening room not found.");
    }

    // Xóa phòng chiếu
    public void deletePhongChieu(String idPhong) {
        for (int i = 0; i < phongChieus.size(); i++) {
            if (phongChieus.get(i).getIdPhong().equals(idPhong)) {
                phongChieus.remove(i);
                savePhongChieuData();
                System.out.println("The screening room has been successfully deleted..");
                return;
            }
        }
        System.out.println("Screening room not found.");
    }

    // Tìm kiếm phòng chiếu
    public PhongChieu searchPhongChieu(String idPhong) {
        for (PhongChieu phongChieu : phongChieus) {
            if (phongChieu.getIdPhong().equals(idPhong)) {
                return phongChieu;
            }
        }
        return null;
    }

    // Hiển thị danh sách phòng chiếu
    public void displayPhongChieu() {
        if (phongChieus.isEmpty()) {
            System.out.println("No screening rooms available.");
        } else {
            System.out.println("List of screening rooms:");
            String header = String.format("%-15s | %-15s\n", "Room ID", "Room Name");

            String separator = new String(new char[header.length()]).replace("\0", "-") ;
            System.out.println(separator);
            System.out.println(header);
            System.out.println(separator);
            for (PhongChieu phongChieu : phongChieus) {
                System.out.println(phongChieu);
            }
        }
    }
    public void staffPhongChieus() throws ParseException {
//        boolean running = true;
//        while (running) {
            String[] options = {
                    "Find a screening room",
                    "View list of screening rooms","Back"
            };
            AutoMenu menu = new AutoMenu("Manage screening room information", options) {
                @Override
                public void execute(int option) {
                    switch (option) {
                        case 1:
                            searchPhongChieuById();
                            break;
                        case 2:
                            displayPhongChieuList();
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

    // Quản lý thông tin phòng chiếu
    public void managePhongChieuInfo() throws ParseException {
//        boolean running = true;
//        while (running) {
            String[] options = {
                    "Add new screening room",
                    "Update Theater from ID",
                    "Delete screening room",
                    "Find a screening room",
                    "View list of screening rooms","Back"
            };
            AutoMenu menu = new AutoMenu("Manage screening room information", options) {
                @Override
                public void execute(int option) {
                    switch (option) {
                        case 1:
                            addNewPhongChieu();
                            break;
                        case 2:
                            updatePhongChieuInfo();
                            break;
                        case 3:
                            deletePhongChieu();
                            break;
                        case 4:
                            searchPhongChieuById();
                            break;
                        case 5:
                            displayPhongChieuList();
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


    private void addNewPhongChieu() {
        String idPhong = Validation.checkInputString("Enter the screening room code: ");
        String tenPhong = Validation.checkInputString("Enter the screening room name: ");
        PhongChieu newPhongChieu = new PhongChieu(idPhong, tenPhong);
        addNewPhongChieu(newPhongChieu);
        System.out.println("New screening room added successfully.");
    }

    private void updatePhongChieuInfo() {
        String idPhong = Validation.checkInputString("Enter the theater code that needs to be updated: ");
        PhongChieu phongChieu = searchPhongChieu(idPhong);
        if (phongChieu != null) {
            String newTenPhong = Validation.checkInputString("Enter the theater code that needs to be updated: ");
            PhongChieu updatedPhongChieu = new PhongChieu(idPhong, newTenPhong);
            updatePhongChieu(idPhong, updatedPhongChieu);
            System.out.println("Screening room information has been updated successfully..");
        } else {
            System.out.println("Screening room not found.");
        }
    }

    private void deletePhongChieu() {
        String idPhong = Validation.checkInputString("Enter the theater code to delete: ");
        deletePhongChieu(idPhong);
    }

    private void searchPhongChieuById() {
        String idPhong = Validation.checkInputString("Enter the ID room code you want to find: ");
        PhongChieu phongChieu = searchPhongChieu(idPhong);
        if (phongChieu != null) {
            System.out.println("Screening room information:");
            System.out.println(phongChieu);
        } else {
            System.out.println("Screening room not found.");
        }
    }

    private void displayPhongChieuList() {
        displayPhongChieu();
    }
}
