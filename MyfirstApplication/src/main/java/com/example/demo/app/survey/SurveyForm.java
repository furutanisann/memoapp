package com.example.demo.app.survey;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class SurveyForm {

//	年齢　０から１５０歳まで
	@Min(0)
	@Max(150)
	private Integer age;
//  満足度　５段階評価
	@Min(1)
	@Max(5)
	private Integer satisfaction;
	@Size(min = 1,max = 200,message = "１から２００文字で入力してください")
	private String comment;
	
	
	public SurveyForm() {
	}
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(Integer satisfaction) {
		this.satisfaction = satisfaction;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
