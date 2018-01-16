package com.ypy.examination.dao.impl;

import java.util.List;

import com.ypy.examination.dao.IScoreDao;
import com.ypy.examination.model.Score;
import com.ypy.examination.util.DB;

public class ScoreDaoImpl implements IScoreDao{

	@Override
	public int deleteByUserid(int user_id) {
		String sql = "delete from t_score where user_id=?";
		return DB.DML(sql, user_id);
	}

	@Override
	public List<Score> selectAll() {
		String sql = "select * from t_score";
		return DB.selectAll(sql, Score.class);
	}

	@Override
	public int updateById(int score_id, Score score) {
		String sql = "update t_score set user_id=?,course=?,normal_score=?,mid_score=?,end_score=?,total_score=? where score_id=?";
		return DB.DML(sql, score.getUser_id(),score.getCourse(),score.getNormal_score(),score.getMid_score(),score.getEnd_score(),score.getTotal_score(),score_id);
	}

	@Override
	public int add(Score score) {
		String sql = "insert into t_score (score_id,user_id,course,normal_score,mid_score,end_score,total_score) values (seq_t_score.nextval,?,?,?,?,?,?)";
		return DB.DML(sql, score.getUser_id(),score.getCourse(),score.getNormal_score(),score.getMid_score(),score.getEnd_score(),score.getTotal_score());
	}

	@Override
	public List<Score> selectByUserid(int user_id) {
		String sql = "select * from t_score where user_id=?";
		return DB.selectAll(sql, Score.class, user_id);
	}

	@Override
	public Score selectByUseridAndCourse(int user_id, String course) {
		String sql = "select * from t_score where user_id=? and course=?";
		return (Score) DB.selectAll(sql, Score.class, user_id, course).get(0);
	}

	@Override
	public int deleteByUseridAndCourse(int user_id, String course) {
		String sql = "delete from t_score where user_id=? and course=?";
		return DB.DML(sql, user_id,course);
	}

	@Override
	public int deleteById(int score_id) {
		String sql = "delete from t_score where score_id=?";
		return DB.DML(sql, score_id);
	}

	@Override
	public List<Score> selectById(int score_id) {
		String sql = "select * from t_score where score_id=?";
		return DB.selectAll(sql, Score.class, score_id);
	}

	@Override
	public List<Score> selectByUserId(int user_id) {
		String sql = "select * from t_score where user_id=?";
		return DB.selectAll(sql, Score.class, user_id);
	}

}
