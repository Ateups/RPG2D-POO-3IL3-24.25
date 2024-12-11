package object;

import entity.Entity;
import projetpoogame.GamePanel;

public class OBJ_Shield_Wood extends Entity{

	public OBJ_Shield_Wood(GamePanel gp) {
		super(gp);
		
		name = " Woor=d Shield";
		down1 = setup("/objects/shield_wood", gp.tilesize, gp.tilesize);
		defenseValue = 1;
		
	}
}
