/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author michi
 */
public class Controlls
{

    private Set<Integer> keysP1 = new HashSet<>();

    public Controlls()
    {

    }

    public void addKey(int keycode)
    {
        if (!keysP1.contains(keycode))
        {
            keysP1.add(keycode);
        }

    }

    public void removeKey(int keycode)
    {
        if (keysP1.contains(keycode))
        {
            keysP1.remove(keycode);

        }

    }

    public int getSize()
    {
        return keysP1.size();
    }

    public boolean containsKey(int keyCode)
    {
        return keysP1.contains(keyCode);
    }
}
