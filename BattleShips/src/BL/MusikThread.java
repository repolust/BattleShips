/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author Michael
 * Erstellt am 19.6.2018
 */
public class MusikThread extends Thread{

        private String path;

    public MusikThread(String path) {
        this.path = path;
    }
        
    
    @Override
    public void run() {
       
        MP3Player mp3 = new MP3Player(path);
        mp3.play();
 
    }
    
}
