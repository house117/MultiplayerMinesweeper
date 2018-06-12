/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javafx.scene.paint.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import objects.Jugador;

/**
 *
 * @author House
 */
public class PanelJugador extends JPanel{
    private JLabel lblEquipo;
    private Tlabel lblImagen;
    private Tlabel lblBanderita;
    private JLabel lblPuntuación;
    private JPanel pnlPuntuacion;
    private JLabel lblTextoPuntuacion;
    private JPanel pnlImagen;
    public PanelJugador(Jugador jugador){
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        pnlPuntuacion = new JPanel(new FlowLayout());
        
        switch(jugador.getEquipo()){
            case EquipoAzul:
                super.setBackground(new java.awt.Color(127, 249, 253));
                lblEquipo = new JLabel("Equipo Azul");
                lblEquipo.setForeground(java.awt.Color.BLUE);
                lblImagen = new Tlabel("/images/bluePlayer.png");
                lblImagen.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                pnlImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
                pnlImagen.add(lblImagen);
                pnlImagen.setBackground(new java.awt.Color(127, 249, 253));
                lblBanderita = new Tlabel("/images/banderaAzul.png");
                lblPuntuación = new JLabel("0");
                lblPuntuación.setForeground(java.awt.Color.BLUE);
                lblTextoPuntuacion = new JLabel("Puntuación");
                lblTextoPuntuacion.setForeground(java.awt.Color.blue);
                pnlPuntuacion.add(lblTextoPuntuacion);
                pnlPuntuacion.add(lblBanderita);
                pnlPuntuacion.add(lblPuntuación);
                pnlPuntuacion.setBackground(new java.awt.Color(127, 249, 253));
                super.add(lblEquipo);
                super.add(pnlImagen);
                super.add(pnlPuntuacion);
                break;
            case EquipoRojo:
                super.setBackground(new java.awt.Color(252, 96, 102));
                System.out.println("ENTRO CASE EQUIPO ROJO PNLJUGADOR");
                lblEquipo = new JLabel("Equipo Rojo");
                lblEquipo.setForeground(new java.awt.Color(142, 0, 5));
                lblImagen = new Tlabel("/images/redPlayer.png");
                lblImagen.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                pnlImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
                pnlImagen.add(lblImagen);
                pnlImagen.setBackground(new java.awt.Color(252, 96, 102));
                lblBanderita = new Tlabel("/images/banderaRoja.png");
                lblPuntuación = new JLabel("0");
                lblPuntuación.setForeground(new java.awt.Color(142, 0, 5));
                lblTextoPuntuacion = new JLabel("Puntuación");
                lblTextoPuntuacion.setForeground(new java.awt.Color(142, 0, 5));
                pnlPuntuacion.add(lblTextoPuntuacion);
                pnlPuntuacion.add(lblBanderita);
                pnlPuntuacion.add(lblPuntuación);
                pnlPuntuacion.setBackground(new java.awt.Color(252, 96, 102));
                super.add(lblEquipo);
                super.add(pnlImagen);
                super.add(pnlPuntuacion);
                break;
        }
    }

    public JLabel getLblEquipo() {
        return lblEquipo;
    }

    public void setLblEquipo(JLabel lblEquipo) {
        this.lblEquipo = lblEquipo;
    }

    public Tlabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(Tlabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public Tlabel getLblBanderita() {
        return lblBanderita;
    }

    public void setLblBanderita(Tlabel lblBanderita) {
        this.lblBanderita = lblBanderita;
    }

    public JLabel getLblPuntuación() {
        return lblPuntuación;
    }

    public void setLblPuntuación(JLabel lblPuntuación) {
        this.lblPuntuación = lblPuntuación;
    }

    public JPanel getPnlPuntuacion() {
        return pnlPuntuacion;
    }

    public void setPnlPuntuacion(JPanel pnlPuntuacion) {
        this.pnlPuntuacion = pnlPuntuacion;
    }
}
