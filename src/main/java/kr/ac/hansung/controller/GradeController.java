package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Grade;
import kr.ac.hansung.model.Preview;
import kr.ac.hansung.service.GradeService;

@Controller
public class GradeController {
	@Autowired
	private GradeService gradeService;

	@RequestMapping("/preview")
	public String showPrivew(Model model) {
		List<Grade> grades;
		List<Preview> previews = new Vector<Preview>();
		int count = 0;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) { 
				Preview preview = new Preview();
				
				preview.setYear(""+(2017+i)); // 2017년 부터 
				preview.setSemester(""+(j+1)); // 학기
				grades = gradeService.getWantGrades(""+(2017+i), ""+(j+1)); // service에게 원하는 리스트 요청
				
				for(int k = 0; k< grades.size(); k++) {
					if(grades.get(k).getYear().equals(preview.getYear()) && grades.get(k).getSemester().equals(preview.getSemester()))
						count += grades.get(k).getGrades(); // 이수 학점 더한다.
				}
				
				preview.setGrades(count);
				System.out.println("preview is "+preview);
				if(preview.getGrades() != 0) {
					previews.add(preview);
					count = 0;
				}
			}
		}
		System.out.println(previews);
		model.addAttribute("previews", previews);
		return "preview";
	}

	@RequestMapping("/grades")
	public String showLink(Model model, @RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "semester", required = false) String semester) {
		List<Grade> grades = gradeService.getWantGrades(year, semester);
		model.addAttribute("grades", grades);
		return "grades";
	}
}
