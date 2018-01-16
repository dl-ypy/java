package com.ypy.www.snake.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * 画布类
 * @author ypy
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel implements Runnable,KeyListener {
	private Snake snake;
	private Food food;
	private boolean gameState = true;//游戏状态
	private boolean isEat = false;//是否吃食物
	private int score = 0;//分数
	private int size; //单元格大小
	private int foodX;//食物x坐标
	private int foodY;//食物y坐标
	private int sleepTime;//睡眠时间
	private int level;//难度
	Properties pro = new Properties();
	
	
	public MyPanel() {
		super();
	}

	public MyPanel(Snake snake, int size, int level) {
		super();
		this.snake = snake;
		this.size = size;
		this.level = level;
		foodX = ((int)(Math.random()*(960/size))+1)*size;
		foodY = ((int)(Math.random()*(620/size))+1)*size;
		//确保食物与蛇不冲突
		while (foodX==snake.getCoordX() && foodY==snake.getCoordY()) {
			foodX = ((int)(Math.random()*(960/size))+1)*size;
			foodY = ((int)(Math.random()*(620/size))+1)*size;
		}
		food = new Food(foodX, foodY, snake.getSize());
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		ImageIcon img_BG = new ImageIcon("image/glass.jpg");
		g.drawImage(img_BG.getImage(), -10, -10, 1000, 800, null);
		try {
			InputStream ips = new FileInputStream(new File("snake.properties"));
			pro.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int maxScore = Integer.parseInt(pro.getProperty("maxScore"));
		if (gameState) {
			//画蛇头
			g.setColor(Color.RED);
			g.fillRect(snake.getCoordX(), snake.getCoordY(), snake.getSize(), snake.getSize());
			//画身体
			g.setColor(Color.BLACK);
			for (int i=0; i<snake.getBodys().size(); i++) {
				g.fillRect(snake.getBodys().get(i).getCoordX(), snake.getBodys().get(i).getCoordY(), snake.getBodys().get(i).getSize(), snake.getBodys().get(i).getSize());
			}
			//画食物
			g.setColor(new Color(70, 43, 120));
			g.fillRect(food.getCoordX(), food.getCoordY(), food.getSize(), food.getSize());
			//分数
			g.setColor(Color.ORANGE);
			g.setFont(new Font("华文行楷", Font.BOLD, 30));
			g.drawString("得分：" + score + "分", 830, 30);
			//难度
			String levelStr = "";
			if (level == 1) {
				levelStr = "天堂";
			} else if (level == 0) {
				levelStr = "人间";
			} else {
				levelStr = "地狱";
			}
			g.drawString("难度：" + levelStr, 20, 30);
			//最高分
			g.setColor(Color.RED);
			g.drawString("最高记录："+maxScore+"分", 400, 30);
		} else {
			g.setColor(Color.YELLOW);
			g.setFont(new Font("华文行楷", Font.BOLD, 55));
			g.drawString("game over!", 380, 270);
			g.drawString("得分：" + score + "分", 350, 330);
			g.drawString("按回车重新开始！", 280, 390);
			if (score > maxScore) {
				g.drawString("恭喜你打破记录！！！", 260, 450);
			}
		}
	}
	
	@Override
	public void run() {
		//选择游戏速度
		chooseSpeed();
		while(true) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//判断蛇与食物是否接触，吃东西时不调用移动方法
		isTouch();
		//判断是否撞到墙
		isCollideWall();
		//判断是否撞到自己身体
		isCollideBody();
		//蛇移动
		if (!isEat) {
			snake.move();
		}
		isEat = false;
		repaint();
		}
	}
	
	/**
	 * 根据难度，选择游戏速度
	 */
	public void chooseSpeed() {
		switch (level) {
		case 1:
			sleepTime = 500;
			break;
		case 0:
			sleepTime = 100;
			break;
		case -1:
			sleepTime = 50;
			break;
		default:
			break;
		}
	}
	
	/**
	 * 判断蛇与食物是否接触
	 */
	public void isTouch() {
		String dir = snake.getDir().toString();
		//确保食物与蛇不冲突
		while(true) {
			int index = 0;
			foodX = ((int)(Math.random()*(960/size))+1)*size;
			foodY = ((int)(Math.random()*(620/size))+1)*size;
			for (int i=0; i<snake.getBodys().size(); i++) {
				index++;
				if (foodX==snake.getBodys().get(i).getCoordX() && foodY==snake.getBodys().get(i).getCoordY()) {
					break;
				}
			}
			if (index==snake.getBodys().size() && (foodX!=snake.getCoordX()||foodY!=snake.getCoordY())) {
				break;
			}
		}
		switch (dir) {
		case "LEFT":
			if ((snake.getCoordX()==(food.getCoordX()+food.getSize())) && (snake.getCoordY()==food.getCoordY())) {
				//吃掉食物并且随机产生食物
				isEat = true;
				snake.eatFood(food);
				score += 5;
				food = new Food(foodX, foodY, snake.getSize());
			}
			break;
		case "RIGHT":
			if ((food.getCoordX()==(snake.getCoordX()+food.getSize())) && (snake.getCoordY()==food.getCoordY())) {
				isEat = true;
				snake.eatFood(food);
				score += 5;
				food = new Food(foodX, foodY, snake.getSize());
			}
			break;
		case "UP":
			if ((food.getCoordY()==(snake.getCoordY()-food.getSize())) && (snake.getCoordX()==food.getCoordX())) {
				isEat = true;
				snake.eatFood(food);
				score += 5;
				food = new Food(foodX, foodY, snake.getSize());
			}
			break;
		case "DOWN":
			if ((food.getCoordY()==(snake.getCoordY()+food.getSize())) && (snake.getCoordX()==food.getCoordX())) {
				isEat = true;
				snake.eatFood(food);
				score += 5;
				food = new Food(foodX, foodY, snake.getSize());
			}
			break;
		default:
			break;
		}
	}

	/**
	 * 判断是否撞到墙
	 */
	public void isCollideWall() {
		if ((snake.getCoordX()<=8&&snake.getDir().toString().equals("LEFT")) ||
				(snake.getCoordX()>=950&&snake.getDir().toString().equals("RIGHT")) ||
				(snake.getCoordY()>=630&&snake.getDir().toString().equals("DOWN")) ||
				(snake.getCoordY()<20&&snake.getDir().toString().equals("UP"))) {
			gameState = false;
		}
	}
	
	/**
	 * 判断是否撞到自己身体
	 */
	public void isCollideBody() {
		for (int i=0; i<snake.getBodys().size(); i++) {
			if ((snake.getCoordX()==snake.getBodys().get(i).getCoordX()) && (snake.getCoordY()==snake.getBodys().get(i).getCoordY())) {
				gameState = false;
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	//监听键盘输入  且确保蛇不能倒着移动
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (!"RIGHT".equals(snake.getDir().toString())){
				snake.setDir(Direction.LEFT);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (!"LEFT".equals(snake.getDir().toString())){
				snake.setDir(Direction.RIGHT);
			}
			break;
		case KeyEvent.VK_UP:
			if (!"DOWN".equals(snake.getDir().toString())){
				snake.setDir(Direction.UP);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (!"UP".equals(snake.getDir().toString())){
				snake.setDir(Direction.DOWN);
			}
		//按回车重新开始
		case KeyEvent.VK_ENTER:
			if (!gameState) {
				try {
					//将最高分数记录到配置文件中
					InputStream ips = new FileInputStream(new File("snake.properties"));
					pro.load(ips);
					int maxScore = Integer.parseInt(pro.getProperty("maxScore"));
					if (maxScore < score) {
						//修改配置文件内容
						pro.setProperty("maxScore", score+"");
						FileOutputStream fops = new FileOutputStream(new File("snake.properties"));
						pro.store(fops, "update");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				gameState = true;
				score = 0;
				snake.setCoordX(size);
				snake.setCoordY(size);
				snake.getBodys().clear();
				snake.setDir(Direction.RIGHT);
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
