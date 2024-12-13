package object;

import entity.Entity;
import projetpoogame.GamePanel;

public class OBJ_Weapon_Normal extends Entity{
 
	public OBJ_Weapon_Normal(GamePanel gp) {
		super(gp);
		
		name = " Normal Sword";
		down1 = setup("/objects/sword_normal", gp.tilesize, gp.tilesize);
		attackValue = 1;
	}
}
