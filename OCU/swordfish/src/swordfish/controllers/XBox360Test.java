package swordfish.controllers;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Version;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import net.java.games.input.Component;
import net.java.games.input.Component.Identifier;
import swordfish.models.input.XboxController;
import swordfish.models.input.JInputXboxController;

/**
 * User: Sam Coe
 * Date: 10/11/13
 */

public class XBox360Test {

    public XBox360Test() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String args[]){
        JInputXboxController test = (JInputXboxController) XboxController.getAll().get(0);

        /*
        System.out.println("JInput version: " + Version.getVersion());
        ControllerEnvironment ce = ControllerEnvironment.getDefaultEnvironment();
        Controller[] cs = ce.getControllers();
        for (int i = 0; i < cs.length; i++) {
            System.out.println(i + ". " + cs[i].getName() + ", " + cs[i].getType() );
        }

        //fetch gamepad controller
        Controller gamePadContr = null;
        for(Controller c : cs){
            if(c.getType() == Controller.Type.GAMEPAD) {
                gamePadContr = c;
                break;
            }
        }

        //none found
        if(gamePadContr == null){
            throw new NullPointerException("No gamepad found");
        }

        while(true) {
            gamePadContr.poll();
            Component[] components = gamePadContr.getComponents();
            StringBuffer buffer = new StringBuffer();
            for(int i=0;i<components.length;i++) {
                if(i>0) {
                    buffer.append(", ");
                }
                buffer.append(components[i].getName());
                buffer.append(": ");
                if(components[i].isAnalog()) {
                    buffer.append(components[i].getPollData());
                } else {
                    if(components[i].getPollData()==1.0f) {
                        buffer.append("On");
                    } else {
                        buffer.append("Off");
                    }
                }
            }
            System.out.println(buffer.toString());

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        */
    }
}
