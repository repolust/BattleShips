/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author Leonardo
 */
public class Player {
    private String name;
    private Color c;
    private int xPos,yPos;
    private Image schiff;
    private int leben;
    private int munition;
    private int punkte;

    public Player(String name, Color c, int xPos, int yPos, Image schiff) {
        this.name = name;
        this.c = c;
        this.xPos = xPos;
        this.yPos = yPos;
        this.schiff = schiff;
        this.leben = 5;
        this.munition = 100;
        this.punkte = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Image getSchiff() {
        return schiff;
    }

    public void setSchiff(Image schiff) {
        this.schiff = schiff;
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

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    @Override
    public String toString() {
        return "Name: "+name+" | Farbe: "+c.toString();
    }
    
    
    
}
