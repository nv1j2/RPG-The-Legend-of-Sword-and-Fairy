package test.xx;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;

class MyJframe extends JFrame implements Runnable{
    int mapX = -300,mapY = -300;
    int lxyIndex = 0;
    int lxyDirection = 8;
    float AwsIndex = 0;//������
    int AwsX = 600,AwsY = 600;
    float WcsTndex = 0;//����ɩ
    int WcsX = 500,WcsY = 450;
    float AzwjIndex = 0;//����ι��
    int AzwjX = 400,AzwjY = 650;
    
    Image LxyImage;
    Image LxyUpImage[] = new Image[8];
    Image LxyDownImage[] = new Image[8];
    Image LxyLeftImage[] = new Image[8];
    Image LxyRightImage[] = new Image[8];
    Image AwsImage[] = new Image[17];
    Image WcsImage[] = new Image[14];
    Image AzwjImage[] = new Image[6];
    public MyJframe(){
        for(int i = 0;i < 8;i ++){
            LxyUpImage[i] = new ImageIcon("res/����ң/����ң8/" + i + ".png").getImage();
            LxyDownImage[i] = new ImageIcon("res/����ң/����ң2/" + i + ".png").getImage();
            LxyLeftImage[i] = new ImageIcon("res/����ң/����ң4/" + i + ".png").getImage();
            LxyRightImage[i] = new ImageIcon("res/����ң/����ң6/" + i + ".png").getImage();
        }
        LxyImage = LxyDownImage[0];
        for(int i = 0;i < AwsImage.length;i++){
            AwsImage[i] = new ImageIcon("res/������/" + i + ".png").getImage();
        }
        for(int i = 0;i < WcsImage.length;i++){
            WcsImage[i] = new ImageIcon("res/����ɩ/" + i + ".png").getImage();
        }
        for(int i = 0;i < AzwjImage.length;i++){
            AzwjImage[i] = new ImageIcon("res/����ι��/" + i + ".png").getImage();
        }
    }
    
    public void paint(Graphics g){
       
        BufferedImage bufferedImage = new BufferedImage(800,600,2);//��,��,��ɫ���� ;2Ϊ����͸��ͨ��
        Graphics buffereG = bufferedImage.getGraphics();
        ImageIcon mapLjcImageIcon = new ImageIcon("res/��Ҵ�/0.png");
        //ImageIcon LxyImageIcon = new ImageIcon("res/����ң/����ң" + lxyDirection + "/" + lxyIndex + ".png");    
        buffereG.drawImage(mapLjcImageIcon.getImage(),mapX,mapY,null);//��ͼ����ײ�
        buffereG.drawImage(AwsImage[(int)AwsIndex],AwsX+mapX,AwsY+mapY,null);//������
        buffereG.drawImage(WcsImage[(int)WcsTndex],WcsX+mapX,WcsY+mapY,null);//����ɩ
        buffereG.drawImage(AzwjImage[(int)AzwjIndex],AzwjX+mapX,AzwjY+mapY,null);//����ι��
        
        buffereG.drawImage(LxyImage,400,300,null);//����ң
        g.drawImage(bufferedImage,0,0,null);
    }
    public void processKeyEvent(KeyEvent e){        //��������¼�
        int id = e.getID(); //��������Ϣ��������
        if(id == 401){                              //401���̰���
            int code = e.getKeyCode();
            if(code == 37){//��
                mapX ++;
                lxyIndex ++;
                if(lxyIndex >= LxyLeftImage.length){
                    lxyIndex = 0;
                }
                LxyImage = LxyLeftImage[lxyIndex];
            }
            else if(code == 38){//��
                mapY ++;
                lxyIndex ++;
                if(lxyIndex >= LxyUpImage.length){
                    lxyIndex = 0;
                }
                LxyImage = LxyUpImage[lxyIndex];
            }
            else if(code == 39){//��
                mapX --;
                lxyIndex ++;
                if(lxyIndex >= LxyRightImage.length){
                    lxyIndex = 0;
                }

                LxyImage = LxyRightImage[lxyIndex];
            }
            else if(code == 40){//��
                mapY --;
                lxyIndex ++;
                if(lxyIndex >= LxyDownImage.length){
                    lxyIndex = 0;
                }
                LxyImage = LxyDownImage[lxyIndex];
            }

            //System.out.println(id);
            repaint();
        }
    }
    public void run(){
        while(true){
            AwsIndex ++;
            WcsTndex ++;
            AzwjIndex ++;
            if(AwsIndex >= AwsImage.length){
                AwsIndex = 0;
            }
            if(WcsTndex >= WcsImage.length){
                WcsTndex = 0;
            }
            if(AzwjIndex >= AzwjImage.length){
                AzwjIndex = 0;
            }
            repaint();
            try{
                Thread.sleep(130);
            }
            catch(Exception e){}
        }
    }
}

public class Game{
    public static void main(String[] args){
    MyJframe windows = new MyJframe();
    windows.setSize(800,600);  //�����С
    //JFrame windows[] = new JFrame[10];
    //for(int i = 0;i < 10;i ++)
        
    Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize(); // �����ʾ����С���� 
    Dimension frameSize = windows.getSize();             // ��ô��ڴ�С����  
    if(frameSize.width > displaySize.width)
        frameSize.width = displaySize.width;           // ���ڵĿ�Ȳ��ܴ�����ʾ���Ŀ��  
    if(frameSize.height > displaySize.height)
        frameSize.height = displaySize.height;          // ���ڵĸ߶Ȳ��ܴ�����ʾ���ĸ߶�  
    windows.setLocation((displaySize.width - frameSize.width)/2,(displaySize.height - frameSize.height)/2); //���ô��ھ�����ʾ����ʾ 

    windows.setVisible(true);//��ʾ����,�������
    Thread thread = new Thread(windows);//�������߲�
    thread.start();
    }
}