package object;

import entity.Entity;
import projetpoogame.GamePanel;

public class OBJ_Door extends Entity {
//	GamePanel gp;
	
	public OBJ_Door(GamePanel gp) {
		super(gp);
		name = "Door";
		down1 = setup("/objects/door", gp.tilesize, gp.tilesize);
		
		
//		try {
//			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
//			uTool.scaleImage(image, gp.tilesize, gp.tilesize);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		collision = true;
		
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
}