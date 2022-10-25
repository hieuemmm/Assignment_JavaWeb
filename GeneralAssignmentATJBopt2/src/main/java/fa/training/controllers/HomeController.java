package fa.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView homePageIndex() {
		ModelAndView homeView = new ModelAndView("index");
		return homeView;
	}
}

