/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.guitester;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import net.thebinaries.GUI.*;

/**
 *
 * @author Jacob
 */
public class EZGUITester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EZFrame ef = new EZFrame("TEST");
        EZTextPane etp = new EZTextPane("This is a test for the EZtextpane\nHello World People PopCorn Carrot");
        ef.add(etp);

        etp.setBold(true);
          etp.setColor(Color.RED);
        etp.setUnderline(true) ;
        etp.setStyle(0, 4);
        etp.setColor(Color.BLUE) ;
        etp.setSubscript(true);
        etp.setStyle(5, 7) ;
        etp.setBold(true) ;
        etp.setColor(Color.MAGENTA) ;
        etp.setSubscript(false);
       
        try {
            etp.addImageAt(etp.getText().length(),30,20,ImageIO.read(new File("C:\\Users\\Jacob\\Pictures\\cool-background-wallpapers_copy.jpg")), false) ;
        } catch (IOException ex) {
            Logger.getLogger(EZGUITester.class.getName()).log(Level.SEVERE, null, ex);
        }
        etp.setStyle(34,52) ;
        System.out.println(etp.isBold());
       

        ef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ef.setSize(500, 500);
        ef.setVisible(true);

    }

}
