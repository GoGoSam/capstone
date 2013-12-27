package swordfish.views;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author J. Robinson
 */
public class run_FunctioningMainClass {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        // TODO code application logic here

        if (false) {
            XBox360_DirectionDisplay xboxDD = new XBox360_DirectionDisplay();
            xboxDD.setVisible(true);
        }
        if (false) {
            MobileDirectionDisplayKeyboard ppp = new MobileDirectionDisplayKeyboard();
            ppp.setVisible(true);
        }
        MainMenu mm = new MainMenu();
        mm.setVisible(true);

    }
}
