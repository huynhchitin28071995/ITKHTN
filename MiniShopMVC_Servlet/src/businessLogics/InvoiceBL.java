package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import models.Invoice;
import models.InvoiceDetail;

public class InvoiceBL {
	private int[] add(List<InvoiceDetail> list) {
		try (Connection connection = CSDL.getKetNoi()) {
			PreparedStatement pstm = connection
					.prepareStatement("INSERT INTO InvoiceDetail(InvoiceId,ProductId,Quantity,Price) VALUES(?,?,?,?)");
			for (InvoiceDetail invoiceDetail : list) {
				pstm.setLong(1, invoiceDetail.getId());
				pstm.setInt(2, invoiceDetail.getProductId());
				pstm.setShort(3, invoiceDetail.getQuantity());
				pstm.setInt(4, invoiceDetail.getPrice());
				pstm.addBatch();
			}

			return pstm.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int addToDatabase(Invoice invoice) throws SQLException {
		try (Connection connection = CSDL.getKetNoi()) {
			PreparedStatement pstm = connection
					.prepareStatement("INSERT INTO Invoice(InvoiceId,UserId,Email,Tel,Address) VALUES(?,?,?,?,?)");
			pstm.setLong(1, invoice.getId());
			pstm.setObject(2, invoice.getMemberId());
			pstm.setString(3, invoice.getEmail());
			pstm.setString(4, invoice.getTel());
			pstm.setString(5, invoice.getAddress());
			return pstm.executeUpdate();
		}

	}
}
