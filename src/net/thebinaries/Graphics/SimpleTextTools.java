/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.Graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.LineMetrics;
import javafx.scene.text.Font;

/**
 *
 * @author Jacob
 */
public class SimpleTextTools {

    private Graphics graphics;

    public SimpleTextTools(Graphics graphics) {
        this.graphics = graphics;

    }

    public Graphics getGraphics() {

        return graphics;
    }

    public void drawWrappedText(String s, int x, int y, int width) {
        int start = 0;
        int end = 1;

        while (end <= s.length()) {

            String tempS = s.substring(start, end);
            
            int spaceIndex = tempS.lastIndexOf(" ");
            System.out.println(tempS.contains("velit..."));
            if (getStringWidth(tempS) > width) {
                if (spaceIndex < end && spaceIndex > start) {
                    graphics.drawString(tempS.substring(start, spaceIndex), x, y += graphics.getFontMetrics().getHeight());
                    s = s.substring(spaceIndex + 1, s.length());
            
                    end = 1;
                    System.out.println(tempS + " : " + start + " : " + spaceIndex + " : " + end);
                } else {
                    graphics.drawString(tempS.substring(0, tempS.length()) + "-", x, y += graphics.getFontMetrics().getHeight());

                    s = s.substring(tempS.length(), s.length());
                  
                    end = 1;
                    System.err.println(tempS + " : " + start + " : " + spaceIndex + " : " + end);
                }
            } else {
                end += 1;
            }

        }

        graphics.drawString(s, x, y += graphics.getFontMetrics().getHeight());

    }
    
    
    public int getFontHeight()
    {
    return getGraphics().getFontMetrics(getGraphics().getFont()).getHeight() ;
    
    }
    
    public int getStringWidth(String s)
    {
    return getGraphics().getFontMetrics(getGraphics().getFont()).stringWidth(s) ;
    
    }

}
