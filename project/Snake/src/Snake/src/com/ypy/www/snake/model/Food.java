package com.ypy.www.snake.model;
/**
 *  ≥ŒÔ¿‡
 * @author ypy
 */
public class Food {
	private int coordX;
	private int coordY;
	private int size;
	public Food() {
		super();
	}
	public Food(int coordX, int coordY, int size) {
		super();
		this.coordX = coordX;
		this.coordY = coordY;
		this.size = size;
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
}
