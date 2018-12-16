package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin(@RequestParam(value = "error", required = false) String error,
			Model model, @RequestParam(value = "logout", required = false) String logout) {
		System.out.println(error);
		if (error != null) {
			model.addAttribute("errorMsg", "Invalid username and password");
		}
		if (logout != null) {
			model.addAttribute("logoutMsg", "You have been logged out successfully");
		}

		return "login";
	}
}
