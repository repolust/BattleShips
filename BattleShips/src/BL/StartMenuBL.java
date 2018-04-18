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

    private final String pathBackground = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "SettingsGUIBild.jpg";
    private final String pathPlay = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "playButton.png";
    private final String pathX = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "bilder"
            + File.separator + "xButton.png";

    private Image background;
    private Image play;
    private Image x;

    @Override
    public void paint(Graphics g) {

        breite = getWidth();
        hoehe = getHeight();
        try {
            background = ImageIO.read(new File(pathBackground));
            g.drawImage(background, 0, 0, this);
            play = ImageIO.read(new File(pathPlay));
            g.drawImage(play, 470, 100, 100, 100, this);
            x = ImageIO.read(new File(pathX));
            g.drawImage(x, 610, 100, 100, 100, this);
        } catch (IOException ex) {
            Logger.getLogger(StartMenuBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
