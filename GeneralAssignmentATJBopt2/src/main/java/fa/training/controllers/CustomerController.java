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

import fa.training.entites.KhachHang;
import fa.training.entites.May;
import fa.training.services.CustomerService;
import fa.training.services.IGeneralService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	IGeneralService<KhachHang> customerService;

	@ModelAttribute("customer")
	public KhachHang getCustomerObject() {
		return new KhachHang();
	}

	@GetMapping(value = "")
	public String list(Model model) {
		return listOfPage(model, 1);
	}

	@GetMapping("/{currentPage}")
	public String listOfPage(Model model, @PathVariable(name = "currentPage") int currentPage) {
		int pageSize = 5;
		Page<KhachHang> page = customerService.findAll(currentPage, pageSize);
		List<KhachHang> customers = page.getContent();
		System.out.println(customers.toString());
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		System.out.println(currentPage);
		System.out.println(customers.toString());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("customers", customers);
		return "customer/list";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {
		return "customer/add";
	}

	@PostMapping(value = "/saveAdd")
	public String saveAdd(@ModelAttribute(name = "customer") KhachHang newCustomer, RedirectAttributes attributes) {
		Optional<KhachHang> customer = Optional.ofNullable(customerService.findById(newCustomer.getMaKH()));
		if (customer.isPresent()) {
			attributes.addFlashAttribute("messageError", "Id" + newCustomer.getMaKH() + " đã bị trùng");
			attributes.addFlashAttribute("customer", newCustomer);
			return "redirect:/customer/add";
		}
		KhachHang customerSuccess = customerService.save(newCustomer);
		attributes.addFlashAttribute("messageSuccess", "Thêm khách hàng " + customerSuccess.getMaKH() + " thành công");
		return "redirect:/customer/1";
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable String id) {
		System.out.println("id" + id);
		Optional<KhachHang> customer = Optional.ofNullable(customerService.findById(id));
		if (customer.isPresent()) {
			System.out.println("customer" + customer.get().toString());
			model.addAttribute("customer", customer.get());
			return "customer/edit";
		} else {
			System.out.println("Không tìm thấy");
			return listOfPage(model, 1);
		}
	}

	@PostMapping(value = "/saveEdit")
	public String saveEdit(@ModelAttribute(name = "customer") KhachHang editCustomer, RedirectAttributes attributes) {
		Optional<KhachHang> customer = Optional.ofNullable(customerService.findById(editCustomer.getMaKH()));
		if (customer.isPresent()) {
			KhachHang customerSuccess = customerService.save(editCustomer);
			attributes.addFlashAttribute("messageSuccess", "Sửa khách hàng " + customer.get().getMaKH() + " thành công");
			attributes.addFlashAttribute("customer", customerSuccess);
			return "redirect:/customer/1";
		}
		attributes.addFlashAttribute("messageError", "Id" + editCustomer.getMaKH() + " không tìm thấy");
		return "redirect:/customer/edit";
	}

	@GetMapping(value = "/delete/{id}/{currentPage}")
	public String delete(Model model, @PathVariable String id, @PathVariable int currentPage) {
		customerService.delete(id);
		return listOfPage(model, currentPage);
	}

	@GetMapping("/search")
	public String search(@RequestParam String search, Model model) {
		System.out.println(search);
		if(!search.equals("")) {
			List<KhachHang> customers = customerService.findAllByKeyWord(search);
			model.addAttribute("customers", customers);
			model.addAttribute("search", search);
			return "customer/list";
		}
		return list(model);
	}
}
