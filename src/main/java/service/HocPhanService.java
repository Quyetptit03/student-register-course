package service;

import entity.HocPhan;
import repository.HocPhanRepository;
import java.util.List;

public class HocPhanService {
    private HocPhanRepository repo = new HocPhanRepository();

    public String themHocPhan(String maHp, String tenHp, int soTinChi) {
        if (repo.findByMaHp(maHp) != null) {
            return "❌ Mã học phần '" + maHp + "' đã tồn tại!";
        }
        repo.save(new HocPhan(maHp, tenHp, soTinChi));
        return "✅ Thêm học phần thành công!";
    }

    public List<HocPhan> layTatCa() {
        return repo.findAll();
    }

    public HocPhan timTheoId(Long id) {
        return repo.findById(id);
    }

    public String capNhatHocPhan(Long id, String tenMoi, int soTinChiMoi) {
        HocPhan hp = repo.findById(id);
        if (hp == null) {
            return "❌ Không tìm thấy học phần có ID " + id;
        }
        hp.setTenHp(tenMoi);
        hp.setSoTinChi(soTinChiMoi);
        repo.update(hp);
        return "✅ Cập nhật học phần thành công!";
    }

    public String xoaHocPhan(Long id) {
        HocPhan hp = repo.findById(id);
        if (hp == null) {
            return "❌ Không tìm thấy học phần có ID " + id;
        }
        repo.deleteById(id);
        return "✅ Đã xóa học phần và các đăng ký liên quan!";
    }

}
