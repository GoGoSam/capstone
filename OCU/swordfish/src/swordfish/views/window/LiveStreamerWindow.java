package swordfish.views.window;

import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container.*;
//import java.awt.FileDialog;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import swordfish.views.dialog.LogIn;
import swordfish.controllers.VideoStreamer;
import java.awt.event.ComponentListener;

/**
 *
 * @author jrob
 */
public class LiveStreamerWindow extends JFrame
        implements KeyListener, WindowListener, ComponentListener, streamerInterface {

    int[] pointer = new int[1];
//    private JLabel icon_down;
//    private JLabel icon_left;
//    private JLabel icon_right;
//    private JLabel icon_up;
    boolean[] f_video_loaded = new boolean[1];
    boolean[] f_mstream2_on = new boolean[1];
    private VideoStreamer vs;
    private LiveStreamerWindow2 lsw2;
    ImageTaker it;
    String icon_path = System.getProperty("user.dir") + "/resources/";
    String image_out_path = System.getProperty("user.home") + "/Desktop/";

    public LiveStreamerWindow() {

        initComponents();
        initContainer();
        f_video_loaded[0] = false;
        f_mstream2_on[0] = false;
        setResizable(false);
        it = new ImageTaker(image_out_path);
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public LiveStreamerWindow(LiveStreamerWindow2 lsw2_in) {
        lsw2 = lsw2_in;

        initComponents();
        initContainer();

        f_video_loaded[0] = false;
        f_mstream2_on[0] = true;
        setResizable(false);
        it = new ImageTaker(image_out_path);
        addComponentListener(this);
        lsw2.setWindowLink(this);
    }

    public void linkCameras(LiveStreamerWindow2 lsw2_in) {

        lsw2 = lsw2_in;
        lsw2.setWindowLink(this);
        addComponentListener(this);
        f_mstream2_on[0] = true;
    }

    public void setVideoStreamer(VideoStreamer instance) {
        vs = instance;
    }

    public void setVideoStreamer(VideoStreamer instance, VideoStreamer instance2) {
        vs = instance;
        lsw2.setVideoStreamer(instance2);
    }

    public boolean setMediaWindows() {
        if (!f_mstream2_on[0]) {
            return false;
        }

        Point pp = this.getLocationOnScreen();
        int x = pp.x;
        int y = pp.y + this.getWidth();
        lsw2.setLocation(x, y);
        return true;

    }

    public void checkCC(boolean checkit) {
        if (checkit) {
            cb_controller_connected.setSelected(true);
        } else {
            cb_controller_connected.setSelected(false);
        }
    }

    @Override
    public void setVideoFlag(boolean state) { // used for component states to be set
        f_video_loaded[0] = state;

    }

    @Override
    public void set_button_states() {
//        b_vid_ff.setEnabled(f_video_loaded[0]);
//        b_vid_mute.setEnabled(f_video_loaded[0]);
        b_vid_stop.setEnabled(f_video_loaded[0]);
        b_vid_play.setEnabled(f_video_loaded[0]);
//        b_vid_rw.setEnabled(f_video_loaded[0]);
        b_vid_pause.setEnabled(f_video_loaded[0]);
        b_capture_moment.setEnabled(f_video_loaded[0]);
//        cb_controller_connected.setSelected(rc.isConnected());
    }

    @Override
    public JPanel getMediaPlayer() {
        return p_mediaPlayer;
    }

    private void initContainer() {

        setResizable(false);
        addWindowListener(this);
        set_button_states();


    }

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
        pan_right = new javax.swing.JPanel();
        l_controller_connected = new javax.swing.JLabel();
        cb_controller_connected = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox();
        cb_boundviews = new javax.swing.JCheckBox();
        cb_sideview_on = new javax.swing.JCheckBox();
        jToggleButton2 = new javax.swing.JToggleButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        l_progress_static = new javax.swing.JLabel();
        l_progress = new javax.swing.JLabel();
        l_speed = new javax.swing.JLabel();
        l_speed_static = new javax.swing.JLabel();
        pb_battery = new javax.swing.JProgressBar();
        l_button_sig = new javax.swing.JLabel();
        l_battery_per = new javax.swing.JLabel();
        l_vid_sig_per = new javax.swing.JLabel();
        pb_cam_sig_per = new javax.swing.JProgressBar();
        l_cam_sig = new javax.swing.JLabel();
        l_data_logging = new javax.swing.JLabel();
        pb_logging_per = new javax.swing.JProgressBar();
        l_cam_sig_per = new javax.swing.JLabel();
        l_logging_per = new javax.swing.JLabel();
        pb_vid_sig_per = new javax.swing.JProgressBar();
        l_vid_sig = new javax.swing.JLabel();
        pb_robo_connect1 = new javax.swing.JProgressBar();
        l_robot_connection1 = new javax.swing.JLabel();
        l_robo_connect_per1 = new javax.swing.JLabel();
        pan_center = new javax.swing.JPanel();
        p_mediaPlayer = new javax.swing.JPanel();
        pan_media_control = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        b_capture_moment = new javax.swing.JButton();
        b_vid_play = new javax.swing.JButton();
        b_vid_pause = new javax.swing.JButton();
        b_vid_stop = new javax.swing.JButton();
        b_set_flag = new javax.swing.JButton();
        pan_systam_status = new javax.swing.JPanel();
        tf_video_port = new javax.swing.JTextField();
        l_video_port = new javax.swing.JLabel();
        l_controller_port = new javax.swing.JLabel();
        tf_r_id1 = new javax.swing.JTextField();
        l_r_id1 = new javax.swing.JLabel();
        l_source1_ip = new javax.swing.JLabel();
        b_reset = new javax.swing.JButton();
        b_connect = new javax.swing.JButton();
        tf_controller_port = new javax.swing.JTextField();
        tf_source1_ip = new javax.swing.JTextField();
        l_source2_ip = new javax.swing.JLabel();
        tf_base_video_port = new javax.swing.JTextField();
        tf_motor_port = new javax.swing.JTextField();
        l_motor_port = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tf_source2_ip1 = new javax.swing.JTextField();
        l_source2_ip1 = new javax.swing.JLabel();
        tf_video_port1 = new javax.swing.JTextField();
        l_video_port1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pan_login = new javax.swing.JPanel();
        l_inspector = new javax.swing.JLabel();
        l_mid__static = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        l_logo_icon = new javax.swing.JLabel();
        b_logon = new javax.swing.JButton();
        b_logon1 = new javax.swing.JButton();
        l_mid = new javax.swing.JLabel();
        l_date_static = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Base View", "Lift View", "Both Views" }));

        cb_boundviews.setFont(new java.awt.Font("Andale Mono", 0, 11)); // NOI18N
        cb_boundviews.setSelected(true);
        cb_boundviews.setText("Bound Views");
        cb_boundviews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_boundviewsActionPerformed(evt);
            }
        });

        cb_sideview_on.setFont(new java.awt.Font("Andale Mono", 0, 11)); // NOI18N
        cb_sideview_on.setSelected(true);
        cb_sideview_on.setText("View2 On");
        cb_sideview_on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sideview_onActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Acoustic Sensing");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Lights on");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        l_progress_static.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_progress_static.setText("Progress:");

        l_progress.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_progress.setText("1 / 1");

        l_speed.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_speed.setText("0 mph");

        l_speed_static.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_speed_static.setText("Speed:");

        pb_battery.setValue(94);

        l_button_sig.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_button_sig.setText("Battery");

        l_battery_per.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_battery_per.setText("94%");

        l_vid_sig_per.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_vid_sig_per.setText("96%");

        pb_cam_sig_per.setValue(96);

        l_cam_sig.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_cam_sig.setText("Base Connection");

        l_data_logging.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_data_logging.setText("Lift Connection");

        pb_logging_per.setValue(100);

        l_cam_sig_per.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_cam_sig_per.setText("100%");

        l_logging_per.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_logging_per.setText("82%");

        pb_vid_sig_per.setValue(82);

        l_vid_sig.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_vid_sig.setText("Video Signal");

        pb_robo_connect1.setValue(97);

        l_robot_connection1.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_robot_connection1.setText("Data Logging");

        l_robo_connect_per1.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        l_robo_connect_per1.setText("97%");

        javax.swing.GroupLayout pan_rightLayout = new javax.swing.GroupLayout(pan_right);
        pan_right.setLayout(pan_rightLayout);
        pan_rightLayout.setHorizontalGroup(
            pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_rightLayout.createSequentialGroup()
                        .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton2)
                            .addComponent(cb_boundviews)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_sideview_on)
                            .addGroup(pan_rightLayout.createSequentialGroup()
                                .addComponent(l_controller_connected)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_controller_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pan_rightLayout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(l_button_sig, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(l_cam_sig, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(l_data_logging, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(l_vid_sig, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pan_rightLayout.createSequentialGroup()
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pb_battery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_robot_connection1)
                    .addComponent(pb_robo_connect1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_cam_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_vid_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_logging_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_robo_connect_per1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_logging_per, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_cam_sig_per, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_vid_sig_per, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_battery_per, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(pan_rightLayout.createSequentialGroup()
                .addContainerGap(6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_rightLayout.createSequentialGroup()
                        .addComponent(l_speed_static, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_speed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_rightLayout.createSequentialGroup()
                        .addComponent(l_progress_static, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_progress))))
        );

        pan_rightLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pb_battery, pb_cam_sig_per, pb_robo_connect1, pb_vid_sig_per});

        pan_rightLayout.setVerticalGroup(
            pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rightLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_rightLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(l_progress_static, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(l_progress, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_speed_static)
                    .addComponent(l_speed, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_button_sig)
                .addGap(3, 3, 3)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_battery_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_battery, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_cam_sig)
                .addGap(3, 3, 3)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_vid_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_cam_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_data_logging)
                .addGap(3, 3, 3)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_cam_sig_per, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_logging_per, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_vid_sig)
                .addGap(0, 0, 0)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pb_vid_sig_per, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(l_logging_per))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_robot_connection1)
                .addGap(3, 3, 3)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(l_robo_connect_per1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_robo_connect1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_controller_connected)
                    .addComponent(cb_controller_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_sideview_on)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_boundviews)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1))
        );

        p_mediaPlayer.setMaximumSize(new java.awt.Dimension(350, 32767));
        p_mediaPlayer.setPreferredSize(new java.awt.Dimension(450, 250));

        javax.swing.GroupLayout p_mediaPlayerLayout = new javax.swing.GroupLayout(p_mediaPlayer);
        p_mediaPlayer.setLayout(p_mediaPlayerLayout);
        p_mediaPlayerLayout.setHorizontalGroup(
            p_mediaPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        p_mediaPlayerLayout.setVerticalGroup(
            p_mediaPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pan_media_control.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pan_media_control.setPreferredSize(new java.awt.Dimension(121, 145));

        b_capture_moment.setBackground(new java.awt.Color(153, 255, 255));
        b_capture_moment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swordfish/resources/media_control_icons/camerabutton.png"))); // NOI18N
        b_capture_moment.setToolTipText("Take Picture");
        b_capture_moment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_capture_momentActionPerformed(evt);
            }
        });

        b_vid_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swordfish/resources/media_control_icons/playbutton.png"))); // NOI18N
        b_vid_play.setToolTipText("Play Media Stream");
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

        b_vid_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swordfish/resources/media_control_icons/pausebutton.png"))); // NOI18N
        b_vid_pause.setToolTipText("Pause Media Stream");
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

        b_vid_stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swordfish/resources/media_control_icons/stopbutton.png"))); // NOI18N
        b_vid_stop.setToolTipText("Stop Media Streaming");
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

        b_set_flag.setFont(new java.awt.Font("Andale Mono", 0, 13)); // NOI18N
        b_set_flag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swordfish/resources/flag.jpg"))); // NOI18N
        b_set_flag.setToolTipText("Flag Current Location");
        b_set_flag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_set_flagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan_media_controlLayout = new javax.swing.GroupLayout(pan_media_control);
        pan_media_control.setLayout(pan_media_controlLayout);
        pan_media_controlLayout.setHorizontalGroup(
            pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_media_controlLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(b_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_vid_pause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_vid_stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(b_capture_moment, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_set_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_vid_pause, b_vid_play, b_vid_stop});

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b_capture_moment, b_set_flag});

        pan_media_controlLayout.setVerticalGroup(
            pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_media_controlLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_vid_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_vid_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_vid_play, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pan_media_controlLayout.createSequentialGroup()
                .addGroup(pan_media_controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(b_set_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan_media_controlLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(b_capture_moment)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pan_media_controlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_vid_pause, b_vid_play, b_vid_stop});

        javax.swing.GroupLayout pan_centerLayout = new javax.swing.GroupLayout(pan_center);
        pan_center.setLayout(pan_centerLayout);
        pan_centerLayout.setHorizontalGroup(
            pan_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_centerLayout.createSequentialGroup()
                .addGroup(pan_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_mediaPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addGroup(pan_centerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pan_media_control, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pan_centerLayout.setVerticalGroup(
            pan_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_centerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_mediaPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_media_control, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tf_video_port.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_video_port.setText("6789");

        l_video_port.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_video_port.setText("Video Port:");

        l_controller_port.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_controller_port.setText("IP Address:");

        tf_r_id1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_r_id1.setText("BasePi");
        tf_r_id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_r_id1ActionPerformed(evt);
            }
        });

        l_r_id1.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_r_id1.setText("Host Name:");

        l_source1_ip.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_source1_ip.setText("IP Address: ");

        b_reset.setFont(new java.awt.Font("Andale Mono", 0, 10)); // NOI18N
        b_reset.setText("Reset");

        b_connect.setFont(new java.awt.Font("Andale Mono", 0, 10)); // NOI18N
        b_connect.setText("Connect");
        b_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });

        tf_controller_port.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_controller_port.setText("192.168.1.6");

        tf_source1_ip.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_source1_ip.setText("192.168.1.69");
        tf_source1_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_source1_ipActionPerformed(evt);
            }
        });

        l_source2_ip.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_source2_ip.setText("Video Port: ");

        tf_base_video_port.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_base_video_port.setText("6789");
        tf_base_video_port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_base_video_portActionPerformed(evt);
            }
        });

        tf_motor_port.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_motor_port.setText("LiftPi");
        tf_motor_port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_motor_portActionPerformed(evt);
            }
        });

        l_motor_port.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_motor_port.setText("Host Name:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        jLabel2.setText("Base:");

        tf_source2_ip1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_source2_ip1.setText("5555");
        tf_source2_ip1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_source2_ip1ActionPerformed(evt);
            }
        });

        l_source2_ip1.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_source2_ip1.setText("Motor Port: ");

        tf_video_port1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tf_video_port1.setText("5555");
        tf_video_port1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_video_port1ActionPerformed(evt);
            }
        });

        l_video_port1.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        l_video_port1.setText("Motor Port:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        jLabel3.setText("Lift:");

        pan_login.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        l_inspector.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        l_inspector.setText("jRob");
        l_inspector.setToolTipText("");

        l_mid__static.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        l_mid__static.setText("MID:");

        l_date.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_date.setText("518");

        b_logon.setFont(new java.awt.Font("Andale Mono", 0, 10)); // NOI18N
        b_logon.setText("Login");
        b_logon.setActionCommand("b_logon");
        b_logon.setEnabled(false);
        b_logon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logonActionPerformed(evt);
            }
        });

        b_logon1.setFont(new java.awt.Font("Andale Mono", 0, 10)); // NOI18N
        b_logon1.setText("Logout");
        b_logon1.setActionCommand("b_logon");
        b_logon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logon1ActionPerformed(evt);
            }
        });

        l_mid.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_mid.setText("March 20, 2014");

        l_date_static.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        l_date_static.setText("Date:");

        javax.swing.GroupLayout pan_loginLayout = new javax.swing.GroupLayout(pan_login);
        pan_login.setLayout(pan_loginLayout);
        pan_loginLayout.setHorizontalGroup(
            pan_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l_logo_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pan_loginLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pan_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_loginLayout.createSequentialGroup()
                        .addComponent(b_logon, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(b_logon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pan_loginLayout.createSequentialGroup()
                        .addComponent(l_inspector)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_mid__static)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_date)))
                .addContainerGap())
            .addGroup(pan_loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_date_static)
                .addGap(18, 18, 18)
                .addComponent(l_mid)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pan_loginLayout.setVerticalGroup(
            pan_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_loginLayout.createSequentialGroup()
                .addGroup(pan_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_inspector)
                    .addComponent(l_date, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_mid__static))
                .addGap(15, 15, 15)
                .addGroup(pan_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_logon1)
                    .addComponent(b_logon))
                .addGap(3, 3, 3)
                .addComponent(l_logo_icon)
                .addGap(3, 3, 3)
                .addGroup(pan_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_mid)
                    .addComponent(l_date_static))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_loginLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_logon, b_logon1});

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swordfish/resources/company_logo_small.jpg"))); // NOI18N

        javax.swing.GroupLayout pan_systam_statusLayout = new javax.swing.GroupLayout(pan_systam_status);
        pan_systam_status.setLayout(pan_systam_statusLayout);
        pan_systam_statusLayout.setHorizontalGroup(
            pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1))
            .addComponent(pan_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_source2_ip1)
                            .addComponent(l_source1_ip)
                            .addComponent(l_r_id1)
                            .addComponent(l_source2_ip))
                        .addGap(6, 6, 6)
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_base_video_port)
                            .addComponent(tf_r_id1)
                            .addComponent(tf_source1_ip, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(tf_source2_ip1)))
                    .addGroup(pan_systam_statusLayout.createSequentialGroup()
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pan_systam_statusLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(b_connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(l_motor_port)
                            .addComponent(l_controller_port)
                            .addComponent(l_video_port)
                            .addComponent(l_video_port1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_video_port, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_video_port1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_motor_port, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_controller_port, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pan_systam_statusLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(b_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pan_systam_statusLayout.setVerticalGroup(
            pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_systam_statusLayout.createSequentialGroup()
                .addComponent(pan_login, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_r_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_source2_ip))
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_source1_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_r_id1))
                .addGap(1, 1, 1)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_base_video_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_source1_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_source2_ip1)
                    .addComponent(tf_source2_ip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_motor_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_motor_port))
                .addGap(0, 0, 0)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_controller_port)
                    .addComponent(tf_controller_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_video_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_video_port, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_video_port1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_video_port1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_systam_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pan_systam_statusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tf_controller_port, tf_r_id1, tf_source1_ip, tf_video_port});

        pan_systam_statusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b_connect, b_reset});

        javax.swing.GroupLayout pan_rootLayout = new javax.swing.GroupLayout(pan_root);
        pan_root.setLayout(pan_rootLayout);
        pan_rootLayout.setHorizontalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addComponent(pan_systam_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pan_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pan_rootLayout.setVerticalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pan_systam_status, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pan_center, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pan_right, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(3, 3, 3))
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

        mnu_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnu_exit.setText("Exit");
        mnu_exit.setActionCommand("mnu_exit");
        mnu_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_exitActionPerformed(evt);
            }
        });
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

        setBounds(0, 0, 901, 487);
    }// </editor-fold>//GEN-END:initComponents

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

            System.out.println("Login");


        } else if (logger.get(1) == evt.getSource()) {

            System.out.println("Register");

        } else {

            System.out.println("Cancel");

        }
    }
    private void jMenuItem4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mnu_inspect_robotActionPerformed(ActionEvent evt) {//GEN-FIRST:event_mnu_inspect_robotActionPerformed
//        try {
//            //        media_pan.playz("debris_robo_view.mov");
//            Desktop.getDesktop().open(new File("~/Desktop/go.mpg"));
////        open();
//        } catch (IOException ex) {
//            Logger.getLogger(LiveStreamerWindow.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_mnu_inspect_robotActionPerformed

    private void jMenuItem9ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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

    private void b_set_flagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_set_flagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_set_flagActionPerformed

    private void tf_base_video_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_base_video_portActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_base_video_portActionPerformed

    private void mnu_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_exitActionPerformed
        // TODO add your handling code here:
        if (f_mstream2_on[0]) {
            lsw2.disconnect();
        }

        vs.disconnect();
        System.exit(0);
    }//GEN-LAST:event_mnu_exitActionPerformed

    private void cb_boundviewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_boundviewsActionPerformed
        // TODO add your handling code here:
        if (!f_mstream2_on[0]) {
            return;
        }

        if (cb_boundviews.isSelected() && cb_sideview_on.isSelected()) {

            Point pp = this.getLocationOnScreen();
            int x = pp.x + this.getWidth();
            int y = pp.y;
            pp.y = y;
            pp.x = x;

            lsw2.setLocation(pp);
            lsw2.setVisible(true);
        }


    }//GEN-LAST:event_cb_boundviewsActionPerformed

    private void cb_sideview_onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sideview_onActionPerformed
        // TODO add your handling code here:

        if (!f_mstream2_on[0]) {
            return;
        }

        if (cb_sideview_on.isSelected()) {
            lsw2.setVisible(true);
        } else {
            lsw2.setVisible(false);
        }
    }//GEN-LAST:event_cb_sideview_onActionPerformed

    private void tf_source2_ip1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_source2_ip1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_source2_ip1ActionPerformed

    private void tf_motor_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_motor_portActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_motor_portActionPerformed

    private void cb_controller_connectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_controller_connectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_controller_connectedActionPerformed

    private void b_vid_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_stopActionPerformed

        vs.pause();
        b_vid_stop.setEnabled(false);
        b_vid_play.setEnabled(true);
    }//GEN-LAST:event_b_vid_stopActionPerformed

    private void b_vid_pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_pauseActionPerformed
        //        media_pan.stop();
    }//GEN-LAST:event_b_vid_pauseActionPerformed

    private void b_vid_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_vid_playActionPerformed

        vs.start();

        b_vid_stop.setEnabled(true);
        b_vid_play.setEnabled(false);
    }//GEN-LAST:event_b_vid_playActionPerformed

    private void b_capture_momentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_capture_momentActionPerformed
        it.captureImage(p_mediaPlayer);
    }//GEN-LAST:event_b_capture_momentActionPerformed

    private void tf_video_port1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_video_port1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_video_port1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void tf_r_id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_r_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_r_id1ActionPerformed

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="WindowListeners">
    @Override
    public void windowClosing(WindowEvent e) {

//         if(f_mstream2_on[0])
//                lsw2.disconnect();

        vs.disconnect();
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

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="KeyListeners">
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Handle the key pressed event from the text field. The function checks if
     * event was triggered via arrow keys on keypad. If so, the corresponding
     * arrow icon will be enabled, i.e., will display its true color.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        /*
         System.out.println("Key Press: " + e.toString());

         int location = e.getKeyCode();

         if (location == KeyEvent.VK_LEFT) {
         icon_left.setEnabled(true);
         } else if (location == KeyEvent.VK_RIGHT) {
         icon_right.setEnabled(true);
         } else if (location == KeyEvent.VK_UP) {

         icon_up.setEnabled(true);
         } else if (location == KeyEvent.VK_DOWN) {
         icon_down.setEnabled(true);
         }*/
    }

    /**
     * Handle the key released event from the text field. The function checks if
     * event was triggered via arrow keys on keypad. If so, the corresponding
     * arrow icon will be disabled, i.e., will lose its true color set when key
     * was pressed.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        /*
         System.out.println("Key Released: " + e.toString());

         int location = e.getKeyCode();

         if (location == KeyEvent.VK_LEFT) {
         icon_left.setEnabled(false);
         } else if (location == KeyEvent.VK_RIGHT) {
         icon_right.setEnabled(false);
         } else if (location == KeyEvent.VK_UP) {

         icon_up.setEnabled(false);
         } else if (location == KeyEvent.VK_DOWN) {
         icon_down.setEnabled(false);
         }*/
    }
    // </editor-fold>

    /* Create and display the form */
    @Override
    public void componentMoved(ComponentEvent e) {
        if (cb_boundviews.isSelected()) {
            Point pp = this.getLocationOnScreen();
            int x = pp.x + this.getWidth();
            int y = pp.y;
            pp.y = y;
            pp.x = x;
            lsw2.setLocation(pp);
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    class ImageTaker {

        String dir_out;

        public ImageTaker(String dir_path) {
            dir_out = dir_path;
        }

        private void captureImage(JPanel p_in) {
            BufferedImage im = new BufferedImage(p_in.getWidth(), p_in.getHeight(), BufferedImage.TYPE_INT_RGB);

            Graphics2D g2 = im.createGraphics();
            p_in.paint(g2);
            String fname = dir_out.concat("test.jpg");
            im = im.getSubimage(10, 10, im.getWidth() - 10, im.getHeight() - 10);
            try {
                ImageIO.write(im, "JPG", new File(fname));

            } catch (IOException ex) {
                Logger.getLogger(LiveStreamerWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private ArrayList<JButton> logger;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b_capture_moment;
    private javax.swing.JButton b_connect;
    private javax.swing.JButton b_logon;
    private javax.swing.JButton b_logon1;
    private javax.swing.JButton b_reset;
    private javax.swing.JButton b_set_flag;
    private javax.swing.JButton b_vid_pause;
    public javax.swing.JButton b_vid_play;
    public javax.swing.JButton b_vid_stop;
    public javax.swing.JCheckBox cb_boundviews;
    public javax.swing.JCheckBox cb_controller_connected;
    public javax.swing.JCheckBox cb_sideview_on;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel l_battery_per;
    private javax.swing.JLabel l_button_sig;
    private javax.swing.JLabel l_cam_sig;
    private javax.swing.JLabel l_cam_sig_per;
    private javax.swing.JLabel l_controller_connected;
    private javax.swing.JLabel l_controller_port;
    private javax.swing.JLabel l_data_logging;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_date_static;
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
    private javax.swing.JLabel l_source2_ip1;
    private javax.swing.JLabel l_speed;
    private javax.swing.JLabel l_speed_static;
    private javax.swing.JLabel l_vid_sig;
    private javax.swing.JLabel l_vid_sig_per;
    private javax.swing.JLabel l_video_port;
    private javax.swing.JLabel l_video_port1;
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
    private javax.swing.JPanel pan_center;
    private javax.swing.JPanel pan_login;
    private javax.swing.JPanel pan_media_control;
    private javax.swing.JPanel pan_right;
    private javax.swing.JPanel pan_root;
    private javax.swing.JPanel pan_systam_status;
    private javax.swing.JProgressBar pb_battery;
    private javax.swing.JProgressBar pb_cam_sig_per;
    private javax.swing.JProgressBar pb_logging_per;
    private javax.swing.JProgressBar pb_robo_connect1;
    private javax.swing.JProgressBar pb_vid_sig_per;
    public javax.swing.JTextField tf_base_video_port;
    public javax.swing.JTextField tf_controller_port;
    public javax.swing.JTextField tf_motor_port;
    public javax.swing.JTextField tf_r_id1;
    public javax.swing.JTextField tf_source1_ip;
    public javax.swing.JTextField tf_source2_ip1;
    public javax.swing.JTextField tf_video_port;
    public javax.swing.JTextField tf_video_port1;
    // End of variables declaration//GEN-END:variables
}
