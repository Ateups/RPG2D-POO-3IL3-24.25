package projetpoogame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import object.OBJ_Heart;

public class UI {
	
	GamePanel gp;
	Graphics2D g2;
//	Font maruMonica, purinaB;
	Font arial_40, arial_800;
	
	BufferedImage heart_full, heart_half, heart_blank;
//	BufferedImage keyImage;
	
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public String currentDialogue = "";
	public int commandNum = 0;
	public int tileScreenState = 0; // the first screen
//	double playTime;
//	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(GamePanel gp) {
		this.gp = gp;	
		
//		try {
//			InputStream is = getClass().getResourceAsStream("font/");
//			maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
//			is = getClass().getResourceAsStream("font/Purina Bold.ttf");
//			purinaB = Font.createFont(Font.TRUETYPE_FONT, is);
//		} catch (FontFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		arial_40 = new Font("Cambria", Font.PLAIN, 40);
		arial_800 = new Font("Arial", Font.BOLD, 80);
//		OBJ_Key key = new OBJ_Key(gp);
//		keyImage = key.image;
		
		// CREATE HUD OBJECTS 
		Entity heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
	}
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
	}
	public void draw(Graphics2D g2) {    
		
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		// TILE STATE
		if(gp.gameState == gp.tileState) {
			drawTileScreen();
		}
		//PLAY STATE
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
			//PAUSE STATE
		}
		if(gp.gameState == gp.pauseState) {   //
			drawPlayerLife();
			drawPauseScreen();
		}
		// DIALOGUE;
		if(gp.gameState == gp.dialogueState) {
			drawPlayerLife();
			drawDialogueScreen();
		}
//		if(gameFinished == true) {
//			g2.setFont(arial_40);
//			g2.setColor(Color.white);
//			
//			String text;
//			int textLength;
//			int x;
//			int y;
//			
//			text = "T'as trouve le tresor!";
//			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//			x = gp.screenWidth/2 - textLength/2;
//			y = gp.screenHeight/2 - (gp.tilesize*3);
//			g2.drawString(text, x, y);
//			
//			text = "Ton temps est : "+dFormat.format(playTime) + "!";
//			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//			x = gp.screenWidth/2 - textLength/2;
//			y = gp.screenHeight/2 + (gp.tilesize*4);
//			g2.drawString(text, x, y);
//			
//			g2.setFont(arial_800);
//			g2.setColor(Color.yellow);
//			text = "Congratulation!";
//			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//			x = gp.screenWidth/2 - textLength/2;
//			y = gp.screenHeight/2 + (gp.tilesize*2);
//			g2.drawString(text, x, y);
//			
//			gp.gameThread = null;
//			
//			
//		}else {
//			g2.setFont(arial_40);
//			g2.setColor(Color.white);
//			g2.drawImage(keyImage, gp.tilesize/2, gp.tilesize/2, gp.tilesize, gp.tilesize, null);
//			g2.drawString("    x "+gp.player.hasKey, 20, 65);
//			
//			//TIME
//			playTime += (double)1/60;
//			g2.drawString("Time:"+ dFormat.format(playTime), gp.tilesize*11, 65);
//			//message
//			if(messageOn == true) {
//				g2.setFont(g2.getFont().deriveFont(30F));
//				g2.drawString(message, gp.tilesize/2, gp.tilesize*5);
//				
//				messageCounter++;
//				if(messageCounter > 120) {
//					messageCounter = 0;
//					messageOn = false;
//				}
//			}
//		}
		
	}
	public void drawPlayerLife() {
		
//		gp.player.life = 3;
		int x = gp.tilesize/2;
		int y = gp.tilesize/2;
		int i = 0;
		
		// DRAW BLANK
		
		while(i<gp.player.maxLife/2) {
			g2.drawImage(heart_blank, x, y, null);
			i++;
			x += gp.tilesize;
			
		}
		// HEART
		 x = gp.tilesize/2;
		 y = gp.tilesize/2;
		 i = 0;
		 
		 // CURRENT LIFE
		 while (i<gp.player.life) {
			 g2.drawImage(heart_half, x, y, null);
			 i++;
			 if(i<gp.player.life) {
				 g2.drawImage(heart_full, x, y, null);
			 }
			 i++;
			 x += gp.tilesize;
		 }
		 
	}
	
	public void drawTileScreen() {
		
		if(tileScreenState == 0) {

			g2.setColor(new Color(0,0,0));
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			// TILE NAME;
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 70F));
			String text = "Blue Man Adventure";
			int x = getXforCenteredText(text) - (gp.tilesize*4)/2;
			int y = gp.tilesize*3 ;
			
			// SHADOW
			g2.setColor(Color.gray);
			g2.drawString(text, x+5, y+5);
			// MAIN COLOR
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			//BLUE Man IMAGE;
			x = gp.screenWidth / 2 - (gp.tilesize*2)/2;
			y += gp.tilesize*2;
			g2.drawImage(gp.player.down1, x, y, gp.tilesize*2, gp.tilesize*2, null);
			
			//MENU ;
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
			text = "NOUVELLE PARTIE";
			x = getXforCenteredText(text) + (gp.tilesize*2)/3;
			y += gp.tilesize*3.5;
			g2.drawString(text, x, y);
				if(commandNum == 0) {
					g2.drawString(">", x-gp.tilesize, y);
				}
			
			text = "CHARGER LA PARTIE";
			x = getXforCenteredText(text) + (gp.tilesize*2)/3;
			y += gp.tilesize;
			g2.drawString(text, x, y);
				if(commandNum == 1) {
					g2.drawString(">", x-gp.tilesize, y);
				}
		
			text = "QUITTER";
			x = getXforCenteredText(text) + ((gp.tilesize*4)/3)+2;
			y += gp.tilesize;
			g2.drawString(text, x, y);
				if(commandNum == 2) {
					g2.drawString(">", x-gp.tilesize, y);
				}
		}
		else if(tileScreenState == 1) {
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(42F));
			
			String text = "Select your class";
			int x = getXforCenteredText(text);
			int y = gp.tilesize*3;
			g2.drawString(text, x, y);
			
			text = "Fighter";
			x = getXforCenteredText(text) + ((gp.tilesize*4)/3)+2;
			y += gp.tilesize*3;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">", x-gp.tilesize, y);
			}
			
			text = "Thief";
			x = getXforCenteredText(text) + ((gp.tilesize*4)/3)+2;
			y += gp.tilesize;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x-gp.tilesize, y);
			}
			
			text = "Sorcerer";
			x = getXforCenteredText(text) + ((gp.tilesize*3)/3);
			y += gp.tilesize;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.drawString(">", x-gp.tilesize, y);
			}
			
			text = "Back";
			x = getXforCenteredText(text) + ((gp.tilesize*4)/3)+2;
			y += gp.tilesize*2;
			g2.drawString(text, x, y);
			if(commandNum == 3) {
				g2.drawString(">", x-gp.tilesize, y);
			}
			
		}
	
	}
	public void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
		String text = " PAUSED ";
		int x = getXforCenteredText(text);
//		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
	}
	
	public void drawDialogueScreen() {
		// WINDOWS
		int x = gp.tilesize*2;
		int y = gp.tilesize/2;
		int width = gp.screenWidth -(gp.tilesize*4);
		int height = gp.tilesize*4;
		
		drawSubWindow(x, y, width, height);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20));
		x += gp.tilesize;
		y += gp.tilesize;
		for(String line : currentDialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 40;
		}
		
	}
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0,0,0, 210);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
	}
	public int getXforCenteredText(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenHeight/2 - length/5;
		return x;
	}
}
