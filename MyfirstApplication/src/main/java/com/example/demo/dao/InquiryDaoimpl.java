package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.app.entity.Inquiry;


@Repository
public class InquiryDaoimpl implements InquiryDao{
//	データベース操作用
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public InquiryDaoimpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertInquiry(Inquiry inquiry) {
//							idはオート指定のため挿入なし
//							SQLインジェクション対策実施
		jdbcTemplate.update("INSERT INTO inquiry(name,email,contents,created)"
				+ " VALUES(?,?,?,?)",
				inquiry.getName(),inquiry.getEmail(),inquiry.getContents(),inquiry.getCreated());
		
		
	}

//	データベースから引いたデータをInquiryクラスに渡す
	@Override
	public List<Inquiry> getAll() {
		String sql = "SELECT id,name,email,contents,created FROM inquiry";
		List<Map<String, Object>> resultlist = jdbcTemplate.queryForList(sql);
		List<Inquiry> list = new ArrayList<Inquiry>();
		for(Map<String,Object> result : resultlist) {
			Inquiry inquiry = new Inquiry();
//							オブジェクト型なので各型へダウンキャスト
			inquiry.setId((int)result.get("id"));
			inquiry.setName((String)result.get("name"));
			inquiry.setEmail((String)result.get("email"));
			inquiry.setContents((String)result.get("contents"));
			inquiry.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			list.add(inquiry);
		}
		return list;
	}

}
