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
 * 该类将演示Mybatis的几个更新方式
 * @author Mr-hang
 *
 */
public class MybatisUpdateTest {
	public static void main(String[] args) throws IOException {
		String resource = "Configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过输入流指定配置文件，返回一个sessionFactory
		SqlSessionFactory  sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		//打开一个session
		SqlSession session = sqlSessionFactory.openSession();									
		try {
			User user=new User();
			user.setUsername("niambi");
			MybatisSaveTest.saveUseInterface(user, session);
			System.out.println("保存一个对象成功！");
			user.setUsername("林可");
			updateUseInterface(user, session);
			System.out.println("修改一个对象成功！");
			session.commit();						//看来有自动事务处理啊
			System.out.println("显示保存的用户主键"+user.getId());		//当实体对象变成持久化对象时，有数据库生成的id。
		} finally {
		  session.close();
		}
	}
	
	/**
	 * 使用接口来更新一个对象
	 * @param user
	 * @param session Mybatis的sesion会话对象
	 */
	private static void updateUseInterface(User user,SqlSession session){
		UserMapper um=session.getMapper(UserMapper.class);
		um.update(user);
	}
	/**
	 * 使用原始的配置文件来保存一个对象
	 * @param user
	 * @param session
	 */
	private static void saveUseConfig(User user,SqlSession session){
		session.update("com.Mybatis.Mapper.UserMapper.update", user);
	}
}
