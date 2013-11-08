/*
 * Interface Providing Image Processing Tool Library.
 */
package swordfish.views;

// <editor-fold defaultstate="collapsed" desc="Imports">
import com.google.common.primitives.Chars;
import com.google.common.primitives.Ints;
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
//import java.util.Collections;

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
import ij.measure.Calibration;
import ij.process.ImageProcessor;
import ij.process.ImageStatistics;
//import ij.process.ByteProcessor;
//import ij.plugin.*;
//import ij.process.*;
//import ij.io.*;
//import ij.measure.*;
import java.awt.Desktop;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Properties;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
 * rev 5 Nov 4 - Resize images to fit in panel [230 x 330]
 *
 *
 * @since October 22, 2013
 * @author jrob
 */
public class FunctioningMainMenu extends JFrame
        implements KeyListener, WindowListener, ActionListener {

//    FunctioningMainMenu instance = this;
    ImagePlus im_plus = null;           // This will be the original
    ImagePlus im_plus_rgb = null;       // in the case RGB type is set as conversion
    ImagePlus im_plus_gray = null;      // --- 8-Bit Gray
    int DarkColor = 110;    // 64 (correct)
    int BrightColor = 138;
    int IMG_WIDTH = 275;    // pixels
    int IMG_HEIGHT = 280;   // pixels
    double[] orig_min_max = new double[2];
    boolean do_debug = true;
    Process p;
    ImageJ dd;
    String icon_path = System.getProperty("user.dir") + "/resources/";
//    String imagej_app_fpath =
//            "/Applications/ImageJ/ImageJ64.app/Contents/MacOS/JavaApplicationStub";
    String image_name = icon_path + "hanger_test_image.jpg";
    Desktop ff = null;
    File ff_file = null;
    int window = 255;
    int level = 128;
    boolean[] is_im_loaded = new boolean[1];
    boolean[] color_scaler = new boolean[2]; /*  0 - RGB; 1 - 8 Bit
     */


    public FunctioningMainMenu() {

        super("A Robots-eye View");

        buildGui();

        // set flags
        is_im_loaded[0] = false;

        color_scaler[0] = false;
        color_scaler[1] = false;
        set_button_states();

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
        p_video_buttons = new JPanel();
        p_media_player = new JPanel();

        b_load = new JButton();
        b_save = new JButton();

        lab_record = new JLabel();
        lab_pause = new JLabel();
        lab_stop = new JLabel();

        b_take_image = new JButton();

        l_vid_player = new JLabel();
        lab_imageIcon = new JLabel();
        l_brightness = new JLabel();
        l_brightness1 = new JLabel();
        l_title = new JLabel();
        lab_record = new JLabel();
        lab_pause = new JLabel();
        lab_stop = new JLabel();

        canvas2 = new Canvas();

        slide_contrast = new JSlider();
        slide_brightness = new JSlider();

        gr_color_scale = new ButtonGroup();
        rb_gray_scale = new JRadioButton();
        rb_rgb = new JRadioButton();

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
        p_live_streaming.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        p_live_streaming.setFont(new Font("Lucida Grande", 1, 13));


        l_vid_player.setText("<Media Player>");

//        GroupLayout p_live_streamingLayout = new GroupLayout(p_live_streaming);
//        p_live_streaming.setLayout(p_live_streamingLayout);
//        p_live_streamingLayout.setHorizontalGroup(
//                p_live_streamingLayout.createParallelGroup(Alignment.LEADING)
//                .addGroup(p_live_streamingLayout.createSequentialGroup()
//                .addGap(152, 152, 152)
//                .addComponent(l_vid_player)
//                .addContainerGap(163, Short.MAX_VALUE)));
//        p_live_streamingLayout.setVerticalGroup(
//                p_live_streamingLayout.createParallelGroup(Alignment.LEADING)
//                .addGroup(p_live_streamingLayout.createSequentialGroup()
//                .addGap(125, 125, 125)
//                .addComponent(l_vid_player)
//                .addContainerGap(145, Short.MAX_VALUE)));
//        p_title.setFont(new java.awt.Font("Arial", 3, 13));
//        l_title.setFont(new java.awt.Font("Lucida Grande", 3, 18));
//        l_title.setHorizontalAlignment(SwingConstants.CENTER);
//        l_title.setText("Robotic Vision v0.1");
//
//        GroupLayout p_titleLayout = new GroupLayout(p_title);
//        p_title.setLayout(p_titleLayout);
//        p_titleLayout.setHorizontalGroup(
//                p_titleLayout.createParallelGroup(Alignment.LEADING)
//                .addGroup(Alignment.TRAILING, p_titleLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(l_title, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)));
//        p_titleLayout.setVerticalGroup(
//                p_titleLayout.createParallelGroup(Alignment.LEADING)
//                .addGroup(p_titleLayout.createSequentialGroup()
//                .addComponent(l_title)
//                .addGap(0, 9, Short.MAX_VALUE)));


//        jLabel3.setText("<Media Player>");




        GroupLayout p_media_playerLayout = new GroupLayout(p_media_player);
        p_media_player.setLayout(p_media_playerLayout);
        p_media_playerLayout.setHorizontalGroup(
                p_media_playerLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_media_playerLayout.createSequentialGroup()
                .addGap(146, 146, Short.MAX_VALUE)
                .addComponent(l_vid_player)
                .addGap(146, 146, Short.MAX_VALUE)));
        p_media_playerLayout.setVerticalGroup(
                p_media_playerLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_media_playerLayout.createSequentialGroup()
                .addGap(146, 146, Short.MAX_VALUE)
                .addComponent(l_vid_player)
                .addGap(146, 146, 146)));

        p_video_buttons.setBorder(javax.swing.BorderFactory.createEtchedBorder());


        b_take_image.setIcon(new javax.swing.ImageIcon(icon_path + "media_control_icons/sym_camera.jpg")); // NOI18N
        b_take_image.setBorderPainted(false);
        b_take_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_take_imageActionPerformed(evt);
            }
        });

        lab_record.setIcon(new javax.swing.ImageIcon(icon_path + "media_control_icons/sym_record.jpg")); // NOI18N
        lab_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                recordMousePressed(evt);
            }
        });

        lab_pause.setIcon(new javax.swing.ImageIcon(icon_path + "media_control_icons/sym_pause.jpg")); // NOI18N
        lab_pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                recordMousePressed(evt);
            }
        });

        lab_stop.setIcon(new javax.swing.ImageIcon(icon_path + "media_control_icons/sym_stop.jpg")); // NOI18N
        lab_stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                recordMousePressed(evt);
            }
        });

        GroupLayout p_video_buttonsLayout = new GroupLayout(p_video_buttons);
        p_video_buttons.setLayout(p_video_buttonsLayout);
        p_video_buttonsLayout.setHorizontalGroup(
                p_video_buttonsLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, p_video_buttonsLayout.createSequentialGroup()
                //                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(121, 121, 121)
                .addComponent(b_take_image)
                .addGap(0, 0, 0)
                .addComponent(lab_record)
                //                .addPreferredGap(LayoutStyle.RELATED)
                .addComponent(lab_pause)
                //                .addPreferredGap(LayoutStyle.RELATED)
                .addComponent(lab_stop)
                .addGap(130, 130, 130)));


        p_video_buttonsLayout.setVerticalGroup(
                p_video_buttonsLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, p_video_buttonsLayout.createSequentialGroup()
                .addGroup(p_video_buttonsLayout.createParallelGroup(Alignment.TRAILING)
                //                .addGroup(p_video_buttonsLayout.createParallelGroup(Alignment.LEADING)
                //                .addGap(0, 0, 0)
                //                .addComponent(Alignment.LEADING, lab_stop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                //                .addComponent(Alignment.LEADING, lab_record, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                //                .addComponent(Alignment.LEADING, lab_pause, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                //                .addComponent(Alignment.LEADING, b_take_image, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))//)
                .addComponent(lab_stop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lab_record, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lab_pause, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_take_image, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))//)

                .addContainerGap()));

        GroupLayout p_live_streamingLayout = new GroupLayout(p_live_streaming);
        p_live_streaming.setLayout(p_live_streamingLayout);
        p_live_streamingLayout.setHorizontalGroup(
                p_live_streamingLayout.createParallelGroup(Alignment.LEADING)
                //                .addGroup(p_live_streamingLayout.createSequentialGroup()
                //                .addGroup(p_live_streamingLayout.createParallelGroup(Alignment.LEADING)
                //                .addGroup(p_live_streamingLayout.createSequentialGroup()
                //                .addGroup(p_live_streamingLayout.createParallelGroup(Alignment.LEADING)
                //                .addGroup(p_live_streamingLayout.createSequentialGroup()
                //                .addGap(177, 177, 177)
                //                .addGap(177, 177, 177)
                //  .add(canvas3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                ///       .add(p_live_streamingLayout.createSequentialGroup()
                //     .add(166, 166, 166)
                // .add(canvas4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                /// .add(p_live_streamingLayout.createSequentialGroup()
                /////   .add(152, 152, 152)
                //    .add(canvas1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(p_media_player, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p_video_buttons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));//                .addGap(GroupLayout.DEFAULT_SIZE

        // .addGap(119, 119, 119))))));//.addContainerGap())))));
//                .addGap(119, 119, 119))))));

        p_live_streamingLayout.setVerticalGroup(
                p_live_streamingLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(p_live_streamingLayout.createSequentialGroup()
                .addComponent(p_media_player, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                ///   .add(canvas1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                //////   .add(0, 0, 0)
                ///.add(canvas4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                //.add(0, 0, 0)
                //.add(canvas3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                //.add(0, 0, 0)
                .addComponent(p_video_buttons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                //                .addGap(0, 0 0));
                .addContainerGap()));

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
        lab_imageIcon.setPreferredSize(new Dimension(IMG_WIDTH, IMG_HEIGHT));
        GroupLayout jPanel5Layout = new GroupLayout(p_image_disp);
        p_image_disp.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                //       .addGap(19, 19, 19)//
                .addContainerGap() //235
                .addComponent(lab_imageIcon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                .addComponent(lab_imageIcon)
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

//        slide_contrast.addChangeListener(null);
//        slide_contrast.addChangeListener(new ChangeListener() {
//            public void actionPerformed(ActionEvent evt) {
//                slide_contrastActionPerformed(evt);
//            }
//
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                slide_contrastActionPerformed(e);
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
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

    private void b_take_imageActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void recordMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
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
            slide_contrast.setEnabled(true);

            slide_brightness.setEnabled(true);
            b_save.setEnabled(true);



        } else {

            if (do_debug) {
                System.out.println("set_button_states(): Image not loaded");
            }
            rb_gray_scale.setSelected(false);
            rb_gray_scale.setEnabled(false);
            rb_rgb.setSelected(false);
            rb_rgb.setEnabled(false);
            slide_contrast.setEnabled(false);
            slide_brightness.setEnabled(false);
            b_save.setEnabled(false);
        }


    }

    private void slide_contrastActionPerformed(ChangeEvent evt) {

        JSlider tmp = (JSlider) evt.getSource();
//        tmp.getValue();
        System.out.printf((tmp.getValue()) + "\n");//.getValue()));
        ImageProcessor ff = im_plus.getProcessor();

        double scaled_thres = tmp.getValue() - 50;

//        System.out.printf(Double.toString(orig_min_max[0] * scaled_thres));
        if (scaled_thres >= 0) {
            im_plus.getProcessor().setMinAndMax(orig_min_max[0], orig_min_max[1] * scaled_thres / 100);
            System.out.printf("Max: " + (orig_min_max[1] + scaled_thres) + "\n");//.getValue()));
        } else {
            im_plus.getProcessor().setMinAndMax(orig_min_max[0] * scaled_thres / 100, orig_min_max[1]);
            System.out.printf("Min: " + (orig_min_max[0] - scaled_thres) + "\n");//.getValue()));
//im_plus.getProcessor().
        }




//        Calibration cal = im_plus.getCalibration();
//        im_plus.getProcessor().setMinAndMax(22, 77);

        im_plus.updateAndDraw();

    }
//
//    public static char[] convert(int[] chars) {
//        char[] int = new char[chars.length];
//        for (int i = 0; i < copy.length; i++) {
//            copy[i] = ((chars[i]));
//        }
//        return copy;
//    }

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
//            im_plus.hide();
//            im_plus_gray.show();

            lab_imageIcon.setIcon(new ImageIcon(im_plus_gray.getImage())); // NOI18N



        } else if (message.equals("Type RGB")) {
            if (do_debug) {
                System.out.println("RGB RadioButton was pressed");
            }
            im_plus_rgb = im_plus.duplicate();
//            IJ.run(im_plus_gray, "8-bit", "");
//            im_plus.hide();
//            im_plus_rgb.show();

            lab_imageIcon.setIcon(new ImageIcon(im_plus_rgb.getImage())); // NOI18N

//            im_plus_gray.show();


            int autoThreshold = 0;
            int AUTO_THRESHOLD = 5000;

//            Image imp = im_plus.getImage();

            Calibration cal = im_plus.getCalibration();
//            im_plus.setCalibration(cal);
//            imp.setCalibration("None");
            im_plus.setCalibration(null);
            ImageStatistics stats = im_plus.getStatistics();// # get uncalibrated stats
            im_plus.setCalibration(cal);
            int limit = (stats.pixelCount / 10);
            int[] histogram = stats.histogram;// #int[]
//            for (int i = 0; i < histogram.length; i++) {
//                System.out.printf(MessageFormat.format("{0}  ", Integer.toString(java.lang.Math.max(histogram))));
//            }
//            List b = Arrays.asList(ArrayUtils.toObject(histogram));
//            Character[] b = convert(Array.histogram);
            System.out.println(Ints.min(histogram));
            System.out.println(Ints.max(histogram));
//            return;
//            System.out.println(Collections.max(Arrays.asList(histogram)));
//            System.out.println(Collections.min(b));
//            System.out.println(Collections.max(b));
//            if (autoThreshold < 10) {
//                autoThreshold = AUTO_THRESHOLD;
//            } else {
//            }
////Array.
//            autoThreshold /= 2;
//            int threshold = stats.pixelCount / autoThreshold;
////stats.
////            System.out.printf("count: %d", stats.pixelCount);
//            System.out.printf("count: %d", threshold);
//            System.out.printf("count: %d", limit);
////#int
////print "pixelCount", stats.pixelCount;
//print "threshold", threshold
//print "limit", limit

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
    /**
     *
     */
    private void setImageDefaultSize() {

        ImageProcessor ip_big = im_plus.getProcessor();
        ip_big.setInterpolate(true);
        ImageProcessor ip_small = ip_big.resize(IMG_WIDTH, IMG_HEIGHT);
        ImagePlus small = new ImagePlus("small", ip_small);
        im_plus = small;

    }

    private boolean load_image(String fpath) {

        boolean ret_val;

        im_plus = IJ.openImage(image_name);
//        im_plus.show();

        if (im_plus != null) {
            ret_val = true;
        } else {
            ret_val = false;
        }
        int[] dims = im_plus.getDimensions();

        if (dims[0] != IMG_WIDTH || dims[1] != IMG_HEIGHT) {
            setImageDefaultSize();
        }
        lab_imageIcon.setIcon(new ImageIcon(im_plus.getImage()));
        ImageProcessor proc = im_plus.getProcessor();
        orig_min_max[0] = proc.getMin();
        orig_min_max[1] = proc.getMax();

//        String tmp = im_plus.getProperties().toString();
//        System.out.printf(tmp);

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
//            im_plus_gray.show();

            lab_imageIcon.setIcon(new ImageIcon(im_plus_gray.getImage())); // NOI18N


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


//
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
    JButton b_take_image;
    JLabel l_title;
    JLabel l_vid_player;
    JMenuBar menuBar;
    JPanel p_title;
    JPanel p_image_disp;
    JPanel p_video_buttons;
    JPanel p_media_player;
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
    JLabel lab_imageIcon;
    JLabel lab_pause;
    JLabel lab_record;
    JLabel lab_stop;
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

