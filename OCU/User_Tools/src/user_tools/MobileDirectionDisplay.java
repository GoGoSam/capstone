package user_tools;

import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyEvent.*;

/**
 *
 * @author J. Robinson
 * @date September 10, 2013
 * 
 * The purpose of this Class is to visual show the user when an arrow key on 
 * the keyboard is pressed/held down. 
 * 
 * The display is constructed using image icons located in source directory with
 * the directory 'resources.' The interface used to listen for key events is 
 * simply the KeyListener class offered through JAVA's API. The functions used 
 * within this interface is setEnabled(true or false)... which adds color when 
 * set true; else, color is removed.
 * 
 */
public class MobileDirectionDisplay extends JFrame
        implements KeyListener,
        ActionListener {

                    
    private JLabel icon_down;
    private JLabel icon_left;
    private JLabel icon_right;
    private JLabel icon_up;
    private JPanel p_directionals;
    
    private boolean do_debug = true;
    private boolean [] key_flag = new boolean [1];
    
    
    private String dir_image_icons = "/user_tools/resources/";
    
    // End of variables declaration   

    //public static final int DISPLAY_HEIGHT = 480;
    //public static final int DISPLAY_WIDTH = 640;
    
        
    // <editor-fold defaultstate="collapsed" desc="Constructors">   
    /**
     * Creates new form Controls_Display
     */   
    public MobileDirectionDisplay() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     //   Display.setDisplayMode(new DisplayMode(DISPLAY_WIDTH,DISPLAY_HEIGHT));
//Display.setFullscreen(false);
//Display.setTitle("Hello LWJGL World!");
//Display.create();
        
  //      Keyboard.create();
//throw new RuntimeException("Compiled Code");
    }

    public MobileDirectionDisplay(String name) {
        super(name);
    }// </editor-fold> 

    
    // <editor-fold defaultstate="collapsed" desc="Event Listeners">   
    /**
     * Handle the key typed event from the text field.
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Handle the key pressed event from the text field.
     * The function checks if event was triggered via arrow keys on keypad. If 
     * so, the corresponding arrow icon will be enabled, i.e., will display 
     * its true color.
     */
    @Override
    public void keyPressed(KeyEvent e) {

        if (key_flag[0])
            return;
        else
            key_flag[0] = true;    

                    
        if (do_debug)
            System.out.println("Key Press: " + e.toString());
        

        int location = e.getKeyCode();
        
        
        if (location == KeyEvent.VK_LEFT) {
            icon_left.setEnabled(true);
        } else if (location == KeyEvent.VK_RIGHT) {
            icon_right.setEnabled(true);
        } else if (location == KeyEvent.VK_UP) {
            
            icon_up.setEnabled(true);
        } else if (location == KeyEvent.VK_DOWN) {
            icon_down.setEnabled(true);
        }
    }

    
    /**
     * Handle the key released event from the text field.
     * The function checks if event was triggered via arrow keys on keypad. If 
     * so, the corresponding arrow icon will be disabled, i.e., will lose its 
     * true color set when key was pressed.
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {   
        key_flag[0] = false;
        
        if (do_debug)
            System.out.println("Key Released: " + e.toString());
                
        int location = e.getKeyCode();
        
        if (location == KeyEvent.VK_LEFT) {
            icon_left.setEnabled(false);
        } else if (location == KeyEvent.VK_RIGHT) {
            icon_right.setEnabled(false);
        } else if (location == KeyEvent.VK_UP) {
            
            icon_up.setEnabled(false);
        } else if (location == KeyEvent.VK_DOWN) {
            icon_down.setEnabled(false);
        }
    }
    
    /**
     * Handle the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {}
    // </editor-fold>  
    
    public void processKeyboard() {
    System.out.println("fjbdf");
    
    }
    
    // <editor-fold defaultstate="collapsed" desc="initComponents()">  
    /**
     * This method is called from within the constructor to initialize the form.
     * It sets the components on the displayed panel; in addition, sets 
     * appropriate event listeners.
     */    
    private void initComponents() {

        // instantiate 
        p_directionals = new JPanel();
        icon_up = new JLabel();
        icon_right = new JLabel();
        icon_left = new JLabel();
        icon_down = new JLabel();

        
        // set flags
        key_flag[0] = false;
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Get images to set as icons on label JComponents; 
        // default state disabled
        icon_up.setIcon(new ImageIcon
                (getClass().getResource(dir_image_icons + "Arrow_up.jpg"))); 
        icon_up.setEnabled(false);

        icon_right.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_right.jpg"))); // NOI18N
        icon_right.setEnabled(false);

        icon_left.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_left.jpg"))); // NOI18N
        icon_left.setEnabled(false);

        icon_down.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_down.jpg"))); // NOI18N
        icon_down.setEnabled(false);

        // Layour components
        org.jdesktop.layout.GroupLayout p_directionalsLayout = new org.jdesktop.layout.GroupLayout(p_directionals);
        p_directionals.setLayout(p_directionalsLayout);
        p_directionalsLayout.setHorizontalGroup(
                p_directionalsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(p_directionalsLayout.createSequentialGroup()
                .addContainerGap()
                .add(icon_left, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(p_directionalsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(icon_up, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(icon_down))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(icon_right)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        p_directionalsLayout.setVerticalGroup(
                p_directionalsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(p_directionalsLayout.createSequentialGroup()
                .addContainerGap()
                .add(p_directionalsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(p_directionalsLayout.createSequentialGroup()
                .add(icon_up)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(icon_down))
                .add(p_directionalsLayout.createSequentialGroup()
                .add(41, 41, 41)
                .add(p_directionalsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(icon_right)
                .add(icon_left))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        icon_up.getAccessibleContext().setAccessibleName("U");
        icon_left.getAccessibleContext().setAccessibleName("Up");
        icon_down.getAccessibleContext().setAccessibleName("L_down");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(p_directionals, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(p_directionals, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE));

                
        addKeyListener(this);
        pack();
    }// </editor-fold>    
} // end class