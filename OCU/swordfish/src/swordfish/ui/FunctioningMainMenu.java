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
import static java.lang.Thread.MIN_PRIORITY;
import java.util.zip.GZIPInputStream;

// </editor-fold>

/** 
/**
* This Class is the GUI display for the live media (robot vision) and image 
* (moment captured from video) processing/analysis.
* 
*  rev 1 October 22, 2013
*       - Created Document
*       - Compressed much of the code to reduce length
*       - Added functionality to display image in the appropriate panel
* 
 * 
 * @since  October 22, 2013
 * @author jrob
 */
public class FunctioningMainMenu extends JFrame 
implements KeyListener{
    
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
    
//    jLabel2 = new javax.swing.JLabel();
//    String dir_image_icons = "/resources/";
//    JPanel p_directionals;
    
    public FunctioningMainMenu() {
         
      //  init();
        buildGui();
   
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
                .addContainerGap(163, Short.MAX_VALUE))
        );
        p_live_streamingLayout.setVerticalGroup(
            p_live_streamingLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(p_live_streamingLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(l_vid_player)
                .addContainerGap(145, Short.MAX_VALUE))
        );

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
                .addComponent(l_title, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
        );
        p_titleLayout.setVerticalGroup(
            p_titleLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(p_titleLayout.createSequentialGroup()
                .addComponent(l_title)
                .addGap(0, 9, Short.MAX_VALUE))
        );

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
                .addComponent(b_save, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
        );

      //  p_file_handlingLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {b_load, b_save}, );

        p_file_handlingLayout.linkSize
	   	    (SwingConstants.HORIZONTAL, new Component[] 
		{b_load, b_save});


        p_file_handlingLayout.setVerticalGroup(
            p_file_handlingLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(p_file_handlingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(p_file_handlingLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(b_load, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_save))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                jPanel5.setMaximumSize(jPanel5.getSize() );
        // </editor-fold> 
        
        
        p_directional.setBorder(BorderFactory.createTitledBorder(null, "Directionals", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        GroupLayout p_directionalLayout = new GroupLayout(p_directional);
        p_directional.setLayout(p_directionalLayout);
        p_directionalLayout.setHorizontalGroup(
            p_directionalLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        p_directionalLayout.setVerticalGroup(
            p_directionalLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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
                .addContainerGap(63, Short.MAX_VALUE))
        );
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
                .addContainerGap(9, Short.MAX_VALUE))
        );

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
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //layout.linkSize(new Component[] {jPanel5, p_inspect_tools}, SwingConstants.HORIZONTAL);
     layout.linkSize
	   	    (SwingConstants.HORIZONTAL, new Component[] 
		{jPanel5, p_inspect_tools});

     
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
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        	
        layout.linkSize
	    (SwingConstants.VERTICAL, new Component[] 
		{jPanel5, p_live_streaming});
                
       // layout.linkSize(SwingConstants.VERTICAL, new Component[] {jPanel5, p_live_streaming}, );
//panel_dirLayout.linkSize
//	    (SwingConstants.VERTICAL, new Component[] 
//		{text_dir_prefix, text_label_extension, text_synf_extension});
        pack();
    }// </editor-fold>                        

      
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
        // TODO add your handling code here:
    }                                        

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String image_name = "/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/hanger_test_image.jpg";
        
File file=new File(image_name);
        im_plus = IJ.createImage 
		       	("Test",  "RGB black", 258,338,1);
        

         FileInfo fi = getHeaderInfo(image_name);
            
         int COL = fi.width;
     
             
         int ROW = fi.height;
                 new FileLoaderSynf("aaa","test", im_plus,COL,ROW,
			    1, DarkColor, BrightColor); 
		  // cur_moment_view.setImage(im_plus.getImage());
       im_plus.show();
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
    public void keyTyped(KeyEvent e) {}

    /**
     * Handle the key pressed event from the text field.
     * The function checks if event was triggered via arrow keys on keypad. If 
     * so, the corresponding arrow icon will be enabled, i.e., will display 
     * its true color.
     */
    @Override
    public void keyPressed(KeyEvent e) {

        if (do_debug)
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
        }
    }

    
    /**
     * Handle the key released event from the text field.
     * The function checks if event was triggered via arrow keys on keypad. If 
     * so, the corresponding arrow icon will be disabled, i.e., will lose its 
     * true color set when key was pressed.
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {             
        if (do_debug)
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
        }
    }
    
    FileInfo getHeaderInfo(String name_to_read) //throws IOException
 {
     int anUnsignedShort = 0;
     int magicNumber = 0;
     int nim = 0;
    
     int firstByte = 0;
     int secondByte = 0;

     byte bb;

     FileInfo fi = null;

     int col=0;
     int row=0;

     try
     {                
	 DataInputStream ins_head;
                    
	 if (name_to_read.toLowerCase().endsWith("jpg") )
	 {
	     ins_head = 
		 new DataInputStream
		 (new BufferedInputStream
		  (new GZIPInputStream
		   (new FileInputStream(name_to_read))));
	 }
	 else
         {
	     ins_head = 
		 new DataInputStream
		 (new BufferedInputStream
		  (new FileInputStream
		   (name_to_read)));
	 }           
                    
	 for (int k=0;k<300;k++)
         {
	     bb = ins_head.readByte();
	     firstByte = (0x000000FF & ((int)bb));
	     bb = ins_head.readByte();
	     secondByte = (0x000000FF & ((int)bb));
	     anUnsignedShort  = (int) (secondByte | firstByte << 8);
       
	     /*                 
	     if(do_debug==1) 
		 IJ.log(" " + Integer.toString(firstByte) + " " + Integer.toString(secondByte));
                        
	     if(do_debug==1) 
	     	 IJ.log("read header " + Integer.toString(anUnsignedShort));
	     */
	     if (k==0)
                magicNumber = anUnsignedShort;

	     if (k==1)
                nim = anUnsignedShort;

	     if (k==296)
                col = anUnsignedShort;

	     if (k==297)
                row = anUnsignedShort;
	 }            
     }
     catch (Throwable e1)
     {
	 //	 IJ.showStatus("");
//	 	 IJ.showMessage("CTL_viewer", ""+e1);
	 // label_flag[0] = true;
//	 if(do_debug == 1)
//	     IJ.log("Problem header info " + e1.getMessage());
	 return fi;
     }

     if (magicNumber!=12431)
     {
	 IJ.showStatus("NOT MI:"+name_to_read);
	 IJ.showMessage("NOT MI:"+name_to_read);
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

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu().setVisible(true);
                new MobileDirectionDisplay().setVisible(true);
            }
        });
    }
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

        
//    }

    private void println(String property) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}




class FileLoader {
	String command;
        String fname;
	ImagePlus im_plus;
        int COL;
        int ROW;
        int nImages;
        int ROW_SKIP;
        int[] is_loaded_flag;

 FileLoader(String command, String fname,ImagePlus im_plus,
	     int col,int row, int nImages,int row_skip,
	     int[] is_loaded_flag)
 {
     // super(command);
     this.command = command;
     this.fname = fname;
     this.im_plus = im_plus;
     this.COL = col;
     this.ROW = row;
     this.ROW_SKIP = row_skip;
     this.nImages = nImages;
     this.is_loaded_flag = is_loaded_flag;

     /*   
     setPriority(Math.max(getPriority()-2, MIN_PRIORITY));
     start();*/
 }
//*************************************************************************************************************
// This function runs the plugin, what is implemented here is what the plugin actually does.
//************************************************************************************************************* 
 public void run() 
 {
     DataInputStream ins;
         
     int seglab = 0;
                   
     int firstByte = 0;
     int secondByte = 0;
     int anUnsignedShort = 0;
 

     float maxbyte = (float)256.0;
     float maxbyte2 = (float)128.0;
           
     byte bb;

     short[] pixels_n;

     int padd;
     int s = COL*ROW*2;    //total area of 1 image 
     int c = 0; //counter
     
     while(s >= c)
	 c += 512;
     
 IJ.log("read1.0");

     if ((c - s) == 512)
	 padd = 0;
     else
	 padd = -(s-c);    
 
     try{                        
	 if (fname.toLowerCase().endsWith(".mi.gz") ) 
	 {	
	     ins = 
		 new DataInputStream
		 (new BufferedInputStream
		  (new GZIPInputStream
		   (new FileInputStream(fname))));                                                      
	 }
	 else
	 {                                          
	     ins = 
		 new DataInputStream
		 (new BufferedInputStream
		  (new FileInputStream(fname)));                          
	 }
         
	 int unit;               
                         
	 ins.skipBytes(512);            
                IJ.log("read1.1");         
	 for (int k=0;k<nImages;k++)
         {    
	     ins.skipBytes(512);
	     
	     if (k>0)
		 ins.skipBytes(padd);
	     
	     im_plus.setPosition(1,k+1,1);
             
	     ImageProcessor im = im_plus.getProcessor();  //Reference to image's ImageProcessor.
                             
	     pixels_n = (short[])im.getPixels(); //Get pixel array of image.

	     ins.skipBytes(ROW_SKIP*COL*2);
                            
	     for (int i=ROW_SKIP*COL;i<COL*ROW;i++)
	     {	                                                                    
		 bb = ins.readByte();
		 firstByte = (0x000000FF & ((int)bb));
		 bb = ins.readByte();
		 secondByte = (0x000000FF & ((int)bb));

		 anUnsignedShort  = (int) (secondByte  | firstByte << 8 );                                
                                
//                    val = ((float)anUnsignedShort
//                           - level - offset)/window*maxbyte + maxbyte2;

		 anUnsignedShort = (anUnsignedShort<0)?0:anUnsignedShort;
		 anUnsignedShort = (anUnsignedShort>32767)?32767:anUnsignedShort;
                                
//                    val = (val<0)?0:val;
//                    val = (val>255)?255:val;                                
//                    anUnsignedShort = (int)val;
		 
		 if (i>=ROW_SKIP*COL)
		     pixels_n[i-ROW_SKIP*COL] = (short)anUnsignedShort;                                
	     }
	 }                                            
     }
     catch (Exception e2)
     {
	 //	 IJ.showStatus("error reading files ");
	 //	 IJ.log("Error 1");
	 is_loaded_flag[3] = 1;
	 IJ.log("read1.3  " + e2.getMessage());
	 return;
     }
     // IJ.log("read1.4");
     im_plus.updateAndDraw();   //Pixel array read and image display updated.
     im_plus.unlock();         //Unlocks the image (NOTE: multithreading?).
     //	 IJ.log("Error 2");
	 //    IJ.showMessage("dd","hhh");
     is_loaded_flag[0] = 1;
     //  IJ.log("read1.5");
 }
}

//*************************************************************************************************************
//************************************************************************************************************* 
//************************************************************************************************************* 
class FileLoaderSynf extends Thread 
{
    private String command;
    private String fname;
    private ImagePlus im_plus;
    private int COL;
    private int ROW;
    private int nImages;
    private int DarkColor;
    private int BrightColor;
    
    // determine/set no synf flag (image icon)

 FileLoaderSynf(String command, String fname,ImagePlus im_plus,int col,int row,
		  int nImages, int DarkColor, int BrightColor){

     super(command);
     this.command = command;
     this.fname = fname;
     this.im_plus = im_plus;
     this.COL = col;
     this.ROW = row;
     this.nImages = nImages;
     this.DarkColor = DarkColor;
     this.BrightColor = BrightColor;

     setPriority(Math.max(getPriority()-2, MIN_PRIORITY));
     start();
 }

//************************************************************************************************************* 
// This function runs the plugin, what is implemented here is what the plugin actually does.
//*************************************************************************************************************    
 public void run() 
 {
     DataInputStream ins;
           
     int seglab = 0;
                     
     int firstByte = 0;
     int secondByte = 0;
     int anUnsignedShort = 0;

     float maxbyte = (float)256.0;
     float maxbyte2 = (float)128.0;
             
     byte bb;

     int pixelval;

     int[] pixels_n;

     int[] collist = new int[16];            
            
     collist[1]  = 255 << 16;
     collist[2]  = 255 << 8;
     collist[3]  = 255;
     collist[4]  = 255 << 8 | 255 << 16;
     collist[5]  = 255 << 16 | 255;
     collist[6]  = 255 << 8 | 255;
     collist[7]  = 255 << 16 | BrightColor << 8 | BrightColor;
     collist[8]  = BrightColor << 16 | 255 << 8 | BrightColor;
     collist[9]  = BrightColor << 16 | BrightColor << 8 | 255;
     collist[10]  = 0 << 16 | DarkColor << 8 | BrightColor;
     collist[11]  = BrightColor << 16 | 0 << 8 | DarkColor;
     collist[12]  = DarkColor << 16 | BrightColor << 8 | 0;
     collist[13]  = DarkColor << 16 | 0 << 8 | 0;
     collist[14]  = 0 << 16 | DarkColor << 8 | 0;
     collist[15]  = DarkColor;

     int colorval;
     try{
	 
	 if (fname.toLowerCase().endsWith(".mi.gz") ) 
	 {                            
	     ins = 
		 new DataInputStream
		 (new BufferedInputStream
		  (new GZIPInputStream
		   (new FileInputStream(fname))));                            
	 }
	 else
         {                                                                      
	     ins = 
		 new DataInputStream
		 (new BufferedInputStream
		  (new FileInputStream(fname)));                
	 }                        
             
	 int unit;
                        
	 float val;
                        
	 int count;

	 int padd = 512*(int)java.lang.Math.ceil((double)COL*(double)nImages*(double)2/(double)512) - COL*nImages*2;
    

//            IJ.log(Integer.toString(padd));                                                 
	 ins.skipBytes(512);
                        
	 for (int k=0;k<2;k++)
	 {                                
	     ins.skipBytes(512);

                // padding
	     if (k==1)
		 ins.skipBytes(padd);
                            
                            
//                im_plus.setPosition(1,k+1,1);
                            
	     ImageProcessor im = im_plus.getProcessor();  //Reference to image's ImageProcessor.
                             
	     pixels_n = (int[])im.getPixels();   //Reference to image's pixel array.

	     if (k==0)
		 count = COL;
	     else
		 count = ROW;
                            
	     for (int j=0;j<count;j++)            
		 for (int i=0;i<nImages;i++)
                 {
		     bb = ins.readByte();
		     firstByte = (0x000000FF & ((int)bb));
		     bb = ins.readByte();
		     secondByte = (0x000000FF & ((int)bb));
//                        anUnsignedShort  = (int) (secondByte << 8 | firstByte);
		     anUnsignedShort  = (int) (secondByte  | firstByte << 8 );
                                
//                        if(do_debug==1) IJ.log(Integer.toString(anUnsignedShort));

		     if (anUnsignedShort-1024<=8000)
                     {
			 val = ((float)(anUnsignedShort-1024))/256*maxbyte + maxbyte2;
                        
			 val = (val<0)?0:val;
			 val = (val>255)?255:val;
			 anUnsignedShort = (int)val;

			 pixelval =
			     anUnsignedShort << 16 |
			     anUnsignedShort << 8 |
			     anUnsignedShort;
		     }
		     else
                     {
			 seglab  = anUnsignedShort - 8000 - 1024;

			 colorval =
			     (seglab<16)?collist[seglab]:collist[15];

			 pixelval = colorval;
		     }

		     if(k==0)
			 pixels_n[i + j*(nImages*2 + 5)] = pixelval;
		     else
			 pixels_n[i + j*(nImages*2 + 5) + nImages + 5] = pixelval;
		 }
	     
	 }              
     }
     catch (Exception e2)
     {
	 IJ.showStatus("error reading files");
	 return;
     }
     im_plus.updateAndDraw();      //Pixel array read and image display updated.
     im_plus.unlock();            //Unlocks the image (NOTE: multithreading?).
 }
}