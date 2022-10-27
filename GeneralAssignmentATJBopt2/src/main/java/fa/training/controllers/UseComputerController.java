package fa.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.entites.SuDungMay;
import fa.training.services.IGeneralService;
import fa.training.entites.May;
import fa.training.entites.IdSuDungMay;
import fa.training.entites.KhachHang;

@Controller
@RequestMapping(value = "/useComputer")
public class UseComputerController {
	@Autowired
	IGeneralService<SuDungMay, IdSuDungMay> useComputerService;
	
	@Autowired
	IGeneralService<KhachHang, String> customerService;
	
	@Autowired
	IGeneralService<May, String> computerService;
	
	@ModelAttribute("useComputer")
	public SuDungMay getUseComputerObject() {
		return new SuDungMay();
	}

	@GetMapping(value = "")
	public String list(Model model) {
		return listOfPage(model, 1);
	}

	@GetMapping("/{currentPage}")
	public String listOfPage(Model model, @PathVariable(name = "currentPage") int currentPage) {
		System.out.println(currentPage);
		int pageSize = 5;
		Page<SuDungMay> page = useComputerService.findAll(currentPage, pageSize);
		List<SuDungMay> useComputers = page.getContent();
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("useComputers", useComputers);
		return "useComputer/list";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("customers", customerService.findAll());
		model.addAttribute("computers", computerService.findAll());
		return "useComputer/add";
	}
	
	@GetMapping(value = "/add/{maMay}")
	public String add2(Model model,@PathVariable String maMay) {
		model.addAttribute("customers", customerService.findAll());
		model.addAttribute("computers", computerService.findAll());
		model.addAttribute("useComputer", new SuDungMay(maMay));
		return "useComputer/add";
	}
	
	@PostMapping(value = "/saveAdd")
	public String saveAdd(@ModelAttribute(name = "useComputer") SuDungMay newUseComputer, RedirectAttributes attributes) {
		IdSuDungMay idNewUseComputer = new IdSuDungMay(newUseComputer.getMaKH(),newUseComputer.getMaMay(),newUseComputer.getNgayBatDauSuDung(),newUseComputer.getGioBatDauSuDung());
		Optional<SuDungMay> useComputer = Optional.ofNullable(useComputerService.findById(idNewUseComputer));
		if (useComputer.isPresent()) {
			attributes.addFlashAttribute("messageError", "Id" + idNewUseComputer.toString() + " đã bị trùng");
			attributes.addFlashAttribute("useComputer", newUseComputer);
			return "redirect:/useComputer/add";
		}
		//Edit may		
		May may = computerService.findById(newUseComputer.getMaMay());
		may.setTrangThai("Dang dung");
		computerService.save(may);
		//Save newUseComputer
		useComputerService.save(newUseComputer);
		attributes.addFlashAttribute("messageSuccess", "Đăng ký sử dụng máy thành công");
		return "redirect:/useComputer/1";
	}

	@GetMapping(value = "/edit/{maKH}/{maMay}/{ngayBatDauSuDung}/{gioBatDauSuDung}")
	public String edit(Model model, @PathVariable String maKH, @PathVariable String maMay, @PathVariable String ngayBatDauSuDung, @PathVariable String gioBatDauSuDung) {
		IdSuDungMay id = new IdSuDungMay(maKH, maMay, ngayBatDauSuDung, gioBatDauSuDung);
		Optional<SuDungMay> useComputer = Optional.ofNullable(useComputerService.findById(id));
		if (useComputer.isPresent()) {
			System.out.println("useComputer" + useComputer.get().toString());
			model.addAttribute("useComputer", useComputer.get());
			return "useComputer/edit";
		} else {
			System.out.println("Không tìm thấy");
			return listOfPage(model, 1);
		}
	}

	@PostMapping(value = "/saveEdit")
	public String saveEdit(@ModelAttribute(name = "useComputer") SuDungMay editUseComputer, RedirectAttributes attributes) {
		IdSuDungMay idEditUseComputer = new IdSuDungMay(editUseComputer.getMaKH(),editUseComputer.getMaMay(),editUseComputer.getNgayBatDauSuDung(),editUseComputer.getGioBatDauSuDung());
		Optional<SuDungMay> useComputer = Optional.ofNullable(useComputerService.findById(idEditUseComputer));
		if (useComputer.isPresent()) {
			SuDungMay useComputerSuccess = useComputerService.save(editUseComputer);
			attributes.addFlashAttribute("messageSuccess", "Sửa sử dụng máy thành công");
			attributes.addFlashAttribute("useComputer", useComputerSuccess);
			return "redirect:/useComputer/1";
		}
		attributes.addFlashAttribute("messageError", "Id" + idEditUseComputer.toString() + " không tìm thấy");
		return "redirect:/useComputer/edit";
	}

	@GetMapping(value = "/delete/{maKH}/{maMay}/{ngayBatDauSuDung}/{gioBatDauSuDung}/{currentPage}")
	public String delete(Model model, @PathVariable String maKH, @PathVariable String maMay, @PathVariable String ngayBatDauSuDung, @PathVariable String gioBatDauSuDung, @PathVariable int currentPage, RedirectAttributes attributes) {
		IdSuDungMay id = new IdSuDungMay(maKH, maMay, ngayBatDauSuDung, gioBatDauSuDung);
		if(useComputerService.delete(id)) {
			attributes.addFlashAttribute("messageSuccess", "Huỷ đăng ký thành công");
		}
		return "redirect:/useComputer/" + currentPage;
	}

	@GetMapping("/search")
	public String search(@RequestParam String search, Model model) {
		System.out.println(search);
		if(!search.equals("")) {
			List<SuDungMay> useComputers = useComputerService.findAllByKeyWord(search);
			model.addAttribute("useComputers", useComputers);
			model.addAttribute("search", search);
			return "useComputer/list";
		}
		return list(model);
	}
}
