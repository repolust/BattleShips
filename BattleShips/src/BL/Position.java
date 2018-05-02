/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author michi
 */
public class Position
{
    private double x;
    private double y;

    public Position(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void increaseX(double value)
    {
        x += value;
    }
    public void increaseY(double value)
    {
        y += value;
    }
    public double getX()
    {
        return x;
    }
    
    public int getXint()
    {
        return (int)Math.round(x);
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public int getYint()
    {
        return (int)Math.round(y);
    }
        
    public void setY(double y)
    {
        this.y = y;
    }
    
    
            
            
}
