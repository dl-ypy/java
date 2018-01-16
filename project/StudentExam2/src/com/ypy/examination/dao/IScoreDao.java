package com.ypy.examination.dao;

import java.util.List;
import com.ypy.examination.model.Score;

public interface IScoreDao {
	//修改某个学生的某门课成绩
	int updateById(int score_id, Score score);
	int add(Score score);
	//删除某个学生的所有成绩
	int deleteByUserid(int user_id);
	//删除某个学生的某门课成绩
	int deleteByUseridAndCourse(int user_id, String course);
	//查询一个学生的所有成绩
	List<Score> selectByUserid(int user_id);
	//查询某个学生的某门课成绩
	Score selectByUseridAndCourse(int user_id, String course);
	List<Score> selectAll();
	int deleteById(int score_id);
	List<Score> selectById(int score_id);
	List<Score> selectByUserId(int user_id);
}
