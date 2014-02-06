package swordfish.views.window;

//import swordfish.ui_develop.*;
//import swordfish.*;
//import ij.IJ;
//import java.awt.BorderLayout;
//import java.awt.Canvas;
import java.awt.Color;
//import java.awt.Component;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container.*;
//import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
//import java.awt.Font;
//import java.awt.LayoutManager;
import java.awt.event.KeyEvent.*;
import java.io.File;
import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.border.TitledBorder;
//import swordfish.controllers.RobotController;
import swordfish.views.dialog.LogIn;
import swordfish.views.MobileDirectionDisplayKeyboard;
import swordfish.applications.LiveStreamer;
//import java.io.*;

/**
 *
 * @author jrob
 */
public class LiveStreamerWindow extends JFrame
        implements KeyListener, WindowListener {

    private JFrame frmLiveStreamerDisplay;
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
//    MobileDirectionDisplayKeyboard mddk = new MobileDirectionDisplayKeyboard();
//    MyMediaPlayer media_pan;
    String icon_path = System.getProperty("user.dir") + "/resources/";

    public LiveStreamerWindow() {
//        super("ddd");

        initComponents();
        initMediaPlayer();
        init();
        initContainer();
        frmLiveStreamerDisplay = this;
        f_video_loaded[0] = false;

        set_button_states();
        setResizable(false);
//        JPanel p_directionals = new MobileDirectionDisplayKeyboard().getPanelDisplay();
//        p_directionals.setVisible(true);

//        pan_directionals.add(p_directionals);
//        pack();
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
//        this.pack();
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
//        media_pan = new MyMediaPlayer();
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pan_root = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pan_robo_tracker = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        l_speed_static = new javax.swing.JLabel();
        l_speed = new javax.swing.JLabel();
        l_ins = new javax.swing.JLabel();
        l_progress = new javax.swing.JLabel();
        l_progress_static = new javax.swing.JLabel();
        l_ins_static = new javax.swing.JLabel();
        seperator1 = new javax.swing.JSeparator();
        l_date_static = new javax.swing.JLabel();
        l_mid = new javax.swing.JLabel();
        l_logging_per = new javax.swing.JLabel();
        l_cam_sig_per = new javax.swing.JLabel();
        l_vid_sig_per = new javax.swing.JLabel();
        l_vid_sig = new javax.swing.JLabel();
        pb_vid_sig_per = new javax.swing.JProgressBar();
        l_cam_sig = new javax.swing.JLabel();
        pb_cam_sig_per = new javax.swing.JProgressBar();
        l_data_logging = new javax.swing.JLabel();
        pb_logging_per = new javax.swing.JProgressBar();
        pb_robo_connect1 = new javax.swing.JProgressBar();
        l_robo_connect_per1 = new javax.swing.JLabel();
        l_battery_per1 = new javax.swing.JLabel();
        l_battery1 = new javax.swing.JLabel();
        pb_battery1 = new javax.swing.JProgressBar();
        l_robot_connection1 = new javax.swing.JLabel();
        pan_south_east = new javax.swing.JPanel();
        l_inspect_static = new javax.swing.JLabel();
        l_inspector = new javax.swing.JLabel();
        l_mid__static = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        b_logon = new javax.swing.JButton();
        l_logo_icon = new javax.swing.JLabel();
        b_logon1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pan_media_control = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        b_archive = new javax.swing.JButton();
        b_load = new javax.swing.JButton();
        b_set_flag = new javax.swing.JButton();
        sb_vid_play = new javax.swing.JScrollBar();
        b_capture_moment = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        b_close = new javax.swing.JButton();
        b_vid_mute = new javax.swing.JToggleButton();
        b_vid_rw = new javax.swing.JButton();
        b_vid_play = new javax.swing.JButton();
        b_vid_stop = new javax.swing.JButton();
        b_vid_ff = new javax.swing.JButton();
        b_vid_pause = new javax.swing.JButton();
        pan_north = new javax.swing.JPanel();
        pan_live_streaming = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        canvas3 = new java.awt.Canvas();
        canvas4 = new java.awt.Canvas();
        p_media_player = new javax.swing.JPanel();
        pan_north_east_bottom = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pan_vision_utils = new javax.swing.JPanel();
        b_scan_hanger = new javax.swing.JButton();
        b_inspect_ceiling = new javax.swing.JButton();
        b_analyze_anchor = new javax.swing.JButton();
        cb_object_aware = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        pan_systam_status = new javax.swing.JPanel();
        tf_video_port = new javax.swing.JTextField();
        l_ip1 = new javax.swing.JLabel();
        l_remote_ip1 = new javax.swing.JLabel();
        tf_r_id1 = new javax.swing.JTextField();
        l_r_id1 = new javax.swing.JLabel();
        l_source_ip1 = new javax.swing.JLabel();
        b_reset5 = new javax.swing.JButton();
        b_logout5 = new javax.swing.JButton();
        b_connect = new javax.swing.JButton();
        tf_controller_port = new javax.swing.JTextField();
        tf_source_ip = new javax.swing.JTextField();
        cb_controller_connected = new javax.swing.JCheckBox();
        l_controller_connected = new javax.swing.JLabel();
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
        menu_tools4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        mnu_inspect_robot = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menu_tools2 = new javax.swing.JMenu();
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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inspector Robot");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pan_root.setPreferredSize(new java.awt.Dimension(900, 745));

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

        l_speed_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_speed_static.setText("Speed:");

        l_speed.setText("-- ");

        l_ins.setText("- - --");

        l_progress.setText("# / #");

        l_progress_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_progress_static.setText("Progress");

        l_ins_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_ins_static.setText("INS:");

        seperator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        l_date_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_date_static.setText("Date:");

        l_mid.setText("- -  ");

        l_logging_per.setText("94%");

        l_cam_sig_per.setText("100%");

        l_vid_sig_per.setText("96%");

        l_vid_sig.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_vid_sig.setText("Video Signal");

        pb_vid_sig_per.setValue(94);

        l_cam_sig.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_cam_sig.setText("Camera Signal");

        pb_cam_sig_per.setValue(96);

        l_data_logging.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_data_logging.setText("Data Logging");

        pb_logging_per.setValue(100);

        pb_robo_connect1.setValue(97);

        l_robo_connect_per1.setText("97%");

        l_battery_per1.setText("82%");

        l_battery1.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_battery1.setText("Battery");

        pb_battery1.setValue(82);
        pb_battery1.setBorderPainted(false);

        l_robot_connection1.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        l_robot_connection1.setText("Controls Connection ");

        javax.swing.GroupLayout pan_robo_trackerLayout = new javax.swing.GroupLayout(pan_robo_tracker);
        pan_robo_tracker.setLayout(pan_robo_trackerLayout);
        pan_robo_trackerLayout.setHorizontalGroup(
            pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_battery1)
                    .addComponent(l_cam_sig)
                    .addComponent(l_data_logging)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_speed_static)
                            .addComponent(l_ins_static))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(l_speed))
                            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                .addComponent(l_ins)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seperator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_progress_static, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_date_static))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_mid)
                            .addComponent(l_progress)
                            .addComponent(l_cam_sig_per)))
                    .addComponent(l_vid_sig))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb_cam_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(pb_vid_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_logging_per, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_robot_connection1)
                    .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pb_battery1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pb_robo_connect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(l_battery_per1)
                    .addComponent(l_logging_per)
                    .addComponent(l_vid_sig_per)
                    .addComponent(l_robo_connect_per1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );

        pan_robo_trackerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pb_battery1, pb_cam_sig_per, pb_logging_per, pb_robo_connect1, pb_vid_sig_per});

        pan_robo_trackerLayout.setVerticalGroup(
            pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_speed_static)
                            .addComponent(l_speed, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_ins_static))
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(l_ins, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(seperator1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                            .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(l_progress_static)
                                .addComponent(l_progress, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(l_mid)
                                .addComponent(l_date_static)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_vid_sig)
                .addGap(8, 8, 8)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addComponent(pb_vid_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_cam_sig))
                    .addComponent(l_logging_per))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addComponent(pb_cam_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_data_logging, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(l_vid_sig_per))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_cam_sig_per)
                    .addComponent(pb_logging_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_battery1)
                .addGap(0, 0, 0)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addComponent(pb_battery1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(l_robot_connection1)
                        .addGap(0, 0, 0)
                        .addComponent(pb_robo_connect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addComponent(l_battery_per1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_robo_connect_per1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_robo_trackerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pb_battery1, pb_cam_sig_per, pb_logging_per, pb_robo_connect1, pb_vid_sig_per});

        pan_south_east.setBorder(javax.swing.BorderFactory.createTitledBorder(" "));

        l_inspect_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_inspect_static.setText("Inspector:");

        l_inspector.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        l_inspector.setText("Pete Reed");
        l_inspector.setToolTipText("");

        l_mid__static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_mid__static.setText("MID:");

        l_date.setText("518");

        b_logon.setText("Login");
        b_logon.setActionCommand("b_logon");
        b_logon.setEnabled(false);
        b_logon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logonActionPerformed(evt);
            }
        });

        l_logo_icon.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/company_logo_small.jpg")); // NOI18N

        b_logon1.setText("Logout");
        b_logon1.setActionCommand("b_logon");
        b_logon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logon1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan_south_eastLayout = new javax.swing.GroupLayout(pan_south_east);
        pan_south_east.setLayout(pan_south_eastLayout);
        pan_south_eastLayout.setHorizontalGroup(
            pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_south_eastLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addComponent(l_inspect_static)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_inspector))
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(l_mid__static)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_date)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_south_eastLayout.createSequentialGroup()
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_logon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_logon1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_logo_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pan_south_eastLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_logon, b_logon1});

        pan_south_eastLayout.setVerticalGroup(
            pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_south_eastLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_inspect_static)
                    .addComponent(l_inspector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_mid__static)
                    .addComponent(l_date, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_logo_icon)
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addComponent(b_logon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_logon1)))
                .addContainerGap())
        );

        pan_south_eastLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_logon, b_logon1});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pan_robo_tracker, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pan_south_east, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pan_robo_tracker, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_south_east, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pan_robo_tracker.getAccessibleContext().setAccessibleName("I-90 East");
        pan_robo_tracker.getAccessibleContext().setAccessibleDescription("");

        pan_media_control.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Media Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        pan_media_control.setPreferredSize(new java.awt.Dimension(121, 145));

        b_archive.setText("Archive");

        b_load.setText("Load");
        b_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loadActionPerformed(evt);
            }
        });

        b_set_flag.setText("Set Flag");

        sb_vid_play.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        b_capture_moment.setBackground(new java.awt.Color(153, 255, 255));
        b_capture_moment.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/video_image_control_icons/camera_icon_small.jpg")); // NOI18N
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

        b_vid_mute.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/media_control_icons/mute_icon.jpg")); // NOI18N
        b_vid_mute.setContentAreaFilled(false);
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
                .addContainerGap()
                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sb_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(b_capture_moment, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
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
                        .addComponent(b_vid_mute, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addComponent(b_load)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_archive, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_close, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_set_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_vid_ff, b_vid_mute, b_vid_pause, b_vid_play, b_vid_rw, b_vid_stop});

        pan_media_controlLayout.setVerticalGroup(
            pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_media_controlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pan_media_controlLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_capture_moment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sb_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(b_vid_rw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b_vid_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b_vid_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b_vid_ff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(b_vid_mute, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_load, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_archive, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_set_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_vid_ff, b_vid_mute, b_vid_pause, b_vid_play, b_vid_rw, b_vid_stop});

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_archive, b_close, b_load, b_set_flag});

        pan_live_streaming.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pan_live_streaming.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        p_media_player.setBackground(new java.awt.Color(51, 51, 51));
        p_media_player.setForeground(new java.awt.Color(102, 102, 102));
        p_media_player.setMaximumSize(new java.awt.Dimension(350, 32767));

        javax.swing.GroupLayout p_media_playerLayout = new javax.swing.GroupLayout(p_media_player);
        p_media_player.setLayout(p_media_playerLayout);
        p_media_playerLayout.setHorizontalGroup(
            p_media_playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        p_media_playerLayout.setVerticalGroup(
            p_media_playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pan_north_east_bottomLayout = new javax.swing.GroupLayout(pan_north_east_bottom);
        pan_north_east_bottom.setLayout(pan_north_east_bottomLayout);
        pan_north_east_bottomLayout.setHorizontalGroup(
            pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pan_north_east_bottomLayout.setVerticalGroup(
            pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pan_live_streamingLayout = new javax.swing.GroupLayout(pan_live_streaming);
        pan_live_streaming.setLayout(pan_live_streamingLayout);
        pan_live_streamingLayout.setHorizontalGroup(
            pan_live_streamingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_live_streamingLayout.createSequentialGroup()
                .addComponent(p_media_player, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201)
                .addComponent(pan_north_east_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(390, 390, 390)
                .addGroup(pan_live_streamingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pan_live_streamingLayout.setVerticalGroup(
            pan_live_streamingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_live_streamingLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pan_north_east_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(254, 254, 254))
            .addGroup(pan_live_streamingLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pan_live_streamingLayout.createSequentialGroup()
                .addComponent(p_media_player, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pan_northLayout = new javax.swing.GroupLayout(pan_north);
        pan_north.setLayout(pan_northLayout);
        pan_northLayout.setHorizontalGroup(
            pan_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_northLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pan_live_streaming, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pan_northLayout.setVerticalGroup(
            pan_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_northLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pan_live_streaming, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pan_north, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(pan_media_control, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pan_north, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_media_control, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pan_vision_utils.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vision Utils", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        b_scan_hanger.setText("Scan Hanger");

        b_inspect_ceiling.setText("Inspect Ceiling");
        b_inspect_ceiling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_inspect_ceilingActionPerformed(evt);
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan_vision_utilsLayout = new javax.swing.GroupLayout(pan_vision_utils);
        pan_vision_utils.setLayout(pan_vision_utilsLayout);
        pan_vision_utilsLayout.setHorizontalGroup(
            pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_object_aware)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_vision_utilsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_scan_hanger, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_analyze_anchor)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_inspect_ceiling))
                .addContainerGap())
        );

        pan_vision_utilsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_analyze_anchor, b_inspect_ceiling, b_scan_hanger, jButton1});

        pan_vision_utilsLayout.setVerticalGroup(
            pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_object_aware)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_inspect_ceiling)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_analyze_anchor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_scan_hanger)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pan_vision_utilsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_analyze_anchor, b_inspect_ceiling, b_scan_hanger, jButton1});

        tf_video_port.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_video_port.setText("6789");

        l_ip1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_ip1.setText("Video Port:");

        l_remote_ip1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_remote_ip1.setText("Controller Port:");

        tf_r_id1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_r_id1.setText("Barracuda");

        l_r_id1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_r_id1.setText("R-ID:");

        l_source_ip1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_source_ip1.setText("Source IP: ");

        b_reset5.setBackground(new java.awt.Color(255, 102, 102));
        b_reset5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        b_reset5.setText("Reset");

        b_logout5.setBackground(new java.awt.Color(255, 51, 51));
        b_logout5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        b_logout5.setText("Logout");
        b_logout5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logout5b_logoutActionPerformed(evt);
            }
        });

        b_connect.setBackground(new java.awt.Color(0, 204, 51));
        b_connect.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        b_connect.setText("Connect");
        b_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });

        tf_controller_port.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_controller_port.setText("5555");

        tf_source_ip.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_source_ip.setText("192.168.1.69");
        tf_source_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_source_ipActionPerformed(evt);
            }
        });

        cb_controller_connected.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        cb_controller_connected.setBorderPainted(true);
        cb_controller_connected.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        cb_controller_connected.setEnabled(false);
        cb_controller_connected.setFocusable(false);
        cb_controller_connected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_controller_connectedActionPerformed(evt);
            }
        });

        l_controller_connected.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        l_controller_connected.setText("Controller Connected");
        l_controller_connected.setFocusable(false);

        javax.swing.GroupLayout pan_systam_statusLayout = new javax.swing.GroupLayout(pan_systam_status);
        pan_systam_status.setLayout(pan_systam_statusLayout);
        pan_systam_statusLayout.setHorizontalGroup(
            pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addComponent(l_remote_ip1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_systam_statusLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_source_ip1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(l_r_id1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_r_id1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_source_ip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_controller_port, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_systam_statusLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(l_ip1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_video_port, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cb_controller_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l_controller_connected))
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addComponent(b_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_reset5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(b_logout5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pan_systam_statusLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tf_controller_port, tf_r_id1, tf_source_ip, tf_video_port});

        pan_systam_statusLayout.setVerticalGroup(
            pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_r_id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_r_id1))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_systam_statusLayout.createSequentialGroup()
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_source_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_source_ip1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tf_controller_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_remote_ip1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_video_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_ip1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_logout5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_reset5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(l_controller_connected)
                    .addComponent(cb_controller_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        pan_systam_statusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tf_controller_port, tf_r_id1, tf_source_ip, tf_video_port});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pan_vision_utils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pan_systam_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pan_systam_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_vision_utils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pan_rootLayout = new javax.swing.GroupLayout(pan_root);
        pan_root.setLayout(pan_rootLayout);
        pan_rootLayout.setHorizontalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pan_rootLayout.setVerticalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pan_root, new java.awt.GridBagConstraints());

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

        menu_tools4.setText("Tool");

        jMenuItem6.setText("Workspace Organizer");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menu_tools4.add(jMenuItem6);

        mnu_inspect_robot.setText("Inspect Robot");
        mnu_inspect_robot.setToolTipText("");
        mnu_inspect_robot.setActionCommand("inspectrobotactioncommand");
        mnu_inspect_robot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_inspect_robotActionPerformed(evt);
            }
        });
        menu_tools4.add(mnu_inspect_robot);

        jMenuItem9.setText("History Profiler");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menu_tools4.add(jMenuItem9);

        jMenuItem4.setText("References");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu_tools4.add(jMenuItem4);

        menu_tools2.setText("Preferences");
        menu_tools4.add(menu_tools2);

        jMenuBar1.add(menu_tools4);

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

        setBounds(0, 0, 827, 488);
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="init()">
    private void init() {
//        pan_directionals = mddk.getPanelDisplay();
        // instantiate
        /*
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
         */
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

    private void b_logout5b_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logout5b_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_logout5b_logoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_object_awareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_object_awareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_object_awareActionPerformed

    private void b_analyze_anchorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_analyze_anchorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_analyze_anchorActionPerformed

    private void b_inspect_ceilingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_inspect_ceilingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_inspect_ceilingActionPerformed

    private void b_vid_pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_pauseActionPerformed
        //        media_pan.pause();
    }//GEN-LAST:event_b_vid_pauseActionPerformed

    private void b_vid_ffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_ffActionPerformed
        //        media_pan.ff(b_vid_ff);
    }//GEN-LAST:event_b_vid_ffActionPerformed

    private void b_vid_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_stopActionPerformed
        //        media_pan.stop();
    }//GEN-LAST:event_b_vid_stopActionPerformed

    private void b_vid_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_playActionPerformed
        //        media_pan.playz();
    }//GEN-LAST:event_b_vid_playActionPerformed

    private void b_vid_rwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_rwActionPerformed
    }//GEN-LAST:event_b_vid_rwActionPerformed

    private void b_vid_muteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_muteActionPerformed
        //        media_pan.mute();
    }//GEN-LAST:event_b_vid_muteActionPerformed

    private void b_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_closeActionPerformed
        //        if (media_pan.isPlaying()) {
        //            media_pan.stop();
        //        }
        f_video_loaded[0] = false;
        set_button_states();
    }//GEN-LAST:event_b_closeActionPerformed

    private void b_capture_momentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_capture_momentActionPerformed
        /*
         boolean tmp = media_pan.save_snap_shot();
         if (tmp) {
         System.out.println("Yupp, Snap!\n\n");
         } else {
         System.out.println("No Snap!\n\n");
         }*/
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
            //            media_pan.playz(dir + fname);
            f_video_loaded[0] = true;
        }
        set_button_states();
    }//GEN-LAST:event_b_loadActionPerformed

    private void b_logonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logonActionPerformed
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

    private void b_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_connectActionPerformed


        LiveStreamer.connect_ip(tf_source_ip.getText(), tf_video_port.getText());
    }//GEN-LAST:event_b_connectActionPerformed

    private void tf_source_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_source_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_source_ipActionPerformed

    private void b_logon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logon1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_logon1ActionPerformed

    private void cb_controller_connectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_controller_connectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_controller_connectedActionPerformed

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
//    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//        } catch (Exception ee) {
//        }
    //InstantiationException
//        catch (IllegalAccessException) {
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(LiveStreamerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
    //</editor-fold>
    /* Create and display the form */
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LiveStreamerWindow window = new LiveStreamerWindow();
                    window.frmLiveStreamerDisplay.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
//        java.awt.EventQueue.invokeLater(
//                new Runnable() {
//            @Override
//            public void run() {
//                new LiveStreamerWindow().setVisible(true);
////                new MobileDirectionDisplay().setVisible(true);
//            }
//        });
    private ArrayList<JButton> logger;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_analyze_anchor;
    private javax.swing.JButton b_archive;
    private javax.swing.JButton b_capture_moment;
    private javax.swing.JButton b_close;
    private javax.swing.JButton b_connect;
    private javax.swing.JButton b_inspect_ceiling;
    private javax.swing.JButton b_load;
    private javax.swing.JButton b_logon;
    private javax.swing.JButton b_logon1;
    private javax.swing.JButton b_logout5;
    private javax.swing.JButton b_reset5;
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
    private javax.swing.JCheckBox cb_controller_connected;
    private javax.swing.JCheckBox cb_object_aware;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel l_battery1;
    private javax.swing.JLabel l_battery_per1;
    private javax.swing.JLabel l_cam_sig;
    private javax.swing.JLabel l_cam_sig_per;
    private javax.swing.JLabel l_controller_connected;
    private javax.swing.JLabel l_data_logging;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_date_static;
    private javax.swing.JLabel l_ins;
    private javax.swing.JLabel l_ins_static;
    private javax.swing.JLabel l_inspect_static;
    private javax.swing.JLabel l_inspector;
    private javax.swing.JLabel l_ip1;
    private javax.swing.JLabel l_logging_per;
    private javax.swing.JLabel l_logo_icon;
    private javax.swing.JLabel l_mid;
    private javax.swing.JLabel l_mid__static;
    private javax.swing.JLabel l_progress;
    private javax.swing.JLabel l_progress_static;
    private javax.swing.JLabel l_r_id1;
    private javax.swing.JLabel l_remote_ip1;
    private javax.swing.JLabel l_robo_connect_per1;
    private javax.swing.JLabel l_robot_connection1;
    private javax.swing.JLabel l_source_ip1;
    private javax.swing.JLabel l_speed;
    private javax.swing.JLabel l_speed_static;
    private javax.swing.JLabel l_vid_sig;
    private javax.swing.JLabel l_vid_sig_per;
    private javax.swing.JMenu menu_about;
    private javax.swing.JMenu menu_about1;
    private javax.swing.JMenu menu_edit;
    private javax.swing.JMenu menu_file;
    private javax.swing.JMenu menu_help;
    private javax.swing.JMenu menu_tools2;
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
    private javax.swing.JPanel pan_robo_tracker;
    private javax.swing.JPanel pan_root;
    private javax.swing.JPanel pan_south_east;
    private javax.swing.JPanel pan_systam_status;
    private javax.swing.JPanel pan_vision_utils;
    private javax.swing.JProgressBar pb_battery1;
    private javax.swing.JProgressBar pb_cam_sig_per;
    private javax.swing.JProgressBar pb_logging_per;
    private javax.swing.JProgressBar pb_robo_connect1;
    private javax.swing.JProgressBar pb_vid_sig_per;
    private javax.swing.JScrollBar sb_vid_play;
    private javax.swing.JSeparator seperator1;
    private javax.swing.JTextField tf_controller_port;
    private javax.swing.JTextField tf_r_id1;
    private javax.swing.JTextField tf_source_ip;
    private javax.swing.JTextField tf_video_port;
    // End of variables declaration//GEN-END:variables
//    private void printn(String property) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
