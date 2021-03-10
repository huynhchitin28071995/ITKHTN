package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Product;

public class ProductBL {
//	private static List<Product> dsProduct = new ArrayList<Product>(); //will require longer load time or massive memory up-front

//	private static Map<Integer, Product> mapProduct = new HashMap<Integer, Product>();
	public static List<Product> getProducts(int start, int numOfProductPerPage) {
//		if (dsProduct.isEmpty()) {
//			String sql = "SELECT * FROM minishop.Product";
		List<Product> dsProduct = new ArrayList<Product>();
		String sql = "SELECT * FROM minishop.Product LIMIT ?,?";
		try (Connection c = CSDL.getKetNoi()) {
//				Statement stm = c.createStatement();
			PreparedStatement pstm = c.prepareStatement(sql);
//				ResultSet rs = stm.executeQuery(sql);
			pstm.setInt(1, start);
			pstm.setInt(2, numOfProductPerPage);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Product p = new Product.Builder().authorId(rs.getInt("AuthorId")).categoryId(rs.getInt("CategoryId"))
						.content(rs.getString("Content")).description(rs.getString("Description"))
						.imageURL(rs.getString("ImageURL")).isbn(rs.getString("ISBN")).page(rs.getInt("Pages"))
						.price(rs.getInt("Price")).productId(rs.getInt("ProductId"))
						.publisherId(rs.getInt("PublisherId")).size(rs.getString("Size")).title(rs.getString("Title"))
						.weight(rs.getString("Weight")).year(rs.getInt("Year")).build();
				dsProduct.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsProduct;

	}

	public static int count() {
		String sql = "SELECT COUNT(*) AS Total FROM MiniShop.Product";
		try (Connection connection = CSDL.getKetNoi()) {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("Total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static Product getProductById(int id) {
		return null;
	}
}
