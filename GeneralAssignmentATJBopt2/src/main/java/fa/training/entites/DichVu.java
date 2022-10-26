package fa.training.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;

@Entity
public class DichVu {
	@Id
	private String maDV;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenDV;
	@Column(columnDefinition = "nvarchar(255)")
	private String donViTinh;
	private int donGia;
	private String hinhAnh;

	@OneToMany(mappedBy = "maDV")
	private List<SuDungDichVu> suDungDichVus;

	public DichVu() {
	}

	public DichVu(String maDV, String tenDV, String donViTinh, int donGia, String hinhAnh) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
		this.hinhAnh = hinhAnh;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public List<SuDungDichVu> getSuDungDichVus() {
		return suDungDichVus;
	}

	public void setSuDungDichVus(List<SuDungDichVu> suDungDichVus) {
		this.suDungDichVus = suDungDichVus;
	}

	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", donViTinh=" + donViTinh + ", donGia=" + donGia
				+ ", hinhanh=" + hinhAnh + ", suDungDichVus=" + suDungDichVus + "]";
	}
}
