/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.GameBL;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Leonardo
 */
public class GameGUI extends javax.swing.JFrame
{

    /**
     * Creates new form GameGUI
     */
    private GameBL bl;

    private Thread zeichenThread;

    private HashMap<String, Boolean> flagMap = new HashMap();

    @Override
    public void paint(Graphics grphcs)
    {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.

        if (bl != null)
        {
                try
                {
                    bl.drawPlayers();
                    Thread.sleep(100);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

        }

    }

    public GameGUI()
    {
        initComponents();

        jpGame.addKeyListener(jpGameListener);
        jpGame.setFocusable(true);

        this.setExtendedState(this.MAXIMIZED_BOTH); //make it fullscrren

        bl = new GameBL(this.jpGame);
        fillMap();

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
                    flagMap.replace("a", true);
                    break;
                case KeyEvent.VK_W:
                    System.out.println("Pressed: w");
                    flagMap.replace("w", true);
                    break;
                case KeyEvent.VK_S:
                    System.out.println("Pressed: s");
                    flagMap.replace("s", true);
                    break;
                case KeyEvent.VK_D:
                    System.out.println("Pressed: d");
                    flagMap.replace("d", true);
                    break;

                case KeyEvent.VK_LEFT:
                    System.out.println("Pressed: left");
                    flagMap.replace("left", true);
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("Pressed: up");
                    flagMap.replace("up", true);
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Pressed: down");
                    flagMap.replace("down", true);
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("Pressed: right");
                    flagMap.replace("right", true);
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
                    flagMap.replace("a", false);
                    break;
                case KeyEvent.VK_W:
                    System.out.println("Released: w");
                    flagMap.replace("w", false);
                    break;
                case KeyEvent.VK_S:
                    System.out.println("Released: s");
                    flagMap.replace("s", false);
                    break;
                case KeyEvent.VK_D:
                    System.out.println("Released: d");
                    flagMap.replace("d", false);
                    break;

                case KeyEvent.VK_LEFT:
                    System.out.println("Released: left");
                    flagMap.replace("left", false);
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("Released: up");
                    flagMap.replace("up", false);
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Released: down");
                    flagMap.replace("down", false);
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("Released: right");
                    flagMap.replace("right", false);
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
                    //aufruf schuss methode //player1
                    break;
                case KeyEvent.VK_ENTER:
                    System.out.println("**enter**");
                    //aufruf schuss methode //player2
                    break;
            }
        }

    };

    public void fillMap()
    {
        flagMap.put("w", false);
        flagMap.put("a", false);
        flagMap.put("s", false);
        flagMap.put("d", false);

        flagMap.put("up", false);
        flagMap.put("down", false);
        flagMap.put("left", false);
        flagMap.put("right", false);

    }

    public class zeichenThread extends Thread
    {

        private LinkedList<String> movement = new LinkedList();

        public zeichenThread()
        {
            System.out.println("thread created");
        }

        @Override
        public void run()
        {
            System.out.println("thread started");
            while (true)
            {
                for (String move : flagMap.keySet())
                {
                    boolean b = flagMap.get(move);

                    if (b)
                    {
                        movement.add(move);
                        System.out.println("Movement added");
                    }
                }
                bl.movePlayer(movement);
                try
                {
                    Thread.sleep(40);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
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
