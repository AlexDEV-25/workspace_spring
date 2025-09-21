package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

	private final SpringAutoUpdateTableApplication springAutoUpdateTableApplication;

	MyConfiguration(SpringAutoUpdateTableApplication springAutoUpdateTableApplication) {
		this.springAutoUpdateTableApplication = springAutoUpdateTableApplication;
	}

	@Bean
	public CommandLineRunner getRunner(SinhVienDAO svDAO) {
		return runner -> {

			while (true) {
				System.out.println("===== MENU QUẢN LÝ SINH VIÊN =====");
				System.out.println("1. Thêm sinh viên");
				System.out.println("2. Tìm kiếm sinh viên theo id");
				System.out.println("3. Tìm kiếm sinh viên theo name");
				System.out.println("4. Hiển thị tất cả sinh viên");
				System.out.println("5. Sửa thông tin 1 sinh viên");
				System.out.println("6. Sửa thông tin nhiều sinh viên");
				System.out.println("7. Xóa sinh viên");
				System.out.println("8. Xóa sinh viên theo tên");
				System.out.println("9. Thoát");
				System.out.print("Vui lòng chọn chức năng (1-9): ");
				Scanner sc = new Scanner(System.in);
				int choose = sc.nextInt();
				sc.nextLine(); // đọc bỏ Enter thừa
				if (choose == 1) {
					System.out.println("nhập thông tin sinh viên");
					System.out.println("nhập họ");
					String hoDem = sc.nextLine();
					System.out.println("nhập tên");
					String ten = sc.nextLine();
					System.out.println("nhập email");
					String email = sc.nextLine();
					SinhVien sv = new SinhVien(hoDem, ten, email);
					svDAO.create(sv);
					System.out.println("thêm thành công");
				} else if (choose == 2) {
					System.out.println("tìm sinh viên");
					System.out.println("nhập id sinh viên muốn tìm");
					int id = sc.nextInt();
					if (svDAO.getByID(id) == null) {
						System.out.println("không tìm thấy sinh viên");
					} else {
						System.out.println(svDAO.getByID(id).toString());
					}
				} else if (choose == 3) {
					System.out.println("tìm sinh viên");
					System.out.println("nhập name sinh viên muốn tìm");
					String name = sc.nextLine();
					List<SinhVien> s = svDAO.getByName(name);
					if (s == null) {
						System.out.println("không tìm thấy sinh viên");
					} else {
						for (SinhVien sv : s) {
							System.out.println(sv.toString());
						}
					}
				} else if (choose == 4) {
					List<SinhVien> s = svDAO.getAll();
					if (s == null) {
						System.out.println("không tìm thấy sinh viên");
					} else {
						for (SinhVien sv : s) {
							System.out.println(sv.toString());
						}
					}
				} else if (choose == 5) {
					System.out.println("tìm sinh viên");
					System.out.println("nhập id sinh viên muốn tìm");
					int id = sc.nextInt();
					sc.nextLine();
					if (svDAO.getByID(id) == null) {
						System.out.println("không tìm thấy sinh viên, không thể cập nhật");
					} else {
						System.out.println("nhập thông tin sinh viên");
						System.out.println("nhập họ");
						String hoDem = sc.nextLine();
						System.out.println("nhập tên");
						String ten = sc.nextLine();
						System.out.println("nhập email");
						String email = sc.nextLine();
						SinhVien sv = svDAO.getByID(id);
						sv.setHoDem(hoDem);
						sv.setTen(ten);
						sv.setEmail(email);
						svDAO.update(sv);
						System.out.println("cập nhật thành công");
					}
				} else if (choose == 6) {
					System.out.println("nhập thông tin sinh viên");
					System.out.println("nhập tên");
					String ten = sc.nextLine();
					svDAO.updateAllName(ten);
					System.out.println("cập nhật thành công");
					int rows = svDAO.updateAllName(ten);
					System.out.println("số dòng bị thay đổi là : " + rows);

				} else if (choose == 7) {
					System.out.println("tìm sinh viên");
					System.out.println("nhập id sinh viên muốn tìm");
					int id = sc.nextInt();
					sc.nextLine();
					if (svDAO.getByID(id) == null) {
						System.out.println("không tìm thấy sinh viên, không thể xóa");
					} else {
						svDAO.delete(svDAO.getByID(id));
						System.out.println("xóa thành công");
					}
				} else if (choose == 8) {
					System.out.println("nhập thông tin sinh viên");
					System.out.println("nhập tên");
					String ten = sc.nextLine();
					svDAO.deleteByName(ten);
					System.out.println("xóa thành công");
				}
				if (choose == 9) {
					break;
				}
			}

		};
	}
}
