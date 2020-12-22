package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.NguoiDung;

public class NguoiDungBL {
	// Tao danh sach NguoiDung
	private static List<NguoiDung> taoDanhSach(String sql) {
		List<NguoiDung> dsnd = new ArrayList<>();
		try (Connection connection = CSDL.getKetNoi()) {
			Statement stm = connection.createStatement();
			// String sql = "SELECT * FROM nguoidung";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				NguoiDung nd = new NguoiDung();
				nd.setIdVaiTro(rs.getInt("id_vaitro"));
				nd.setDtdd(rs.getString("dtdd"));
				nd.setDiaChi(rs.getString("diachi"));
				nd.setHoTen(rs.getString("hoten"));
				nd.setEmail(rs.getString("email"));
				nd.setPassword(rs.getString("password"));
				nd.setId(rs.getInt("id"));
				dsnd.add(nd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsnd;
	}

	// Dang nhap
	public static NguoiDung docTheoEmailPassword(String email, String password) {
		NguoiDung nd = null;
		String sql = "SELECT * FROM phuong_perfume.nguoidung WHERE email='" + email + "' and password = '" + password
				+ "'";
		List<NguoiDung> dsnd = taoDanhSach(sql);
		if (dsnd.size() > 0) {
			return nd = dsnd.get(0);
		} else {
			return null;
		}

	}

//	public static void main(String[] args) {
//		List<NguoiDung> dsnd = taoDanhSach("select * from nguoidung");
//		NguoiDung nd = docTheoEmailPassword("bichle@gmail.com", "bichle");
//		System.out.println("Nguoi dung 1 trong DSND: " + dsnd.get(0).getHoTen());
//		System.out.println("Bich le: " + nd.getEmail());
//	}

}