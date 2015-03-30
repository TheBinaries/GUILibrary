/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.Graphics;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Jacob
 */
public class WritingPen {
    private Graphics graphics ;
    private Color color ;
    private int thickness ;
    private JComponent parent ;
    
    private ArrayList<Point> points = new ArrayList<>() ;
   
    public WritingPen()
    {
     parent.addMouseMotionListener(new Listeners());
       parent.addMouseListener(new Listeners());
    }
    
    public WritingPen(Graphics g,JComponent parentComponent)
    {
        graphics = g ;
        parent = parentComponent ;
       parent.addMouseMotionListener(getMouseMotionListener());
       parent.addMouseListener(getMouseListener());
    }
    
    public WritingPen(Color c, int thickness, Graphics g,JComponent parentComponent)
    {
        graphics = g ;
        color = c ;
        this.thickness = thickness ;
        parent = parentComponent ;
       parent.addMouseMotionListener(getMouseMotionListener());
       parent.addMouseListener(getMouseListener());
        g.setColor(color);
        ((Graphics2D)g).setStroke(new BasicStroke(thickness)) ;
        
   
        
        
    
    }

 

    public void connectPoints(Point p1, Point p2) {
  
    graphics.drawLine(p1.x,p1.y,p2.x,p2.y) ;
    parent.repaint() ;
    
    
    
    }
    
    
    public void setGraphics(Graphics g)
    {
    graphics = g ;
    
    }
      
    public void setParentComponent(JComponent parent)
    {
    this.parent = parent ;
    
    }
    
    private MouseListener getMouseListener()
    {
    return parent.getMouseListeners()[0] ;
    
    }
     private MouseMotionListener getMouseMotionListener()
    {
    return parent.getMouseMotionListeners()[0] ;
    
    }
    
    
    public class Listeners implements MouseListener,MouseMotionListener
    {
    
       @Override
    public void mouseDragged(MouseEvent me) {
    points.add(new Point(me.getX(),me.getY())) ;
      if(points.size()>=2)
    {
    connectPoints(points.get(points.size()-2) , points.get(points.size() - 1)) ;
    }
         System.out.println(points.size()) ;
    }
 

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    graphics.drawOval(me.getX(), me.getY(), 40, 40);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
    }
    
    
    
    
    
    
}
