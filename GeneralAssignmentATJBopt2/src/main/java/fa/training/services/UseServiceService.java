package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.entites.IdSuDungDichVu;
import fa.training.entites.SuDungDichVu;
import fa.training.repositories.UseServiceRepository;

@Service
@Transactional
public class UseServiceService implements IGeneralService<SuDungDichVu,IdSuDungDichVu> {
	@Autowired
	UseServiceRepository useServiceRepository;

	@Override
	@Transactional
	public List<SuDungDichVu> findAll() {
		return useServiceRepository.findAll();
	}

	@Override
	@Transactional
	public Page<SuDungDichVu> findAll(int pageCurrent, int pageSize) {
		Pageable pageable = PageRequest.of(pageCurrent - 1, pageSize, Sort.by("maDV").ascending());
		return useServiceRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public List<SuDungDichVu> findAllByKeyWord(String keyword) {
		return useServiceRepository.findAllByKeyWord(keyword.trim());
	}

	@Override
	@Transactional
	public SuDungDichVu findById(IdSuDungDichVu id) {
		return useServiceRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public SuDungDichVu save(SuDungDichVu dichVu) {
		return useServiceRepository.save(dichVu);
	}

	@Override
	@Transactional
	public boolean delete(IdSuDungDichVu id) {
		useServiceRepository.deleteById(id);
		return true;
	}
}
