package user_tools;

/**
 *
 * @author Sam Coe and Joe Robinson
 */
public class User_Tools {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //XBox360_DirectionDisplay ff = null;
        MobileDirectionDisplay mdd = null;
        mdd = new MobileDirectionDisplay();
        mdd.setVisible(true);
        
        
        MainMenu user_tool_ui = null;
        user_tool_ui = new MainMenu();
        user_tool_ui.setVisible(true);
    }
}
