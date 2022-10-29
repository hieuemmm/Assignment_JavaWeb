package fa.training.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fa.training.entites.May;

@Repository
public interface ComputerRepository extends JpaRepository<May, String>{
	List<May> findByMaMayContains(String maMay);
	List<May> findByTrangThai(boolean trangThai);
	
	@Query(value = "SELECT d FROM May d "
			+ "WHERE d.maMay LIKE ?1% "
			+ "OR d.viTri LIKE ?1% "
			+ "OR d.trangThai LIKE ?1% ")
	List<May> findAllByKeyWord(String keyword);
}
