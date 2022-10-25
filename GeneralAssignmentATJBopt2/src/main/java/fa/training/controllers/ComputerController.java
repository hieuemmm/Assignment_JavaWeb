package fa.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/computer")
public class ComputerController {
	
	@GetMapping(value = "")
	public String listComputer() {
	
		return "computer/list";
	}
	@GetMapping(value = "/add")
	public String formAddComputer() {
	
		return "computer/add";
	}
	@PostMapping(value = "/add")
	public String addComputer() {
	
		return "computer/add";
	}
}
