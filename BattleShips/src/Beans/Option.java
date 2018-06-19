/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Michael
 */
public class Option {//Option-Klasse die die Werte für den Start des Spiels beinhaltet
    
    private int leben,munition,speed ,radius;

    public Option(int leben, int munition, int speed, int radius) {
        this.leben = leben;
        this.munition = munition;
        this.speed = speed;
        this.radius = radius;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public int getMunition() {
        return munition;
    }

    public void setMunition(int munition) {
        this.munition = munition;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
}
