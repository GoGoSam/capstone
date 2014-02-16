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
import org.gstreamer.State;
import org.gstreamer.swing.VideoPlayer;
//import javax.swing.border.TitledBorder;
//import swordfish.controllers.RobotController;
import swordfish.views.dialog.LogIn;
import swordfish.views.MobileDirectionDisplayKeyboard;
//import swordfish.applications.LiveStreamer;
import swordfish.controllers.RobotController;
import swordfish.controllers.VideoStreamer;
//import java.io.*;

/**
 *
 * @author jrob
 */
public class LiveStreamerWindow extends JFrame
        implements KeyListener, WindowListener {

//    private JFrame frmLiveStreamerDisplay;
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
    private VideoStreamer vs;
//    private RobotController rc;
//    MobileDirectionDisplayKeyboard mddk = new MobileDirectionDisplayKeyboard();
//    MyMediaPlayer media_pan;
    String icon_path = System.getProperty("user.dir") + "/resources/";

    public LiveStreamerWindow() {
//        super("ddd");

        initComponents();
//        initMediaPlayer();
        init();
        initContainer();
//        frmLiveStreamerDisplay = this;
        f_video_loaded[0] = false;
//        rc = new RobotController();
//        rc.connect(this);
        set_button_states();
        setResizable(false);
//        JPanel p_directionals = new MobileDirectionDisplayKeyboard().getPanelDisplay();
//        p_directionals.setVisible(true);

//        pan_directionals.add(p_directionals);
//        pack();
    }

    public LiveStreamerWindow(JFrame ui) {
//        super("ddd");

        initComponents();
//        initMediaPlayer();
        init();
        initContainer();

        f_video_loaded[0] = false;
//        rc = new RobotController();
//        rc.connect(this);
        set_button_states();
        setResizable(false);
//        JPanel p_directionals = new MobileDirectionDisplayKeyboard().getPanelDisplay();
//        p_directionals.setVisible(true);

//        pan_directionals.add(p_directionals);
//        pack();
    }

    public void setVideoStreamer(VideoStreamer instance)
    {
        vs = instance;
    }
    public void checkCC(boolean checkit) {
        if (checkit) {
            cb_controller_connected.setSelected(true);
        } else {
            cb_controller_connected.setSelected(false);

        }

    }

    private void set_button_states() {
        b_vid_ff.setEnabled(f_video_loaded[0]);
        b_vid_mute.setEnabled(f_video_loaded[0]);
        b_vid_pause.setEnabled(f_video_loaded[0]);
        b_vid_play.setEnabled(f_video_loaded[0]);
//        b_vid_rw.setEnabled(f_video_loaded[0]);
        b_vid_stop.setEnabled(f_video_loaded[0]);
        b_capture_moment.setEnabled(f_video_loaded[0]);

//        cb_controller_connected.setSelected(rc.isConnected());

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
    public void initMediaPlayer(VideoStreamer vp) {
//        p_mediaPlayer.setBackground(new Color(51, 51, 51));
//        p_mediaPlayer.setForeground(new Color(102, 102, 102));
//        p_mediaPlayer.setMaximumSize(new Dimension(350, 32767));

//x        pp = new Player();
//        pp = new Player();
//        p_mediaPlayer.add(vp.getPanel());
        p_mediaPlayer = vp.getPanel();
        GroupLayout p_media_playerLayout = new GroupLayout(p_mediaPlayer);
        p_mediaPlayer.setLayout(p_media_playerLayout);
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
                .addComponent(p_mediaPlayer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));
        pan_video_streamLayout.setVerticalGroup(
                pan_video_streamLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pan_video_streamLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(p_mediaPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(canvas1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(canvas4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(canvas3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                ));
//                      .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        
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
        l_battery_per = new javax.swing.JLabel();
        l_cam_sig_per = new javax.swing.JLabel();
        l_vid_sig_per = new javax.swing.JLabel();
        l_button_sig = new javax.swing.JLabel();
        pb_battery = new javax.swing.JProgressBar();
        l_cam_sig = new javax.swing.JLabel();
        pb_cam_sig_per = new javax.swing.JProgressBar();
        l_data_logging = new javax.swing.JLabel();
        pb_logging_per = new javax.swing.JProgressBar();
        pb_robo_connect1 = new javax.swing.JProgressBar();
        l_robo_connect_per1 = new javax.swing.JLabel();
        l_logging_per = new javax.swing.JLabel();
        l_vid_sig = new javax.swing.JLabel();
        pb_vid_sig_per = new javax.swing.JProgressBar();
        l_robot_connection1 = new javax.swing.JLabel();
        l_controller_connected = new javax.swing.JLabel();
        cb_controller_connected = new javax.swing.JCheckBox();
        icon_uArrow = new javax.swing.JLabel();
        icon_rArrow1 = new javax.swing.JLabel();
        icon_lArrow1 = new javax.swing.JLabel();
        icon_dArrow = new javax.swing.JLabel();
        l_dArrow = new javax.swing.JLabel();
        pan_south_east = new javax.swing.JPanel();
        l_inspect_static = new javax.swing.JLabel();
        l_inspector = new javax.swing.JLabel();
        l_mid__static = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        b_logon = new javax.swing.JButton();
        l_logo_icon = new javax.swing.JLabel();
        b_logon1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pan_live_streaming = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        canvas3 = new java.awt.Canvas();
        canvas4 = new java.awt.Canvas();
        p_mediaPlayer = new javax.swing.JPanel();
        pan_north_east_bottom = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pan_vision_utils = new javax.swing.JPanel();
        b_scan_hanger = new javax.swing.JButton();
        b_inspect_ceiling = new javax.swing.JButton();
        b_analyze_anchor = new javax.swing.JButton();
        cb_object_aware = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        b_load = new javax.swing.JButton();
        b_set_flag = new javax.swing.JButton();
        b_close = new javax.swing.JButton();
        b_archive = new javax.swing.JButton();
        pan_systam_status = new javax.swing.JPanel();
        tf_video_port = new javax.swing.JTextField();
        l_video_port = new javax.swing.JLabel();
        l_controller_port = new javax.swing.JLabel();
        tf_r_id1 = new javax.swing.JTextField();
        l_r_id1 = new javax.swing.JLabel();
        l_source1_ip = new javax.swing.JLabel();
        b_reset5 = new javax.swing.JButton();
        b_connect = new javax.swing.JButton();
        tf_controller_port = new javax.swing.JTextField();
        tf_source1_ip = new javax.swing.JTextField();
        l_source2_ip = new javax.swing.JLabel();
        tf_source2_ip = new javax.swing.JTextField();
        tf_motor_port = new javax.swing.JTextField();
        l_motor_port = new javax.swing.JLabel();
        pan_media_control = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        sb_vid_play = new javax.swing.JScrollBar();
        b_capture_moment = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        b_vid_mute = new javax.swing.JToggleButton();
        b_vid_rw = new javax.swing.JButton();
        b_vid_play = new javax.swing.JButton();
        b_vid_stop = new javax.swing.JButton();
        b_vid_ff = new javax.swing.JButton();
        b_vid_pause = new javax.swing.JButton();
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

        l_speed_static.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_speed_static.setText("Speed:");

        l_speed.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_speed.setText("-- ");

        l_ins.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_ins.setText("- - --");

        l_progress.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_progress.setText("# / #");

        l_progress_static.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_progress_static.setText("Progress");

        l_ins_static.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_ins_static.setText("INS:");

        seperator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        l_date_static.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_date_static.setText("Date:");

        l_mid.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_mid.setText("- -  ");

        l_battery_per.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_battery_per.setText("94%");

        l_cam_sig_per.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_cam_sig_per.setText("100%");

        l_vid_sig_per.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_vid_sig_per.setText("96%");

        l_button_sig.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_button_sig.setText("Battery");

        pb_battery.setValue(94);

        l_cam_sig.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_cam_sig.setText("Camera Signal");

        pb_cam_sig_per.setValue(96);

        l_data_logging.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_data_logging.setText("Data Logging");

        pb_logging_per.setValue(100);

        pb_robo_connect1.setValue(97);

        l_robo_connect_per1.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_robo_connect_per1.setText("97%");

        l_logging_per.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_logging_per.setText("82%");

        l_vid_sig.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_vid_sig.setText("Video Signal");

        pb_vid_sig_per.setValue(82);

        l_robot_connection1.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_robot_connection1.setText("Controls Connection ");

        l_controller_connected.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        l_controller_connected.setText("Controller Connected");
        l_controller_connected.setFocusable(false);

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

        icon_uArrow.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        icon_uArrow.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/xbox_controller_arrow_pics/Arrow_up.jpg")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        icon_uArrow.setEnabled(false);

        icon_rArrow1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        icon_rArrow1.setEnabled(false);

        icon_lArrow1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        icon_lArrow1.setEnabled(false);

        icon_dArrow.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        icon_dArrow.setEnabled(false);

        l_dArrow.setIcon(new javax.swing.ImageIcon("/home/sabertooth/capstone/OCU/swordfish/resources/xbox_controller_arrow_pics/Arrow_down.jpg")); // NOI18N
        l_dArrow.setEnabled(false);

        javax.swing.GroupLayout pan_robo_trackerLayout = new javax.swing.GroupLayout(pan_robo_tracker);
        pan_robo_tracker.setLayout(pan_robo_trackerLayout);
        pan_robo_trackerLayout.setHorizontalGroup(
            pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(cb_controller_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(l_controller_connected))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pb_battery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l_robot_connection1)
                            .addComponent(pb_robo_connect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pb_cam_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pb_logging_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pb_vid_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(l_logging_per)
                            .addComponent(l_battery_per)
                            .addComponent(l_vid_sig_per)
                            .addComponent(l_robo_connect_per1)
                            .addComponent(l_cam_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14))))
            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(l_button_sig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(l_speed_static, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(l_ins_static, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(l_speed))
                                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                        .addComponent(l_ins)
                                        .addGap(6, 6, 6)
                                        .addComponent(seperator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                        .addComponent(l_date_static)
                                        .addGap(18, 18, 18)
                                        .addComponent(l_mid))
                                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                                        .addComponent(l_progress_static, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(l_progress))))
                            .addComponent(l_cam_sig, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_data_logging, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_vid_sig, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(icon_lArrow1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(icon_uArrow)
                            .addComponent(icon_dArrow, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icon_rArrow1)
                            .addComponent(l_dArrow))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pan_robo_trackerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pb_battery, pb_cam_sig_per, pb_logging_per, pb_robo_connect1, pb_vid_sig_per});

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_button_sig)
                .addGap(3, 3, 3)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_battery_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_battery, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(l_cam_sig)
                .addGap(3, 3, 3)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_vid_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_cam_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(l_data_logging)
                .addGap(3, 3, 3)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_cam_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_logging_per, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(l_vid_sig)
                .addGap(0, 0, 0)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pb_vid_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(l_logging_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(l_robot_connection1)
                .addGap(3, 3, 3)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(l_robo_connect_per1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_robo_connect1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(l_controller_connected)
                    .addComponent(cb_controller_connected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_robo_trackerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pan_robo_trackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icon_uArrow)
                            .addComponent(icon_rArrow1)
                            .addComponent(icon_lArrow1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(icon_dArrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_robo_trackerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(l_dArrow)
                        .addContainerGap())))
        );

        pan_south_east.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andale Mono", 0, 1))); // NOI18N

        l_inspect_static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_inspect_static.setText("Inspector:");

        l_inspector.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        l_inspector.setText("Pete Reed");
        l_inspector.setToolTipText("");

        l_mid__static.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        l_mid__static.setText("MID:");

        l_date.setText("518");

        b_logon.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_logon.setText("Login");
        b_logon.setActionCommand("b_logon");
        b_logon.setEnabled(false);
        b_logon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logonActionPerformed(evt);
            }
        });

        b_logon1.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_logon1.setText("Logout");
        b_logon1.setActionCommand("b_logon");
        b_logon1.setEnabled(false);
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
                .addGap(86, 86, 86)
                .addComponent(l_logo_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pan_south_eastLayout.createSequentialGroup()
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(l_date))))
                    .addGroup(pan_south_eastLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(b_logon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_logon1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_south_eastLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_logon, b_logon1});

        pan_south_eastLayout.setVerticalGroup(
            pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_south_eastLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_inspect_static)
                    .addComponent(l_inspector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_mid__static)
                    .addComponent(l_date, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_south_eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_logon)
                    .addComponent(b_logon1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_logo_icon)
                .addContainerGap())
        );

        pan_south_eastLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_logon, b_logon1});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pan_robo_tracker, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pan_south_east, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pan_robo_tracker, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pan_south_east, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pan_robo_tracker.getAccessibleContext().setAccessibleName("I-90 East");
        pan_robo_tracker.getAccessibleContext().setAccessibleDescription("");

        pan_live_streaming.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pan_live_streaming.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        p_mediaPlayer.setMaximumSize(new java.awt.Dimension(350, 32767));
        p_mediaPlayer.setPreferredSize(new java.awt.Dimension(450, 250));

        javax.swing.GroupLayout p_mediaPlayerLayout = new javax.swing.GroupLayout(p_mediaPlayer);
        p_mediaPlayer.setLayout(p_mediaPlayerLayout);
        p_mediaPlayerLayout.setHorizontalGroup(
            p_mediaPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        p_mediaPlayerLayout.setVerticalGroup(
            p_mediaPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pan_north_east_bottomLayout = new javax.swing.GroupLayout(pan_north_east_bottom);
        pan_north_east_bottom.setLayout(pan_north_east_bottomLayout);
        pan_north_east_bottomLayout.setHorizontalGroup(
            pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        pan_north_east_bottomLayout.setVerticalGroup(
            pan_north_east_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pan_live_streamingLayout = new javax.swing.GroupLayout(pan_live_streaming);
        pan_live_streaming.setLayout(pan_live_streamingLayout);
        pan_live_streamingLayout.setHorizontalGroup(
            pan_live_streamingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_live_streamingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_mediaPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_north_east_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(pan_live_streamingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pan_live_streamingLayout.setVerticalGroup(
            pan_live_streamingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_live_streamingLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(p_mediaPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pan_live_streaming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pan_live_streaming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(236, 429));

        pan_vision_utils.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Vision Utils", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        b_scan_hanger.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_scan_hanger.setText("Scan Hanger");
        b_scan_hanger.setEnabled(false);

        b_inspect_ceiling.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_inspect_ceiling.setText("Inspect Ceiling");
        b_inspect_ceiling.setEnabled(false);
        b_inspect_ceiling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_inspect_ceilingActionPerformed(evt);
            }
        });

        b_analyze_anchor.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_analyze_anchor.setText("Analyze Anchors");
        b_analyze_anchor.setEnabled(false);
        b_analyze_anchor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_analyze_anchorActionPerformed(evt);
            }
        });

        cb_object_aware.setFont(new java.awt.Font("Andale Mono", 0, 12)); // NOI18N
        cb_object_aware.setText("Object Aware");
        cb_object_aware.setEnabled(false);
        cb_object_aware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_object_awareActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Andale Mono", 0, 12)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Directionals On");

        jButton1.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        jButton1.setText("Image Viewer");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        b_load.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_load.setText("Load");
        b_load.setEnabled(false);
        b_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loadActionPerformed(evt);
            }
        });

        b_set_flag.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_set_flag.setText("Flag");
        b_set_flag.setEnabled(false);
        b_set_flag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_set_flagActionPerformed(evt);
            }
        });

        b_close.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_close.setText("Close");
        b_close.setEnabled(false);
        b_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_closeActionPerformed(evt);
            }
        });

        b_archive.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_archive.setText("Save");
        b_archive.setEnabled(false);

        javax.swing.GroupLayout pan_vision_utilsLayout = new javax.swing.GroupLayout(pan_vision_utils);
        pan_vision_utils.setLayout(pan_vision_utilsLayout);
        pan_vision_utilsLayout.setHorizontalGroup(
            pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_scan_hanger, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_analyze_anchor)
                    .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(b_inspect_ceiling))
                        .addComponent(cb_object_aware)
                        .addComponent(jCheckBox1)))
                .addGap(18, 18, 18)
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_load)
                    .addComponent(b_set_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_close, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_archive, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pan_vision_utilsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_analyze_anchor, b_inspect_ceiling, b_scan_hanger, jButton1});

        pan_vision_utilsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_archive, b_close, b_load, b_set_flag});

        pan_vision_utilsLayout.setVerticalGroup(
            pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_vision_utilsLayout.createSequentialGroup()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_object_aware)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_inspect_ceiling)
                    .addComponent(b_load, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_analyze_anchor)
                    .addComponent(b_set_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_scan_hanger)
                    .addComponent(b_close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_vision_utilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(b_archive, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pan_vision_utilsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_archive, b_close, b_load, b_set_flag});

        pan_vision_utilsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_analyze_anchor, b_inspect_ceiling, b_scan_hanger, jButton1});

        tf_video_port.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_video_port.setText("6789");

        l_video_port.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_video_port.setText("Video Port:");

        l_controller_port.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_controller_port.setText("Controller Port:");

        tf_r_id1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_r_id1.setText("Barracuda");

        l_r_id1.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_r_id1.setText("R-ID:");

        l_source1_ip.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_source1_ip.setText("Source 1 IP: ");

        b_reset5.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_reset5.setText("Reset");
        b_reset5.setEnabled(false);

        b_connect.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_connect.setText("Connect");
        b_connect.setEnabled(false);
        b_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });

        tf_controller_port.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_controller_port.setText("5555");

        tf_source1_ip.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_source1_ip.setText("192.168.1.69");
        tf_source1_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_source1_ipActionPerformed(evt);
            }
        });

        l_source2_ip.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_source2_ip.setText("Source 2 IP: ");

        tf_source2_ip.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_source2_ip.setText("192.168.1.69");
        tf_source2_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_source2_ipActionPerformed(evt);
            }
        });

        tf_motor_port.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_motor_port.setText("5555");

        l_motor_port.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_motor_port.setText("Motors Port:");

        javax.swing.GroupLayout pan_systam_statusLayout = new javax.swing.GroupLayout(pan_systam_status);
        pan_systam_status.setLayout(pan_systam_statusLayout);
        pan_systam_statusLayout.setHorizontalGroup(
            pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_motor_port, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_source2_ip, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_r_id1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_controller_port, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_video_port, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_source2_ip)
                            .addComponent(tf_motor_port)
                            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_controller_port, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(tf_video_port, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(tf_r_id1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l_source1_ip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_source1_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_reset5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        pan_systam_statusLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tf_controller_port, tf_r_id1, tf_source1_ip, tf_video_port});

        pan_systam_statusLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_connect, b_reset5});

        pan_systam_statusLayout.setVerticalGroup(
            pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_r_id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_r_id1))
                        .addGap(9, 9, 9)
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_source1_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_source1_ip)))
                    .addComponent(b_connect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_reset5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_source2_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_source2_ip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_motor_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_motor_port))
                .addGap(9, 9, 9)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_controller_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_controller_port))
                .addGap(9, 9, 9)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_video_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_video_port, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pan_systam_statusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tf_controller_port, tf_r_id1, tf_source1_ip, tf_video_port});

        pan_systam_statusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_connect, b_reset5});

        pan_media_control.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Media Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        pan_media_control.setPreferredSize(new java.awt.Dimension(121, 145));

        sb_vid_play.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        b_capture_moment.setBackground(new java.awt.Color(153, 255, 255));
        b_capture_moment.setIcon(new javax.swing.ImageIcon("/home/sabertooth/capstone/OCU/swordfish/resources/video_image_control_icons/camera_icon_small.jpg")); // NOI18N
        b_capture_moment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_capture_momentActionPerformed(evt);
            }
        });

        jLabel2.setText("-- / --");

        b_vid_mute.setIcon(new javax.swing.ImageIcon("/home/sabertooth/capstone/OCU/swordfish/resources/media_control_icons/mute_icon.jpg")); // NOI18N
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

        b_vid_rw.setIcon(new javax.swing.ImageIcon("/home/sabertooth/capstone/OCU/swordfish/resources/media_control_icons/rewind_icon.jpg")); // NOI18N
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

        b_vid_play.setIcon(new javax.swing.ImageIcon("/home/sabertooth/capstone/OCU/swordfish/resources/media_control_icons/play_icon.jpg")); // NOI18N
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

        b_vid_stop.setIcon(new javax.swing.ImageIcon("/home/sabertooth/capstone/OCU/swordfish/resources/media_control_icons/stop_icon.jpg")); // NOI18N
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

        b_vid_ff.setIcon(new javax.swing.ImageIcon("/home/sabertooth/capstone/OCU/swordfish/resources/media_control_icons/ff_icon.jpg")); // NOI18N
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

        b_vid_pause.setIcon(new javax.swing.ImageIcon("/home/sabertooth/capstone/OCU/swordfish/resources/media_control_icons/pause_icon.jpg")); // NOI18N
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
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_media_controlLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(b_vid_rw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_vid_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_vid_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_vid_ff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_vid_mute, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pan_media_controlLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sb_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b_capture_moment, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(150, 150, 150))))
        );

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_vid_ff, b_vid_mute, b_vid_pause, b_vid_play, b_vid_rw, b_vid_stop});

        pan_media_controlLayout.setVerticalGroup(
            pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_media_controlLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pan_media_controlLayout.createSequentialGroup()
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sb_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(b_capture_moment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_vid_rw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_vid_play, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_vid_stop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_vid_pause, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_vid_ff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_vid_mute, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_vid_ff, b_vid_mute, b_vid_pause, b_vid_play, b_vid_rw, b_vid_stop});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pan_systam_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pan_vision_utils, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(pan_media_control, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pan_systam_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_vision_utils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pan_media_control, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pan_rootLayout = new javax.swing.GroupLayout(pan_root);
        pan_root.setLayout(pan_rootLayout);
        pan_rootLayout.setHorizontalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pan_rootLayout.setVerticalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, Short.MAX_VALUE)
                    .addGroup(pan_rootLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

        setBounds(0, 0, 1238, 627);
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
        
//        vs.pipe.setState(State.PAUSED);        
        vs.pause();     
        b_vid_pause.setEnabled(false);
        b_vid_play.setEnabled(true);
    }//GEN-LAST:event_b_vid_pauseActionPerformed

    private void b_vid_ffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_ffActionPerformed
        //        media_pan.ff(b_vid_ff);
    }//GEN-LAST:event_b_vid_ffActionPerformed

    private void b_vid_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_stopActionPerformed
        //        media_pan.stop();
    }//GEN-LAST:event_b_vid_stopActionPerformed

    private void b_vid_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_playActionPerformed
     
       vs.startPlaying();
             
       b_vid_pause.setEnabled(true);      
       b_vid_play.setEnabled(false);
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


//        LiveStreamer.connect_ip(tf_source_ip.getText(), tf_video_port.getText());
    }//GEN-LAST:event_b_connectActionPerformed

    private void tf_source1_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_source1_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_source1_ipActionPerformed

    private void b_logon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logon1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_logon1ActionPerformed

    private void cb_controller_connectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_controller_connectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_controller_connectedActionPerformed

    private void b_set_flagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_set_flagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_set_flagActionPerformed

    private void tf_source2_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_source2_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_source2_ipActionPerformed

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
    /* Create and display the form */

    /**
     * Launch the application.
     */
    /*
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
     }*/
//        java.awt.EventQueue.invokeLater(
//                new Runnable() {
//            @Override
//            public void run() {
//                new LiveStreamerWindow().setVisible(true);
////                new MobileDirectionDisplay().setVisible(true);
//            }
//        });
    public JFrame getFrame() {
        return this;

    }
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
    private javax.swing.JButton b_reset5;
    private javax.swing.JButton b_scan_hanger;
    private javax.swing.JButton b_set_flag;
    private javax.swing.JButton b_vid_ff;
    private javax.swing.JToggleButton b_vid_mute;
    public javax.swing.JButton b_vid_pause;
    public javax.swing.JButton b_vid_play;
    private javax.swing.JButton b_vid_rw;
    private javax.swing.JButton b_vid_stop;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas3;
    private java.awt.Canvas canvas4;
    public javax.swing.JCheckBox cb_controller_connected;
    private javax.swing.JCheckBox cb_object_aware;
    public javax.swing.JLabel icon_dArrow;
    public javax.swing.JLabel icon_lArrow1;
    public javax.swing.JLabel icon_rArrow1;
    public javax.swing.JLabel icon_uArrow;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel l_battery_per;
    private javax.swing.JLabel l_button_sig;
    private javax.swing.JLabel l_cam_sig;
    private javax.swing.JLabel l_cam_sig_per;
    private javax.swing.JLabel l_controller_connected;
    private javax.swing.JLabel l_controller_port;
    public javax.swing.JLabel l_dArrow;
    private javax.swing.JLabel l_data_logging;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_date_static;
    private javax.swing.JLabel l_ins;
    private javax.swing.JLabel l_ins_static;
    private javax.swing.JLabel l_inspect_static;
    private javax.swing.JLabel l_inspector;
    private javax.swing.JLabel l_logging_per;
    private javax.swing.JLabel l_logo_icon;
    private javax.swing.JLabel l_mid;
    private javax.swing.JLabel l_mid__static;
    private javax.swing.JLabel l_motor_port;
    private javax.swing.JLabel l_progress;
    private javax.swing.JLabel l_progress_static;
    private javax.swing.JLabel l_r_id1;
    private javax.swing.JLabel l_robo_connect_per1;
    private javax.swing.JLabel l_robot_connection1;
    private javax.swing.JLabel l_source1_ip;
    private javax.swing.JLabel l_source2_ip;
    private javax.swing.JLabel l_speed;
    private javax.swing.JLabel l_speed_static;
    private javax.swing.JLabel l_vid_sig;
    private javax.swing.JLabel l_vid_sig_per;
    private javax.swing.JLabel l_video_port;
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
    public javax.swing.JPanel p_mediaPlayer;
    public javax.swing.JPanel pan_live_streaming;
    private javax.swing.JPanel pan_media_control;
    private javax.swing.JPanel pan_north_east_bottom;
    private javax.swing.JPanel pan_robo_tracker;
    private javax.swing.JPanel pan_root;
    private javax.swing.JPanel pan_south_east;
    private javax.swing.JPanel pan_systam_status;
    private javax.swing.JPanel pan_vision_utils;
    private javax.swing.JProgressBar pb_battery;
    private javax.swing.JProgressBar pb_cam_sig_per;
    private javax.swing.JProgressBar pb_logging_per;
    private javax.swing.JProgressBar pb_robo_connect1;
    private javax.swing.JProgressBar pb_vid_sig_per;
    private javax.swing.JScrollBar sb_vid_play;
    private javax.swing.JSeparator seperator1;
    public javax.swing.JTextField tf_controller_port;
    public javax.swing.JTextField tf_motor_port;
    public javax.swing.JTextField tf_r_id1;
    public javax.swing.JTextField tf_source1_ip;
    public javax.swing.JTextField tf_source2_ip;
    public javax.swing.JTextField tf_video_port;
    // End of variables declaration//GEN-END:variables
//    private void printn(String property) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
