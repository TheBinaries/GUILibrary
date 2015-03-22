/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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

    /**
     *
     * @param start - the starting index >=0
     * @param end   - the ending index <= document length
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
    public void insertTextAdd(int start, String s) {
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
     */
    public void addImageAt(int start, int width, int height, Image i) {

        Image resizedImage = (Image) i.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        JLabel l = new JLabel(new ImageIcon(resizedImage));
        l.setSize(width, height);
        setCaretPosition(start);
        insertComponent(l);
        setCaretPosition(start + 1);
    }

}
