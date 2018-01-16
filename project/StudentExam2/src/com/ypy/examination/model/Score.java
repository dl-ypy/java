package com.ypy.examination.model;

public class Score {
	private int score_id;
	private int user_id;     
	private String course;      
	private double normal_score;
	private double mid_score;   
	private double end_score;   
	private double total_score;
	public Score() {
		super();
	}
	public Score(int user_id, String course, double normal_score, double mid_score, double end_score, double total_score) {
		super();
		this.user_id = user_id;
		this.course = course;
		this.normal_score = normal_score;
		this.mid_score = mid_score;
		this.end_score = end_score;
		this.total_score = total_score;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getNormal_score() {
		return normal_score;
	}
	public void setNormal_score(double normal_score) {
		this.normal_score = normal_score;
	}
	public double getMid_score() {
		return mid_score;
	}
	public void setMid_score(double mid_score) {
		this.mid_score = mid_score;
	}
	public double getEnd_score() {
		return end_score;
	}
	public void setEnd_score(double end_score) {
		this.end_score = end_score;
	}
	public double getTotal_score() {
		return total_score;
	}
	public void setTotal_score(double total_score) {
		this.total_score = total_score;
	}
	
	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	@Override
	public String toString() {
		return "Score [score_id=" + score_id + ", user_id=" + user_id + ", course=" + course + ", normal_score="
				+ normal_score + ", mid_score=" + mid_score + ", end_score=" + end_score + ", total_score="
				+ total_score + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		long temp;
		temp = Double.doubleToLongBits(end_score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mid_score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(normal_score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + score_id;
		temp = Double.doubleToLongBits(total_score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Score other = (Score) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (Double.doubleToLongBits(end_score) != Double.doubleToLongBits(other.end_score))
			return false;
		if (Double.doubleToLongBits(mid_score) != Double.doubleToLongBits(other.mid_score))
			return false;
		if (Double.doubleToLongBits(normal_score) != Double.doubleToLongBits(other.normal_score))
			return false;
		if (score_id != other.score_id)
			return false;
		if (Double.doubleToLongBits(total_score) != Double.doubleToLongBits(other.total_score))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
}
