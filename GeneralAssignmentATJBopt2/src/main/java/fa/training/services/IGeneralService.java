package fa.training.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.entites.KhachHang;

public interface IGeneralService<T> {
	List<T> findAll();
	Page<T> findAll(int pageCurrent, int pageSize);
	List<T> findAllByKeyWord(String keyword);
	T findById(String id);
	T save(T t);
	boolean delete(String id);
}
