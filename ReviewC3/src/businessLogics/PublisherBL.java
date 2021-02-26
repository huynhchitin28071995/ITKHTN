package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import models.Publisher;

public class PublisherBL {
	private static ResultSet rs;

	private static List<Publisher> dsPublisher;
	public static List<Publisher> getPublishers() {
		if (dsPublisher == null) {
			dsPublisher = new ArrayList<Publisher>();
			try (Connection connection = CSDL.getKetNoi()) {
				Statement stm = connection.createStatement();
				rs = stm.executeQuery("SELECT * FROM minishop.Publisher");
				while (rs.next()) {
					Publisher p = new Publisher.Builder().publisherId(rs.getInt("PublisherId"))
							.publisherName(rs.getString("PublisherName")).build();
					dsPublisher.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			System.out.println("Da lay danh sach Publisher");
		}
//		System.out.println("Ds Publisher da co san!");
		return dsPublisher;
	}

	public static void addPublisher(Publisher p) {
		try (Connection c = CSDL.getKetNoi()) {
			String sql = "INSERT INTO minishop.Publisher(PublisherName) VALUES(?)";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, p.getPublisherName());
			
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		dsPublisher = null;
		System.out.println("Added " + p.toString());
	}

	public static Publisher getPublisher(int publisherId) {
		if (dsPublisher == null) {
			for(Publisher p: getPublishers()) {
				if (p.getPublisherId() == publisherId) {
					return p;
				}
			}
		} else {
			for(Publisher p: dsPublisher) {
				if (p.getPublisherId() == publisherId) {
					return p;
				}
			}
		}
		return null;
	}
	
	public static void editPublisher(int publisherId, String newPublisherName) {
		Publisher p = getPublisher(publisherId); 
		if (p != null) {
			String sql = "UPDATE minishop.Publisher SET PublisherName=? WHERE PublisherId=?";
			try(Connection c = CSDL.getKetNoi()){
				PreparedStatement pstm = c.prepareStatement(sql);
				pstm.setString(1,newPublisherName);
				pstm.setInt(2, p.getPublisherId());
				pstm.execute(); //potentially bugged when new publisher added/edited to DB but not dsPublisher.
				dsPublisher.add(new Publisher.Builder().publisherId(publisherId).publisherName(newPublisherName).build());
				dsPublisher.remove(p);
				System.out.println("Edited " + p.toString() + " To new Publisher");
				p = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean deletePublisher(int publisherId) {
		String sql = "DELETE FROM minishop.Publisher WHERE PublisherId = ?";
		try(Connection c = CSDL.getKetNoi()) {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, publisherId);
			dsPublisher.remove(getPublisher(publisherId));
			return pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean multiDels(List<Integer> publisherIds) {
		for (int i : publisherIds) {
			deletePublisher(i);
		}
		return true;
		
	}
}
