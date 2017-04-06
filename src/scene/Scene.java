package scene;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import cn.nelab.pal.Game;
import cn.nelab.pal.role.Role; 


/**
 * ≥°æ∞∏∏¿‡
 * @author Ned
 *
 */
public class Scene {
	ArrayList<Role> roles = new ArrayList<>();
	
	BufferedImage image;
	private int x = 300;
	private int y = 300;
	
	
	public BufferedImage getImage(){
		BufferedImage temp = new BufferedImage(Game.GAME_WIDTH, Game.GAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics g = temp.getGraphics();
		g.drawImage(image, -this.getX(), -this.getY(), null);
		for(int i = 0; i < roles.size();i ++){
			
			g.drawImage(roles.get(i).getImage(), roles.get(i).getX() - this.getX(), roles.get(i).getY() - this.getY(), null); 
		}
		g.dispose();
		return temp;
	}
	
	public void addRole(Role role){
		roles.add(role);
	}
	public int getX() {
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void move(int x,int y){
		setX(x);
		setY(y);
	}
	
	
}
