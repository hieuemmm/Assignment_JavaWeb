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

import fa.training.entites.DichVu;
import fa.training.services.IGeneralService;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
	@Autowired
	IGeneralService<DichVu, String> serviceService;

	@ModelAttribute("service")
	public DichVu getServiceObject() {
		return new DichVu();
	}

	@GetMapping(value = "")
	public String list(Model model) {
		return listOfPage(model, 1);
	}

	@GetMapping("/{currentPage}")
	public String listOfPage(Model model, @PathVariable(name = "currentPage") int currentPage) {
		int pageSize = 10;
		Page<DichVu> page = serviceService.findAll(currentPage, pageSize);
		List<DichVu> services = page.getContent();
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("services", services);
		return "service/list";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {
		return "service/add";
	}

	@PostMapping(value = "/saveAdd")
	public String saveAdd(@ModelAttribute(name = "service") DichVu newService, RedirectAttributes attributes) {
		Optional<DichVu> service = Optional.ofNullable(serviceService.findById(newService.getMaDV()));
		if (service.isPresent()) {
			attributes.addFlashAttribute("messageError", "Id" + newService.getMaDV() + " đã bị trùng");
			attributes.addFlashAttribute("service", newService);
			return "redirect:/service/add";
		}
		DichVu serviceSuccess = serviceService.save(newService);
		attributes.addFlashAttribute("messageSuccess", "Thêm dịch vụ " + serviceSuccess.getMaDV() + " thành công");
		return "redirect:/service/1";
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable String id) {
		System.out.println("id" + id);
		Optional<DichVu> service = Optional.ofNullable(serviceService.findById(id));
		if (service.isPresent()) {
			System.out.println("service" + service.get().toString());
			model.addAttribute("service", service.get());
			return "service/edit";
		} else {
			System.out.println("Không tìm thấy");
			return listOfPage(model, 1);
		}
	}

	@PostMapping(value = "/saveEdit")
	public String saveEdit(@ModelAttribute(name = "service") DichVu editService, RedirectAttributes attributes) {
		Optional<DichVu> service = Optional.ofNullable(serviceService.findById(editService.getMaDV()));
		if (service.isPresent()) {
			DichVu serviceSuccess = serviceService.save(editService);
			attributes.addFlashAttribute("messageSuccess", "Sửa dịch vụ " + service.get().getMaDV() + " thành công");
			attributes.addFlashAttribute("service", serviceSuccess);
			return "redirect:/service/1";
		}
		attributes.addFlashAttribute("messageError", "Id" + editService.getMaDV() + " không tìm thấy");
		return "redirect:/service/edit";
	}

	@GetMapping(value = "/delete/{id}/{currentPage}")
	public String delete(Model model, @PathVariable String id, @PathVariable int currentPage, RedirectAttributes attributes) {
		if(serviceService.delete(id)) {
			attributes.addFlashAttribute("messageSuccess", "Xoá dịch vụ có maDV " + id + " thành công");
		}
		return "redirect:/service/" + currentPage;
	}

	@GetMapping("/search")
	public String search(@RequestParam String search, Model model) {
		System.out.println(search);
		if(!search.equals("")) {
			List<DichVu> services = serviceService.findAllByKeyWord(search);
			model.addAttribute("services", services);
			model.addAttribute("search", search);
			return "service/list";
		}
		return list(model);
	}
}
