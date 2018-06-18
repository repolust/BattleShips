/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Beans.EinheitsVektor;
import Beans.Kugel;
import Beans.Player;
import Beans.Position;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author tobia
 */
public class CheckIfHit
{

    private LinkedList<Kugel> kugelListe = new LinkedList<Kugel>();
    private LinkedList<Player> schiffListe = new LinkedList<Player>();

    public CheckIfHit(LinkedList<Kugel> kugeln, LinkedList<Player> schiffe)
    {
        kugelListe = kugeln;
        schiffListe = schiffe;

    }
    public void checkIfHit2()
    {
         //size vom schiff berechnen

//        boolean xIf = false;
//        boolean yIf = false;
//        Position pos1_1 = new Position(schiffListe.get(0).getP().getX(), schiffListe.get(0).getP().getY());
//        Position pos1_2 = new Position(schiffListe.get(1).getP().getX(), schiffListe.get(1).getP().getY());
//        
//        EinheitsVektor einh = new EinheitsVektor(schiffListe.get(0).getDirection().getX(), schiffListe.get(0).getDirection().getY());
//        einh = einh.rotateEinheitsVektorRueckgabe(+90);
//        pos1_2.increaseX(einh.getX() + schiffListe.get(0).getWidth());
//        einh = einh.rotateEinheitsVektorRueckgabe(+90);
//        pos1_2.increaseY(einh.getY() - schiffListe.get(0).getHeight());//rechts untn
        
        Player p1 = schiffListe.get(0);
        Player p2 = schiffListe.get(1);
        
        Rectangle hitbox1 = null;
        Rectangle hitbox2 = null;
//        Rectangle r = new Rectangle(20, 20);
//        r.in

       //-----------Hitbox-------
             
            
            if((p1.getCurrentAngle() > 45 && p1.getCurrentAngle() < 135 || p1.getCurrentAngle() > 225 && p1.getCurrentAngle() < 315) || (p1.getCurrentAngle() < -45 && p1.getCurrentAngle() > -135 || p1.getCurrentAngle() < -225 && p1.getCurrentAngle() > -315))
            {
               hitbox1 = new Rectangle(p1.getP().getXInt() -(p1.getWidth()/4), p1.getP().getYInt()+(p1.getWidth()/4), p1.getHeight(), p1.getWidth()); 
            }
            else
            {
                hitbox1 = new Rectangle(p1.getP().getXInt(), p1.getP().getYInt(), p1.getWidth(), p1.getHeight());
            }
            
            if((p2.getCurrentAngle() > 45 && p2.getCurrentAngle() < 135 || p2.getCurrentAngle() > 225 && p2.getCurrentAngle() < 315) || (p2.getCurrentAngle() < -45 && p2.getCurrentAngle() > -135 || p2.getCurrentAngle() < -225 && p2.getCurrentAngle() > -315))
            {
               hitbox2 = new Rectangle(p2.getP().getXInt() -(p2.getWidth()/4), p2.getP().getYInt()+(p1.getWidth()/4), p2.getHeight(), p2.getWidth()); 
            }
            else
            {
                hitbox2 = new Rectangle(p2.getP().getXInt(), p2.getP().getYInt(), p2.getWidth(), p2.getHeight());
            }
            //-----------/Hitbox-------
        
            
            if(hitbox1.intersects(hitbox2))
            {
                JOptionPane.showMessageDialog(null, "RIP");
            }
    }

//    public void checkIfHit()
//    {
//        //size vom schiff berechnen
//
//        boolean xIf = false;
//        boolean yIf = false;
//        Position pos1_1 = new Position(schiffListe.get(0).getP().getX(), schiffListe.get(0).getP().getY());
//        Position pos1_2 = new Position(schiffListe.get(1).getP().getX(), schiffListe.get(1).getP().getY());
////        EinheitsVektor einh = new EinheitsVektor(schiffListe.get(0).getDirection().getX(), schiffListe.get(0).getDirection().getY());
////        einh = einh.rotateEinheitsVektorRueckgabe(+90);
////        pos1_2.increaseX(einh.getX() + schiffListe.get(0).getWidth());
////        einh = einh.rotateEinheitsVektorRueckgabe(+90);
////        pos1_2.increaseY(einh.getY() - schiffListe.get(0).getHeight());//rechts untn
//
//        for (Kugel k: kugelListe)
//        {
//            if (pos1_1.getX() < pos1_2.getX())
//            {
//                if (pos1_1.getX() < k.getPos().getX() && k.getPos().getX() < pos1_2.getX())
//                {
//                    xIf = true;
//                    if (pos1_1.getY() < pos1_2.getY())
//                    {
//                        if (pos1_1.getY() < k.getPos().getY() && k.getPos().getY() < pos1_2.getY())
//                        {
//                            yIf = true;
//                        }
//                    }
//
//                    if (pos1_1.getY() > pos1_2.getY())
//                    {
//                        if (pos1_1.getY() > k.getPos().getY() && k.getPos().getY() > pos1_2.getY())
//                        {
//                            yIf = true;
//                        }
//                    }
//                }
//
//            }
//
//            if (pos1_1.getX() > pos1_2.getX())
//            {
//                if (pos1_1.getX() > k.getPos().getX() && k.getPos().getX() > pos1_2.getX())
//                {
//                    xIf = true;
//                    if (pos1_1.getY() < pos1_2.getY())
//                    {
//                        if (pos1_1.getY() < k.getPos().getY() && k.getPos().getY() < pos1_2.getY())
//                        {
//                            yIf = true;
//                        }
//                    }
//
//                    if (pos1_1.getY() > pos1_2.getY())
//                    {
//                        if (pos1_1.getY() > k.getPos().getY() && k.getPos().getY() > pos1_2.getY())
//                        {
//                            yIf = true;
//                        }
//                    }
//                }
//            }
//        }
//
//        if (xIf && yIf)
//        {
//            JOptionPane.showMessageDialog(null, "hit");
//        }
//
////        wenn die pos von der kugel im bereich des schiffs ist -> treffer
////        if treffer -> kugel löschen und leben abziehen
//    
//
//    }
    
}
