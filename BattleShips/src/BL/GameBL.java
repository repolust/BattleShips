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
    private double currentAngle1 = 180;
//    private double currentAngle2 = 0;
    private EinheitsVektor direction1;
    private EinheitsVektor direction2;
    private double speed = 3;
    private Set<Integer> keys = new HashSet<>();

    private final String imagePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "shipbasic.png";

    private Image ship;
    private BufferedImage bufferedImage;

    public GameBL(JPanel jpGame, EinheitsVektor einh1, EinheitsVektor einh2)
    {
        this.jpGame = jpGame;
        direction1 = einh1;
        direction2 = einh2;
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
        pos1 = new Position((maxX / 2 - 112), (maxY / 2 - 35));
        pos2 = new Position((maxX / 2 + 88), (maxY / 2 - 35));

        bufferedImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_ARGB);
    }

    public void drawPlayers()
    {
        drawPlayer1();
//        rotatePlayer1(0);
        drawPlayer2();

    }

    public void drawPlayer1()
    {
//        g.clearRect(pos1.getXInt() - 10, pos1.getYInt() - 10, shipWidth + 20, shipHeight + 20);
//        g.setColor(Color.BLACK);
//        g.drawRect(pos1.getXInt(), pos1.getYInt(), shipWidth, shipHeight);
        Graphics bufferedImageGraphics = bufferedImage.getGraphics();
        bufferedImageGraphics.drawImage(ship, pos1.getXInt(), pos1.getYInt(), null);
//        g.drawImage(ship, pos1.getXInt(), pos1.getYInt(), null);
    }

    public void drawPlayer2()
    {
//        g.clearRect(pos2.getXInt() - 10, pos2.getYInt() - 10, shipWidth + 20, shipHeight + 20);
//        g.setColor(Color.BLACK);
//        g.drawRect(pos2.getXInt(), pos2.getYInt(), shipWidth, shipHeight);
        g.drawImage(ship, pos2.getXInt(), pos2.getYInt(), null);
    }

    public void setRotation1(int angle)
    {

        Graphics2D g2d = bufferedImage.createGraphics();
        AffineTransform origXform = g2d.getTransform();
        AffineTransform newXform = (AffineTransform) (origXform.clone());
        currentAngle1 += angle;
        int xRot = pos1.getXInt() + (shipWidth / 2);
        int yRot = pos1.getYInt() + (shipHeight / 2);
        newXform.rotate(Math.toRadians(currentAngle1), xRot, yRot);
        g2d.setTransform(newXform);
        Graphics bufferedImageGraphics = bufferedImage.getGraphics();
        bufferedImageGraphics.clearRect(0, 0, maxX, maxY);
        g2d.drawImage(ship, pos1.getXInt(), pos1.getYInt(), null);
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
    public void movePlayer1(int keyCode1, int keyCode2)
    {
//        if (!(pos1.getY() - 10 < 0) && !(pos1.getX() - 10 < 0) && !(pos1.getX() + 10 + shipWidth > maxX) && !((pos1.getY() + 10 + shipHeight) > maxY))

        if (keyCode2 == 0)
        {
            pos1.increaseX(direction1.getX() * speed);
            pos1.increaseY(direction1.getY() * speed);
//            drawPlayer1();
            setRotation1(0);
            g.drawImage(bufferedImage, 0, 0, null);
        } else
        {
            switch (keyCode2)
            {
                case KeyEvent.VK_A:
                    direction1.rotateEinheitsVektor(-3);
                    pos1.increaseX(direction1.getX() * speed);
                    pos1.increaseY(direction1.getY() * speed);
//                    drawPlayer1();
                    setRotation1(-4);
                    g.drawImage(bufferedImage, 0, 0, null);
                    break;
                case KeyEvent.VK_D:
                    direction1.rotateEinheitsVektor(3);
                    pos1.increaseX(direction1.getX() * speed);
                    pos1.increaseY(direction1.getY() * speed);
//                    drawPlayer1();
                    setRotation1(4);
                    g.drawImage(bufferedImage, 0, 0, null);
                    break;
            }
        }

    }

    public void movePlayer2(int keyCode1, int keyCode2)
    {
//        if (!(pos1.getY() - 10 < 0) && !(pos1.getX() - 10 < 0) && !(pos1.getX() + 10 + shipWidth > maxX) && !((pos1.getY() + 10 + shipHeight) > maxY))
        if (keyCode2 == 0)
        {
            pos2.increaseX(direction2.getX() * speed);
            pos2.increaseY(direction2.getY() * speed);
            drawPlayer2();
        } else
        {
            switch (keyCode2)
            {
                case KeyEvent.VK_LEFT:
                    direction2.rotateEinheitsVektor(3);
                    pos2.increaseX(direction2.getX() * speed);
                    pos2.increaseY(direction2.getY() * speed);
                    drawPlayer2();
                    break;
                case KeyEvent.VK_RIGHT:
                    direction2.rotateEinheitsVektor(-3);
                    pos2.increaseX(direction2.getX() * speed);
                    pos2.increaseY(direction2.getY() * speed);
                    drawPlayer2();
                    break;
            }
        }
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

        private int count = 0;
        private Position pos;

        public ShootingThread1()
        {
            System.out.println("ShootingThread1 created");

        }

        @Override
        public void run()
        {
            System.out.println("ShootingThread1 started");

            pos = new Position(pos1.getX(), pos1.getY());
            while (!this.isInterrupted())
            {

                for (int i = 0; i < 10; i++)
                {

                    for (int j = 0; j < 5; j++)
                    {
                        g.setColor(Color.BLACK);
                        g.fillOval(pos1.getXInt() + j + i, pos1.getYInt() + j + i, 2, 2);
                    }
                    count++;
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameBL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                count = 0;
                pos.setX(0);
                pos.setY(0);
                Thread.interrupted();
                System.out.println("ShootingThread1 interrupted");
            }
        }
    }
}
