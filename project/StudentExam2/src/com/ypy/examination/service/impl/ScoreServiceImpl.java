package com.ypy.examination.service.impl;

import java.util.List;
import com.ypy.examination.dao.impl.ScoreDaoImpl;
import com.ypy.examination.model.Score;
import com.ypy.examination.service.IScoreService;

public class ScoreServiceImpl implements IScoreService{
	private final ScoreDaoImpl ScoreServiceImpl = new ScoreDaoImpl();
	
	@Override
	public int updateById(int score_id, Score score) {
		return ScoreServiceImpl.updateById(score_id, score);
	}

	@Override
	public int add(Score score) {
		return ScoreServiceImpl.add(score);
	}

	@Override
	public int deleteByUserid(int user_id) {
		return ScoreServiceImpl.deleteByUserid(user_id);
	}

	@Override
	public int deleteByUseridAndCourse(int user_id, String course) {
		return ScoreServiceImpl.deleteByUseridAndCourse(user_id, course);
	}

	@Override
	public List<Score> selectByUserid(int user_id) {
		return ScoreServiceImpl.selectByUserid(user_id);
	}

	@Override
	public Score selectByUseridAndCourse(int user_id, String course) {
		return ScoreServiceImpl.selectByUseridAndCourse(user_id, course);
	}

	@Override
	public List<Score> selectAll() {
		return ScoreServiceImpl.selectAll();
	}

	@Override
	public int deleteById(int score_id) {
		return ScoreServiceImpl.deleteById(score_id);
	}

	@Override
	public Score selectById(int score_id) {
		List<Score> list = ScoreServiceImpl.selectById(score_id);
		if (list.size() > 0) {
			return list.get(0);
		}
		return new Score();
	}

	@Override
	public List<Score> selectByUserId(int user_id) {
		return ScoreServiceImpl.selectByUserid(user_id);
	}

	
}
