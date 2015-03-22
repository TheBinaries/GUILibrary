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
import javax.swing.text.StyleConstants.CharacterConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Jacob
 */
public class EZTextPane extends JTextPane {

    private StyledDocument sd;
    private SimpleAttributeSet as = new SimpleAttributeSet();

    public EZTextPane() {
        this.sd = getStyledDocument();

        setDocument(sd);
    }

    public EZTextPane(String s) {
        this.sd = getStyledDocument();

        setDocument(sd);

        setText(s);
    }

    public void setBold(boolean b) {
    as.addAttribute(CharacterConstants.Bold,b );
    
    }

    public void setItalic(boolean b) {
    as.addAttribute(CharacterConstants.Italic,b );
    }

    public void setUnderline(boolean b) {
       as.addAttribute(CharacterConstants.Underline,b );
    }
     public void setSubscript(boolean b) {
       as.addAttribute(CharacterConstants.Subscript,b );
    }
     public void setSuperscript(boolean b) {
       as.addAttribute(CharacterConstants.Superscript,b );
    }
    
    
    
    /**
     *
     * @param color the color of the text
     * @param start the starting point of the text
     * @param end   the ending point of the text
     */
    public void setColor(Color color) {
        as.addAttribute(StyleConstants.CharacterConstants.Foreground, color);
    }
    
    public void setStyle(int start, int end )
    {
        SimpleAttributeSet as2 = new SimpleAttributeSet( );
        as2.addAttributes(as.copyAttributes());  
        try {
            String s = getText().substring(start,end) ;
            sd.insertString(start, getText().substring(start,end), as2);
            removeTextAt(end,s.length());
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
