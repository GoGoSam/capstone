/**
 *
 */
package swordfish.views;

//import swordfish.ui_develop.*;
//import swordfish;
//import com.sun.jna.Native;
//import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Container.*;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Color;
//import java.awt.Desktop;
import java.awt.Dimension;

import java.awt.event.KeyEvent.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import javax.swing.border.*;
import javax.swing.*;
import javax.swing.LayoutStyle.*;
import javax.swing.WindowConstants;
//import uk.co.caprica.vlcj.binding.LibVlc;
//import uk.co.caprica.vlcj.player.MediaPlayerFactory;
//import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
//import uk.co.caprica.vlcj.runtime.RuntimeUtil;

//import java.awt.BorderLayout;
//import java.awt.Canvas;
//import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import ij.IJ;
import java.awt.FileDialog;
import java.io.File;

//import uk.co.caprica.vlcj.binding.LibVlc;
//import uk.co.caprica.vlcj.player.MediaPlayerFactory;
//import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
//import uk.co.caprica.vlcj.runtime.RuntimeUtil;
//
//import com.sun.jna.Native;
//import com.sun.jna.NativeLibrary;
/*
 import javax.media.*; //media.*;
 import java.io.File;
 import java.awt.*;
 import java.net.MalformedURLException;
 import java.net.URL;*/
/**
 *
 * @author jrob
 */
public class InspectorRobot extends JFrame
        implements KeyListener, WindowListener {

    /**
     * Creates new form MainMenu
     */
    private JLabel icon_down;
    private JLabel icon_left;
    private JLabel icon_right;
    private JLabel icon_up;
    private JPanel p_directionals;
    private boolean do_debug = true;
    MediaPlayerHandle media_pan;

    String icon_path = System.getProperty("user.dir") + "/resources/";

//    Player pp;
//    private String dir_image_icons = "/resources/";
    // globals
    public InspectorRobot() {
        buildGui();
        media_pan = new MediaPlayerHandle();
        JPanel ppp = media_pan.getF();
        ppp.setSize(p_media_player.getSize());
        p_media_player.add(ppp);
        media_pan.playz();

    }

// <editor-fold defaultstate="collapsed" desc="buildGui">
    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void buildGui() {

        // <editor-fold defaultstate="collapsed" desc="Instantiate Components">
        jMenuItem1 = new JMenuItem();

        pan_top_level = new JPanel();
        pan_2nd_level_sw = new JPanel();
        pan_vision_utils = new JPanel();
        pan_image_file_buttons = new JPanel();
        pan_2nd_level_top = new JPanel();
        pan_video_stream = new JPanel();
        p_media_player = new JPanel();
        jPanel1 = new JPanel();
        pan_3rd_level_south = new JPanel();
        pan_vid_controls = new JPanel();
        jPanel3 = new JPanel();
        pan_logo_icons = new JPanel();
        pan_sys_status = new JPanel();
        pan_data_logging = new JPanel();
        jPanel14 = new JPanel();
        pan_com_buttons = new JPanel();
        pan_dDisplay = new JPanel();
        pan_middle_sys_utils = new JPanel();
        pan_top_sys_utils = new JPanel();

        b_scan_hanger = new JButton();
        b_inspect_ceiling = new JButton();
        b_look_around = new JButton();
        b_snap_image = new JButton();
        b_save_image = new JButton();
        b_open_image = new JButton();
        b_close_image = new JButton();
        b_load = new JButton();
        b_archive = new JButton();
        b_set_flag = new JButton();
        b_reset = new JButton();
        b_connect = new JButton();
        b_close = new JButton();

        l_capture_moment = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        l_logo = new JLabel();
        l_vid_con_icons = new JLabel();
        jLabel5 = new JLabel();
        jLabel1 = new JLabel();
        l_plenum_map = new JLabel();
        l_logging_per = new JLabel();
        l_log_file = new JLabel();
        l_data_logging = new JLabel();
        jLabel8 = new JLabel();
        l_vid_sig_per = new JLabel();
        l_cam_sig_per = new JLabel();
        l_vid_signal = new JLabel();
        l_battery_per = new JLabel();
        l_battery = new JLabel();
        l_robo_conn_per = new JLabel();
        l_robo_connect = new JLabel();
        l_r_id = new JLabel();
        l_src_ip = new JLabel();
        l_dest_ip = new JLabel();
        l_host_ip = new JLabel();

        canvas1 = new Canvas();
        canvas3 = new Canvas();
        canvas4 = new Canvas();

        sb_logging = new JProgressBar();
        sb_camera_signal = new JProgressBar();
        sb_video_signal = new JProgressBar();
        sb_battery = new JProgressBar();
        sb_robo_connection = new JProgressBar();
        pb_load_image = new JProgressBar();

        cb_object_aware = new JCheckBox();
        cb_do_log = new JCheckBox();

        tf_r_id = new JTextField();
        tf_ip = new JTextField();
        tf_log_dump_file = new JTextField();

        combox_src_ip = new JComboBox();
        combox_dest_ip = new JComboBox();

        jMenuBar1 = new JMenuBar();
        mnu_open = new JMenuItem();
        mnu_saveas = new JMenuItem();
        mnu_close = new JMenuItem();
        mnu_exit = new JMenuItem();

        menu_file = new JMenu();
        menu_edit = new JMenu();
        menu_tools = new JMenu();
        menu_help = new JMenu();
        menu_about = new JMenu();
// </editor-fold>

        jMenuItem1.setText("jMenuItem1");

        // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inspector Robot"); // set title

        // <editor-fold defaultstate="collapsed" desc="Vision Utils">
        pan_vision_utils.setBorder(BorderFactory.createTitledBorder(null, "Vision Utils", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14)));

        b_scan_hanger.setText("Scan Hanger");

        b_inspect_ceiling.setText("Inspect Ceiling");
        b_inspect_ceiling.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_inspect_ceilingActionPerformed(evt);
            }
        });

        b_look_around.setText("Do Look Around");
        b_look_around.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_look_aroundActionPerformed(evt);
            }
        });

        cb_object_aware.setText("Object Aware");
        cb_object_aware.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cb_object_awareActionPerformed(evt);
            }
        });

        l_capture_moment.setText("Capture Moment");

        b_snap_image.setIcon(new ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/video_image_control_icons/camera_icon.jpg"));
        b_snap_image.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_snap_imageActionPerformed(evt);

            }
        });

        b_save_image.setText("Save");
        b_save_image.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_save_imageActionPerformed(evt);
            }
        });

        b_open_image.setText("Open");
        b_open_image.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                b_open_imageActionPerformed(evt);
            }
        });

        b_close_image.setText("Close");

        GroupLayout pan_image_file_buttonsLayout = new GroupLayout(pan_image_file_buttons);
        pan_image_file_buttons.setLayout(pan_image_file_buttonsLayout);
        pan_image_file_buttonsLayout.setHorizontalGroup(
                pan_image_file_buttonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_image_file_buttonsLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_open_image)
                        .addGap(18, 18, 18)
                        .addComponent(b_save_image)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(b_close_image)
                        .addGap(12, 12, 12))
        );

        pan_image_file_buttonsLayout.linkSize(SwingConstants.HORIZONTAL, new Component[]{b_open_image, b_save_image, b_close_image});

        pan_image_file_buttonsLayout.setVerticalGroup(
                pan_image_file_buttonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_image_file_buttonsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_image_file_buttonsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(b_open_image)
                                .addComponent(b_save_image)
                                .addComponent(b_close_image))
                        .addContainerGap())
        );

        GroupLayout pan_vision_utilsLayout = new GroupLayout(pan_vision_utils);
        pan_vision_utils.setLayout(pan_vision_utilsLayout);
        pan_vision_utilsLayout.setHorizontalGroup(
                pan_vision_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_vision_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                                        .addGroup(pan_vision_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(cb_object_aware, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(b_look_around, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(b_inspect_ceiling, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(b_scan_hanger, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(pan_vision_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                        .addComponent(l_capture_moment)
                                                        .addContainerGap(12, Short.MAX_VALUE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, pan_vision_utilsLayout.createSequentialGroup()
                                                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(b_snap_image)
                                                        .addGap(25, 25, 25))))
                                .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                                        .addComponent(pan_image_file_buttons, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pb_load_image, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
        );
        pan_vision_utilsLayout.setVerticalGroup(
                pan_vision_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pan_vision_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                                        .addComponent(b_snap_image)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(l_capture_moment))
                                .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                                        .addComponent(b_scan_hanger)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(b_inspect_ceiling)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(b_look_around)
                                        .addGap(7, 7, 7)
                                        .addComponent(cb_object_aware)))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(pan_image_file_buttons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(pb_load_image, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
        );
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Panel Builds">
        pan_vid_controls.setBorder(BorderFactory.createTitledBorder(null, "Video Control", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14)));
        pan_vid_controls.setPreferredSize(new Dimension(121, 145));

        b_set_flag.setText("Set Flag");

        b_load.setText("Load");
        b_load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_loadActionPerformed(evt);
            }
        });

        b_archive.setText("Archive");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(b_load)
                        .addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(b_archive)
                        .addGap(119, 119, 119)
                        .addComponent(b_set_flag)
                        .addContainerGap())
        );

        jPanel3Layout.linkSize(SwingConstants.HORIZONTAL, new Component[]{b_load, b_archive, b_set_flag});

        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(b_set_flag)
                                .addComponent(b_load)
                                .addComponent(b_archive)))
        );

        jPanel3Layout.linkSize(SwingConstants.VERTICAL, new Component[]{b_load, b_archive, b_set_flag});

        l_vid_con_icons.setIcon(new ImageIcon(icon_path + "video_image_control_icons/video_control_icons.jpg"));

        GroupLayout pan_vid_controlsLayout = new GroupLayout(pan_vid_controls);
        pan_vid_controls.setLayout(pan_vid_controlsLayout);
        pan_vid_controlsLayout.setHorizontalGroup(
                pan_vid_controlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_vid_controlsLayout.createSequentialGroup()
                        .addGroup(pan_vid_controlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, GroupLayout.Alignment.CENTER)
                                .addGroup(pan_vid_controlsLayout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(l_vid_con_icons)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan_vid_controlsLayout.setVerticalGroup(
                pan_vid_controlsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_vid_controlsLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5)
                        .addGap(16, 16, 16)
                        .addComponent(l_vid_con_icons)
                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
        );
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bottom Pans">
        jLabel2.setIcon(new ImageIcon(icon_path + "massDot_log.jpg"));

        l_logo.setIcon(new ImageIcon(icon_path + "company_logo.jpg"));

        GroupLayout pan_logo_iconsLayout = new GroupLayout(pan_logo_icons);
        pan_logo_icons.setLayout(pan_logo_iconsLayout);
        pan_logo_iconsLayout.setHorizontalGroup(
                pan_logo_iconsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_logo_iconsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(l_logo)
                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20))
        );
        pan_logo_iconsLayout.setVerticalGroup(
                pan_logo_iconsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_logo_iconsLayout.createSequentialGroup()
                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(101, 101, 101))
                .addGroup(pan_logo_iconsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_logo_iconsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(l_logo))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout pan_3rd_level_southLayout = new GroupLayout(pan_3rd_level_south);
        pan_3rd_level_south.setLayout(pan_3rd_level_southLayout);
        pan_3rd_level_southLayout.setHorizontalGroup(
                pan_3rd_level_southLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_3rd_level_southLayout.createSequentialGroup()
                        .addGroup(pan_3rd_level_southLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pan_logo_icons, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pan_3rd_level_southLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(pan_vid_controls, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        pan_3rd_level_southLayout.setVerticalGroup(
                pan_3rd_level_southLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_3rd_level_southLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pan_vid_controls, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(pan_logo_icons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout pan_2nd_level_swLayout = new GroupLayout(pan_2nd_level_sw);
        pan_2nd_level_sw.setLayout(pan_2nd_level_swLayout);
        pan_2nd_level_swLayout.setHorizontalGroup(
                pan_2nd_level_swLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_2nd_level_swLayout.createSequentialGroup()
                        .addComponent(pan_vision_utils, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(pan_3rd_level_south, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan_2nd_level_swLayout.setVerticalGroup(
                pan_2nd_level_swLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, pan_2nd_level_swLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(pan_2nd_level_swLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pan_vision_utils, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pan_3rd_level_south, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Media Streaming">
        pan_video_stream.setBorder(BorderFactory.createTitledBorder(null, "Live Streaming", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14)));
        pan_video_stream.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        pan_video_stream.setFont(new Font("Lucida Grande", 1, 13));

        p_media_player.setBackground(new Color(51, 51, 51));
        p_media_player.setForeground(new Color(102, 102, 102));
        p_media_player.setMaximumSize(new Dimension(350, 32767));

//x        pp = new Player();
//        pp = new Player();
        GroupLayout p_media_playerLayout = new GroupLayout(p_media_player);
        p_media_player.setLayout(p_media_playerLayout);
        p_media_playerLayout.setHorizontalGroup(
                p_media_playerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );
        p_media_playerLayout.setVerticalGroup(
                p_media_playerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 464, Short.MAX_VALUE)
        );

        GroupLayout pan_video_streamLayout = new GroupLayout(pan_video_stream);
        pan_video_stream.setLayout(pan_video_streamLayout);
        pan_video_streamLayout.setHorizontalGroup(
                pan_video_streamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_video_streamLayout.createSequentialGroup()
                        .addGroup(pan_video_streamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pan_video_streamLayout.createSequentialGroup()
                                        .addGroup(pan_video_streamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(pan_video_streamLayout.createSequentialGroup()
                                                        .addGap(177, 177, 177)
                                                        .addComponent(canvas3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pan_video_streamLayout.createSequentialGroup()
                                                        .addGap(166, 166, 166)
                                                        .addComponent(canvas4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pan_video_streamLayout.createSequentialGroup()
                                                        .addGap(152, 152, 152)
                                                        .addComponent(canvas1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 356, Short.MAX_VALUE))
                                .addComponent(p_media_player, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        pan_video_streamLayout.setVerticalGroup(
                pan_video_streamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_video_streamLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(p_media_player, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(canvas1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(canvas4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(canvas3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "RoboTracker", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14)));
        /*
         jLabel1.setIcon(new JLabel() {
         public Icon getIcon() {
         try {
         return new ImageIcon(
         new java.net.URL("file:/Users/jrob/Desktop/tunnel_map-8.jpg")
         );
         } catch (java.net.MalformedURLException e) {
         }
         return null;
         }
         }.getIcon());*/

        l_plenum_map.setIcon(new ImageIcon(icon_path + "test_images_n_template_im/tunnel_map-8.jpg"));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14))
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l_plenum_map)
                        .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l_plenum_map, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
        );

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="System Status">
        pan_sys_status.setBorder(BorderFactory.createTitledBorder(null, "System Status", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14)));

        tf_log_dump_file.setText("...ecenu/05182014_i90E.log");
        tf_log_dump_file.setToolTipText("");
        tf_log_dump_file.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tf_log_dump_fileActionPerformed(evt);
            }
        });

        l_logging_per.setText("100%");

        l_log_file.setText("Log File:");
        l_log_file.setToolTipText("");

        sb_logging.setValue(100);

        cb_do_log.setText("Log File Path");
        cb_do_log.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cb_do_logActionPerformed(evt);
            }
        });

        l_data_logging.setFont(new Font("Lucida Grande", 3, 13));
        l_data_logging.setText("Data Logging");

        GroupLayout pan_data_loggingLayout = new GroupLayout(pan_data_logging);
        pan_data_logging.setLayout(pan_data_loggingLayout);
        pan_data_loggingLayout.setHorizontalGroup(
                pan_data_loggingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_data_loggingLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_data_loggingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(cb_do_log)
                                .addGroup(pan_data_loggingLayout.createSequentialGroup()
                                        .addComponent(l_log_file)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(tf_log_dump_file, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                .addGroup(pan_data_loggingLayout.createSequentialGroup()
                                        .addComponent(sb_logging, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                        .addComponent(l_logging_per))
                                .addComponent(l_data_logging))
                        .addContainerGap())
        );
        pan_data_loggingLayout.setVerticalGroup(
                pan_data_loggingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_data_loggingLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l_data_logging)
                        .addGap(1, 1, 1)
                        .addGroup(pan_data_loggingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pan_data_loggingLayout.createSequentialGroup()
                                        .addComponent(sb_logging, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addGroup(pan_data_loggingLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(tf_log_dump_file, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(l_log_file))
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(cb_do_log))
                                .addComponent(l_logging_per))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sb_camera_signal.setValue(100);

        jLabel8.setFont(new Font("Lucida Grande", 3, 13));
        jLabel8.setText("Camera Signal");

        sb_video_signal.setValue(97);

        l_vid_sig_per.setText("97%");

        l_cam_sig_per.setText("100%");

        l_vid_signal.setFont(new Font("Lucida Grande", 3, 13));
        l_vid_signal.setText("Video Signal");

        GroupLayout pan_middle_sys_utilsLayout = new GroupLayout(pan_middle_sys_utils);
        pan_middle_sys_utils.setLayout(pan_middle_sys_utilsLayout);
        pan_middle_sys_utilsLayout.setHorizontalGroup(
                pan_middle_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_middle_sys_utilsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_middle_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pan_middle_sys_utilsLayout.createSequentialGroup()
                                        .addGroup(pan_middle_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(sb_camera_signal, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                                .addComponent(sb_video_signal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addGroup(pan_middle_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(l_vid_sig_per)
                                                .addComponent(l_cam_sig_per)))
                                .addComponent(jLabel8)
                                .addComponent(l_vid_signal))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan_middle_sys_utilsLayout.setVerticalGroup(
                pan_middle_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_middle_sys_utilsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l_vid_signal)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(pan_middle_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(sb_video_signal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(l_vid_sig_per))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3)
                        .addGroup(pan_middle_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(sb_camera_signal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(l_cam_sig_per))
                        .addContainerGap())
        );

        sb_battery.setValue(86);
        sb_battery.setBorderPainted(false);

        l_battery_per.setText("86%");

        l_battery.setFont(new Font("Lucida Grande", 3, 13));
        l_battery.setText("Battery");

        l_robo_conn_per.setText("95%");

        l_robo_connect.setFont(new Font("Lucida Grande", 3, 13));
        l_robo_connect.setText("Robot Connection");

        sb_robo_connection.setValue(95);

        l_r_id.setText("R-ID");

        tf_r_id.setFont(new Font("Lucida Grande", 0, 10));
        tf_r_id.setText("Barracuda");

        combox_src_ip.setFont(new Font("Lucida Grande", 0, 10));
        combox_src_ip.setModel(new DefaultComboBoxModel(new String[]{"localHost"}));

        combox_dest_ip.setFont(new Font("Lucida Grande", 0, 10));
        combox_dest_ip.setModel(new DefaultComboBoxModel(new String[]{"localHost"}));

        l_src_ip.setText("Source IP");

        l_dest_ip.setText("Destination IP");

        tf_ip.setFont(new Font("Lucida Grande", 0, 10));
        tf_ip.setText("192.168.1.2");

        l_host_ip.setText("IP");

        b_reset.setBackground(new Color(255, 102, 102));
        b_reset.setFont(new Font("Lucida Grande", 0, 10));
        b_reset.setText("Reset");

        b_connect.setBackground(new Color(0, 204, 51));
        b_connect.setFont(new Font("Lucida Grande", 0, 10));
        b_connect.setText("Connect");
        b_connect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });

        b_close.setBackground(new Color(255, 51, 51));
        b_close.setFont(new Font("Lucida Grande", 0, 10));
        b_close.setText("Close");

        GroupLayout pan_com_buttonsLayout = new GroupLayout(pan_com_buttons);
        pan_com_buttons.setLayout(pan_com_buttonsLayout);
        pan_com_buttonsLayout.setHorizontalGroup(
                pan_com_buttonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_com_buttonsLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(b_connect)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(b_reset)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(b_close)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_com_buttonsLayout.linkSize(SwingConstants.HORIZONTAL, new Component[]{b_connect, b_reset, b_close});

        pan_com_buttonsLayout.setVerticalGroup(
                pan_com_buttonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_com_buttonsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_com_buttonsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(b_reset)
                                .addComponent(b_close)
                                .addComponent(b_connect))
                        .addContainerGap())
        );

        pan_com_buttonsLayout.linkSize(SwingConstants.VERTICAL, new Component[]{b_connect, b_reset, b_close});

        GroupLayout jPanel14Layout = new GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(pan_com_buttons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pan_com_buttons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Higher Level Panels">
        GroupLayout pan_top_sys_utilsLayout = new GroupLayout(pan_top_sys_utils);
        pan_top_sys_utils.setLayout(pan_top_sys_utilsLayout);
        pan_top_sys_utilsLayout.setHorizontalGroup(
                pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_top_sys_utilsLayout.createSequentialGroup()
                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, pan_top_sys_utilsLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(l_robo_connect)
                                                .addGroup(pan_top_sys_utilsLayout.createSequentialGroup()
                                                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(pan_top_sys_utilsLayout.createSequentialGroup()
                                                                        .addGap(31, 31, 31)
                                                                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(l_src_ip)
                                                                                .addComponent(l_r_id)))
                                                                .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(l_host_ip)
                                                                        .addComponent(l_dest_ip)))
                                                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(combox_dest_ip, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(tf_ip, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(combox_src_ip, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(tf_r_id, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(pan_top_sys_utilsLayout.createSequentialGroup()
                                                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(l_battery, GroupLayout.Alignment.LEADING)
                                                                .addComponent(sb_robo_connection, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                                                .addComponent(sb_battery, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(l_battery_per)
                                                                .addComponent(l_robo_conn_per)))))
                                .addComponent(jPanel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        pan_top_sys_utilsLayout.setVerticalGroup(
                pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_top_sys_utilsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l_battery)
                        .addGap(0, 0, 0)
                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(sb_battery, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(l_battery_per))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(l_robo_connect)
                        .addGap(0, 0, 0)
                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(sb_robo_connection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(l_robo_conn_per))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(pan_top_sys_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pan_top_sys_utilsLayout.createSequentialGroup()
                                        .addComponent(l_r_id)
                                        .addGap(12, 12, 12)
                                        .addComponent(l_src_ip)
                                        .addGap(11, 11, 11)
                                        .addComponent(l_dest_ip)
                                        .addGap(11, 11, 11)
                                        .addComponent(l_host_ip)
                                        .addGap(0, 6, Short.MAX_VALUE)
                                        .addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(pan_top_sys_utilsLayout.createSequentialGroup()
                                        .addComponent(tf_r_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(combox_src_ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(combox_dest_ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 0, 0))
        );

        GroupLayout pan_sys_statusLayout = new GroupLayout(pan_sys_status);
        pan_sys_status.setLayout(pan_sys_statusLayout);
        pan_sys_statusLayout.setHorizontalGroup(
                pan_sys_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_sys_statusLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pan_sys_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pan_sys_statusLayout.createSequentialGroup()
                                        .addComponent(pan_top_sys_utils, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, pan_sys_statusLayout.createSequentialGroup()
                                        .addGroup(pan_sys_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(pan_data_logging, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pan_middle_sys_utils, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(3, 3, 3))))
        );
        pan_sys_statusLayout.setVerticalGroup(
                pan_sys_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_sys_statusLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(pan_top_sys_utils, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(pan_middle_sys_utils, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pan_data_logging, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout pan_2nd_level_topLayout = new GroupLayout(pan_2nd_level_top);
        pan_2nd_level_top.setLayout(pan_2nd_level_topLayout);
        pan_2nd_level_topLayout.setHorizontalGroup(
                pan_2nd_level_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_2nd_level_topLayout.createSequentialGroup()
                        .addComponent(pan_sys_status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(pan_video_stream, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        pan_2nd_level_topLayout.setVerticalGroup(
                pan_2nd_level_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_2nd_level_topLayout.createSequentialGroup()
                        .addGroup(pan_2nd_level_topLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pan_sys_status, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pan_video_stream, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
        );
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Data Zone">
        jPanel1.getAccessibleContext().setAccessibleName("I-90 East");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pan_dDisplay.setBorder(BorderFactory.createTitledBorder(null, "Data Zone", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14)));

        GroupLayout pan_dDisplayLayout = new GroupLayout(pan_dDisplay);
        pan_dDisplay.setLayout(pan_dDisplayLayout);
        pan_dDisplayLayout.setHorizontalGroup(
                pan_dDisplayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 226, Short.MAX_VALUE)
        );
        pan_dDisplayLayout.setVerticalGroup(
                pan_dDisplayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );

        GroupLayout pan_top_levelLayout = new GroupLayout(pan_top_level);
        pan_top_level.setLayout(pan_top_levelLayout);
        pan_top_levelLayout.setHorizontalGroup(
                pan_top_levelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_top_levelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_top_levelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pan_top_levelLayout.createSequentialGroup()
                                        .addComponent(pan_2nd_level_top, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(pan_top_levelLayout.createSequentialGroup()
                                        .addComponent(pan_2nd_level_sw, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)
                                        .addComponent(pan_dDisplay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
        );
        pan_top_levelLayout.setVerticalGroup(
                pan_top_levelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_top_levelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pan_2nd_level_top, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(pan_top_levelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pan_2nd_level_sw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pan_dDisplay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Menu Bar">
        // <editor-fold defaultstate="collapsed" desc="Drop Down Menus">
        menu_file.setText("File");

        mnu_open.setText("Open...");
        mnu_open.setToolTipText("");
        mnu_open.setActionCommand("mnu_file");
        mnu_open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnu_openActionPerformed(evt);
            }
        });
        menu_file.add(mnu_open);

        mnu_saveas.setText("Save As...");
        mnu_saveas.setActionCommand("mnu_file");
        mnu_saveas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
        // </editor-fold>

        menu_edit.setText("Edit");
        jMenuBar1.add(menu_edit);

        menu_tools.setLabel("Tools");
        jMenuBar1.add(menu_tools);

        menu_help.setText("Help");
        jMenuBar1.add(menu_help);

        menu_about.setText("About");
        jMenuBar1.add(menu_about);

        setJMenuBar(jMenuBar1);
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Combined Panel">
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(pan_top_level, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(pan_top_level, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        // </editor-fold>

        addKeyListener(IJ.getInstance());

        setResizable(false);
        this.pack();
        addWindowListener(this);
        //  this.setVisible(true);

    }// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="TO DO">
    private void mnu_openActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

        FileDialog fd = new FileDialog(this, "TrivialJMFPlayer", FileDialog.LOAD);

        fd.setVisible(true);

        String dir = fd.getDirectory();
        String fname = fd.getFile();
        File f = new File(dir, fname);

        if (!f.exists()) {
            if (do_debug) {
                System.out.println("Open Dialog Box did not return a file chose.\n");
            }
            return;
        }
        media_pan.playz(dir + "/" + fname);

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
//                    im_plus = IJ.openImage(fpath);
//
//                    im_plus.show();
//
//                    if (im_plus != null) {
//                        is_im_loaded[0] = true;
//                    } else {
//                        is_im_loaded[0] = false;
//                    }
//
//                    set_button_states();
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
    private void mnu_saveasActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cb_object_awareActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void b_look_aroundActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void b_inspect_ceilingActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void b_loadActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void b_save_imageActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void b_open_imageActionPerformed(ActionEvent evt) {

        System.out.println("Snap!\n\n");
        // TODO add your handling code here:
    }

    private void tf_log_dump_fileActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cb_do_logActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void b_connectActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void b_snap_imageActionPerformed(ActionEvent evt) {

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
    public void keyPressed(KeyEvent e
    ) {

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
    public void keyReleased(KeyEvent e
    ) {
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

    // <editor-fold defaultstate="collapsed" desc="WindowListeners">
    @Override
    public void windowClosing(WindowEvent e) {
//        p.destroy();
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
     * @param args the command line arguments
     */
    /*
     public static void main(String args[]) {

     try {
     for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
     if ("Nimbus".equals(info.getName())) {
     UIManager.setLookAndFeel(info.getClassName());
     break;
     }
     }
     } catch (ClassNotFoundException ex) {
     java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (InstantiationException ex) {
     java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
     java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (UnsupportedLookAndFeelException ex) {
     java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     //</editor-fold>
     */

    /*  //Create and display the form
     java.awt.EventQueue.invokeLater(new Runnable() {
     @Override
     public void run() {
     new MainMenu().setVisible(true);
     //                new MobileDirectionDisplay().setVisible(true);
     }
     });
     }
     */
    //<editor-fold defaultstate="collapsed" desc="Component Declared">
    // Variables declaration - do not modify
    Canvas canvas1;
    Canvas canvas3;
    Canvas canvas4;
    JButton b_scan_hanger;
    JButton b_connect;
    JButton b_reset;
    JButton b_close;
    JButton b_snap_image;
    JButton b_inspect_ceiling;
    JButton b_look_around;
    JButton b_load;
    JButton b_archive;
    JButton b_set_flag;
    JButton b_open_image;
    JButton b_save_image;
    JButton b_close_image;
    JCheckBox cb_object_aware;
    JCheckBox cb_do_log;
    JComboBox combox_src_ip;
    JComboBox combox_dest_ip;
    JLabel jLabel1;
    JLabel l_battery;
    JLabel l_capture_moment;
    JLabel l_log_file;
    JLabel l_battery_per;
    JLabel l_robo_conn_per;
    JLabel l_vid_sig_per;
    JLabel l_logging_per;
    JLabel l_cam_sig_per;
    JLabel l_r_id;
    JLabel l_src_ip;
    JLabel jLabel2;
    JLabel l_dest_ip;
    JLabel l_host_ip;
    JLabel l_vid_con_icons;
    JLabel l_plenum_map;
    JLabel jLabel3;
    JLabel l_logo;
    JLabel jLabel5;
    JLabel l_robo_connect;
    JLabel l_vid_signal;
    JLabel jLabel8;
    JLabel l_data_logging;
    JMenuBar jMenuBar1;
    JMenuItem jMenuItem1;
    JPanel jPanel1;
    JPanel pan_2nd_level_sw;
    JPanel pan_top_level;
    JPanel pan_middle_sys_utils;
    JPanel pan_top_sys_utils;
    JPanel jPanel14;
    JPanel pan_image_file_buttons;
    JPanel pan_com_buttons;
    JPanel pan_sys_status;
    JPanel jPanel3;
    JPanel pan_dDisplay;
    JPanel pan_vision_utils;
    JPanel pan_logo_icons;
    JPanel pan_3rd_level_south;
    JPanel pan_data_logging;
    JPanel pan_2nd_level_top;
    JProgressBar pb_load_image;
    JProgressBar sb_robo_connection;
    JProgressBar sb_video_signal;
    JProgressBar sb_logging;
    JProgressBar sb_battery;
    JProgressBar sb_camera_signal;
    JTextField tf_log_dump_file;
    JTextField tf_r_id;
    JTextField tf_ip;
    JMenu menu_about;
    JMenu menu_edit;
    JMenu menu_file;
    JMenu menu_help;
    JMenu menu_tools;
    JMenuItem mnu_close;
    JMenuItem mnu_exit;
    JMenuItem mnu_open;
    JMenuItem mnu_saveas;
    JPanel pan_vid_controls;
    JPanel pan_video_stream;
    JPanel p_media_player;
    // </editor-fold>

    // End of variables declaration
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

class MediaPlayerHandle {

//    JFrame frame = new JFrame("");
    JPanel p;
    MediaPlayerFactory mediaPlayerFactory;
    EmbeddedMediaPlayer mediaPlayer;
    String icon_path = System.getProperty("user.dir") + "/resources/";

    MediaPlayerHandle() {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "/Applications/VLC.app/Contents/MacOS/lib/");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        mediaPlayerFactory = new MediaPlayerFactory();

        Canvas c = new Canvas();
        c.setBackground(Color.black);
        p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(c, BorderLayout.CENTER);
//        frame.add(p, BorderLayout.CENTER);

        mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));
//        frame.setLocation(100, 100);
//        frame.setSize(1280, 720);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JPanel getF() {
        return p;
    }

    public void playz(String vpath) {
        mediaPlayer.playMedia(vpath);
    }

    public void playz() {
        mediaPlayer.playMedia(icon_path + "/Users/jrob/Google Drive/Capstone/Visualization/Video and PNGs/Scene 10/Office_Scene_10.avi");

    }
}
