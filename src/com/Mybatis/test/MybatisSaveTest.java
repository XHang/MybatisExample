package com.Mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Mybatis.Mapper.UserMapper;
import com.Mybatis.model.User;
/**
 * 该类将演示Mybatis的几个保存方式
 * @author Mr-hang
 *
 */
public class MybatisSaveTest {
	public static void main(String[] args) throws IOException {
		String resource = "Configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过输入流指定配置文件，返回一个sessionFactory
		SqlSessionFactory  sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		//打开一个session
		SqlSession session = sqlSessionFactory.openSession();									
		try {
			User user=new User();
			user.setId(1);
			user.setUsername("niambi");
			saveUseInterface(user, session);
			session.commit();						//看来有自动事务处理啊
			System.out.println(user.getId());		//当实体对象变成持久化对象时，有数据库生成的id。
		} finally {
		  session.close();
		}
	}
	
	/**
	 * 使用接口来保存一个对象
	 * @param user
	 * @param session Mybatis的sesion会话对象
	 */
	public  static void saveUseInterface(User user,SqlSession session){
		UserMapper um=session.getMapper(UserMapper.class);
		um.adduser(user);
	}
	/**
	 * 使用原始的配置文件来保存一个对象
	 * @param user
	 * @param session
	 */
	public static void saveUseConfig(User user,SqlSession session){
		session.update("com.Mybatis.Mapper.UserMapper.adduser", user);
	}
}
