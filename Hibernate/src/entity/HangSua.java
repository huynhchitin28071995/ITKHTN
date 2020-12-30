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
 * HangSua generated by hbm2java
 */
@Entity
@Table(name = "hang_sua", catalog = "qlbansua")
public class HangSua implements java.io.Serializable {

	private String maHangSua;
	private String tenHangSua;
	private String diaChi;
	private String dienThoai;
	private String email;
	private Set<Sua> suas = new HashSet<Sua>(0);

	public HangSua() {
	}

	public HangSua(String maHangSua, String tenHangSua, String diaChi, String dienThoai, String email) {
		this.maHangSua = maHangSua;
		this.tenHangSua = tenHangSua;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
	}

	public HangSua(String maHangSua, String tenHangSua, String diaChi, String dienThoai, String email, Set<Sua> suas) {
		this.maHangSua = maHangSua;
		this.tenHangSua = tenHangSua;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.suas = suas;
	}

	@Id

	@Column(name = "Ma_hang_sua", unique = true, nullable = false, length = 20)
	public String getMaHangSua() {
		return this.maHangSua;
	}

	public void setMaHangSua(String maHangSua) {
		this.maHangSua = maHangSua;
	}

	@Column(name = "Ten_hang_sua", nullable = false, length = 100)
	public String getTenHangSua() {
		return this.tenHangSua;
	}

	public void setTenHangSua(String tenHangSua) {
		this.tenHangSua = tenHangSua;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hangSua")
	public Set<Sua> getSuas() {
		return this.suas;
	}

	public void setSuas(Set<Sua> suas) {
		this.suas = suas;
	}

}
