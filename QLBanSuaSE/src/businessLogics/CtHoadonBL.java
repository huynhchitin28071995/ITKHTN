package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.CtHoadon;
import entity.Sua;

public class CtHoadonBL {
	private static final SessionFactory factory = CSDL.getFactory();

	public static List<CtHoadon> docCtHoadon() {
		List<CtHoadon> dsCtHoadon = null;
		try (Session session = factory.openSession()) {
			dsCtHoadon = session.createQuery("select h from CtHoadon h inner join h.sua s", CtHoadon.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCtHoadon;
	}

	public static List<CtHoadon> suaBanChayTheoCtHoadon() {
		List<CtHoadon> dsCtHoadon = null;
		try (Session session = factory.openSession()) {
			dsCtHoadon = session.createQuery("select hd from CtHoadon hd order by hd.soLuong desc ", CtHoadon.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCtHoadon;
	}

	public static List<Sua> docSuaTheoHoadon() {
		List<Sua> dsCtHoadon = null;
		try (Session session = factory.openSession()) {
			dsCtHoadon = session.createQuery("select hd.sua from CtHoadon hd order by hd.soLuong desc", Sua.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCtHoadon;
	}
}
