/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Beans.Player;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Leonardo
 * Erstellt am 23.4.2018
 */
public class ListModel extends AbstractListModel{// Listemodel für den NewPlayerDialog

    private LinkedList<Player> liste = new LinkedList<Player>();
    
    @Override
    public int getSize() {
        return liste.size();
    }

    @Override
    public Player getElementAt(int i) {
        return liste.get(i);
    }
    
    public void addElement(Player p){
        liste.add(p);
        super.fireContentsChanged(liste, 0, liste.size()-1);
    }
    
    public void deleteElement(int index){
        liste.remove(index);
        super.fireContentsChanged(liste, 0, liste.size()-1);
    }
    
    public boolean checkPlayer(String name){
        for(Player p: liste){
            if(p.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
}
