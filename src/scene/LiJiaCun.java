package scene;

import cn.nelab.pal.ImageTools;
import cn.nelab.pal.role.AWangShen;
import cn.nelab.pal.role.AZhu;
import cn.nelab.pal.role.Role;
import cn.nelab.pal.role.TiaoSheng;
import cn.nelab.pal.role.WangCaiSao;

/**
 * ��Ҵ峡����
 * @author Ned
 *
 */
public class LiJiaCun extends Scene {
	
	public LiJiaCun() {
		image = ImageTools.readImage("��Ҵ�/0.png");
		this.addRole(new AWangShen());
		this.addRole(new WangCaiSao());
		this.addRole(new AZhu());
		this.addRole(new TiaoSheng());
		this.move(300, 300);
	}
	
	
}
