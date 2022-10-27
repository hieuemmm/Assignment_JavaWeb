package fa.training.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(IdSuDungDichVu.class)
public class SuDungDichVu {
	@Id
	private String maKH;
	@Id
	private String maDV;
	@Id
	private String ngaySuDung;
	@Id
	private String gioSuDung;
	private int soLuong;

	@ManyToOne
	@JoinColumn(name = "maKH", insertable = false, updatable = false)
	private KhachHang khacHang;

	@ManyToOne
	@JoinColumn(name = "maDV", insertable = false, updatable = false)
	private DichVu dichVu;

	public SuDungDichVu() {
	}

	public SuDungDichVu(String maKH) {
		this.maKH = maKH;
	}
	public SuDungDichVu(String maKH, String maDV, String ngaySuDung, String gioSuDung, int soLuong, KhachHang khacHang,
			DichVu dichVu) {
		super();
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.soLuong = soLuong;
		this.khacHang = khacHang;
		this.dichVu = dichVu;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(String ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public String getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(String gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public KhachHang getKhacHang() {
		return khacHang;
	}

	public void setKhacHang(KhachHang khacHang) {
		this.khacHang = khacHang;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
}
