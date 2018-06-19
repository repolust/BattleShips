/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Michael und Tobias
 * Erstellt am 23.4.2018
 */
public class Controlls //Liste mit gerade gedrückten Tasten
{

    private Set<Integer> keys = new HashSet<>();

    public Controlls()
    {

    }

    public void addKey(int keycode)
    {
        if (!keys.contains(keycode))
        {
            keys.add(keycode);
        }

    }

    public void removeKey(int keycode)
    {
        if (keys.contains(keycode))
        {
            keys.remove(keycode);

        }

    }

    public int getSize()
    {
        return keys.size();
    }

    public boolean containsKey(int keyCode)
    {
        return keys.contains(keyCode);
    }
}
