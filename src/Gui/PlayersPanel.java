/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import objects.Jugador;

/**
 *
 * @author House
 */
public class PlayersPanel extends JPanel{
    private Jugador jugador1;
    private Jugador jugador2;

    public PlayersPanel(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        super.setBackground(Color.black);
        super.setLayout(null);
        super.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }
    
}
