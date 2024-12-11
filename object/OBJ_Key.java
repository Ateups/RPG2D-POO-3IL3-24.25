package object;

import entity.Entity;
import projetpoogame.GamePanel;

public class OBJ_Key extends Entity{
	
//	GamePanel gp;
	public OBJ_Key(GamePanel gp) {
		super(gp);
//		this.gp = gp;
		
		name = "key";
		down1 = setup("/objects/key", gp.tilesize, gp.tilesize);
		
//		try {
//			image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
//			uTool.scaleImage(image, gp.tilesize, gp.tilesize);
//		
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		
//		collision = true;
	}
	
}
