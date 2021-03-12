package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Product;

public class ProductBL {
//	private static List<Product> dsProduct = new ArrayList<Product>(); //will require longer load time or massive memory up-front
	private static Connection connection;

	private static ResultSet getDataByQuery(String sql) {
		ResultSet rs = null;
		connection = CSDL.getKetNoi();
		try {
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	private static Product buildProduct(ResultSet rs) {
		try {
			Product p = new Product.Builder().authorId(rs.getInt("AuthorId")).categoryId(rs.getInt("CategoryId"))
					.content(rs.getString("Content")).description(rs.getString("Description"))
					.imageURL(rs.getString("ImageURL")).isbn(rs.getString("ISBN")).page(rs.getInt("Pages"))
					.price(rs.getInt("Price")).productId(rs.getInt("ProductId")).publisherId(rs.getInt("PublisherId"))
					.size(rs.getString("Size")).title(rs.getString("Title")).weight(rs.getString("Weight"))
					.year(rs.getInt("Year")).build();
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Product> getProducts(int start, int numOfProductPerPage) {
		List<Product> dsProduct = new ArrayList<Product>();
		String sql = "SELECT * FROM minishop.Product LIMIT " + start + "," + numOfProductPerPage;

		try (ResultSet rs = getDataByQuery(sql);) {
			while (rs.next()) {
				dsProduct.add(buildProduct(rs));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsProduct;

	}

	public static int count() {
		String sql = "SELECT COUNT(*) AS Total FROM MiniShop.Product";

		try (ResultSet rs = getDataByQuery(sql)) {
			if (rs.next()) {
				int total = rs.getInt("Total");
				connection.close();
				return total;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static Product getProductById(int productId) {
		String sql = "SELECT * FROM Minishop.Product WHERE ProductId = " + productId;
		getDataByQuery(sql);
		try (ResultSet rs = getDataByQuery(sql)) {
			if (rs.next()) {
				Product p = buildProduct(rs);
				connection.close();
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
