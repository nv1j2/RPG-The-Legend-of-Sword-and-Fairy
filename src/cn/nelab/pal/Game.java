package cn.nelab.pal;
import scene.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Game extends JFrame implements Runnable,KeyListener{
	
	/**
	 * ��Ϸ������
	 */
	public static final int GAME_WIDTH  = 800;
	/**
	 * ��Ϸ����߶�
	 */
	public static final int GAME_HEIGHT = 600;
	/**
	 * ��Ϸ�������
	 */
	public static final int INTERVAL    = 10;
	
	/**
	 * ��������
	 */
	private LiJiaCun scene = new LiJiaCun();
	
	/**
	 * ��ʼ����Ϸ����
	 */
	public Game(){

		this.setTitle("�ɽ�");
		this.setSize(GAME_WIDTH,GAME_HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
	}
	


	/**
	 *  ������Ϸ
	 */
	public void start(){
		new Thread(this).start();
	}
	
	/**
	 * ������Ϸ����
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
	 * ���̰����¼�
	 */
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_SPACE){
			System.out.println("sdjfsdf");
			
		}

	}

	/**
	 * ���̵����¼�
	 */
	public void keyReleased(KeyEvent e) {
		
		 
	}
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
