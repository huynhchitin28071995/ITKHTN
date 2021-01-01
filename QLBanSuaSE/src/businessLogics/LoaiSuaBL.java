package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.LoaiSua;

public class LoaiSuaBL {
	private static final SessionFactory factory = CSDL.getFactory();

	public static List<LoaiSua> docLoaiSua() {

		List<LoaiSua> dsLoaiSua = null;
		try (Session session = factory.openSession()) {
			// dsLoaiSua = session.createQuery(sql, LoaiSua.class).setParameter("dsLoaiSua",
			// dsLoaiSua).list();
			String sql = "select ls from LoaiSua ls";
			dsLoaiSua = session.createQuery(sql, LoaiSua.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsLoaiSua;
	}

	public static LoaiSua timLoaiSua(String maLoai) {
		LoaiSua loaiSua = null;
		try (Session session = factory.openSession()) {
			loaiSua = session.get(LoaiSua.class, maLoai);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loaiSua;
	}
}
