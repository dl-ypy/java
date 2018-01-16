package com.ypy.examination.dao.impl;

import java.util.List;

import com.ypy.examination.dao.IExaminationDao;
import com.ypy.examination.model.Examination;
import com.ypy.examination.util.DB;

public class ExaminationDaoImpl implements IExaminationDao{

	@Override
	public int updateById(int tp_id, Examination examination) {
		String sql = "update t_examination set tp_title=?,tp_choicea=?,tp_choiceb=?,tp_choicec=?,tp_choiced=?,tp_score=?,tp_answer=?,user_id=? where tp_id=?";
		return DB.DML(sql, examination.getTp_title(),examination.getTp_choicea(),examination.getTp_choiceb(),examination.getTp_choicec(),examination.getTp_choiced(),examination.getTp_score(),examination.getTp_answer(),examination.getUser_id(),tp_id);
	}

	@Override
	public int add(Examination examination) {
		String sql = "insert into t_examination(tp_id,tp_title,tp_choicea,tp_choiceb,tp_choicec,tp_choiced,tp_score,tp_answer,user_id) values (seq_t_examination.nextval,?,?,?,?,?,?,?,?)";
		return DB.DML(sql, examination.getTp_title(),examination.getTp_choicea(),examination.getTp_choiceb(),examination.getTp_choicec(),examination.getTp_choiced(),examination.getTp_score(),examination.getTp_answer(),examination.getUser_id());
	}

	@Override
	public int deleteById(int tp_id) {
		String sql = "delete from t_examination where tp_id=?";
		return DB.DML(sql, tp_id);
	}

	@Override
	public Examination selectById(int tp_id) {
		String sql = "select * from t_examination where tp_id = ?";
		return (Examination) DB.selectAll(sql, Examination.class, tp_id).get(0);
	}

	@Override
	public List<Examination> selectAll() {
		String sql = "select * from t_examination";
		return DB.selectAll(sql, Examination.class);
	}

}
