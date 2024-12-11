package object;

import entity.Entity;
import projetpoogame.GamePanel;

public class OBJ_Chest extends Entity{
//	GamePanel gp;
	
	public OBJ_Chest(GamePanel gp) {
//		this.gp = gp;
		super(gp);
		name = "Chest";
		
		down1 = setup("/objects/chest", gp.tilesize, gp.tilesize);
//		try {
//			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
//			uTool.scaleImage(image, gp.tilesize, gp.tilesize);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		collision = true;
	}
}
