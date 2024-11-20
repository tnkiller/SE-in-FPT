package Model.ve;

public class LoaiVe {
    protected String maLoaiVe;
    protected  String tenLoaiVe;
    protected long donGia;

    public LoaiVe(String maLoaiVe, String tenLoaiVe, long donGia) {
        this.maLoaiVe = maLoaiVe;
        this.tenLoaiVe = tenLoaiVe;
        this.donGia = donGia;
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

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "LoaiVe{" +
                "maLoaiVe='" + maLoaiVe + '\'' +
                ", tenLoaiVe='" + tenLoaiVe + '\'' +
                ", donGia=" + donGia +
                '}';
    }
}
