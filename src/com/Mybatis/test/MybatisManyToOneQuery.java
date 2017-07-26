package com.Mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Mybatis.Mapper.ArticleMapper;
import com.Mybatis.Mapper.UserMapper;
import com.Mybatis.model.Article;

/**
 * Mybatis多对一查询示例
 * @author Mr-hang
 *
 */
public class MybatisManyToOneQuery {
	public static void main(String[] args) throws IOException {
		SqlSession session=null;
		try {
			String resource = "Configuration.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			//通过输入流指定配置文件，返回一个sessionFactory
			SqlSessionFactory  sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
			//打开一个session
			session = sqlSessionFactory.openSession();									
			ArticleMapper am=session.getMapper(ArticleMapper.class);
			List<Article> articles=am.selectArticle(2);
			for(Article article:articles){
				System.out.println("文章内容:"+article.getContent()+"    作者:"+article.getUser().getUsername());
			}
		} finally {
		  session.close();
		}
	}
}
