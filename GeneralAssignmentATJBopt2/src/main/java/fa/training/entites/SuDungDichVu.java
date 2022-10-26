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
@IdClass(fa.training.entites.SuDungDichVu.IdClassSuDungDichVu.class)
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maKH", insertable  = false, updatable  = false)
	private KhachHang khacHang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maDV", insertable  = false, updatable  = false)
	private DichVu dichVu;
	
	private class IdClassSuDungDichVu implements Serializable {
		private static final long serialVersionUID = 2L;
		private String maKH;
		private String maDV;
		private String ngaySuDung;
		private String gioSuDung;
	}
}
