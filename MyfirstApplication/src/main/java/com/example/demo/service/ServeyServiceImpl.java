package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.entity.Survey;
import com.example.demo.dao.SurveyDao;

@Service
public class ServeyServiceImpl implements SurveyService {

//	データベースとやり取りするため、DAOクラス準備
	private final SurveyDao dao;
	
//	コントローラーから呼び出されるためにDIコンテナに準備
	@Autowired
	ServeyServiceImpl(SurveyDao dao) {
		this.dao = dao;
	}
//	データベース保存
	@Override
	public void save(Survey survey) {
		dao.insert(survey);
	}
//	データベースから全県取得
	@Override
	public List<Survey> getAll() {
		return dao.getAll();
	}

}
