/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Gui.JuegoTerminadoDialog;
import Gui.PrincipalFrame;
import buscaminasobjects.BuscaminasMp;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import objects.GameEst;

/**
 *
 * @author House
 */
public class Juez extends Thread{
    private BuscaminasMp buscaminas;
    private PrincipalFrame ventana;
    private ObjectOutputStream writer;
    private ObjectInputStream reader;
    public Juez(PrincipalFrame ventana, BuscaminasMp buscaminas, ObjectOutputStream writer,
     ObjectInputStream reader){
        this.writer = writer;
        this.reader = reader;
        this.ventana = ventana;
        this.buscaminas = buscaminas;
    }

    @Override
    public void run() {
        while(true){
            if(buscaminas.getBlueFlagCount()>25 || buscaminas.getRedFlagCount()>25
                    && buscaminas.getJuego() != GameEst.TERMINADO ){
                System.out.println("JUEZ DETECTO JUEGO FINALIZADO");
                buscaminas.setJuego(GameEst.TERMINADO);
                
                ventana.terminarJuego();
                JuegoTerminadoDialog terminado = new JuegoTerminadoDialog(ventana, writer, reader);
                buscaminas.setJuego(GameEst.JUGANDO);
            }
        }
    }

    public BuscaminasMp getBuscaminas() {
        return buscaminas;
    }

    public void setBuscaminas(BuscaminasMp buscaminas) {
        this.buscaminas = buscaminas;
    }

    public PrincipalFrame getVentana() {
        return ventana;
    }

    public void setVentana(PrincipalFrame ventana) {
        this.ventana = ventana;
    }

    public ObjectOutputStream getWriter() {
        return writer;
    }

    public void setWriter(ObjectOutputStream writer) {
        this.writer = writer;
    }

    public ObjectInputStream getReader() {
        return reader;
    }

    public void setReader(ObjectInputStream reader) {
        this.reader = reader;
    }
    
}
