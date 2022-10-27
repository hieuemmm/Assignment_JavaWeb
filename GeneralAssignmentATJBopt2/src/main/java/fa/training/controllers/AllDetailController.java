package fa.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.dto.IAllDetailDTO;
import fa.training.entites.IdSuDungMay;
import fa.training.entites.KhachHang;
import fa.training.entites.May;
import fa.training.entites.SuDungMay;
import fa.training.services.AllDetailService;
import fa.training.services.CustomerService;
import fa.training.services.IGeneralService;

@Controller
@RequestMapping(value = "/allDetail")
public class AllDetailController {
	@Autowired
	AllDetailService allDetailService;
	@Autowired
	IGeneralService<SuDungMay, IdSuDungMay> useComputerService;;

	@GetMapping(value = "")
	public String list(Model model) {
		return allToDayOnline(model, 1);
	}
	
	@GetMapping(value = "/allHistory/{currentPage}")
	public String allHistory(Model model, @PathVariable(name = "currentPage") int currentPage) {
		int pageSize = 20;
		List<IAllDetailDTO> allDetail = allDetailService.getAllDetail_All(currentPage, pageSize, true);
		System.out.println(allDetail.size());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", 3);
		allDetail.forEach(el -> System.out.println(el.isTrangThaiThanhToan()));
		model.addAttribute("allDetail", allDetail);
		model.addAttribute("modeShow", "allHistory");
		return "allDetail/allHistory";
	}

	@GetMapping(value = "/allToDayOnline/{currentPage}")
	public String allToDayOnline(Model model, @PathVariable(name = "currentPage") int currentPage) {
		int pageSize = 20;
		List<IAllDetailDTO> allDetail = allDetailService.getAllDetail_All(currentPage, pageSize, false);
		allDetail.forEach(System.out::print);
		System.out.println(allDetail.size());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", 3);
		model.addAttribute("allDetail", allDetail);
		model.addAttribute("modeShow", "allToDayOnline");
		return "allDetail/allHistory";
	}

	@GetMapping(value = "/checkOut/{maKH}/{maMay}/{ngayBatDauSuDung}/{gioBatDauSuDung}/{currentPage}")
	public String CheckOut(RedirectAttributes attributes, @PathVariable String maKH, @PathVariable String maMay,
			@PathVariable String ngayBatDauSuDung, @PathVariable String gioBatDauSuDung,
			@PathVariable int currentPage) {
		System.out.println("Im here");
		IdSuDungMay id = new IdSuDungMay(maKH, maMay, ngayBatDauSuDung, gioBatDauSuDung);
		Optional<SuDungMay> useComputer = Optional.ofNullable(useComputerService.findById(id));
		if (useComputer.isPresent()) {
			useComputer.get().setTrangThaiThanhToan(true);
			useComputerService.save(useComputer.get());
			attributes.addFlashAttribute("messageSuccess", "CheckOut thành công!");
		}
		return "redirect:/allDetail/allToDayOnline/" + currentPage;
	}
}
