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

import fa.training.entites.May;
import fa.training.services.ComputerService;
import fa.training.services.IGeneralService;

@Controller
@RequestMapping(value = "/computer")
public class ComputerController {
	@Autowired
	IGeneralService<May, String> computerService;

	@ModelAttribute("computer")
	public May getComputerObject() {
		return new May();
	}

	@GetMapping(value = "")
	public String list(Model model) {
		return listOfPage(model, 1);
	}

	@GetMapping("/{currentPage}")
	public String listOfPage(Model model, @PathVariable(name = "currentPage") int currentPage) {
		int pageSize = 5;
		Page<May> page = computerService.findAll(currentPage, pageSize);
		List<May> computers = page.getContent();
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		System.out.println(currentPage);
		System.out.println(computers.toString());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("computers", computers);
		return "computer/list";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {
		return "computer/add";
	}

	@PostMapping(value = "/saveAdd")
	public String saveAdd(@ModelAttribute(name = "computer") May newComputer, RedirectAttributes attributes) {
		Optional<May> computer = Optional.ofNullable(computerService.findById(newComputer.getMaMay()));
		if (computer.isPresent()) {
			attributes.addFlashAttribute("messageError", "Id" + newComputer.getMaMay() + " đã bị trùng");
			attributes.addFlashAttribute("computer", newComputer);
			return "redirect:/computer/add";
		}
		May computerSuccess = computerService.save(newComputer);
		attributes.addFlashAttribute("messageSuccess", "Thêm máy " + computerSuccess.getMaMay() + " thành công");
		return "redirect:/computer/1";
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable String id) {
		System.out.println("id" + id);
		Optional<May> computer = Optional.ofNullable(computerService.findById(id));
		if (computer.isPresent()) {
			System.out.println("computer" + computer.get().toString());
			model.addAttribute("computer", computer.get());
			return "computer/edit";
		} else {
			System.out.println("Không tìm thấy");
			return listOfPage(model, 1);
		}
	}

	@PostMapping(value = "/saveEdit")
	public String saveEdit(@ModelAttribute(name = "computer") May editComputer, RedirectAttributes attributes) {
		Optional<May> computer = Optional.ofNullable(computerService.findById(editComputer.getMaMay()));
		if (computer.isPresent()) {
			May computerSuccess = computerService.save(editComputer);
			attributes.addFlashAttribute("messageSuccess", "Sửa máy " + computer.get().getMaMay() + " thành công");
			attributes.addFlashAttribute("computer", computerSuccess);
			return "redirect:/computer/1";
		}
		attributes.addFlashAttribute("messageError", "Id" + editComputer.getMaMay() + " không tìm thấy");
		return "redirect:/computer/edit";
	}

	@GetMapping(value = "/delete/{id}/{currentPage}")
	public String delete(Model model, @PathVariable String id, @PathVariable int currentPage, RedirectAttributes attributes) {
		if(computerService.delete(id)) {
			attributes.addFlashAttribute("messageSuccess", "Xoá máy có maMay " + id + " thành công");
		}
		return "redirect:/computer/" + currentPage;
	}

	@GetMapping("/search")
	public String search(@RequestParam String search, Model model) {
		if(!search.equals("")) {
			List<May> computers = computerService.findAllByKeyWord(search);
			model.addAttribute("computers", computers);
			model.addAttribute("search", search);
			return "computer/list";
		}
		return list(model);
	}
}
