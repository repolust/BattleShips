/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Michael
 */
public class Treffer {
    
    private int playernummer;
    private int kugelIndex;

    public Treffer(int playernummer, int kugelIndex) {
        this.playernummer = playernummer;
        this.kugelIndex = kugelIndex;
    }

    public int getPlayernummer() {
        return playernummer;
    }

    public void setPlayernummer(int playernummer) {
        this.playernummer = playernummer;
    }

    public int getKugelIndex() {
        return kugelIndex;
    }

    public void setKugelIndex(int kugelIndex) {
        this.kugelIndex = kugelIndex;
    }
    
    
}
