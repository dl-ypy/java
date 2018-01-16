package com.ypy.examination.dao.impl;

import java.util.List;

import com.ypy.examination.dao.IUserDao;
import com.ypy.examination.model.User;
import com.ypy.examination.util.DB;

public class UserDaoImpl implements IUserDao{

	@Override
	public int updateById(int user_id, User user) {
		String sql = "update t_user set user_account=?,user_password=?,user_type=?,user_name=?,user_age=?,user_sex=?,user_idcard=?,user_phone=?,user_institure=?,user_grade=?,user_class=? where user_id=?";
		return DB.DML(sql, user.getUser_account(),user.getUser_password(),user.getUser_type(),user.getUser_name(),user.getUser_age(),user.getUser_sex(),user.getUser_idcard(),user.getUser_phone(),user.getUser_institure(),user.getUser_grade(),user.getUser_class(),user_id);
	}

	@Override
	public int add(User user) {
		String sql = "insert into t_user (user_id,user_account,user_password,user_type,user_name,user_age,user_sex,user_idcard,user_phone,user_institure,user_grade,user_class)"+
				                       "values (seq_t_user.nextval,seq_t_user.nextval,?,?,?,?,?,?,?,?,?,?)";
		return DB.DML(sql, "123456", user.getUser_type(),user.getUser_name(),user.getUser_age(),user.getUser_sex(),user.getUser_idcard(),user.getUser_phone(),user.getUser_institure(),user.getUser_grade(),user.getUser_class());
	}

	@Override
	public int deleteById(int user_id) {
		String sql = "delete from t_user where user_id = ?";
		return DB.DML(sql, user_id);
	}

	@Override
	public List<User> selectByAccountAndPwdAndType(String user_account, String user_password, int user_type) {
		String sql = "select * from t_user where user_account = ? and user_password = ? and user_type =?";
		return DB.selectAll(sql, User.class, user_account,user_password,user_type);
	}

	@Override
	public List<User> selectAll() {
		String sql = "select * from t_user";
		return DB.selectAll(sql, User.class);
	}

	@Override
	public List<User> selectById(int user_id) {
		String sql = "select * from t_user where user_id=?";
		return  DB.selectAll(sql, User.class, user_id);
	}

	@Override
	public List<User> selectByIdAndAccount(int user_id, String user_account) {
		String sql = "select * from t_user where user_account=? and user_id <> ?";
		return DB.selectAll(sql, User.class, user_account, user_id);
	}

}
