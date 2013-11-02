/*
 * Interface Providing Image Processing Tool Library.
 */
package swordfish.ui;

// <editor-fold defaultstate="collapsed" desc="Imports">
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Container.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import java.awt.Container.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.*;
import javax.swing.BorderFactory.*;
import javax.swing.GroupLayout.*;
import javax.swing.GroupLayout;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout.*;
import javax.swing.*;


//import swordfish.MobileDirectionDisplay;
import java.sql.Time.*;
//import ij.*;
//import ij.gui.*;
//import ij.io.FileInfo;
//import ij.process.ImageProcessor;
//import java.io.DataInputStream;
import java.io.File;
//import java.io.FileInputStream;
import java.io.*;



import ij.*;
//import ij.process.ByteProcessor;
//import ij.plugin.*;
//import ij.process.*;
//import ij.io.*;
//import ij.measure.*;
import java.awt.Desktop;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//import javax.swing.filechooser.FileNameExtensionFilter;

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
        implements KeyListener, WindowListener, ActionListener {

//    FunctioningMainMenu instance = this;
    ImagePlus im_plus = null;       // This will be the original
    ImagePlus im_plus_rgb = null;   // in the case RGB type is set as conversion
    ImagePlus im_plus_gray = null;      // --- 8-Bit Gray
    int DarkColor = 110;// 64 (correct)
    int BrightColor = 138;
    boolean do_debug = true;
    Process p;
    ImageJ dd;
    String imagej_app_fpath =
            "/Applications/ImageJ/ImageJ64.app/Contents/MacOS/JavaApplicationStub";
    String image_name =
            "/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/hanger_test_image.jpg";
    Desktop ff = null;
    File ff_file = null;
    boolean[] is_im_loaded = new boolean[1];
    boolean[] color_scaler = new boolean[2]; /*  0 - RGB; 1 - 8 Bit
     */


    public FunctioningMainMenu() {

        super("A Robots-eye View");
        //  init();

        buildGui();
//       System.out.printf("About to try\n");
   /*      try {
         Runtime rt = Runtime.getRuntime();
         p = rt.exec(imagej_app_fpath);
         InputStream in = p.getInputStream();
         OutputStream out = p.getOutputStream();
         InputStream err = p.getErrorStream();

         p.destroy();//
         } catch (Exception exc) {
         System.out.printf("Thrown Exception %s\n", exc.getMessage());
         }
         */
        // set flags
        is_im_loaded[0] = false;

        color_scaler[0] = false;
        color_scaler[1] = false;
        set_button_states();

//        System.out.printf("Done trying\n");
    }

    // <editor-fold defaultstate="collapsed" desc="buildGui">
    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void buildGui() {


        // <editor-fold defaultstate="collapsed" desc="Instantiate Components">
        p_live_streaming = new JPanel();
        p_title = new JPanel();
        p_file_handling = new JPanel();
        p_directional = new JPanel();
        p_inspect_tools = new JPanel();
        p_image_disp = new JPanel();

        b_load = new JButton();
        b_save = new JButton();

        l_vid_player = new JLabel();
        jLabel2 = new JLabel();
        l_brightness = new JLabel();
        l_brightness1 = new JLabel();
        l_title = new JLabel();

        canvas2 = new Canvas();

        slide_contrast = new JSlider();
        slide_brightness = new JSlider();


        gr_color_scale = new ButtonGroup();
        rb_gray_scale = new JRadioButton();
        rb_rgb = new JRadioButton();

//        im_plus = new ImagePlus();

        menuBar = new JMenuBar();
        menu_file = new JMenu();
        menu_edit = new JMenu();
        menu_tools = new JMenu();
        menu_help = new JMenu();
        menu_about = new JMenu();


        mnu_open = new JMenuItem();
        mnu_saveas = new JMenuItem();
        mnu_close = new JMenuItem();
        mnu_exit = new JMenuItem();
        // </editor-fold>



        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robotic Vision"); // set title


        // <editor-fold defaultstate="collapsed" desc="Video Stream Panel">
        p_live_streaming.setBorder(BorderFactory.createTitledBorder(null,
                "Live Streaming", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", 1, 14))); //
        p_live_streaming.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        p_live_streaming.setFont(new java.awt.Font("Lucida Grande", 1, 13));



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
        p_title.setFont(new java.awt.Font("Arial", 3, 13));
        l_title.setFont(new java.awt.Font("Lucida Grande", 3, 18));
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
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="File Handling Panel">
        p_file_handling.setBorder(BorderFactory.createTitledBorder(null, "File Handling", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14)));

        b_load.setText("Load");
        b_load.setMaximumSize(new Dimension(45, 29));
        b_load.setMinimumSize(new Dimension(45, 29));
        b_load.setPreferredSize(new Dimension(45, 29));
        b_load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                b_loadActionPerformed(evt);
            }
        });
        b_save.setText("Save");
        b_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
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
        p_image_disp.setBorder(BorderFactory.createTitledBorder(null, "Captured Moment", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14)));

        GroupLayout jPanel5Layout = new GroupLayout(p_image_disp);
        p_image_disp.setLayout(jPanel5Layout);
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

//       p_image_disp.setM
        p_image_disp.setMaximumSize(p_image_disp.getSize());
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Directionals Panel">
        p_directional.setBorder(BorderFactory.createTitledBorder(null, "Directionals", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14)));

        GroupLayout p_directionalLayout = new GroupLayout(p_directional);
        p_directional.setLayout(p_directionalLayout);
        p_directionalLayout.setHorizontalGroup(
                p_directionalLayout.createParallelGroup(Alignment.LEADING)
                .addGap(0, 206, Short.MAX_VALUE));
        p_directionalLayout.setVerticalGroup(
                p_directionalLayout.createParallelGroup(Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE));

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Image Processing Panel">
        p_inspect_tools.setBorder(BorderFactory.createTitledBorder(null, "Inspection Tools", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14)));

        l_brightness.setText("Brightness");

        l_brightness1.setText("Contrast");

        rb_gray_scale.setText("Gray-Scale");
        rb_gray_scale.setToolTipText("View Image as 8-bit gray scale");
//        rb_gray_scale.setSelected(false);
        rb_gray_scale.setActionCommand("Type 8bit");
        rb_gray_scale.addActionListener(this);
//        rb_gray_scale.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                rb_color_scaleActionPerformed(evt);
//            }
//        });

        rb_rgb.setText("RGB");
        rb_rgb.setToolTipText("View image as RGB");
        rb_rgb.setSelected(true);


//        rb_rgb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                rb_color_scaleActionPerformed(evt);
//            }
//        });
        rb_rgb.addActionListener(this);
        rb_rgb.setActionCommand("Type RGB");

        gr_color_scale.add(rb_rgb);
        gr_color_scale.add(rb_gray_scale);

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
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Menu Bar">

        // <editor-fold defaultstate="collapsed" desc="File Dropdown">
        menu_file.setText("File");

        mnu_open.setText("Open...");
//        mnu_open.setToolTipText("");
        mnu_open.setActionCommand("Open...");
        mnu_open.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_fileActionPerformed(evt);
            }
        });
        menu_file.add(mnu_open);

        mnu_saveas.setText("Save As...");
        mnu_saveas.setActionCommand("Save As...");
        mnu_saveas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mnu_fileActionPerformed(evt);
            }
        });
        menu_file.add(mnu_saveas);

        mnu_close.setText("Close");
        mnu_close.setActionCommand("Close");
        mnu_close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mnu_fileActionPerformed(evt);
            }
        });
        menu_file.add(mnu_close);

        mnu_exit.setText("Exit");
        mnu_exit.setActionCommand("Exit");
        mnu_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mnu_fileActionPerformed(evt);
            }
        });
        menu_file.add(mnu_exit);

        menuBar.add(menu_file);

        // </editor-fold>

        menu_edit.setText("Edit");
        menuBar.add(menu_edit);

        menu_tools.setLabel("Tools");
        menuBar.add(menu_tools);

        menu_help.setText("Help");
        menuBar.add(menu_help);

        menu_about.setText("About");
        menuBar.add(menu_about);

        setJMenuBar(menuBar);
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Combined Panel">
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
                .addComponent(p_image_disp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(p_inspect_tools, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        //layout.linkSize(new Component[] {jPanel5, p_inspect_tools}, SwingConstants.HORIZONTAL);
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[]{p_image_disp, p_inspect_tools});


        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(p_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(p_live_streaming, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(p_image_disp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                //                  .addGroup(panel_allLayout.createParallelGroup()
                ///                    .addComponent(panel_fly, GroupLayout.DEFAULT_SIZE,
                //				  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
                .addComponent(p_directional, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p_file_handling, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p_inspect_tools, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));


        layout.linkSize(SwingConstants.VERTICAL, new Component[]{p_image_disp, p_live_streaming});
        // </editor-fold>


        addKeyListener(IJ.getInstance());

        setResizable(false);
        this.pack();
        addWindowListener(this);
        this.setVisible(true);



    }

    // </editor-fold>
    /**
     * Method called to set GUI components according to the flag values.
     *
     */
    private void set_button_states() {
        if (is_im_loaded[0]) {

            if (do_debug) {
                System.out.println("set_button_states(): Image loaded");
            }

            rb_gray_scale.setEnabled(true);
            rb_rgb.setEnabled(true);

        } else {

            if (do_debug) {
                System.out.println("set_button_states(): Image not loaded");
            }
            rb_gray_scale.setSelected(false);
            rb_gray_scale.setEnabled(false);
            rb_rgb.setSelected(false);
            rb_rgb.setEnabled(false);
        }

    }

    /**
     * Listens to the radio buttons.
     */
    public void actionPerformed(ActionEvent evt) {

        String message = evt.getActionCommand();

        if (message.equals("Type 8bit")) {
            if (do_debug) {
                System.out.println("8 - bit RadioButton was pressed");
            }
            im_plus_gray = im_plus.duplicate();
            IJ.run(im_plus_gray, "8-bit", "");
            im_plus.hide();
            im_plus_gray.show();


        } else if (message.equals("Type RGB")) {
            if (do_debug) {
                System.out.println("RGB RadioButton was pressed");
            }
            im_plus_rgb = im_plus.duplicate();
//            IJ.run(im_plus_gray, "8-bit", "");
            im_plus.hide();
            im_plus_rgb.show();
//            im_plus_gray.show();

        }



    }

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
    private boolean load_image(String fpath) {

        boolean ret_val;

        im_plus = IJ.openImage(image_name);
        im_plus.show();

        if (im_plus != null) {
            ret_val = true;
        } else {
            ret_val = false;
        }


        return ret_val;
    }

    //<editor-fold defaultstate="expanded" desc="ComponentListeners">
    private void b_loadActionPerformed(ActionEvent evt) {

        is_im_loaded[0] = load_image(image_name);
//        new ImagePlus("My new image", new ByteProcessor(400, 400)).show();
//        ImagePlus imp = IJ.openImage(image_name);

//        if (!do_debug) {
//            // Set for developing purposes
//            im_plus = IJ.openImage(image_name);
//            im_plus.show();
//
//
//            if (im_plus != null) {
//                is_im_loaded[0] = true;
//            } else {
//                is_im_loaded[0] = false;
//            }
//            set_button_states();
//            return;
//
//        }



        set_button_states();

    }

    private void b_saveActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
//ImagePlus imp = ...
//new FileSaver(imp).saveAsTiff("/path/to/image.tif");
//        File file = new File(image_name);
//        ImagePlus im_plus = IJ.createImage("Test", "RGB black", 258, 338, 1);
        // cur_moment_view.setImage(im_plus.getImage());im_plus
//        IJ.newImage(image_name, image_name, WIDTH, WIDTH, WIDTH);
//        IJ.run("Open...");
//        IJ.log("TEST");
//        IJ.open(image_name);
    }

    private void rb_color_scaleActionPerformed(ActionEvent evt) {

        String message = evt.getActionCommand();

        if (message.equals("Type RGB")) {

            im_plus_rgb = im_plus_rgb.duplicate();



//            IJ.run(im_plus_, "8-bit", "");

            im_plus.hide();
            if (im_plus_gray != null) {


                im_plus_gray = null;
            }
            im_plus_rgb.show();
        } else if (message.equals("Type 8bit")) {

            im_plus_gray = im_plus_rgb.duplicate();



            IJ.run(im_plus_gray, "8-bit", "");

            im_plus.hide();
            if (im_plus_rgb != null) {


                im_plus_rgb = null;
            }
            im_plus_gray.show();

        }
    }

    private void rb_rgbActionPerformed(ActionEvent evt) {
        im_plus_gray.close();
        if (rb_gray_scale.isSelected()) {
            rb_rgb.setSelected(true);
            rb_gray_scale.setSelected(false);
        } else {
            rb_gray_scale.setSelected(true);
            rb_rgb.setSelected(false);
        }
    }

    /**
     * Function called in the event an item under File menu tab is pressed
     *
     * @param evt
     */
    private void mnu_fileActionPerformed(ActionEvent evt) {
        String s_mnu = evt.getActionCommand();
        if (do_debug) {
            System.out.println("File Menu Sub-menu triggered by " + s_mnu);
        }

        if (s_mnu.equals("Open...")) {


            String cur_dir = IJ.getDirectory("current");
            JFileChooser fileopen = new JFileChooser(cur_dir);

            int ret = fileopen.showDialog(new JPanel(), "Open file");

            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();

                if (file.isFile()) {
//                    String fname = file.getName();
                    String fpath = file.getPath();
//                String fpath = dir + fname;
                    im_plus = IJ.openImage(fpath);

                    im_plus.show();

                    if (im_plus != null) {
                        is_im_loaded[0] = true;
                    } else {
                        is_im_loaded[0] = false;
                    }

                    set_button_states();
                    //This is where a real application would open the file.

                    if (do_debug) {
                        System.out.println("Opening: " + fpath);
                    }

                } else {

                    if (do_debug) {
                        System.out.println("Open command cancelled by user.");
                    }

                }

            } else if (ret == JFileChooser.CANCEL_OPTION) {

                if (do_debug) {
                    System.out.print("user cancelled from 'open' dialog box");
                }

            } else {
                if (do_debug) {
                    System.out.print("not approved or cancelled... sweet");
                }
            }
        } else if (s_mnu.equals("Save As...")) {
        } else if (s_mnu.equals("Close")) {
        } else if (s_mnu.equals("Exit")) {
            this.setVisible(false);
            this.dispose();

//            instance = null;
        }



    }
    // </editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Key Listeners">

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
    // </editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Component Declarations">
    Canvas canvas2;
    JButton b_load, b_save;
    JLabel l_title;
    JLabel l_vid_player;
    JMenuBar menuBar;
    JPanel p_title;
    JPanel p_image_disp;
    ButtonGroup gr_color_scale;
    JRadioButton rb_gray_scale, rb_rgb;
    JLabel l_brightness;
    JLabel l_brightness1;
    JMenu menu_about, menu_edit, menu_file, menu_help, menu_tools;
    JMenuItem mnu_close;
    JMenuItem mnu_exit;
    JMenuItem mnu_open;
    JMenuItem mnu_saveas;
    JPanel p_directional, p_file_handling, p_inspect_tools, p_live_streaming;
    JSlider slide_brightness, slide_contrast;
    JLabel icon_down;
    JLabel icon_left;
    JLabel icon_right;
    JLabel icon_up;
    JLabel jLabel2;
    ImageIcon cur_moment_view;
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Main (For Testing/Development)">
    public static void main(String[] args) {
        FunctioningMainMenu fmm = new FunctioningMainMenu();
    }
    // </editor-fold>
}
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

 icon_right.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_right.jpg")));
 icon_right.setEnabled(false);

 icon_left.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_left.jpg")));
 icon_left.setEnabled(false);

 icon_down.setIcon(new ImageIcon(getClass().getResource(dir_image_icons + "Arrow_down.jpg")));
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

