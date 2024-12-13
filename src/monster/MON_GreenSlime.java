package monster;

import java.util.Random;

import entity.Entity;
import projetpoogame.GamePanel;

public class MON_GreenSlime extends Entity{

	GamePanel gp;
	public MON_GreenSlime(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = 2;
		name = "Green Slime";
		speed = 1;
		maxLife = 20;
		life = maxLife;
		attack = 5;
		defense = 0;
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
//		sectAction();
	}
	public void getImage() {
		
		up1 = setup("/monster/greenslime_down_1", gp.tilesize, gp.tilesize);
		up2 = setup("/monster/greenslime_down_2", gp.tilesize, gp.tilesize);
		down1 = setup("/monster/greenslime_down_1", gp.tilesize, gp.tilesize);
		down2 = setup("/monster/greenslime_down_2", gp.tilesize, gp.tilesize);
		left1 = setup("/monster/greenslime_down_1", gp.tilesize, gp.tilesize);
		left2 = setup("/monster/greenslime_down_2", gp.tilesize, gp.tilesize);
		right1 = setup("/monster/greenslime_down_1", gp.tilesize, gp.tilesize);
		right2 = setup("/monster/greenslime_down_2", gp.tilesize, gp.tilesize);

	}
	public void sectAction() {
		
		actionLockCounter ++;
		   if(actionLockCounter == 120) {
			   Random random = new Random();
			   
			   int i = random.nextInt(100)+1; // chosir entre 1 a 100;
			   
			   if(i <= 25) {
				   direction = "up";
			   }
			   if(i > 25 && i <= 50) {
				   direction = "down";
			   }
			   if(i > 50 && i<= 75) {
				   direction = "left";
			   }
			   if(i >75 && i<= 100) {
				   direction = "right";
			   }
			   actionLockCounter = 0;
		   }
	}
	public void damageReaction() {
		
		actionLockCounter = 0;
		direction = gp.player.direction;
	}
}
