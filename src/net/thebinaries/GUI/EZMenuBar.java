/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.LayoutManager;
import java.util.Collection;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author Jacob
 */
public class EZMenuBar extends JMenuBar {

    /**
     * @param components the components that will be added to the parent
     *                   component
     */
    public EZMenuBar(Collection<JComponent> components) {

        components.stream().forEach((jc) -> {
            add(jc);
        });

    }
    
    public EZMenuBar(JComponent[] menu,JComponent[][] menuItems){
        for(JComponent c : menu)
        {
        add(c) ;
        
        }
        for(int i = 0 ; i < menu.length;i++)
        {
            for (JComponent menuItem : menuItems[i]) {
                ((JMenu)menu[i]).add(menuItem);
            }
        
        }
    }
    
       public EZMenuBar(String[] menu,String[][] menuItems){
        for (String menu1 : menu) {
            add(new EZMenu(menu1));
        }
        for(int i = 0 ; i < menu.length;i++)
        {
            for (String menuItem : menuItems[i]) {
                EZMenuItem x = new EZMenuItem(menuItem) ;
            //  System.out.println(  x.getHighlightColor()) ;
                ((EZMenu)getComponent(i)).add(x);
            }
        
        }
    }
    
    
    
    public EZMenuBar(){
        
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
