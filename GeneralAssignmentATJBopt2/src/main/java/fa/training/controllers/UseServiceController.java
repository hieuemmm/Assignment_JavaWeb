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

import fa.training.entites.SuDungDichVu;
import fa.training.entites.DichVu;
import fa.training.entites.IdSuDungDichVu;
import fa.training.entites.KhachHang;
import fa.training.services.IGeneralService;

@Controller
@RequestMapping(value = "/useService")
public class UseServiceController {
	@Autowired
	IGeneralService<SuDungDichVu, IdSuDungDichVu> useServiceService;
	
	@Autowired
	IGeneralService<KhachHang, String> customerService;
	
	@Autowired
	IGeneralService<DichVu, String> serviceService;
	
	@ModelAttribute("useService")
	public SuDungDichVu getUseServiceObject() {
		return new SuDungDichVu();
	}

	@GetMapping(value = "")
	public String list(Model model) {
		return listOfPage(model, 1);
	}

	@GetMapping("/{currentPage}")
	public String listOfPage(Model model, @PathVariable(name = "currentPage") int currentPage) {
		System.out.println(currentPage);
		int pageSize = 5;
		Page<SuDungDichVu> page = useServiceService.findAll(currentPage, pageSize);
		List<SuDungDichVu> useServices = page.getContent();
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("useServices", useServices);
		return "useService/list";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("customers", customerService.findAll());
		model.addAttribute("services", serviceService.findAll());
		return "useService/add";
	}
	
	@GetMapping(value = "/add/{maKH}")
	public String add2(Model model, @PathVariable String maKH) {
		model.addAttribute("customers", customerService.findAll());
		model.addAttribute("services", serviceService.findAll());
		model.addAttribute("useService", new SuDungDichVu(maKH));
		return "useService/add";
	}
	
	@PostMapping(value = "/saveAdd")
	public String saveAdd(@ModelAttribute(name = "useService") SuDungDichVu newUseService, RedirectAttributes attributes) {
		IdSuDungDichVu idNewUseService = new IdSuDungDichVu(newUseService.getMaKH(),newUseService.getMaDV(),newUseService.getNgaySuDung(),newUseService.getGioSuDung());
		Optional<SuDungDichVu> useService = Optional.ofNullable(useServiceService.findById(idNewUseService));
		if (useService.isPresent()) {
			attributes.addFlashAttribute("messageError", "Id" + idNewUseService.toString() + " đã bị trùng");
			attributes.addFlashAttribute("useService", newUseService);
			return "redirect:/useService/add";
		}
		SuDungDichVu useServiceSuccess = useServiceService.save(newUseService);
		attributes.addFlashAttribute("messageSuccess", "Đăng ký sử dụng dịch vụ thành công");
		return "redirect:/useService/1";
	}

	@GetMapping(value = "/edit/{maKH}/{maDV}/{ngaySuDung}/{gioSuDung}")
	public String edit(Model model, @PathVariable String maKH, @PathVariable String maDV, @PathVariable String ngaySuDung, @PathVariable String gioSuDung) {
		IdSuDungDichVu id = new IdSuDungDichVu(maKH,maDV,ngaySuDung,gioSuDung);
		Optional<SuDungDichVu> useService = Optional.ofNullable(useServiceService.findById(id));
		if (useService.isPresent()) {
			System.out.println("useService" + useService.get().toString());
			model.addAttribute("useService", useService.get());
			return "useService/edit";
		} else {
			System.out.println("Không tìm thấy");
			return listOfPage(model, 1);
		}
	}

	@PostMapping(value = "/saveEdit")
	public String saveEdit(@ModelAttribute(name = "useService") SuDungDichVu editUseService, RedirectAttributes attributes) {
		IdSuDungDichVu idEditUseService = new IdSuDungDichVu(editUseService.getMaKH(),editUseService.getMaDV(),editUseService.getNgaySuDung(),editUseService.getGioSuDung());
		Optional<SuDungDichVu> useService = Optional.ofNullable(useServiceService.findById(idEditUseService));
		if (useService.isPresent()) {
			SuDungDichVu useServiceSuccess = useServiceService.save(editUseService);
			attributes.addFlashAttribute("messageSuccess", "Sửa sử dụng dịch vụ thành công");
			attributes.addFlashAttribute("useService", useServiceSuccess);
			return "redirect:/useService/1";
		}
		attributes.addFlashAttribute("messageError", "Id" + idEditUseService.toString() + " không tìm thấy");
		return "redirect:/useService/edit";
	}

	@GetMapping(value = "/delete/{maKH}/{maDV}/{ngaySuDung}/{gioSuDung}/{currentPage}")
	public String delete(Model model, @PathVariable String maKH, @PathVariable String maDV, @PathVariable String ngaySuDung, @PathVariable String gioSuDung, @PathVariable int currentPage, RedirectAttributes attributes) {
		IdSuDungDichVu id = new IdSuDungDichVu(maKH,maDV,ngaySuDung,gioSuDung);
		if(useServiceService.delete(id)) {
			attributes.addFlashAttribute("messageSuccess", "Xoá đăng ký " + id.toString() + " thành công");
		}
		return "redirect:/useService/" + currentPage;
	}

	@GetMapping("/search")
	public String search(@RequestParam String search, Model model) {
		System.out.println(search);
		if(!search.equals("")) {
			List<SuDungDichVu> useServices = useServiceService.findAllByKeyWord(search);
			model.addAttribute("useServices", useServices);
			model.addAttribute("search", search);
			return "useService/list";
		}
		return list(model);
	}
}
