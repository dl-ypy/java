package dao;

import model.User;

/**
 * (����javadoc����)
 * ��User����в���
 * @author ������
 * @see User
 * @version 1.0
 */
public class UserDao {
	/**
	 * ������
	 * @param args ���õ�����ı���
	 */
	public static void main(String[] args) {
		print("ypy");
	}
	
	/**
	 * ��ӡ�û�����
	 * @param name �û�����
	 */
	public static void print(String name) {
		User user = new User();
		user.setName(name);
		System.out.println(user.getName());
	}
}

