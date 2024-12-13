package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import projetpoogame.GamePanel;
import projetpoogame.UtilityTool;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[50];
		
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map.txt");
		loadMap("/maps/worldV2.txt");

	}
	
	public void getTileImage() {
//		try {
//			tile[0] = new Tile();
//			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
		
//			BufferedImage scaledImage = new BufferedImage(gp.tilesize, gp.tilesize, tile[0].image.getType());
//			Graphics2D g2 = scaledImage.createGraphics();
//			g2.drawImage(tile[0].image, 0, 0, gp.tilesize, gp.tilesize, null);
//			tile[0].image = scaledImage;
		
		//PLA EHOLDER
//			setup(0, "grass", false);
//			setup(1, "wall", true);
//			setup(2, "walter", true);
//			setup(3, "earth", false);
//			setup(4, "tree", true);
//			setup(5, "sand", false);
//			setup(6, "sand", false);
//			setup(7, "sand", false);
//			setup(8, "sand", false);
//			setup(9, "sand", false);
		
			setup(0, "grass", false);
			setup(1, "grass", true);
			setup(2, "grass", true);
			setup(3, "grass", false);
			setup(4, "grass", true);
			setup(5, "grass", false);
			setup(6, "grass", false);
			setup(7, "grass", false);
			setup(8, "grass", false);
			setup(9, "grass", false);
			
			setup(10, "grass", false);
			setup(11, "grass01", false);
			setup(12, "walter00", true);
			setup(13, "walter01", true);
			setup(14, "walter02", true);
			setup(15, "walter03", true);
			setup(16, "walter04", true);
			setup(17, "walter05", true);
			setup(18, "walter06", true);
			setup(19, "walter07", true);
			setup(20, "walter08", true);
			setup(21, "walter09", true);
			setup(22, "walter10", true);
			setup(23, "walter11", true);
			setup(24, "walter12", true);
			setup(25, "walter13", true);
			setup(26, "road00", false);
			setup(27, "road01", false);
			setup(28, "road02", false);
			setup(29, "road03", false);
			setup(30, "road04", false);
			setup(31, "road05", false);
			setup(32, "road06", false);
			setup(33, "road07", false);
			setup(34, "road08", false);
			setup(35, "road09", false);
			setup(36, "road10", false);
			setup(37, "road11", false);
			setup(38, "road12", false);
			setup(39, "earth", false);
			setup(40, "wall", true);
			setup(41, "tree", true);
			
			
//			tile[1] = new Tile();
//			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
//			tile[1].collision = true;
//			
//			tile[2] = new Tile();
//			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/walter.png"));
//			tile[2].collision = true;
//			
//			tile[3] = new Tile();
//			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
//		
//			tile[4] = new Tile();
//			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
//			tile[4].collision = true;
//			
//			tile[5] = new Tile();
//			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
		
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
	}
	public void setup(int index, String imageName, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
			try {
				tile[index] = new Tile();
				tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imageName+".png"));
				
				tile[index].image = uTool.scaleImage(tile[index].image, gp.tilesize, gp.tilesize);
				tile[index].collision = collision;

			}catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
					
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		
		}catch(Exception e) {
			
		}
	}
	
	
	public void draw(Graphics2D g2) {
		
//		g2.drawImage(tile[1].image, 0, 0, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[1].image, 48, 0, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[1].image, 96, 0, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[1].image, 144, 0, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[1].image, 192, 0, gp.tilesize, gp.tilesize, null);
//
//		g2.drawImage(tile[1].image, 0, 48, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 48, 48, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 96, 48, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 144, 48, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[1].image, 192, 48, gp.tilesize, gp.tilesize, null);
//
//		g2.drawImage(tile[1].image, 0, 96, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 48, 96, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 96, 96, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 144, 96, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 192, 96, gp.tilesize, gp.tilesize, null);
//
//		g2.drawImage(tile[1].image, 0, 144, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 48, 144, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 96, 144, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[0].image, 144, 144, gp.tilesize, gp.tilesize, null);
//	 	g2.drawImage(tile[1].image, 192, 144, gp.tilesize, gp.tilesize, null);
//
//		g2.drawImage(tile[1].image, 0, 192, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[2].image, 48, 192, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[2].image, 96, 192, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[2].image, 144, 192, gp.tilesize, gp.tilesize, null);
//		g2.drawImage(tile[1].image, 192, 192, gp.tilesize, gp.tilesize, null);

		int WorldCol = 0;
		int WorldRow = 0;
//		int x = 0;
//		int y = 0;
		 
		while(WorldCol <gp.maxWorldCol && WorldRow<gp.maxWorldRow) {
			
			int tileNum = mapTileNum[WorldCol][WorldRow];
			
			int worldX = WorldCol * gp.tilesize;
			int worldY = WorldRow * gp.tilesize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tilesize > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tilesize< gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tilesize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tilesize< gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
				
			}
			WorldCol++;
//			x += gp.tilesize;
			
			if(WorldCol == gp.maxWorldCol) {
				WorldCol = 0;
//				x = 0;
				WorldRow++;
//				y += gp.tilesize;
			}
		}
	} 
}
