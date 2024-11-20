package Model.phongVe;

import Model.film.Film;
import Model.ve.ListVe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lichchieu extends Film {

    protected String maXuatChieu;
    protected Date NgayChieu;
    protected String caChieu;
    protected String soPhongChieu;
    protected String tienve;

    public Lichchieu(String idFilm, String maXuatChieu, Date ngayChieu, String caChieu, String soPhongChieu, String tienve) throws ParseException {
        super(idFilm);
        this.maXuatChieu = maXuatChieu;
        NgayChieu = ngayChieu;
        this.caChieu = caChieu;
        this.soPhongChieu = soPhongChieu;
        this.tienve = setTienve();
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

    public String getTienve() {
        return tienve;
    }

    public String setTienve() throws ParseException {
        return "Standard: 50000 - Couple :120000 - Vip : 60000";
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String header = String.format("%-15s | %-15s | %-10s | %-15s | %-10s\n",
                "Show Code", "Show Date", "Session", "Room Number", "Ticket Price");

        String separator = new String(new char[header.length()]).replace("\0", "-");

        String row = String.format("%-15s | %-15s | %-10s | %-15s | %-10s",
                maXuatChieu,
                sdf.format(NgayChieu),
                caChieu,
                soPhongChieu,
                tienve);

        return row + "\n" + separator;
    }

}
