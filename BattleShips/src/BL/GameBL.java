/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Beans.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
    private int p1X1, p1Y1, p1X2, p1Y2, p2X1, p2Y1, p2X2, p2Y2;
    private Graphics g;
    private JPanel jpGame;

    private final String imagePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "ship.png";
    
    private Image ship;

    public GameBL(JPanel jpGame)
    {
        this.jpGame = jpGame;

        initMyInits();
        loadImage();
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
        g = this.jpGame.getGraphics();
        g.clearRect(0, 0, maxX, maxY);
        p1X1 = maxX / 2 - 112;
        p1Y1 = maxY / 2 - 35;
        p1X2 = 25;
        p1Y2 = 70;
        p2X1 = maxX / 2 + 88;
        p2Y1 = maxY / 2 - 35;
        p2X2 = 25;
        p2Y2 = 70;
    }

    public void drawPlayers()
    {
        drawPlayer1();
        drawPlayer2();
     
    }

    public void drawPlayer1()
    {
        g.setColor(Color.BLACK);
        g.drawRect(p1X1 + 22, p1Y1 + 23, p1X2, p1Y2);
        g.drawImage(ship, p1X1, p1Y1, null);

    }

    public void drawPlayer2()
    {
        g.setColor(Color.BLACK);
        g.drawRect(p2X1 + 22, p2Y1 + 23, p2X2, p2Y2);
        g.drawImage(ship, p2X1, p2Y1, null);

    }

    public void movePlayer(LinkedList<String> movement)
    {
        if(movement.size() == 2)
        {
            String moveA = movement.get(0);
            String moveB = movement.get(1);
            
            
        }
        else if(movement.size() == 1)
        {
            String move = movement.get(0);
            if(move.equals("w"))
            {
                p1Y1+=10;
                System.out.println("move to:"+p1Y1);
            }
        }
        else
        {
//            System.out.println("gehtnd SIZE: "+movement.size());
        }
     
        
    }
    
}
