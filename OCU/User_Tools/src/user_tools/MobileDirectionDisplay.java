/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user_tools;

import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyEvent.*;
import java.io.*;

/**
 *
 * @author jrob
 */
public class MobileDirectionDisplay extends JFrame
        implements KeyListener,
        ActionListener {

    //private Controls_Display frame;
    private static MobileDirectionDisplay frame;
    // Variables declaration - do not modify                     
    private JLabel icon_down;
    private JLabel icon_left;
    private JLabel icon_right;
    private JLabel icon_up;
    private JPanel p_directionals;
    // End of variables declaration   

    
        
    // <editor-fold defaultstate="collapsed" desc="Constructors">   
    /**
     * Creates new form Controls_Display
     */   
    public MobileDirectionDisplay() {

        System.out.print("TEST");
        //  frame = new Controls_Display();
        initComponents();
        // setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.



        //Display the window.
        //  pack();
        //    setVisible(true);

    }

    public MobileDirectionDisplay(String name) {
        super(name);
    }// </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Event Listeners">   
    /**
     * Handle the key typed event from the text field.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //      System.out.println("KEY TYPED: " + e.toString());
    }

    /**
     * Handle the key pressed event from the text field.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //    System.out.println("KEY PRESSED: " + e.toString());
        //  displayInfo(e, "KEY RELEASED: ");

//        if (icon_up.isEnabled())
//                icon_up.setEnabwed(false);        
//        else
//            icon_up.setEnabled(true);

        int location = e.getKeyCode();

        System.out.println(e.getKeyCode());
        System.out.println(Integer.toString(location));
        System.out.println(Integer.toString(KeyEvent.VK_LEFT));
        System.out.println(Integer.toString(KeyEvent.VK_RIGHT));
        System.out.println(Integer.toString(KeyEvent.VK_UP));
        System.out.println(Integer.toString(KeyEvent.VK_DOWN));
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
     */
    @Override
    public void keyReleased(KeyEvent e) {}
    
    /**
     * Handle the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {}
    // </editor-fold>  
    
    
    // <editor-fold defaultstate="collapsed" desc="initComponents()">  
    /**
     * This method is called from within the constructor to initialize the form.
     */    
    private void initComponents() {

        p_directionals = new JPanel();
        icon_up = new JLabel();
        icon_right = new JLabel();
        icon_left = new JLabel();
        icon_down = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        icon_up.setIcon(new ImageIcon(getClass().getResource("/user_tools/resources/Arrow_up.jpg"))); // NOI18N
        icon_up.setEnabled(false);

        icon_right.setIcon(new ImageIcon(getClass().getResource("/user_tools/resources/Arrow_right.jpg"))); // NOI18N
        icon_right.setEnabled(false);

        icon_left.setIcon(new ImageIcon(getClass().getResource("/user_tools/resources/Arrow_left.jpg"))); // NOI18N
        icon_left.setEnabled(false);

        icon_down.setIcon(new ImageIcon(getClass().getResource("/user_tools/resources/Arrow_down.jpg"))); // NOI18N
        icon_down.setEnabled(false);

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

    
//    /**
//     * Create the GUI and show it. For thread safety, this method should be
//     * invoked from the event-dispatching thread.
//     */
//    private void createAndShowGUI() {
//        //Create and set up the window.
//        // frame = new ("KeyEventDemo");
//
//
//
//        frame.initComponents2();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Set up the content pane.
//
//
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//        frame.addKeyListener(this);
//    }
} // end class