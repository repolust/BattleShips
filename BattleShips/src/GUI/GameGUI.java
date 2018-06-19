/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.CheckIfHit;
import BL.Controlls;
import BL.Controlls;
import BL.GameBL;
import BL.MP3Player;
import BL.MusikThread;
import Beans.EinheitsVektor;
import Beans.Kugel;
import Beans.Player;
import Beans.Position;
import Beans.Treffer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Team
 */
public class GameGUI extends javax.swing.JFrame
{

    /**
     * Creates new form GameGUI
     */
    private GameBL bl;

    private Thread zeichenThread;
    private Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int maxX;
    private int maxY;

//    private HashMap<String, Boolean> flagMap = new HashMap();
    private Controlls controlls = new Controlls();
    private Image ship1 = null;
    private Image ship2 = null;

    private final String imagePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "shipbasic.png";
    
    private final String soundPath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "sound"
            + File.separator + "meer.mp3";
    
    private final String cannonPath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "sound"
            + File.separator + "cannon.mp3";
    
    private LinkedList<Player> schiffListe = new LinkedList<Player>();
    private LinkedList<Kugel> kugelListe = new LinkedList<Kugel>();
    private MusikThread shot;
    private Position pos1, pos2;

    

    @Override
    public void paint(Graphics grphcs)
    {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.

        if (bl != null)
        {
            bl.drawPlayers();

        }
    }

    public GameGUI()
    {
        initComponents();

//        this.setExtendedState(this.MAXIMIZED_BOTH); //make it fullscrren
        this.setSize(1920, 1080);
        this.setVisible(true);
        
        

//        this.setResizable(false);
        maxX = (int) this.jpGame.getSize().getWidth();
        maxY = (int) this.jpGame.getSize().getHeight();
        jpGame.addKeyListener(jpGameListener);
        jpGame.setFocusable(true);

        createPlayer();

        bl = new GameBL(this.jpGame, new EinheitsVektor(1, 0), new EinheitsVektor(0, 1), schiffListe);
//        fillMap();

        zeichenThread = new zeichenThread(this.lbP1Health, this.lbP1Munition, this.lbP2Health, this.lbP2Munition);
        zeichenThread.start();
        
       
        startMusik();
    }

    public void startMusik()
    {
         MusikThread mt = new MusikThread(soundPath);
         mt.start();
    }
    
    public void startCannonSound()
    {
        shot = new MusikThread(cannonPath);
         shot.start();
    }
    
    
    public void createPlayer()
    {
        try
        {
            ship1 = ImageIO.read(new File(imagePath));
            ship2 = ImageIO.read(new File(imagePath));
            pos1 = new Position(300, (maxY / 2 - 35));
            pos2 = new Position((maxX - 390), (maxY / 2 - 35));
        } catch (IOException ex)
        {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        Player p1 = new Player("Spieler1", Color.BLUE, ship1, 100, 150, 0, pos1, "schiff1", 90, new EinheitsVektor(1, 0), 8, 3);
        Player p2 = new Player("Spieler2", Color.RED, ship2, 100, 150, 0, pos2, "schiff2", 270, new EinheitsVektor(-1, 0), 8, 3);

        schiffListe.add(p1);
        schiffListe.add(p2);
    }

    public GameGUI(Player p1, Player p2)
    {
       initComponents();

//        this.setExtendedState(this.MAXIMIZED_BOTH); //make it fullscrren
        this.setSize(1920, 1080);
        this.setVisible(true);
//        this.setResizable(false);
            
        this.jpPlayer1.setBackground(p1.getC());
        this.jpPlayer2.setBackground(p2.getC());
        
        this.lbPlayer1.setText(p1.getName()+":");
        this.lbPlayer2.setText(p2.getName()+":");
        
        maxX = (int) this.jpGame.getSize().getWidth();
        maxY = (int) this.jpGame.getSize().getHeight();
        jpGame.addKeyListener(jpGameListener);
        jpGame.setFocusable(true);

        pos1 = new Position(300, (maxY / 2 - 35));
        pos2 = new Position((maxX - 390), (maxY / 2 - 35));     
        p1.setP(pos1);
        p2.setP(pos2);
        
        schiffListe.add(p1);
        schiffListe.add(p2);
     

        bl = new GameBL(this.jpGame, new EinheitsVektor(1, 0), new EinheitsVektor(0, 1), schiffListe);


        zeichenThread = new zeichenThread(this.lbP1Health, this.lbP1Munition, this.lbP2Health, this.lbP2Munition);
        zeichenThread.start();
        
        startMusik();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPlayer1 = new javax.swing.JPanel();
        lbPlayer1 = new javax.swing.JLabel();
        lbP1Health = new javax.swing.JLabel();
        lbP1Munition = new javax.swing.JLabel();
        jpPlayer2 = new javax.swing.JPanel();
        lbPlayer2 = new javax.swing.JLabel();
        lbP2Health = new javax.swing.JLabel();
        lbP2Munition = new javax.swing.JLabel();
        jpGame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpPlayer1.setBackground(new java.awt.Color(0, 102, 204));
        jpPlayer1.setLayout(new java.awt.GridLayout(1, 3));

        lbPlayer1.setBackground(new java.awt.Color(255, 0, 51));
        lbPlayer1.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        lbPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlayer1.setText("Player 1:");
        jpPlayer1.add(lbPlayer1);

        lbP1Health.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbP1Health.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbP1Health.setText("Health:");
        jpPlayer1.add(lbP1Health);

        lbP1Munition.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbP1Munition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbP1Munition.setText("Munition:");
        jpPlayer1.add(lbP1Munition);

        jpPlayer2.setBackground(new java.awt.Color(0, 102, 204));
        jpPlayer2.setLayout(new java.awt.GridLayout(1, 3));

        lbPlayer2.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        lbPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlayer2.setText("Player 2:");
        jpPlayer2.add(lbPlayer2);

        lbP2Health.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbP2Health.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbP2Health.setText("Health:");
        jpPlayer2.add(lbP2Health);

        lbP2Munition.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbP2Munition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbP2Munition.setText("Munition:");
        jpPlayer2.add(lbP2Munition);

        javax.swing.GroupLayout jpGameLayout = new javax.swing.GroupLayout(jpGame);
        jpGame.setLayout(jpGameLayout);
        jpGameLayout.setHorizontalGroup(
            jpGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpGameLayout.setVerticalGroup(
            jpGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, 1924, Short.MAX_VALUE)
            .addComponent(jpGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPlayer2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    KeyListener jpGameListener = new KeyAdapterImpl();

    public class zeichenThread extends Thread
    {

        private Player p1, p2;
        private JLabel lbP1Health, lbP1Munition, lbP2Health, lbP2Munition;
//        private LinkedList<String> movement = new LinkedList();

        public zeichenThread(JLabel lbP1Health, JLabel lbP1Munition, JLabel lbP2Health, JLabel lbP2Munition)
        {
            System.out.println("threadP1 created");
            this.lbP1Health = lbP1Health;
            this.lbP1Munition = lbP1Munition;
            this.lbP2Health = lbP2Health;
            this.lbP2Munition = lbP2Munition;
        }

        @Override
        public void run()
        {
            while (!isInterrupted())
            {
                try
                {
                    p1 = schiffListe.get(0);
                    p2 = schiffListe.get(1);
//                    lbP1Position.setText(p1.getP().getXInt() + " / " + p1.getP().getYInt());
//
//                    lbP1Ballz.setText("" + kugelListe.size());
//
////                    String s = String.format("%2.2f / %2.2f", p1.getDirection().getX(), p1.getDirection().getY());
//                    lbP1Vektor.setText("" + p1.getCurrentAngle());

//                    tfVektor.setText(s);
                    this.lbP1Health.setText("Health: " + p1.getLeben());
                    this.lbP2Health.setText("Health: " + p2.getLeben());
                    this.lbP1Munition.setText("Munition: " + p1.getMunition());
                    this.lbP2Munition.setText("Munition: " + p2.getMunition());

//-----------------------------------Spieler 1 ---------------------------------  
                    if (p1.getCurrentAngle() >= 360 || p1.getCurrentAngle() <= -360) // reset Angle
                    {
                        p1.setCurrentAngle(0);
                    }

                    if (controlls.containsKey(KeyEvent.VK_W) && !controlls.containsKey(KeyEvent.VK_A) && !controlls.containsKey(KeyEvent.VK_D))// W Gerade aus
                    {
                        pos1 = p1.getP();
                        checkAndIncrease1();

                    }
                    if (controlls.containsKey(KeyEvent.VK_W) && controlls.containsKey(KeyEvent.VK_A) && controlls.containsKey(KeyEvent.VK_D))// W A D Gerade aus
                    {
                        pos1 = p1.getP();
                        checkAndIncrease1();

                    }
                    if (controlls.containsKey(KeyEvent.VK_W) && controlls.containsKey(KeyEvent.VK_A) && !controlls.containsKey(KeyEvent.VK_D))// W A Links Kurve
                    {
                        pos1 = p1.getP();
                        checkAndIncrease1();
                        EinheitsVektor k = p1.getDirection();
                        k.rotateEinheitsVektor(-p1.getRotation());
                        p1.setDirection(k);
                        p1.setCurrentAngle(p1.getCurrentAngle() - p1.getRotation());

                    }
                    if (controlls.containsKey(KeyEvent.VK_W) && controlls.containsKey(KeyEvent.VK_D) && !controlls.containsKey(KeyEvent.VK_A))// W D Rechts Kurve
                    {
                        pos1 = p1.getP();
                        checkAndIncrease1();
                        EinheitsVektor k = p1.getDirection();
                        k.rotateEinheitsVektor(p1.getRotation());
                        p1.setDirection(k);
                        p1.setCurrentAngle(p1.getCurrentAngle() + p1.getRotation());

                    }
                    if (controlls.containsKey(KeyEvent.VK_SPACE)) // Schuss
                    {

                        EinheitsVektor einVLinks = new EinheitsVektor(schiffListe.get(0).getDirection().getX(), schiffListe.get(0).getDirection().getY()); //vektor
                        EinheitsVektor einVRechts = new EinheitsVektor(schiffListe.get(0).getDirection().getX(), schiffListe.get(0).getDirection().getY());

                        einVLinks.rotateEinheitsVektor(-90); //links rechts drehen
                        einVRechts.rotateEinheitsVektor(90);

//                        Position posSL = new Position(schiffListe.get(0).getP().getX() + 15, schiffListe.get(0).getP().getY() + 27);//position schiff
//                        Position posSR = new Position(schiffListe.get(0).getP().getX() + 15, schiffListe.get(0).getP().getY() + 63);
//                        Rectangle hitbox =  p1.getHitbox();
                        Rectangle hitbox = new Rectangle(p1.getHitbox().x, p1.getHitbox().y, p1.getHitbox().width, p1.getHitbox().height);
//                        

                        for (int i = 0; i <= 14; i += 7)
                        {
                            Position posSL = new Position(hitbox.getCenterX() - 3, hitbox.getCenterY() - 3);
                            Position posSR = new Position(hitbox.getCenterX() + 3, hitbox.getCenterY() + 3);

                            if ((p1.getCurrentAngle() > 70 && p1.getCurrentAngle() < 110 || p1.getCurrentAngle() > 250 && p1.getCurrentAngle() < 290) || (p1.getCurrentAngle() < -70 && p1.getCurrentAngle() > -110 || p1.getCurrentAngle() < -250 && p1.getCurrentAngle() > -290))
                            {
                                posSL.increaseX(i);
                                posSR.increaseX(i);
                            } else if ((p1.getCurrentAngle() > 340 && p1.getCurrentAngle() <= 360 || p1.getCurrentAngle() > 160 && p1.getCurrentAngle() <= 200 || p1.getCurrentAngle() >= 0 && p1.getCurrentAngle() < 20) || (p1.getCurrentAngle() < -340 && p1.getCurrentAngle() >= -360 || p1.getCurrentAngle() < -160 && p1.getCurrentAngle() >= -200 || p1.getCurrentAngle() <= -0 && p1.getCurrentAngle() > -20))
                            {
                                posSL.increaseY(i);
                                posSR.increaseY(i);
                            } else if ((p1.getCurrentAngle() > 20 && p1.getCurrentAngle() < 70 || p1.getCurrentAngle() > 200 && p1.getCurrentAngle() < 250) || (p1.getCurrentAngle() < -290 && p1.getCurrentAngle() > -340 || p1.getCurrentAngle() < -110 && p1.getCurrentAngle() > -160))
                            {
                                posSL.increaseX(i * (-1));
                                posSR.increaseX(i * (-1));
                                posSL.increaseY(i);
                                posSR.increaseY(i);
                            } else
                            {
                                posSL.increaseX(i);
                                posSR.increaseX(i);
                                posSL.increaseY(i);
                                posSR.increaseY(i);
                            }
                            if (!(p1.getMunition() <= 0))
                            {
                                kugelListe.add(new Kugel(einVLinks, posSL, 5, 1));
                                kugelListe.add(new Kugel(einVRechts, posSR, 5, 1));
                                p1.setMunition(p1.getMunition() - 2);

                            }
                        }
//                            
                        controlls.removeKey(KeyEvent.VK_SPACE);
                        if(p1.getMunition() != 0)
                        {
                            startCannonSound();
                        }
                        
                    }

//-----------------------------------Spieler 2 ---------------------------------
                    if (p2.getCurrentAngle() >= 360 || p2.getCurrentAngle() <= -360)// reset Angle
                    {
                        p2.setCurrentAngle(0);
                    }

                    if (controlls.containsKey(KeyEvent.VK_UP) && !controlls.containsKey(KeyEvent.VK_LEFT) && !controlls.containsKey(KeyEvent.VK_RIGHT))// UP Gerade aus
                    {
                        pos2 = p2.getP();
                        checkAndIncrease2();

                    }
                    if (controlls.containsKey(KeyEvent.VK_UP) && controlls.containsKey(KeyEvent.VK_LEFT) && controlls.containsKey(KeyEvent.VK_RIGHT))// UP LEFT RIGHT Gerade aus
                    {
                        pos2 = p2.getP();
                        checkAndIncrease2();

                    }
                    if (controlls.containsKey(KeyEvent.VK_UP) && controlls.containsKey(KeyEvent.VK_LEFT) && !controlls.containsKey(KeyEvent.VK_RIGHT))// UP LEFT Links Kurve
                    {
                        pos2 = p2.getP();
                        checkAndIncrease2();

                        EinheitsVektor k = p2.getDirection();
                        k.rotateEinheitsVektor(-p1.getRotation());
                        p2.setDirection(k);
                        p2.setCurrentAngle(p2.getCurrentAngle() - p1.getRotation());

                    }
                    if (controlls.containsKey(KeyEvent.VK_UP) && controlls.containsKey(KeyEvent.VK_RIGHT) && !controlls.containsKey(KeyEvent.VK_LEFT))// UP RIGHT Rechts Kurve
                    {
                        pos2 = p2.getP();
                        checkAndIncrease2();

                        EinheitsVektor k = p2.getDirection();
                        k.rotateEinheitsVektor(p1.getRotation());
                        p2.setDirection(k);
                        p2.setCurrentAngle(p2.getCurrentAngle() + p1.getRotation());

                    }

                    if (controlls.containsKey(KeyEvent.VK_ENTER)) // Schuss
                    {

                        EinheitsVektor einVLinks = new EinheitsVektor(schiffListe.get(1).getDirection().getX(), schiffListe.get(1).getDirection().getY()); //vektor
                        EinheitsVektor einVRechts = new EinheitsVektor(schiffListe.get(1).getDirection().getX(), schiffListe.get(1).getDirection().getY());

                        einVLinks.rotateEinheitsVektor(-90); //links rechts drehen
                        einVRechts.rotateEinheitsVektor(90);

//                        Position posSL = new Position(schiffListe.get(0).getP().getX() + 15, schiffListe.get(0).getP().getY() + 27);//position schiff
//                        Position posSR = new Position(schiffListe.get(0).getP().getX() + 15, schiffListe.get(0).getP().getY() + 63);
//                        Rectangle hitbox =  p1.getHitbox();
                        Rectangle hitbox = new Rectangle(p2.getHitbox().x, p2.getHitbox().y, p2.getHitbox().width, p2.getHitbox().height);
//                        

                        for (int i = 0; i <= 14; i += 7)
                        {
                            Position posSL = new Position(hitbox.getCenterX() - 3, hitbox.getCenterY() - 3);
                            Position posSR = new Position(hitbox.getCenterX() + 3, hitbox.getCenterY() + 3);

                            if ((p2.getCurrentAngle() > 70 && p2.getCurrentAngle() < 110 || p2.getCurrentAngle() > 250 && p2.getCurrentAngle() < 290) || (p2.getCurrentAngle() < -70 && p2.getCurrentAngle() > -110 || p2.getCurrentAngle() < -250 && p2.getCurrentAngle() > -290))
                            {
                                posSL.increaseX(i);
                                posSR.increaseX(i);
                            } else if ((p2.getCurrentAngle() > 340 && p2.getCurrentAngle() <= 360 || p2.getCurrentAngle() > 160 && p2.getCurrentAngle() <= 200 || p2.getCurrentAngle() >= 0 && p2.getCurrentAngle() < 20) || (p2.getCurrentAngle() < -340 && p2.getCurrentAngle() >= -360 || p2.getCurrentAngle() < -160 && p2.getCurrentAngle() >= -200 || p2.getCurrentAngle() <= -0 && p2.getCurrentAngle() > -20))
                            {
                                posSL.increaseY(i);
                                posSR.increaseY(i);
                            } else if ((p2.getCurrentAngle() > 20 && p2.getCurrentAngle() < 70 || p2.getCurrentAngle() > 200 && p2.getCurrentAngle() < 250) || (p2.getCurrentAngle() < -290 && p2.getCurrentAngle() > -340 || p2.getCurrentAngle() < -110 && p2.getCurrentAngle() > -160))
                            {
                                posSL.increaseX(i * (-1));
                                posSR.increaseX(i * (-1));
                                posSL.increaseY(i);
                                posSR.increaseY(i);
                            } else
                            {
                                posSL.increaseX(i);
                                posSR.increaseX(i);
                                posSL.increaseY(i);
                                posSR.increaseY(i);
                            }

                            if (!(p2.getMunition() <= 0))
                            {
                                kugelListe.add(new Kugel(einVLinks, posSL, 5, 2));
                                kugelListe.add(new Kugel(einVRechts, posSR, 5, 2));
                                p2.setMunition(p2.getMunition() - 2);

                            }

                        }

                        controlls.removeKey(KeyEvent.VK_ENTER);
                        if(p2.getMunition() != 0)
                        {
                            startCannonSound();
                        }
                    }

//-----------------------------------Liste setzen---------------------------------                    
                    schiffListe.set(0, p1);
                    schiffListe.set(1, p2);

//-----------------------------------kugel---------------------------------
                    int removeIndex = -1;

                    for (Kugel k : kugelListe)
                    {

                        k.getPos().increaseX(k.getEinheintsVektor().getX() * 20);
                        k.getPos().increaseY(k.getEinheintsVektor().getY() * 20);

                        if (k.getPos().getX() > maxX || k.getPos().getX() < 0)
                        {
                            removeIndex = kugelListe.indexOf(k);
//                                kugelListe.remove(k);

                        }
                        if (k.getPos().getY() > maxY || k.getPos().getY() < 0)
                        {
                            removeIndex = kugelListe.indexOf(k);
//                                kugelListe.remove(k);

                        }

                    }

                    if (removeIndex != -1)
                    {
                        kugelListe.remove(removeIndex);
                    }

//                    System.out.println(schiffListe.get(0).toString2());
//                    System.out.println(schiffListe.get(1).toString2());
//                    jLabel1.setText("KugelN:"+kugelListe.size());
                    CheckIfHit check = new CheckIfHit(kugelListe, schiffListe);

                    if (check.checkCollision())
                    {
                        if (p1.getLeben() < 15 && p2.getLeben() > 50)
                        {
                            p1.setLeben(0);
                        } else if (p2.getLeben() < 15 && p1.getLeben() > 50)
                        {
                            p2.setLeben(0);
                        } else
                        {
                            p1.setLeben(p1.getLeben() - 10);
                            p2.setLeben(p2.getLeben() - 10);
                        }

                        pos1 = new Position(300, (maxY / 2 - 35));
                        pos2 = new Position((maxX - 390), (maxY / 2 - 35));
                        p1.setP(pos1);
                        p2.setP(pos2);

                    }

                    if (check.checkIfHit() != null)
                    {
                        Treffer t = check.checkIfHit();
                        kugelListe.remove((t.getKugelIndex()));

                    }

                    if (p1.getLeben() <= 0)
                    {
                        JOptionPane.showMessageDialog(null, p2.getName()+" hat gewonnen!");
                        //zurück ins menü!
                        this.interrupt();
                        System.exit(0);
                    } else if (p2.getLeben() <= 0)
                    {
                        JOptionPane.showMessageDialog(null, p1.getName()+"Spieler 1 hat gewonnen!");
                        //zurück ins menü!
                        this.interrupt();
                        System.exit(0);
                    }
//                        JOptionPane.showMessageDialog(null, "Spieler " + t.getPlayernummer() + " wurde getroffen!");
                    bl.draw(schiffListe, kugelListe);

                    Thread.sleep(10);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        public void checkAndIncrease1()
        {

            if (p1.getP().getX() <= 0)
            {
                pos1.setX(maxX - 1);
            } else if (pos1.getX() >= maxX)
            {
                pos1.setX(1);
            } else if (pos1.getY() <= 0)
            {
                pos1.setY(maxY - 1);
            } else if (pos1.getY() >= maxY)
            {
                pos1.setY(1);
            } else
            {
                pos1.increaseY(p1.getDirection().getY() * p1.getSpeed());
                pos1.increaseX(p1.getDirection().getX() * p1.getSpeed());
            }
        }

        public void checkAndIncrease2()
        {
            if (p2.getP().getX() <= 0)
            {
                pos2.setX(maxX - 1);
            } else if (pos2.getX() >= maxX)
            {
                pos2.setX(1);
            } else if (pos2.getY() <= 0)
            {
                pos2.setY(maxY - 1);
            } else if (pos2.getY() >= maxY)
            {
                pos2.setY(1);
            } else
            {
                pos2.increaseY(p2.getDirection().getY() * p2.getSpeed());
                pos2.increaseX(p2.getDirection().getX() * p2.getSpeed());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(GameGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GameGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GameGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GameGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpGame;
    private javax.swing.JPanel jpPlayer1;
    private javax.swing.JPanel jpPlayer2;
    private javax.swing.JLabel lbP1Health;
    private javax.swing.JLabel lbP1Munition;
    private javax.swing.JLabel lbP2Health;
    private javax.swing.JLabel lbP2Munition;
    private javax.swing.JLabel lbPlayer1;
    private javax.swing.JLabel lbPlayer2;
    // End of variables declaration//GEN-END:variables

    private class KeyAdapterImpl extends KeyAdapter
    {

        public KeyAdapterImpl()
        {
        }

        @Override
        public void keyPressed(KeyEvent evt)
        {
            switch (evt.getKeyCode())
            {
                case KeyEvent.VK_A:
                    System.out.println("Pressed: a");
                    controlls.addKey(KeyEvent.VK_A);
                    break;
                case KeyEvent.VK_W:
                    System.out.println("Pressed: w");
                    controlls.addKey(KeyEvent.VK_W);
                    break;
                case KeyEvent.VK_S:
                    System.out.println("Pressed: s");
                    controlls.addKey(KeyEvent.VK_S);
                    break;
                case KeyEvent.VK_D:
                    System.out.println("Pressed: d");
                    controlls.addKey(KeyEvent.VK_D);
                    break;

                case KeyEvent.VK_LEFT:
                    System.out.println("Pressed: left");
                    controlls.addKey(KeyEvent.VK_LEFT);
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("Pressed: up");
                    controlls.addKey(KeyEvent.VK_UP);
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Pressed: down");
                    controlls.addKey(KeyEvent.VK_DOWN);
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("Pressed: right");
                    controlls.addKey(KeyEvent.VK_RIGHT);
                    break;
                case KeyEvent.VK_SPACE:
                    System.out.println("# space #");
                    controlls.addKey(KeyEvent.VK_SPACE);
//                    bl.shootPlayer1();
                    //aufruf schuss methode //player1
                    break;
                case KeyEvent.VK_ENTER:
                    System.out.println("**enter**");
                    controlls.addKey(KeyEvent.VK_ENTER);
//                    bl.shootPlayer2();
                    break;
            }

        }

        @Override
        public void keyReleased(KeyEvent evt)
        {
            switch (evt.getKeyCode())
            {
                case KeyEvent.VK_A:
                    System.out.println("Released: a");
                    controlls.removeKey(KeyEvent.VK_A);
                    break;
                case KeyEvent.VK_W:
                    System.out.println("Released: w");
                    controlls.removeKey(KeyEvent.VK_W);
                    break;
                case KeyEvent.VK_S:
                    System.out.println("Released: s");
                    controlls.removeKey(KeyEvent.VK_S);
                    break;
                case KeyEvent.VK_D:
                    System.out.println("Released: d");
                    controlls.removeKey(KeyEvent.VK_D);
                    break;
                case KeyEvent.VK_SPACE:
                    System.out.println("Released: space");
                    controlls.removeKey(KeyEvent.VK_SPACE);
                    break;
                case KeyEvent.VK_LEFT:
                    System.out.println("Released: left");
                    controlls.removeKey(KeyEvent.VK_LEFT);
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("Released: up");
                    controlls.removeKey(KeyEvent.VK_UP);
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Released: down");
                    controlls.removeKey(KeyEvent.VK_DOWN);
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("Released: right");
                    controlls.removeKey(KeyEvent.VK_RIGHT);
                    break;
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
                    break;
            }

        }

        @Override
        public void keyTyped(KeyEvent evt)
        {
            switch (evt.getKeyCode())
            {
                case KeyEvent.VK_ESCAPE:
                    System.out.println("ESC");

                    //menüaufruf
                    break;

            }
        }
    }
}
