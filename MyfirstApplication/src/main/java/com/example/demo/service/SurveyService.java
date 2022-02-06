package com.example.demo.service;

import java.util.List;

import com.example.demo.app.entity.Survey;


//SurveyServiceImplクラスの実装定義
public interface SurveyService {

	void save(Survey servey);
	
	List<Survey> getAll();
}
