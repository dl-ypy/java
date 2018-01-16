package com.ypy.examination.service.impl;

import java.util.List;

import com.ypy.examination.dao.impl.ExaminationDaoImpl;
import com.ypy.examination.model.Examination;
import com.ypy.examination.service.IExaminationService;

public class ExaminationServiceImpl implements IExaminationService{
	private final ExaminationDaoImpl ExaminationServiceImpl = new ExaminationDaoImpl();
	
	@Override
	public int updateById(int tp_id, Examination examination) {
		return ExaminationServiceImpl.updateById(tp_id, examination);
	}

	@Override
	public int add(Examination examination) {
		return ExaminationServiceImpl.add(examination);
	}

	@Override
	public int deleteById(int tp_id) {
		return ExaminationServiceImpl.deleteById(tp_id);
	}

	@Override
	public Examination selectById(int tp_id) {
		return ExaminationServiceImpl.selectById(tp_id);
	}

	@Override
	public List<Examination> selectAll() {
		return ExaminationServiceImpl.selectAll();
	}

}
