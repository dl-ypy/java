package com.ypy.www.snake.tesk;

import java.awt.event.KeyAdapter;
import java.io.IOException;
import com.ypy.www.snake.model.MyFrame;
/**
 * date:2017��7��12��17:46:26
 * ������
 * @author ypy
 */
public class Test extends KeyAdapter{

	public static void main(String[] args) {
		try {
			MyFrame.draw();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
