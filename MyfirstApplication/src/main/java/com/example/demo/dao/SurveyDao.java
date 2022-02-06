package com.example.demo.dao;

import java.util.List;

import com.example.demo.app.entity.Survey;

//	SurveyDaoImplクラスのインターフェース
public interface SurveyDao {
	
//	データベース追加用
	void insert(Survey servay);
	
//	データベースから登録内容をすべて取得
//	カラム名をString,各内容をObjectで取得
	List<Survey> getAll();
}
