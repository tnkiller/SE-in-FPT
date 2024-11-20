package Model.ve;

import Model.film.Film;
import Model.phongVe.PhongChieu;
import Model.phongVe.Lichchieu;
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
        return "ThongTinVe{" +
                "ve=" + ve.getCodeTicket() +
                ", phongChieu=" + phongChieu.getTenPhong() +
                ", phim=" + phim.getTitle() +
                ", xuatChieu=" + xuatChieu.getNgayChieu() + " " + xuatChieu.getMaXuatChieu() +
                '}';
    }
}
