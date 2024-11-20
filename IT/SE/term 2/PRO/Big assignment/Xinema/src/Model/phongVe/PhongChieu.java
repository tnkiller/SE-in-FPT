package Model.phongVe;

public class PhongChieu {
    protected String idPhong;
    protected String tenPhong;

    public PhongChieu(String idPhong, String tenPhong) {
        this.idPhong = idPhong;
        this.tenPhong = tenPhong;
    }

    public PhongChieu() {
    }

    public String getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(String idPhong) {
        this.idPhong = idPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    @Override
    public String toString() {
        return "PhongChieu{" +
                "idPhong='" + idPhong + '\'' +
                ", tenPhong='" + tenPhong + '\'' +
                '}';
    }
}
