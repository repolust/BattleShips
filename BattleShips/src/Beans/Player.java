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
    private String schiffArt;
    private double currentAngle;
    private EinheitsVektor direction;
    private double speed;

    public Player(String name, Color c, Image schiff, int leben, int munition, int punkte, int index, Position p, String schiffArt, double currentAngle, EinheitsVektor direction, double speed) {
        this.name = name;
        this.c = c;
        this.schiff = schiff;
        this.leben = leben;
        this.munition = munition;
        this.punkte = punkte;
        this.index = index;
        this.p = p;
        this.schiffArt = schiffArt;
        this.currentAngle = currentAngle;
        this.direction = direction;
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public EinheitsVektor getDirection() {
        return direction;
    }

    public void setDirection(EinheitsVektor direction) {
        this.direction = direction;
    }

    public String getSchiffArt() {
        return schiffArt;
    }

    public void setSchiffArt(String schiffArt) {
        this.schiffArt = schiffArt;
    }

    public double getCurrentAngle() {
        return currentAngle;
    }

    public void setCurrentAngle(double currentAngle) {
        this.currentAngle = currentAngle;
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
        return "Player"+index+" | "+"Name: "+name+" | "+schiffArt;
    }
    
    
    
}
