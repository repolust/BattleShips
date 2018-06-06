/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Beans.Kugel;
import Beans.Player;
import java.awt.Color;
import java.util.LinkedList;

/**
 *
 * @author tobia
 */
public class CheckIfHit
{
    LinkedList<Kugel> kugeln = new LinkedList<Kugel>();
    Player p1, p2;

    public CheckIfHit(Player p1, Player p2, LinkedList<Kugel> list)
    {
        this.p1 = p1;
        this.p2 = p2;
        kugeln = list;
    }

    public boolean checkIfHit()
    {
     if (p1.getSchiff().get  (int) position.getPositionx() + ((int) (direction.x * controllOffset)), (int) position.getPositiony() + ((int) (direction.y * controllOffset))) != Color.black.getRGB()) {
      
    }
    
    
    
       
    
    
        
    
    
       
    
    
    
    
}

    
}
