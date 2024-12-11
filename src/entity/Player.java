/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import my2dgame.GamePanel;
import my2dgame.KeyHandler;


/**
 *
 * @author lion
 */
public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
   
    
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp=gp;
        this.keyH=keyH;
        
        screenX = gp.screenWidth/2 - (gp.tilesize/2);
        screenY = gp.screenHeight/2 - (gp.tilesize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultx = solidArea.x;
        solidAreaDefaulty = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        
        setDefaultValues();
        getPlayerImage();
    }

    private void setDefaultValues() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    	worldX = gp.tilesize * 23;
    	worldY = gp.tilesize * 21;
    	x = 100;
        y = 100;
        speed = 4;
        
        direction = "down";
    }
    //////
    public void getPlayerImage() {
    	try {
    		up1 = ImageIO.read(getClass().getResourceAsStream("/player/man_up_1.png"));
    		up2 = ImageIO.read(getClass().getResourceAsStream("/player/man_up_2.png"));
    		down1 = ImageIO.read(getClass().getResourceAsStream("/player/man_down_1.png"));
    		down2 = ImageIO.read(getClass().getResourceAsStream("/player/man_down_2.png"));
    		left1 = ImageIO.read(getClass().getResourceAsStream("/player/man_left_1.png"));
    		left2 = ImageIO.read(getClass().getResourceAsStream("/player/man_left_2.png"));
    		right1 = ImageIO.read(getClass().getResourceAsStream("/player/man_right_1.png"));
    		right2 = ImageIO.read(getClass().getResourceAsStream("/player/man_right_2.png"));
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    public void update(){
    	
    	if(keyH.upPressed == true || keyH.downPressed == true ||
    			keyH.leftPressed == true || keyH.rightPressed == true) {
    		
    		 if(keyH.upPressed == true){
    	        	direction = "up";
//    	            worldY -= speed;
    	        }
    	        else if(keyH.downPressed == true){
    	        	direction = "down";
//    	        	worldY += speed;
    	        }
    	        else if(keyH.leftPressed == true){
    	        	direction = "left";
//    	        	 worldX -= speed;
    	        }
    	        else if(keyH.rightPressed == true){
    	        	direction = "right";
//    	            worldX += speed;
    	        }
    	        
    		 // CHECK TILE COLLISION
    		 
    		 	collisionOn = false;
    		 	gp.cChecker.checkTile(this);
    		 	
    		 	int objIndex = gp.cChecker.checkObject(this, true);
    		 	pickUpObject(objIndex);
    		 
    		 	// IF COLLISION IS FALSE, PLAYER CAN MOVE
    		 	if(collisionOn == false) {
    		 		
    		 		switch(direction) {
    		 		case "up":
    		 			worldY -= speed;
    		 			break;
    		 		case "down":
    		 			worldY += speed;
    		 			break;
    		 		case "left":
    		 			 worldX -= speed;
    		 			break;
    		 		case "right":
    		 			worldX += speed;
    		 			break;
    		 		}
    		 	}
    	        spriteCounter++;
    	        if(spriteCounter > 10) {
    	        	if(spriteNum == 1) {
    	        		spriteNum = 2;
    	        	}
    	        	else if(spriteNum == 2) {
    	        		spriteNum = 1;
    	        	}
    	        	spriteCounter = 0;
    	        }
    	}
       
   }
    public void pickUpObject(int i) {
    	if(i != 999) {
    		gp.obj[i] = null;
    	}
    }

    public void draw(Graphics2D g2){
    	
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    	
    	BufferedImage image = null;
    	
    	switch(direction) {
	    	case "up":
	    		if(spriteNum == 1) {
	    			image = up1;
	    		}
	    		
	    		if(spriteNum == 2) {
	    			image = up2;
	    		}
	    		break;
	    	case "down":
	    		if(spriteNum == 1) {
		    		image = down1;
	    		}
	    		if(spriteNum == 2) {
		    		image = down2;
	    		}
	    		break;
	    	case "left":
	    		if(spriteNum == 1) {
		    		image = left1;
	    		}
	    		if(spriteNum == 2) {
		    		image = left2;
	    		}
	    		break;
	    	case "right":
	    		if(spriteNum == 1) {
		    		image = right1;
	    		}
	    		if(spriteNum == 2) {
		    		image = right2;
	    		}
	    		break;
	    	
	    }
    	g2.drawImage(image, screenX, screenY, gp.tilesize, gp.tilesize, null);
    }
    
    
}
