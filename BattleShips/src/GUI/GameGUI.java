/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.ControllsP1;
import BL.ControllsP2;
import BL.GameBL;
import Beans.EinheitsVektor;
import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private Thread zeichenP1Thread;
    private Thread zeichenP2Thread;

//    private HashMap<String, Boolean> flagMap = new HashMap();
    private ControllsP1 controllP1 = new ControllsP1();
    private ControllsP2 controllP2 = new ControllsP2();

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

        jpGame.addKeyListener(jpGameListener);
        jpGame.setFocusable(true);

        this.setExtendedState(this.MAXIMIZED_BOTH); //make it fullscrren

        bl = new GameBL(this.jpGame, new EinheitsVektor(0, 1));
//        fillMap();

        zeichenP1Thread = new zeichenP1Thread();
        zeichenP1Thread.start();

        zeichenP2Thread = new zeichenP2Thread();
        zeichenP2Thread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jpPlayer1 = new javax.swing.JPanel();
        jpPlayer2 = new javax.swing.JPanel();
        jpGame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpPlayer1Layout = new javax.swing.GroupLayout(jpPlayer1);
        jpPlayer1.setLayout(jpPlayer1Layout);
        jpPlayer1Layout.setHorizontalGroup(
            jpPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1924, Short.MAX_VALUE)
        );
        jpPlayer1Layout.setVerticalGroup(
            jpPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout jpGameLayout = new javax.swing.GroupLayout(jpGame);
        jpGame.setLayout(jpGameLayout);
        jpGameLayout.setHorizontalGroup(
            jpGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1924, Short.MAX_VALUE)
        );
        jpGameLayout.setVerticalGroup(
            jpGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 864, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    KeyListener jpGameListener = new KeyAdapter()
    {
        @Override
        public void keyPressed(KeyEvent evt)
        {
            switch (evt.getKeyCode())
            {
                case KeyEvent.VK_A:
                    System.out.println("Pressed: a");
                    controllP1.addKey(KeyEvent.VK_A);
                    break;
                case KeyEvent.VK_W:
                    System.out.println("Pressed: w");
                    controllP1.addKey(KeyEvent.VK_W);
                    break;
                case KeyEvent.VK_S:
                    System.out.println("Pressed: s");
                    controllP1.addKey(KeyEvent.VK_S);
                    break;
                case KeyEvent.VK_D:
                    System.out.println("Pressed: d");
                    controllP1.addKey(KeyEvent.VK_D);
                    break;

                case KeyEvent.VK_LEFT:
                    System.out.println("Pressed: left");
                    controllP2.addKey(KeyEvent.VK_LEFT);
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("Pressed: up");
                    controllP2.addKey(KeyEvent.VK_UP);
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Pressed: down");
                    controllP2.addKey(KeyEvent.VK_DOWN);
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("Pressed: right");
                    controllP2.addKey(KeyEvent.VK_RIGHT);
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
                    controllP1.removeKey(KeyEvent.VK_A);
                    break;
                case KeyEvent.VK_W:
                    System.out.println("Released: w");
                    controllP1.removeKey(KeyEvent.VK_W);
                    break;
                case KeyEvent.VK_S:
                    System.out.println("Released: s");
                    controllP1.removeKey(KeyEvent.VK_S);
                    break;
                case KeyEvent.VK_D:
                    System.out.println("Released: d");
                    controllP1.removeKey(KeyEvent.VK_D);
                    break;

                case KeyEvent.VK_LEFT:
                    System.out.println("Released: left");
                    controllP2.removeKey(KeyEvent.VK_LEFT);
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("Released: up");
                    controllP2.removeKey(KeyEvent.VK_UP);
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Released: down");
                    controllP2.removeKey(KeyEvent.VK_DOWN);
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("Released: right");
                    controllP2.removeKey(KeyEvent.VK_RIGHT);
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
                case KeyEvent.VK_SPACE:
                    System.out.println("# space #");
                    bl.shootPlayer1();
                    //aufruf schuss methode //player1
                    break;
                case KeyEvent.VK_ENTER:
                    System.out.println("**enter**");
                    controllP2.addKey(KeyEvent.VK_ENTER);
                    bl.shootPlayer2();
                    break;
            }
        }

    };

    public class zeichenP1Thread extends Thread
    {

//        private LinkedList<String> movement = new LinkedList();
        public zeichenP1Thread()
        {
            System.out.println("threadP1 created");
        }

        @Override
        public void run()
        {
            System.out.println("threadP1 started");
            while (!this.isInterrupted())
            {

                while (controllP1.getSize() == 1) //wenn 1 Key, aus dem KeySet von Player 1 gedrückt wird
                {
                    if (controllP1.containsKey(KeyEvent.VK_W))
                    {
                        bl.movePlayer1(KeyEvent.VK_W, 0);
                    }
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                while (controllP1.getSize() == 2) //wenn 2 Keys, aus dem KeySet von Player 1 gedrückt wird
                {
                    if (controllP1.containsKey(KeyEvent.VK_W) && (controllP1.containsKey(KeyEvent.VK_A) || controllP1.containsKey(KeyEvent.VK_D)))
                    {
                        if (controllP1.containsKey(KeyEvent.VK_D))
                        {
                            bl.movePlayer1(KeyEvent.VK_W, KeyEvent.VK_D);
                        } else if (controllP1.containsKey(KeyEvent.VK_A))
                        {
                            bl.movePlayer1(KeyEvent.VK_W, KeyEvent.VK_A);
                        }
                    }
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }

    }

    public class zeichenP2Thread extends Thread
    {

//        private LinkedList<String> movement = new LinkedList();
        public zeichenP2Thread()
        {
            System.out.println("threadP2 created");
        }

        @Override
        public void run()
        {
            System.out.println("threadP2 started");
            while (!this.isInterrupted())
            {

                while (controllP2.getSize() == 1) //wenn 1 Key, aus dem KeySet von Player 2 gedrückt wird
                {
                    if (controllP2.containsKey(KeyEvent.VK_UP))
                    {
                        bl.movePlayer2(KeyEvent.VK_UP, 0);
                    }
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                while (controllP2.getSize() == 2) //wenn 2 Keys, aus dem KeySet von Player 2 gedrückt wird
                {
                    if (controllP2.containsKey(KeyEvent.VK_UP) && (controllP2.containsKey(KeyEvent.VK_LEFT) || controllP2.containsKey(KeyEvent.VK_RIGHT)))
                    {
                        if (controllP2.containsKey(KeyEvent.VK_RIGHT))
                        {
                            bl.movePlayer2(KeyEvent.VK_UP, KeyEvent.VK_RIGHT);
                        } else if (controllP2.containsKey(KeyEvent.VK_LEFT))
                        {
                            bl.movePlayer2(KeyEvent.VK_UP, KeyEvent.VK_LEFT);
                        }
                    }
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

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
    // End of variables declaration//GEN-END:variables
}
