package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.entites.May;
import fa.training.repositories.ComputerRepository;

@Service
@Transactional
public class ComputerService implements IGeneralService<May,String> {
	@Autowired
	ComputerRepository computerRepository;

	@Override
	@Transactional
	public List<May> findAll() {
		return computerRepository.findAll();
	}

	@Override
	public Page<May> findAll(int pageCurrent, int pageSize) {
		Pageable pageable = PageRequest.of(pageCurrent - 1, pageSize, Sort.by("maMay").ascending());
		return computerRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public List<May> findAllByKeyWord(String keyword) {
		return computerRepository.findAllByKeyWord(keyword.trim());
	}

	@Override
	@Transactional
	public May findById(String id) {
		return computerRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public May save(May may) {
		return computerRepository.save(may);
	}

	@Override
	@Transactional
	public boolean delete(String id) {
		computerRepository.deleteById(id);
		return true;
	}
}
