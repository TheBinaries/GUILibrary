/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.LayoutManager ;
import java.awt.Color;
import java.util.Collection;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Jacob
 */
public class EZPanel extends JPanel {
   
    /**
     * 
     * @param layout the layout of the component
     */
    
        public EZPanel(LayoutManager layout)
        {
            super(layout) ;
        
        }
    
    /**
     * 
     * @param bg the background of the component
     * @param fg the foreground of the component
     */
        public EZPanel(Color bg,Color fg)
        {
            setBackground(bg);
            setForeground(fg) ;
        
        
        }
        
        public EZPanel() {
        
        } 
        /**
         * 
         * @param components the components that will be added to the parent component
         * @param layout the layout of the component
         */
        public void addComponents(Collection<JComponent> components,LayoutManager layout)
        {
            setLayout(layout) ;
          
          components.stream().forEach((i) -> {
            add((JComponent)i) ;
        });
        
        }
        
        
}
