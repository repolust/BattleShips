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
import Beans.EinheitsVektor;
import Beans.Kugel;
import Beans.Player;
import Beans.Position;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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

    private LinkedList<Player> schiffListe = new LinkedList<Player>();
    private LinkedList<Kugel> kugelListe = new LinkedList<Kugel>();

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

        this.setResizable(false);
        maxX = this.jpGame.getWidth();
        maxY = this.jpGame.getHeight();
        jpGame.addKeyListener(jpGameListener);
        jpGame.setFocusable(true);

        this.setExtendedState(this.MAXIMIZED_BOTH); //make it fullscrren

        createPlayer();

        bl = new GameBL(this.jpGame, new EinheitsVektor(1, 0), new EinheitsVektor(0, 1), schiffListe);
//        fillMap();

        zeichenThread = new zeichenThread(this.tfPosition,this.tfAnzahlKugel,this.tfVektor);
        zeichenThread.start();

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

        Player p1 = new Player("a", Color.BLUE, ship1, 100, 100, 0, 0, pos1, "schiff1", 90, new EinheitsVektor(1, 0), 12);
        Player p2 = new Player("b", Color.RED, ship2, 100, 100, 0, 0, pos2, "schiff2", 180, new EinheitsVektor(0, 1), 12);

        schiffListe.add(p1);
        schiffListe.add(p2);
    }

    public GameGUI(Image ship1, Image ship2)
    {
        initComponents();

        this.setResizable(false);

        jpGame.addKeyListener(jpGameListener);
        jpGame.setFocusable(true);

        this.setExtendedState(this.MAXIMIZED_BOTH); //make it fullscrren

        this.ship1 = ship1;
        this.ship2 = ship2;

        bl = new GameBL(this.jpGame, new EinheitsVektor(1, 0), new EinheitsVektor(0, 1), ship1, ship2);
//        fillMap();

        zeichenThread = new zeichenThread(this.tfPosition,this.tfAnzahlKugel,this.tfVektor);
        zeichenThread.start();
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
        jpPlayer2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfPosition = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfAnzahlKugel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfVektor = new javax.swing.JTextField();
        jpGame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpPlayer1.setBackground(new java.awt.Color(32, 126, 152));

        javax.swing.GroupLayout jpPlayer1Layout = new javax.swing.GroupLayout(jpPlayer1);
        jpPlayer1.setLayout(jpPlayer1Layout);
        jpPlayer1Layout.setHorizontalGroup(
            jpPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpPlayer1Layout.setVerticalGroup(
            jpPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jpPlayer1, java.awt.BorderLayout.SOUTH);

        jpPlayer2.setBackground(new java.awt.Color(32, 126, 152));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Position");

        tfPosition.setFocusable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Anzahl Kugeln");

        tfAnzahlKugel.setFocusable(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Vektor");

        tfVektor.setFocusable(false);

        javax.swing.GroupLayout jpPlayer2Layout = new javax.swing.GroupLayout(jpPlayer2);
        jpPlayer2.setLayout(jpPlayer2Layout);
        jpPlayer2Layout.setHorizontalGroup(
            jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPlayer2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfPosition)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(tfAnzahlKugel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpPlayer2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfVektor))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jpPlayer2Layout.setVerticalGroup(
            jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPlayer2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(tfAnzahlKugel)
                    .addComponent(tfVektor))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jpPlayer2, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jpGameLayout = new javax.swing.GroupLayout(jpGame);
        jpGame.setLayout(jpGameLayout);
        jpGameLayout.setHorizontalGroup(
            jpGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1924, Short.MAX_VALUE)
        );
        jpGameLayout.setVerticalGroup(
            jpGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );

        getContentPane().add(jpGame, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    KeyListener jpGameListener = new KeyAdapterImpl();

    public class zeichenThread extends Thread
    {

        private Player p1, p2;
        private JTextField tfPos,tfKugeln,tfVektor;
//        private LinkedList<String> movement = new LinkedList();

        public zeichenThread(JTextField tfPos, JTextField tfKugeln, JTextField tfVektor)
        {
            System.out.println("threadP1 created");
            this.tfPos = tfPos;
            this.tfKugeln = tfKugeln;
            this.tfVektor = tfVektor;
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
                    tfPos.setText(p1.getP().getXInt()+" / "+p1.getP().getYInt());
                    
                    tfKugeln.setText(""+kugelListe.size());
                    
//                    String s = String.format("%2.2f / %2.2f", p1.getDirection().getX(), p1.getDirection().getY());
//                    tfVektor.setText(s);
//-----------------------------------Spieler 1 ---------------------------------  

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
                        k.rotateEinheitsVektor(-4);
                        p1.setDirection(k);
                        p1.setCurrentAngle(p1.getCurrentAngle() - 4);

                    }
                    if (controlls.containsKey(KeyEvent.VK_W) && controlls.containsKey(KeyEvent.VK_D) && !controlls.containsKey(KeyEvent.VK_A))// W D Rechts Kurve
                    {
                        pos1 = p1.getP();
                        checkAndIncrease1();
                        EinheitsVektor k = p1.getDirection();
                        k.rotateEinheitsVektor(4);
                        p1.setDirection(k);
                        p1.setCurrentAngle(p1.getCurrentAngle() + 4);

                    }
//-----------------------------------Spieler 2 ---------------------------------
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
                        k.rotateEinheitsVektor(-4);
                        p2.setDirection(k);
                        p2.setCurrentAngle(p2.getCurrentAngle() - 4);

                    }
                    if (controlls.containsKey(KeyEvent.VK_UP) && controlls.containsKey(KeyEvent.VK_RIGHT) && !controlls.containsKey(KeyEvent.VK_LEFT))// UP RIGHT Rechts Kurve
                    {
                        pos2 = p2.getP();
                        checkAndIncrease2();

                        EinheitsVektor k = p2.getDirection();
                        k.rotateEinheitsVektor(4);
                        p2.setDirection(k);
                        p2.setCurrentAngle(p2.getCurrentAngle() + 4);

                    }
                    if (controlls.containsKey(KeyEvent.VK_SPACE))
                    {

                        EinheitsVektor einVLinks = new EinheitsVektor(schiffListe.get(0).getDirection().getX(), schiffListe.get(0).getDirection().getY()); //vektor
                        EinheitsVektor einVRechts = new EinheitsVektor(schiffListe.get(0).getDirection().getX(), schiffListe.get(0).getDirection().getY());

                        einVLinks.rotateEinheitsVektor(-90); //links rechts drehen
                        einVRechts.rotateEinheitsVektor(90);

                        Position posSL = new Position(schiffListe.get(0).getP().getX() + 15, schiffListe.get(0).getP().getY() + 27);//position schiff
                        Position posSR = new Position(schiffListe.get(0).getP().getX() + 15, schiffListe.get(0).getP().getY() + 63);

                        for (int i = 0; i < 24; i += 6)//4 durchgänge //i ist abstand//Linke Kugeln
                        {
                            posSL.setX((posSL.getX()+i));
                            kugelListe.add(new Kugel(einVLinks, posSL, 5));
                        }
                        for (int i = 0; i < 24; i += 6)//4 durchgänge //i ist abstand //Rechte Kugeln
                        {
                            posSL.setX((posSL.getX()+i));
                            kugelListe.add(new Kugel(einVRechts, posSR, 5));
                        }
                        controlls.removeKey(KeyEvent.VK_SPACE);
                    }
                    schiffListe.set(0, p1);
                    schiffListe.set(1, p2);
                    
//-----------------------------------kugel---------------------------------
                    for (Kugel k : kugelListe)
                    {
                        try
                        {
                            k.getPos().increaseX(k.getEinheintsVektor().getX() * 5);
                            k.getPos().increaseY(k.getEinheintsVektor().getY() * 5);


//                            if (k.getPos().getX() <= 0) {
//                                kugelListe.remove(k);
//                            } else if (k.getPos().getX() >= maxX) {
//                                kugelListe.remove(k);
//                            } else if (k.getPos().getY() <= 0) {
//                                kugelListe.remove(k);
//                            } else if (k.getPos().getY() >= maxY) {
//                                kugelListe.remove(k);
//                            }

//                            if (k.getPos().getX() > maxX || k.getPos().getX() < 0) {
//                                kugelListe.remove(k);
//                            }
//                            if (k.getPos().getY() > maxY || k.getPos().getY() < 0) {
//                                kugelListe.remove(k);
//                            }
                        } catch (Exception ex)
                        {
                            
                        }

                    }

//                    System.out.println(schiffListe.get(0).toString2());
//                    System.out.println(schiffListe.get(1).toString2());
//                    jLabel1.setText("KugelN:"+kugelListe.size());


                    CheckIfHit check = new CheckIfHit(kugelListe, schiffListe);
                    check.checkIfHit();
                    
                    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jpGame;
    private javax.swing.JPanel jpPlayer1;
    private javax.swing.JPanel jpPlayer2;
    private javax.swing.JTextField tfAnzahlKugel;
    private javax.swing.JTextField tfPosition;
    private javax.swing.JTextField tfVektor;
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
                    bl.shootPlayer2();
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
