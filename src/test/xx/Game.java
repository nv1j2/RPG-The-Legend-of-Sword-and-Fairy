package test.xx;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;

class MyJframe extends JFrame implements Runnable{
    int mapX = -300,mapY = -300;
    int lxyIndex = 0;
    int lxyDirection = 8;
    float AwsIndex = 0;//阿旺婶
    int AwsX = 600,AwsY = 600;
    float WcsTndex = 0;//旺财嫂
    int WcsX = 500,WcsY = 450;
    float AzwjIndex = 0;//阿朱喂鸡
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
            LxyUpImage[i] = new ImageIcon("res/李逍遥/李逍遥8/" + i + ".png").getImage();
            LxyDownImage[i] = new ImageIcon("res/李逍遥/李逍遥2/" + i + ".png").getImage();
            LxyLeftImage[i] = new ImageIcon("res/李逍遥/李逍遥4/" + i + ".png").getImage();
            LxyRightImage[i] = new ImageIcon("res/李逍遥/李逍遥6/" + i + ".png").getImage();
        }
        LxyImage = LxyDownImage[0];
        for(int i = 0;i < AwsImage.length;i++){
            AwsImage[i] = new ImageIcon("res/阿旺婶/" + i + ".png").getImage();
        }
        for(int i = 0;i < WcsImage.length;i++){
            WcsImage[i] = new ImageIcon("res/旺财嫂/" + i + ".png").getImage();
        }
        for(int i = 0;i < AzwjImage.length;i++){
            AzwjImage[i] = new ImageIcon("res/阿朱喂鸡/" + i + ".png").getImage();
        }
    }
    
    public void paint(Graphics g){
       
        BufferedImage bufferedImage = new BufferedImage(800,600,2);//宽,高,颜色类型 ;2为包含透明通道
        Graphics buffereG = bufferedImage.getGraphics();
        ImageIcon mapLjcImageIcon = new ImageIcon("res/李家村/0.png");
        //ImageIcon LxyImageIcon = new ImageIcon("res/李逍遥/李逍遥" + lxyDirection + "/" + lxyIndex + ".png");    
        buffereG.drawImage(mapLjcImageIcon.getImage(),mapX,mapY,null);//地图，最底层
        buffereG.drawImage(AwsImage[(int)AwsIndex],AwsX+mapX,AwsY+mapY,null);//阿旺婶
        buffereG.drawImage(WcsImage[(int)WcsTndex],WcsX+mapX,WcsY+mapY,null);//旺财嫂
        buffereG.drawImage(AzwjImage[(int)AzwjIndex],AzwjX+mapX,AzwjY+mapY,null);//阿朱喂鸡
        
        buffereG.drawImage(LxyImage,400,300,null);//李逍遥
        g.drawImage(bufferedImage,0,0,null);
    }
    public void processKeyEvent(KeyEvent e){        //处理键盘事件
        int id = e.getID(); //或许按键信息返回整型
        if(id == 401){                              //401键盘按下
            int code = e.getKeyCode();
            if(code == 37){//左
                mapX ++;
                lxyIndex ++;
                if(lxyIndex >= LxyLeftImage.length){
                    lxyIndex = 0;
                }
                LxyImage = LxyLeftImage[lxyIndex];
            }
            else if(code == 38){//上
                mapY ++;
                lxyIndex ++;
                if(lxyIndex >= LxyUpImage.length){
                    lxyIndex = 0;
                }
                LxyImage = LxyUpImage[lxyIndex];
            }
            else if(code == 39){//右
                mapX --;
                lxyIndex ++;
                if(lxyIndex >= LxyRightImage.length){
                    lxyIndex = 0;
                }

                LxyImage = LxyRightImage[lxyIndex];
            }
            else if(code == 40){//下
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
    windows.setSize(800,600);  //窗体大小
    //JFrame windows[] = new JFrame[10];
    //for(int i = 0;i < 10;i ++)
        
    Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize(); // 获得显示器大小对象 
    Dimension frameSize = windows.getSize();             // 获得窗口大小对象  
    if(frameSize.width > displaySize.width)
        frameSize.width = displaySize.width;           // 窗口的宽度不能大于显示器的宽度  
    if(frameSize.height > displaySize.height)
        frameSize.height = displaySize.height;          // 窗口的高度不能大于显示器的高度  
    windows.setLocation((displaySize.width - frameSize.width)/2,(displaySize.height - frameSize.height)/2); //设置窗口居中显示器显示 

    windows.setVisible(true);//显示窗口,放在最后
    Thread thread = new Thread(windows);//创建新线层
    thread.start();
    }
}