import entity.*;
import service.DangKyHocService;
import service.HocPhanService;
import service.SinhVienService;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static SinhVienService svService = new SinhVienService();
    private static HocPhanService hpService = new HocPhanService();
    private static DangKyHocService dkService = new DangKyHocService();

    public static void main(String[] args) {
        if (svService.layTatCa().isEmpty()) {
            svService.themSinhVien("SV01", "Nguyễn Văn A");
            svService.themSinhVien("SV02", "Trần Thị B");
            svService.themSinhVien("SV03", "Lê Văn C");
        }

        if (hpService.layTatCa().isEmpty()) {
            hpService.themHocPhan("HP01", "Lập trình Java", 3);
            hpService.themHocPhan("HP02", "Cơ sở dữ liệu", 3);
            hpService.themHocPhan("HP03", "Mạng máy tính", 2);
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== HỆ THỐNG ĐĂNG KÝ HỌC PHẦN =====");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Xem danh sách học phần");
            System.out.println("3. Đăng ký học phần");
            System.out.println("4. Xem danh sách học phần đã đăng ký");
            System.out.println("5. Xóa đăng ký học phần");
            System.out.println("6. ➕ Thêm sinh viên mới");
            System.out.println("7. ➕ Thêm học phần mới");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1 -> {
                    List<SinhVien> svs = svService.layTatCa();
                    if (svs.isEmpty()) System.out.println("⚠ Chưa có sinh viên nào!");
                    else svs.forEach(System.out::println);
                }
                case 2 -> {
                    List<HocPhan> hps = hpService.layTatCa();
                    if (hps.isEmpty()) System.out.println("⚠ Chưa có học phần nào!");
                    else hps.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Nhập ID sinh viên: ");
                    Long svId = sc.nextLong();
                    System.out.print("Nhập ID học phần: ");
                    Long hpId = sc.nextLong();

                    SinhVien sv = svService.timTheoId(svId);
                    HocPhan hp = hpService.timTheoId(hpId);

                    if (sv != null && hp != null) {
                        dkService.dangKyHocPhan(sv, hp);
                        System.out.println("✅ Đăng ký thành công!");
                    } else {
                        System.out.println("❌ Không tìm thấy sinh viên hoặc học phần!");
                    }
                }
                case 4 -> {
                    System.out.print("Nhập ID sinh viên: ");
                    Long svId = sc.nextLong();
                    SinhVien sv = svService.timTheoId(svId);
                    if (sv != null) {
                        List<DangKyHoc> list = dkService.layDangKyTheoSinhVien(sv);
                        if (list.isEmpty()) System.out.println("⚠ Sinh viên chưa đăng ký học phần nào!");
                        else list.forEach(System.out::println);
                    } else System.out.println("Không tìm thấy sinh viên!");
                }
                case 5 -> {
                    System.out.print("Nhập ID sinh viên: ");
                    Long svId = sc.nextLong();
                    SinhVien sv = svService.timTheoId(svId);
                    if (sv == null) {
                        System.out.println("Không tìm thấy sinh viên!");
                        break;
                    }

                    List<DangKyHoc> list = dkService.layDangKyTheoSinhVien(sv);
                    if (list.isEmpty()) {
                        System.out.println("⚠ Sinh viên chưa đăng ký học phần nào!");
                        break;
                    }

                    list.forEach(System.out::println);
                    System.out.print("Nhập ID đăng ký muốn xóa: ");
                    Long dkId = sc.nextLong();

                    DangKyHoc dk = list.stream().filter(d -> d.getId().equals(dkId)).findFirst().orElse(null);
                    if (dk != null) {
                        dkService.xoaDangKy(dk);
                        System.out.println("✅ Đã xóa đăng ký!");
                    } else System.out.println("❌ Không tìm thấy!");
                }
                case 6 -> { // thêm sinh viên
                    System.out.print("Nhập mã sinh viên: ");
                    String maSv = sc.nextLine();
                    System.out.print("Nhập họ tên sinh viên: ");
                    String hoTen = sc.nextLine();
                    System.out.println(svService.themSinhVien(maSv, hoTen));
                }

                case 7 -> { // thêm học phần
                    System.out.print("Nhập mã học phần: ");
                    String maHp = sc.nextLine();
                    System.out.print("Nhập tên học phần: ");
                    String tenHp = sc.nextLine();
                    System.out.print("Nhập số tín chỉ: ");
                    int soTinChi = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.println(hpService.themHocPhan(maHp, tenHp, soTinChi));
                }
                case 0 -> {
                    System.out.println("Thoát chương trình!");
                    System.exit(0);
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
