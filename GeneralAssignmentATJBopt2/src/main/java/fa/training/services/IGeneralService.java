package fa.training.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.entites.KhachHang;

public interface IGeneralService<T,K> {
	List<T> findAll();
	Page<T> findAll(int pageCurrent, int pageSize);
	List<T> findAllByKeyWord(String keyword);
	T findById(K id);
	T save(T t);
	boolean delete(K id);
}
