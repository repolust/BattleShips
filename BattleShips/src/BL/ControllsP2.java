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
public class ControllsP2
{

    private Set<Integer> keysP2 = new HashSet<>();

    public ControllsP2()
    {

    }

    public void addKey(int keycode)
    {
        if (!keysP2.contains(keycode))
        {
            keysP2.add(keycode);
        }

    }

    public void removeKey(int keycode)
    {
        if (keysP2.contains(keycode))
        {
            keysP2.remove(keycode);

        }

    }

    public int getSize()
    {
        return keysP2.size();
    }

    public boolean containsKey(int keyCode)
    {
        return keysP2.contains(keyCode);
    }
}
