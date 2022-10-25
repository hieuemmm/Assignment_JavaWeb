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
public class May {
	@Id
	private String maMay;
	private String viTri;
	private String trangThai;
	@OneToMany(mappedBy = "maMay", fetch = FetchType.LAZY)
	private List<SuDungMay> suDungMays;
}
