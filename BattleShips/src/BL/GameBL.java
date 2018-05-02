/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Beans.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
public class GameBL
{

    private LinkedList<Player> players = new LinkedList();
    private int maxX, maxY;
    private Graphics g;
    private JPanel jpGame;
    private Position pos1;
    private Position pos2;
    private int shipWidth, shipHeight;
    private double currentAngle1 = 0;
    private double currentAngle2 = 0;
    
    private final String imagePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "ship1.png";
    
    private Image ship;

    public GameBL(JPanel jpGame)
    {
        this.jpGame = jpGame;
        loadImage();
        initMyInits();
        
    }

    public void loadImage()
    {

        try
        {
            ship = ImageIO.read(new File(imagePath));
        } catch (IOException ex)
        {
            Logger.getLogger(GameBL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initMyInits()
    {
        maxX = this.jpGame.getWidth();
        maxY = this.jpGame.getHeight();
        
        shipWidth = ship.getWidth(null);
        shipHeight = ship.getHeight(null);
        
        g = this.jpGame.getGraphics();
        g.clearRect(0, 0, maxX, maxY);
        
        pos1 = new Position((maxX / 2 - 112),(maxY / 2 - 35));
        
        pos2 = new Position((maxX / 2 + 88),(maxY / 2 - 35));
 

    }

    public void drawPlayers()
    {
//        drawPlayer1();
        rotatePlayer1(0);
        drawPlayer2();
     
    }

    public void drawPlayer1()
    {
  
        g.clearRect(pos1.getXint()-10, pos1.getYint()-10, shipWidth+20, shipHeight+20);
        
        
//        g.setColor(Color.BLACK);
//        g.drawRect(pos1.getX(), pos1.getY(), shipWidth, shipHeight);
        g.drawImage(ship, pos1.getXint(), pos1.getYint(), null);
        
    }
    
    public void rotatePlayer1(int angle)
    {   
       
        Graphics2D g2d = (Graphics2D)g;

        g.clearRect(pos1.getXint()-20, pos1.getYint()-10, shipHeight+20, shipHeight+20);
        AffineTransform origXform = g2d.getTransform();
        AffineTransform newXform = (AffineTransform)(origXform.clone());
        currentAngle1 += angle;
        int xRot =  pos1.getXint()+(shipWidth/2);
        int yRot =  pos1.getYint()+(shipHeight/2);
        newXform.rotate(Math.toRadians(currentAngle1), xRot, yRot);
        g2d.setTransform(newXform);
        g2d.drawImage(ship, pos1.getXint(), pos1.getYint(), null);
        g2d.setTransform(origXform);

    }
    
//    public void setVektor(int angle)
//    {
//        double x = Math.cos(Math.toRadians(currentAngle1))*pos1.getX() - Math.sin(Math.toRadians(currentAngle1))*pos1.getX();
//        double y = Math.sin(Math.toRadians(currentAngle1))*pos1.getY() + Math.cos(Math.toRadians(currentAngle1))*pos1.getY();
//        
//        int x2 = (int) Math.round(x);
//        int y2 = (int) Math.round(y);
//        pos1.setX(x2);
//        pos1.setY(y2);
//    }

    public void drawPlayer2()
    {
        g.clearRect(pos2.getXint(), pos2.getYint(), shipWidth, shipHeight);
        
//        g.setColor(Color.BLACK);
//        g.drawRect(pos2.getX(), pos2.getY(), shipWidth, shipHeight);
        g.drawImage(ship, pos2.getXint(), pos2.getYint(), null);

    }

    public void movePlayer1(int keyCode)
    {
        if(!(pos1.getY()-10 < 0) && !(pos1.getX()-10 < 0) && !(pos1.getX()+10+shipWidth > maxX) && !((pos1.getY()+10+shipHeight) > maxY))
        {
            switch(keyCode)
            {
               case KeyEvent.VK_W: pos1.increaseY(-10);drawPlayer1();break;
               case KeyEvent.VK_A: rotatePlayer1(-1);break;
               case KeyEvent.VK_S: pos1.increaseY(10);drawPlayer1();break;
               case KeyEvent.VK_D: rotatePlayer1(1);break;
            
            }
             
        }
        
    }
    
}
