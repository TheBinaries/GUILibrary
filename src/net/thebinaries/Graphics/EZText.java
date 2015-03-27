/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.Graphics;

import java.awt.Graphics;
import java.awt.font.LineMetrics;
import javafx.scene.text.Font;

/**
 *
 * @author Jacob
 */
public class EZText {

    public void drawWrappedText(String s , int x , int y , int width,Graphics g )
    {

        if(g.getFontMetrics().stringWidth(s) > width)
        {
        int ex = g.getFontMetrics().stringWidth(s) - width ;
        String sx = Font.getDefaultFont().subStringWidth() ;
        lm.getNumChars() ;
        
        
        }
        
    g.drawString(s, x, y);
    
    
    
    }
    
    
}