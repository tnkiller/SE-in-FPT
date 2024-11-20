package Model.ve;

import Model.film.Film;
import Model.phongVe.PhongChieu;
import Model.phongVe.Lichchieu;

import java.text.SimpleDateFormat;

public class ThongTinVe {
    // Thuộc tính của ThongTinVe
    private Ve ve;               // Đối tượng Ve thay cho maVe
    private PhongChieu phongChieu; // Đối tượng PhongChieu thay cho maPhong
    private Film phim;             // Đối tượng Phim thay cho maPhim
    private Lichchieu xuatChieu;   // Đối tượng LichChieu thay cho maXuatChieu

    // Constructor
    public ThongTinVe(Ve ve, PhongChieu phongChieu, Film phim, Lichchieu xuatChieu) {
        this.ve = ve;
        this.phongChieu = phongChieu;
        this.phim = phim;
        this.xuatChieu = xuatChieu;
    }

    // Getter và Setter cho các thuộc tính

    public Ve getVe() {
        return ve;
    }

    public void setVe(Ve ve) {
        this.ve = ve;
    }

    public PhongChieu getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(PhongChieu phongChieu) {
        this.phongChieu = phongChieu;
    }

    public Film getPhim() {
        return phim;
    }

    public void setPhim(Film phim) {
        this.phim = phim;
    }

    public Lichchieu getXuatChieu() {
        return xuatChieu;
    }

    public void setXuatChieu(Lichchieu xuatChieu) {
        this.xuatChieu = xuatChieu;
    }

    // Phương thức toString để hiển thị thông tin của ThongTinVe
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String header = String.format("%-15s | %-15s | %-15s | %-15s | %-15s\n",
                "Ticket Code", "Screening Room", "Movie Title", "Show Date", "Show Code");

        String separator = new String(new char[header.length()]).replace("\0", "-") ;

        String row = String.format("%-15s | %-15s | %-15s | %-15s | %-15s",
                ve.getCodeTicket(),
                phongChieu.getTenPhong(),
                phim.getTitle(),
                sdf.format(xuatChieu.getNgayChieu()),
                xuatChieu.getMaXuatChieu());

        return separator + header + separator + row + "\n" + separator;
    }

}
