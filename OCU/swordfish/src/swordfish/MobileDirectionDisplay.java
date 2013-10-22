package swordfish;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author S. Coe and J. Robinson
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

    private static final long serialVersionUID = 1L;
    private JLabel icon_down;
    private JLabel icon_left;
    private JLabel icon_right;
    private JLabel icon_up;
    private JPanel p_directionals;
    private boolean debug = false;
    private boolean keyPressed = false;
    private String dir_image_icons = ".../resources/";

    /**
     * Creates new form Controls_Display
     */
    public MobileDirectionDisplay() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

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

        if (debug)
            System.out.println("Key Press: " + e.toString());

        if (keyPressed)
            return;

        int location = e.getKeyCode();

        if (location == KeyEvent.VK_LEFT) {
            //client.writeToSocket("L");
            icon_left.setEnabled(true);
            keyPressed = true;
        } else if (location == KeyEvent.VK_RIGHT) {
            //client.writeToSocket("R");
            icon_right.setEnabled(true);
            keyPressed = true;
        } else if (location == KeyEvent.VK_UP) {
            //client.writeToSocket("F");
            icon_up.setEnabled(true);
            keyPressed = true;
        } else if (location == KeyEvent.VK_DOWN) {
            //client.writeToSocket("B");
            icon_down.setEnabled(true);
            keyPressed = true;
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
        if (debug)
            System.out.println("Key Released: " + e.toString());

        int location = e.getKeyCode();

        if (location == KeyEvent.VK_LEFT) {
            //client.writeToSocket("S");
            icon_left.setEnabled(false);
            keyPressed = false;
        } else if (location == KeyEvent.VK_RIGHT) {
            //client.writeToSocket("S");
            icon_right.setEnabled(false);
            keyPressed = false;
        } else if (location == KeyEvent.VK_UP) {
            //client.writeToSocket("S");
            icon_up.setEnabled(false);
            keyPressed = false;
        } else if (location == KeyEvent.VK_DOWN) {
            //client.writeToSocket("S");
            icon_down.setEnabled(false);
            keyPressed = false;
        }
    }

    /**
     * Handle the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {}

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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Get images to set as icons on label JComponents;
        // default state disabled
        icon_up.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_up.jpg")));
        icon_up.setEnabled(false);
        icon_right.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_right.jpg")));
        icon_right.setEnabled(false);
        icon_left.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_left.jpg")));
        icon_left.setEnabled(false);
        icon_down.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_down.jpg")));
        icon_down.setEnabled(false);

        // Layout components
        javax.swing.GroupLayout p_directionalsLayout = new javax.swing.GroupLayout(p_directionals);
        p_directionals.setLayout(p_directionalsLayout);
        p_directionalsLayout.setHorizontalGroup(
                p_directionalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p_directionalsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(icon_left, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_directionalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(icon_up, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(icon_down))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(icon_right)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        p_directionalsLayout.setVerticalGroup(
                p_directionalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p_directionalsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(p_directionalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(p_directionalsLayout.createSequentialGroup()
                                                .addComponent(icon_up)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(icon_down))
                                        .addGroup(p_directionalsLayout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addGroup(p_directionalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(icon_right)
                                                        .addComponent(icon_left))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        icon_up.getAccessibleContext().setAccessibleName("U");
        icon_left.getAccessibleContext().setAccessibleName("Up");
        icon_down.getAccessibleContext().setAccessibleName("L_down");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(p_directionals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(p_directionals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        addKeyListener(this);
        pack();
        //setVisible(true);
    }
}
