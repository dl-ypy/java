package com.ypy.www.snake.model;

import java.util.ArrayList;
/**
 * ����
 * @author ypy
 */
public class Snake {
	private int coordX;//��ͷx����
	private int coordY;//��ͷy����
	private Direction dir;//�ƶ�����
	private ArrayList<Snake> bodys;//�ߵ�����
	private int size;//��Ԫ���С
	public Snake(int coordX, int coordY, Direction dir, int size) {
		this();
		this.coordX = coordX;
		this.coordY = coordY;
		this.dir = dir;
		this.size = size;
	}
	public Snake() {
		super();
		bodys = new ArrayList<>();
	}
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public int getCoordX() {
		return coordX;
	}
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	public int getCoordY() {
		return coordY;
	}
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ArrayList<Snake> getBodys() {
		return bodys;
	}
	public void setBodys(ArrayList<Snake> bodys) {
		this.bodys = bodys;
	}
	
	/**
	 * ��ʳ��
	 * @param food
	 */
	public void eatFood(Food food) {
		Snake body = null;
		//���֮ǰû������  �ͽ�����ŵ�ͷ����
		if (bodys.size() == 0) {
			body = new Snake(this.coordX, this.coordY, this.dir, this.size);
		} else {//����У��ͽ�����ǰ��һ�ڣ��൱���ƶ�����������ŵ����һ���������
			String Dir = bodys.get(bodys.size()-1).getDir().toString();
			move();
			switch (Dir) {
			case "LEFT":
				body = new Snake(bodys.get(bodys.size()-1).getCoordX()+food.getSize(), bodys.get(bodys.size()-1).getCoordY(), bodys.get(bodys.size()-1).dir,this.size);
				break;
			case "RIGHT":
				body = new Snake(bodys.get(bodys.size()-1).getCoordX()-food.getSize(), bodys.get(bodys.size()-1).getCoordY(), bodys.get(bodys.size()-1).dir,this.size);
				break;
			case "UP":
				body = new Snake(bodys.get(bodys.size()-1).getCoordX(), bodys.get(bodys.size()-1).getCoordY()+food.getSize(), bodys.get(bodys.size()-1).dir,this.size);
				break;
			case "DOWN":
				body = new Snake(bodys.get(bodys.size()-1).getCoordX(), bodys.get(bodys.size()-1).getCoordY()-food.getSize(), bodys.get(bodys.size()-1).dir,this.size);
				break;
			default:
				break;
			}
		}
		bodys.add(body);
		this.coordX = food.getCoordX();
		this.coordY = food.getCoordY();
	}
	
	/**
	 * �ƶ�  ͷ���ƶ�size��С�����岿��ÿһ�ڵ���ǰһ�ڵ�λ��
	 */
	public void move() {
		String headDir = this.getDir().toString();
		int[] arrX = new int[bodys.size()+1];
		int[] arrY = new int[bodys.size()+1];
		Direction[] arrDir = new Direction[bodys.size()+1];
		arrX[0] = this.getCoordX();
		arrY[0] = this.getCoordY();
		arrDir[0] = this.getDir();
		switch (headDir) {
		case "LEFT":
			this.coordX -= size;
			break;
		case "RIGHT":
			this.coordX += size;
			break;
		case "UP":
			this.coordY -= size;
			break;
		case "DOWN":
			this.coordY += size;
			break;
		default:
			break;
		}
		for (int i=1; i<arrX.length; i++) {
			arrX[i] = bodys.get(i-1).getCoordX();
			arrY[i] = bodys.get(i-1).getCoordY();
			arrDir[i] = bodys.get(i-1).getDir();
		}
		for (int i=0; i<bodys.size(); i++) {
			bodys.get(i).setCoordX(arrX[i]);
			bodys.get(i).setCoordY(arrY[i]);
			bodys.get(i).setDir(arrDir[i]);
		}
	}
}
