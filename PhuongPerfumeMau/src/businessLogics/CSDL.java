package businessLogics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CSDL {
	public static Connection getKetNoi() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3308/phuong_perfume?useUnicode=true&characterEncoding=UTF-8";
			connection = DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		getKetNoi();
	}
}
