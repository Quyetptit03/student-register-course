package service;


import entity.*;
import repository.*;

import java.util.List;

public class DangKyHocService {
    private DangKyHocRepository dkRepo = new DangKyHocRepository();

    public void dangKyHocPhan(SinhVien sv, HocPhan hp) {
        dkRepo.save(new DangKyHoc(sv, hp));
    }

    public List<DangKyHoc> layDangKyTheoSinhVien(SinhVien sv) {
        return dkRepo.findBySinhVien(sv);
    }

    public void xoaDangKy(DangKyHoc dk) {
        dkRepo.delete(dk);
    }
}