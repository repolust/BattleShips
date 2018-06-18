/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Beans.EinheitsVektor;
import Beans.Kugel;
import Beans.Player;
import Beans.Position;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Tobia
 */
public class GameBL
{

    private LinkedList<Player> players = new LinkedList();
    private int maxX, maxY;
    private Graphics g;
    private JPanel jpGame;
    private final String imagePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "shipbasic.png";
    private BufferedImage bufferedImage;
    private Controlls controlls;
    private LinkedList<Player> schiffListe;
    private LinkedList<Kugel> kugelListe;

    public GameBL(JPanel jpGame, EinheitsVektor einh1, EinheitsVektor einh2, LinkedList<Player> schiffListe)
    {
        this.jpGame = jpGame;
        this.schiffListe = schiffListe;

        initMyInits();

    }

    public GameBL(JPanel jpGame, EinheitsVektor einh1, EinheitsVektor einh2, Image ship1, Image ship2)
    {
        this.jpGame = jpGame;
        initMyInits();

    }

    public void initMyInits()
    {
        maxX = this.jpGame.getWidth();
        maxY = this.jpGame.getHeight();

        g = this.jpGame.getGraphics();
        g.clearRect(0, 0, maxX, maxY);

        bufferedImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_ARGB);
    }

    public void draw(LinkedList<Player> schiffListe, LinkedList<Kugel> kugelListe)
    {
        this.schiffListe = schiffListe;
        this.kugelListe = kugelListe;
        this.drawShips();
        this.drawKugeln();
        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void drawShips()
    {
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.clearRect(0, 0, maxX, maxY);
        g2d.setColor(new Color(62, 208, 245));
        g2d.fillRect(0, 0, maxX, maxY);
        
        for (Player p : schiffListe)
        {
            //-----------Position Point-------
            g.setColor(Color.red);
            g.fillOval(p.getP().getXInt(), p.getP().getYInt(), 8, 8);
            g.setColor(Color.black);
            //-----------/Position Point-------
 
            
            //-----------Hitbox-------
            Rectangle hitbox = p.getHitbox();
            g.drawRect((int) Math.round(hitbox.x), (int) Math.round(hitbox.y), hitbox.width, hitbox.height);

    
            //-----------/Hitbox-------
            
            
            //-----------Rotate----------------
            AffineTransform origXform1 = g2d.getTransform();
            AffineTransform newXform1 = (AffineTransform) (origXform1.clone());
            int xRot1 = p.getP().getXInt() + (p.getWidth() / 2);
            int yRot1 = p.getP().getYInt() + (p.getHeight() / 2);
            newXform1.rotate(Math.toRadians(p.getCurrentAngle()), xRot1, yRot1);
            g2d.setTransform(newXform1);
            g2d.drawImage(p.getSchiff(), p.getP().getXInt(), p.getP().getYInt(), null);
            g2d.setTransform(origXform1);
            //-----------/Rotate---------------
        }
    }
    public void drawKugeln(){
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.BLACK);
        for(Kugel k:kugelListe){
            g.fillOval(k.getPos().getXInt(), k.getPos().getYInt(), k.getGroesse(), k.getGroesse()); 
        }
    }
    
    public void drawPlayers()
    {
        Graphics gPanel = this.jpGame.getGraphics();
        gPanel.setColor(new Color(62, 208, 245));
        gPanel.fillRect(0, 0, maxX, maxY);

        Graphics2D g2d = bufferedImage.createGraphics();

        drawPlayer1(schiffListe.get(0), 0);
        drawPlayer2(schiffListe.get(0), 180);

        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void drawPlayer1(Player p, int angle)
    {
        Graphics2D g2d = bufferedImage.createGraphics();
        AffineTransform origXform1 = g2d.getTransform();
        AffineTransform newXform1 = (AffineTransform) (origXform1.clone());
        int xRot1 = p.getP().getXInt() + (p.getWidth() / 2);
        int yRot1 = p.getP().getYInt() + (p.getHeight() / 2);
        newXform1.rotate(Math.toRadians(p.getCurrentAngle()), xRot1, yRot1);
        g2d.setTransform(newXform1);
        g2d.drawImage(p.getSchiff(), p.getP().getXInt(), p.getP().getYInt(), null);
        g2d.setTransform(origXform1);
    }

    public void drawPlayer2(Player p, int angle)
    {
        Graphics2D g2d = bufferedImage.createGraphics();
        AffineTransform origXform1 = g2d.getTransform();
        AffineTransform newXform1 = (AffineTransform) (origXform1.clone());
        int xRot1 = p.getP().getXInt() + (p.getWidth() / 2);
        int yRot1 = p.getP().getYInt() + (p.getHeight() / 2);
        newXform1.rotate(Math.toRadians(p.getCurrentAngle()), xRot1, yRot1);
        g2d.setTransform(newXform1);
        g2d.drawImage(p.getSchiff(), p.getP().getXInt(), p.getP().getYInt(), null);
        g2d.setTransform(origXform1);

    }

    public void shootPlayer1()
    {
        Thread cannonShoot1 = new ShootingThread1();
        cannonShoot1.start();
    }

    public void shootPlayer2()
    {
        //do p1 shoot 
    }

    public class ShootingThread1 extends Thread
    {

        private Position posSL, posSR;
        private EinheitsVektor einVLinks;
        private EinheitsVektor einVRechts;

        public ShootingThread1()
        {
            System.out.println("ShootingThread1 created");

        }

        @Override
        public void run()
        {
            System.out.println("ShootingThread1 started");

            einVLinks = new EinheitsVektor(schiffListe.get(0).getDirection().getX(), schiffListe.get(0).getDirection().getY()); //vektor
            einVRechts = new EinheitsVektor(schiffListe.get(0).getDirection().getX(), schiffListe.get(0).getDirection().getY());

            einVLinks.rotateEinheitsVektor(-90); //links rechts drehen
            einVRechts.rotateEinheitsVektor(90);

            posSL = new Position(schiffListe.get(0).getP().getX() + 15, schiffListe.get(0).getP().getY() + 27);//position schiff
            posSR = new Position(schiffListe.get(0).getP().getX() + 15, schiffListe.get(0).getP().getY() + 63);
            
            

//            posSL = new Position(pos1.getX(), pos1.getY());
//            posSR = new Position(pos1.getX(), pos1.getY());
//            g.fillOval(schiffListe.get(0).getP().getXInt(), schiffListe.get(0).getP().getYInt(), 5, 5);

            while (!this.isInterrupted())
            {
                for (int i = 0; i < 24; i += 6)//4 durchgänge //i ist abstand
                {
                    g.setColor(Color.BLACK); //schwarze kugel
                    g.fillOval(posSL.getXInt() + i, posSL.getYInt(), 5, 5); //
                    g.fillOval(posSR.getXInt() + i, posSR.getYInt(), 5, 5);
                }

                posSL.increaseX(einVLinks.getX() * 5); //kugelposition speed 5
                posSL.increaseY(einVLinks.getY() * 5);
                posSR.increaseX(einVRechts.getX() * 5);
                posSR.increaseY(einVRechts.getY() * 5);

                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(GameBL.class.getName()).log(Level.SEVERE, null, ex);
                }
//                this.interrupt();
                System.out.println("ShootingThread1 interrupted");
            }
        }

    }
}
