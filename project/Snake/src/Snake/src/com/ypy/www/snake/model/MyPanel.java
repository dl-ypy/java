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
 * ������
 * @author ypy
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel implements Runnable,KeyListener {
	private Snake snake;
	private Food food;
	private boolean gameState = true;//��Ϸ״̬
	private boolean isEat = false;//�Ƿ��ʳ��
	private int score = 0;//����
	private int size; //��Ԫ���С
	private int foodX;//ʳ��x����
	private int foodY;//ʳ��y����
	private int sleepTime;//˯��ʱ��
	private int level;//�Ѷ�
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
		//ȷ��ʳ�����߲���ͻ
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
			//����ͷ
			g.setColor(Color.RED);
			g.fillRect(snake.getCoordX(), snake.getCoordY(), snake.getSize(), snake.getSize());
			//������
			g.setColor(Color.BLACK);
			for (int i=0; i<snake.getBodys().size(); i++) {
				g.fillRect(snake.getBodys().get(i).getCoordX(), snake.getBodys().get(i).getCoordY(), snake.getBodys().get(i).getSize(), snake.getBodys().get(i).getSize());
			}
			//��ʳ��
			g.setColor(new Color(70, 43, 120));
			g.fillRect(food.getCoordX(), food.getCoordY(), food.getSize(), food.getSize());
			//����
			g.setColor(Color.ORANGE);
			g.setFont(new Font("�����п�", Font.BOLD, 30));
			g.drawString("�÷֣�" + score + "��", 830, 30);
			//�Ѷ�
			String levelStr = "";
			if (level == 1) {
				levelStr = "����";
			} else if (level == 0) {
				levelStr = "�˼�";
			} else {
				levelStr = "����";
			}
			g.drawString("�Ѷȣ�" + levelStr, 20, 30);
			//��߷�
			g.setColor(Color.RED);
			g.drawString("��߼�¼��"+maxScore+"��", 400, 30);
		} else {
			g.setColor(Color.YELLOW);
			g.setFont(new Font("�����п�", Font.BOLD, 55));
			g.drawString("game over!", 380, 270);
			g.drawString("�÷֣�" + score + "��", 350, 330);
			g.drawString("���س����¿�ʼ��", 280, 390);
			if (score > maxScore) {
				g.drawString("��ϲ����Ƽ�¼������", 260, 450);
			}
		}
	}
	
	@Override
	public void run() {
		//ѡ����Ϸ�ٶ�
		chooseSpeed();
		while(true) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�ж�����ʳ���Ƿ�Ӵ����Զ���ʱ�������ƶ�����
		isTouch();
		//�ж��Ƿ�ײ��ǽ
		isCollideWall();
		//�ж��Ƿ�ײ���Լ�����
		isCollideBody();
		//���ƶ�
		if (!isEat) {
			snake.move();
		}
		isEat = false;
		repaint();
		}
	}
	
	/**
	 * �����Ѷȣ�ѡ����Ϸ�ٶ�
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
	 * �ж�����ʳ���Ƿ�Ӵ�
	 */
	public void isTouch() {
		String dir = snake.getDir().toString();
		//ȷ��ʳ�����߲���ͻ
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
				//�Ե�ʳ�ﲢ���������ʳ��
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
	 * �ж��Ƿ�ײ��ǽ
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
	 * �ж��Ƿ�ײ���Լ�����
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

	//������������  ��ȷ���߲��ܵ����ƶ�
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
		//���س����¿�ʼ
		case KeyEvent.VK_ENTER:
			if (!gameState) {
				try {
					//����߷�����¼�������ļ���
					InputStream ips = new FileInputStream(new File("snake.properties"));
					pro.load(ips);
					int maxScore = Integer.parseInt(pro.getProperty("maxScore"));
					if (maxScore < score) {
						//�޸������ļ�����
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
