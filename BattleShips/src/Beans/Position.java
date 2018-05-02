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
<<<<<<< HEAD:BattleShips/src/BL/Position.java
    private double x;
    private double y;

    public Position(double x, double y)
=======

    private double positionx;
    private double positiony;

    public Position(double positionx, double positiony)
>>>>>>> BattleShips:BattleShips/src/Beans/Position.java
    {
        this.positionx = positionx;
        this.positiony = positiony;
    }

<<<<<<< HEAD:BattleShips/src/BL/Position.java
    public void increaseX(double value)
=======
    public double getPositionx()
>>>>>>> BattleShips:BattleShips/src/Beans/Position.java
    {
        return positionx;
    }
<<<<<<< HEAD:BattleShips/src/BL/Position.java
    public void increaseY(double value)
=======

    public void setPositionx(double positionx)
>>>>>>> BattleShips:BattleShips/src/Beans/Position.java
    {
        this.positionx = positionx;
    }
<<<<<<< HEAD:BattleShips/src/BL/Position.java
    public double getX()
=======

    public double getPositiony()
>>>>>>> BattleShips:BattleShips/src/Beans/Position.java
    {
        return positiony;
    }
    
    public int getXint()
    {
        return (int)Math.round(x);
    }

<<<<<<< HEAD:BattleShips/src/BL/Position.java
    public void setX(double x)
=======
    public void setPositiony(double positiony)
>>>>>>> BattleShips:BattleShips/src/Beans/Position.java
    {
        this.positiony = positiony;
    }

<<<<<<< HEAD:BattleShips/src/BL/Position.java
    public double getY()
=======
    public void increasePositionxBy(double positionx)
>>>>>>> BattleShips:BattleShips/src/Beans/Position.java
    {
        this.positionx += positionx;
    }

<<<<<<< HEAD:BattleShips/src/BL/Position.java
    public int getYint()
    {
        return (int)Math.round(y);
    }
        
    public void setY(double y)
=======
    public void increasePositionyBy(double positiony)
>>>>>>> BattleShips:BattleShips/src/Beans/Position.java
    {
        this.positiony += positiony;
    }

    @Override
    public String toString()
    {
        return "Position{" + "positionx=" + positionx + ", positiony=" + positiony + '}';
    }

}
