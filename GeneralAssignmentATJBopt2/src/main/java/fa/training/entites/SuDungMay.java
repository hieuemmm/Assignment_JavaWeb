package fa.training.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@IdClass(fa.training.entites.SuDungMay.IdClassSuDungMay.class)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maMay", insertable  = false, updatable  = false)
	private May may;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maKH", insertable  = false, updatable  = false)
	private KhachHang khachHang;
	
	private class IdClassSuDungMay implements Serializable {
		private static final long serialVersionUID = 1L;
		private String maKH;
		private String maMay;
		private String ngayBatDauSuDung;
		private String gioBatDauSuDung;
	}
}
