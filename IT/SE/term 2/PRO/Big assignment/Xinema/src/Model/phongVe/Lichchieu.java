package Model.phongVe;

import Model.film.Film;
import java.util.Date;

public class Lichchieu extends Film {
    protected String maXuatChieu;
    protected Date NgayChieu;
    protected String caChieu;
    protected String soPhongChieu;
    protected int tienve;

    public Lichchieu(String idFilm, String maXuatChieu, Date ngayChieu, String caChieu, String soPhongChieu, int tienve) {
        super(idFilm);
        this.maXuatChieu = maXuatChieu;
        NgayChieu = ngayChieu;
        this.caChieu = caChieu;
        this.soPhongChieu = soPhongChieu;
        this.tienve = tienve;
    }

    public String getMaXuatChieu() {
        return maXuatChieu;
    }

    public void setMaXuatChieu(String maXuatChieu) {
        this.maXuatChieu = maXuatChieu;
    }

    public Date getNgayChieu() {
        return NgayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        NgayChieu = ngayChieu;
    }

    public String getCaChieu() {
        return caChieu;
    }

    public void setCaChieu(String caChieu) {
        this.caChieu = caChieu;
    }

    public String getSoPhongChieu() {
        return soPhongChieu;
    }

    public void setSoPhongChieu(String soPhongChieu) {
        this.soPhongChieu = soPhongChieu;
    }

    public int getTienve() {
        return tienve;
    }

    public void setTienve(int tienve) {
        this.tienve = tienve;
    }

    @Override
    public String toString() {
        return "Lichchieu{" +
                "maXuatChieu='" + maXuatChieu + '\'' +
                ", NgayChieu=" + NgayChieu +
                ", caChieu='" + caChieu + '\'' +
                ", soPhongChieu=" + soPhongChieu +
                ", tienve=" + tienve +
                '}';
    }
}
