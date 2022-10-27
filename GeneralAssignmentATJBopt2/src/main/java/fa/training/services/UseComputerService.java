package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.entites.IdSuDungMay;
import fa.training.entites.SuDungMay;
import fa.training.repositories.UseComputerRepository;
import fa.training.repositories.UseServiceRepository;

@Service
@Transactional
public class UseComputerService implements IGeneralService<SuDungMay,IdSuDungMay> {
	@Autowired
	UseComputerRepository useComputerRepository;

	@Override
	@Transactional
	public List<SuDungMay> findAll() {
		return useComputerRepository.findAll();
	}

	@Override
	@Transactional
	public Page<SuDungMay> findAll(int pageCurrent, int pageSize) {
		Pageable pageable = PageRequest.of(pageCurrent - 1, 
											pageSize, 
											Sort.by("ngayBatDauSuDung").descending()
											.and(Sort.by("gioBatDauSuDung").descending()));
		return useComputerRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public List<SuDungMay> findAllByKeyWord(String keyword) {
		return useComputerRepository.findAllByKeyWord(keyword.trim());
	}

	@Override
	@Transactional
	public SuDungMay findById(IdSuDungMay id) {
		return useComputerRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public SuDungMay save(SuDungMay dichVu) {
		return useComputerRepository.save(dichVu);
	}

	@Override
	@Transactional
	public boolean delete(IdSuDungMay id) {
		useComputerRepository.deleteById(id);
		return true;
	}
}
