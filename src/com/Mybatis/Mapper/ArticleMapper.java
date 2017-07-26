package com.Mybatis.Mapper;

import java.util.List;

import com.Mybatis.model.Article;
import com.Mybatis.model.User;

public interface ArticleMapper {
	/**
	 * 通过用户id查询用户发过的帖子集合
	 * @param userid
	 * @return
	 */
	public List<Article> selectArticle(int userid);
}
