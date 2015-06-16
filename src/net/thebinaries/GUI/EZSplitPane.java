/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author Jacob
 */
public class EZSplitPane extends JSplitPane {
     public static final int HORIZONTAL_SPLIT = 0 ;
          public static final int VERTICAL_SPLIT = 1 ;
  public EZSplitPane(){

    if(getOrientation() == HORIZONTAL_SPLIT){
            setTopComponent(new JPanel());
            setBottomComponent(new JPanel());
           
                    setResizeWeight(.5);
        }else{
        setLeftComponent(new JPanel());
        setRightComponent(new JPanel());
                setResizeWeight(.5);
        }
  }
    public EZSplitPane(int orientation)
    {
     if(orientation == HORIZONTAL_SPLIT){
            setTopComponent(new JPanel());
            setBottomComponent(new JPanel());
           
                    setResizeWeight(.5);
        }else{
        setLeftComponent(new JPanel());
        setRightComponent(new JPanel());
                setResizeWeight(.5);
        }
    
    
    } ;
    public EZSplitPane(JComponent c1 , JComponent c2,int  orientation,double ratio)
    {
        
        if(orientation == HORIZONTAL_SPLIT){
            setTopComponent(c1);
            setBottomComponent(c2);
              
                    setResizeWeight(ratio);
        }else{
        setLeftComponent(c1);
        setRightComponent(c2);
             //   setDividerLocation(getWidth());
                setResizeWeight(ratio);
        }

        
    }
    
    @Override
    public void setOrientation(int i){
        if(i == JSplitPane.VERTICAL_SPLIT || i == HORIZONTAL_SPLIT){
        
        super.setOrientation(HORIZONTAL_SPLIT) ;
        
        }else 
            
            super.setOrientation(VERTICAL_SPLIT) ;
        
        
        
    }
    
    
    
    
    
    }

