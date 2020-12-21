package javaBeans;

import java.io.Serializable;

public class LoaiSua implements Serializable{
	private String tenLoai;
	private String maLoai;
	public LoaiSua() {
	
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	
}
