package com.example.demo.app.entity;

import java.time.LocalDateTime;

//	データベースから受け取った値BLへ渡す際のクラス
public class Survey {
	private int id;
	private int age;
	private int satisfaction;
	private String comment;
	private LocalDateTime created;
	
//	データベースから取得時に設定するので空
	public Survey() {
	}

//	以降各ゲッターセッター
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	
}
