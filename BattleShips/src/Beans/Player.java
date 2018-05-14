/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Beans.Position;
import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author Leonardo
 */
public class Player {
    private String name;
    private Color c;
    private Image schiff;
    private int leben;
    private int munition;
    private int punkte;
    private int index;
    private Position p;

    public Player(String name, Color c, Position p, Image schiff, int index) {
        this.name = name;
        this.c = c;
        this.p = p;
        this.schiff = schiff;
        this.leben = 100;
        this.munition = 100;
        this.punkte = 0;
        this.index=index;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    
    @Override
    public String toString() {
        return "Player"+index+" | "+"Name: "+name;
    }
    
    
    
}
