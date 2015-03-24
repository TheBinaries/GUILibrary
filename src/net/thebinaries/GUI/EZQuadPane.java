/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicSplitPaneDivider;

/**
 *
 * @author Jacob
 */
public class EZQuadPane extends EZSplitPane implements PropertyChangeListener {

    private EZSplitPane splitPane1;
    private EZSplitPane splitPane2;

    private static boolean isIndependent = true;

    public EZQuadPane(int orientation) {
        if (orientation == EZGUIConstants.HORIZONTAL_SPLIT) {
            splitPane1 = new EZSplitPane(EZGUIConstants.VERTICAL_SPLIT);
            splitPane2 = new EZSplitPane(EZGUIConstants.VERTICAL_SPLIT);
            setOrientation(JSplitPane.VERTICAL_SPLIT);
            setTopComponent(splitPane1);
            setBottomComponent(splitPane2);

            setResizeWeight(.5);
        } else {
            splitPane1 = new EZSplitPane(EZGUIConstants.HORIZONTAL_SPLIT);
            splitPane2 = new EZSplitPane(EZGUIConstants.HORIZONTAL_SPLIT);
            setOrientation(JSplitPane.HORIZONTAL_SPLIT);
            setLeftComponent(splitPane1);
            setRightComponent(splitPane2);
            setResizeWeight(.5);
        }
        splitPane1.setContinuousLayout(true);
        splitPane2.setContinuousLayout(true);
        setContinuousLayout(true);
        
        splitPane1.setOneTouchExpandable(true);
        if(!isIndependent){
        splitPane2.setOneTouchExpandable(true);
        }else
        {
        splitPane2.setOneTouchExpandable(true);
        }
        setOneTouchExpandable(true);
        splitPane1.addPropertyChangeListener(this);
        splitPane2.addPropertyChangeListener(this);
    
    }

    public void setSubDividersIndependent(boolean b) {

        isIndependent = b;

    }

    public boolean isSubDividersIndependent() {
        return isIndependent;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (!isIndependent) {
            pce.setPropagationId(JSplitPane.DIVIDER_LOCATION_PROPERTY);
            splitPane2.setOneTouchExpandable(false);
            if (pce.getSource().equals(splitPane1) && splitPane1.getDividerLocation() != splitPane2.getDividerLocation()) {
                splitPane2.setDividerLocation(splitPane1.getDividerLocation());

            } else {
                splitPane1.setDividerLocation(splitPane2.getDividerLocation());
            }
        }
    }

}
