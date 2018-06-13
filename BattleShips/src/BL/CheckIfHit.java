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

    public void checkIfHit()
    {
        //size vom schiff berechnen

        boolean xIf = false;
        boolean yIf = false;
        Position pos1_1 = new Position(0, 0);
        Position pos1_2 = new Position(0, 0);
        pos1_1 = schiffListe.get(0).getP(); //links obn
        pos1_2 = schiffListe.get(0).getP();
        EinheitsVektor einh = schiffListe.get(0).getDirection();
        einh = einh.rotateEinheitsVektorRueckgabe(+90);
        pos1_2.increaseX(einh.getX() + schiffListe.get(0).getWidth());
        einh = einh.rotateEinheitsVektorRueckgabe(+90);
        pos1_2.increaseY(einh.getY() - schiffListe.get(0).getHeight());//rechts untn

        for (int i = 0; i < kugelListe.size(); i++)
        {

            if (pos1_1.getX() < pos1_2.getX())
            {
                if (pos1_1.getX() < kugelListe.get(i).getPos().getX() && kugelListe.get(i).getPos().getX() < pos1_2.getX())
                {
                    xIf = true;
                    if (pos1_1.getY() < pos1_2.getY())
                    {
                        if (pos1_1.getY() < kugelListe.get(i).getPos().getY() && kugelListe.get(i).getPos().getY() < pos1_2.getY())
                        {
                            yIf = true;
                        }
                    }

                    if (pos1_1.getY() > pos1_2.getY())
                    {
                        if (pos1_1.getY() > kugelListe.get(i).getPos().getY() && kugelListe.get(i).getPos().getY() > pos1_2.getY())
                        {
                            yIf = true;
                        }
                    }
                }

            }

            if (pos1_1.getX() > pos1_2.getX())
            {
                if (pos1_1.getX() > kugelListe.get(i).getPos().getX() && kugelListe.get(i).getPos().getX() > pos1_2.getX())
                {
                    xIf = true;
                    if (pos1_1.getY() < pos1_2.getY())
                    {
                        if (pos1_1.getY() < kugelListe.get(i).getPos().getY() && kugelListe.get(i).getPos().getY() < pos1_2.getY())
                        {
                            yIf = true;
                        }
                    }

                    if (pos1_1.getY() > pos1_2.getY())
                    {
                        if (pos1_1.getY() > kugelListe.get(i).getPos().getY() && kugelListe.get(i).getPos().getY() > pos1_2.getY())
                        {
                            yIf = true;
                        }
                    }
                }
            }
        }

        if (xIf && yIf)
        {
            JOptionPane.showMessageDialog(null, "hit");
        }

        //wenn die pos von der kugel im bereich des schiffs ist -> treffer
        //if treffer -> kugel löschen und leben abziehen
    }
}
