package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Enrolment;
import kr.ac.hansung.model.Grade;
import kr.ac.hansung.service.EnrollService;

@Controller
public class EnrollController {
	@Autowired
	private EnrollService enrollService;

	@RequestMapping("/createenrolment") // 이 url로 request 날아옴
	public String createEnrolment(Model model) {

		model.addAttribute("enrolment", new Enrolment()); // jsp에서 사용하기 위해 model을 등록 해주어야 함

		return "createenrolment";
	}

	@RequestMapping("/doenroll")
	public String doEnroll(Model model, @Valid Enrolment enrolment, BindingResult result ) {

		if (result.hasErrors()) {
			System.out.println("====Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
			}
			return "createenrolment";
		}
		enrollService.insert(enrolment);
		List<Enrolment> enrolled =  enrollService.getCurrent();
		model.addAttribute("enrolled",enrolled);
		return "enrolled";
	}
	
	@RequestMapping("/showenroll")
	public String showEnroll(Model model) {
		List<Enrolment> enrolled =  enrollService.getCurrent();
		System.out.println("show "+enrolled);
		model.addAttribute("enrolled", enrolled);
		return "enrolled";
	}
}
