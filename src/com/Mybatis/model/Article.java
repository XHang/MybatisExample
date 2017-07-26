package com.Mybatis.model;

/**
 * 文章实体类对象
 * 用来演示多对一查询的，这个是多的一方，少的一方是用户
 * @author Mr-hang
 *
 */
public class Article {
	int id;
	User user;
	String title;
	String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
