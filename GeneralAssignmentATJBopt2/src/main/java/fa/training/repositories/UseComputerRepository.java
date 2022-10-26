package fa.training.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.entites.IdSuDungMay;
import fa.training.entites.SuDungMay;

@Repository
public interface UseComputerRepository extends JpaRepository<SuDungMay, IdSuDungMay>{
	@Query(value = 
			"SELECT sdm FROM SuDungMay sdm "
			+ "WHERE sdm.maKH LIKE %?1% "
			+ "OR sdm.maMay LIKE %?1% "
			+ "OR sdm.ngayBatDauSuDung LIKE %?1% "
			+ "OR sdm.gioBatDauSuDung LIKE %?1% "
			+ "OR sdm.thoiGianSuDung LIKE %?1% ")
	List<SuDungMay> findAllByKeyWord(String keyword);
}
