/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import projetpoogame.GamePanel;
import projetpoogame.UtilityTool;

public class Entity {
    
	GamePanel gp;
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2,
    attackLeft1, attackLeft2, attackRight1, attackRight2; 
    public BufferedImage image, image2, image3;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collision = false;
    String dialogue[] = new String[20];
    
    //STATE
    public int worldX, worldY;
    public String direction = "down";
    public int spriteNum = 1;
    int dialogueIndex = 0;
    public boolean collisionOn = false;
    public boolean invincible = false;
    boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
	boolean hpBarOn = false;
    
	// COUNTER 
    public int spriteCounter = 0;
    public int actionLockCounter = 0;
    public int invinciblecounter = 0;
    int dyingCounter = 0;
    int hpBarCounter = 0;
    
    //CHARACTERE STATUS;
    public int type; // 0 = player, 1 = npc, 2 = monster
	public String name;
	public int speed;
    public int maxLife;
    public int life;
    public int level;
    public int strenght;
    public int dexterity;
    public int attack;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public Entity currentWeapon;
    public Entity currentShield;
    
    //ITEMS ATTRIBUTS
    public int attackValue;
    public int defenseValue;
    
    public Entity(GamePanel gp) {
    	this.gp = gp;
    }
    
    public void setAction() {
    	
    }
    public void damageReaction() {
    	
    }
    public void speak() {
    	
    	if(dialogue[dialogueIndex] == null) {
			   dialogueIndex = 0;
		   }
		   
		   gp.ui.currentDialogue = dialogue[dialogueIndex];
		   dialogueIndex ++;
		   
		   switch(gp.player.direction) {
		   case "up":
			   direction = "down";
			   break;
		   case "down":
			   direction = "up";
			   break;
		   case "left":
			   direction = "right";
			   break;
		   case "right":
			   direction = "left";
			   break;
		   }
    }
    public void update() {
    	
    	setAction();
    	
    	collisionOn = false;
    	gp.cChecker.checkTile(this);
    	gp.cChecker.checkObject(this, false);
    	gp.cChecker.checkEntity(this, gp.npc);
    	gp.cChecker.checkEntity(this, gp.monster);
//    	gp.cChecker.checkPlayer(this);
    	boolean contactPlayer = gp.cChecker.checkPlayer(this);
    	
    	if(this.type == 2 && contactPlayer == true) {
    		if(gp.player.invincible == false) {
    			// we can give damage
    			gp.playSE(6);
    			
    			int damage = attack - gp.player.defense;
    			if(damage < 0) {
    				damage = 0;
    			}
        		gp.player.life -= damage; 
//    			gp.player.life -= 1;
    			gp.player.invincible = true;
    		} 
    	}
    	
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
        if(spriteCounter > 12) {
        	if(spriteNum == 1) {
        		spriteNum = 2;
        	}
        	else if(spriteNum == 2) {
        		spriteNum = 1;
        	}
        	spriteCounter = 0;
        }
        
        if(invincible == true) {
    		invinciblecounter++;
    		if(invinciblecounter > 60) {
    			invincible = false;
    			invinciblecounter = 0;
    		}
    	}
    }
    public void draw(Graphics2D g2) {
    	
    	BufferedImage image = null;
    	int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.tilesize > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.tilesize< gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tilesize > gp.player.worldY - gp.player.screenY &&
		   worldY - gp.tilesize< gp.player.worldY + gp.player.screenY) {
			
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
			
			//monster hp bar
			if(type == 2 && hpBarOn == true) {
				double oneScale = (double)gp.tilesize/maxLife;
				double hpBarValue = oneScale*life;
				
				g2.setColor(new Color(35,35,35));
				g2.fillRect(screenX-1,  screenY-16, gp.tilesize+2, 12);
				
				g2.setColor(new Color(255, 0, 30));
				g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 10);
				
				hpBarCounter++;
				if(hpBarCounter > 600) {
					hpBarCounter = 0;
					hpBarOn = false;
				}
				
			}
			
			if(invincible == true) {
				
				hpBarOn = true;
				hpBarCounter = 0;

				changeAlpha(g2,0.4F);
//	    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
	    	}
			if(dying == true) {
				dyingAnimation(g2);
			}
			
			g2.drawImage(image,screenX, screenY, gp.tilesize, gp.tilesize, null);
			
			changeAlpha(g2,1F);
//    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

		}
    }
    public void dyingAnimation(Graphics2D g2) {
    	
    	dyingCounter++;
    	
    	int i = 5;
    	if(dyingCounter <= i) {
//    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
    		changeAlpha(g2,0f);
    	}
    	if(dyingCounter > i && dyingCounter <= i*2) {
//    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    		changeAlpha(g2,1f);
    	}
    	if(dyingCounter > i*2 && dyingCounter <= i*3) {
//    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
    		changeAlpha(g2,0f);
    	}
    	if(dyingCounter > i*3 && dyingCounter <= i*4) {
//    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    		changeAlpha(g2,1f);
    	}
    	if(dyingCounter > i*4 && dyingCounter <= i*5) {
//    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
    		changeAlpha(g2,0f);
    	}
    	if(dyingCounter > i*5 && dyingCounter <= i*6) {
//    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    		changeAlpha(g2,1f);
    	}
    	if(dyingCounter > i*6 && dyingCounter <= i*7) {
//    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
    		changeAlpha(g2,0f);
    	}
    	if(dyingCounter > i*7 && dyingCounter <= i*8) {
//    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    		changeAlpha(g2,1f);
    	}
    	if(dyingCounter > i*8) {
    		dying = false;
    		alive = false;
    	}
    }
    public void changeAlpha(Graphics2D g2, float alphaValue) {
    	
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));

    }
    public BufferedImage setup(String imagePath, int width, int height) {
    	
    	UtilityTool uTool = new UtilityTool();
    	BufferedImage image = null;
    	
    	try {
    		image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
    		image = uTool.scaleImage(image, width, height);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	return image;
    }
    
}
