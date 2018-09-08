/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Gui.JuegoTerminadoDialog;
import Gui.PlayersPanel;
import Gui.PrincipalFrame;
import buscaminasobjects.BuscaminasMp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import objects.Coordenada;
import objects.GameEst;
import objects.Jugador;

/**
 *
 * @author House
 */
public class Receptor extends Thread{
    private Jugador enemy;
    private BuscaminasMp buscaminas;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private PrincipalFrame parent;
    public Receptor(Jugador player, BuscaminasMp buscaminas, 
            ObjectInputStream reader, ObjectOutputStream writer, PrincipalFrame parent) throws IOException {
        this.buscaminas = buscaminas;
        this.parent = parent;
        this.enemy = null;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
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
            Jugador enemigo = (Jugador)reader.readObject();
            enemy = enemigo;
            parent.getJugadorEnemigo().setNombre(enemigo.getNombre()); 
            parent.getPnlJugadores().getPnlJugadorEnemigo().getLblNombre().setText(enemigo.getNombre());
            if(parent.getIsMyTurn()){
            parent.getPnlJugadores().getPnlJugadorPrincipal().getLblTurno().setText("- Tu turno");
            parent.getPnlJugadores().getPnlJugadorEnemigo().getLblTurno().setText("- Esperando...");
        }else{
            parent.getPnlJugadores().getPnlJugadorPrincipal().getLblTurno().setText("- Espera...");
            parent.getPnlJugadores().getPnlJugadorEnemigo().getLblTurno().setText("- Jugando...");
        }
            parent.repaint();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            try {
                System.out.println("ME ESTOY EJECUTANDO, esperando a leer!!!");
                Boolean turno = (Boolean)reader.readObject();
                System.out.println("LEÍ BOOLEANO: "+turno.toString());
                Coordenada cord = (Coordenada)reader.readObject();
                
                System.out.println("Recibí jugador enemigo y su puntuación ES: "+cord.getPlayer().getPuntaje());
                buscaminas.abrirCelda(cord.getX(), cord.getY(), cord.getPlayer());
                 if (buscaminas.getBlueFlagCount() > 25 || buscaminas.getRedFlagCount() > 25
                                && buscaminas.getJuego() != GameEst.TERMINADO) {
                            System.out.println("JUEZ DETECTO JUEGO FINALIZADO");
                            buscaminas.setJuego(GameEst.TERMINADO);
                             parent.terminarJuego();
                            JuegoTerminadoDialog terminado = new JuegoTerminadoDialog(parent, writer, reader);
                            buscaminas.setJuego(GameEst.JUGANDO);
                        }
                parent.updateMinas();
                parent.updatePuntuaciones();
                parent.setIsMyTurn(turno);
                if(turno == true){
                    parent.getPnlJugadores().getPnlJugadorEnemigo().getLblTurno().setText("Esperando...");
                    parent.getPnlJugadores().getPnlJugadorPrincipal().getLblTurno().setText("- Tu turno");
                }else{
                    parent.getPnlJugadores().getPnlJugadorEnemigo().getLblTurno().setText("- Jugando...");
                }
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

    public Jugador getEnemy() {
        return enemy;
    }

    public void setEnemy(Jugador enemy) {
        this.enemy = enemy;
    }
    
}
