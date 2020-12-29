package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Author;

public class AuthorBL {
	static JdbcTemplate jdbc = CSDL.getJdbc();

	public static List<Author> docTatCa() {
		String sql = "SELECT * FROM author";
		return jdbc.query(sql, new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				Author author = new Author();
				author.setAuthorId(rs.getInt("AuthorId"));
				author.setAuthorName(rs.getString("AuthorName"));
				return author;
			}
		});
	}

	// Doc theo id
	public static Author docTheoId(int id) {
		String sql = "select * from author where AuthorId=?";
		return jdbc.queryForObject(sql, new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				Author author = new Author();
				author.setAuthorId(rs.getInt("AuthorId"));
				author.setAuthorName(rs.getString("AuthorName"));
				return author;
			}
		}, id);
	}

	// Them author
	public static int them(Author author) {
		String sql = "Insert into author(authorname) values(?)";
		return jdbc.update(sql, author.getAuthorName());
	}

	public static void xoa(int authorId) {
		String sql = "delete from author where AuthorId=?";
		jdbc.update(sql, authorId);
	}

	public static void xoa(List<Integer> list) {
		list.forEach(id -> jdbc.update("delete from author where AuthorId=?", id));
	}

	public static void sua(int authorId, String authorName) {
		String sql = "update Author set AuthorName=? where AuthorId=?";
		jdbc.update(sql, authorName, authorId);
	}

	public static void main(String[] args) {
		docTatCa().forEach(author -> System.out.println(author.getAuthorName()));
		System.out.println(docTheoId(1).getAuthorName());
		Author author = new Author();
		author.setAuthorName("AAAAA");
		// author.setAuthorId(27);
		for (int i = 0; i < 10; i++)
			them(author);
		// xoa(21);
	}
}
