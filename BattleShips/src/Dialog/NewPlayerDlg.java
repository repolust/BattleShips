/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialog;

import BL.ListModel;
import Beans.EinheitsVektor;
import Beans.Option;
import Beans.Position;
import Beans.Player;
import GUI.GameGUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class NewPlayerDlg extends javax.swing.JDialog {

    /**
     * Creates new form NewPlayerDlg
     */
    private Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int hoeheSchirm = (int) screensize.getHeight();
    private int breiteSchirm = (int) screensize.getWidth();

    private String name = null;
    private Color c;

    private Player p;

    private ListModel lm = new ListModel();

    private int index = 0;

    private Image ship = null;
    private String shiffArt = "";
    private Option o;

    public NewPlayerDlg(java.awt.Frame parent, boolean modal, Option o) {
        super(parent, modal);
        initComponents();
        this.setBounds(breiteSchirm * 2 / 3, hoeheSchirm / 3, breiteSchirm / 6, hoeheSchirm / 3);
        this.setResizable(false);
        this.jlMyPlayerListe.setModel(lm);
        this.o = o;
    }

    public void clearAuswahl() {
        ship = null;
        shiffArt = "";
        p = null;
        c = null;
        name = null;
        this.tfName.setText("");
        this.btFarbe.setBackground(null);
        this.btSchiff.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlMyPlayerListe = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btFarbe = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btSchiff = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btErstellen = new javax.swing.JButton();
        btLoeschen = new javax.swing.JButton();
        btBeenden = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btSpielStarten = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Spieler erstellen");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setLayout(new java.awt.GridLayout(3, 2));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Spieler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Old English Text MT", 1, 14))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane2.setViewportView(jlMyPlayerListe);

        jPanel1.add(jScrollPane2);

        jPanel7.add(jPanel1);

        jPanel3.setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 1, 18)); // NOI18N
        jLabel1.setText("Name");
        jPanel3.add(jLabel1);

        tfName.setFont(new java.awt.Font("Old English Text MT", 1, 18)); // NOI18N
        jPanel3.add(tfName);

        jLabel2.setFont(new java.awt.Font("Old English Text MT", 1, 18)); // NOI18N
        jLabel2.setText("Farbe");
        jPanel3.add(jLabel2);

        btFarbe.setBorder(null);
        btFarbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFarbeActionPerformed(evt);
            }
        });
        jPanel3.add(btFarbe);

        jLabel3.setFont(new java.awt.Font("Old English Text MT", 1, 18)); // NOI18N
        jLabel3.setText("Schiff");
        jPanel3.add(jLabel3);

        btSchiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSchiffActionPerformed(evt);
            }
        });
        jPanel3.add(btSchiff);

        jPanel7.add(jPanel3);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        btErstellen.setFont(new java.awt.Font("Old English Text MT", 1, 24)); // NOI18N
        btErstellen.setText("Erstellen");
        btErstellen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btErstellen.setContentAreaFilled(false);
        btErstellen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btErstellenActionPerformed(evt);
            }
        });
        jPanel4.add(btErstellen);

        btLoeschen.setFont(new java.awt.Font("Old English Text MT", 1, 24)); // NOI18N
        btLoeschen.setText("Löschen");
        btLoeschen.setToolTipText("");
        btLoeschen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btLoeschen.setContentAreaFilled(false);
        btLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoeschenActionPerformed(evt);
            }
        });
        jPanel4.add(btLoeschen);

        btBeenden.setFont(new java.awt.Font("Old English Text MT", 1, 24)); // NOI18N
        btBeenden.setText("Beenden");
        btBeenden.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btBeenden.setContentAreaFilled(false);
        btBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBeendenActionPerformed(evt);
            }
        });
        jPanel4.add(btBeenden);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        btSpielStarten.setFont(new java.awt.Font("Old English Text MT", 1, 24)); // NOI18N
        btSpielStarten.setText("Spiel starten");
        btSpielStarten.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btSpielStarten.setContentAreaFilled(false);
        btSpielStarten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSpielStartenActionPerformed(evt);
            }
        });
        jPanel5.add(btSpielStarten);

        jPanel2.add(jPanel5);

        jPanel7.add(jPanel2);

        getContentPane().add(jPanel7);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFarbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFarbeActionPerformed
        ColorChooserDlg cdlg = new ColorChooserDlg(this, true);
        cdlg.setVisible(true);
        if (cdlg.isC()) {
            c = cdlg.getC();
            this.btFarbe.setBackground(c);
        } else {
            System.out.println("Fehler bei der Farbübergabe!!!");
        }
    }//GEN-LAST:event_btFarbeActionPerformed

    private void btErstellenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btErstellenActionPerformed
        this.name = this.tfName.getText();
        if (c != null && (!name.equals("")) && ship != null) {
            if (lm.getSize() >= 2) {
                JOptionPane.showMessageDialog(this, "Maximal 2 Spieler (Ligth-Version)");
            } else {
                if (!lm.checkPlayer(name)) {
                    index = index + 1;
                    
                    if(index == 1)
                    {
                        // (String name, Color c, Image schiff, int leben, int munition, int index, Position p, String schiffArt, double currentAngle, EinheitsVektor direction, double speed, int rotation) 
                        p = new Player(this.name, c, ship, o.getLeben(), o.getMunition(), index, (new Position(0, 0)), shiffArt, 90, new EinheitsVektor(1, 0), o.getSpeed(), o.getRadius());
                    }
                    else
                    {
                        p = new Player(this.name, c, ship, o.getLeben(), o.getMunition(), index, (new Position(0, 0)), shiffArt, 270, new EinheitsVektor(-1, 0), o.getSpeed(),o.getRadius());
                    }
                    
                    

                    lm.addElement(p);
                    this.btSchiff.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Wähle einen anderen Spielernamen");
                }
            }
            clearAuswahl();
        } else {
            JOptionPane.showMessageDialog(this, "Bitte Name, Farbe und Schiff auswählen!");
        }

    }//GEN-LAST:event_btErstellenActionPerformed

    private void btSpielStartenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSpielStartenActionPerformed
        if (lm.getSize() == 2) {
            this.dispose();

            Player p1 = lm.getElementAt(0);
            Player p2 = lm.getElementAt(1);
            GameGUI gg = new GameGUI(p1, p2);

            gg.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Du musst 2 Spieler erstellen!");
        }
    }//GEN-LAST:event_btSpielStartenActionPerformed

    private void btBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBeendenActionPerformed
        dispose();
    }//GEN-LAST:event_btBeendenActionPerformed

    private void btLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoeschenActionPerformed
        try{
            if(lm.getSize() == 0) {
                JOptionPane.showMessageDialog(this, "Bitte Spieler zuerst erstellen");
            }
            else if (this.jlMyPlayerListe.getSelectedValue() != null) {
                lm.deleteElement(this.jlMyPlayerListe.getSelectedIndex());
            }
            else{
                JOptionPane.showMessageDialog(this, "Bitte Spieler zuerst auswählen um zu löschen");
            }
        }catch(IndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Bitte Spieler zuerst auswählen um zu löschen");
        }
        
    }//GEN-LAST:event_btLoeschenActionPerformed

    private void btSchiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSchiffActionPerformed
        ShipChooserDlg scdlg = new ShipChooserDlg(this, true);
        scdlg.setVisible(true);

        if (scdlg.issok()) {
            ship = scdlg.getSelectedShip();
            shiffArt = scdlg.getshipName();
            this.btSchiff.setText(shiffArt);
        }
    }//GEN-LAST:event_btSchiffActionPerformed

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
            java.util.logging.Logger.getLogger(NewPlayerDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPlayerDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPlayerDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPlayerDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewPlayerDlg dialog = new NewPlayerDlg(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBeenden;
    private javax.swing.JButton btErstellen;
    private javax.swing.JButton btFarbe;
    private javax.swing.JButton btLoeschen;
    private javax.swing.JButton btSchiff;
    private javax.swing.JButton btSpielStarten;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JList<String> jlMyPlayerListe;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
