package LTM.Haychongiadung_RMI;

import java.io.Serializable;

public class MatHang implements Serializable {
    private int id;
    private String tenMatHang;
    private float giaMatHang;

    public float getGiaMatHang() {
        return giaMatHang;
    }

    public void setGiaMatHang(float giaMatHang) {
        this.giaMatHang = giaMatHang;
    }

    public MatHang(){}
    public MatHang(int id, String tenMatHang,float giaMatHang) {
        this.id = id;
        this.tenMatHang = tenMatHang;
        this.giaMatHang = giaMatHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }
}
