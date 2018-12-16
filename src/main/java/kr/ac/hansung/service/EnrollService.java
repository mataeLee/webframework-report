package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.EnrollDAO;
import kr.ac.hansung.dao.GradeDAO;
import kr.ac.hansung.model.Enrolment;
import kr.ac.hansung.model.Grade;

@Service
public class EnrollService {
	@Autowired
	private EnrollDAO enrollDAO;
	
	public List<Enrolment> getCurrent() {
		return enrollDAO.getEnrolments();
	}
	
	public void insert(Enrolment enrolment) {
		enrollDAO.insert(enrolment);
	}
}
