package dao;

import model.User;

/**
 * (生成javadoc测试)
 * 对User类进行操作
 * @author 杨佩钰
 * @see User
 * @version 1.0
 */
public class UserDao {
	/**
	 * 主方法
	 * @param args 调用的命令的变量
	 */
	public static void main(String[] args) {
		print("ypy");
	}
	
	/**
	 * 打印用户姓名
	 * @param name 用户姓名
	 */
	public static void print(String name) {
		User user = new User();
		user.setName(name);
		System.out.println(user.getName());
	}
}

