package fa.training.entites;

import java.io.Serializable;

public class IdSuDungDichVu implements Serializable{
	private static final long serialVersionUID = 2L;
	private String maKH;
	private String maDV;
	private String ngaySuDung;
	private String gioSuDung;

	public IdSuDungDichVu() {
	}

	public IdSuDungDichVu(String maKH, String maDV, String ngaySuDung, String gioSuDung) {
		super();
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
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

	@Override
	public String toString() {
		return "IdSuDungDichVu [maKH=" + maKH + ", maDV=" + maDV + ", ngaySuDung=" + ngaySuDung + ", gioSuDung="
				+ gioSuDung + "]";
	}
}
