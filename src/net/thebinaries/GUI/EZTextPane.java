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
      /**
      * 
      * @param b determines whether the text should be bold
      */
    public void setBold(boolean b) {
        as.addAttribute(CharacterConstants.Bold, b);

    }

    /**
     *
     * @param b determines whether the text should be italicized
     */
    public void setItalic(boolean b) {
        as.addAttribute(CharacterConstants.Italic, b);
    }

    /**
     *
     * @param b determines whether the text should be underlined
     */
    public void setUnderline(boolean b) {
        as.addAttribute(CharacterConstants.Underline, b);
    }

    /**
     *
     * @param b determines whether the text should be a subscript
     */
    public void setSubscript(boolean b) {
        as.addAttribute(CharacterConstants.Subscript, b);
    }

    /**
     *
     * @param b determines whether the text should be a superscript
     */
    public void setSuperscript(boolean b) {
        as.addAttribute(CharacterConstants.Superscript, b);
    }

    /**
     *
     * @param color the color of the text
     */
    public void setColor(Color color) {
        as.addAttribute(StyleConstants.CharacterConstants.Foreground, color);
    }
    //****************************************************************************
  /**
   * 
   * @return whether the current attribute set is set to be bold
   */
    public boolean isBold() {
      return StyleConstants.isBold(as) ;
    }

  /**
   * 
   * @return whether the current attribute set is set to be a italicized
   */
    public boolean isItalicized() {
        return StyleConstants.isItalic(as) ;
    }

  /**
   * 
   * @return whether the current attribute set is set to be underlined
   */
    public boolean isUnderlined() {
        return StyleConstants.isUnderline(as) ;
    }

     /**
   * 
   * @return whether the current attribute set is set to be a subscript
   */
    public boolean isSubscript() {
       return StyleConstants.isSubscript(as) ;
    }

  /**
   * 
   * @return whether the current attribute set is set to be a superscript
   */
    public boolean isSuperscript() {
         return StyleConstants.isItalic(as) ;
    }

/**
 * 
 * @return the current color of the text
 */
    public Color getColor() {
        return  sd.getForeground(as) ;
    }
    
  
/**
 * 
 * @param start - the starting index >=0
 * @param end - the ending index <= document length
 */
    public void setStyle(int start, int end) {
        
        try {
            String s = getText().substring(start, end);
            sd.insertString(start, getText().substring(start, end), as);
            removeTextAt(end, s.length());
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
