package com.Mybatis.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.Mybatis.model.Article;

/**
 * Article的dao接口
 * @author Mr-hang
 *
 */
public interface ArticleMapper {
	/**
	 * 根据对象查找对象-动态if语句
	 * @param article
	 * @return
	 */
	Article dynamicSqlIfQuery(Article article);
	
	
	/**
	 * 根据对象查找对象，动态choose语句
	 * @param article
	 * @return
	 */
	Article dynamicSqlChooseQuery(Article article);
	
	/**
	 * 根据对象查找对象，where语句
	 * @param article
	 * @return
	 */
	Article dynamicSqlWhereQuery(Article article);
	/**
	 * 根据对象查找对象，trim语句
	 * @param article
	 * @return
	 */
	Article dynamicSqlTrimQuery(Article article);
	
	
	/**
	 * 根据对象的id，更新整个对象
	 * @param article
	 */
	void updateArticleSet(Article article);
	
	/**
	 * 传入数组条件，查询符合条件的文章集合
	 * @param arr
	 * @return
	 */
	List<Article> selectArticleListByArray(String [] arr);
	
	List<Article>selectArticleListByList (List<String> list);
	
	/**
	 * 构造一个map，里面存储字段名和字段值，根据这个条件来查询符合条件的Article
	 * @param map
	 * @return
	 */
	List<Article>selectArticleListByMap (@Param("map") Map<String,Object> map);
}
