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
                    System.out.println("???Asdasd?");
                    PrincipalFrame ventana = new PrincipalFrame("Busca Flags!");
                    System.out.println("?????");
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
}
