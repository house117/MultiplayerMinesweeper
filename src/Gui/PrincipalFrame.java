/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import buscaminasobjects.BuscaminasMp;
import Gui.listener.TableroListener;
import Threads.Receptor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import objects.Equipo;
import objects.GameEst;
import objects.Jugador;

/**
 *
 * @author House
 */
public class PrincipalFrame extends JFrame{
    private BuscaminasMp buscaminas;
    private TableroPanel pnlTablero;
    private PlayersPanel pnlJugadores;
    private Socket socket;
    private Jugador jugador;
    private Jugador jugadorEnemigo;
    private Boolean isMyTurn;
    ObjectOutputStream writer;
    ObjectInputStream reader;
    Receptor receptor;
    public PrincipalFrame(String nombre) throws IOException, ClassNotFoundException{
        super(nombre);
        super.setLayout(new FlowLayout(FlowLayout.LEFT));
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(new Dimension(700, 520));
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setBackground(Color.black);
        socket = new Socket("localhost", 1235);
        
        writer = new ObjectOutputStream(socket.getOutputStream());
        writer.writeObject(nombre);
        
        reader = new ObjectInputStream(socket.getInputStream());
        
        jugador = (Jugador)reader.readObject();
        System.out.println("leyo al jugador: "+jugador.getEquipo());
        isMyTurn = (Boolean)reader.readObject();
        System.out.println("BOOLEANO ES:"+isMyTurn.toString());
        
        
        
        
        //juego
        this.buscaminas = (BuscaminasMp)reader.readObject();
        
        
        //JUGADORES
        
        
        //PANEL JUGADORES
        pnlJugadores = new PlayersPanel(this.jugador, this.jugador);
        pnlJugadores.setPreferredSize(new Dimension(200,480));
        //PANEL TABLERO
        pnlTablero = new TableroPanel(new ImageIcon("fondo.png"));
        pnlTablero.setPreferredSize(new Dimension(480, 480));
        pnlTablero.drawTablero(this.buscaminas);
        pnlTablero.setListener(new TableroListener() {
            @Override
            public void btnCasillaOnClick(Integer x, Integer y) {
                if (getIsMyTurn()) {
                    System.out.printf("hicieron click en [%d][%d]", x, y);
                    try {
                        setIsMyTurn(buscaminas.abrirCelda(x, y, getJugador(), writer));
                        if (buscaminas.getEstado() == GameEst.JUGANDO) {
                            getPnlTablero().removeAll();
                            getPnlTablero().drawTablero(buscaminas);
                            PrincipalFrame.this.repaint();
                        } else {
                            System.out.println(buscaminas.getEstado());
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else{
                    System.out.println("NO ES TU TURNO!!!");
                }
                //AGREGAR CONDICIONES SI GANAS O PIERDES!!!!!
                //AGREGAR NIVELES DE DIFICULTAD
                //AGREGAR VENTANA RESIZABLE FALSE Y QUE SE REDIMENSIONE
                //DE ACUERDO A LA DIFICULTAD, QUE EL BOTON CAMBIE DE CARITA FELIZ A TRISTE.
                //O SI GANAS QUE SE PONGA LOS LENTES!!!
                
            }
            @Override
            public void onRightClickButton(Integer x, Integer y) {
                if (getIsMyTurn()) {
                    System.out.printf("hicieron click en [%d][%d]", x, y);
                    buscaminas.marcarCelda(x, y);
                    getPnlTablero().removeAll();
                    getPnlTablero().drawTablero(buscaminas);
                    PrincipalFrame.this.repaint();
                    /*
               
               SI GANO O PERDIO, EL CAMBIO DEL ICONITO, LENTES O MUERTO
                     */
                }

            }
        });
        super.add(pnlJugadores);
        super.add(pnlTablero);
        receptor = new Receptor(getJugador(), this.buscaminas, reader, this);
        System.out.println("Creo el receptor");
        receptor.start();
        System.out.println("Ya esta todo el pedo para "+jugador.getEquipo());
        super.setVisible(true);
    }

    public TableroPanel getPnlTablero() {
        return pnlTablero;
    }

    public void setPnlTablero(TableroPanel pnlTablero) {
        this.pnlTablero = pnlTablero;
    }

    /**
     * @return the isMyTurn
     */
    public Boolean getIsMyTurn() {
        return isMyTurn;
    }

    /**
     * @param isMyTurn the isMyTurn to set
     */
    public void setIsMyTurn(Boolean isMyTurn) {
        this.isMyTurn = isMyTurn;
    }

    /**
     * @return the jugadorEnemigo
     */
    public Jugador getJugadorEnemigo() {
        return jugadorEnemigo;
    }

    /**
     * @param jugadorEnemigo the jugadorEnemigo to set
     */
    public void setJugadorEnemigo(Jugador jugadorEnemigo) {
        this.jugadorEnemigo = jugadorEnemigo;
    }

    /**
     * @return the jugador
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     * @param jugador the jugador to set
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
