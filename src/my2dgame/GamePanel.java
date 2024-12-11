/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my2dgame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;

import tile.TileManager;
/**
 *
 * @author lion
 */
public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize =16;
   final int scale = 3;
   public final int tilesize = originalTileSize * scale; 
   public final int maxScreenCol = 16;
   public final int maxScreenRow = 12;
   public final int screenWidth = tilesize * maxScreenCol;
   public final int screenHeight = tilesize * maxScreenRow;
  
   // WORLD SETINGS
   public final int maxWorldCol = 50;
   public final int maxWorldRow = 50;
   public final int worldWidth = tilesize * maxWorldCol;
   public final int worldHeight = tilesize * maxWorldRow;
  
   // FPS
   int FPS = 60;
   
   
   TileManager tileM = new TileManager(this);
   KeyHandler keyH = new KeyHandler();
   Thread gameThread;
   public CollisionChecker cChecker = new CollisionChecker(this);
  
   public AssetSetter aSetter = new AssetSetter(this);
   
   public Player player = new Player(this,keyH);
//   
   public SuperObject obj[] = new SuperObject[10];
//   int playerX = 100;
//   int playerY=100;
//   int playerSpeed =4;
//   
   public GamePanel(){
   
       this.setPreferredSize(new Dimension(screenWidth,screenHeight));
       this.setBackground(Color.black);
       this.setDoubleBuffered(true);
       this.addKeyListener(keyH);
       this.setFocusable(true);
       
       
   }
   
   public void setupGame() {
   	aSetter.setObject();
   }
   
   public void StartGameThread(){
       gameThread = new Thread(this);
       gameThread.start();
   }

 @Override
 /* public void run(){
      double drawInterval = 1000000000/FPS;
      double nextDrawTime = System.nanoTime()+ drawInterval;
      
      
      while(gameThread != null){
          //long currentTime = System.nanoTime();
         // long currentTime2 = System.currentTimeMillis();
         // System.out.println("current Time"+currentTime);
        update();
        repaint();
        
        
        try{
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime/1000000;
            if(remainingTime < 0){
                remainingTime =0;
            }
            
             Thread.sleep((long) remainingTime);
             
             nextDrawTime += drawInterval;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
      }
  }*/
  public void run(){
	  
      double drawInterval = 1000000000/FPS;
      double delta = 0;
      long lastTime =System.nanoTime();
      long currentTime;
      long timer = 0;
      int drawCount = 0;
      
while (gameThread != null){
   
   currentTime = System.nanoTime();
   
   delta += (currentTime - lastTime) / drawInterval;
   timer += (currentTime - lastTime);
   lastTime = currentTime;
   
   if(delta >= 1){
      update();
      repaint(); 
      delta--;
      drawCount++;
   }
   if(timer >= 1000000000){
       System.out.println("FPS" + drawCount);
       drawCount = 0;
       timer = 0;
   }
   
}
}  
  public void update(){
//      if(keyH.upPressed==true){
//          playerY -= playerSpeed;
//         // playerY = playerY - playerSpeed;
//       }
//      else if(keyH.downPressed==true){
//          playerY += playerSpeed;
//      }
//      else if(keyH.leftPressed==true){
//          playerX -= playerSpeed;
//      }
//      else if(keyH.rightPressed==true){
//          playerX += playerSpeed;
//      }
//
	   player.update();
  }
 public void paintComponent(Graphics g){
      super.paintComponent(g);
      
      Graphics2D g2 = (Graphics2D)g;
      
      // TILE 
      tileM.draw(g2);
      
      // OBJECT 
      
      for(int i = 0; i<obj.length;i++) {
   	   if(obj[i] != null) {
   		   obj[i].draw(g2, this);
   	   }
      }
      //PLAYER
      player.draw(g2);
//      g2.setColor(Color.white);
//      g2.fillRect(playerX, playerY, tilesize, tilesize);
      g2.dispose();
  }
    
}
