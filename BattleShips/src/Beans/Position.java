/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author michi
 */
public class Position
{

    private double positionx;
    private double positiony;

    public Position(double positionx, double positiony)
    {
        this.positionx = positionx;
        this.positiony = positiony;
    }

    public double getPositionx()
    {
        return positionx;
    }

    public void setPositionx(double positionx)
    {
        this.positionx = positionx;
    }

    public double getPositiony()
    {
        return positiony;
    }

    public void setPositiony(double positiony)
    {
        this.positiony = positiony;
    }

    public void increasePositionxBy(double positionx)
    {
        this.positionx += positionx;
    }

    public void increasePositionyBy(double positiony)
    {
        this.positiony += positiony;
    }

    @Override
    public String toString()
    {
        return "Position{" + "positionx=" + positionx + ", positiony=" + positiony + '}';
    }

}
