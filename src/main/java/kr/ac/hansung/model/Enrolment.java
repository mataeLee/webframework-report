package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Enrolment {
	private String username; // 수강신청 이름
	
	@NotEmpty(message="Year cannot be empty")
	@Size(min=4, max=4, message="Year must be 4 chars")
	private String year; // 수강년도
	
	@NotEmpty(message="Semester cannot be empty")
	@Size(min=1, max=1, message="Semester must be 1 chars")
	private String semester; //수강학기
	
	@NotEmpty(message="Code cannot be empty")
	private String code; // 과목코드
	
	@NotEmpty(message="Cores cannot be empty")
	private String cores; // 과목명
	
	@NotEmpty(message="Division cannot be empty")
	private String division; // 구분
	
	private int grades; //학점
}
