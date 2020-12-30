package businessLogics;

import org.springframework.jdbc.core.JdbcTemplate;

import javaBeans.User;

public class MemberBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();
	public static void add(User user) {
		String sql = "INSERT INTO user(userId,username,password,email,gender,tel,address) VALUES(?,?,?,?,?,?,?)";
		jdbc.update(sql, user.getUserId(),user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getTel(),user.getAddress());
	}
	public static void main(String[] args) {
		User user = new User();
		
	}
}
