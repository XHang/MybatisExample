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
 * 该类将演示Mybatis的几个删除方式
 * @author Mr-hang
 *
 */
public class MybatisDeleteTest {
	public static void main(String[] args) throws IOException {
		String resource = "Configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过输入流指定配置文件，返回一个sessionFactory
		SqlSessionFactory  sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		//打开一个session
		SqlSession session = sqlSessionFactory.openSession();									
		try {
			//删除主键为1的用户记录
			deleteUseConfig(1, session);
			System.out.println("删除成功，不管你信不信，反正我是信了");
			session.commit();						//自动事务处理
		} finally {
		  session.close();
		}
	}
	
	/**
	 * 使用接口来删除一个对象
	 * @param id 用户主键id
	 * @param session Mybatis的sesion会话对象
	 */
	private static void deleteUseInterface(int id,SqlSession session){
		UserMapper um=session.getMapper(UserMapper.class);
		um.deleteUser(id);
	}
	/**
	 * 使用原始的配置文件来删除一个对象
	 * @param user
	 * @param session
	 */
	private static void deleteUseConfig(int id,SqlSession session){
		session.update("com.Mybatis.Mapper.UserMapper.deleteUser", id);
	}
}
