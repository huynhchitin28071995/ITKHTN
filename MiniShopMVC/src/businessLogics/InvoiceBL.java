package businessLogics;

import org.springframework.jdbc.core.JdbcTemplate;

import javaBeans.NewInvoice;

public class InvoiceBL {
	static JdbcTemplate jdbc = CSDL.getJdbc();

	public static int add(NewInvoice obj) {
		return jdbc.update("CALL AddInvoice(?, ?, ?, ?, ?)", obj.getId(), obj.getMemberId(), obj.getEmail(),
				obj.getTel(), obj.getAddress());
	}
}
