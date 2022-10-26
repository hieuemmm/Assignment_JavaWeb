package fa.training.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public class KhachHang {
	@Id
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String soDienThoai;
	private String diaChiEmail;

	@OneToMany(mappedBy = "maKH", fetch = FetchType.LAZY)
	private List<SuDungMay> suDungMays;

	@OneToMany(mappedBy = "maKH", fetch = FetchType.LAZY)
	private List<SuDungDichVu> suDungDichVus;

	public KhachHang() {
	}

	public KhachHang(String maKH, String tenKH, String diaChi, String soDienThoai, String diaChiEmail,
			List<SuDungMay> suDungMays, List<SuDungDichVu> suDungDichVus) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.diaChiEmail = diaChiEmail;
		this.suDungMays = suDungMays;
		this.suDungDichVus = suDungDichVus;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChiEmail() {
		return diaChiEmail;
	}

	public void setDiaChiEmail(String diaChiEmail) {
		this.diaChiEmail = diaChiEmail;
	}

	public List<SuDungMay> getSuDungMays() {
		return suDungMays;
	}

	public void setSuDungMays(List<SuDungMay> suDungMays) {
		this.suDungMays = suDungMays;
	}

	public List<SuDungDichVu> getSuDungDichVus() {
		return suDungDichVus;
	}

	public void setSuDungDichVus(List<SuDungDichVu> suDungDichVus) {
		this.suDungDichVus = suDungDichVus;
	}
}
