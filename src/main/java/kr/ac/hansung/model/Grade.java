package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {
	private String username;
	private String year; // 수강년도
	private String semester; //수강학기
	private String code; // 과목코드
	private String cores; // 과목명
	private String division; // 구분
	private int grades; //학점
}
