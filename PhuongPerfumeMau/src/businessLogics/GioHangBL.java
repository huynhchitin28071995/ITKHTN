package businessLogics;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javaBeans.SanPham;
import javaBeans.SanPhamMua;

public class GioHangBL {
	private Hashtable<Integer,Integer> dsh; //key: idsp, value: so luong mua
	public GioHangBL() {
		dsh = new Hashtable<>();
	}
	public void them(int idsp, int slm) {
		if(dsh.containsKey(idsp))
			dsh.replace(idsp, dsh.get(idsp)+slm);
		else
			dsh.put(idsp, slm);
	}
	public int soMatHang() {
		return dsh.size();
	}
	public double tongTien() {
		double tt=0;
		for(int idsp:dsh.keySet()) {
			SanPham sp = SanPhamBL.docTheoID(idsp);
			tt += sp.getDonGiaKM() * dsh.get(idsp);
		}
		return tt;
	}
	public List<SanPhamMua> danhSachSanPhamMua() {
		List<SanPhamMua> dsspm = new ArrayList<>();
		for(int idsp: dsh.keySet()) {
			SanPham sp = SanPhamBL.docTheoID(idsp);
			SanPhamMua spm = new SanPhamMua();
			spm.setId(sp.getId());
			spm.setTenSanPham(sp.getTenSanPham());
			spm.setMoTa(sp.getMoTa());
			spm.setHinhAnh(sp.getHinhAnh());
			spm.setDonGia(sp.getDonGia());
			spm.setDonGiaKM(sp.getDonGiaKM());
			spm.setHienThi(sp.getHienThi());
			spm.setId_loai(sp.getId_loai());
			spm.setNgayTao(sp.getNgayTao());
			spm.setId_thuongHieu(sp.getId_thuongHieu());
			spm.setSoLuong(sp.getSoLuong());
			spm.setSoLuongMua(dsh.get(idsp));
			dsspm.add(spm);
		}
		return dsspm;
		
	}
}
