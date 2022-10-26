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

import fa.training.entites.KhachHang;
import fa.training.entites.May;

@Repository
public interface CustomerRepository extends JpaRepository<KhachHang, String>{
	@Query(value = "SELECT kh FROM KhachHang kh "
			+ "WHERE kh.maKH LIKE %?1% "
			+ "OR kh.diaChi LIKE %?1% "
			+ "OR kh.soDienThoai LIKE %?1% "
			+ "OR kh.diaChiEmail LIKE %?1% ")
	List<KhachHang> findAllByKeyWord(String keyword);
}
