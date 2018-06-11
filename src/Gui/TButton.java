/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import objects.Celda;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author House
 */
public class TButton extends JButton{
    
    private Celda celda;
    private Integer xx;
    private Integer yy;
    
    public TButton(String path){
        super();
        cargarIcono(path);
}
    public TButton(Celda celda, Integer xx, Integer yy){
        this.celda = celda;
        this.xx = xx;
        this.yy = yy;
        switch(celda.getEstado()){
            /*
                CERRADO,
    ABIERTO,
    INTERROGACION,
    MINA,
    BOOM,
    BANDERA,
    BANDERAMALA;
            */
           
            case INTERROGACION:
                this.cargarIcono("/images/interrogacion.png");
                break;
            case BANDERA:
                this.cargarIcono("/images/bandera.png");
        }
    }
    private void cargarIcono(String path){
                URL url = System.class.getResource(path);
        ImageIcon im = new ImageIcon(url);
        super.setIcon(im);
    }

    /**
     * @return the xx
     */
    public Integer getXx() {
        return xx;
    }

    /**
     * @param xx the xx to set
     */
    public void setXx(Integer xx) {
        this.xx = xx;
    }

    /**
     * @return the yy
     */
    public Integer getYy() {
        return yy;
    }

    /**
     * @param yy the yy to set
     */
    public void setYy(Integer yy) {
        this.yy = yy;
    }
}
