package fa.training.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.entites.IdSuDungDichVu;
import fa.training.entites.SuDungDichVu;

@Repository
public interface UseServiceRepository extends JpaRepository<SuDungDichVu, IdSuDungDichVu>{
	@Query(value = 
			"SELECT sddv FROM SuDungDichVu sddv "
			+ "WHERE sddv.maDV LIKE %?1% "
			+ "OR sddv.maKH LIKE %?1% "
			+ "OR sddv.maDV LIKE %?1% "
			+ "OR sddv.ngaySuDung LIKE %?1% "
			+ "OR sddv.gioSuDung LIKE %?1% "
			+ "OR sddv.soLuong LIKE %?1% ")
	List<SuDungDichVu> findAllByKeyWord(String keyword);
}
