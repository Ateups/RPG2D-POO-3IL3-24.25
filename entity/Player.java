/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import object.OBJ_Shield_Wood;
import object.OBJ_Weapon_Normal;
import projetpoogame.GamePanel;
import projetpoogame.KeyHandler;


/**
 *
 * @author lion
 */
public class Player extends Entity{
//    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
//    public int hasKey = 0;
    int standCounter = 0;
    public boolean attackCanceled = false;
    
    public Player(GamePanel gp, KeyHandler keyH){
    	
    	super(gp);
    	
//        this.gp=gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tilesize/2);
        screenY = gp.screenHeight/2 - (gp.tilesize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        solidArea.width = 32;
        solidArea.height = 32;
        
        attackArea.width = 36;
        attackArea.height = 36;
        
        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }

    private void setDefaultValues() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    	worldX = gp.tilesize * 23;
    	worldY = gp.tilesize * 21;

//    	worldX = gp.tilesize * 10;
//    	worldY = gp.tilesize * 13;

        speed = 4;
        direction = "down";
        
        // PLAYER STATUS;
        level = 1;
        maxLife = 6;
        life = maxLife;
        strenght = 1;
        dexterity = 1;
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
        currentWeapon = new OBJ_Weapon_Normal(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        attack = getAttack();
        defense = getDefense();
    }
    public int getAttack() {
    	
    	return attack - strenght * currentWeapon.attackValue;
    }
    public int getDefense() {
    	return defense - dexterity * currentShield.defenseValue;
    }
    
    public void getPlayerImage() {
//    	try {
//    		up1 = ImageIO.read(getClass().getResourceAsStream("/player/man_up_1.png"));
//    		up2 = ImageIO.read(getClass().getResourceAsStream("/player/man_up_2.png"));
//    		down1 = ImageIO.read(getClass().getResourceAsStream("/player/man_down_1.png"));
//    		down2 = ImageIO.read(getClass().getResourceAsStream("/player/man_down_2.png"));
//    		left1 = ImageIO.read(getClass().getResourceAsStream("/player/man_left_1.png"));
//    		left2 = ImageIO.read(getClass().getResourceAsStream("/player/man_left_2.png"));
//    		right1 = ImageIO.read(getClass().getResourceAsStream("/player/man_right_1.png"));
//    		right2 = ImageIO.read(getClass().getResourceAsStream("/player/man_right_2.png"));
//    	}catch(IOException e){
//    		e.printStackTrace();
//    		
//    	}
    	up1 = setup("/player/man_up_1", gp.tilesize, gp.tilesize);
    	up2 = setup("/player/man_up_2", gp.tilesize, gp.tilesize);
    	down1 = setup("/player/man_down_1", gp.tilesize, gp.tilesize);
    	down2 = setup("/player/man_down_2", gp.tilesize, gp.tilesize);
    	left1 = setup("/player/man_left_1", gp.tilesize, gp.tilesize);
    	left2 = setup("/player/man_left_2", gp.tilesize, gp.tilesize);
    	right1 = setup("/player/man_right_1", gp.tilesize, gp.tilesize);
    	right2 = setup("/player/man_right_2", gp.tilesize, gp.tilesize);
    }
    
    public void getPlayerAttackImage() {
//    	
    	attackUp1 = setup("/player/man_attack_up_1", gp.tilesize, gp.tilesize*2);
    	attackUp2 = setup("/player/man_attack_up_2", gp.tilesize, gp.tilesize*2);
    	attackDown1 = setup("/player/man_attack_down_1", gp.tilesize, gp.tilesize*2);
    	attackDown2 = setup("/player/man_attack_down_2", gp.tilesize, gp.tilesize*2);
    	attackLeft1 = setup("/player/man_attack_left_1", gp.tilesize*2, gp.tilesize);
    	attackLeft2 = setup("/player/man_attack_left_2", gp.tilesize*2, gp.tilesize);
    	attackRight1 = setup("/player/man_attack_right_1", gp.tilesize*2, gp.tilesize);
    	attackRight2 = setup("/player/man_attack_right_2", gp.tilesize*2, gp.tilesize);
    }
    
//    public BufferedImage setup(String imageName) {
//    	
//    	UtilityTool uTool = new UtilityTool();
//    	BufferedImage image = null;
//    	
//    	try {
//    		image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
//    		image = uTool.scaleImage(image, gp.tilesize, gp.tilesize);
//    	}catch(IOException e) {
//    		e.printStackTrace();
//    	}
//    	return image;
//    }
//    
    public void update(){
    	
    	if(attacking == true) {
    		attacking();
    	}
    	else if(keyH.upPressed == true || keyH.downPressed == true ||
    			keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true) {
    		
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
    		 	
    		 // Check object collision
    		 	int objIndex = gp.cChecker.checkObject(this, true);
    		 	pickUpObject(objIndex);
    		 	
    		 	//CHECK NPC COLLISION
    		 	int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
    		 	interactNPC(npcIndex);
    		 	
    		 	//CHECK MONSTER COLLISION;
    		 	int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
    		 	contactMonster(monsterIndex);
    		 	
    		 	// CHECK EVENT;
    		 	gp.eHandler.checkEvent();
    		 	
    		 	// IF COLLISION IS FALSE, PLAYER CAN MOVE
    		 	if(collisionOn == false && keyH.enterPressed == false) {
    		 		
    		 		switch(direction) {
    		 		case "up":worldY -= speed;break;
    		 		case "down":worldY += speed;break;
    		 		case "left": worldX -= speed;break;
    		 		case "right":worldX += speed;break;
    		 		}
    		 	}
    		 	
    		 	if(keyH.enterPressed == true && attackCanceled == true) {
    		 		gp.playSE(7);
    		 		attacking = true;
    		 		spriteCounter = 0;
    		 	}
    		 	
    		 	attackCanceled = false;
    		 	gp.keyH.enterPressed = false;
    		 			
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
    		}
	    	else {
	    		standCounter++;
	    		if(standCounter == 20) {
	    			spriteNum = 1;
	    			standCounter = 0;
	    		}
	    	}
    	
    	// this needs to be outaide of key igt statement
    	if(invincible == true) {
    		invinciblecounter++;
    		if(invinciblecounter > 60) {
    			invincible = false;
    			invinciblecounter = 0;
    		}
    	}
       
   }

    public void attacking() {
    	
    	spriteCounter++;
    	
    	if(spriteCounter <= 5) {
    		spriteNum = 1;
    	}
    	if(spriteCounter > 5 && spriteCounter <= 25) {
    		spriteNum = 2;
    		
    		//save the current wordx, worldy, solidArea;
    		int currentWorldX = worldX;
    		int currentWorldY = worldY;
    		int solidAreaWidth = solidArea.width;
    		int solidAreaHeight = solidArea.height;
    		
    		//adjust player's worldx/y for the attackArea
    		switch(direction) {
    		case "up": worldY -= attackArea.height; break;
    		case "down": worldY += attackArea.height; break;
    		case "left": worldX -= attackArea.width; break;
    		case "right": worldX += attackArea.width; break;
    		}
    		// attackArea become solidArea.
    		solidArea.width = attackArea.width;
    		solidArea.height = attackArea.height;
    		//CHECK MONSTER COLLISION WITH THE UPDATED 
    		int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
    		damageMonster(monsterIndex);
    		
    		//after checking collision
    		worldX = currentWorldX;
    		worldY = currentWorldY;
    		solidArea.width = solidAreaWidth;
    		solidArea.height = solidAreaHeight;
    	}
    	if(spriteCounter > 25) {
    		spriteNum = 1;
    		spriteCounter = 0;
    		attacking = false;
    	}
    }
    public void pickUpObject(int i) {
    	if(i != 999) {
//    		gp.obj[i] = null;
//    		String objectName = gp.obj[i].name;
//    		
//    		switch(objectName) {
//    		case "key":
//    			gp.playSE(1);
//    			hasKey++;
//    			gp.obj[i] = null;
////    				System.out.println("key :"+hasKey);
//    			gp.ui.showMessage("une cle recue!");
//    			break;
//    		case "Door":
//    			if(hasKey > 0) {
//    				gp.playSE(3);
//    				gp.obj[i] = null;
//    				hasKey--;
//    				gp.ui.showMessage("porte ouverte!");
//    			}else{
//    				gp.ui.showMessage("cle manquante!");
//    			}
////				System.out.println("key :"+hasKey);
//				break;
//    		case "Boots":
//    			gp.playSE(2);
//    			speed += 1;
//    			gp.obj[i] = null;
//    			gp.ui.showMessage("Accelerez!");
//    			break;
//    		case "Chest":
//    			gp.ui.gameFinished = true;
//    			gp.stopMusic();
//    			gp.playSE(4);
//    			break;
//    		}
    	}
    	
    	
    }
    public void interactNPC(int i ) {
    	
    	if(gp.keyH.enterPressed == true) {
    		if(i != 999) {
    			attackCanceled = true;
        			gp.gameState = gp.dialogueState;
            		gp.npc[i].speak();
        		
        	}
  
    	}
    }
    public void contactMonster(int i) {
    	
    	if(i != 999) {
    		if(invincible == false) {
    			gp.playSE(6);
        		life -= 1; 
        		invincible = true;
    		}
    	}
    }
    public void damageMonster(int i) {
    	if(i != 999) {
    		
    		if(gp.monster[i].invincible == false) {
    			
    			gp.playSE(5);
    			gp.monster[i].life -= 1;
    			gp.monster[i].invincible = true;
    			gp.monster[i].damageReaction();
    			
    			if(gp.monster[i].life <= 0) {
    				gp.monster[i].dying = true;
    			}
    		}
    	}
    }
    public void draw(Graphics2D g2){

    	BufferedImage image = null;
    	int tempScreenX = screenX;
    	int tempScreenY = screenY;
    	
    	switch(direction) {
	    	case "up":
	    		if(attacking == false) {
	    			if(spriteNum == 1) { image = up1;}
		    		if(spriteNum == 2) { image = up2;}
	    		}
	    		if(attacking == true) {
	    			tempScreenY = screenY - gp.tilesize;
	    			if(spriteNum == 1) {image = attackUp1;}
		    		if(spriteNum == 2) {image = attackUp2;}
	    		}
	    		break;
	    	case "down":
	    		if(attacking == false) {
	    			if(spriteNum == 1) {image = down1;}
		    		if(spriteNum == 2) {image = down2;}
	    		}
	    		if(attacking == true) {
	    			if(spriteNum == 1) {image = attackDown1;}
		    		if(spriteNum == 2) {image = attackDown2;}
	    		}
	    		break;
	    	case "left":
	    		if(attacking == false) {
	    			if(spriteNum == 1) {image = left1;}
		    		if(spriteNum == 2) {image = left2;}
	    		}
	    		if(attacking == true) {
	    			tempScreenX = screenX - gp.tilesize;
	    			if(spriteNum == 1) {image = attackLeft1;}
		    		if(spriteNum == 2) {image = attackLeft2;}
	    		}
	    		break;
	    	case "right":
	    		if(attacking == false) {
	    			if(spriteNum == 1) {image = right1;}
		    		if(spriteNum == 2) {image = right2;}
	    		}
	    		if(attacking == true) {
	    			if(spriteNum == 1) {image = attackRight1;}
		    		if(spriteNum == 2) {image = attackRight2;}
	    		}
	    		break;
	    	
	    	}
    	
	    	if(invincible == true) {
	    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
	    	}
	    	g2.drawImage(image, tempScreenX, tempScreenY, null);
	    	
	    	// Reset alpha;
	    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	    	//deburgs
	//    	g2.setFont(new Font("Arial", Font.PLAIN, 30));
	//    	g2.setColor(Color.white);
	//    	g2.drawString("Invincible:" +invinciblecounter, 10, 400);
    	
    }
    
    
}
