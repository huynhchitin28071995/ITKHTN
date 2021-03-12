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

	private static List<Product> getListByQuery(String sql) {
		ResultSet rs = null;
		List<Product> dsProduct = new ArrayList<Product>();
		try (Connection connection = CSDL.getKetNoi()) {
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				dsProduct.add(buildProduct(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsProduct;

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
		String sql = "SELECT * FROM minishop.Product LIMIT " + start + "," + numOfProductPerPage;
		return getListByQuery(sql);

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

	public static int count(String searchInput) {
		String sql = "SELECT COUNT(*) AS Total FROM MiniShop.Product WHERE Title LIKE '%" + searchInput + "%'";
		int total = 0;
		try (ResultSet rs = getDataByQuery(sql)) {
			rs.next();
			total = rs.getInt("Total");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public static Product getProductById(int productId) {
		String sql = "SELECT * FROM Minishop.Product WHERE ProductId = " + productId;
		return getListByQuery(sql).get(0);
	}

	public static List<Product> searchProduct(String searchInput, int start, int numOfProductPerPage) {
		String sql = "SELECT * FROM MiniShop.Product WHERE Title LIKE '%" + searchInput + "%' LIMIT " + start + ","
				+ numOfProductPerPage;
		return getListByQuery(sql);

	}

}
