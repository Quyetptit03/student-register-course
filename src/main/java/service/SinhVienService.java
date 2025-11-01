package service;

import entity.SinhVien;
import repository.SinhVienRepository;
import java.util.List;

public class SinhVienService {
    private SinhVienRepository repo = new SinhVienRepository();

    public String themSinhVien(String maSv, String hoTen) {
        if (repo.findByMaSv(maSv) != null) {
            return "❌ Mã sinh viên '" + maSv + "' đã tồn tại!";
        }
        repo.save(new SinhVien(maSv, hoTen));
        return "✅ Thêm sinh viên thành công!";
    }

    public List<SinhVien> layTatCa() {
        return repo.findAll();
    }

    public SinhVien timTheoId(Long id) {
        return repo.findById(id);
    }
}
