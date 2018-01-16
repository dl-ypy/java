package com.ypy.examination.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB {
	private static Connection conn= null;
	private static PreparedStatement ps = null;
	/**
	 * DML����װ
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int DML(String sql, Object...params) {
		int n = 0;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			if (params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDriver(conn, ps);
		}
		return -1;
	}
	
	/**
	 * ���ܲ�ѯ(DQL����װ)
	 * @param sql sql���
	 * @param cls ʵ�����class
	 * @param params SQL����еĲ�������Σ�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> selectAll(String sql, @SuppressWarnings("rawtypes") Class cls, Object...params) {
		ResultSet rs = null;
		List<T> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			if (params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			rs = ps.executeQuery();
			
			//��ȡ����
			int columnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				//�½�����
				Object instance = cls.newInstance();
				for (int i=1; i<=columnCount; i++) {
					//�õ�����
					Object obj = rs.getObject(i);
					//�жϵõ��������Ƿ�Ϊ��
					if (obj == null) {
						continue;
					}
					//�õ��ֶ���������ת��ΪСд
					String columnName = rs.getMetaData().getColumnName(i).toLowerCase();
					//�ж��Ƿ��и�����
					if (hasField(cls, columnName)) {
						//��������
						Field f = cls.getDeclaredField(columnName);
						//����Ȩ��
						f.setAccessible(true);
						if (rs.getMetaData().getColumnTypeName(i).equals("NUMBER")) {
							BigDecimal val = (BigDecimal) obj;
							if (f.getType().getName().equals("int")) {
								f.set(instance, val.intValue());
							} else if (f.getType().getName().equals("long")) {
								f.set(instance, val.longValue());
							} else {
								f.set(instance, val.doubleValue());
							}
						} else {
							//���õ����ݿ���������õ���Ӧ�����������
							f.set(instance, obj);
						}
					}
				}
				list.add((T) instance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDriver(conn, ps, rs);
		}
		return list;
	}

	/**
	 * �ж�cls�����Ƿ�������columnName
	 * @param cls
	 * @param columnName
	 * @return
	 */
	private static boolean hasField(@SuppressWarnings("rawtypes") Class cls, String columnName) {
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equals(columnName)) {
				return true;
			}
		}
		return false;
	}
}
