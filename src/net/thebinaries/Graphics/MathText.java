/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.Graphics;

import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Jacob
 */
public class MathText extends SimpleTextTools {

    public final int SPACING;
    public static  final String POSITIVE_SIGN = "+" ;
    public static final String NEGATIVE_SIGN = "-" ;
    public MathText(Graphics graphics) {
        super(graphics);
        SPACING = graphics.getFontMetrics().getHeight() / 3;
        
    }

    public void drawFraction(String top, String bottom, int x, int y, boolean isBoxed) {

        String greaterSize;

        int origY = y - getFontHeight();
        if (getStringWidth(top) > getStringWidth(bottom)) {
            greaterSize = top;
        } else {
            greaterSize = bottom;
        }
        getGraphics().drawString(top, x, y);

        getGraphics().drawLine(x - SPACING, y += SPACING, x + getStringWidth(greaterSize) + SPACING, y);

        getGraphics().drawString(bottom, x, y += getFontHeight() / 2 + (SPACING + SPACING / 2));
        if (isBoxed) {
            getGraphics().drawRect(x - SPACING * 2, origY, getStringWidth(greaterSize) + SPACING * 4, y - origY + SPACING);
        }
    }
    
    
    
    
    public void drawSqrt(String s,String sign,int x , int y)
    {
        if(sign.equals(POSITIVE_SIGN))
        {
            getGraphics().drawString("+", x, y-SPACING/2);
        }else
        {
         getGraphics().drawString("-", x, y-SPACING/2);
        }
        getGraphics().drawLine(x,y,x+=getFontHeight() / 3,y) ;
        getGraphics().drawLine(x,y,x+=getFontHeight() / 3,y+=getFontHeight() /3) ;
          getGraphics().drawString(s,x+5,y);
        getGraphics().drawLine(x,y,x+=getFontHeight()/4,y-=getFontHeight()) ;
      
        getGraphics().drawLine(x, y, x+=getStringWidth(s) + 10, y);
    
    
    }
    
    public void drawPower(String base , String power,int x, int y)
    {
        Font tempF = getGraphics().getFont() ;
        getGraphics().drawString(base,x,y) ;
        Font f = tempF.deriveFont((float)tempF.getSize()/2) ;
     //   getGraphics().setFont(f);
        
       getGraphics().drawString(power, x+=getStringWidth(base)+ SPACING*(4/3), y-=getFontHeight()/2);
       getGraphics().setFont(tempF);
        
    
    }
    
    public void drawScientificNotation(String num , String power,int x, int y,boolean isCondensed)
    {
      
        if(isCondensed)
        {
            getGraphics().drawString(num+"e"+power,x, y);
        }else
        {
        drawPower(num+"x10", power, x, y);
        }
    }
}
