package com.example.demo.dao;

import java.util.List;

import com.example.demo.app.entity.Inquiry;


// DAO関係のインターフェース
public interface InquiryDao {
	
	void insertInquiry(Inquiry inquiry);

// 例外処理検証用
	int updateInquiry(Inquiry inquiry);
	
	List<Inquiry> getAll();
}
