/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.Collection;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author Jacob
 */
public class EZButton extends JButton {
/**
 * 
 * @param text the text placed on the button
     * @param icon the icon of the button
 */
    public EZButton(String text, Icon icon) {
        super(text);
        setIcon(icon);
    }

    /**
     *
     * @param text the text placed on the button
     * @param f the font associate with the text on the button
     */
    public EZButton(String text, Font f) {
        super(text);
        setFont(f);
    }

    /**
     *
     * @param bg the background of the component
     * @param fg the foreground of the component
     */
    public EZButton(Color bg, Color fg) {
        setBackground(bg);
        setForeground(fg);

    }
    /**
     * 
     * @param horizontal set the text's horizontal alignment using JComponent Constants
     * @param vertical set the text's vertical alignment using JComponent Constants
     */
    public void setTextAlignment(int horizontal, int vertical){
        
       setVerticalTextPosition(vertical);
        setHorizontalTextPosition(horizontal);
       
        
    }
    /**
     * 
     * @param direction the direction the text is placed at
     * @see EZGUIConstants.CLOCKWISE
     * @see EZGUIConstants.COUNTERCLOCKWISE
     * @see EZGUIConstants.Reflection
     */
    public void rotateText(int direction)
    {
        Graphics g = getGraphics().create() ;
        Graphics2D g2 = (Graphics2D) g ;
      if (direction == EZGUIConstants.CLOCKWISE ) {
         g2.rotate(Math.PI / 2.0);
         g2.translate(0, -getSize().width);
      } else if (direction == EZGUIConstants.COUNTERCLOCKWISE)  {
         g2.translate(0, getSize().height);
         g2.rotate(- Math.PI / 2.0);
        
      }else
      {
          g2.rotate(Math.PI) ;
      
      }
      super.paintComponent(g2);
         
}
        
    
    
    public void setText_IconAlignment(int horizontal, int vertical)
    {
    
      setVerticalAlignment(vertical);
        setHorizontalAlignment(horizontal);
    }

    /**
     *
     * @param components the components that will be added to the parent
     *                   component
     * @param layout     the layout of the component
     */
    public void addComponents(Collection<JComponent> components, LayoutManager layout) {
        setLayout(layout);
        Object[] list = components.toArray();
        for (int i = 0; i < components.size(); i++) {

            add((JComponent) list[i]);

        }
    }
}