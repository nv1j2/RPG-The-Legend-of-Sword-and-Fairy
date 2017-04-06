package cn.nelab.pal.role;

import java.awt.image.BufferedImage;

import cn.nelab.pal.Game;
import cn.nelab.pal.ImageTools;

public class Role {
	private static final int INTERVAL = 130;
	private int x;
	private int y;
	private int index ;
	private int intervalIndex = 0;
	private int intervaCount = INTERVAL / Game.INTERVAL;
	BufferedImage[] images;
	
	
	Role( String dirName,int count) {
		images = ImageTools.readImage(dirName, count);
	} 
	public BufferedImage getImage() {
		intervalIndex ++;
		if(intervalIndex  == intervaCount){
			index ++;
			intervalIndex = 0;
			if(index == images.length){
				index = 0;
			}
		}
		return images[index];
	}
	public int getX() {
		return this.x;
		
	}
	public int getY() {
		return this.y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void move(int x,int y){
		this.setX(x);
		this.setY(y);
	}
	
	
}
