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
public class GameBL
{

    private LinkedList<Player> players = new LinkedList();
    private int maxX, maxY;
    private Graphics g;
    private JPanel jpGame;
    private Position pos1;
    private Position pos2;
    private int shipWidth, shipHeight;
    private double currentAngle1 = 90;
    private double currentAngle2 = 90;
    private EinheitsVektor direction1;
    private EinheitsVektor direction2;
    private double speed = 12;
    private Set<Integer> keys = new HashSet<>();

    private final String imagePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "shipbasic.png";

    private Image ship1;
    private Image ship2;
    private BufferedImage bufferedImage;

    public GameBL(JPanel jpGame, EinheitsVektor einh1, EinheitsVektor einh2)
    {
        this.jpGame = jpGame;
        direction1 = einh1;
        direction2 = einh2;
        loadImage();
        initMyInits();

    }

    public GameBL(JPanel jpGame, EinheitsVektor einh1, EinheitsVektor einh2, Image ship1, Image ship2)
    {
        this.jpGame = jpGame;
        direction1 = einh1;
        direction2 = einh2;
        this.ship1 = ship1;
        this.ship2 = ship2;
        initMyInits();

    }

    public void loadImage()
    {

        try
        {
            ship1 = ImageIO.read(new File(imagePath));
            ship2 = ImageIO.read(new File(imagePath));
        } catch (IOException ex)
        {
            Logger.getLogger(GameBL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initMyInits()
    {
        maxX = this.jpGame.getWidth();
        maxY = this.jpGame.getHeight();

        shipWidth = ship1.getWidth(null);
        shipHeight = ship1.getHeight(null);

        g = this.jpGame.getGraphics();
        g.clearRect(0, 0, maxX, maxY);
        pos1 = new Position(300, (maxY / 2 - 35));
        pos2 = new Position((maxX - 390), (maxY / 2 - 35));

        bufferedImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_ARGB);
    }

    public void drawPlayers()
    {
        Graphics gPanel = this.jpGame.getGraphics();
        gPanel.setColor(new Color(62, 208, 245));
        gPanel.fillRect(0, 0, maxX, maxY);

        Graphics2D g2d = bufferedImage.createGraphics();

        drawPlayer1(g2d, 0);
        drawPlayer2(g2d, 180);

        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void drawPlayer1(Graphics2D g2d, int angle)
    {
        drawPlayer1(gPanel, 0, 180);

        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void drawPlayer1(Graphics gPanel, int angle1, int angle2)
    {
        Graphics2D g2d = bufferedImage.createGraphics();

        AffineTransform origXform1 = g2d.getTransform();
        AffineTransform newXform1 = (AffineTransform) (origXform1.clone());
        currentAngle1 += angle;
        int xRot1 = pos1.getXInt() + (shipWidth / 2);
        int yRot1 = pos1.getYInt() + (shipHeight / 2);
        newXform1.rotate(Math.toRadians(currentAngle1), xRot1, yRot1);
        g2d.setTransform(newXform1);
        g2d.drawImage(ship1, pos1.getXInt(), pos1.getYInt(), null);
        g2d.setTransform(origXform1);
    }

    public void drawPlayer2(Graphics2D g2d, int angle)
    {
        AffineTransform origXform1 = g2d.getTransform();
        AffineTransform newXform1 = (AffineTransform) (origXform1.clone());
        currentAngle2 += angle;
        int xRot1 = pos2.getXInt() + (shipWidth / 2);
        int yRot1 = pos2.getYInt() + (shipHeight / 2);
        newXform1.rotate(Math.toRadians(currentAngle2), xRot1, yRot1);
//        g2d.setTransform(newXform1);
        g2d.drawImage(ship2, pos2.getXInt(), pos2.getYInt(), null);
        g2d.setTransform(origXform1);

        origXform1 = g2d.getTransform();
        newXform1 = (AffineTransform) (origXform1.clone());
        currentAngle2 += angle2;
        int xRot2 = pos2.getXInt() + (shipWidth / 2);
        int yRot2 = pos2.getYInt() + (shipHeight / 2);
        newXform1.rotate(Math.toRadians(currentAngle2), xRot2, yRot2);
        g2d.setTransform(newXform1);
        g2d.drawImage(ship2, pos2.getXInt(), pos2.getYInt(), null);
        g2d.setTransform(origXform1);

    }

    public void drawPlayer2(Graphics gPanel, int angle)
    {
//        Graphics2D g2d = bufferedImage.createGraphics();

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
        bufferedImageGraphics.setColor(new Color(62, 208, 245));
        bufferedImageGraphics.fillRect(0, 0, maxX, maxY);
        g2d.drawImage(ship1, pos1.getXInt(), pos1.getYInt(), null);
        g2d.setTransform(origXform);
        g2d.drawImage(ship2, pos2.getXInt(), pos2.getYInt(), null);
    }

    public void setRotation2(int angle)
    {
        Graphics2D g2d = bufferedImage.createGraphics();
        AffineTransform origXform = g2d.getTransform();
        AffineTransform newXform = (AffineTransform) (origXform.clone());
        currentAngle2 += angle;
        int xRot = pos2.getXInt() + (shipWidth / 2);
        int yRot = pos2.getYInt() + (shipHeight / 2);
        newXform.rotate(Math.toRadians(currentAngle2), xRot, yRot);
        g2d.setTransform(newXform);
        Graphics bufferedImageGraphics = bufferedImage.getGraphics();
        bufferedImageGraphics.clearRect(0, 0, maxX, maxY);
        bufferedImageGraphics.setColor(new Color(62, 208, 245));
        bufferedImageGraphics.fillRect(0, 0, maxX, maxY);
        g2d.drawImage(ship2, pos2.getXInt(), pos2.getYInt(), null);
        g2d.setTransform(origXform);
        g2d.drawImage(ship1, pos1.getXInt(), pos1.getYInt(), null);
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
    public void movePlayer1(int keyCode1, int keyCode2, int keycode3)
    {
//        if (!(pos1.getY() - 10 < 0) && !(pos1.getX() - 10 < 0) && !(pos1.getX() + 10 + shipWidth > maxX) && !((pos1.getY() + 10 + shipHeight) > maxY))

        if (keyCode2 == 0 && keycode3 == 0)
        {
            pos1.increaseX(direction1.getX() * speed);
            pos1.increaseY(direction1.getY() * speed);
//            drawPlayer1();
            checkAndIncrease();
            setRotation1(0);
            g.drawImage(bufferedImage, 0, 0, null);
        } else
        {
            switch (keyCode2)
            {
                case KeyEvent.VK_A:
                    if (keycode3 == KeyEvent.VK_D)
                    {
                        checkAndIncrease();
                        setRotation1(0);
                        g.drawImage(bufferedImage, 0, 0, null);
                    } else
                    {
                        direction1.rotateEinheitsVektor(-4);
                        checkAndIncrease();
//                    drawPlayer1();
                        g.drawImage(bufferedImage, 0, 0, null);
                        setRotation1(-4);
                        g.drawImage(bufferedImage, 0, 0, null);
                    }
                    break;
                case KeyEvent.VK_D:
                    if (keycode3 == KeyEvent.VK_A)
                    {
                        checkAndIncrease();
                        setRotation1(0);
                        g.drawImage(bufferedImage, 0, 0, null);
                    } else
                    {
                        direction1.rotateEinheitsVektor(4);
                        checkAndIncrease();
//                    drawPlayer1();
                        g.drawImage(bufferedImage, 0, 0, null);
                        setRotation1(4);
                        g.drawImage(bufferedImage, 0, 0, null);
                    }
                    break;
            }
        }

    }

    public void movePlayer2(int keyCode1, int keyCode2, int keycode3)
    {
//        if (!(pos1.getY() - 10 < 0) && !(pos1.getX() - 10 < 0) && !(pos1.getX() + 10 + shipWidth > maxX) && !((pos1.getY() + 10 + shipHeight) > maxY))
        //        if (!(pos1.getY() - 10 < 0) && !(pos1.getX() - 10 < 0) && !(pos1.getX() + 10 + shipWidth > maxX) && !((pos1.getY() + 10 + shipHeight) > maxY))

        if (keyCode2 == 0 && keycode3 == 0)
        {
            pos2.increaseX(direction2.getX() * speed);
            pos2.increaseY(direction2.getY() * speed);
//            drawPlayer1();
            setRotation1(0);
            g.drawImage(bufferedImage, 0, 0, null);
        } else
        {
            switch (keyCode2)
            {
                case KeyEvent.VK_A:
                    if (keycode3 == KeyEvent.VK_D)
                    {
                        checkAndIncrease();
                        setRotation1(0);
                        g.drawImage(bufferedImage, 0, 0, null);
                    } else
                    {
                        direction2.rotateEinheitsVektor(-4);
                        checkAndIncrease();
//                    drawPlayer1();
                        g.drawImage(bufferedImage, 0, 0, null);
                        setRotation1(-4);
                        g.drawImage(bufferedImage, 0, 0, null);
                    }
                    break;
                case KeyEvent.VK_D:
                    if (keycode3 == KeyEvent.VK_A)
                    {
                        checkAndIncrease();
                        setRotation1(0);
                        g.drawImage(bufferedImage, 0, 0, null);
                    } else
                    {
                        direction2.rotateEinheitsVektor(4);
                        checkAndIncrease();
//                    drawPlayer1();
                        g.drawImage(bufferedImage, 0, 0, null);
                        setRotation1(4);
                        g.drawImage(bufferedImage, 0, 0, null);
                    }
                    break;
            }
        }
    }

<<<<<<< HEAD
    public void checkAndIncrease()
    {
        if (pos1.getX() <= 0)
        {
            pos1.increaseY(direction1.getY() * speed);
        } else if (pos1.getX() >= maxX)
        {
            pos1.increaseY(direction1.getY() * speed);
        } else if (pos1.getY() <= 0)
        {
            pos1.increaseX(direction1.getX() * speed);
        } else if (pos1.getY() >= maxY)
        {
            pos1.increaseX(direction1.getX() * speed);
        } else
        {
=======
//    public void checkAndIncrease() {
//        if (pos1.getX() <= 0) {
//            pos1.increaseY(direction1.getY() * speed);
//        } else if (pos1.getX() >= maxX) {
//            pos1.increaseY(direction1.getY() * speed);
//        } else if (pos1.getY() <= 0) {
//            pos1.increaseX(direction1.getX() * speed);
//        } else if (pos1.getY() >= maxY) {
//            pos1.increaseX(direction1.getX() * speed);
//        } else {
//            pos1.increaseY(direction1.getY() * speed);
//            pos1.increaseX(direction1.getX() * speed);
//        }
//    }
        public void checkAndIncrease() {
        if (pos1.getX() <= 0) {
            pos1.setX(maxX);
        } else if (pos1.getX() >= maxX) {
            pos1.setX(0);
        } else if (pos1.getY() <= 0) {
            pos1.setY(maxY);
        } else if (pos1.getY() >= maxY) {
            pos1.setY(0);
        } else {
>>>>>>> BattleShips
            pos1.increaseY(direction1.getY() * speed);
            pos1.increaseX(direction1.getX() * speed);
        }
    }

//    public void movePlayer2(int keyCode1, int keyCode2)
//    {
////        if (!(pos1.getY() - 10 < 0) && !(pos1.getX() - 10 < 0) && !(pos1.getX() + 10 + shipWidth > maxX) && !((pos1.getY() + 10 + shipHeight) > maxY))
//        if (keyCode2 == 0)
//        {
//            pos2.increaseX(direction2.getX() * speed);
//            pos2.increaseY(direction2.getY() * speed);
////            drawPlayer2();
//        } else
//        {
//            switch (keyCode2)
//            {
//                case KeyEvent.VK_LEFT:
//                    direction2.rotateEinheitsVektor(3);
//                    pos2.increaseX(direction2.getX() * speed);
//                    pos2.increaseY(direction2.getY() * speed);
////                    drawPlayer2();
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    direction2.rotateEinheitsVektor(-3);
//                    pos2.increaseX(direction2.getX() * speed);
//                    pos2.increaseY(direction2.getY() * speed);
////                    drawPlayer2();
//                    break;
//            }
//        }
//    }
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

        private Position pos;
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

            einVLinks = new EinheitsVektor(direction1.getX(), direction1.getY());
            einVRechts = new EinheitsVektor(direction1.getX(), direction1.getY());

            pos = new Position(pos1.getX(), pos1.getY());
            while (!this.isInterrupted())
            {

                for (int i = 0; i < 10; i++)
                {

                    for (int j = 0; j < 5; j++)
                    {
                        g.setColor(Color.BLACK);
                        g.fillOval(pos.getXInt() + j + i, pos.getYInt() + j + i, 2, 2);
                    }
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameBL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                pos.setX(0);
                pos.setY(0);
                this.interrupt();
                System.out.println("ShootingThread1 interrupted");
            }
        }
    }
}
