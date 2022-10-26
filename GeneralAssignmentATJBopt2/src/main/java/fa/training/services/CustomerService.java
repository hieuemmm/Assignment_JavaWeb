package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.entites.KhachHang;
import fa.training.repositories.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerService implements IGeneralService<KhachHang> {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	@Transactional
	public List<KhachHang> findAll() {
		return customerRepository.findAll();
	}
	
	@Override
	@Transactional
	public Page<KhachHang> findAll(int pageCurrent, int pageSize) {
		Pageable pageable = PageRequest.of(pageCurrent - 1, pageSize, Sort.by("maKH").ascending());
		return customerRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public List<KhachHang> findAllByKeyWord(String keyword) {
		return customerRepository.findAllByKeyWord(keyword);
	}

	@Override
	@Transactional
	public KhachHang findById(String id) {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public KhachHang save(KhachHang khachHang) {
		return customerRepository.save(khachHang);
	}

	@Override
	@Transactional
	public boolean delete(String id) {
		customerRepository.deleteById(id);
		return true;
	}
}
