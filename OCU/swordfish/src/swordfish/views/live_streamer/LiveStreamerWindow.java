package swordfish.views.live_streamer;

//import swordfish.ui_develop.*;
//import swordfish.*;
//import ij.IJ;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container.*;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.KeyEvent.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.TitledBorder;
import swordfish.views.LogIn;

//import java.io.*;
/**
 *
 * @author jrob
 */
public class LiveStreamerWindow extends JFrame
        implements KeyListener, WindowListener {

    /**
     * Creates new form LiveStreamerWindow
     */
    int[] pointer = new int[1];
    private JLabel icon_down;
    private JLabel icon_left;
    private JLabel icon_right;
    private JLabel icon_up;
    private JPanel p_directionals;
    private boolean do_debug = true;
    boolean[] f_video_loaded = new boolean[1];
//    MyMediaPlayer media_pan;
    String icon_path = System.getProperty("user.dir") + "/resources/";

    public LiveStreamerWindow() {
        init();
        initComponents();
        initMediaPlayer();
        initContainer();
        f_video_loaded[0] = false;

        set_button_states();
        setResizable(true);
        pack();
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
//        addKeyListener(IJ.getInstance());

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
                .addGap(0, 0, Short.MAX_VALUE));
        p_media_playerLayout.setVerticalGroup(
                p_media_playerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 464, Short.MAX_VALUE));

        /* GroupLayout pan_video_streamLayout = new GroupLayout(pan_live_streaming);
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
         .addContainerGap()));
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
         .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
         media_pan = new MyMediaPlayer();*/
//        JPanel mediaFrame = media_pan.getF();
//        mediaFrame.setSize(p_media_player.getSize());

//        p_media_player.add(mediaFrame);
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

        jMenuItem1 = new JMenuItem();
        jScrollPane1 = new JScrollPane();
        jTextPane1 = new JTextPane();
        jMenuBar2 = new JMenuBar();
        jMenu2 = new JMenu();
        jMenu3 = new JMenu();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        pan_root = new JPanel();
        pan_north = new JPanel();
        p_media_player = new JPanel();
        pan_vision_utils = new JPanel();
        b_scan_hanger = new JButton();
        b_inspect_ceiling = new JButton();
        b_do_look = new JButton();
        b_analyze_anchor = new JButton();
        cb_object_aware = new JCheckBox();
        jCheckBox1 = new JCheckBox();
        jButton1 = new JButton();
        pan_media_control = new JPanel();
        jLabel5 = new JLabel();
        b_archive = new JButton();
        b_load = new JButton();
        b_set_flag = new JButton();
        sb_vid_play = new JScrollBar();
        b_capture_moment = new JButton();
        jLabel2 = new JLabel();
        b_close = new JButton();
        b_save = new JButton();
        pb_image_load = new JProgressBar();
        b_vid_mute = new JToggleButton();
        b_vid_rw = new JButton();
        b_vid_play = new JButton();
        b_vid_stop = new JButton();
        b_vid_ff = new JButton();
        b_vid_pause = new JButton();
        pan_robo_tracker = new JPanel();
        jLabel1 = new JLabel();
        l_speed_static = new JLabel();
        l_speed = new JLabel();
        l_ins = new JLabel();
        l_progress = new JLabel();
        l_progress_static = new JLabel();
        l_ins_static = new JLabel();
        seperator1 = new JSeparator();
        l_date_static = new JLabel();
        l_mid = new JLabel();
        l_logging_per = new JLabel();
        l_cam_sig_per = new JLabel();
        l_vid_sig_per = new JLabel();
        l_vid_sig = new JLabel();
        pb_vid_sig_per = new JProgressBar();
        l_cam_sig = new JLabel();
        pb_cam_sig_per = new JProgressBar();
        l_data_logging = new JLabel();
        pb_logging_per = new JProgressBar();
        pan_south_east = new JPanel();
        l_inspect_static = new JLabel();
        l_inspector = new JLabel();
        l_mid__static = new JLabel();
        l_date = new JLabel();
        b_logon = new JButton();
        l_logo_icon = new JLabel();
        pan_systam_status = new JPanel();
        cb_output_log = new JCheckBox();
        tf_log_fpath = new JTextField();
        l_log_file = new JLabel();
        l_robo_connect_per1 = new JLabel();
        pb_robo_connect1 = new JProgressBar();
        l_robot_connection1 = new JLabel();
        pb_battery1 = new JProgressBar();
        l_battery_per1 = new JLabel();
        l_battery1 = new JLabel();
        tf_ip1 = new JTextField();
        l_ip1 = new JLabel();
        l_remote_ip1 = new JLabel();
        comboB_remote_ip1 = new JComboBox();
        comboB_source_ip1 = new JComboBox();
        tf_r_id1 = new JTextField();
        l_r_id1 = new JLabel();
        l_source_ip1 = new JLabel();
        b_reset5 = new JButton();
        b_logout5 = new JButton();
        b_connect5 = new JButton();
        jMenuBar1 = new JMenuBar();
        menu_file = new JMenu();
        mnu_open = new JMenuItem();
        mnu_saveas1 = new JMenuItem();
        mnu_saveas = new JMenuItem();
        mnu_close = new JMenuItem();
        mnu_exit = new JMenuItem();
        menu_edit = new JMenu();
        jMenuItem7 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuItem8 = new JMenuItem();
        menu_tools = new JMenu();
        menu_tools2 = new JMenu();
        menu_tools3 = new JMenu();
        menu_tools4 = new JMenu();
        mnu_inspect_robot = new JMenuItem();
        jMenuItem6 = new JMenuItem();
        jMenuItem9 = new JMenuItem();
        jMenuItem4 = new JMenuItem();
        jMenu1 = new JMenu();
        jMenuItem3 = new JMenuItem();
        menu_about = new JMenu();
        menu_help = new JMenu();
        menu_about1 = new JMenu();

        jMenuItem1.setText("jMenuItem1");

        jScrollPane1.setViewportView(jTextPane1);

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inspector Robot");

        p_media_player.setBackground(new Color(51, 51, 51));
        p_media_player.setForeground(new Color(102, 102, 102));
        p_media_player.setMaximumSize(new Dimension(350, 32767));

        GroupLayout p_media_playerLayout = new GroupLayout(p_media_player);
        p_media_player.setLayout(p_media_playerLayout);
        p_media_playerLayout.setHorizontalGroup(
            p_media_playerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        p_media_playerLayout.setVerticalGroup(
            p_media_playerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        GroupLayout pan_northLayout = new GroupLayout(pan_north);
        pan_north.setLayout(pan_northLayout);
        pan_northLayout.setHorizontalGroup(
            pan_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_northLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_media_player, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pan_northLayout.setVerticalGroup(
            pan_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pan_northLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_media_player, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pan_vision_utils.setBorder(BorderFactory.createTitledBorder(null, "Vision Utils", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14))); // NOI18N

        b_scan_hanger.setText("Scan Hanger");

        b_inspect_ceiling.setText("Inspect Ceiling");
        b_inspect_ceiling.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_inspect_ceilingActionPerformed(evt);
            }
        });

        b_do_look.setText("Do Look Around");
        b_do_look.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_do_lookActionPerformed(evt);
            }
        });

        b_analyze_anchor.setText("Analyze Anchors");
        b_analyze_anchor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_analyze_anchorActionPerformed(evt);
            }
        });

        cb_object_aware.setText("Object Aware");
        cb_object_aware.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cb_object_awareActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Directionals On");

        jButton1.setText("Launch Image Viewer");

        GroupLayout pan_vision_utilsLayout = new GroupLayout(pan_vision_utils);
        pan_vision_utils.setLayout(pan_vision_utilsLayout);
        pan_vision_utilsLayout.setHorizontalGroup(
            pan_vision_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_vision_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(b_scan_hanger, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_analyze_anchor)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_inspect_ceiling)
                    .addComponent(b_do_look)
                    .addComponent(cb_object_aware))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_vision_utilsLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {b_analyze_anchor, b_do_look, b_inspect_ceiling, b_scan_hanger, jButton1});

        pan_vision_utilsLayout.setVerticalGroup(
            pan_vision_utilsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_object_aware)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_do_look)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_inspect_ceiling)
                .addGap(18, 18, 18)
                .addComponent(b_analyze_anchor)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_scan_hanger)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pan_vision_utilsLayout.linkSize(SwingConstants.VERTICAL, new Component[] {b_analyze_anchor, b_do_look, b_inspect_ceiling, b_scan_hanger, jButton1});

        pan_media_control.setBorder(BorderFactory.createTitledBorder(null, "Media Control", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14))); // NOI18N
        pan_media_control.setPreferredSize(new Dimension(121, 145));

        b_archive.setText("Archive");
        b_archive.setEnabled(false);

        b_load.setText("Load");
        b_load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_loadActionPerformed(evt);
            }
        });

        b_set_flag.setText("Set Flag");
        b_set_flag.setEnabled(false);

        sb_vid_play.setOrientation(JScrollBar.HORIZONTAL);

        b_capture_moment.setBackground(new Color(153, 255, 255));
        b_capture_moment.setIcon(new ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/video_image_control_icons/camera_icon_small.jpg")); // NOI18N
        b_capture_moment.setEnabled(false);
        b_capture_moment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_capture_momentActionPerformed(evt);
            }
        });

        jLabel2.setText("-- / --");

        b_close.setText("Close");
        b_close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_closeActionPerformed(evt);
            }
        });

        b_save.setText("Save");
        b_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        pb_image_load.setValue(30);
        pb_image_load.setEnabled(false);

        b_vid_mute.setIcon(new ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/mute_icon.jpg")); // NOI18N
        b_vid_mute.setContentAreaFilled(false);
        b_vid_mute.setEnabled(false);
        b_vid_mute.setFocusable(false);
        b_vid_mute.setHorizontalTextPosition(SwingConstants.CENTER);
        b_vid_mute.setMaximumSize(new Dimension(50, 50));
        b_vid_mute.setPreferredSize(new Dimension(40, 40));
        b_vid_mute.setVerticalTextPosition(SwingConstants.BOTTOM);
        b_vid_mute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_vid_muteActionPerformed(evt);
            }
        });

        b_vid_rw.setIcon(new ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/rewind_icon.jpg")); // NOI18N
        b_vid_rw.setEnabled(false);
        b_vid_rw.setFocusable(false);
        b_vid_rw.setHorizontalTextPosition(SwingConstants.CENTER);
        b_vid_rw.setMaximumSize(new Dimension(50, 50));
        b_vid_rw.setMinimumSize(new Dimension(50, 50));
        b_vid_rw.setPreferredSize(new Dimension(50, 50));
        b_vid_rw.setVerticalTextPosition(SwingConstants.BOTTOM);
        b_vid_rw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_vid_rwActionPerformed(evt);
            }
        });

        b_vid_play.setIcon(new ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/play_icon.jpg")); // NOI18N
        b_vid_play.setEnabled(false);
        b_vid_play.setFocusable(false);
        b_vid_play.setHorizontalTextPosition(SwingConstants.CENTER);
        b_vid_play.setMaximumSize(new Dimension(50, 50));
        b_vid_play.setMinimumSize(new Dimension(50, 50));
        b_vid_play.setPreferredSize(new Dimension(50, 50));
        b_vid_play.setVerticalTextPosition(SwingConstants.BOTTOM);
        b_vid_play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_vid_playActionPerformed(evt);
            }
        });

        b_vid_stop.setIcon(new ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/stop_icon.jpg")); // NOI18N
        b_vid_stop.setEnabled(false);
        b_vid_stop.setFocusable(false);
        b_vid_stop.setHorizontalTextPosition(SwingConstants.CENTER);
        b_vid_stop.setMaximumSize(new Dimension(50, 50));
        b_vid_stop.setMinimumSize(new Dimension(50, 50));
        b_vid_stop.setPreferredSize(new Dimension(50, 50));
        b_vid_stop.setVerticalTextPosition(SwingConstants.BOTTOM);
        b_vid_stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_vid_stopActionPerformed(evt);
            }
        });

        b_vid_ff.setIcon(new ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/ff_icon.jpg")); // NOI18N
        b_vid_ff.setBorderPainted(false);
        b_vid_ff.setEnabled(false);
        b_vid_ff.setFocusable(false);
        b_vid_ff.setHorizontalTextPosition(SwingConstants.CENTER);
        b_vid_ff.setMaximumSize(new Dimension(50, 50));
        b_vid_ff.setMinimumSize(new Dimension(50, 50));
        b_vid_ff.setPreferredSize(new Dimension(50, 50));
        b_vid_ff.setVerticalTextPosition(SwingConstants.BOTTOM);
        b_vid_ff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_vid_ffActionPerformed(evt);
            }
        });

        b_vid_pause.setIcon(new ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/pause_icon.jpg")); // NOI18N
        b_vid_pause.setEnabled(false);
        b_vid_pause.setFocusable(false);
        b_vid_pause.setHorizontalTextPosition(SwingConstants.CENTER);
        b_vid_pause.setMaximumSize(new Dimension(50, 50));
        b_vid_pause.setMinimumSize(new Dimension(50, 50));
        b_vid_pause.setPreferredSize(new Dimension(50, 50));
        b_vid_pause.setVerticalTextPosition(SwingConstants.BOTTOM);
        b_vid_pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_vid_pauseActionPerformed(evt);
            }
        });

        GroupLayout pan_media_controlLayout = new GroupLayout(pan_media_control);
        pan_media_control.setLayout(pan_media_controlLayout);
        pan_media_controlLayout.setHorizontalGroup(
            pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_media_controlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(GroupLayout.Alignment.TRAILING, pan_media_controlLayout.createSequentialGroup()
                        .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(sb_vid_play, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_capture_moment, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, pan_media_controlLayout.createSequentialGroup()
                                .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b_load, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pb_image_load, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(b_save)
                                    .addComponent(b_archive, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b_close, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b_set_flag, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.LEADING, pan_media_controlLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(b_vid_rw, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_play, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_stop, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_pause, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_ff, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_vid_mute, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 50, Short.MAX_VALUE)))
                        .addGap(11, 11, 11))))
        );

        pan_media_controlLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {b_vid_ff, b_vid_mute, b_vid_pause, b_vid_play, b_vid_rw, b_vid_stop});

        pan_media_controlLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {b_archive, b_close, b_load, b_save, b_set_flag});

        pan_media_controlLayout.setVerticalGroup(
            pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pan_media_controlLayout.createSequentialGroup()
                .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addComponent(sb_vid_play, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(b_capture_moment, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(b_vid_rw, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(b_vid_play, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(b_vid_stop, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(b_vid_pause, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(b_vid_ff, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addComponent(b_vid_mute, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(b_archive, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_load, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                .addGroup(pan_media_controlLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(b_save, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pb_image_load, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addComponent(b_close, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(b_set_flag, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );

        pan_media_controlLayout.linkSize(SwingConstants.VERTICAL, new Component[] {b_vid_ff, b_vid_mute, b_vid_pause, b_vid_play, b_vid_rw, b_vid_stop});

        pan_media_controlLayout.linkSize(SwingConstants.VERTICAL, new Component[] {b_archive, b_close, b_load, b_save, b_set_flag});

        pan_robo_tracker.setPreferredSize(new Dimension(294, 512));

        jLabel1.setIcon(new JLabel() {
            public Icon getIcon() {
                try {
                    return new ImageIcon(
                        new URL("file:/Users/jrob/Desktop/tunnel_map-8.jpg")
                    );
                } catch (        MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        l_speed_static.setFont(new Font("Lucida Grande", 2, 13)); // NOI18N
        l_speed_static.setText("Speed:");

        l_speed.setText("-- ");

        l_ins.setText("- - --");

        l_progress.setText("# / #");

        l_progress_static.setFont(new Font("Lucida Grande", 2, 13)); // NOI18N
        l_progress_static.setText("Progress");

        l_ins_static.setFont(new Font("Lucida Grande", 2, 13)); // NOI18N
        l_ins_static.setText("INS:");

        seperator1.setOrientation(SwingConstants.VERTICAL);

        l_date_static.setFont(new Font("Lucida Grande", 2, 13)); // NOI18N
        l_date_static.setText("Date:");

        l_mid.setText("    - - -  ");

        l_logging_per.setText("0%");

        l_cam_sig_per.setText("0%");

        l_vid_sig_per.setText("0%");

        l_vid_sig.setFont(new Font("Lucida Grande", 3, 13)); // NOI18N
        l_vid_sig.setText("Video Signal");

        l_cam_sig.setFont(new Font("Lucida Grande", 3, 13)); // NOI18N
        l_cam_sig.setText("Camera Signal");

        l_data_logging.setFont(new Font("Lucida Grande", 3, 13)); // NOI18N
        l_data_logging.setText("Data Logging");

        GroupLayout pan_robo_trackerLayout = new GroupLayout(pan_robo_tracker);
        pan_robo_tracker.setLayout(pan_robo_trackerLayout);
        pan_robo_trackerLayout.setHorizontalGroup(
            pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(l_speed_static)
                            .addComponent(l_ins_static))
                        .addGap(18, 18, 18)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(l_speed))
                            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                .addComponent(l_ins)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seperator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                .addComponent(l_progress_static, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l_progress))
                            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                .addComponent(l_date_static)
                                .addGap(6, 6, 6)
                                .addComponent(l_mid))))
                    .addComponent(l_vid_sig)
                    .addGroup(GroupLayout.Alignment.TRAILING, pan_robo_trackerLayout.createSequentialGroup()
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(l_cam_sig)
                                .addComponent(l_data_logging)
                                .addComponent(pb_cam_sig_per, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                            .addComponent(pb_vid_sig_per, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pb_logging_per, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(l_logging_per)
                            .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(l_vid_sig_per)
                                .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(l_cam_sig_per))))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );
        pan_robo_trackerLayout.setVerticalGroup(
            pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addComponent(l_speed_static)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_ins_static))
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                .addComponent(l_speed, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l_ins, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                            .addComponent(seperator1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                            .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(l_progress_static)
                                .addComponent(l_progress, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(l_mid)
                                .addComponent(l_date_static)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_vid_sig)
                .addGap(8, 8, 8)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addComponent(pb_vid_sig_per, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_cam_sig))
                    .addComponent(l_logging_per))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addComponent(pb_cam_sig_per, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_data_logging, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                    .addComponent(l_vid_sig_per))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(l_cam_sig_per)
                    .addComponent(pb_logging_per, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pan_robo_trackerLayout.linkSize(SwingConstants.VERTICAL, new Component[] {pb_cam_sig_per, pb_logging_per, pb_vid_sig_per});

        pan_south_east.setBorder(BorderFactory.createTitledBorder(" "));

        l_inspect_static.setFont(new Font("Lucida Grande", 2, 13)); // NOI18N
        l_inspect_static.setText("Inspector:");

        l_inspector.setFont(new Font("Lucida Grande", 1, 13)); // NOI18N
        l_inspector.setText("   - - -  ");

        l_mid__static.setFont(new Font("Lucida Grande", 2, 13)); // NOI18N
        l_mid__static.setText("MID:");

        l_date.setText("     - - -  ");

        b_logon.setText("Log-on");
        b_logon.setActionCommand("b_logon");
        b_logon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_logonActionPerformed(evt);
            }
        });

        l_logo_icon.setIcon(new ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/company_logo_small.jpg")); // NOI18N

        GroupLayout pan_south_eastLayout = new GroupLayout(pan_south_east);
        pan_south_east.setLayout(pan_south_eastLayout);
        pan_south_eastLayout.setHorizontalGroup(
            pan_south_eastLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_south_eastLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pan_south_eastLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addComponent(l_inspect_static)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_inspector))
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pan_south_eastLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pan_south_eastLayout.createSequentialGroup()
                                .addComponent(l_mid__static)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l_date))
                            .addComponent(l_logo_icon, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, pan_south_eastLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_logon)
                .addContainerGap())
        );
        pan_south_eastLayout.setVerticalGroup(
            pan_south_eastLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_south_eastLayout.createSequentialGroup()
                .addComponent(b_logon)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_south_eastLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(l_inspect_static)
                    .addComponent(l_inspector))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_south_eastLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(l_mid__static)
                    .addComponent(l_date, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_logo_icon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cb_output_log.setText("Save Log to File");
        cb_output_log.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        cb_output_log.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cb_output_logActionPerformed(evt);
            }
        });

        tf_log_fpath.setText("...ecenu/051814.log");
        tf_log_fpath.setToolTipText("");
        tf_log_fpath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tf_log_fpathActionPerformed(evt);
            }
        });

        l_log_file.setText("Log File:");
        l_log_file.setToolTipText("");

        l_robo_connect_per1.setText(" --");

        l_robot_connection1.setFont(new Font("Lucida Grande", 3, 13)); // NOI18N
        l_robot_connection1.setText("Robot Connection ");

        pb_battery1.setBorderPainted(false);

        l_battery_per1.setText(" --");

        l_battery1.setFont(new Font("Lucida Grande", 3, 13)); // NOI18N
        l_battery1.setText("Battery");

        tf_ip1.setFont(new Font("Lucida Grande", 0, 10)); // NOI18N
        tf_ip1.setText("192.168.1.2");

        l_ip1.setFont(new Font("Lucida Grande", 2, 11)); // NOI18N
        l_ip1.setText("IP: ");

        l_remote_ip1.setFont(new Font("Lucida Grande", 2, 11)); // NOI18N
        l_remote_ip1.setText("Remote IP: ");

        comboB_remote_ip1.setFont(new Font("Lucida Grande", 0, 10)); // NOI18N
        comboB_remote_ip1.setModel(new DefaultComboBoxModel(new String[] { "localHost" }));
        comboB_remote_ip1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboB_remote_ip1ActionPerformed(evt);
            }
        });

        comboB_source_ip1.setFont(new Font("Lucida Grande", 0, 10)); // NOI18N
        comboB_source_ip1.setModel(new DefaultComboBoxModel(new String[] { "localHost" }));

        tf_r_id1.setFont(new Font("Lucida Grande", 0, 10)); // NOI18N
        tf_r_id1.setText("Barracuda");

        l_r_id1.setFont(new Font("Lucida Grande", 2, 11)); // NOI18N
        l_r_id1.setText("R-ID:");

        l_source_ip1.setFont(new Font("Lucida Grande", 2, 11)); // NOI18N
        l_source_ip1.setText("Source IP: ");

        b_reset5.setBackground(new Color(255, 102, 102));
        b_reset5.setFont(new Font("Lucida Grande", 0, 10)); // NOI18N
        b_reset5.setText("Reset");

        b_logout5.setBackground(new Color(255, 51, 51));
        b_logout5.setFont(new Font("Lucida Grande", 0, 10)); // NOI18N
        b_logout5.setText("Logout");
        b_logout5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_logout5b_logoutActionPerformed(evt);
            }
        });

        b_connect5.setBackground(new Color(0, 204, 51));
        b_connect5.setFont(new Font("Lucida Grande", 0, 10)); // NOI18N
        b_connect5.setText("Connect");
        b_connect5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_connect5b_connectActionPerformed(evt);
            }
        });

        GroupLayout pan_systam_statusLayout = new GroupLayout(pan_systam_status);
        pan_systam_status.setLayout(pan_systam_statusLayout);
        pan_systam_statusLayout.setHorizontalGroup(
            pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addComponent(l_robot_connection1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(pb_battery1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pb_robo_connect1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(l_battery_per1)
                            .addComponent(l_robo_connect_per1))
                        .addGap(6, 6, 6))
                    .addGroup(GroupLayout.Alignment.TRAILING, pan_systam_statusLayout.createSequentialGroup()
                        .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(l_r_id1))
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(l_ip1))
                            .addComponent(l_remote_ip1)
                            .addComponent(l_source_ip1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(comboB_source_ip1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboB_remote_ip1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_ip1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_r_id1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(l_battery1)
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(l_log_file)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_log_fpath, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                        .addComponent(b_connect5, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(b_reset5, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(b_logout5, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cb_output_log))))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pan_systam_statusLayout.setVerticalGroup(
            pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addComponent(l_battery1)
                .addGap(0, 0, 0)
                .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addComponent(pb_battery1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(l_robot_connection1)
                        .addGap(0, 0, 0)
                        .addComponent(pb_robo_connect1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addComponent(l_battery_per1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_robo_connect_per1)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tf_r_id1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_r_id1))
                .addGap(0, 0, 0)
                .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(GroupLayout.Alignment.TRAILING, pan_systam_statusLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(l_source_ip1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_remote_ip1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_ip1))
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addComponent(comboB_source_ip1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(comboB_remote_ip1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(tf_ip1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_logout5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(b_reset5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_connect5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pan_systam_statusLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_log_fpath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_log_file))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_output_log, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        GroupLayout pan_rootLayout = new GroupLayout(pan_root);
        pan_root.setLayout(pan_rootLayout);
        pan_rootLayout.setHorizontalGroup(
            pan_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pan_systam_status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pan_robo_tracker, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pan_north, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(pan_rootLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pan_media_control, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pan_vision_utils, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pan_south_east, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pan_rootLayout.setVerticalGroup(
            pan_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pan_rootLayout.createSequentialGroup()
                .addGroup(pan_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(pan_rootLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pan_systam_status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pan_robo_tracker, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_rootLayout.createSequentialGroup()
                        .addGroup(pan_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(pan_north, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pan_vision_utils, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(pan_media_control, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(pan_south_east, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_robo_tracker.getAccessibleContext().setAccessibleName("I-90 East");
        pan_robo_tracker.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(pan_root, BorderLayout.CENTER);

        menu_file.setText("File");

        mnu_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.META_MASK));
        mnu_open.setText("Open...");
        mnu_open.setToolTipText("");
        mnu_open.setActionCommand("mnu_file");
        mnu_open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnu_openActionPerformed(evt);
            }
        });
        menu_file.add(mnu_open);

        mnu_saveas1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_MASK));
        mnu_saveas1.setText("Save");
        mnu_saveas1.setActionCommand("mnu_file");
        mnu_saveas1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnu_saveas1ActionPerformed(evt);
            }
        });
        menu_file.add(mnu_saveas1);

        mnu_saveas.setText("Save As...");
        mnu_saveas.setActionCommand("mnu_file");
        mnu_saveas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnu_saveasActionPerformed(evt);
            }
        });
        menu_file.add(mnu_saveas);

        mnu_close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.META_MASK));
        mnu_close.setText("Close");
        mnu_close.setActionCommand("mnu_file");
        menu_file.add(mnu_close);

        mnu_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.META_MASK));
        mnu_exit.setText("Exit");
        mnu_exit.setActionCommand("mnu_file");
        menu_file.add(mnu_exit);

        jMenuBar1.add(menu_file);

        menu_edit.setText("Edit");

        jMenuItem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.META_MASK));
        jMenuItem7.setText("Cut");
        menu_edit.add(jMenuItem7);

        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.META_MASK));
        jMenuItem2.setText("Copy");
        jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_edit.add(jMenuItem2);

        jMenuItem8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.META_MASK));
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
        mnu_inspect_robot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mnu_inspect_robotActionPerformed(evt);
            }
        });
        menu_tools3.add(mnu_inspect_robot);

        jMenuItem6.setText("Workspace Organizer");
        jMenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menu_tools3.add(jMenuItem6);

        jMenuItem9.setText("History Profiler");
        jMenuItem9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menu_tools3.add(jMenuItem9);

        menu_tools.add(menu_tools3);

        jMenuItem4.setText("References");
        jMenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu_tools.add(jMenuItem4);

        jMenuBar1.add(menu_tools);

        jMenu1.setText("Window");

        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0));
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
        GroupLayout p_directionalsLayout = new GroupLayout(p_directionals);
        getContentPane().setLayout(p_directionalsLayout);
        p_directionalsLayout.setHorizontalGroup(
                p_directionalsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(p_directionalsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon_left, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                //                .addGap(GroupLayout.DEFAULT_SIZE)
                //                                .addPreferredGap()
                .addGroup(p_directionalsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(icon_up, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addComponent(icon_down))
                //                .addGap(GroupLayout.DEFAULT_SIZE)
                .addComponent(icon_right)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        p_directionalsLayout.setVerticalGroup(
                p_directionalsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(p_directionalsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_directionalsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(p_directionalsLayout.createSequentialGroup()
                .addComponent(icon_up)
                //                                        .addPreferredGap(GroupLayout.RELATED)
                //                .addGap(GroupLayout.PREFERRED_SIZE)
                .addComponent(icon_down))
                .addGroup(p_directionalsLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(p_directionalsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(icon_right)
                .addComponent(icon_left))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        icon_up.getAccessibleContext().setAccessibleName("U");
        icon_left.getAccessibleContext().setAccessibleName("Up");
        icon_down.getAccessibleContext().setAccessibleName("L_down");
        new JFrame().add(p_directionals).setVisible(true);

        //       ControllerEnvironment.getDefaultEnvironment().addControllerListener(this);
        addKeyListener(this);

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Action Performed">
    private void mnu_openActionPerformed(ActionEvent evt) {//GEN-FIRST:event_mnu_openActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_openActionPerformed

    private void mnu_saveas1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_mnu_saveas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_saveas1ActionPerformed

    private void mnu_saveasActionPerformed(ActionEvent evt) {//GEN-FIRST:event_mnu_saveasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_saveasActionPerformed

    private void jMenuItem2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
    private void jMenuItem4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mnu_inspect_robotActionPerformed(ActionEvent evt) {//GEN-FIRST:event_mnu_inspect_robotActionPerformed
        try {
            //        media_pan.playz("debris_robo_view.mov");
            Desktop.getDesktop().open(new File("~/Desktop/go.mpg"));
//        open();
        } catch (IOException ex) {
            Logger.getLogger(LiveStreamerWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnu_inspect_robotActionPerformed

    private void jMenuItem9ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void b_vid_pauseActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_vid_pauseActionPerformed
//        media_pan.pause();
    }//GEN-LAST:event_b_vid_pauseActionPerformed

    private void b_vid_ffActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_vid_ffActionPerformed
//        media_pan.ff(b_vid_ff);
    }//GEN-LAST:event_b_vid_ffActionPerformed

    private void b_vid_stopActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_vid_stopActionPerformed
//        media_pan.stop();
    }//GEN-LAST:event_b_vid_stopActionPerformed

    private void b_vid_playActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_vid_playActionPerformed
//        media_pan.playz();
    }//GEN-LAST:event_b_vid_playActionPerformed

    private void b_vid_rwActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_vid_rwActionPerformed
    }//GEN-LAST:event_b_vid_rwActionPerformed

    private void b_vid_muteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_vid_muteActionPerformed
//        media_pan.mute();
    }//GEN-LAST:event_b_vid_muteActionPerformed

    private void b_saveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_closeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_closeActionPerformed
//        if (media_pan.isPlaying()) {
//            media_pan.stop();
//        }
        f_video_loaded[0] = false;
        set_button_states();
    }//GEN-LAST:event_b_closeActionPerformed

    private void b_capture_momentActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_capture_momentActionPerformed
        /*
         boolean tmp = media_pan.save_snap_shot();
         if (tmp) {
         System.out.println("Yupp, Snap!\n\n");
         } else {
         System.out.println("No Snap!\n\n");
         }*/
    }//GEN-LAST:event_b_capture_momentActionPerformed

    private void b_loadActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_loadActionPerformed
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
//            media_pan.playz(dir + fname);
            f_video_loaded[0] = true;
        }
        set_button_states();
    }//GEN-LAST:event_b_loadActionPerformed

    private void cb_object_awareActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cb_object_awareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_object_awareActionPerformed

    private void b_analyze_anchorActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_analyze_anchorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_analyze_anchorActionPerformed

    private void b_do_lookActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_do_lookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_do_lookActionPerformed

    private void b_inspect_ceilingActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_inspect_ceilingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_inspect_ceilingActionPerformed

    private void b_logonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_logonActionPerformed
        //        try {

        pointer[0] = 0;
        ArrayList<JLabel> labs = new ArrayList<JLabel>();
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
        ////            Logger.getLogger(LiveStreamerWindow.class.getName()).log(Level.SEVERE, null, ex);
        ////        }
        //        } catch (InterruptedException ex) {
        ////            Logger.getLogger(LiveStreamerWindow.class.getName()).log(Level.SEVERE, null, ex);
        //        }
    }//GEN-LAST:event_b_logonActionPerformed

    private void cb_output_logActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cb_output_logActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_output_logActionPerformed

    private void tf_log_fpathActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tf_log_fpathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_log_fpathActionPerformed

    private void comboB_remote_ip1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_comboB_remote_ip1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboB_remote_ip1ActionPerformed

    private void b_logout5b_logoutActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_logout5b_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_logout5b_logoutActionPerformed

    private void b_connect5b_connectActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_connect5b_connectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_connect5b_connectActionPerformed

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
        } catch (Exception ex) {
            Logger.getLogger(LiveStreamerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LiveStreamerWindow().setVisible(true);
//                new MobileDirectionDisplay().setVisible(true);
            }
        });
    }
    private ArrayList<JButton> logger;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton b_analyze_anchor;
    private JButton b_archive;
    private JButton b_capture_moment;
    private JButton b_close;
    private JButton b_connect5;
    private JButton b_do_look;
    private JButton b_inspect_ceiling;
    private JButton b_load;
    private JButton b_logon;
    private JButton b_logout5;
    private JButton b_reset5;
    private JButton b_save;
    private JButton b_scan_hanger;
    private JButton b_set_flag;
    private JButton b_vid_ff;
    private JToggleButton b_vid_mute;
    private JButton b_vid_pause;
    private JButton b_vid_play;
    private JButton b_vid_rw;
    private JButton b_vid_stop;
    private JCheckBox cb_object_aware;
    private JCheckBox cb_output_log;
    private JComboBox comboB_remote_ip1;
    private JComboBox comboB_source_ip1;
    private JButton jButton1;
    private JCheckBox jCheckBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenuBar jMenuBar1;
    private JMenuBar jMenuBar2;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem6;
    private JMenuItem jMenuItem7;
    private JMenuItem jMenuItem8;
    private JMenuItem jMenuItem9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextPane jTextPane1;
    private JLabel l_battery1;
    private JLabel l_battery_per1;
    private JLabel l_cam_sig;
    private JLabel l_cam_sig_per;
    private JLabel l_data_logging;
    private JLabel l_date;
    private JLabel l_date_static;
    private JLabel l_ins;
    private JLabel l_ins_static;
    private JLabel l_inspect_static;
    private JLabel l_inspector;
    private JLabel l_ip1;
    private JLabel l_log_file;
    private JLabel l_logging_per;
    private JLabel l_logo_icon;
    private JLabel l_mid;
    private JLabel l_mid__static;
    private JLabel l_progress;
    private JLabel l_progress_static;
    private JLabel l_r_id1;
    private JLabel l_remote_ip1;
    private JLabel l_robo_connect_per1;
    private JLabel l_robot_connection1;
    private JLabel l_source_ip1;
    private JLabel l_speed;
    private JLabel l_speed_static;
    private JLabel l_vid_sig;
    private JLabel l_vid_sig_per;
    private JMenu menu_about;
    private JMenu menu_about1;
    private JMenu menu_edit;
    private JMenu menu_file;
    private JMenu menu_help;
    private JMenu menu_tools;
    private JMenu menu_tools2;
    private JMenu menu_tools3;
    private JMenu menu_tools4;
    private JMenuItem mnu_close;
    private JMenuItem mnu_exit;
    private JMenuItem mnu_inspect_robot;
    private JMenuItem mnu_open;
    private JMenuItem mnu_saveas;
    private JMenuItem mnu_saveas1;
    private JPanel p_media_player;
    private JPanel pan_media_control;
    private JPanel pan_north;
    private JPanel pan_robo_tracker;
    private JPanel pan_root;
    private JPanel pan_south_east;
    private JPanel pan_systam_status;
    private JPanel pan_vision_utils;
    private JProgressBar pb_battery1;
    private JProgressBar pb_cam_sig_per;
    private JProgressBar pb_image_load;
    private JProgressBar pb_logging_per;
    private JProgressBar pb_robo_connect1;
    private JProgressBar pb_vid_sig_per;
    private JScrollBar sb_vid_play;
    private JSeparator seperator1;
    private JTextField tf_ip1;
    private JTextField tf_log_fpath;
    private JTextField tf_r_id1;
    // End of variables declaration//GEN-END:variables
//    private void printn(String property) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
