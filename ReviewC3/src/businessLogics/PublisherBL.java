package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Publisher;

public class PublisherBL {
	private static ResultSet rs;

	private static List<Publisher> dsPublisher;

	public static List<Publisher> getPublishers() {
		dsPublisher = new ArrayList<Publisher>();
		try (Connection connection = CSDL.getKetNoi()) {
			Statement stm = connection.createStatement();
			rs = stm.executeQuery("SELECT * FROM minishop.publisher");
			while (rs.next()) {
				Publisher p = new Publisher.Builder().publisherId(rs.getInt("PublisherId"))
						.publisherName(rs.getString("PublisherName")).build();
				dsPublisher.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPublisher;

	}

}
