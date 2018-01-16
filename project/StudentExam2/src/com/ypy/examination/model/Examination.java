package com.ypy.examination.model;

public class Examination {
	private int tp_id;      
	private String tp_title;   
	private String tp_choicea; 
	private String tp_choiceb; 
	private String tp_choicec; 
	private String tp_choiced; 
	private double tp_score;   
	private String tp_answer;  
	private int user_id;
	public Examination() {
		super();
	}
	public Examination(int tp_id, String tp_title, String tp_choicea, String tp_choiceb, String tp_choicec,
			String tp_choiced, double tp_score, String tp_answer, int user_id) {
		super();
		this.tp_id = tp_id;
		this.tp_title = tp_title;
		this.tp_choicea = tp_choicea;
		this.tp_choiceb = tp_choiceb;
		this.tp_choicec = tp_choicec;
		this.tp_choiced = tp_choiced;
		this.tp_score = tp_score;
		this.tp_answer = tp_answer;
		this.user_id = user_id;
	}
	public int getTp_id() {
		return tp_id;
	}
	public void setTp_id(int tp_id) {
		this.tp_id = tp_id;
	}
	public String getTp_title() {
		return tp_title;
	}
	public void setTp_title(String tp_title) {
		this.tp_title = tp_title;
	}
	public String getTp_choicea() {
		return tp_choicea;
	}
	public void setTp_choicea(String tp_choicea) {
		this.tp_choicea = tp_choicea;
	}
	public String getTp_choiceb() {
		return tp_choiceb;
	}
	public void setTp_choiceb(String tp_choiceb) {
		this.tp_choiceb = tp_choiceb;
	}
	public String getTp_choicec() {
		return tp_choicec;
	}
	public void setTp_choicec(String tp_choicec) {
		this.tp_choicec = tp_choicec;
	}
	public String getTp_choiced() {
		return tp_choiced;
	}
	public void setTp_choiced(String tp_choiced) {
		this.tp_choiced = tp_choiced;
	}
	public double getTp_score() {
		return tp_score;
	}
	public void setTp_score(double tp_score) {
		this.tp_score = tp_score;
	}
	public String getTp_answer() {
		return tp_answer;
	}
	public void setTp_answer(String tp_answer) {
		this.tp_answer = tp_answer;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Examination [tp_id=" + tp_id + ", tp_title=" + tp_title + ", tp_choicea=" + tp_choicea + ", tp_choiceb="
				+ tp_choiceb + ", tp_choicec=" + tp_choicec + ", tp_choiced=" + tp_choiced + ", tp_score=" + tp_score
				+ ", tp_answer=" + tp_answer + ", user_id=" + user_id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tp_answer == null) ? 0 : tp_answer.hashCode());
		result = prime * result + ((tp_choicea == null) ? 0 : tp_choicea.hashCode());
		result = prime * result + ((tp_choiceb == null) ? 0 : tp_choiceb.hashCode());
		result = prime * result + ((tp_choicec == null) ? 0 : tp_choicec.hashCode());
		result = prime * result + ((tp_choiced == null) ? 0 : tp_choiced.hashCode());
		result = prime * result + tp_id;
		long temp;
		temp = Double.doubleToLongBits(tp_score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tp_title == null) ? 0 : tp_title.hashCode());
		result = prime * result + user_id;
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
		Examination other = (Examination) obj;
		if (tp_answer == null) {
			if (other.tp_answer != null)
				return false;
		} else if (!tp_answer.equals(other.tp_answer))
			return false;
		if (tp_choicea == null) {
			if (other.tp_choicea != null)
				return false;
		} else if (!tp_choicea.equals(other.tp_choicea))
			return false;
		if (tp_choiceb == null) {
			if (other.tp_choiceb != null)
				return false;
		} else if (!tp_choiceb.equals(other.tp_choiceb))
			return false;
		if (tp_choicec == null) {
			if (other.tp_choicec != null)
				return false;
		} else if (!tp_choicec.equals(other.tp_choicec))
			return false;
		if (tp_choiced == null) {
			if (other.tp_choiced != null)
				return false;
		} else if (!tp_choiced.equals(other.tp_choiced))
			return false;
		if (tp_id != other.tp_id)
			return false;
		if (Double.doubleToLongBits(tp_score) != Double.doubleToLongBits(other.tp_score))
			return false;
		if (tp_title == null) {
			if (other.tp_title != null)
				return false;
		} else if (!tp_title.equals(other.tp_title))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
}
