/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetpoogame;

import javax.swing.JFrame;
/**
 *
 * @author lion
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D ADVENTURE");
        
        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamepanel.setupGame();
        gamepanel.StartGameThread();
    }
    
}
