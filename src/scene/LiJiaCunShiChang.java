package scene;
import cn.nelab.pal.ImageTools;
import cn.nelab.pal.role.AWangShen;

public class LiJiaCunShiChang extends Scene{

	public LiJiaCunShiChang() {
		image = ImageTools.readImage("李家村市场/0.png");
		this.move(0, 0);
		AWangShen aWangShen = new AWangShen();
		aWangShen.move(100, 100);
		this.addRole( aWangShen);
	}

}
