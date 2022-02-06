package com.example.demo.dao;

import java.util.List;

import com.example.demo.app.entity.Inquiry;


// DAO関係のインターフェース
public interface InquiryDao {
	
	void insertInquiry(Inquiry inquiry);
	
	List<Inquiry> getAll();
}
