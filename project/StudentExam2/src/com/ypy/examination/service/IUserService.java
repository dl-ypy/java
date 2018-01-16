package com.ypy.examination.service;

import java.util.List;

import com.ypy.examination.model.User;

public interface IUserService {
	int updateById(int user_id, User user);
	int add(User user);
	int deleteById(int user_id);
	User selectByAccountAndPwdAndType(String user_account, String user_password, int user_type);
	List<User> selectAll();
	User selectById(int user_id);
	List<User> selectByIdAndAccount(int user_id, String user_account);
}
