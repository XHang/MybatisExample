package com.Mybatis.Mapper;

import com.Mybatis.model.User;
/**
 * 用户的映射接口类
 * @author Mr-hang
 * 注意：里面的方法名都要和实体类的映射文件的sql配置的id相同
 *
 */
public interface UserMapper {
	/**
	 * 添加一个用户
	 * @param user
	 */
	void adduser(User user);
	/**
	 * 删除一个用户 
	 * @param id
	 */
	void deleteUser(int id);
	
	/**
	 * 更新整个用户
	 * @param u
	 */
	public void update(User u);
}
