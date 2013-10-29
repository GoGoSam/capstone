/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swordfish.ui;
// <editor-fold defaultstate="expanded" desc="Imports">
import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.Container.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import java.awt.Container.*;
import java.awt.event.KeyEvent.*;
import java.awt.Component;
import java.util.logging.*;
import javax.swing.BorderFactory.*;
import javax.swing.GroupLayout.*;
import javax.swing.GroupLayout;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout.*;
import javax.swing.*;
import javax.swing.JSlider;

import swordfish.MobileDirectionDisplay;
import java.sql.Time.*;
import ij.*;
import ij.gui.*;
import ij.io.FileInfo;
import ij.process.ImageProcessor;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.*;



import ij.*;
import ij.plugin.*;
import ij.process.*;
import ij.io.*;
import ij.measure.*;
import java.awt.Desktop;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.zip.GZIPInputStream;

// </editor-fold>
/**
 * /**
 * This Class is the GUI display for the live media (robot vision) and image
 * (moment captured from video) processing/analysis.
 *
 * rev 1 October 22, 2013 - Created Document - Compressed much of the code to
 * reduce length - Added functionality to display image in the appropriate panel
 *
 *
 * @since October 22, 2013
 * @author jrob
 */
public class FunctioningMainMenu extends JFrame
        implements KeyListener, WindowListener {

    JLabel icon_down;
    JLabel icon_left;
    JLabel icon_right;
    JLabel icon_up;
    ImagePlus im_plus;
    JLabel jLabel2;
    ImageIcon cur_moment_view;
    int DarkColor = 110;// 64 (correct)
    int BrightColor = 138;
    boolean do_debug = true;
    Process p;
    ImageJ dd;
    String imagej_app_fpath =
            "/Applications/ImageJ/ImageJ64.app/Contents/MacOS/JavaApplicationStub";
    Desktop ff = null;
    File ff_file = null;
//    jLabel2 = new javax.swing.JLabel();
//    String dir_image_icons = "/resources/";
//    JPanel p_directionals;

    public FunctioningMainMenu() {

        //  init();
        buildGui();
        System.out.printf("About to try\n");
        try {
            Runtime rt = Runtime.getRuntime();
            p = rt.exec(imagej_app_fpath);
            InputStream in = p.getInputStream();
            OutputStream out = p.getOutputStream();
            InputStream err = p.getErrorStream();

            p.destroy();//
        } catch (Exception exc) {
            System.out.printf("Thrown Exception %s\n", exc.getMessage());
        }
        System.out.printf("Done trying\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     *
     */
    // <editor-fold defaultstate="collapsed" desc="buildGui">
    private void buildGui() {


        // <editor-fold defaultstate="collapsed" desc="Instantiate Components">
        p_live_streaming = new JPanel();
        l_vid_player = new JLabel();
        jLabel2 = new JLabel();

        p_title = new JPanel();
        l_title = new JLabel();
        p_file_handling = new JPanel();
        l_brightness = new JLabel();
        l_brightness1 = new JLabel();

        b_load = new JButton();
        b_save = new JButton();


        p_directional = new JPanel();
        p_inspect_tools = new JPanel();
        jPanel5 = new JPanel();

        canvas2 = new Canvas();

        slide_contrast = new JSlider();
        slide_brightness = new JSlider();

        rb_gray_scale = new JRadioButton();
        rb_rgb = new JRadioButton();

        jMenuBar1 = new JMenuBar();
        menu_file = new JMenu();
        menu_edit = new JMenu();
        menu_tools = new JMenu();
        menu_help = new JMenu();
        menu_about = new JMenu();
        im_plus = new ImagePlus();
        // </editor-fold>


        // <editor-fold defaultstate="collapsed" desc="Video Panel">
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robotic Vision");

        p_live_streaming.setBorder(BorderFactory.createTitledBorder(null, "Live Streaming", TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        p_live_streaming.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        p_live_streaming.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        l_vid_player.setText("<Media Player>");

        GroupLayout p_live_streamingLayout = new GroupLayout(p_live_streaming);
        p_live_streaming.setLayout(p_live_streamingLayout);
        p_live_streamingLayout.setHorizontalGroup(
                p_live_streamingLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_live_streamingLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(l_vid_player)
                .addContainerGap(163, Short.MAX_VALUE)));
        p_live_streamingLayout.setVerticalGroup(
                p_live_streamingLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_live_streamingLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(l_vid_player)
                .addContainerGap(145, Short.MAX_VALUE)));

        p_title.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N

        l_title.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        l_title.setHorizontalAlignment(SwingConstants.CENTER);
        l_title.setText("Robotic Vision v0.1");

        GroupLayout p_titleLayout = new GroupLayout(p_title);
        p_title.setLayout(p_titleLayout);
        p_titleLayout.setHorizontalGroup(
                p_titleLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, p_titleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_title, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)));
        p_titleLayout.setVerticalGroup(
                p_titleLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_titleLayout.createSequentialGroup()
                .addComponent(l_title)
                .addGap(0, 9, Short.MAX_VALUE)));

        p_file_handling.setBorder(BorderFactory.createTitledBorder(null, "File Handling", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        b_load.setText("Load");
        b_load.setMaximumSize(new java.awt.Dimension(45, 29));
        b_load.setMinimumSize(new java.awt.Dimension(45, 29));
        b_load.setPreferredSize(new java.awt.Dimension(45, 29));
        b_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loadActionPerformed(evt);
            }
        });

        b_save.setText("Save");
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        GroupLayout p_file_handlingLayout = new GroupLayout(p_file_handling);
        p_file_handling.setLayout(p_file_handlingLayout);
        p_file_handlingLayout.setHorizontalGroup(
                p_file_handlingLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_file_handlingLayout.createSequentialGroup()
                .addComponent(b_load, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_save, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)));

        //  p_file_handlingLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {b_load, b_save}, );

        p_file_handlingLayout.linkSize(SwingConstants.HORIZONTAL, new Component[]{b_load, b_save});


        p_file_handlingLayout.setVerticalGroup(
                p_file_handlingLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_file_handlingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(p_file_handlingLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(b_load, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(b_save))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        b_load.getAccessibleContext().setAccessibleName("b_load");
        // </editor-fold>


        // <editor-fold defaultstate="collapsed" desc="Image Viewer">
        jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Captured Moment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                //       .addGap(19, 19, 19)//
                .addContainerGap() //235
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(canvas2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                //.addContainerGap(262, Short.MAX_VALUE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                //  .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
                //  .addGap(0, 206, Short.MAX_VALUE)
                .addComponent(jLabel2)
                //               .addComponent(kk)
                .addComponent(canvas2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                // .addContainerGap(276, Short.MAX_VALUE))
                .addGap(6, 6, 6))));

//       jPanel5.setM
        jPanel5.setMaximumSize(jPanel5.getSize());
        // </editor-fold>


        p_directional.setBorder(BorderFactory.createTitledBorder(null, "Directionals", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        GroupLayout p_directionalLayout = new GroupLayout(p_directional);
        p_directional.setLayout(p_directionalLayout);
        p_directionalLayout.setHorizontalGroup(
                p_directionalLayout.createParallelGroup(Alignment.LEADING)
                .addGap(0, 206, Short.MAX_VALUE));
        p_directionalLayout.setVerticalGroup(
                p_directionalLayout.createParallelGroup(Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE));

        p_inspect_tools.setBorder(BorderFactory.createTitledBorder(null, "Inspection Tools", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        l_brightness.setText("Brightness");

        l_brightness1.setText("Contrast");

        rb_gray_scale.setText("Gray-Scale");
        rb_gray_scale.setToolTipText("");
        rb_gray_scale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_gray_scaleActionPerformed(evt);
            }
        });

        rb_rgb.setText("RGB");
        rb_rgb.setToolTipText("");
        rb_rgb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_rgbActionPerformed(evt);
            }
        });

        GroupLayout p_inspect_toolsLayout = new GroupLayout(p_inspect_tools);
        p_inspect_tools.setLayout(p_inspect_toolsLayout);
        p_inspect_toolsLayout.setHorizontalGroup(
                p_inspect_toolsLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_inspect_toolsLayout.createSequentialGroup()
                .addGroup(p_inspect_toolsLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(l_brightness1)
                .addComponent(l_brightness))
                .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(p_inspect_toolsLayout.createSequentialGroup()
                .addGroup(p_inspect_toolsLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_inspect_toolsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(p_inspect_toolsLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(slide_brightness, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(slide_contrast, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGroup(p_inspect_toolsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_gray_scale)
                .addGap(18, 18, 18)
                .addComponent(rb_rgb)))
                .addContainerGap(63, Short.MAX_VALUE)));
        p_inspect_toolsLayout.setVerticalGroup(
                p_inspect_toolsLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_inspect_toolsLayout.createSequentialGroup()
                .addGroup(p_inspect_toolsLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(rb_gray_scale)
                .addComponent(rb_rgb))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_brightness)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slide_brightness, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_brightness1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slide_contrast, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE)));

        menu_file.setText("File");
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(p_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) //
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(p_directional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)//
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(p_file_handling, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addComponent(p_live_streaming, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(p_inspect_tools, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        //layout.linkSize(new Component[] {jPanel5, p_inspect_tools}, SwingConstants.HORIZONTAL);
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[]{jPanel5, p_inspect_tools});


        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(p_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(p_live_streaming, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                //                  .addGroup(panel_allLayout.createParallelGroup()
                ///                    .addComponent(panel_fly, GroupLayout.DEFAULT_SIZE,
                //				  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
                .addComponent(p_directional, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p_file_handling, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p_inspect_tools, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));


        layout.linkSize(SwingConstants.VERTICAL, new Component[]{jPanel5, p_live_streaming});

        // layout.linkSize(SwingConstants.VERTICAL, new Component[] {jPanel5, p_live_streaming}, );
//panel_dirLayout.linkSize
//	    (SwingConstants.VERTICAL, new Component[]
//		{text_dir_prefix, text_label_extension, text_synf_extension});
        this.pack();
        addWindowListener(this);
        this.setVisible(true);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="WindowListeners">
    @Override
    public void windowClosing(WindowEvent e) {
        p.destroy();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

//    public void windowGainedFocus(WindowEvent e) {    }
//    public void windowLostFocus(WindowEvent e) {
//    }
//
//    public void windowStateChanged(WindowEvent e) {
//    }
    // </editor-fold>
    /**
     * This method is called from within the constructor to initialize the
     * components and listeners.
     */
    /*
     // <editor-fold defaultstate="collapsed" desc="init">
     private void init(){

     // instantiate
     //   p_directionals = new JPanel();
     icon_up = new JLabel();
     icon_right = new JLabel();
     icon_left = new JLabel();
     icon_down = new JLabel();

     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     */
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
    /*
     GroupLayout p_directionalsLayout = new GroupLayout(getContentPane());
     getContentPane().setLayout(p_directionalsLayout);
     p_directionalsLayout.setHorizontalGroup(
     p_directionalsLayout.createParallelGroup(Alignment.LEADING)
     .addGroup(p_directionalsLayout.createSequentialGroup()
     .addContainerGap()
     .addComponent(icon_left, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
     .addGroup(p_directionalsLayout.createParallelGroup(Alignment.LEADING)
     .addComponent(icon_up, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
     .addComponent(icon_down))
     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
     .addComponent(icon_right)
     .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
     p_directionalsLayout.setVerticalGroup(
     p_directionalsLayout.createParallelGroup(Alignment.LEADING)
     .addGroup(p_directionalsLayout.createSequentialGroup()
     .addContainerGap()
     .addGroup(p_directionalsLayout.createParallelGroup(Alignment.LEADING)
     .addGroup(p_directionalsLayout.createSequentialGroup()
     .addComponent(icon_up)
     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
     .addComponent(icon_down))
     .addGroup(p_directionalsLayout.createSequentialGroup()
     .addGap(41, 41, 41)
     .addGroup(p_directionalsLayout.createParallelGroup(Alignment.LEADING)
     .addComponent(icon_right)
     .addComponent(icon_left))))
     .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

     icon_up.getAccessibleContext().setAccessibleName("U");
     icon_left.getAccessibleContext().setAccessibleName("Up");
     icon_down.getAccessibleContext().setAccessibleName("L_down");
     *//*
     GroupLayout layout = new GroupLayout(getContentPane());
     getContentPane().setLayout(layout);
     layout.setHorizontalGroup(
     layout.createParallelGroup(Alignment.LEADING)
     .add(p_directionals, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
     layout.setVerticalGroup(
     layout.createParallelGroup(Alignment.LEADING)
     .add(p_directionals, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
     */
    /*        //       ControllerEnvironment.getDefaultEnvironment().addControllerListener(this);
     addKeyListener(this);


     }*/
    // </editor-fold>

    private void b_loadActionPerformed(java.awt.event.ActionEvent evt) {
        try {

            ff = Desktop.getDesktop();
            /* Runtime r=Runtime.getRuntime();
             //    Process p=null;
             String s="MyLineInInput.app";
             try {
             p = r.exec(s);
             */
            ff.open(new File(imagej_app_fpath));
            ff_file = new File(imagej_app_fpath);

            Class<?>[] tt = ff.getClass().getClasses();

            for (int i = 0; i < tt.length; i++) {
                System.out.println(Integer.toString(i) + ": " + tt[i].toString());
            }
        } catch (IOException ex) {
            System.err.print(ex.getMessage());
        } catch (IllegalArgumentException ee) {
            System.err.printf(ee.getMessage());
        }
    }

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String image_name = "/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/hanger_test_image.jpg";

        File file = new File(image_name);
        im_plus = IJ.createImage("Test", "RGB black", 258, 338, 1);


        FileInfo fi = getHeaderInfo(image_name);

        //    int COL = fi.width;


// Analyze_Reader rr = new Analyze_Reader();
        // cur_moment_view.setImage(im_plus.getImage());im_plus
        IJ.newImage(image_name, image_name, WIDTH, WIDTH, WIDTH);
        IJ.run("Open...");
        IJ.log("TEST");

        IJ.open(image_name);
        IJ.log("TEST");

        //    im_plus.show();
        // cur_moment_view =
        //       new ImageIcon();
        //ImagePlus jj = new ImagePlus("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/hanger_test_image.jpg");
        //kk.setImage(jj);
//        cur_moment_view.
        // jLabel2.setIcon(kk.clone());//cur_moment_view);

    }

    private void rb_gray_scaleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void rb_rgbActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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

    //<editor-fold defaultstate="collapsed" desc="getHeaderInfo() ">
    FileInfo getHeaderInfo(String name_to_read) //throws IOException
    {
        int anUnsignedShort = 0;
        int magicNumber = 0;
        int nim = 0;

        int firstByte = 0;
        int secondByte = 0;

        byte bb;

        FileInfo fi = null;

        int col = 0;
        int row = 0;

        try {
            DataInputStream ins_head;

            if (name_to_read.toLowerCase().endsWith("jpg")) {
                ins_head =
                        new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(name_to_read))));
            } else {
                ins_head =
                        new DataInputStream(new BufferedInputStream(new FileInputStream(name_to_read)));
            }

            for (int k = 0; k < 300; k++) {
                bb = ins_head.readByte();
                firstByte = (0x000000FF & ((int) bb));
                bb = ins_head.readByte();
                secondByte = (0x000000FF & ((int) bb));
                anUnsignedShort = (int) (secondByte | firstByte << 8);

                /*
                 if(do_debug==1)
                 IJ.log(" " + Integer.toString(firstByte) + " " + Integer.toString(secondByte));

                 if(do_debug==1)
                 IJ.log("read header " + Integer.toString(anUnsignedShort));
                 */
                if (k == 0) {
                    magicNumber = anUnsignedShort;
                }

                if (k == 1) {
                    nim = anUnsignedShort;
                }

                if (k == 296) {
                    col = anUnsignedShort;
                }

                if (k == 297) {
                    row = anUnsignedShort;
                }
            }
        } catch (Throwable e1) {
            //	 IJ.showStatus("");
//	 	 IJ.showMessage("CTL_viewer", ""+e1);
            // label_flag[0] = true;
//	 if(do_debug == 1)
//	     IJ.log("Problem header info " + e1.getMessage());
            return fi;
        }

        if (magicNumber != 12431) {
            IJ.showStatus("NOT MI:" + name_to_read);
            IJ.showMessage("NOT MI:" + name_to_read);
//	 if(do_debug ==1)
//	     IJ.log("NOT MI:"+name_to_read);

//	 b_open_state[0] = true;
//	 set_button_states();

            return fi;
        }

        //     if(do_debug==1) IJ.log("READ MAGIC: "+Integer.toString(magicNumber));
        //    if(do_debug==1) IJ.log("READ N: "+Integer.toString(nim));

        fi = new FileInfo();
        fi.width = col;
        fi.height = row;
        fi.nImages = nim;

        return fi;

    }
// </editor-fold>
    /**
     * @param args the command line arguments
     */
    /*
     public static void main(String args[]) {



     java.awt.EventQueue.invokeLater(new Runnable() {
     @Override
     public void run() {
     new MainMenu().setVisible(true);
     new MobileDirectionDisplay().setVisible(true);
     }
     });
     }*/
    // Variables declaration - do not modify
    private java.awt.Canvas canvas2;
    private JButton b_load;
    private JButton b_save;
    private JLabel l_title;
    private JLabel l_vid_player;
//    private JLabel jLabel2;
    private JMenuBar jMenuBar1;
    private JPanel p_title;
    private JPanel jPanel5;
    private JRadioButton rb_gray_scale;
    private JRadioButton rb_rgb;
    private JLabel l_brightness;
    private JLabel l_brightness1;
    private JMenu menu_about;
    private JMenu menu_edit;
    private JMenu menu_file;
    private JMenu menu_help;
    private JMenu menu_tools;
    private JPanel p_directional;
    private JPanel p_file_handling;
    private JPanel p_inspect_tools;
    private JPanel p_live_streaming;
    private JSlider slide_brightness;
    private JSlider slide_contrast;
    // End of variables declaration
    //  @Override
    //public void actionPerformed(ActionEvent ae) {
    //System.out.println(ae.getSource());
    //System.out.println("eeee");
    //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

/**
 * This plugin loads Analyze format files. It parses the header file found in
 * '<filename>.hdr' and uses this to appropriately load the raw image data found
 * in '<filename>.img'. - Loads either big or little endian format. - Requires
 * ImageJ 1.16 or later * Guy Williams, gbw1000@wbic.cam.ac.uk 23/9/99
 */
class Analyze_Reader extends ImagePlus {// implements PlugIn {

    public boolean littleEndian = false;

    public void run(String arg) {
        OpenDialog od = new OpenDialog("Open Analyze...", arg);
        String directory = od.getDirectory();
        String name = od.getFileName();
        if (name == null) {
            return;
        }
        IJ.showStatus("Opening: " + directory + name);
        FileInfo fi = load(directory, name);
        FileOpener fo = new FileOpener(fi);
        ImagePlus imp = fo.open(false);
        if (imp == null) {
            return;
        }
        ImageStack stack = imp.getStack();
        for (int i = 1; i <= stack.getSize(); i++) {
            ImageProcessor ip = stack.getProcessor(i);
            ip.flipVertical();
        }
        if (imp.getStackSize() > 1) {
            setStack(name, stack);
        } else {
            setProcessor(name, imp.getProcessor());
        }
        setCalibration(imp.getCalibration());
        setFileInfo(fi); // needed for revert
        if (arg.equals("")) {
            show();
        }
    }

    FileInfo load(String directory, String name) {
        FileInfo fi = new FileInfo();
        if ((name == null) || (name == "")) {
            return null;
        }
        if (name.endsWith(".img") || name.endsWith(".IMG")) {
            name = name.substring(0, name.length() - 4);
        }
        if (name.endsWith(".hdr") || name.endsWith(".HDR")) {
            name = name.substring(0, name.length() - 4);
        }
        IJ.showStatus("Loading Analyze File: " + directory + name);
        try {
            fi = readHeader(directory + name + ".hdr");
        } catch (IOException e) {
            IJ.log("Analyze Reader: " + e.getMessage());
        }
        fi.fileName = name + ".img";
        fi.directory = directory;
        fi.fileFormat = fi.RAW;
        return fi;
    }

    public FileInfo readHeader(String hdrfile) throws IOException {
        FileInputStream filein = new FileInputStream(hdrfile);
        DataInputStream input = new DataInputStream(filein);
        FileInfo fi = new FileInfo();
        byte[] units = new byte[4];

        this.littleEndian = false;

        int i;
        short bitsallocated, datatype;
// In order to get the sliceSpacing, ImagePlus has been altered

//  header_key

        input.readInt(); 				// sizeof_hdr
        for (i = 0; i < 10; i++) {
            input.read();		// data_type
        }
        for (i = 0; i < 18; i++) {
            input.read(); 		// db_name
        }
        input.readInt(); 				// extents
        input.readShort(); 			// session_error
        input.readByte();				// regular
        input.readByte(); 				// hkey_un0

// image_dimension

        short endian = readShort(input);		// dim[0]
        if ((endian < 0) || (endian > 15)) {
            littleEndian = true;
            fi.intelByteOrder = true;
        }
        fi.width = readShort(input);		// dim[1]
        fi.height = readShort(input);		// dim[2]
        fi.nImages = readShort(input);		// dim[3]
        input.readShort();				// dim[4]
        for (i = 0; i < 3; i++) {
            input.readShort();	// dim[5-7]
        }
        input.read(units, 0, 4); 			// vox_units
        fi.unit = new String(units, 0, 4);
        for (i = 0; i < 8; i++) {
            input.read();		// cal_units[8]
        }
        input.readShort();				// unused1
        datatype = readShort(input);		// datatype
        bitsallocated = readShort(input);		// bitpix
        input.readShort();				// dim_un0
        input.readFloat();				// pixdim[0]
        fi.pixelWidth = (double) readFloat(input);	// pixdim[1]
        fi.pixelHeight = (double) readFloat(input); // pixdim[2]
        fi.pixelDepth = (double) readFloat(input); 	// pixdim[3]
        for (i = 0; i < 4; i++) {
            input.readFloat();	// pixdim[4-7]
        }
        fi.offset = (int) readFloat(input);			// vox_offset
        input.readFloat();				// roi_scale
        input.readFloat();				// funused1
        input.readFloat();				// funused2
        input.readFloat();				// cal_max
        input.readFloat();				// cal_min
        input.readInt();				// compressed
        input.readInt();				// verified
        //   ImageStatistics s = imp.getStatistics();
        readInt(input);	//(int) s.max		// glmax
        readInt(input);	//(int) s.min		// glmin

// data_history

        for (i = 0; i < 80; i++) {
            input.read();		// descrip
        }
        for (i = 0; i < 24; i++) {
            input.read();		// aux_file
        }
        input.read();				// orient
        for (i = 0; i < 10; i++) {
            input.read();		// originator
        }
        for (i = 0; i < 10; i++) {
            input.read();		// generated
        }
        for (i = 0; i < 10; i++) {
            input.read();		// scannum
        }
        for (i = 0; i < 10; i++) {
            input.read();		// patient_id
        }
        for (i = 0; i < 10; i++) {
            input.read();		// exp_date
        }
        for (i = 0; i < 10; i++) {
            input.read();		// exp_time
        }
        for (i = 0; i < 3; i++) {
            input.read();		// hist_un0
        }
        input.readInt();				// views
        input.readInt();				// vols_added
        input.readInt();				// start_field
        input.readInt();				// field_skip
        input.readInt();				// omax
        input.readInt();				// omin
        input.readInt();				// smax
        input.readInt();				// smin

        input.close();
        filein.close();

        switch (datatype) {

            case 2:
                fi.fileType = FileInfo.GRAY8; 			// DT_UNSIGNED_CHAR
                bitsallocated = 8;
                break;
            case 4:
                fi.fileType = FileInfo.GRAY16_SIGNED; 		// DT_SIGNED_SHORT
                bitsallocated = 16;
                break;
            case 8:
                fi.fileType = FileInfo.GRAY32_INT; 		// DT_SIGNED_INT
                bitsallocated = 32;
                break;
            case 16:
                fi.fileType = FileInfo.GRAY32_FLOAT; 		// DT_FLOAT
                bitsallocated = 32;
                break;
            case 128:
                fi.fileType = FileInfo.RGB_PLANAR; 		// DT_RGB
                bitsallocated = 24;
                break;
            default:
                fi.fileType = 0;					// DT_UNKNOWN
        }

        return (fi);
    }

    public int readInt(DataInputStream input) throws IOException {
        if (!littleEndian) {
            return input.readInt();
        }
        byte b1 = input.readByte();
        byte b2 = input.readByte();
        byte b3 = input.readByte();
        byte b4 = input.readByte();
        return ((((b4 & 0xff) << 24) | ((b3 & 0xff) << 16) | ((b2 & 0xff) << 8) | (b1 & 0xff)));
    }

    public short readShort(DataInputStream input) throws IOException {
        if (!littleEndian) {
            return input.readShort();
        }
        byte b1 = input.readByte();
        byte b2 = input.readByte();
        return ((short) (((b2 & 0xff) << 8) | (b1 & 0xff)));
    }

    public float readFloat(DataInputStream input) throws IOException {
        if (!littleEndian) {
            return input.readFloat();
        }
        int orig = readInt(input);
        return (Float.intBitsToFloat(orig));
    }
}
