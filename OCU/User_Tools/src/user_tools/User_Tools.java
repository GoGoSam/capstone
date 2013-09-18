/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user_tools;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;

/**
 *
 * @author jrob
 */
public class User_Tools {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
        MobileDirectionDisplay ff = null;
       // try {
            ff = new MobileDirectionDisplay();
      //  } catch (LWJGLException ex) {
        //    Logger.getLogger(User_Tools.class.getName()).log(Level.SEVERE, null, ex);
        //}
        ff.setVisible(true);
    }
}
