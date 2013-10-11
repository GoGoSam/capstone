package user_tools;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Version;

/**
 * User: Sam Coe
 * Date: 10/11/13
 */

public class XBox360Test {

    public XBox360Test() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String args[]){
        System.out.println("JInput version: " + Version.getVersion());
        ControllerEnvironment ce = ControllerEnvironment.getDefaultEnvironment();
        Controller[] cs = ce.getControllers();
        for (int i = 0; i < cs.length; i++) {
            System.out.println(i + ". " + cs[i].getName() + ", " + cs[i].getType() );
        }

        /*
        ControllerEnvironment ce =
                ControllerEnvironment.getDefaultEnvironment();

        // retrieve the available controllers
        Controller[] controllers = ce.getControllers();

        //fetch gamepad controller
        Controller gamePadContr = null;
        for(Controller c : controllers){
            if(c.getType() == Controller.Type.GAMEPAD) {
                gamePadContr = c;
                break;
            }
        }

        //none found
        if(gamePadContr == null){
            throw new NullPointerException("No gamepad found");
        }

        Component buttonComponent = gamePadContr.getComponent(Identifier.Axis.POV);

        float prevData = 0;
        while(gamePadContr.poll()){
            float data = buttonComponent.getPollData();
            if(data != prevData)
                System.out.println(data);
        }
        */
    }
}
