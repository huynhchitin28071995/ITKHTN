package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.QuangCao;

public class QuangCaoBL {
	public static List<QuangCao> docTatCa() {
		List<QuangCao> dsqc = new ArrayList<QuangCao>();
		try (Connection connection = CSDL.getKetNoi()) {
			String sql = "select * from phuong_perfume.quangcao";
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				QuangCao qc = new QuangCao();
				qc.setNgayDang(rs.getDate("ngaydang"));
				qc.setTtChiTiet(rs.getString("thongtinchitiet"));
				qc.setThongDiep(rs.getString("thongdiep"));
				qc.setHinhAnh(rs.getString("hinhanh"));
				qc.setId(rs.getInt("id"));
				dsqc.add(qc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dsqc;
	}

	public static void main(String[] args) {
		List<QuangCao> dsqc = new ArrayList<>();
		dsqc = docTatCa();
		dsqc.forEach(qc -> {
			System.out
					.println(qc.getId() + ": " + qc.getNgayDang() + ", " + qc.getThongDiep() + ", " + qc.getHinhAnh());
		});
	}
}
