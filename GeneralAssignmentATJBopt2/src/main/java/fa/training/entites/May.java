package fa.training.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;

@Entity
public class May {
	@Id
	private String maMay;
	private String viTri;
	private String trangThai;
	@OneToMany(mappedBy = "maMay", fetch = FetchType.LAZY)
	private List<SuDungMay> suDungMays;

	public May() {
	}

	public May(String maMay, String viTri, String trangThai, List<SuDungMay> suDungMays) {
		super();
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
		this.suDungMays = suDungMays;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public List<SuDungMay> getSuDungMays() {
		return suDungMays;
	}

	public void setSuDungMays(List<SuDungMay> suDungMays) {
		this.suDungMays = suDungMays;
	}

	
	@Override
	public String toString() {
		return "May [maMay=" + maMay + ", viTri=" + viTri + ", trangThai=" + trangThai + "]";
	}
}