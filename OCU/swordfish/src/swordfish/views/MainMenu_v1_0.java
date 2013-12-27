/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swordfish.views;

//import swordfish.ui_develop.*;
//import swordfish.*;
import ij.IJ;
import java.awt.Color;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container.*;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.KeyEvent.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import java.io.*;
/**
 *
 * @author jrob
 */
public class MainMenu_v1_0 extends JFrame
        implements KeyListener, WindowListener {

    /**
     * Creates new form MainMenu
     */
    int[] pointer = new int[1];
    private JLabel icon_down;
    private JLabel icon_left;
    private JLabel icon_right;
    private JLabel icon_up;
    private JPanel p_directionals;
    private boolean do_debug = true;
    boolean[] f_video_loaded = new boolean[1];
    MyMediaPlayer media_pan;
    String icon_path = System.getProperty("user.dir") + "/resources/";

    public MainMenu_v1_0() {
        init();
        initComponents();
        initMediaPlayer();
        initContainer();
        f_video_loaded[0] = false;
        set_button_states();
    }

    private void set_button_states() {
        b_vid_ff.setEnabled(f_video_loaded[0]);
        b_vid_mute.setEnabled(f_video_loaded[0]);
        b_vid_pause.setEnabled(f_video_loaded[0]);
        b_vid_play.setEnabled(f_video_loaded[0]);
//        b_vid_rw.setEnabled(f_video_loaded[0]);
        b_vid_stop.setEnabled(f_video_loaded[0]);
        b_capture_moment.setEnabled(f_video_loaded[0]);

    }

    // <editor-fold defaultstate="collapsed" desc="initContainer">
    private void initContainer() {
        addKeyListener(IJ.getInstance());

        setResizable(false);
        this.pack();
        addWindowListener(this);

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="initMediaPlayer">
    private void initMediaPlayer() {
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

        GroupLayout pan_video_streamLayout = new GroupLayout(pan_live_streaming);
        pan_live_streaming.setLayout(pan_video_streamLayout);
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
        media_pan = new MyMediaPlayer();
        JPanel mediaFrame = media_pan.getF();
        mediaFrame.setSize(p_media_player.getSize());

        p_media_player.add(mediaFrame);
    }

    // </editor-fold>
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        pan_root = new javax.swing.JPanel();
        pan_south_all = new javax.swing.JPanel();
        pan_south_east = new javax.swing.JPanel();
        l_speed_static = new javax.swing.JLabel();
        l_ins_static = new javax.swing.JLabel();
        l_progress_static = new javax.swing.JLabel();
        l_speed = new javax.swing.JLabel();
        l_ins = new javax.swing.JLabel();
        l_progress = new javax.swing.JLabel();
        seperator1 = new javax.swing.JSeparator();
        l_inspect_static = new javax.swing.JLabel();
        l_inspector = new javax.swing.JLabel();
        l_mid__static = new javax.swing.JLabel();
        l_mid = new javax.swing.JLabel();
        l_date_static = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        l_logo_icon = new javax.swing.JLabel();
        b_logon = new javax.swing.JButton();
        pan_vision_utils = new javax.swing.JPanel();
        b_scan_hanger = new javax.swing.JButton();
        b_inspect_ceiling = new javax.swing.JButton();
        b_do_look = new javax.swing.JButton();
        b_analyze_anchor = new javax.swing.JButton();
        cb_object_aware = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        pan_media_control = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        b_archive = new javax.swing.JButton();
        b_load = new javax.swing.JButton();
        b_set_flag = new javax.swing.JButton();
        sb_vid_play = new javax.swing.JScrollBar();
        b_capture_moment = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        b_close = new javax.swing.JButton();
        b_save = new javax.swing.JButton();
        pb_image_load = new javax.swing.JProgressBar();
        b_vid_mute = new javax.swing.JToggleButton();
        b_vid_rw = new javax.swing.JButton();
        b_vid_play = new javax.swing.JButton();
        b_vid_stop = new javax.swing.JButton();
        b_vid_ff = new javax.swing.JButton();
        b_vid_pause = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pan_north = new javax.swing.JPanel();
        pan_live_streaming = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        canvas3 = new java.awt.Canvas();
        canvas4 = new java.awt.Canvas();
        pan_robo_tracker = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        l_plenum_map_icon = new javax.swing.JLabel();
        p_media_player = new javax.swing.JPanel();
        pan_systam_status = new javax.swing.JPanel();
        pan_north_east_bottom = new javax.swing.JPanel();
        tf_log_fpath = new javax.swing.JTextField();
        l_logging_per = new javax.swing.JLabel();
        l_log_file = new javax.swing.JLabel();
        pb_logging_per = new javax.swing.JProgressBar();
        cb_output_log = new javax.swing.JCheckBox();
        l_data_logging = new javax.swing.JLabel();
        l_vid_sig = new javax.swing.JLabel();
        pb_vid_sig_per = new javax.swing.JProgressBar();
        l_vid_sig_per = new javax.swing.JLabel();
        l_cam_sig_per = new javax.swing.JLabel();
        pb_cam_sig_per = new javax.swing.JProgressBar();
        l_cam_sig = new javax.swing.JLabel();
        pan_north_east_top = new javax.swing.JPanel();
        pb_battery = new javax.swing.JProgressBar();
        l_battery_per = new javax.swing.JLabel();
        l_battery = new javax.swing.JLabel();
        l_robo_connect_per = new javax.swing.JLabel();
        l_robot_connection = new javax.swing.JLabel();
        pb_robo_connect = new javax.swing.JProgressBar();
        l_r_id = new javax.swing.JLabel();
        tf_r_id = new javax.swing.JTextField();
        comboB_source_ip = new javax.swing.JComboBox();
        comboB_remote_ip = new javax.swing.JComboBox();
        l_source_ip = new javax.swing.JLabel();
        l_remote_ip = new javax.swing.JLabel();
        tf_ip = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        b_reset = new javax.swing.JButton();
        b_connect = new javax.swing.JButton();
        b_logout = new javax.swing.JButton();
        l_ip = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        mnu_open = new javax.swing.JMenuItem();
        mnu_saveas1 = new javax.swing.JMenuItem();
        mnu_saveas = new javax.swing.JMenuItem();
        mnu_close = new javax.swing.JMenuItem();
        mnu_exit = new javax.swing.JMenuItem();
        menu_edit = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        menu_tools = new javax.swing.JMenu();
        menu_tools2 = new javax.swing.JMenu();
        menu_tools3 = new javax.swing.JMenu();
        menu_tools4 = new javax.swing.JMenu();
        mnu_inspect_robot = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menu_about = new javax.swing.JMenu();
        menu_help = new javax.swing.JMenu();
        menu_about1 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jScrollPane1.setViewportView(jTextPane1);

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inspector Robot");

        pan_south_east.setBorder(javax.swing.BorderFactory.createTitledBorder(" "));

        l_speed_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_speed_static.setText("Speed:");

        l_ins_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_ins_static.setText("INS:");

        l_progress_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_progress_static.setText("Progress");

        l_speed.setText("-- ");

        l_ins.setText("- - --");

        l_progress.setText("# / #");

        seperator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        l_inspect_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_inspect_static.setText("Inspector:");

        l_inspector.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        l_inspector.setText("   - - -  ");

        l_mid__static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_mid__static.setText("MID:");

        l_mid.setText("    - - -  ");

        l_date_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_date_static.setText("Date:");

        l_date.setText("     - - -  ");

        l_logo_icon.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/company_logo_small.jpg")); // NOI18N

        b_logon.setText("Log-on");
        b_logon.setActionCommand("b_logon");
        b_logon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan_south_eastLayout = new javax.swing.GroupLayout(pan_south_east);
        pan_south_east.setLayout(pan_south_eastLayout);
        pan_south_eastLayout.setHorizontalGroup(
            pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_south_eastLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_progress_static, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pan_south_eastLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(l_speed_static)
                                    .addComponent(l_ins_static))))
                        .addGap(18, 18, 18)
                        .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_progress)
                            .addGroup(pan_south_eastLayout.createSequentialGroup()
                                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_speed)
                                    .addComponent(l_ins))
                                .addGap(18, 18, 18)
                                .addComponent(seperator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(l_logo_icon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_inspect_static)
                            .addComponent(l_mid__static, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_date_static, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_date)
                            .addComponent(l_inspector)
                            .addComponent(l_mid)))
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(b_logon)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pan_south_eastLayout.setVerticalGroup(
            pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_south_eastLayout.createSequentialGroup()
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_inspect_static)
                            .addComponent(l_inspector))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_mid__static)
                            .addComponent(l_mid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_date_static)
                            .addComponent(l_date)))
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pan_south_eastLayout.createSequentialGroup()
                                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(l_speed_static)
                                    .addComponent(l_speed, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(l_ins_static)
                                    .addComponent(l_ins, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(seperator1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_progress_static)
                            .addComponent(l_progress, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_logo_icon)
                    .addComponent(b_logon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_vision_utils.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vision Utils", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        b_scan_hanger.setText("Scan Hanger");

        b_inspect_ceiling.setText("Inspect Ceiling");
        b_inspect_ceiling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_inspect_ceilingActionPerformed(evt);
            }
        });

        b_do_look.setText("Do Look Around");
        b_do_look.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_do_lookActionPerformed(evt);
            }
        });

        b_analyze_anchor.setText("Analyze Anchors");
        b_analyze_anchor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_analyze_anchorActionPerformed(evt);
            }
        });

        cb_object_aware.setText("Object Aware");
        cb_object_aware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_object_awareActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Directionals On");

        jButton1.setText("Launch Image Viewer");

        javax.swing.GroupLayout pan_vision_utilsLayout = new javax.swing.GroupLayout(pan_vision_utils);
        pan_vision_utils.setLayout(pan_vision_utilsLayout);
        pan_vision_utilsLayout.setHorizontalGroup(
            pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                        .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_inspect_ceiling)
                            .addComponent(b_scan_hanger, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(b_analyze_anchor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_do_look)))
                    .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(49, 49, 49)
                        .addComponent(cb_object_aware))))
            .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_vision_utilsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_analyze_anchor, b_do_look, b_inspect_ceiling, b_scan_hanger});

        pan_vision_utilsLayout.setVerticalGroup(
            pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_object_aware)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_inspect_ceiling)
                    .addComponent(b_do_look))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_analyze_anchor)
                    .addComponent(b_scan_hanger))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        pan_media_control.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Media Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        pan_media_control.setPreferredSize(new java.awt.Dimension(121, 145));

        b_archive.setText("Archive");
        b_archive.setEnabled(false);

        b_load.setText("Load");
        b_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loadActionPerformed(evt);
            }
        });

        b_set_flag.setText("Set Flag");
        b_set_flag.setEnabled(false);

        sb_vid_play.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        b_capture_moment.setBackground(new java.awt.Color(153, 255, 255));
        b_capture_moment.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/video_image_control_icons/camera_icon_small.jpg")); // NOI18N
        b_capture_moment.setEnabled(false);
        b_capture_moment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_capture_momentActionPerformed(evt);
            }
        });

        jLabel2.setText("-- / --");

        b_close.setText("Close");
        b_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_closeActionPerformed(evt);
            }
        });

        b_save.setText("Save");
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        pb_image_load.setValue(30);
        pb_image_load.setEnabled(false);

        b_vid_mute.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/mute_icon.jpg")); // NOI18N
        b_vid_mute.setContentAreaFilled(false);
        b_vid_mute.setEnabled(false);
        b_vid_mute.setFocusable(false);
        b_vid_mute.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_vid_mute.setMaximumSize(new java.awt.Dimension(50, 50));
        b_vid_mute.setPreferredSize(new java.awt.Dimension(40, 40));
        b_vid_mute.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        b_vid_mute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_vid_muteActionPerformed(evt);
            }
        });

        b_vid_rw.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/rewind_icon.jpg")); // NOI18N
        b_vid_rw.setEnabled(false);
        b_vid_rw.setFocusable(false);
        b_vid_rw.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_vid_rw.setMaximumSize(new java.awt.Dimension(50, 50));
        b_vid_rw.setMinimumSize(new java.awt.Dimension(50, 50));
        b_vid_rw.setPreferredSize(new java.awt.Dimension(50, 50));
        b_vid_rw.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        b_vid_rw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_vid_rwActionPerformed(evt);
            }
        });

        b_vid_play.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/play_icon.jpg")); // NOI18N
        b_vid_play.setEnabled(false);
        b_vid_play.setFocusable(false);
        b_vid_play.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_vid_play.setMaximumSize(new java.awt.Dimension(50, 50));
        b_vid_play.setMinimumSize(new java.awt.Dimension(50, 50));
        b_vid_play.setPreferredSize(new java.awt.Dimension(50, 50));
        b_vid_play.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        b_vid_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_vid_playActionPerformed(evt);
            }
        });

        b_vid_stop.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/stop_icon.jpg")); // NOI18N
        b_vid_stop.setEnabled(false);
        b_vid_stop.setFocusable(false);
        b_vid_stop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_vid_stop.setMaximumSize(new java.awt.Dimension(50, 50));
        b_vid_stop.setMinimumSize(new java.awt.Dimension(50, 50));
        b_vid_stop.setPreferredSize(new java.awt.Dimension(50, 50));
        b_vid_stop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        b_vid_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_vid_stopActionPerformed(evt);
            }
        });

        b_vid_ff.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/ff_icon.jpg")); // NOI18N
        b_vid_ff.setBorderPainted(false);
        b_vid_ff.setEnabled(false);
        b_vid_ff.setFocusable(false);
        b_vid_ff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_vid_ff.setMaximumSize(new java.awt.Dimension(50, 50));
        b_vid_ff.setMinimumSize(new java.awt.Dimension(50, 50));
        b_vid_ff.setPreferredSize(new java.awt.Dimension(50, 50));
        b_vid_ff.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        b_vid_ff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_vid_ffActionPerformed(evt);
            }
        });

        b_vid_pause.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/pause_icon.jpg")); // NOI18N
        b_vid_pause.setEnabled(false);
        b_vid_pause.setFocusable(false);
        b_vid_pause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_vid_pause.setMaximumSize(new java.awt.Dimension(50, 50));
        b_vid_pause.setMinimumSize(new java.awt.Dimension(50, 50));
        b_vid_pause.setPreferredSize(new java.awt.Dimension(50, 50));
        b_vid_pause.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        b_vid_pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_vid_pauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan_media_controlLayout = new javax.swing.GroupLayout(pan_media_control);
        pan_media_control.setLayout(pan_media_controlLayout);
        pan_media_controlLayout.setHorizontalGroup(
            pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_media_controlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5))
            .addGroup(pan_media_controlLayout.createSequentialGroup()
                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pb_image_load, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(b_save)
                            .addComponent(b_archive, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_set_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sb_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(b_capture_moment, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(b_vid_rw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_ff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_mute, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_vid_ff, b_vid_mute, b_vid_pause, b_vid_play, b_vid_rw, b_vid_stop});

        pan_media_controlLayout.setVerticalGroup(
            pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_media_controlLayout.createSequentialGroup()
                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addComponent(sb_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2))
                            .addComponent(b_capture_moment, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(b_vid_rw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(b_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(b_vid_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(b_vid_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(b_vid_ff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(b_vid_mute, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(b_archive, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_load, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pb_image_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addComponent(b_close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(b_set_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_vid_ff, b_vid_mute, b_vid_pause, b_vid_play, b_vid_rw, b_vid_stop});

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_archive, b_close, b_load});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pan_south_allLayout = new javax.swing.GroupLayout(pan_south_all);
        pan_south_all.setLayout(pan_south_allLayout);
        pan_south_allLayout.setHorizontalGroup(
            pan_south_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_south_allLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pan_media_control, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_vision_utils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_south_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_south_allLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(207, 207, 207))
                    .addComponent(pan_south_east, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pan_south_allLayout.setVerticalGroup(
            pan_south_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_south_allLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pan_south_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pan_south_east, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pan_south_allLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pan_south_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pan_media_control, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(pan_vision_utils, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))))
                .addGap(3, 3, 3)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_live_streaming.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Live Streaming", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        pan_live_streaming.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pan_live_streaming.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        javax.swing.GroupLayout pan_live_streamingLayout = new javax.swing.GroupLayout(pan_live_streaming);
        pan_live_streaming.setLayout(pan_live_streamingLayout);
        pan_live_streamingLayout.setHorizontalGroup(
            pan_live_streamingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_live_streamingLayout.createSequentialGroup()
                .addGroup(pan_live_streamingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_live_streamingLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_live_streamingLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_live_streamingLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        pan_live_streamingLayout.setVerticalGroup(
            pan_live_streamingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_live_streamingLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_robo_tracker.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RoboTracker", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        pan_robo_tracker.setPreferredSize(new java.awt.Dimension(294, 512));

        jLabel1.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/Users/jrob/Desktop/tunnel_map-8.jpg")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        l_plenum_map_icon.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/test_images_n_template_im/tunnel_map-8.jpg")); // NOI18N

        p_media_player.setBackground(new java.awt.Color(51, 51, 51));
        p_media_player.setForeground(new java.awt.Color(102, 102, 102));
        p_media_player.setMaximumSize(new java.awt.Dimension(350, 32767));

        javax.swing.GroupLayout p_media_playerLayout = new javax.swing.GroupLayout(p_media_player);
        p_media_player.setLayout(p_media_playerLayout);
        p_media_playerLayout.setHorizontalGroup(
            p_media_playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        p_media_playerLayout.setVerticalGroup(
            p_media_playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pan_robo_trackerLayout = new javax.swing.GroupLayout(pan_robo_tracker);
        pan_robo_tracker.setLayout(pan_robo_trackerLayout);
        pan_robo_trackerLayout.setHorizontalGroup(
            pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_robo_trackerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                .addComponent(p_media_player, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(l_plenum_map_icon))
        );
        pan_robo_trackerLayout.setVerticalGroup(
            pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_media_player, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_plenum_map_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pan_systam_status.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "System Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        tf_log_fpath.setText("...ecenu/051814.log");
        tf_log_fpath.setToolTipText("");
        tf_log_fpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_log_fpathActionPerformed(evt);
            }
        });

        l_logging_per.setText("0%");

        l_log_file.setText("Log File:");
        l_log_file.setToolTipText("");

        cb_output_log.setText("Save Log to File");
        cb_output_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_output_logActionPerformed(evt);
            }
        });

        l_data_logging.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_data_logging.setText("Data Logging");

        l_vid_sig.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_vid_sig.setText("Video Signal");

        l_vid_sig_per.setText("0%");

        l_cam_sig_per.setText("0%");

        l_cam_sig.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_cam_sig.setText("Camera Signal");

        javax.swing.GroupLayout pan_north_east_bottomLayout = new javax.swing.GroupLayout(pan_north_east_bottom);
        pan_north_east_bottom.setLayout(pan_north_east_bottomLayout);
        pan_north_east_bottomLayout.setHorizontalGroup(
            pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_north_east_bottomLayout.createSequentialGroup()
                .addGroup(pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_north_east_bottomLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_data_logging)
                            .addComponent(pb_logging_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pb_cam_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_cam_sig)
                            .addComponent(l_vid_sig)
                            .addComponent(pb_vid_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_vid_sig_per, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_cam_sig_per, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_logging_per, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pan_north_east_bottomLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(l_log_file)
                        .addGap(0, 0, 0)
                        .addComponent(tf_log_fpath, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_north_east_bottomLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cb_output_log)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pan_north_east_bottomLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pb_cam_sig_per, pb_logging_per, pb_vid_sig_per});

        pan_north_east_bottomLayout.setVerticalGroup(
            pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_north_east_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_vid_sig)
                .addGap(3, 3, 3)
                .addGroup(pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pb_vid_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_vid_sig_per))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_cam_sig)
                .addGap(3, 3, 3)
                .addGroup(pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb_cam_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_cam_sig_per))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l_data_logging)
                .addGap(3, 3, 3)
                .addGroup(pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb_logging_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_logging_per))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_log_fpath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_log_file))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_output_log))
        );

        pan_north_east_bottomLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pb_cam_sig_per, pb_logging_per, pb_vid_sig_per});

        pb_battery.setBorderPainted(false);

        l_battery_per.setText(" --");

        l_battery.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_battery.setText("Battery");

        l_robo_connect_per.setText(" --");

        l_robot_connection.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_robot_connection.setText("Robot Connection ");

        l_r_id.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        l_r_id.setText("R-ID:");

        tf_r_id.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_r_id.setText("Barracuda");

        comboB_source_ip.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        comboB_source_ip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "localHost" }));

        comboB_remote_ip.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        comboB_remote_ip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "localHost" }));
        comboB_remote_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboB_remote_ipActionPerformed(evt);
            }
        });

        l_source_ip.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        l_source_ip.setText("Source IP: ");

        l_remote_ip.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        l_remote_ip.setText("Remote IP: ");

        tf_ip.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_ip.setText("192.168.1.2");

        b_reset.setBackground(new java.awt.Color(255, 102, 102));
        b_reset.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        b_reset.setText("Reset");

        b_connect.setBackground(new java.awt.Color(0, 204, 51));
        b_connect.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        b_connect.setText("Connect");
        b_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });

        b_logout.setBackground(new java.awt.Color(255, 51, 51));
        b_logout.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        b_logout.setText("Logout");
        b_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(b_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(b_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(b_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_reset)
                    .addComponent(b_logout)
                    .addComponent(b_connect))
                .addContainerGap())
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_connect, b_logout, b_reset});

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        l_ip.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        l_ip.setText("IP: ");

        javax.swing.GroupLayout pan_north_east_topLayout = new javax.swing.GroupLayout(pan_north_east_top);
        pan_north_east_top.setLayout(pan_north_east_topLayout);
        pan_north_east_topLayout.setHorizontalGroup(
            pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pan_north_east_topLayout.createSequentialGroup()
                    .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pan_north_east_topLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(l_r_id))
                        .addGroup(pan_north_east_topLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(l_ip))
                        .addComponent(l_remote_ip)
                        .addComponent(l_source_ip))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboB_source_ip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_r_id, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboB_remote_ip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pan_north_east_topLayout.createSequentialGroup()
                    .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pan_north_east_topLayout.createSequentialGroup()
                            .addComponent(l_battery)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(pan_north_east_topLayout.createSequentialGroup()
                            .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pan_north_east_topLayout.createSequentialGroup()
                                    .addComponent(l_robot_connection)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(pb_robo_connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pb_battery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(l_battery_per)
                                .addComponent(l_robo_connect_per))))
                    .addContainerGap()))
            .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(tf_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pan_north_east_topLayout.setVerticalGroup(
            pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_north_east_topLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(l_battery)
                .addGap(0, 0, 0)
                .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_north_east_topLayout.createSequentialGroup()
                        .addComponent(pb_battery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(l_robot_connection)
                        .addGap(0, 0, 0)
                        .addComponent(pb_robo_connect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_r_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pan_north_east_topLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l_r_id)))
                        .addGap(0, 0, 0)
                        .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_north_east_topLayout.createSequentialGroup()
                                .addGroup(pan_north_east_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_north_east_topLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(l_source_ip)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(l_remote_ip)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(l_ip)
                                        .addGap(9, 9, 9))
                                    .addGroup(pan_north_east_topLayout.createSequentialGroup()
                                        .addComponent(comboB_source_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(comboB_remote_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pan_north_east_topLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pan_north_east_topLayout.createSequentialGroup()
                        .addComponent(l_battery_per)
                        .addGap(16, 16, 16)
                        .addComponent(l_robo_connect_per)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout pan_systam_statusLayout = new javax.swing.GroupLayout(pan_systam_status);
        pan_systam_status.setLayout(pan_systam_statusLayout);
        pan_systam_statusLayout.setHorizontalGroup(
            pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_systam_statusLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pan_north_east_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pan_north_east_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pan_systam_statusLayout.setVerticalGroup(
            pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addComponent(pan_north_east_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_north_east_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pan_northLayout = new javax.swing.GroupLayout(pan_north);
        pan_north.setLayout(pan_northLayout);
        pan_northLayout.setHorizontalGroup(
            pan_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_northLayout.createSequentialGroup()
                .addComponent(pan_systam_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(pan_live_streaming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(pan_robo_tracker, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pan_northLayout.setVerticalGroup(
            pan_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pan_live_streaming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pan_systam_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pan_robo_tracker, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pan_robo_tracker.getAccessibleContext().setAccessibleName("I-90 East");
        pan_robo_tracker.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout pan_rootLayout = new javax.swing.GroupLayout(pan_root);
        pan_root.setLayout(pan_rootLayout);
        pan_rootLayout.setHorizontalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pan_south_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pan_north, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pan_rootLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pan_north, pan_south_all});

        pan_rootLayout.setVerticalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pan_north, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_south_all, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jFormattedTextField1.setText("jFormattedTextField1");

        menu_file.setText("File");

        mnu_open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.META_MASK));
        mnu_open.setText("Open...");
        mnu_open.setToolTipText("");
        mnu_open.setActionCommand("mnu_file");
        mnu_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_openActionPerformed(evt);
            }
        });
        menu_file.add(mnu_open);

        mnu_saveas1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        mnu_saveas1.setText("Save");
        mnu_saveas1.setActionCommand("mnu_file");
        mnu_saveas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_saveas1ActionPerformed(evt);
            }
        });
        menu_file.add(mnu_saveas1);

        mnu_saveas.setText("Save As...");
        mnu_saveas.setActionCommand("mnu_file");
        mnu_saveas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_saveasActionPerformed(evt);
            }
        });
        menu_file.add(mnu_saveas);

        mnu_close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.META_MASK));
        mnu_close.setText("Close");
        mnu_close.setActionCommand("mnu_file");
        menu_file.add(mnu_close);

        mnu_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_MASK));
        mnu_exit.setText("Exit");
        mnu_exit.setActionCommand("mnu_file");
        menu_file.add(mnu_exit);

        jMenuBar1.add(menu_file);

        menu_edit.setText("Edit");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.META_MASK));
        jMenuItem7.setText("Cut");
        menu_edit.add(jMenuItem7);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.META_MASK));
        jMenuItem2.setText("Copy");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_edit.add(jMenuItem2);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.META_MASK));
        jMenuItem8.setText("Paste");
        menu_edit.add(jMenuItem8);

        jMenuBar1.add(menu_edit);

        menu_tools.setLabel("Tools");

        menu_tools2.setText("Preferences");
        menu_tools.add(menu_tools2);

        menu_tools3.setText("Tools");

        menu_tools4.setText("Inspection Tools");
        menu_tools3.add(menu_tools4);

        mnu_inspect_robot.setText("Inspect Robot");
        mnu_inspect_robot.setToolTipText("");
        mnu_inspect_robot.setActionCommand("inspectrobotactioncommand");
        mnu_inspect_robot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_inspect_robotActionPerformed(evt);
            }
        });
        menu_tools3.add(mnu_inspect_robot);

        jMenuItem6.setText("Workspace Organizer");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menu_tools3.add(jMenuItem6);

        jMenuItem9.setText("History Profiler");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menu_tools3.add(jMenuItem9);

        menu_tools.add(menu_tools3);

        jMenuItem4.setText("References");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu_tools.add(jMenuItem4);

        jMenuBar1.add(menu_tools);

        jMenu1.setText("Window");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0));
        jMenuItem3.setText("Full Screen");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        menu_about.setText("About");

        menu_help.setText("Help");
        menu_about.add(menu_help);

        menu_about1.setText("About ...");
        menu_about.add(menu_about1);

        jMenuBar1.add(menu_about);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pan_root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pan_root, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="init()">
    private void init() {

        // instantiate
        p_directionals = new JPanel();
        icon_up = new JLabel();
        icon_right = new JLabel();
        icon_left = new JLabel();
        icon_down = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // System.out.println(System.getProperty("user.dir"));
        // Get images to set as icons on label JComponents;
        // default state disabled
//        icon_up.setIcon(new ImageIcon(getClass().getResource(icon_path + "xbox_controller_arrow_pics/Arrow_up.jpg")));

        icon_up.setIcon(new ImageIcon(icon_path + "xbox_controller_arrow_pics/Arrow_up.jpg"));

        icon_up.setEnabled(false);

        //   icon_right.setIcon(new ImageIcon(getClass().getResource(icon_path + "xbox_controller_arrow_pics/Arrow_right.jpg"))); // NOI18N
        icon_right.setIcon(new ImageIcon(icon_path + "xbox_controller_arrow_pics/Arrow_right.jpg")); // NOI18N

        icon_right.setEnabled(false);

        // icon_left.setIcon(new ImageIcon(getClass().getResource(icon_path + "xbox_controller_arrow_pics/Arrow_left.jpg"))); // NOI18N
        icon_left.setIcon(new ImageIcon(icon_path + "xbox_controller_arrow_pics/Arrow_left.jpg")); // NOI18N

        icon_left.setEnabled(false);

        //  icon_down.setIcon(new ImageIcon(getClass().getResource(icon_path + "xbox_controller_arrow_pics/Arrow_down.jpg"))); // NOI18N
        icon_down.setIcon(new ImageIcon(icon_path + "xbox_controller_arrow_pics/Arrow_down.jpg")); // NOI18N

        icon_down.setEnabled(false);

        // Layour components
        org.jdesktop.layout.GroupLayout p_directionalsLayout = new org.jdesktop.layout.GroupLayout(p_directionals);
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
        new JFrame().add(p_directionals).setVisible(true);
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
   // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Action Performed">
    private void mnu_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_openActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_openActionPerformed

    private void cb_object_awareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_object_awareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_object_awareActionPerformed

    private void b_do_lookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_do_lookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_do_lookActionPerformed

    private void b_inspect_ceilingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_inspect_ceilingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_inspect_ceilingActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_saveActionPerformed

    private void tf_log_fpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_log_fpathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_log_fpathActionPerformed

    private void cb_output_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_output_logActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_output_logActionPerformed

    private void b_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_connectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_connectActionPerformed

    private void b_capture_momentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_capture_momentActionPerformed

        boolean tmp = media_pan.save_snap_shot();
        if (tmp) {
            System.out.println("Yupp, Snap!\n\n");
        } else {
            System.out.println("No Snap!\n\n");
        }
    }//GEN-LAST:event_b_capture_momentActionPerformed

    private void b_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loadActionPerformed
        FileDialog fd = new FileDialog(this, "TrivialJMFPlayer", FileDialog.LOAD);

        fd.setVisible(true);

        String dir = fd.getDirectory();
        String fname = fd.getFile();
        File f = new File(dir, fname);

        if (!f.exists()) {
            if (do_debug) {
                System.out.println("Open Dialog Box did not return a file chose.\n");
            }
            f_video_loaded[0] = false;
        } else {
            //    media_pan = new MyMediaPlayer(dir + "/" + fname);
            media_pan.playz(dir + fname);
            f_video_loaded[0] = true;
        }
        set_button_states();
    }//GEN-LAST:event_b_loadActionPerformed

    private void b_vid_muteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_muteActionPerformed

        media_pan.mute();

    }//GEN-LAST:event_b_vid_muteActionPerformed

    private void b_vid_ffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_ffActionPerformed
        media_pan.ff(b_vid_ff);
    }//GEN-LAST:event_b_vid_ffActionPerformed

    private void b_vid_pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_pauseActionPerformed
        media_pan.pause();
    }//GEN-LAST:event_b_vid_pauseActionPerformed

    private void b_vid_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_stopActionPerformed
        media_pan.stop();
    }//GEN-LAST:event_b_vid_stopActionPerformed

    private void b_vid_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_playActionPerformed
        media_pan.playz();
    }//GEN-LAST:event_b_vid_playActionPerformed

    private void b_vid_rwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_rwActionPerformed

    }//GEN-LAST:event_b_vid_rwActionPerformed

    private void b_analyze_anchorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_analyze_anchorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_analyze_anchorActionPerformed

    private void b_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logoutActionPerformed

    }//GEN-LAST:event_b_logoutActionPerformed

    private void comboB_remote_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboB_remote_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboB_remote_ipActionPerformed

    private void mnu_saveas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_saveas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_saveas1ActionPerformed

    private void mnu_saveasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_saveasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_saveasActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void logging_on(ActionEvent evt) {
//        evt.equals(evt);
        System.out.println(evt.getSource().toString());
        if (logger.get(0) == evt.getSource()) {
            if (do_debug) {
                System.out.println("Login");
            }

        } else if (logger.get(1) == evt.getSource()) {
            if (do_debug) {
                System.out.println("Register");
            }
        } else {
            if (do_debug) {
                System.out.println("Cancel");
            }
        }
    }
    private void b_logonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logonActionPerformed
//        try {

        pointer[0] = 0;
        Vector<JLabel> labs = new Vector<JLabel>();
        labs.add(l_inspector);
        labs.add(l_mid);
        labs.add(l_date);
        LogIn instance = new LogIn(pointer, labs);

        instance.setVisible(true);
//        instance.addWindowListener(this);
        instance.setName("LogOn");
        logger = instance.getButtons();
        for (int i = 0; i < 3; i++) {

            logger.get(i).addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    logging_on(evt);
                }
            });
        }
//        try {
//            instance.wait();
////        while (instance.isVisible()) {
////            System.out.println("Visible");
////            IJ.wait(5);
////
////        }
////        instance.addWindowListener(this);
////
////            System.out.println("Not");
//////        instance.setName("Log On");
////        } catch (InterruptedException ex) {
////            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        } catch (InterruptedException ex) {
////            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_b_logonActionPerformed

    private void b_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_closeActionPerformed
        if (media_pan.isPlaying()) {
            media_pan.stop();
        }
        f_video_loaded[0] = false;
        set_button_states();
    }//GEN-LAST:event_b_closeActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mnu_inspect_robotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_inspect_robotActionPerformed
        try {
            //        media_pan.playz("debris_robo_view.mov");
            Desktop.getDesktop().open(new File("~/Desktop/go.mpg"));
//        open();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu_v1_0.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnu_inspect_robotActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="WindowListeners">
    @Override
    public void windowClosing(WindowEvent e) {

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
    // <editor-fold defaultstate="collapsed" desc="KeyListeners">
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

    // </editor-fold>
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
            java.util.logging.Logger.getLogger(MainMenu_v1_0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu_v1_0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu_v1_0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu_v1_0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu_v1_0().setVisible(true);
//                new MobileDirectionDisplay().setVisible(true);
            }
        });
    }
    private Vector<JButton> logger;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_analyze_anchor;
    private javax.swing.JButton b_archive;
    private javax.swing.JButton b_capture_moment;
    private javax.swing.JButton b_close;
    private javax.swing.JButton b_connect;
    private javax.swing.JButton b_do_look;
    private javax.swing.JButton b_inspect_ceiling;
    private javax.swing.JButton b_load;
    private javax.swing.JButton b_logon;
    private javax.swing.JButton b_logout;
    private javax.swing.JButton b_reset;
    private javax.swing.JButton b_save;
    private javax.swing.JButton b_scan_hanger;
    private javax.swing.JButton b_set_flag;
    private javax.swing.JButton b_vid_ff;
    private javax.swing.JToggleButton b_vid_mute;
    private javax.swing.JButton b_vid_pause;
    private javax.swing.JButton b_vid_play;
    private javax.swing.JButton b_vid_rw;
    private javax.swing.JButton b_vid_stop;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas3;
    private java.awt.Canvas canvas4;
    private javax.swing.JCheckBox cb_object_aware;
    private javax.swing.JCheckBox cb_output_log;
    private javax.swing.JComboBox comboB_remote_ip;
    private javax.swing.JComboBox comboB_source_ip;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel l_battery;
    private javax.swing.JLabel l_battery_per;
    private javax.swing.JLabel l_cam_sig;
    private javax.swing.JLabel l_cam_sig_per;
    private javax.swing.JLabel l_data_logging;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_date_static;
    private javax.swing.JLabel l_ins;
    private javax.swing.JLabel l_ins_static;
    private javax.swing.JLabel l_inspect_static;
    private javax.swing.JLabel l_inspector;
    private javax.swing.JLabel l_ip;
    private javax.swing.JLabel l_log_file;
    private javax.swing.JLabel l_logging_per;
    private javax.swing.JLabel l_logo_icon;
    private javax.swing.JLabel l_mid;
    private javax.swing.JLabel l_mid__static;
    private javax.swing.JLabel l_plenum_map_icon;
    private javax.swing.JLabel l_progress;
    private javax.swing.JLabel l_progress_static;
    private javax.swing.JLabel l_r_id;
    private javax.swing.JLabel l_remote_ip;
    private javax.swing.JLabel l_robo_connect_per;
    private javax.swing.JLabel l_robot_connection;
    private javax.swing.JLabel l_source_ip;
    private javax.swing.JLabel l_speed;
    private javax.swing.JLabel l_speed_static;
    private javax.swing.JLabel l_vid_sig;
    private javax.swing.JLabel l_vid_sig_per;
    private javax.swing.JMenu menu_about;
    private javax.swing.JMenu menu_about1;
    private javax.swing.JMenu menu_edit;
    private javax.swing.JMenu menu_file;
    private javax.swing.JMenu menu_help;
    private javax.swing.JMenu menu_tools;
    private javax.swing.JMenu menu_tools2;
    private javax.swing.JMenu menu_tools3;
    private javax.swing.JMenu menu_tools4;
    private javax.swing.JMenuItem mnu_close;
    private javax.swing.JMenuItem mnu_exit;
    private javax.swing.JMenuItem mnu_inspect_robot;
    private javax.swing.JMenuItem mnu_open;
    private javax.swing.JMenuItem mnu_saveas;
    private javax.swing.JMenuItem mnu_saveas1;
    private javax.swing.JPanel p_media_player;
    private javax.swing.JPanel pan_live_streaming;
    private javax.swing.JPanel pan_media_control;
    private javax.swing.JPanel pan_north;
    private javax.swing.JPanel pan_north_east_bottom;
    private javax.swing.JPanel pan_north_east_top;
    private javax.swing.JPanel pan_robo_tracker;
    private javax.swing.JPanel pan_root;
    private javax.swing.JPanel pan_south_all;
    private javax.swing.JPanel pan_south_east;
    private javax.swing.JPanel pan_systam_status;
    private javax.swing.JPanel pan_vision_utils;
    private javax.swing.JProgressBar pb_battery;
    private javax.swing.JProgressBar pb_cam_sig_per;
    private javax.swing.JProgressBar pb_image_load;
    private javax.swing.JProgressBar pb_logging_per;
    private javax.swing.JProgressBar pb_robo_connect;
    private javax.swing.JProgressBar pb_vid_sig_per;
    private javax.swing.JScrollBar sb_vid_play;
    private javax.swing.JSeparator seperator1;
    private javax.swing.JTextField tf_ip;
    private javax.swing.JTextField tf_log_fpath;
    private javax.swing.JTextField tf_r_id;
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
