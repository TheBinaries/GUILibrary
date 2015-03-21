/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.Color;
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

    private StyledDocument sd;

    public EZTextPane() {
        this.sd = getStyledDocument();
    }

    public EZTextPane(String s) {
        this.sd = getStyledDocument();
        setDocument(sd);
        
        setText(s);
    }
/**
 * 
 * @param attribute the style attribute that will be designated to the selected text
 * @param start the starting point of the text
 * @param end the ending point of the text
 */
    public void setStyleAt(Object attribute, int start, int end) {
        SimpleAttributeSet as = new SimpleAttributeSet();
        as.addAttribute(StyleConstants.CharacterConstants.Italic, "atr");
        String sstart = getText().substring(0, start);
        String send = getText().substring(end);
         String text = getText().substring(start, end);
        try {

          sd.insertString(start, text, as);
             sd.remove(end, text.length());
              setDocument(sd);
        } catch (BadLocationException ex) {
            Logger.getLogger(EZTextPane.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
 * 
 * @param color the color of the text
 * @param start the starting point of the text
 * @param end the ending point of the text
 */
    public void setColorAt(Color color, int start, int end) {
        SimpleAttributeSet as = new SimpleAttributeSet();
        as.addAttribute(StyleConstants.CharacterConstants.Foreground, color);
        String sstart = getText().substring(0, start);
        String send = getText().substring(end);
        String text = getText().substring(start, end);
        try {
           // setText(sstart) ;
          
            sd.insertString(start, text, as);
             sd.remove(end, text.length());
            //  setDocument(sd);
          
        //    setText(getText() + send) ;
          
        } catch (BadLocationException ex) {
            Logger.getLogger(EZTextPane.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    public void removeTextAt(int start, int end) {
        try {
            getDocument().remove(start, end);
        } catch (BadLocationException ex) {
            Logger.getLogger(EZTextPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
