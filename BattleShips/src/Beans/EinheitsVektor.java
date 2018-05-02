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
public class EinheitsVektor extends Vektor{
    
    public EinheitsVektor(double x, double y) {
        super(x, y);
        makeVektorToEinheitsVektor();
    }
    
    
    public void makeVektorToEinheitsVektor(){
        double hx = x;
        double hy = y;
        
        x = (1/Math.sqrt(Math.pow(hx, 2) + Math.pow(hy, 2)))*hx;
        y = (1/Math.sqrt(Math.pow(hx, 2) + Math.pow(hy, 2)))*hy;
    }
    public void addEinheitsVektor(EinheitsVektor v){
        x+=v.x;
        y+=v.y;
        makeVektorToEinheitsVektor();
        
    }

    @Override
    public String toString() {
        return "EinheitsVektor{" + x + ";" + y + '}';
    }
    public void rotateEinheitsVektor(double degree){
        double hx = x;
        double hy = y;
        
        x = Math.cos(Math.toRadians(degree))*hx - Math.sin(Math.toRadians(degree))*hy;
        y = Math.sin(Math.toRadians(degree))*hx + Math.cos(Math.toRadians(degree))*hy;
    }
    public EinheitsVektor rotateEinheitsVektorRueckgabe(double degree){
        double hx = x;
        double hy = y;
        return new EinheitsVektor(Math.cos(Math.toRadians(degree))*hx - Math.sin(Math.toRadians(degree))*hy, Math.sin(Math.toRadians(degree))*hx + Math.cos(Math.toRadians(degree))*hy);
        
    }
    
    
}
