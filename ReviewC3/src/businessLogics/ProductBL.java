package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Product;

public class ProductBL {
	private static List<Product> dsProduct = new ArrayList<Product>();

	public static List<Product> getProducts() {
		if(dsProduct.isEmpty() ) {
			String sql = "SELECT * FROM minishop.Product";
			try(Connection c = CSDL.getKetNoi()){
				Statement stm = c.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					Product p = new Product.Builder()
							.authorId(rs.getInt("AuthorId"))
							.categoryId(rs.getInt("CategoryId"))
							.content(rs.getString("Content"))
							.description(rs.getString("Description"))
							.imageURL(rs.getString("ImageURL"))
							.isbn(rs.getString("ISBN"))
							.page(rs.getInt("Pages"))
							.price(rs.getInt("Price"))
							.productId(rs.getInt("ProductId"))
							.publisherId(rs.getInt("PublisherId"))
							.size(rs.getString("Size"))
							.title(rs.getString("Title"))
							.weight(rs.getString("Weight"))
							.year(rs.getInt("Year"))
							.build();
					dsProduct.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return dsProduct;
	}
}
