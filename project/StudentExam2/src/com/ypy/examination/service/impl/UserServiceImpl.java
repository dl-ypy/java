package com.ypy.examination.service.impl;

import java.util.List;

import com.ypy.examination.dao.impl.UserDaoImpl;
import com.ypy.examination.model.User;
import com.ypy.examination.service.IUserService;

public class UserServiceImpl implements IUserService{
	private final UserDaoImpl UserServiceImpl = new UserDaoImpl();
	
	@Override
	public int updateById(int user_id, User user) {
		return UserServiceImpl.updateById(user_id, user);
	}

	@Override
	public int add(User user) {
		return UserServiceImpl.add(user);
	}

	@Override
	public int deleteById(int user_id) {
		return UserServiceImpl.deleteById(user_id);
	}

	@Override
	public User selectByAccountAndPwdAndType(String user_account, String user_password, int user_type) {
		List<User> list = UserServiceImpl.selectByAccountAndPwdAndType(user_account, user_password, user_type);
		if (list.size() > 0) {
			return list.get(0);
		}
		return new User();
	}

	@Override
	public List<User> selectAll() {
		return UserServiceImpl.selectAll();
	}

	@Override
	public User selectById(int user_id) {
		List<User> list = UserServiceImpl.selectById(user_id);
		if (list.size() > 0) {
			return list.get(0);
		}
		return new User();
	}

	@Override
	public List<User> selectByIdAndAccount(int user_id, String user_account) {
		return UserServiceImpl.selectByIdAndAccount(user_id, user_account);
	}

}
