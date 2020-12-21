package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javaBeans.LoaiSua;

/**
 *
 * @author hv
 */
public class LoaiSuaBL {
    public static List<LoaiSua> docTatCa(){
        List<LoaiSua> dsls = null;
        try (Connection ketNoi = CSDL.getKetNoi()){
            Statement stm = ketNoi.createStatement();
            ResultSet rs = stm.executeQuery("select * from loai_sua");
            dsls = new ArrayList<>();
            while(rs.next()){
                LoaiSua ls = new LoaiSua();
                ls.setMaLoai(rs.getString("ma_loai_sua"));
                ls.setTenLoai(rs.getString("ten_loai"));
                dsls.add(ls);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsls;
    }
    public static LoaiSua docTheoMaLoai(String maLoai){
        LoaiSua ls = null;
        try (Connection ketNoi = CSDL.getKetNoi()){
            Statement stm = ketNoi.createStatement();
            ResultSet rs = stm.executeQuery("select * from loai_sua where ma_loai_sua = '"+maLoai+"'");
            while(rs.next()){
                ls = new LoaiSua();
                ls.setMaLoai(rs.getString("ma_loai_sua"));
                ls.setTenLoai(rs.getString("ten_loai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    public static int them(LoaiSua ls) {
    	int smt =0;
    	String sql = "insert into loai_sua(ma_loai_sua, ten_loai) values (?,?)";
    	try (Connection ketNoi = CSDL.getKetNoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1,ls.getMaLoai());
			pst.setString(2, ls.getTenLoai());
			smt = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return smt;
    }
}