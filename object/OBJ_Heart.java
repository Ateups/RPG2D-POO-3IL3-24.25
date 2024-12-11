package object;

import entity.Entity;
import projetpoogame.GamePanel;
 
public class OBJ_Heart extends Entity{

//	GamePanel gp;
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		//		this.gp = gp;
		name = "Heart";
		
		image = setup("/objects/heart_full", gp.tilesize, gp.tilesize);
		image2 = setup("/objects/heart_half", gp.tilesize, gp.tilesize);
		image3 = setup("/objects/heart_blank", gp.tilesize, gp.tilesize);
		
//		try {
//			image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
//			image2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
//			image3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
//
//			image = uTool.scaleImage(image, gp.tilesize, gp.tilesize);
//			image2 = uTool.scaleImage(image2, gp.tilesize, gp.tilesize);
//			image3 = uTool.scaleImage(image3, gp.tilesize, gp.tilesize);
//
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		
//		collision = true;
	}
}
