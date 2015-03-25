/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;


import java.awt.*;
import java.util.Collection;
import javax.swing.*;

/**
 *
 * @author Jacob
 */
public class EZFrame extends JFrame {

    /**
     *
     * @param title  the title of the Window
     * @param width  the width of the window
     * @param height the height of the window
     */
    public EZFrame(String title, int width, int height) {
        super(title);
        setSize(new Dimension(width, height));
    }

    /**
     *
     * @param title the title of the Window
     */
    public EZFrame(String title) {
        super(title);

    }
    
    
    public EZFrame()
    {
    
    }

    /**
     *
     * @param components a collection of components that will be added to the
     *                   parent component
     * @param layout     the layout of the parent component(determines the
     *                   arrangement of the components to be added
     */
    public void addComponents(Collection<JComponent> components, LayoutManager layout) {
        setLayout(layout);
        components.stream().forEach((jc) -> {
            add(jc);
        });

    }

}
