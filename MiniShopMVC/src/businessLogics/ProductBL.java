package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Product;

public class ProductBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();
	public static List<Product> docTatCa() {
		
		String sql = "select * from product";
		return jdbc.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product p = new Product();
				p.setAuthorId(rs.getInt("AuthorId"));
				p.setPrice(rs.getInt("Price"));
				p.setImageUrl(rs.getString("ImageUrl"));
				p.setDescription(rs.getString("Description"));
				p.setSize(rs.getString("size"));
				p.setWeight(rs.getString("Weight"));
				p.setYear(rs.getShort("Year"));
				p.setPages(rs.getShort("Pages"));
				p.setTitle(rs.getString("Title"));
				p.setIsbn(rs.getString("ISBN"));
				p.setAuthorId(rs.getInt("AuthorId"));
				p.setPublisherId(rs.getInt("PublisherId"));
				p.setCategoryId(rs.getInt("CategoryId"));
				p.setProductId(rs.getInt("ProductId"));
				return p;
			}
		});
	}
}
