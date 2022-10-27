package fa.training.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(IdSuDungMay.class)
public class SuDungMay {
	@Id
	private String maKH;
	@Id
	private String maMay;
	@Id
	private String ngayBatDauSuDung;
	@Id
	private String gioBatDauSuDung;
	private int thoiGianSuDung;
	@Column(nullable = false)
	private boolean trangThaiThanhToan;

	@ManyToOne
	@JoinColumn(name = "maMay", insertable = false, updatable = false)
	private May may;

	@ManyToOne
	@JoinColumn(name = "maKH", insertable = false, updatable = false)
	private KhachHang khachHang;

	public SuDungMay() {
	}

	public SuDungMay(String maMay) {
		this.maMay = maMay;
	}
	public SuDungMay(String maKH, String maMay, String ngayBatDauSuDung, String gioBatDauSuDung, int thoiGianSuDung,
			May may, KhachHang khachHang) {
		super();
		this.maKH = maKH;
		this.maMay = maMay;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung;
		this.thoiGianSuDung = thoiGianSuDung;
		this.may = may;
		this.khachHang = khachHang;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getNgayBatDauSuDung() {
		return ngayBatDauSuDung;
	}

	public void setNgayBatDauSuDung(String ngayBatDauSuDung) {
		this.ngayBatDauSuDung = ngayBatDauSuDung;
	}

	public String getGioBatDauSuDung() {
		return gioBatDauSuDung;
	}

	public void setGioBatDauSuDung(String gioBatDauSuDung) {
		this.gioBatDauSuDung = gioBatDauSuDung;
	}

	public int getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(int thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public May getMay() {
		return may;
	}

	public void setMay(May may) {
		this.may = may;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public boolean isTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

}
