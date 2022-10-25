package fa.training.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class KhacHang {
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
}
