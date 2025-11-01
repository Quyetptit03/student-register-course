package entity;


import jakarta.persistence.*;

@Entity
public class DangKyHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SinhVien sinhVien;

    @ManyToOne
    private HocPhan hocPhan;

    public DangKyHoc() {}

    public DangKyHoc(SinhVien sinhVien, HocPhan hocPhan) {
        this.sinhVien = sinhVien;
        this.hocPhan = hocPhan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    @Override
    public String toString() {
        return "DangKyHoc{id=" + id + ", sinhVien=" + sinhVien.getHoTen() +
                ", hocPhan=" + hocPhan.getTenHp() + "}";
    }
}