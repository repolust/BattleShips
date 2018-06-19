/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Beans.EinheitsVektor;
import Beans.Kugel;
import Beans.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Team
 */
public class GameBL
{

    private LinkedList<Player> players = new LinkedList();
    private int maxX, maxY;
    private Graphics g;
    private JPanel jpGame;

    private BufferedImage bufferedImage;

    private LinkedList<Player> schiffListe;
    private LinkedList<Kugel> kugelListe;

    public GameBL(JPanel jpGame, EinheitsVektor einh1, EinheitsVektor einh2, LinkedList<Player> schiffListe)
    {
        this.jpGame = jpGame;
        this.schiffListe = schiffListe;

        initMyInits();

    }


    public void initMyInits()//Initialisiert die Startwerte
    {
        maxX = this.jpGame.getWidth();
        maxY = this.jpGame.getHeight();

        g = this.jpGame.getGraphics();
        g.clearRect(0, 0, maxX, maxY);

        bufferedImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_ARGB);
    }

    public void draw(LinkedList<Player> schiffListe, LinkedList<Kugel> kugelListe)//Zeichnet alles
    {
        this.schiffListe = schiffListe;
        this.kugelListe = kugelListe;
        
        this.drawShips();
        this.drawKugeln();
        
        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void drawShips()//Zeichnet die SChiffe
    {
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.clearRect(0, 0, maxX, maxY);
        g2d.setColor(new Color(62, 208, 245));
        g2d.fillRect(0, 0, maxX, maxY);
        
        for (Player p : schiffListe)
        {
            
//            //-----------Position Point-------
//            g.setColor(Color.red);
//            g.fillOval(p.getP().getXInt(), p.getP().getYInt(), 8, 8);
//            g.setColor(Color.black);
//            //-----------/Position Point-------
// 
//            
//            //-----------Hitbox-------
//            Rectangle hitbox = p.getHitbox();
//            g.drawRect((int) Math.round(hitbox.x), (int) Math.round(hitbox.y), hitbox.width, hitbox.height); 
//            //-----------/Hitbox-------
            
            
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
    public void drawKugeln()//Zeichnet die Kugeln
    {        
            
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.BLACK);
        for(Kugel k:kugelListe){
            g2d.fillOval(k.getPos().getXInt(), k.getPos().getYInt(), k.getGroesse(), k.getGroesse()); 
        }

    }

    public void drawPlayers()//Zeichnet die Schiffe das erste mal. Wird von der Paint-Methode aus der GUI am start aufgerufen
    {
        Graphics gPanel = this.jpGame.getGraphics();
        gPanel.setColor(new Color(62, 208, 245));
        gPanel.fillRect(0, 0, maxX, maxY);

        Graphics2D g2d = bufferedImage.createGraphics();

        drawPlayer1(schiffListe.get(0), 0);
        drawPlayer2(schiffListe.get(1), 180);

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
    
}
