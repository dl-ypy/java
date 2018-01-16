package com.ypy.examination.model;

public class User {
	private int user_id;       
	private String user_account;  
	private String user_password; 
	private int user_type;     
	private String user_name;     
	private int user_age;      
	private String user_sex;      
	private String user_idcard;   
	private long user_phone;    
	private String user_institure;
	private String user_grade;    
	private String user_class;
	public User() {
		super();
	}
	public User(int user_id, String user_account, String user_password, int user_type, String user_name, int user_age,
			String user_sex, String user_idcard, long user_phone, String user_institure, String user_grade,
			String user_class) {
		super();
		this.user_id = user_id;
		this.user_account = user_account;
		this.user_password = user_password;
		this.user_type = user_type;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_sex = user_sex;
		this.user_idcard = user_idcard;
		this.user_phone = user_phone;
		this.user_institure = user_institure;
		this.user_grade = user_grade;
		this.user_class = user_class;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_idcard() {
		return user_idcard;
	}
	public void setUser_idcard(String user_idcard) {
		this.user_idcard = user_idcard;
	}
	public long getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(long user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_institure() {
		return user_institure;
	}
	public void setUser_institure(String user_institure) {
		this.user_institure = user_institure;
	}
	public String getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}
	public String getUser_class() {
		return user_class;
	}
	public void setUser_class(String user_class) {
		this.user_class = user_class;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_account=" + user_account + ", user_password=" + user_password
				+ ", user_type=" + user_type + ", user_name=" + user_name + ", user_age=" + user_age + ", user_sex="
				+ user_sex + ", user_idcard=" + user_idcard + ", user_phone=" + user_phone + ", user_institure="
				+ user_institure + ", user_grade=" + user_grade + ", user_class=" + user_class + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_account == null) ? 0 : user_account.hashCode());
		result = prime * result + user_age;
		result = prime * result + ((user_class == null) ? 0 : user_class.hashCode());
		result = prime * result + ((user_grade == null) ? 0 : user_grade.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_idcard == null) ? 0 : user_idcard.hashCode());
		result = prime * result + ((user_institure == null) ? 0 : user_institure.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + (int) (user_phone ^ (user_phone >>> 32));
		result = prime * result + ((user_sex == null) ? 0 : user_sex.hashCode());
		result = prime * result + user_type;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_account == null) {
			if (other.user_account != null)
				return false;
		} else if (!user_account.equals(other.user_account))
			return false;
		if (user_age != other.user_age)
			return false;
		if (user_class == null) {
			if (other.user_class != null)
				return false;
		} else if (!user_class.equals(other.user_class))
			return false;
		if (user_grade == null) {
			if (other.user_grade != null)
				return false;
		} else if (!user_grade.equals(other.user_grade))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_idcard == null) {
			if (other.user_idcard != null)
				return false;
		} else if (!user_idcard.equals(other.user_idcard))
			return false;
		if (user_institure == null) {
			if (other.user_institure != null)
				return false;
		} else if (!user_institure.equals(other.user_institure))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_phone != other.user_phone)
			return false;
		if (user_sex == null) {
			if (other.user_sex != null)
				return false;
		} else if (!user_sex.equals(other.user_sex))
			return false;
		if (user_type != other.user_type)
			return false;
		return true;
	}

}
