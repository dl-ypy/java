package com.ypy.www.snake.tesk;

import java.awt.event.KeyAdapter;
import java.io.IOException;
import com.ypy.www.snake.model.MyFrame;
/**
 * date:2017年7月12日17:46:26
 * 测试类
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
