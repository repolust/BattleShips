/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Leonardo
 */
public class Kugel {
    private EinheitsVektor einheintsVektor;
    private Position pos;
    private int groesse;
    private int playernumber;

    public Kugel(EinheitsVektor einheintsVektor, Position pos, int groesse, int playernumber) {
        this.einheintsVektor = einheintsVektor;
        this.pos = pos;
        this.groesse = groesse;
        this.playernumber = playernumber;
    }

    public int getPlayernumber() {
        return playernumber;
    }

    public EinheitsVektor getEinheintsVektor() {
        return einheintsVektor;
    }

    public void setEinheintsVektor(EinheitsVektor einheintsVektor) {
        this.einheintsVektor = einheintsVektor;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }
    
}
