package entity;
// Generated Dec 10, 2020 10:37:40 AM by Hibernate Tools 5.1.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * KhachHang generated by hbm2java
 */
@Entity
@Table(name = "khach_hang", catalog = "qlbansua")
public class KhachHang implements java.io.Serializable {

	private String maKhachHang;
	private String tenKhachHang;
	private boolean phai;
	private String diaChi;
	private String dienThoai;
	private String email;
	private Set<HoaDon> hoaDons = new HashSet<HoaDon>(0);

	public KhachHang() {
	}

	public KhachHang(String maKhachHang, String tenKhachHang, boolean phai, String diaChi, String dienThoai,
			String email) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.phai = phai;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
	}

	public KhachHang(String maKhachHang, String tenKhachHang, boolean phai, String diaChi, String dienThoai,
			String email, Set<HoaDon> hoaDons) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.phai = phai;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.hoaDons = hoaDons;
	}

	@Id

	@Column(name = "Ma_khach_hang", unique = true, nullable = false, length = 5)
	public String getMaKhachHang() {
		return this.maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	@Column(name = "Ten_khach_hang", nullable = false, length = 100)
	public String getTenKhachHang() {
		return this.tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	@Column(name = "Phai", nullable = false)
	public boolean isPhai() {
		return this.phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	@Column(name = "Dia_chi", nullable = false, length = 200)
	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Column(name = "Dien_thoai", nullable = false, length = 20)
	public String getDienThoai() {
		return this.dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	@Column(name = "Email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khachHang")
	public Set<HoaDon> getHoaDons() {
		return this.hoaDons;
	}

	public void setHoaDons(Set<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

}
