package fa.training.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.entites.DichVu;

@Repository
public interface ServiceRepository extends JpaRepository<DichVu, String>{
	@Query(value = "SELECT dv FROM DichVu dv "
			+ "WHERE dv.maDV LIKE %?1% "
			+ "OR dv.tenDV LIKE %?1% "
			+ "OR dv.donViTinh LIKE %?1% "
			+ "OR dv.donGia LIKE %?1% "
			+ "OR dv.hinhAnh LIKE %?1% ")
	List<DichVu> findAllByKeyWord(String keyword);
}
