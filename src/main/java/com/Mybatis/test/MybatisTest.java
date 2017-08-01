package com.Mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Mybatis.Mapper.ArticleMapper;
import com.Mybatis.model.Article;

public class MybatisTest { 
	public static void main(String[] args) throws IOException {
		String resource = "Configuration.xml"; 
		//记下，这个可以从classpath获取文件
		InputStream inputStream = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
		// 通过输入流指定配置文件，返回一个sessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
		// 打开一个session
		SqlSession session = sqlSessionFactory.openSession(); 
		try {
			 // 传入一个用于dao的接口类
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			Article a = new Article();
			a.setTitle("这是标题");
			a.setContent("这是内容");
			//先保存一个文章
			saveArticle(a,session);
			selectArticleListByMap(mapper);
			session.commit();
		} finally {
			session.close();
		}
	}
	/**
	 * 保存一个文章对象
	 * @param article
	 * @param session
	 */
	private static void saveArticle(Article article,SqlSession session){
		session.insert("com.Mybatis.Mapper.ArticleMapper.saveArticle", article);
		System.out.println("保存用户成功："+article);
	}
	/**
	 * 动态sqlIf的示例程序
	 * @param mapper
	 */
	private static void  dynamicSqlIfQuery(ArticleMapper mapper){
		Article article = new Article();
		article.setId(2);
		article = mapper.dynamicSqlIfQuery(article); 
		System.out.println("查询出来的文章对象："+article);
	}
	/**
	 * 动态sql Choose的示例程序
	 * @param mapper
	 */
	private static void  dynamicSqlChooseQuery(ArticleMapper mapper){
		Article article = new Article();
		article.setId(6);
		article = mapper.dynamicSqlChooseQuery(article); 
		System.out.println("查询出来的文章对象："+article);
	}
	
	private static void  dynamicSqlWhereQuery(ArticleMapper mapper){
		Article article = new Article();
		article.setId(6);
		article = mapper.dynamicSqlWhereQuery(article);
		System.out.println("查询出来的文章对象："+article);
	}
	private static void  dynamicSqlTrimQuery(ArticleMapper mapper){
		Article article = new Article();
		article.setId(6);
		article = mapper.dynamicSqlTrimQuery(article);
		System.out.println("查询出来的文章对象："+article);
	}
	
	private static void  updateArticleSet(ArticleMapper mapper){
		Article article = new Article();
		article.setId(6);
		article.setTitle("我有个秘密要告诉你");
		article.setContent("我喜欢你");
		mapper.updateArticleSet(article);
		System.out.println("更新成功");
	}
	
	private static void  selectArticleListByArray(String[] arr,ArticleMapper mapper){
	   List<Article>  list = mapper.selectArticleListByArray(arr);
		System.out.println("查询出来的，符合条件的个数共有："+list.size());
	}
	private static void  selectArticleListByList(ArticleMapper mapper){
		  List<String> list = new ArrayList<String>();
		  list.add("43");
		  list.add("33");
		   List<Article>  articles = mapper.selectArticleListByList(list);
			System.out.println("查询出来的，符合条件的个数共有："+articles.size());
		}
	private static void  selectArticleListByMap(ArticleMapper mapper){
		  Map<String,Object> map = new HashMap<String,Object> ();
		  map.put("title", "这是标题");
		  map.put("content", "这是内容");
		   List<Article>  articles = mapper.selectArticleListByMap(map);
			System.out.println("查询出来的，符合条件的个数共有："+articles.size());
		}
}
