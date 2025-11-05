package entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sinh_vien", uniqueConstraints = @UniqueConstraint(columnNames = "maSv"))
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String maSv;

    @Column(nullable = false)
    private String hoTen;

    private String email;
    private String diaChi;

    @OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DangKyHoc> dangKyHocs = new ArrayList<>();

    public SinhVien() {}

    public SinhVien(String maSv, String hoTen, String email, String diaChi) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.email = email;
        this.diaChi = diaChi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setDangKyHocs(List<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }

    public Long getId() {
        return id;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public List<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", maSv='" + maSv + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", dangKyHocs=" + dangKyHocs +
                '}';
    }
}
