package projetpoogame;

import entity.NPC_OldMan;
import monster.MON_GreenSlime;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
//		gp.obj[0] = new OBJ_Key(gp);
//		gp.obj[0].worldX = 23 * gp.tilesize;
//		gp.obj[0].worldY = 7 * gp.tilesize;
//		
//		gp.obj[1] = new OBJ_Key(gp);
//		gp.obj[1].worldX = 23 * gp.tilesize;
//		gp.obj[1].worldY = 40 * gp.tilesize;
//		
//		gp.obj[2] = new OBJ_Key(gp);
//		gp.obj[2].worldX = 30 * gp.tilesize;
//		gp.obj[2].worldY = 8 * gp.tilesize;
//		
//		gp.obj[0] = new OBJ_Door(gp);
//		gp.obj[0].worldX = 10 * gp.tilesize;
//		gp.obj[0].worldY = 10 * gp.tilesize;
//		
//		gp.obj[1] = new OBJ_Door(gp);
//		gp.obj[1].worldX = 8 * gp.tilesize;
//		gp.obj[1].worldY = 26 * gp.tilesize;
//		
//		gp.obj[5] = new OBJ_Door(gp);
//		gp.obj[5].worldX = 12 * gp.tilesize;
//		gp.obj[5].worldY = 22 * gp.tilesize;
//		
//		gp.obj[6] = new OBJ_Chest(gp);
//		gp.obj[6].worldX = 10 * gp.tilesize;
//		gp.obj[6].worldY = 7 * gp.tilesize;
		
//		gp.obj[7] = new OBJ_Boots(gp);
//		gp.obj[7].worldX = 37 * gp.tilesize;
//		gp.obj[7].worldY = 12 * gp.tilesize;
		
	}
	
	
	public void setNPC() {
		
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tilesize*21;
		gp.npc[0].worldY = gp.tilesize*21;
		
//		gp.npc[0] = new NPC_OldMan(gp);
//		gp.npc[0].worldX = gp.tilesize*9;
//		gp.npc[0].worldY = gp.tilesize*10;
////		
//		gp.npc[2] = new NPC_OldMan(gp);
//		gp.npc[2].worldX = gp.tilesize*31;
//		gp.npc[2].worldY = gp.tilesize*21;
//		
//		gp.npc[3] = new NPC_OldMan(gp);
//		gp.npc[3].worldX = gp.tilesize*21;
//		gp.npc[3].worldY = gp.tilesize*11;
//		
//		gp.npc[4] = new NPC_OldMan(gp);
//		gp.npc[4].worldX = gp.tilesize*21;
//		gp.npc[4].worldY = gp.tilesize*31;
		
	}
	public void setMonster() {
		
		gp.monster[0] = new MON_GreenSlime(gp);
		gp.monster[0].worldX = gp.tilesize*23;
		gp.monster[0].worldY = gp.tilesize*36;
		
		gp.monster[1] = new MON_GreenSlime(gp);
		gp.monster[1].worldX = gp.tilesize*23;
		gp.monster[1].worldY = gp.tilesize*37;
	
//		gp.monster[0] = new MON_GreenSlime(gp);
//		gp.monster[0].worldX = gp.tilesize*11;
//		gp.monster[0].worldY = gp.tilesize*10;
//		
//		gp.monster[1] = new MON_GreenSlime(gp);
//		gp.monster[1].worldX = gp.tilesize*10;
//		gp.monster[1].worldY = gp.tilesize*11;
		
	}
	
	
	
	
}
