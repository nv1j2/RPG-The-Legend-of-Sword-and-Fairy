package cn.nelab.pal;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class ImageTools {

	
	public static final String ROOT = "res/";
	/**
	 * ��ȡͼƬ
	 * @param resName ͼƬĿ¼���ļ���
	 * @return ͼƬ  �����ȡʧ��,����һ�����Ϊ0��ͼƬ
	 */
	public static BufferedImage readImage(String resName) {
		try{
			File file = new File(ROOT + resName);
			return ImageIO.read(file);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	}
	/**
	 * ��ȡָ��Ŀ¼��ָ��������ͼƬ
	 * @param dirName ָ��ͼƬĿ¼
	 * @param count ��ȡͼƬ������
	 * @return ͼƬ����
	 */
	public static BufferedImage[] readImage(String dirName,int count){
		BufferedImage images[] = new BufferedImage[count];
		for(int i = 0;i < count ;i++){
			images[i] = readImage(dirName + i + ".png");
		}
		return images;
	}
}
