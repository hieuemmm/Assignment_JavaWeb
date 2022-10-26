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
@Data
@Builder
public class DichVu {
	@Id
	private String maDV;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenDV;
	@Column(columnDefinition = "nvarchar(255)")
	private String donViTinh;
	private double donGia;
	
	@OneToMany(mappedBy = "maDV", fetch = FetchType.LAZY)
	private List<SuDungDichVu> suDungDichVus;
}
