package com.ypy.examination.util;

import java.util.List;
import com.ypy.examination.model.User;
import com.ypy.examination.service.impl.UserServiceImpl;
/**
 * 判断一些输入规则的工具类
 * @author ypy
 *
 */
public class RuleUtil {
	private static UserServiceImpl impl = new UserServiceImpl();
	private static User user = new User();
	
	/**
	 * 判断用户是否存在
	 * @param user_account
	 * @param user_password
	 * @param user_type
	 * @return
	 */
	public static int userExist(String user_account, String user_password, int user_type) {
		user = impl.selectByAccountAndPwdAndType(user_account, user_password, user_type);
		if (user.getUser_id() != 0) {
			return user.getUser_id();
		} 
		return -1;
	}
	
	/**
	 * 判断是否有重名的用户名
	 * @param user_account
	 * @param user_id
	 * @return
	 */
	public static boolean userAccountRepeat(String user_account, int user_id) {
		List<User> list = impl.selectByIdAndAccount(user_id, user_account);
		if (list.size() != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证电话号码格式
	 * @param phone
	 * @return
	 */
	public static boolean phoneIsCorrect(String phone) {
		if (phone.matches("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证身份证格式
	 * @param idCard
	 * @return
	 */
	public static boolean idCardIsCorrect(String idCard) {
		if (idCard.matches("^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 密码的位数
	 * @param password
	 * @return
	 */
	public static boolean passwordRule(String password) {
		if (password.length()<4 || password.length()>6) {
			return true;
		}
		return false;
	}
	
	/**
	 * 年龄格式
	 * @param user_age
	 * @return
	 */
	public static boolean ageRule(String age) {
		if (age.matches("[1-9][0-9]")){
			return true;
		}
		return false;
	}
	
	/**
	 * 分数格式
	 * @param score
	 * @return
	 */
	public static boolean scoreRule(String score) {
		if (score.matches("[0-9]|[0-9][0-9]|[1][0][0]|[0-9].[0|5]|[0-9][0-9].[0|5]")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 答案的格式
	 * @param answer
	 * @return
	 */
	public static boolean answerRule(String answer) {
		if (answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D") || answer.equals("a") || answer.equals("b") || answer.equals("c") || answer.equals("d")) {
			return true;
		}
		return false;
	}
}
