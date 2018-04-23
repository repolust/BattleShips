/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.LinkedList;

/**
 *
 * @author michi
 */
public class Controlls
{
    private LinkedList<Integer> keys = new LinkedList();

    public Controlls()
    {
        
    }
    
    public void addKey(int keycode)
    {
        keys.add(keycode);
    }
    
    public void removeKey(int keycode)
    {
        keys.remove(keycode);
    }
    
    public boolean containsKey(int keyCode) {
        return keys.contains(keyCode);
    }
}
