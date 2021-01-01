package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Sua;

public class SuaBL {
	private static final SessionFactory factory = CSDL.getFactory();

	public static List<Sua> docSua() {

		List<Sua> dsSua = null;
		try (Session session = factory.openSession()) {
			String sql = "select s from Sua s";
			dsSua = session.createQuery(sql, Sua.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSua;
	}

	public static List<Sua> docSuaTheoMaLoai(String maLoai) {

		List<Sua> dsSua = null;
		try (Session session = factory.openSession()) {
			String sql = "select s from Sua s where s.loaiSua.maLoaiSua = '" + maLoai + "'";
			dsSua = session.createQuery(sql, Sua.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSua;
	}

	public static List<Sua> docSuaTheoMaHang(String maHang) {

		List<Sua> dsSua = null;
		try (Session session = factory.openSession()) {
			String sql = "select s from Sua s where s.loaiSua.maLoaiSua = '" + maHang + "'";
			dsSua = session.createQuery(sql, Sua.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSua;
	}

	public static void themSua(Sua sua) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(sua);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
