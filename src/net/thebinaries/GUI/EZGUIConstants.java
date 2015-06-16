/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thebinaries.GUI;

/**
 *
 * @author Jacob
 */
public enum EZGUIConstants {

    CLOCKWISE(90), COUNTERCLOCKWISE(-90), REFLECTION(180),
    VERTICAL_SPLIT(1), HORIZONTAL_SPLIT(0), HALF_SPLIT(50), QUARTER_SPLIT(25), THREE_QUARTER_SPLIT(75) ;
    private double value ;
    
    

private EZGUIConstants(int v)
{
value = v ;
}
//    public static final int CLOCKWISE = 90;
//    public static final int COUNTERCLOCKWISE = -90;
//    public static final int REFLECTION = 180;
//    public static final int VERTICAL_SPLIT = 1 ;
//    public static final int HORIZONTAL_SPLIT = 0 ;
//    public static final double HALF_SPLIT = .5 ;
//    public static final double QUATER_SPLIT = .25 ;
//    public static final double THREE_QUATER_SPLIT = .75 ;
    
    
}
