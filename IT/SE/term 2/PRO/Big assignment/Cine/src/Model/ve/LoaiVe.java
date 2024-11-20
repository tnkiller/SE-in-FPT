package Model.ve;

import Model.phongVe.ListLichChieu;

import java.text.ParseException;

public class LoaiVe {
    protected String maLoaiVe;
    protected  String tenLoaiVe;
    protected long donGia;
    protected ListLichChieu listLichChieu;
    public LoaiVe(String maLoaiVe, String tenLoaiVe, long donGia) throws ParseException {
        listLichChieu = new ListLichChieu();
        this.maLoaiVe = maLoaiVe;
        this.tenLoaiVe = tenLoaiVe;
        if (tenLoaiVe.equalsIgnoreCase("standard")) this.donGia = 50000;
        else if( tenLoaiVe.equalsIgnoreCase("vip")) this.donGia=60000;
        else if ( tenLoaiVe.equalsIgnoreCase("couple")) {
            this.donGia=110000;
        }
        System.out.println("Don gia la "+this.donGia);
    }

    public LoaiVe() {
    }

    public String getMaLoaiVe() {
        return maLoaiVe;
    }

    public void setMaLoaiVe(String maLoaiVe) {
        this.maLoaiVe = maLoaiVe;
    }

    public String getTenLoaiVe() {
        return tenLoaiVe;
    }

    public void setTenLoaiVe(String tenLoaiVe) {
        this.tenLoaiVe = tenLoaiVe;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia() {
        if (maLoaiVe.equalsIgnoreCase("standard")) this.donGia = 50000;
        else if(maLoaiVe.equalsIgnoreCase("vip")) this.donGia=60000;
        else if (maLoaiVe.equalsIgnoreCase("couple")) {
            this.donGia=110000;
        }
    }

    @Override
    public String toString() {
        String header = String.format("%-15s | %-15s | %-15s\n", "Ticket Code", "Ticket Name", "Price");

        String separator = new String(new char[header.length()]).replace("\0", "-") ;

        String row = String.format("%-15s | %-15s | %-15d", maLoaiVe, tenLoaiVe, this.donGia);

        return  row + "\n" + separator;
    }

}
