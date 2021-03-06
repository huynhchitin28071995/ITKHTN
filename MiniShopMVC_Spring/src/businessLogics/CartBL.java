package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Cart;

public class CartBL {
	static JdbcTemplate jdbc = CSDL.getJdbc();

	public static List<Cart> getCarts(String id) {
		String sql = "CALL GetCarts(?)";
		return jdbc.query(sql, new RowMapper<Cart>() {

			@Override
			public Cart mapRow(ResultSet rs, int numRow) throws SQLException {
				Cart cart = new Cart();
				cart.setId(rs.getString("CartId"));
				cart.setProductId(rs.getInt("ProductId"));
				cart.setTitle(rs.getString("title"));
				cart.setImageUrl(rs.getString("ImageUrl"));
				cart.setPrice(rs.getInt("Price"));
				cart.setQuantity(rs.getShort("quantity"));
				return cart;
			}

		}, id);
	}

	public static int add(Cart c) {
		String sql = "CALL AddCart(?,?,?,?)";
		return jdbc.update(sql, c.getId(), c.getMemberId(), c.getProductId(), c.getQuantity());
	}
}
