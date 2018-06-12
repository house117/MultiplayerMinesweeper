/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import objects.Jugador;

/**
 *
 * @author House
 */
public class PlayersPanel extends JPanel{
    private Jugador jugadorPrincipal;
    private Jugador jugadorEnemigo;
    private PanelJugador pnlJugadorPrincipal;
    private PanelJugador pnlJugadorEnemigo;
    private JLabel minasTotales;
    private JPanel pnlMinasTotales;
    public PlayersPanel(Jugador principal, Jugador enemigo) {
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        super.setBackground(Color.BLACK);
        
        super.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        this.jugadorPrincipal = principal;
        this.jugadorEnemigo = enemigo;
        
        pnlJugadorPrincipal = new PanelJugador(principal);
        
        
        minasTotales = new JLabel("51");
        minasTotales.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        minasTotales.setForeground(Color.CYAN);
        
        pnlMinasTotales = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlMinasTotales.add(minasTotales);
        pnlMinasTotales.setBackground(new Color(134, 29, 215));
        pnlMinasTotales.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        pnlJugadorEnemigo = new PanelJugador(enemigo);
        
        super.add(pnlJugadorPrincipal);
        super.add(pnlMinasTotales);
        super.add(pnlJugadorEnemigo);
        
    }
    
}
