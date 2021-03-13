package businessLogics;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Member;

public class MemberBL {
	private static List<Member> getMemberListByQuery(String sql) {
		List<Member> dsMember = new ArrayList<Member>();
		try (Connection connection = CSDL.getKetNoi()) {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				dsMember.add(buildMember(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsMember;
	}

	private static Member buildMember(ResultSet rs) throws SQLException {
		return new Member.Builder().email(rs.getString("Email")).fullName(rs.getString("FullName"))
				.gender(rs.getByte("Gender")).id(rs.getLong("id")).password(rs.getString("Password"))
				.username(rs.getString("UserName")).addedDate(rs.getDate("AddedDate")).build();
	}

	public static List<Member> getMemberList() {
		String sql = "SELECT * FROM MiniShop.Member";
		return getMemberListByQuery(sql);
	}

	private static byte[] sha256(String text) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			return md.digest(text.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

	}

	private static long random() {
		Random rand = new Random();
		long a = rand.nextInt();
		long b = rand.nextInt();
		return a * b;
	}

	public static boolean addMember(Member member) {
		String sql = "INSERT INTO MiniShop.Member(id,UserName,Password,FullName,Email,Gender) VALUES(?,?,?,?,?,?)";
		try (Connection connection = CSDL.getKetNoi()) {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setLong(1, random());
			pstm.setString(2, member.getUsername());
			pstm.setBytes(3, sha256(member.getPassword()));
			pstm.setString(4, member.getFullName());
			pstm.setString(5, member.getEmail());
			pstm.setByte(6, member.getGender());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Member logOn(String userName, String password) {
//		String sql = "SELECT * FROM MiniShop.Member WHERE UserName = '" + userName + "' AND Password = '"
//				+ sha256(password) + "'";
		String sql = "SELECT * FROM MiniShop.Member WHERE UserName = ? AND Password = ?";
		try (Connection connection = CSDL.getKetNoi()) {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setBytes(2, sha256(password));
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return buildMember(rs);
			}
		} catch (Exception e) {
		}
		return null;
	}
}
