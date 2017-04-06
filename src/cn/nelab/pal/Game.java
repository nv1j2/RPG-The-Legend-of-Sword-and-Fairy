package cn.nelab.pal;
import scene.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Game extends JFrame implements Runnable,KeyListener{
	
	/**
	 * 游戏界面宽度
	 */
	public static final int GAME_WIDTH  = 800;
	/**
	 * 游戏界面高度
	 */
	public static final int GAME_HEIGHT = 600;
	/**
	 * 游戏动画间隔
	 */
	public static final int INTERVAL    = 10;
	
	/**
	 * 场景集合
	 */
	private LiJiaCun scene = new LiJiaCun();
	
	/**
	 * 初始化游戏数据
	 */
	public Game(){

		this.setTitle("仙剑");
		this.setSize(GAME_WIDTH,GAME_HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
	}
	


	/**
	 *  启动游戏
	 */
	public void start(){
		new Thread(this).start();
	}
	
	/**
	 * 绘制游戏界面
	 */
	
	public void paint(Graphics g){
		g.drawImage(scene.getImage(), 0, 0, null);
		
	}
	
	public void run(){
		while (true) {
			this.repaint();
			try {
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


	/**
	 * 键盘按下事件
	 */
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_SPACE){
			System.out.println("sdjfsdf");
			
		}

	}

	/**
	 * 键盘弹起事件
	 */
	public void keyReleased(KeyEvent e) {
		
		 
	}
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
