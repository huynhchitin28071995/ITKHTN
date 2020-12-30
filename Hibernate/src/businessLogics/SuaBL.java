package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Sua;

public class SuaBL {
	private static final SessionFactory factory = CSDL.getFactory();
	public static List<Sua> docTatCa(){
		List<Sua> ds = null;
		try(Session session = (Session) factory.openSession()) {
			String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua";
			ds =  session.createQuery(sql, Sua.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public static List<Sua> docTheoMaLoai(String maLoai){
		List<Sua> ds = null;
		try(Session session = (Session) factory.openSession()) {
			String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua where s.loaiSua.maLoaiSua = :maLoai";
			ds =  session.createQuery(sql, Sua.class)
				  .setParameter("maLoai",maLoai)
				  .list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public static List<Sua> docTheoLoaiHangTen(String maLoai, String maHang, String tenSua){
		List<Sua> ds = null;
		try(Session session = (Session) factory.openSession()) {
			String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua where s.loaiSua.maLoaiSua = :maLoai and s.hangSua.maHangSua = :maHang and s.tenSua like :tenSua";
			ds =  session.createQuery(sql, Sua.class)
				  .setParameter("maLoai",maLoai)
				  .setParameter("maHang", maHang)
				  .setParameter("tenSua", "%"+tenSua+"%")
				  .list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public static List<Sua> suaGiaCao(int top){
		List<Sua> ds = null;
		try(Session session = (Session) factory.openSession()) {
			String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua order by s.donGia desc";
			ds =  session.createQuery(sql, Sua.class)
				  .setFirstResult(0)
				  .setMaxResults(top)
				  .list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds; 
	}

	public static void main(String[] args) {
		List<Sua> ds = SuaBL.docTatCa();
		for(Sua s:ds)
			System.out.println(s.getTenSua());
	}
}