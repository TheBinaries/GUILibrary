/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
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
        return StyleConstants.isBold(as);
    }

    /**
     *
     * @return whether the current attribute set is set to be a italicized
     */
    public boolean isItalicized() {
        return StyleConstants.isItalic(as);
    }

    /**
     *
     * @return whether the current attribute set is set to be underlined
     */
    public boolean isUnderlined() {
        return StyleConstants.isUnderline(as);
    }

    /**
     *
     * @return whether the current attribute set is set to be a subscript
     */
    public boolean isSubscript() {
        return StyleConstants.isSubscript(as);
    }

    /**
     *
     * @return whether the current attribute set is set to be a superscript
     */
    public boolean isSuperscript() {
        return StyleConstants.isItalic(as);
    }

    /**
     *
     * @return the current color of the text
     */
    public Color getColor() {
        return sd.getForeground(as);
    }
    
    
    public SimpleAttributeSet getAttributeSet(){
        
        return as ;
    }

    /**
     *
     * @param start - the starting index; start is greater than or equal to 0
     * 
     * @param end   - the ending index; end is less than or equal to document length
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

    /**
     *
     * @param start the starting position to remove the text
     * @param end   the ending position to remove the text
     */
    public void removeTextAt(int start, int end) {
        try {
            getDocument().remove(start, end);
        } catch (BadLocationException ex) {
            Logger.getLogger(EZTextPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param start the place within the established text where the new text
     *              will be inserted
     * @param s     the text to be inserted
     */
    public void insertTextAt(int start, String s) {
        try {
            getDocument().insertString(start, s, as);
        } catch (BadLocationException ex) {
            Logger.getLogger(EZTextPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param start  the starting position of where the image will be inserted
     * @param width  the width of the image
     * @param height the height of the image
     * @param i      the image to be added
     * @param b determines whether to include the image in the same line or create a new line for the image, if true then the image will put on its own line
     */
    public void addImageAt(int start, int width, int height, Image i, boolean b) {

        Image resizedImage = (Image) i.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        JLabel l = new JLabel(new ImageIcon(resizedImage));
        l.setSize(width, height);
        if(b)
        {
            insertTextAt(start, "\n");
            setCaretPosition(start+1);
            insertComponent(l);
            insertTextAt(start, "\n");
            setCaretPosition(start+2);
            
        }else{
        setCaretPosition(start);
        insertComponent(l);
        setCaretPosition(start+1);
        }
        
    }
    /**
     * 
     * @param start the position to insert the component
     * @param width the width of the component
     * @param height the height of the component
     * @param component the component to be added
* @param b determines whether to include the image in the same line or create a new line for the image, if true then the image will put on its own line
     */
        public void addComponentAt(int start, int width, int height,  JComponent component, boolean b) {

     


        component.setSize(width, height);
        component.setMaximumSize(new Dimension(width,height));
      
        if(b)
        {
            insertTextAt(start, "\n");
            setCaretPosition(start+1);
            insertComponent(component);
            insertTextAt(start, "\n");
            setCaretPosition(start+2);
            
        }else{
        setCaretPosition(start);
        insertComponent(component);
        setCaretPosition(start+1);
        }
        
        }
    

}
