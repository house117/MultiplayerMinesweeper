/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Gui.PrincipalFrame;
import buscaminasobjects.BuscaminasMp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author House
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        grafico();
    }
    public static void grafico(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
       
                try {
                    JTextField nickname = new JTextField(15);
                    JTextField direccion = new JTextField(15);
                    JPanel pnlMaterias = new JPanel();
                    pnlMaterias.setLayout(new BoxLayout(pnlMaterias, BoxLayout.Y_AXIS));
                    pnlMaterias.add(new JLabel("Nickname:"));
                    pnlMaterias.add(nickname);
                    pnlMaterias.add(new JLabel("Direccion Servidor:"));
                    pnlMaterias.add(direccion);
                    int resultMaterias = JOptionPane.showConfirmDialog(null, pnlMaterias, "Ingresa la cantidad de materias",
                            JOptionPane.OK_CANCEL_OPTION); //Con esto tenemos un boton de ok/cancel, muy util
                    if (resultMaterias == JOptionPane.OK_OPTION) {
                        System.out.println("???Asdasd?");
                        PrincipalFrame ventana = new PrincipalFrame(nickname.getText(), direccion.getText());
                        System.out.println("?????");
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
    }
}
