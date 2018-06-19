/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Dialog.HelpDlg;
import Dialog.NewPlayerDlg;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class StartMenuGUI extends javax.swing.JFrame {

    /**
     * Creates new form StartMenuGUI
     */
    private Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int hoeheSchirm = (int) screensize.getHeight();
    private int breiteSchirm = (int) screensize.getWidth();

    public StartMenuGUI() {
        initComponents();
        this.setBounds(breiteSchirm / 3, hoeheSchirm / 3, breiteSchirm / 3, hoeheSchirm / 3);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btHilfe = new javax.swing.JButton();
        btStarten = new javax.swing.JButton();
        btBeenden = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbBild = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BattleShips");
        setUndecorated(true);

        jPanel2.setLayout(null);

        btHilfe.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        btHilfe.setForeground(new java.awt.Color(255, 255, 255));
        btHilfe.setText("Hilfe");
        btHilfe.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        btHilfe.setContentAreaFilled(false);
        btHilfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHilfeActionPerformed(evt);
            }
        });
        jPanel2.add(btHilfe);
        btHilfe.setBounds(40, 120, 220, 45);

        btStarten.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        btStarten.setForeground(new java.awt.Color(255, 255, 255));
        btStarten.setText("Starten");
        btStarten.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        btStarten.setContentAreaFilled(false);
        btStarten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onStart(evt);
            }
        });
        jPanel2.add(btStarten);
        btStarten.setBounds(40, 60, 220, 45);

        btBeenden.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        btBeenden.setForeground(new java.awt.Color(255, 255, 255));
        btBeenden.setText("Beenden");
        btBeenden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        btBeenden.setContentAreaFilled(false);
        btBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBeenden(evt);
            }
        });
        jPanel2.add(btBeenden);
        btBeenden.setBounds(40, 180, 220, 45);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/Logo.PNG"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(440, 120, 150, 100);

        lbBild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/blasen.jpeg"))); // NOI18N
        lbBild.setMaximumSize(new java.awt.Dimension(900, 700));
        lbBild.setMinimumSize(new java.awt.Dimension(900, 700));
        lbBild.setName(""); // NOI18N
        lbBild.setPreferredSize(new java.awt.Dimension(900, 700));
        lbBild.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(lbBild);
        lbBild.setBounds(0, 0, 690, 390);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onStart(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onStart
    {//GEN-HEADEREND:event_onStart
        NewPlayerDlg pldg = new NewPlayerDlg(this, true);
        pldg.setVisible(true);
    }//GEN-LAST:event_onStart

    private void onBeenden(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onBeenden
    {//GEN-HEADEREND:event_onBeenden
        dispose();
    }//GEN-LAST:event_onBeenden

    private void btHilfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHilfeActionPerformed
        HelpDlg hdlg = new HelpDlg(this, true);
        hdlg.setVisible(true);
    }//GEN-LAST:event_btHilfeActionPerformed

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
            java.util.logging.Logger.getLogger(StartMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartMenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBeenden;
    private javax.swing.JButton btHilfe;
    private javax.swing.JButton btStarten;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbBild;
    // End of variables declaration//GEN-END:variables
}
