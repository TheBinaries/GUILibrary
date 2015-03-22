/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.guitester;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.text.StyleConstants;
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
        System.out.println(etp.getColor());
        etp.setStyle(34,52) ;
       

        ef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ef.setSize(500, 500);
        ef.setVisible(true);

    }

}
