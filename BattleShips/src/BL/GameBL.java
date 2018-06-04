/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Beans.EinheitsVektor;
import Beans.Player;
import Beans.Position;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
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
public class GameBL {

    private LinkedList<Player> players = new LinkedList();
    private int maxX, maxY;
    private Graphics g;
    private JPanel jpGame;
    private int shipWidth1, shipHeight1;
    private int shipWidth2, shipHeight2;
    private final String imagePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "shipbasic.png";
    private BufferedImage bufferedImage;
    private Controlls controlls;
    private LinkedList<Player> schiffListe;

    public GameBL(JPanel jpGame, EinheitsVektor einh1, EinheitsVektor einh2, LinkedList<Player> schiffListe) {
        this.jpGame = jpGame;
        this.schiffListe = schiffListe;

        initMyInits();

    }

    public GameBL(JPanel jpGame, EinheitsVektor einh1, EinheitsVektor einh2, Image ship1, Image ship2) {
        this.jpGame = jpGame;
        initMyInits();

    }

    public void initMyInits() {
        maxX = this.jpGame.getWidth();
        maxY = this.jpGame.getHeight();
        Player p1 = schiffListe.get(0);
        shipWidth1 = p1.getSchiff().getWidth(null);
        shipHeight1 = p1.getSchiff().getHeight(null);
        Player p2 = schiffListe.get(1);
        shipWidth2 = p2.getSchiff().getWidth(null);
        shipHeight2 = p2.getSchiff().getHeight(null);
        
        g = this.jpGame.getGraphics();
        g.clearRect(0, 0, maxX, maxY);

        bufferedImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_ARGB);
    }
       
   
    public void draw(LinkedList<Player> schiffListe) {
        this.schiffListe = schiffListe;
        this.drawShips();
    }

    public void drawShips() {
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.clearRect(0, 0, maxX, maxY);
        g2d.setColor(new Color(62, 208, 245));
        g2d.fillRect(0, 0, maxX, maxY);
        
        for (Player p : schiffListe) {
            AffineTransform origXform1 = g2d.getTransform();
            AffineTransform newXform1 = (AffineTransform) (origXform1.clone());
            int xRot1 = p.getP().getXInt() + (shipWidth1 / 2);
            int yRot1 = p.getP().getYInt() + (shipHeight1 / 2);
            newXform1.rotate(Math.toRadians(p.getCurrentAngle()), xRot1, yRot1);
            g2d.setTransform(newXform1);
            g2d.drawImage(p.getSchiff(), p.getP().getXInt(), p.getP().getYInt(), null);
            g2d.setTransform(origXform1);
        }
        g.drawImage(bufferedImage, 0, 0, null);

    }

    public void drawPlayers() {
        Graphics gPanel = this.jpGame.getGraphics();
        gPanel.setColor(new Color(62, 208, 245));
        gPanel.fillRect(0, 0, maxX, maxY);

        Graphics2D g2d = bufferedImage.createGraphics();

        drawPlayer1(schiffListe.get(0), 0);
        drawPlayer2(schiffListe.get(0), 180);

        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void drawPlayer1(Player p, int angle) {
        Graphics2D g2d = bufferedImage.createGraphics();
        AffineTransform origXform1 = g2d.getTransform();
        AffineTransform newXform1 = (AffineTransform) (origXform1.clone());
        int xRot1 = p.getP().getXInt() + (shipWidth1 / 2);
        int yRot1 = p.getP().getYInt() + (shipHeight1 / 2);
        newXform1.rotate(Math.toRadians(p.getCurrentAngle()), xRot1, yRot1);
        g2d.setTransform(newXform1);
        g2d.drawImage(p.getSchiff(), p.getP().getXInt(), p.getP().getYInt(), null);
        g2d.setTransform(origXform1);
    }

    public void drawPlayer2(Player p, int angle) {
        Graphics2D g2d = bufferedImage.createGraphics();
        AffineTransform origXform1 = g2d.getTransform();
        AffineTransform newXform1 = (AffineTransform) (origXform1.clone());
        int xRot1 = p.getP().getXInt() + (shipWidth2 / 2);
        int yRot1 = p.getP().getYInt() + (shipHeight2 / 2);
        newXform1.rotate(Math.toRadians(p.getCurrentAngle()), xRot1, yRot1);
        g2d.setTransform(newXform1);
        g2d.drawImage(p.getSchiff(), p.getP().getXInt(), p.getP().getYInt(), null);
        g2d.setTransform(origXform1);

    }


    public void shootPlayer1() {

        Thread cannonShoot1 = new ShootingThread1();
        cannonShoot1.start();
    }

    public void shootPlayer2() {
        //do p1 shoot 
    }

    public class ShootingThread1 extends Thread {
//
//        private Position pos;
//        private EinheitsVektor einVLinks;
//        private EinheitsVektor einVRechts;
//
//        public ShootingThread1() {
//            System.out.println("ShootingThread1 created");
//
//        }
//
//        @Override
//        public void run() {
//            System.out.println("ShootingThread1 started");
//
//            einVLinks = new EinheitsVektor(direction1.getX(), direction1.getY());
//            einVRechts = new EinheitsVektor(direction1.getX(), direction1.getY());
//
//            pos = new Position(pos1.getX(), pos1.getY());
//            while (!this.isInterrupted()) {
//
//                for (int i = 0; i < 10; i++) {
//
//                    for (int j = 0; j < 5; j++) {
//                        g.setColor(Color.BLACK);
//                        g.fillOval(pos.getXInt() + j + i, pos.getYInt() + j + i, 2, 2);
//                    }
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(GameBL.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//                pos.setX(0);
//                pos.setY(0);
//                this.interrupt();
//                System.out.println("ShootingThread1 interrupted");
//            }
//        }
    }
}
