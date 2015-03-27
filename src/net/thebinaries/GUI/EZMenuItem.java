/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.Color;
import java.awt.MenuItem;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

/**
 *
 * @author Jacob
 */
public class EZMenuItem extends JMenuItem{
    
    
    public EZMenuItem(String s ,Icon i)
    {
        
        super(s) ;
       
        setIcon(i);
        
    }
    
    public EZMenuItem(String s){
        super(s) ;
      
    }
    
    public EZMenuItem(){
        
    }
 
    
    
}
