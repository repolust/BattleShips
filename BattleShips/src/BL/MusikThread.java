/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.File;

/**
 *
 * @author michi
 */
public class MusikThread extends Thread{

        private final String soundPath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "sound"
            + File.separator + "meer.mp3";
    
    @Override
    public void run() {
       
        MP3Player mp3 = new MP3Player(soundPath);
        mp3.play();
    }
    
    
}
