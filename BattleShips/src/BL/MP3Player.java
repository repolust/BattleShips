/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class MP3Player {

    private String filename;
    private Player player;

    public MP3Player(String filename) {
        this.filename = filename;
    }

    public void play() {
        try {
            BufferedInputStream buffer = new BufferedInputStream(
                    new FileInputStream(filename));
            player = new Player(buffer);
            player.play();
        } catch (Exception e) {

            System.out.println(e);
        }

    }
//
//    public static void main(String[] args) {
//        MP3Player mp3 = new MP3Player("song.mp3");
//        mp3.play();
//
//    }

}
