package swordfish.controllers;

import swordfish.views.MobileDirectionDisplay;

/**
 *
 * @author Sam Coe and Joe Robinson
 */
public class Swordfish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //XBox360_DirectionDisplay ff = null;
        MobileDirectionDisplay mdd = null;
        mdd = new MobileDirectionDisplay();
        mdd.setVisible(true);
    }
}
