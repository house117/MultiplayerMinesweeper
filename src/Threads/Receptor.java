/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Gui.PrincipalFrame;
import buscaminasobjects.BuscaminasMp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.Coordenada;
import objects.Equipo;
import objects.GameEst;
import objects.Jugador;

/**
 *
 * @author House
 */
public class Receptor extends Thread{
    //private Jugador player;
    private BuscaminasMp buscaminas;
    private ObjectInputStream reader;
    private PrincipalFrame parent;
    public Receptor(Jugador player, BuscaminasMp buscaminas, 
            ObjectInputStream reader, PrincipalFrame parent) throws IOException {
        this.buscaminas = buscaminas;
        this.parent = parent;
        
        this.reader = reader;
    }

    @Override
    public void run() {
        /*try {
            String nombre = (String) reader.readObject();
            parent.getJugadorEnemigo().setNombre(nombre);
            switch(parent.getJugador().getEquipo()){
                case EquipoAzul:
                    parent.getJugadorEnemigo().setEquipo(Equipo.EquipoRojo);
                    break;
                case EquipoRojo:
                    parent.getJugadorEnemigo().setEquipo(Equipo.EquipoAzul);
                    break;
                        
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        while(true){
            try {
                System.out.println("ME ESTOY EJECUTANDO, esperando a leer!!!");
                Boolean turno = (Boolean)reader.readObject();
                System.out.println("LEÍ BOOLEANO: "+turno.toString());
                Coordenada cord = (Coordenada)reader.readObject();
                buscaminas.abrirCelda(cord.getX(), cord.getY(), cord.getPlayer());
                parent.setIsMyTurn(turno);
                parent.getPnlTablero().removeAll();
                parent.getPnlTablero().drawTablero(buscaminas);
                parent.repaint();
            } catch (IOException ex) {
                Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
