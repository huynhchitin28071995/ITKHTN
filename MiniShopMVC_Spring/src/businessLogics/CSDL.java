package businessLogics;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CSDL {
	private static JdbcTemplate jdbc;

	public static JdbcTemplate getJdbc() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/minishop?useUnicode=true&characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		jdbc = new JdbcTemplate(dataSource);
		return jdbc;
	}
	public static void main(String[] args) {
		getJdbc();
	}
}
