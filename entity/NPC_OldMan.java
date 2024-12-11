package entity;

import java.util.Random;

import projetpoogame.GamePanel;


public class NPC_OldMan extends Entity{

	public NPC_OldMan(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
		setDialogue();
	}
	 public void getImage() { 

	    	up1 = setup("/npc/oldman_up_1", gp.tilesize, gp.tilesize);
	    	up2 = setup("/npc/oldman_up_2", gp.tilesize, gp.tilesize);
	    	down1 = setup("/npc/oldman_down_1", gp.tilesize, gp.tilesize);
	    	down2 = setup("/npc/oldman_down_2", gp.tilesize, gp.tilesize);
	    	left1 = setup("/npc/oldman_left_1", gp.tilesize, gp.tilesize);
	    	left2 = setup("/npc/oldman_left_2", gp.tilesize, gp.tilesize);
	    	right1 = setup("/npc/oldman_right_1", gp.tilesize, gp.tilesize);
	    	right2 = setup("/npc/oldman_right_2", gp.tilesize, gp.tilesize);
	    }
	 public void setDialogue() {
		 dialogue[0] = "Hello, Franc.....\n Sdkoi boy ?, t'es au courant de la forch?...";
		 dialogue[1] = "Hi !!! \n c7 Oklm avec moi etw ?";
		 dialogue[2] = "J'ai grave les nerfs, c'st grav la, il a une  prime sur la \nrecherche du tresor, \ngar help moi";
		 dialogue[3] = "crache le morceau, quoi se passe.... ?";
		 dialogue[4] = "je veux trouver le tresor brother ...";
//		 dialogue[0] = "Hello, Franc";
	 }
	   public void setAction() {
		   
//		   actionLockCounter ++;
//		   if(actionLockCounter == 120) {
//			   Random random = new Random();
//			   int i = random.nextInt(100)+1; // chosiir entre 1 a 100;
//			   if(i <= 25) {
//				   direction = "up";
//			   }
//			   if(i > 25 && i <= 50) {
//				   direction = "down";
//			   }
//			   if(i > 50 && i<= 75) {
//				   direction = "left";
//			   }
//			   if(i >75 && i<= 100) {
//				   direction = "right";
//			   }
//			   actionLockCounter = 0;
//		   }
	   }
	   public void speak() {
//		   if(dialogue[dialogueIndex] == null) {
//			   dialogueIndex = 0;
//		   }
//		   
//		   gp.ui.currentDialogue = dialogue[dialogueIndex];
//		   dialogueIndex++;
//		   
//		   switch(gp.player.direction) {
//		   case "up":
//			   direction = "down";
//			   break;
//		   case "down":
//			   direction = "up";
//			   break;
//		   case "left":
//			   direction = "right";
//			   break;
//		   case "right":
//			   direction = "left";
//			   break;
//		   }
		   // DO THIS CHARACTER SPECIFIC STAFF;
		   super.speak();
	   }
}
