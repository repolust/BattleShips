/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
public class StartMenuBL extends JPanel {
    
    private int breite;
    private int hoehe;
    
    private final String imagePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "SettingsGUIBild.jpg";
    private Image ship;
    
    @Override
    public void paint(Graphics g) {
        
        breite = getWidth();
        hoehe = getHeight();
        try {
            ship = ImageIO.read(new File(imagePath));
            g.drawImage(ship, 0, 0, this);
        } catch (IOException ex) {
            Logger.getLogger(StartMenuBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        g.setColor(Color.BLUE);
        g.setFont(new Font("Serif",Font.BOLD,100));
        g.drawString("Starten", 500, 100);
        
        g.drawString("Beenden", 500, 200);
    }
    
}
