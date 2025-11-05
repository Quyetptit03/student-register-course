package service;

import entity.SinhVien;
import repository.SinhVienRepository;
import java.util.List;

public class SinhVienService {
    private SinhVienRepository repo = new SinhVienRepository();

    public String themSinhVien(String maSv, String hoTen, String email, String diaChi) {
        if (repo.findByMaSv(maSv) != null) {
            return "❌ Mã sinh viên '" + maSv + "' đã tồn tại!";
        }
        repo.save(new SinhVien(maSv, hoTen, email, diaChi));
        return "✅ Thêm sinh viên thành công!";
    }

    public String capNhatSinhVien(Long id, String hoTen, String email, String diaChi) {
        SinhVien sv = repo.findById(id);
        if (sv == null) {
            return "❌ Không tìm thấy sinh viên có ID " + id;
        }
        sv.setHoTen(hoTen);
        sv.setEmail(email);
        sv.setDiaChi(diaChi);
        repo.update(sv);
        return "✅ Cập nhật thông tin sinh viên thành công!";
    }

    public List<SinhVien> layTatCa() {
        return repo.findAll();
    }

    public SinhVien timTheoId(Long id) {
        return repo.findById(id);
    }

    public String xoaSinhVien(Long id) {
        SinhVien sv = repo.findById(id);
        if (sv == null) {
            return "❌ Không tìm thấy sinh viên có ID " + id;
        }
        repo.deleteById(id);
        return "✅ Đã xóa sinh viên và các đăng ký liên quan!";
    }
}
