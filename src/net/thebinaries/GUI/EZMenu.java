/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.Color;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

/**
 *
 * @author Jacob
 */
public class EZMenu extends JMenu {

    /**
     *
     * @param items the items being added to the menu
     */
    public EZMenu(Collection<JComponent> items) {
        items.stream().forEach((i) -> {
            add((JComponent) i);
        });

    }

    /**
     *
     * @param items the items being added to the menu
     */
    public EZMenu(String[] items) {
        for (String i : items) {

            add(new JMenuItem(i));

        }

    }
    
    public EZMenu(String s){
    super(s) ;
    } 
    
    public EZMenu(){
    
    }

    /**
     *
     * @param quantity the number of separators to add
     * @param place    the place within the drop down list in which the
     *                 separators will be placed
     */
    public void addSeperators(int quantity, int[] place) {
        int compNum = this.getComponentCount();

        ArrayList<JComponent> temp = new ArrayList<>();
        for (int i = 0; i < compNum; i++) {
            temp.add((JComponent) getComponent(i));

        }
        int index = 0 ;
        for (int j = 0; j < (temp.size() + place.length); j++) {
            if(place[index] == j)
            {
            addSeparator(); 
            index++ ;
            }else
            {
            
            add(temp.get(j)) ;
            
            }
        }

    }
    

  

}
