/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Jacob
 */
public class EZTextPane extends JTextPane {
    StyledDocument sd = getStyledDocument() ;
    
    public void setStyleAt(int attribute, int start, int end)
    {
    SimpleAttributeSet as = new SimpleAttributeSet() ;
    as.addAttribute(attribute, as);
    String sstart = getText().substring(0, start) ;
    String send  = getText().substring(end) ;
        try {
            setText(sstart) ;
            sd.insertString(start,getText(start, end), as);
            setDocument(sd) ;
            setText(getText() + send) ;
        } catch (BadLocationException ex) {
            Logger.getLogger(EZTextPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }
}
