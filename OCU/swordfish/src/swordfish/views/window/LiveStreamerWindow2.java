package swordfish.views.window;

import javax.swing.*;
import java.awt.Container.*;

import java.awt.Graphics2D;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import swordfish.controllers.VideoStreamer;


/**
 *
 * @author jrob
 */
public class LiveStreamerWindow2 extends JFrame
      implements WindowListener, streamerInterface {


    int[] pointer = new int[1];

    boolean[] f_video_loaded = new boolean[1];
    private VideoStreamer vs;
    ImageTaker it;
    LiveStreamerWindow lsw;

    String icon_path = System.getProperty("user.dir") + "/resources/";
    String image_out_path = System.getProperty("user.home") + "/Desktop/";
    public LiveStreamerWindow2() {
        initComponents();
        initContainer();
        f_video_loaded[0] = false;
        setResizable(false);
        it = new ImageTaker(image_out_path);              
    }

    public void setVideoStreamer(VideoStreamer instance) {
        vs = instance;
    }

    @Override
    public void setVideoFlag(boolean state)
    { // used for component states to be set
        f_video_loaded[0] = state;      
    }


    private void initContainer() {
        setResizable(false);
        addWindowListener(this);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void disconnect() {
        vs.disconnect();
    }
 
    @Override
    public void set_button_states() {

    }
    @Override
    public JPanel getMediaPlayer() {
        return p_mediaPlayer;
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
        pan_center = new javax.swing.JPanel();
        p_mediaPlayer = new javax.swing.JPanel();

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
            .addGap(0, 316, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pan_centerLayout = new javax.swing.GroupLayout(pan_center);
        pan_center.setLayout(pan_centerLayout);
        pan_centerLayout.setHorizontalGroup(
            pan_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_centerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p_mediaPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pan_centerLayout.setVerticalGroup(
            pan_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_centerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_mediaPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pan_rootLayout = new javax.swing.GroupLayout(pan_root);
        pan_root.setLayout(pan_rootLayout);
        pan_rootLayout.setHorizontalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(pan_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pan_rootLayout.setVerticalGroup(
            pan_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_rootLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pan_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pan_root, new java.awt.GridBagConstraints());

        setBounds(0, 0, 586, 374);
    }// </editor-fold>//GEN-END:initComponents

    public void setWindowLink(LiveStreamerWindow lsw)
    {
        this.lsw = lsw;
    }
    
    // <editor-fold defaultstate="collapsed" desc="WindowListeners">
    @Override
    public void windowClosing(WindowEvent e) {
        lsw.cb_sideview_on.setSelected(false);
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

    class ImageTaker    
    {
        String dir_out;
        public ImageTaker(String dir_path){  
            dir_out = dir_path;
        }
      
        private void captureImage(JPanel p_in) {
            BufferedImage im = new BufferedImage(p_in.getWidth(),p_in.getHeight(), BufferedImage.TYPE_INT_RGB);
            
            Graphics2D g2 = im.createGraphics();
            p_in.paint(g2);
            String fname = dir_out.concat("test.jpg");
            im = im.getSubimage(10, 10, im.getWidth() - 10, im.getHeight() - 10);
            try {
                ImageIO.write(im, "JPG", new File(fname));
                
            } catch (IOException ex) {
                Logger.getLogger(LiveStreamerWindow2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    public javax.swing.JPanel p_mediaPlayer;
    private javax.swing.JPanel pan_center;
    private javax.swing.JPanel pan_root;
    // End of variables declaration//GEN-END:variables

}
