package com.ypy.examination.service;

import java.util.List;

import com.ypy.examination.model.Score;

public interface IScoreService {
	//�޸�ĳ��ѧ����ĳ�ſγɼ�
	int updateById(int score_id, Score score);
	int add(Score score);
	//ɾ��ĳ��ѧ�������гɼ�
	int deleteByUserid(int user_id);
	//ɾ��ĳ��ѧ����ĳ�ſγɼ�
	int deleteByUseridAndCourse(int user_id, String course);
	//��ѯһ��ѧ�������гɼ�
	List<Score> selectByUserid(int user_id);
	//��ѯĳ��ѧ����ĳ�ſγɼ�
	Score selectByUseridAndCourse(int user_id, String course);
	List<Score> selectAll();
	int deleteById(int score_id);
	Score selectById(int score_id);
	List<Score> selectByUserId(int user_id);
}
