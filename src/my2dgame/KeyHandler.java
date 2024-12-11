/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my2dgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author lion
 */
public class KeyHandler implements KeyListener{
    
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    @Override
    public void keyTyped(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       int code = e.getKeyCode();
       if(code == KeyEvent.VK_W){
           upPressed = true;
       }
       if(code == KeyEvent.VK_S){
           downPressed = true;
       }
       if(code == KeyEvent.VK_A){
           leftPressed = true;
       }
       if(code == KeyEvent.VK_D){
           rightPressed = true;
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
           upPressed = false;
       }
       if(code == KeyEvent.VK_S){
           downPressed = false;
       }
       if(code == KeyEvent.VK_A){
           leftPressed = false;
       }
       if(code == KeyEvent.VK_D){
           rightPressed = false;
       }
    }
    
}