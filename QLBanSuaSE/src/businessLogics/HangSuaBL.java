package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.HangSua;

public class HangSuaBL {
	private static final SessionFactory factory = CSDL.getFactory();

	public static List<HangSua> docHangSua() {
		List<HangSua> dsHangSua = null;
		try (Session session = factory.openSession()) {
			// dsHangSua = session.createQuery(sql, HangSua.class).setParameter("dsHangSua",
			// dsHangSua).list();
			String sql = "select hs from HangSua hs";
			dsHangSua = session.createQuery(sql, HangSua.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHangSua;
	}

	public static HangSua timHangSua(String maHang) {
		HangSua hangSua = null;
		try (Session session = factory.openSession()) {
			hangSua = session.get(HangSua.class, maHang);
		}
		return hangSua;
	}
}
