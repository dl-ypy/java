package com.ypy.examination.service;

import java.util.List;

import com.ypy.examination.model.Examination;

public interface IExaminationService {
	int updateById(int tp_id, Examination examination);
	int add(Examination examination);
	int deleteById(int tp_id);
	Examination selectById(int tp_id);
	List<Examination> selectAll();
}
