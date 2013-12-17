package swordfish.controllers;

import swordfish.views.MobileDirectionDisplayKeyboard;

/**
 *
 * @author Sam Coe and Joe Robinson
 *
 * @version 1.0
 *
 * Revisions: 1) December 17, 2013, JR - Updated according to external class
 * filename. MobileDirectionDisplay -> MobileDirectionDisplayKeyboard
 */
public class Swordfish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MobileDirectionDisplayKeyboard mddk = new MobileDirectionDisplayKeyboard();
        mddk.setVisible(true);
    }
}
