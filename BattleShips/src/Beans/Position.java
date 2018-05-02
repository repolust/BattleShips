/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author tobia
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

    public double getX()
    {
        return x;
    }

    public int getXInt()
    {
        return (int) Math.round(x);
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public int getYInt()
    {
        return (int) Math.round(y);
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public void increaseX(double x)
    {
        this.x += x;
    }

    public void increaseY(double y)
    {
        this.y += y;
    }

    @Override
    public String toString()
    {
        return "Position{" + "positionx=" + x + ", positiony=" + y + '}';
    }

}
