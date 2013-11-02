/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swordfish.ui_develop;

import swordfish.ui.*;
import swordfish.*;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container.*;
import java.awt.event.KeyEvent.*;

import java.io.*;

/**
 *
 * @author jrob
 */
public class MainMenu1 extends JFrame
        implements KeyListener {

    /**
     * Creates new form MainMenu
     */
    private JLabel icon_down;
    private JLabel icon_left;
    private JLabel icon_right;
    private JLabel icon_up;
    private JPanel p_directionals;
    private boolean do_debug = true;

//    private String dir_image_icons = "/resources/";
    // globals
    public MainMenu1() {
        init();
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        p_live_streaming = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        p_file_handling = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        canvas2 = new java.awt.Canvas();
        jLabel2 = new javax.swing.JLabel();
        p_directional = new javax.swing.JPanel();
        p_inspect_tools = new javax.swing.JPanel();
        slide_contrast = new javax.swing.JSlider();
        l_brightness = new javax.swing.JLabel();
        l_brightness1 = new javax.swing.JLabel();
        slide_brightness = new javax.swing.JSlider();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        mnu_open = new javax.swing.JMenuItem();
        mnu_saveas = new javax.swing.JMenuItem();
        mnu_close = new javax.swing.JMenuItem();
        mnu_exit = new javax.swing.JMenuItem();
        menu_edit = new javax.swing.JMenu();
        menu_tools = new javax.swing.JMenu();
        menu_help = new javax.swing.JMenu();
        menu_about = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robotic Vision");

        p_live_streaming.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Live Streaming", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        p_live_streaming.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        p_live_streaming.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabel3.setText("<Media Player>");

        org.jdesktop.layout.GroupLayout p_live_streamingLayout = new org.jdesktop.layout.GroupLayout(p_live_streaming);
        p_live_streaming.setLayout(p_live_streamingLayout);
        p_live_streamingLayout.setHorizontalGroup(
            p_live_streamingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(p_live_streamingLayout.createSequentialGroup()
                .add(152, 152, 152)
                .add(jLabel3)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        p_live_streamingLayout.setVerticalGroup(
            p_live_streamingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(p_live_streamingLayout.createSequentialGroup()
                .add(125, 125, 125)
                .add(jLabel3)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Robotic Vision v0.1");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jLabel1)
                .add(0, 9, Short.MAX_VALUE))
        );

        p_file_handling.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "File Handling", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jButton1.setText("Load");
        jButton1.setMaximumSize(new java.awt.Dimension(45, 29));
        jButton1.setMinimumSize(new java.awt.Dimension(45, 29));
        jButton1.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout p_file_handlingLayout = new org.jdesktop.layout.GroupLayout(p_file_handling);
        p_file_handling.setLayout(p_file_handlingLayout);
        p_file_handlingLayout.setHorizontalGroup(
            p_file_handlingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(p_file_handlingLayout.createSequentialGroup()
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        p_file_handlingLayout.linkSize(new java.awt.Component[] {jButton1, jButton2}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        p_file_handlingLayout.setVerticalGroup(
            p_file_handlingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(p_file_handlingLayout.createSequentialGroup()
                .add(15, 15, 15)
                .add(p_file_handlingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton2))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.getAccessibleContext().setAccessibleName("b_load");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Captured Moment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/hanger_test_image.jpg")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 235, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(6, 6, 6)
                .add(canvas2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(canvas2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6))
        );

        p_directional.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Directionals", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        org.jdesktop.layout.GroupLayout p_directionalLayout = new org.jdesktop.layout.GroupLayout(p_directional);
        p_directional.setLayout(p_directionalLayout);
        p_directionalLayout.setHorizontalGroup(
            p_directionalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 206, Short.MAX_VALUE)
        );
        p_directionalLayout.setVerticalGroup(
            p_directionalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );

        p_inspect_tools.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inspection Tools", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        l_brightness.setText("Brightness");

        l_brightness1.setText("Contrast");

        jRadioButton1.setText("Gray-Scale");
        jRadioButton1.setToolTipText("");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("RGB");
        jRadioButton2.setToolTipText("");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout p_inspect_toolsLayout = new org.jdesktop.layout.GroupLayout(p_inspect_tools);
        p_inspect_tools.setLayout(p_inspect_toolsLayout);
        p_inspect_toolsLayout.setHorizontalGroup(
            p_inspect_toolsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(p_inspect_toolsLayout.createSequentialGroup()
                .add(p_inspect_toolsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(l_brightness1)
                    .add(l_brightness))
                .add(0, 0, Short.MAX_VALUE))
            .add(p_inspect_toolsLayout.createSequentialGroup()
                .add(p_inspect_toolsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(p_inspect_toolsLayout.createSequentialGroup()
                        .add(28, 28, 28)
                        .add(p_inspect_toolsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(slide_brightness, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(slide_contrast, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(p_inspect_toolsLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jRadioButton1)
                        .add(18, 18, 18)
                        .add(jRadioButton2)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_inspect_toolsLayout.setVerticalGroup(
            p_inspect_toolsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(p_inspect_toolsLayout.createSequentialGroup()
                .add(p_inspect_toolsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton1)
                    .add(jRadioButton2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(l_brightness)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(slide_brightness, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(l_brightness1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(slide_contrast, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        menu_file.setText("File");

        mnu_open.setText("Open...");
        mnu_open.setToolTipText("");
        mnu_open.setActionCommand("mnu_file");
        mnu_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_openActionPerformed(evt);
            }
        });
        menu_file.add(mnu_open);

        mnu_saveas.setText("Save As...");
        mnu_saveas.setActionCommand("mnu_file");
        mnu_saveas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_saveasActionPerformed(evt);
            }
        });
        menu_file.add(mnu_saveas);

        mnu_close.setText("Close");
        mnu_close.setActionCommand("mnu_file");
        menu_file.add(mnu_close);

        mnu_exit.setText("Exit");
        mnu_exit.setActionCommand("mnu_file");
        menu_file.add(mnu_exit);

        jMenuBar1.add(menu_file);

        menu_edit.setText("Edit");
        jMenuBar1.add(menu_edit);

        menu_tools.setLabel("Tools");
        jMenuBar1.add(menu_tools);

        menu_help.setText("Help");
        jMenuBar1.add(menu_help);

        menu_about.setText("About");
        jMenuBar1.add(menu_about);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(p_directional, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(p_file_handling, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(p_live_streaming, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(p_inspect_tools, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(p_live_streaming, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, p_directional, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, p_file_handling, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(p_inspect_tools, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void init() {

        // instantiate
        //   p_directionals = new JPanel();
        icon_up = new JLabel();
        icon_right = new JLabel();
        icon_left = new JLabel();
        icon_down = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // System.out.println(System.getProperty("user.dir"));
        // Get images to set as icons on label JComponents;
        // default state disabled
   /*     icon_up.setIcon(new ImageIcon
         (getClass().getResource(dir_image_icons + "Arrow_up.jpg")));
         icon_up.setEnabled(false);

         icon_right.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_right.jpg"))); // NOI18N
         icon_right.setEnabled(false);

         icon_left.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_left.jpg"))); // NOI18N
         icon_left.setEnabled(false);

         icon_down.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_down.jpg"))); // NOI18N
         icon_down.setEnabled(false);
         */
        // Layour components
        org.jdesktop.layout.GroupLayout p_directionalsLayout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(p_directionalsLayout);
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
        /*
         org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(p_directionals, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE));
         layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(p_directionals, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE));
         */
        //       ControllerEnvironment.getDefaultEnvironment().addControllerListener(this);
        addKeyListener(this);


    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void mnu_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_openActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_openActionPerformed

    private void mnu_saveasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_saveasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_saveasActionPerformed

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Handle the key pressed event from the text field. The function checks if
     * event was triggered via arrow keys on keypad. If so, the corresponding
     * arrow icon will be enabled, i.e., will display its true color.
     */
    @Override
    public void keyPressed(KeyEvent e) {

        if (do_debug) {
            System.out.println("Key Press: " + e.toString());
        }


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
     * Handle the key released event from the text field. The function checks if
     * event was triggered via arrow keys on keypad. If so, the corresponding
     * arrow icon will be disabled, i.e., will lose its true color set when key
     * was pressed.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (do_debug) {
            System.out.println("Key Released: " + e.toString());
        }

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
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu1().setVisible(true);
//                new MobileDirectionDisplay().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel l_brightness;
    private javax.swing.JLabel l_brightness1;
    private javax.swing.JMenu menu_about;
    private javax.swing.JMenu menu_edit;
    private javax.swing.JMenu menu_file;
    private javax.swing.JMenu menu_help;
    private javax.swing.JMenu menu_tools;
    private javax.swing.JMenuItem mnu_close;
    private javax.swing.JMenuItem mnu_exit;
    private javax.swing.JMenuItem mnu_open;
    private javax.swing.JMenuItem mnu_saveas;
    private javax.swing.JPanel p_directional;
    private javax.swing.JPanel p_file_handling;
    private javax.swing.JPanel p_inspect_tools;
    private javax.swing.JPanel p_live_streaming;
    private javax.swing.JSlider slide_brightness;
    private javax.swing.JSlider slide_contrast;
    // End of variables declaration//GEN-END:variables

    //  @Override
    //public void actionPerformed(ActionEvent ae) {
    //System.out.println(ae.getSource());
    //System.out.println("eeee");
    //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    private void println(String property) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}