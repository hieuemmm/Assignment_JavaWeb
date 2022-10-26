package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.entites.DichVu;
import fa.training.repositories.ServiceRepository;

@Service
@Transactional
public class ServiceService implements IGeneralService<DichVu,String> {
	@Autowired
	ServiceRepository serviceRepository;

	@Override
	@Transactional
	public List<DichVu> findAll() {
		return serviceRepository.findAll();
	}

	@Override
	@Transactional
	public Page<DichVu> findAll(int pageCurrent, int pageSize) {
		Pageable pageable = PageRequest.of(pageCurrent - 1, pageSize, Sort.by("maDV").ascending());
		return serviceRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public List<DichVu> findAllByKeyWord(String keyword) {	
		return serviceRepository.findAllByKeyWord(keyword.trim());
	}

	@Override
	@Transactional
	public DichVu findById(String id) {
		return serviceRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DichVu save(DichVu dichVu) {
		return serviceRepository.save(dichVu);
	}

	@Override
	@Transactional
	public boolean delete(String id) {
		serviceRepository.deleteById(id);
		return true;
	}
}
