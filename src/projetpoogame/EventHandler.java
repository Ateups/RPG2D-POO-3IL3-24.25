package projetpoogame;

public class EventHandler {

	GamePanel gp;
//	Rectangle eventRect;
//	int eventRectDefaultX, eventRectDefaultY;
	EventRect eventRect[][];
	
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];
		
		int col = 0;
		int row = 0;
		while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
			eventRect[col][row] = new EventRect();
			eventRect[col][row].x = 23;
			eventRect[col][row].y = 23;
			eventRect[col][row].width = 2;
			eventRect[col][row].height = 2;
			eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
			eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
			
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
			}
				
		}
		

	}
	public void checkEvent() {
		// CHECK IF THE PLAYER CHAACTER IS MORE THAN I TILE AWAY FRM
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if(distance > gp.tilesize) {
			canTouchEvent = true;
		}
		
		if(canTouchEvent == true) {
			if(hit(27, 16, "right") == true) {damagerPit(27, 16, gp.dialogueState);}
			if(hit(27, 16, "right") == true) {teleport(gp.dialogueState);}
			if(hit(23, 19, "any") == true) {damagerPit(27, 16, gp.dialogueState);}
			if(hit(23, 12, "up") == true) {healingPool(23, 12, gp.dialogueState);}

		}
		
	}
	public boolean hit(int col, int row, String regDirection) {
		
		boolean hit = false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRect[col][row].x = col*gp.tilesize + eventRect[col][row].x;
		eventRect[col][row].y = row*gp.tilesize + eventRect[col][row].y;
		
		if(gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false) {
			if(gp.player.direction.contentEquals(regDirection) || regDirection.contentEquals("any")) {
				hit = true;
				
				previousEventX = gp.player.worldX;
				previousEventY = gp.player.worldY;
			}
		}
		
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
		eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
		
		
		return hit;
	}
	public void teleport(int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "Teleport!";
		gp.player.worldX = gp.tilesize*37;
		gp.player.worldY = gp.tilesize*7;

	}
	
	public void damagerPit(int col, int row, int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "Vous etes tombés dqns un trou !";
		gp.player.life -= 1; 
//		eventRect[col][row].eventDone = true;
		canTouchEvent = false;
	}
	public void healingPool(int col, int row, int gameState) {
		
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gameState;
			gp.ui.currentDialogue = "Vous veew de boire de l eau sacrée. \n vos points de vie ont ete restaurés.";
			gp.player.life = gp.player.maxLife;
		}
		
//		gp.keyH.enterPressed = false;
	}
	
	
}
