package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.app.entity.Survey;


//	データベースからアクセスするクラス
@Repository
public class SurveyDioImpl implements SurveyDao {

//	データベースへ接続用
	private final JdbcTemplate jdbcTemplate;
	
//  DIコンテナで自動生成	
	@Autowired
	public SurveyDioImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
//	JBDでサーバ登録
	@Override
	public void insert(Survey survay) {
		
		jdbcTemplate.update("INSERT INTO survey(age,satisfaction,comment,created)"
				+ " VALUES(?,?,?,?)",
				survay.getAge(),survay.getSatisfaction(),survay.getComment(),survay.getCreated());

	}
//	データベースから全県取得
	@Override
	public List<Survey> getAll() {
		String sql = "SELECT id,age,satisfaction,comment,created FROM survey";
		List<Map<String,Object>> resultlist = jdbcTemplate.queryForList(sql);
		List<Survey> list = new ArrayList<Survey>();
		for(Map<String,Object> result : resultlist) {
			Survey survey = new Survey();
			
			survey.setId((int)result.get("id"));
			survey.setAge((int)result.get("age"));
			survey.setSatisfaction((int)result.get("satisfaction"));
			survey.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			survey.setAge((int)result.get("id"));
			list.add(survey);
		}
		return list;
	}

}
