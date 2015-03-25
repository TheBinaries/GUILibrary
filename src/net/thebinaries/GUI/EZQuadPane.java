/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.JSplitPane;

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
            splitPane1.setOrientation(EZGUIConstants.VERTICAL_SPLIT);
            splitPane2.setOrientation(EZGUIConstants.VERTICAL_SPLIT);
            setOrientation(JSplitPane.VERTICAL_SPLIT);
            setTopComponent(splitPane1);
            setBottomComponent(splitPane2);

            setResizeWeight(.5);
        } else if (orientation == EZGUIConstants.VERTICAL_SPLIT) {
            splitPane1 = new EZSplitPane(EZGUIConstants.HORIZONTAL_SPLIT);
            splitPane2 = new EZSplitPane(EZGUIConstants.HORIZONTAL_SPLIT);
            splitPane1.setOrientation(EZGUIConstants.HORIZONTAL_SPLIT);
            splitPane2.setOrientation(EZGUIConstants.HORIZONTAL_SPLIT);
            setOrientation(EZGUIConstants.VERTICAL_SPLIT);
            setLeftComponent(splitPane1);
            setRightComponent(splitPane2);
            setResizeWeight(.5);
        }
        splitPane1.setContinuousLayout(true);
        splitPane2.setContinuousLayout(true);
        setContinuousLayout(true);

        splitPane1.setOneTouchExpandable(true);
        if (!isIndependent) {
            splitPane2.setOneTouchExpandable(true);
        } else {
            splitPane2.setOneTouchExpandable(true);
        }
        setOneTouchExpandable(true);
        splitPane1.addPropertyChangeListener(this);
        splitPane2.addPropertyChangeListener(this);

    }

    public EZQuadPane() {
        splitPane1.setContinuousLayout(true);
        splitPane2.setContinuousLayout(true);
        setContinuousLayout(true);

        splitPane1.setOneTouchExpandable(true);
        if (!isIndependent) {
            splitPane2.setOneTouchExpandable(true);
        } else {
            splitPane2.setOneTouchExpandable(true);
        }
        setOneTouchExpandable(true);
        splitPane1.addPropertyChangeListener(this);
        splitPane2.addPropertyChangeListener(this);

    }

    public void setSubDividersIndependent(boolean b) {

        isIndependent = b;
        if (b) {
            splitPane2.setOneTouchExpandable(true);
            splitPane1.setOneTouchExpandable(true);
            setOneTouchExpandable(true);
        } else {

            splitPane2.setOneTouchExpandable(false);
            splitPane1.setOneTouchExpandable(true);
            setOneTouchExpandable(true);
        }
    }

    public boolean isSubDividersIndependent() {
        return isIndependent;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (!isIndependent) {
            pce.setPropagationId(JSplitPane.DIVIDER_LOCATION_PROPERTY);
            splitPane2.setOneTouchExpandable(false);
            setOneTouchExpandable(false);
            if (pce.getSource().equals(splitPane1) && splitPane1.getDividerLocation() != splitPane2.getDividerLocation()) {
                splitPane2.setDividerLocation(splitPane1.getDividerLocation());

            } else {
                splitPane1.setDividerLocation(splitPane2.getDividerLocation());
            }
        }

    }

    //***************************************************************************************
    public void setTopLeftComponent(JComponent c) {
        if (getOrientation() == EZGUIConstants.HORIZONTAL_SPLIT) {
            splitPane1.setLeftComponent(c);

        } else {
            splitPane1.setTopComponent(c);

        }
    }

    public void setTopRightComponent(JComponent c) {
        if (getOrientation() == EZGUIConstants.HORIZONTAL_SPLIT) {
            splitPane1.setRightComponent(c);

        } else {
            splitPane2.setTopComponent(c);

        }
    }

    public void setBottomRightComponent(JComponent c) {
        if (getOrientation() == EZGUIConstants.HORIZONTAL_SPLIT) {
            splitPane2.setRightComponent(c);

        } else {
            splitPane2.setBottomComponent(c);

        }

    }

    public void setBottomLeftComponent(JComponent c) {
        if (getOrientation() == EZGUIConstants.HORIZONTAL_SPLIT) {
            splitPane2.setLeftComponent(c);

        } else {
            splitPane1.setBottomComponent(c);

        }
    }

    public JComponent getSplitComponentOne() {
        return splitPane1;

    }

    public JComponent getSplitComponentTwo() {
        return splitPane2;

    }

//**********************************************************
    public Component getTopLeftComponent() {
        if (getOrientation() == EZGUIConstants.HORIZONTAL_SPLIT) {
            return splitPane1.getLeftComponent();

        } else {
            return splitPane1.getTopComponent();

        }
       
    }

    public Component getTopRightComponent() {
        if (getOrientation() == EZGUIConstants.HORIZONTAL_SPLIT) {
        return    splitPane1.getRightComponent();

        } else {
          return  splitPane2.getTopComponent();

        }
    }

    public Component getBottomRightComponent() {
        if (getOrientation() == EZGUIConstants.HORIZONTAL_SPLIT) {
            return splitPane2.getRightComponent();

        } else {
            return splitPane2.getBottomComponent();

        }

    }

    public Component getBottomLeftComponent() {
        if (getOrientation() == EZGUIConstants.HORIZONTAL_SPLIT) {
            return splitPane2.getLeftComponent();

        } else {
            return splitPane1.getBottomComponent();

        }
    }

}
