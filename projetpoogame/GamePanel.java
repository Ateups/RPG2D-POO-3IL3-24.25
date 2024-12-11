 /* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetpoogame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import tile.TileManager;
/**
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
//    public final int worldWidth = tilesize * maxWorldCol;
//    public final int worldHeight = tilesize * maxWorldRow;
   
    // FPS
    int FPS = 60;
    
    //System
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Sound music =  new Sound();
    Sound se =  new Sound();

    //ENTITY AND PBJECT
    public Player player = new Player(this, keyH);
//    
    public Entity obj[] = new Entity[10];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];
    
    ArrayList<Entity> entityList = new ArrayList<>();
    
//    int playerX = 100;
//    int playerY=100;
//    int playerSpeed =4;

    // GAME STATE
    public int gameState;
    public final int tileState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    
    public GamePanel(){
    
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
        
    }
    
    public void setupGame() {
    	aSetter.setObject();
    	aSetter.setNPC();
    	aSetter.setMonster();
//    	playMusic(0);
//    	stopMusic();
    	
    	gameState = playState;
    	gameState = tileState;
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
		//      System.out.println("FPS" + drawCount);
		        drawCount = 0;
		        timer = 0;
		    }
		    
		}
  }  
   public void update(){
//       if(keyH.upPressed==true){
//           playerY -= playerSpeed;
//          // playerY = playerY - playerSpeed;
//        }
//       else if(keyH.downPressed==true){
//           playerY += playerSpeed;
//       }
//       else if(keyH.leftPressed==true){
//           playerX -= playerSpeed;
//       }
//       else if(keyH.rightPressed==true){
//           playerX += playerSpeed;
//       }
	   if(gameState == playState) {
		   //PLAYER
		   player.update();
		   //NPC
		   for(int i = 0; i < npc.length; i++) {
			   if(npc[i] != null) {
				   npc[i].update();
			   }
		   }
		   for(int i = 0; i<monster.length; i++) {
			   if(monster[i] != null) {
				   if(monster[i].alive == true && monster[i].dying == false) {
					   monster[i].update();
				   }
				   if(monster[i].alive == false) {
					   monster[i] = null;
				   }
				   
			   }
		   }
	   }
	   if(gameState == pauseState) {
		   // NOTHING
	   }
//	   player.update();
   }
  public void paintComponent(Graphics g){
       super.paintComponent(g);
       
       Graphics2D g2 = (Graphics2D)g;
       //DEBURGS 
       long drawStart = 0;
       if(keyH.checkDrawTime == true) {
    	      drawStart = System.nanoTime();
       }
       // TILE SCREEN
       if(gameState == tileState) {
    	   ui.draw(g2);
       }
       // OTHERS
       else {
	       tileM.draw(g2);
	       
	       //ADD ENTITY TO THE LIST
	       entityList.add(player);
	       
	       for(int i = 0 ; i < npc.length; i++) {
	    	   if(npc[i] != null) {
	    		   entityList.add(npc[i]);
	    	   }
	       }
	       for(int i = 0; i<obj.length; i++) {
	    	   if(obj[i] != null) {
	    		   entityList.add(obj[i]);
	    	   }
	       }
	       for(int i = 0; i<monster.length; i++) {
	    	   if(monster[i] != null) {
	    		   entityList.add(monster[i]);
	    	   }
	       }
	       
	       // SORT
	       Collections.sort(entityList, new Comparator<Entity>() {
	    	   
	    	   @Override
	    	   public int compare(Entity e1, Entity e2) {
	    		   //TODO Auto-generated method atub
	    		   int result = Integer.compare(e1.worldY, e2.worldY);
	    		   return result;
	    	   }
	       });
	       
	       // DRAW ENTITIES 
	       for (int i = 0; i < entityList.size(); i++) {
		    	  entityList.get(i).draw(g2);
		      }
	      //EMPTY ENTITY LIST
	       entityList.clear();
	    	   
	    	   // OBJECT 
	
//	       for(int i = 0; i<obj.length; i++) {
//	    	   if(obj[i] != null) {
//	    		   obj[i].draw(g2, this);
//	    	   }
//	       }
//	       // NPC
//	       for(int i=0; i<npc.length; i++) {
//	    	   if(npc[i] != null) {
//	    		   npc[i].draw(g2);
//	    	   }
//	       }
//       
//       //PLAYER
//       player.draw(g2);
//       g2.setColor(Color.white);
//       g2.fillRect(playerX, playerY, tilesize, tilesize);
       
       // UI
	       ui.draw(g2);
       }
       //DEBURGS
       if(keyH.checkDrawTime == true) {
    	   long drawEnd = System.nanoTime();
           long passed = drawEnd - drawStart;
           g2.setColor(Color.white);
           g2.drawString("Temps de tirage :" +passed, 10, 400);
           System.out.println("Temps de tirage :"+passed);
       }
       
       g2.dispose();
   }
    public void playMusic(int i) {
    	music.setFile(i);
    	music.play();
    	music.loop();
    }
    public void stopMusic() {
    	music.stop();
    }
    public void playSE(int i) {
    	se.setFile(i);
    	se.play();
    }
}
