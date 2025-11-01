package entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hoc_phan", uniqueConstraints = @UniqueConstraint(columnNames = "maHp"))
public class HocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String maHp;

    @Column(nullable = false)
    private String tenHp;

    private int soTinChi;

    @OneToMany(mappedBy = "hocPhan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DangKyHoc> dangKyHocs = new ArrayList<>();

    public HocPhan() {}

    public HocPhan(String maHp, String tenHp, int soTinChi) {
        this.maHp = maHp;
        this.tenHp = tenHp;
        this.soTinChi = soTinChi;
    }

    public Long getId() {
        return id;
    }

    public String getMaHp() {
        return maHp;
    }

    public void setMaHp(String maHp) {
        this.maHp = maHp;
    }

    public String getTenHp() {
        return tenHp;
    }

    public void setTenHp(String tenHp) {
        this.tenHp = tenHp;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return "HocPhan{id=" + id + ", maHp='" + maHp + "', tenHp='" + tenHp + "', soTinChi=" + soTinChi + "}";
    }
}
