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
		 dialogue[0] = "Un lion dormait paisiblement dans la savane lorsqu’un petit rat, en jouant, lui courut sur le nez. Enragé, le lion attrapa le rat dans ses griffes.\r\n"
		 		+ "« Pourquoi ne devrais-je pas te dévorer ? » rugit-il.\r\n"
		 		+ "Le rat répondit : « Si tu me laisses vivre, je te rendrai service un jour. »\r\n"
		 		+ "Le lion éclata de rire : « Comment un si petit être pourrait-il aider un roi ? » Mais, amusé, il relâcha le rat.\r\n"
		 		+ "Quelques jours plus tard, le lion fut pris dans un piège. Incapable de se libérer, il rugit de désespoir. Le petit rat, entendant son appel, accourut et rongea les cordes du piège jusqu’à ce que le lion soit libre.\r\n"
		 		+ "Le lion comprit que même les plus petits peuvent être précieux.";
		 dialogue[1] = "Un jour, la hyène et le lièvre trouvèrent un arbre rempli de fruits mûrs. Mais l’arbre était si haut qu’ils ne pouvaient pas atteindre les fruits.\r\n"
		 		+ "Le lièvre dit : « Construisons une tour avec des pierres pour atteindre le sommet. »\r\n"
		 		+ "La hyène, paresseuse, répondit : « Pourquoi ne pas attendre qu’un vent les fasse tomber ? »\r\n"
		 		+ "Le lièvre commença seul à empiler les pierres et atteignit les fruits. Pendant qu’il mangeait, la hyène, affamée, lui demanda de partager.\r\n"
		 		+ "Le lièvre lui lança des fruits pourris et dit : « La patience et le travail nourrissent, mais la paresse laisse le ventre vide. »";
		 dialogue[2] = "Un oiseau cherchait un endroit pour boire lorsqu’il trouva un étang habité par un crocodile. Le crocodile lui dit :\r\n"
		 		+ "« Viens, approche, je ne te ferai rien. »\r\n"
		 		+ "L’oiseau répondit : « Merci, mais je vais boire d’un arbre. »\r\n"
		 		+ "Le crocodile insista : « Pourquoi douter de moi ? Je suis honnête. »\r\n"
		 		+ "L’oiseau répliqua : « Ton sourire cache des dents acérées. Mieux vaut être prudent que mort. »\r\n"
		 		+ "Et l’oiseau s’envola. Peu après, un autre animal fut dévoré par le crocodile.\r\n"
		 		+ "Ce conte enseigne que la prudence est une forme de sagesse.\r\n"
		 		+ "\r\n"
		 		+ "";
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
