/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author Leonardo
 */
public class ColorDlg extends javax.swing.JFrame {

    /**
     * Creates new form ColorDlg
     */
    private Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int hoeheSchirm = (int) screensize.getHeight();
    private int breiteSchirm = (int) screensize.getWidth();
    private Color c = null;

    public ColorDlg() {
        initComponents();
        this.setBounds(breiteSchirm/3,hoeheSchirm/3,breiteSchirm/3,hoeheSchirm/3);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cChooser = new javax.swing.JColorChooser();
        jPanel2 = new javax.swing.JPanel();
        btAuswaehlen = new javax.swing.JButton();
        btBeenden = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout());
        jPanel1.add(cChooser);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(1, 6));

        btAuswaehlen.setFont(new java.awt.Font("Old English Text MT", 1, 24)); // NOI18N
        btAuswaehlen.setText("Auswählen");
        btAuswaehlen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btAuswaehlen.setContentAreaFilled(false);
        btAuswaehlen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAuswaehlenActionPerformed(evt);
            }
        });
        jPanel2.add(btAuswaehlen);

        btBeenden.setFont(new java.awt.Font("Old English Text MT", 1, 24)); // NOI18N
        btBeenden.setText("Beenden");
        btBeenden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btBeenden.setContentAreaFilled(false);
        btBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBeendenActionPerformed(evt);
            }
        });
        jPanel2.add(btBeenden);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAuswaehlenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAuswaehlenActionPerformed
        c = this.cChooser.getColor();
        dispose();
    }//GEN-LAST:event_btAuswaehlenActionPerformed

    private void btBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBeendenActionPerformed
        dispose();
    }//GEN-LAST:event_btBeendenActionPerformed

    public Color getC() {
        return c;
    }

    public boolean isC() {
        return c != null;
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
            java.util.logging.Logger.getLogger(ColorDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColorDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColorDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColorDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorDlg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAuswaehlen;
    private javax.swing.JButton btBeenden;
    private javax.swing.JColorChooser cChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
