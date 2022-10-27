package fa.training.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fa.training.dto.IAllDetailDTO;
import fa.training.repositories.AllDetailRepository;

@Service
public class AllDetailService {
	@Autowired
	AllDetailRepository allDetailRepository;

	public List<IAllDetailDTO> getAllDetail(int currentPage, int pageSize) {
		List<IAllDetailDTO> alls = allDetailRepository.getAllDetail((currentPage - 1) * pageSize, pageSize);
		return alls;
	}

	public List<IAllDetailDTO> getAllDetail_All(int currentPage, int pageSize, boolean statusPayment) {
		List<IAllDetailDTO> alls = allDetailRepository.getAllDetail_All((currentPage - 1) * pageSize, pageSize, statusPayment);
		return alls;
	}
}
