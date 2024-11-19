package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable {

	// Parametres de la fenetre de jeu
	final int originalTileSize = 16; // 16*16 case
	final int scale = 3;

	public final int tileSize = originalTileSize * scale; // 48*48 case
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 pixels

	// FPS
	int FPS = 60;

	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this, keyH);

	// Position par defaut du personnage
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	/*
	 * public void run() {
	 * 
	 * double drawinterval = 1000000000/FPS; double nextDrawTime = System.nanoTime()
	 * + drawinterval;
	 * 
	 * while(gameThread != null) {
	 * 
	 * update();
	 * 
	 * repaint();
	 * 
	 * try { double remainingTime = nextDrawTime - System.nanoTime(); remainingTime
	 * /= 1000000;
	 * 
	 * 
	 * if(remainingTime < 0) { remainingTime = 0; }
	 * 
	 * Thread.sleep((long) remainingTime);
	 * 
	 * nextDrawTime += drawinterval; } catch (InterruptedException e) {
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */

	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		double lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {
			
			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;

			lastTime = currentTime;

			if (delta > 1) {
				update();
				repaint();
				delta--;
			}
		}
	}

	public void update() {
		player.update();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		player.draw(g2);

		
		g2.dispose();

	}

}
