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
public class Vektor
{

    protected double x;
    protected double y;

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public Vektor(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void printVektor()
    {
        System.out.println("x = " + x + "\ny = " + y);
    }

    public void addVektor(Vektor v)
    {
        x += v.x;
        y += v.y;
    }
}
