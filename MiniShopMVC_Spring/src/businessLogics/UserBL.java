package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Role;
import javaBeans.User;
import util.Helper;

public class UserBL {
	static JdbcTemplate jdbc = CSDL.getJdbc();

	public static int add(User obj) {
		obj.setId(Helper.randomLong());
		int a = jdbc.update(
				"INSERT INTO User(UserId, Username, Password, Email, Gender, Tel, Address) VALUES(?, ?, ?, ?, ?, ?, ?)",
				obj.getId(), obj.getUsername(), Helper.bcrypt(obj.getPassword()), obj.getEmail(), obj.isGender(),
				obj.getTel(), obj.getAddress());
		int b = jdbc.update("INSERT INTO UserInRole(UserId, RoleId) VALUES(?, ?)", obj.getId(), 1);
		return a + b;
	}

	public static User logon(String username) {
		User member = jdbc.queryForObject("SELECT UserId, Username, Password FROM User WHERE Username = ?",
				new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int numRow) throws SQLException {
						return new User(rs.getLong("UserId"), rs.getString("UserName"), rs.getString("Password"));
					}
				}, username);
		member.setRoles(getRolesByMemberId(member.getId()));
		return member;
	}

	public static List<Role> getRolesByMemberId(long id) {
		return jdbc.query(
				"SELECT Role.RoleId, RoleName FROM Role INNER JOIN UserInRole ON Role.RoleId = UserInRole.RoleId WHERE UserId = ?",
				new RowMapper<Role>() {

					@Override
					public Role mapRow(ResultSet rs, int arg1) throws SQLException {
						return new Role(rs.getInt("RoleId"), rs.getString("RoleName"));
					}
				}, id);
	}
}