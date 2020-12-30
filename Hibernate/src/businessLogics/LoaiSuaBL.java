package businessLogics;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.LoaiSua;

public class LoaiSuaBL {
	private static final SessionFactory factory = CSDL.getFactory();
	public static List<LoaiSua> docTatCa(){
		List<LoaiSua> dsls = null;
		try (Session session = factory.openSession()){
			String sql = "select l from LoaiSua l";
			dsls = session.createQuery(sql, LoaiSua.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsls;
	}
	public static LoaiSua docTheoMa(String maLoai) {
		LoaiSua ls = null;
		try (Session session = CSDL.getFactory().openSession()){
			ls = session.get(LoaiSua.class, maLoai);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	public static void them(LoaiSua ls) {
		Session session = CSDL.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(ls);
			tx.commit();
		} catch (Exception e) {
			if(tx!= null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	public static void sua(LoaiSua ls) {
		Session session = CSDL.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(ls);
			tx.commit();
		} catch (Exception e) {
			if(tx!= null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	public static void xoa(String maLoai) {
		Session session = CSDL.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LoaiSua lsx = LoaiSuaBL.docTheoMa(maLoai);
			session.delete(lsx);
			tx.commit();
		} catch (Exception e) {
			if(tx!= null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}	
}