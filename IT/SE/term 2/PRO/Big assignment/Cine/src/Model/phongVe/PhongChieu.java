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
        String header = String.format("%-15s | %-15s\n", "Room ID", "Room Name");

        String separator = new String(new char[header.length()]).replace("\0", "-") ;

        String row = String.format("%-15s | %-15s", idPhong, tenPhong);

        return  row + "\n" + separator;
    }

}
