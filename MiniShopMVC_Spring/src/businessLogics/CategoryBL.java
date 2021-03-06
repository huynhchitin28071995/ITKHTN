package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Category;

public class CategoryBL {
	static JdbcTemplate jdbc = CSDL.getJdbc();
	public static List<Category> docTatCa() {
		String sql = "select * from category";
		return jdbc.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int numRow) throws SQLException {
				Category category = new Category();
				category.setCategoryId(rs.getInt("CategoryId"));
				category.setCategoryName(rs.getString("CategoryName"));
				category.setParentId(rs.getInt("ParentId"));
				return category;
			}
			
		});
	}
	public static List<Category> docParent() {
		String sql = "select * from category where parentid is null";
		return jdbc.query(sql, new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category category = new Category();
				category.setCategoryId(rs.getInt("CategoryId"));
				category.setCategoryName(rs.getString("CategoryName"));
				category.setParentId(rs.getInt("ParentId"));
				return category;
			}
		});
	}
	public static void themCategory(Category category) {
		String sql = "insert into category(CategoryName,ParentId) values(?,?)";
		jdbc.update(sql, category.getCategoryName(),category.getParentId());
	}
	public static void main(String[] args) {
		List<Category> dsCategory = docTatCa();
		dsCategory.forEach(cat -> {
			System.out.println(cat.getCategoryName());
		});
		List<Category> dsParent = docParent();
		dsParent.forEach(cat -> {
			System.out.println(cat.getCategoryName());
		});
		Category category = new Category();
		category.setCategoryName("test");
		category.setParentId(1);
		for (int i = 0; i < 10; i++) {
			themCategory(category);
		}
	}
}
