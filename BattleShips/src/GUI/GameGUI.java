/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Controlls;
import BL.Controlls;
import BL.GameBL;
import Beans.EinheitsVektor;
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

/**
 *
 * @author Team
 */
public class GameGUI extends javax.swing.JFrame {

    /**
     * Creates new form GameGUI
     */
    private GameBL bl;

    private Thread zeichenThread;
    private Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int hoeheSchirm = (int) screensize.getHeight();
    private int breiteSchirm = (int) screensize.getWidth();

//    private HashMap<String, Boolean> flagMap = new HashMap();
    private Controlls controlls = new Controlls();
    private Image ship1 = null;
    private Image ship2 = null;

    private final String imagePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "shipbasic.png";

    private LinkedList<Player> schiffListe = new LinkedList<Player>();

    private Position pos1, pos2;

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.

        if (bl != null) {
            bl.drawPlayers();

        }
    }

    public GameGUI() {
        initComponents();

        this.setResizable(false);

        jpGame.addKeyListener(jpGameListener);
        jpGame.setFocusable(true);

        this.setExtendedState(this.MAXIMIZED_BOTH); //make it fullscrren

        createPlayer();

        bl = new GameBL(this.jpGame, new EinheitsVektor(1, 0), new EinheitsVektor(0, 1));
//        fillMap();

        zeichenThread = new zeichenThread();
        zeichenThread.start();

    }

    public void createPlayer() {
        try {
            ship1 = ImageIO.read(new File(imagePath));
            ship2 = ImageIO.read(new File(imagePath));
            pos1 = new Position(300, (hoeheSchirm / 2 - 35));
            pos2 = new Position((breiteSchirm - 390), (hoeheSchirm / 2 - 35));
        } catch (IOException ex) {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        Player p1 = new Player("a", Color.BLUE, ship1, 100, 100, 0, 0, pos1, "schiff1", 180, new EinheitsVektor(1, 0), 12);
        Player p2 = new Player("b", Color.RED, ship2, 100, 100, 0, 0, pos2, "schiff2", 0, new EinheitsVektor(0, 1), 12);
        
        schiffListe.add(p1);
        schiffListe.add(p2);
    }

    public GameGUI(Image ship1, Image ship2) {
        initComponents();

        this.setResizable(false);

        jpGame.addKeyListener(jpGameListener);
        jpGame.setFocusable(true);

        this.setExtendedState(this.MAXIMIZED_BOTH); //make it fullscrren

        this.ship1 = ship1;
        this.ship2 = ship2;

        bl = new GameBL(this.jpGame, new EinheitsVektor(1, 0), new EinheitsVektor(0, 1), ship1, ship2);
//        fillMap();

        zeichenThread = new zeichenThread();
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
        jpGame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout jpPlayer2Layout = new javax.swing.GroupLayout(jpPlayer2);
        jpPlayer2.setLayout(jpPlayer2Layout);
        jpPlayer2Layout.setHorizontalGroup(
            jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpPlayer2Layout.setVerticalGroup(
            jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
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

    public class zeichenThread extends Thread {

//        private LinkedList<String> movement = new LinkedList();
        public zeichenThread() {
            System.out.println("threadP1 created");
        }

        @Override
        public void run() {
            try {
                Player p1 = schiffListe.get(0);
                Player p2 = schiffListe.get(1);
                if (controlls.containsKey(KeyEvent.VK_W)) {
                    Position pos1 = p1.getP();
                    pos1.increaseY(p1.getDirection().getY() * p1.getSpeed());
                    pos1.increaseX(p1.getDirection().getX() * p1.getSpeed());
                    p1.setP(pos1);
                }
                if (controlls.containsKey(KeyEvent.VK_A)) {
                    Position pos1 = p1.getP();
                    pos1.increaseY(p1.getDirection().getY() * p1.getSpeed());
                    pos1.increaseX(p1.getDirection().getX() * p1.getSpeed());
                    p1.setCurrentAngle(p1.getCurrentAngle() + 4);
                    p1.setP(pos1);
                }
                if (controlls.containsKey(KeyEvent.VK_D)) {
                    Position pos1 = p1.getP();
                    pos1.increaseY(p1.getDirection().getY() * p1.getSpeed());
                    pos1.increaseX(p1.getDirection().getX() * p1.getSpeed());
                    p1.setCurrentAngle(p1.getCurrentAngle() - 4);
                    p1.setP(pos1);
                }

                if (controlls.containsKey(KeyEvent.VK_UP)) {
                    Position pos2 = p2.getP();
                    pos2.increaseY(p2.getDirection().getY() * p2.getSpeed());
                    pos2.increaseX(p2.getDirection().getX() * p2.getSpeed());
                    p2.setP(pos2);
                }
                if (controlls.containsKey(KeyEvent.VK_LEFT)) {
                    Position pos2 = p2.getP();
                    pos2.increaseY(p2.getDirection().getY() * p2.getSpeed());
                    pos2.increaseX(p2.getDirection().getX() * p2.getSpeed());
                    p1.setCurrentAngle(p2.getCurrentAngle() + 4);
                    p2.setP(pos2);
                }
                if (controlls.containsKey(KeyEvent.VK_RIGHT)) {
                    Position pos2 = p2.getP();
                    pos2.increaseY(p2.getDirection().getY() * p2.getSpeed());
                    pos2.increaseX(p2.getDirection().getX() * p2.getSpeed());
                    p1.setCurrentAngle(p2.getCurrentAngle() - 4);
                    p2.setP(pos2);
                }
                schiffListe.set(0, p1);
                schiffListe.set(1, p2);

                bl.draw(schiffListe);
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//
//                while (controllP1.getSize() == 1) //wenn 1 Key, aus dem KeySet von Player 1 gedrückt wird
//                {
//                    if (controllP1.containsKey(KeyEvent.VK_W)) {
//                        bl.movePlayer1(KeyEvent.VK_W, 0,0);
//                    }
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//                while (controllP1.getSize() == 2) //wenn 2 Keys, aus dem KeySet von Player 1 gedrückt werden
//                {
//                    if (controllP1.containsKey(KeyEvent.VK_W) && (controllP1.containsKey(KeyEvent.VK_A) || controllP1.containsKey(KeyEvent.VK_D))) {
//                        if (controllP1.containsKey(KeyEvent.VK_D)) {
//                            bl.movePlayer1(KeyEvent.VK_W, KeyEvent.VK_D,0);
//                        } else if (controllP1.containsKey(KeyEvent.VK_A)) {
//                            bl.movePlayer1(KeyEvent.VK_W, KeyEvent.VK_A,0);
//                        }
//                    }
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                
//                while (controllP1.getSize() == 3) //wenn 3 Keys, aus dem KeySet von Player 1 gedrückt werden
//                {
//                    if (controllP1.containsKey(KeyEvent.VK_W) && (controllP1.containsKey(KeyEvent.VK_A) && controllP1.containsKey(KeyEvent.VK_D))) {
//                        if (controllP1.containsKey(KeyEvent.VK_D)) {
//                            bl.movePlayer1(KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_A);
//                        } else if (controllP1.containsKey(KeyEvent.VK_A)) {
//                            bl.movePlayer1(KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_D);
//                        }
//                    }
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//            }
//        }

    public class zeichenP2Thread extends Thread {

////        private LinkedList<String> movement = new LinkedList();
//        public zeichenP2Thread() {
//            System.out.println("threadP2 created");
//        }
//
//        @Override
//        public void run() {
//            System.out.println("threadP2 started");
//            while (!this.isInterrupted()) {
//
//                while (controllP2.getSize() == 1) //wenn 1 Key, aus dem KeySet von Player 2 gedrückt wird
//                {
//                    if (controllP2.containsKey(KeyEvent.VK_UP)) {
//                        bl.movePlayer2(KeyEvent.VK_UP, 0,0);
//                    }
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//                while (controllP2.getSize() == 2) //wenn 2 Keys, aus dem KeySet von Player 2 gedrückt wird
//                {
//
//                    if (controllP2.containsKey(KeyEvent.VK_UP) && (controllP2.containsKey(KeyEvent.VK_LEFT) || controllP2.containsKey(KeyEvent.VK_RIGHT))) {
//                        if (controllP2.containsKey(KeyEvent.VK_RIGHT)) {
//                            bl.movePlayer2(KeyEvent.VK_UP, KeyEvent.VK_RIGHT,0);
//                        } else if (controllP2.containsKey(KeyEvent.VK_LEFT)) {
//                            bl.movePlayer2(KeyEvent.VK_UP, KeyEvent.VK_LEFT,0);
//                        }
//                    }
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                }
//                while (controllP2.getSize() == 3) //wenn 3 Keys, aus dem KeySet von Player 1 gedrückt werden
//                {
//                    if (controllP2.containsKey(KeyEvent.VK_W) && (controllP2.containsKey(KeyEvent.VK_A) && controllP2.containsKey(KeyEvent.VK_D))) {
//                        if (controllP2.containsKey(KeyEvent.VK_D)) {
//                            bl.movePlayer2(KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_A);
//                        } else if (controllP2.containsKey(KeyEvent.VK_A)) {
//                            bl.movePlayer2(KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_D);
//                        }
//                    }
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//            }
//        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpGame;
    private javax.swing.JPanel jpPlayer1;
    private javax.swing.JPanel jpPlayer2;
    // End of variables declaration//GEN-END:variables

    private class KeyAdapterImpl extends KeyAdapter {

        public KeyAdapterImpl() {
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            switch (evt.getKeyCode()) {
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
            }
        }

        @Override
        public void keyReleased(KeyEvent evt) {
            switch (evt.getKeyCode()) {
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
            }

        }

        @Override
        public void keyTyped(KeyEvent evt) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_ESCAPE:
                    System.out.println("ESC");

                    //menüaufruf
                    break;
                case KeyEvent.VK_SPACE:
                    System.out.println("# space #");
                    bl.shootPlayer1();
                    //aufruf schuss methode //player1
                    break;
                case KeyEvent.VK_ENTER:
                    System.out.println("**enter**");
                    controlls.addKey(KeyEvent.VK_ENTER);
                    bl.shootPlayer2();
                    break;
            }
        }
    }
}
