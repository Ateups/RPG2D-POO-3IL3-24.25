/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetpoogame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author USER
 */
public class KeyHandler implements KeyListener{
    
	GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    //DEBURGS
    boolean showDebugText = false;
    
    public KeyHandler(GamePanel gp) {
    	this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       int code = e.getKeyCode();
       
       //TITLE STATE;
       if(gp.gameState == gp.tileState) {
    	   
    	   if(gp.ui.tileScreenState == 0) {
    		   
    		   tileState(code);
//    		  
    	   }
    	  
    	   else if(gp.ui.tileScreenState == 1) {
    		   if(code == KeyEvent.VK_W){
                   gp.ui.commandNum--;
                   		if(gp.ui.commandNum < 0) {
                   			gp.ui.commandNum = 3;
                   		}
               }
               if(code == KeyEvent.VK_S){
            	   gp.ui.commandNum++;
    	        	   if(gp.ui.commandNum > 2) {
    	          			gp.ui.commandNum = 0;
    	          		}
               }
               if(code == KeyEvent.VK_ENTER) {
            	   if(gp.ui.commandNum == 0) {
            		  System.out.println("Do scene fighter specific stuff !");
            		  gp.gameState = gp.playState;
            		   gp.playMusic(0);
            	   }
            	   if(gp.ui.commandNum == 1) {
            		   System.out.println("Do scene Thief specific stuff !");
            		   // add later;
            		   gp.gameState = gp.playState;
            		   gp.playMusic(0);
            	   }
            	   if(gp.ui.commandNum == 2) {
            		   System.out.println("Do scene Sorcerer specific stuff !");
            		   gp.gameState = gp.playState;
            		   gp.playMusic(0);
            	   }
            	   if(gp.ui.commandNum == 3) {
            		   gp.ui.tileScreenState = 0;
            	   }
               }
    	   }
           
       }
       
       // PLAY STATE
       else if(gp.gameState == gp.playState) {
    	   
    	   playState(code);
//    	
	    }
       // pause state
       else if(gp.gameState == gp.pauseState) {
    	   
    	   pauseState(code);

       }
       // DIALOGUE STATE
       else if(gp.gameState == gp.dialogueState) {
    	   
    	   dialogueState(code);

       }
        // CHARACTER STATE
       else if(gp.gameState == gp.characterState) {
    	   
    	   characterState(code);

       }
       
    }
    public void tileState(int code) {
    	
    	if(code == KeyEvent.VK_W){
            gp.ui.commandNum--;
            		if(gp.ui.commandNum < 0) {
            			gp.ui.commandNum = 2;
            		}
        }
        if(code == KeyEvent.VK_S){
     	   gp.ui.commandNum++;
	        	   if(gp.ui.commandNum > 2) {
	          			gp.ui.commandNum = 0;
	          		}
        }
        if(code == KeyEvent.VK_ENTER) {
     	   if(gp.ui.commandNum == 0) {
     		   gp.ui.tileScreenState = 1;
//     		   gp.playMusic(0);
     	   }
     	   if(gp.ui.commandNum == 1) {
     		   // add later;
     	   }
     	   if(gp.ui.commandNum == 2) {
     		   System.exit(0);;
     	   }
        }
    }
    public void playState(int code) {
    	
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
         if(code == KeyEvent.VK_P){
      	   gp.gameState = gp.pauseState;
      	   //
//             if(gp.gameState == gp.playState) {
//          	   gp.gameState = gp.pauseState;
//             }else if(gp.gameState == gp.pauseState){
//          	   gp.gameState = gp.playState;
//             }
         }
         if(code == KeyEvent.VK_C) {
      	   gp.gameState = gp.characterState;
         }
         if(code == KeyEvent.VK_ENTER){
      	  enterPressed = true;
      	   	
         }
     
     
     //DEBURGS
	       if(code == KeyEvent.VK_T){
	    	   if(showDebugText == false) {
	    		   showDebugText = true;
	    	   }else if(showDebugText == true) {
	    		   showDebugText = true;
	    	   }
	           		
	       }
	       if(code == KeyEvent.VK_R){
	    	   gp.tileM.loadMap("/maps/worldV2.txt");
	       }
    }
    public void pauseState(int code) {
    	
    	if(code == KeyEvent.VK_P){
     	   gp.gameState = gp.playState;
     	    
        }
    }
    public void dialogueState(int code) {
    	
    	 if(code == KeyEvent.VK_ENTER) {
//  		   gp.gameState = gp.playState;
  		   gp.gameState = gp.playState;
  	   	 }
    }
    public void characterState(int code) {
    	
    	if(code == KeyEvent.VK_C) {
 		   gp.gameState = gp.playState;
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
