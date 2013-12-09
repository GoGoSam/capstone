/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swordfish.views;

import java.io.IOException;
//import java.net.URI;
import java.net.URISyntaxException;
//import swordfish.views.FunctioningMainMenu;

/**
 *
 * @author jrob
 */
public class run_FunctioningMainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        // TODO code application logic here

//        javax.imageio.ImageReader ii
//        FunctioningMainMenu fmm = new FunctioningMainMenu();
        MainMenu fmm = new MainMenu();
        fmm.setVisible(true);
//        String theURI = "http://tour.mapsalive.com/37974/page1.htm";
//        java.awt.Desktop.getDesktop().browse(new URI(theURI));
//        //FunctioningMainMenu.se
    }
}
