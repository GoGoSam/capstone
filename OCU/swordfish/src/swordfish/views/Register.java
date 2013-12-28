///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package views;
//
//import java.awt.*;
//import java.util.*;
//import java.util.List;
//import java.awt.event.*;
//import java.awt.image.*;
//import java.awt.Color;
//import java.io.*;
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
//import java.io.FileInputStream;
//import java.io.ObjectInputStream;
//import java.io.IOException;
//
//import javax.swing.GroupLayout.*;
//import javax.swing.BoxLayout;
//import javax.swing.*;
//import javax.swing.JTable;
//import javax.swing.table.AbstractTableModel;
//import javax.swing.JComponent;
//import javax.swing.table.DefaultTableModel;
//
//import java.lang.Math;
//import java.util.Calendar;
//import java.util.LinkedList;
//import java.util.zip.GZIPInputStream;
//import java.util.NoSuchElementException;
//
//import ij.plugin.frame.*;
//import ij.*;
//import ij.process.*;
//import ij.gui.*;
//import ij.io.*;
//import ij.util.Tools;
//import ij.plugin.*;
//import ij.text.*;
//import ij.measure.*;
//import ij.ImageStack.*;
//import ij.plugin.filter.PlugInFilter.*;
//
////import com.analogic.users.CTLUser;
////import ij3d.Image3DUniverse;
////import ij3d.Content;
///*
//
// CTLregister
// created February 13, 2012
//
// This plugin accompanies CTL_trainer
//
// Author: J.Robinson
//
// rev 1
// GUI designed and coded
//
// rev2
// added functions to read/write files
// in binary format
//
// rev3
// ----added functions to read/write files
// in text format
// */
////*************************************************************************************************************
//// This class handles registering.
////*************************************************************************************************************
//public class Register
//        extends PlugInFrame
//        implements Serializable, ActionListener, PlugIn, MouseListener, ItemListener, MouseMotionListener, TextListener, KeyListener {
//
//    private static JFrame instance;
//    private JPanel all_fields;
//    private JPanel panel_buttons;
//    private JPanel panel_all;
//
//    private static JButton b_cancel;
//    private static JButton b_register;
//
//    private JLabel label_CTL;
//    private JLabel label_allFields;
//    private JLabel label_dept;
//    private JLabel label_empNum;
//    private JLabel label_firstN;
//    private JLabel label_lastN;
//    private JLabel label_pWord;
//    private JLabel label_re_pWord;
//    private JLabel label_userN;
//    private JLabel label_email;
//
//    private static JTextField text_dept;
//    private static JTextField text_empNum;
//    private static JTextField text_firstN;
//    private static JTextField text_lastN;
//    private static JTextField text_email;
//
//    private static JPasswordField text_pWord;
//    private static JPasswordField text_re_pWord;
//    private static JTextField text_userN;
//
//    private int do_debug = 1;
//
//    private Color red_color;
//    private Color green_color;
//    private Color red_color_dark;
//    private Color green_color_dark;
//    private Color white_color;
//
//    private String fileName;
//    private String filePath;
//    private String fileNameText;
//    private String fileNameUserLog;
//    private String fileNameLog;
//    private ObjectOutputStream output; //Outputs data to a file
//    private ObjectInputStream input;
//
////    private CTLUser user;
////    private CTLUser registeringUser;
//    private BufferedWriter outText;
//
//    private boolean[] flag_isOpen = new boolean[3];
////    private Vector<CTLUser> accounts = new Vector<CTLUser>();
//    private Enumeration e;
//
//    private String registerName;
//    LogOn current;
//    //    static MyOwnFocusTraversalPolicy newPolicy;
//    //CTLUser user;
//    //    ObjectInputStream inputStream;
//
//    //    Vector <String> fieldInfo = new Vector <String>();
//    /**
//     * *****************************************************************
//     */
//    /**
//     * CTLregister's constructor. It's the only one as there is only one
//     * instance that the object will be used. It creates the GUI for the user to
//     * input account information.
//     * *********************************************************************
//     */
//    public Register(LogOn current) {
//
//        super("Register");
//        this.current = current;
//        red_color = new Color((float) 1.0, (float) 0.8, (float) 0.8);
//        green_color = new Color((float) 0.8, (float) 1.0, (float) 0.8);
//        white_color = new Color((float) 1.0, (float) 1.0, (float) 1.0);
//
//        red_color_dark = new Color((float) 0.9, (float) 0.7, (float) 0.7);
//        green_color_dark = new Color((float) 0.7, (float) 0.9, (float) 0.7);
//
//        if (IJ.versionLessThan("1.39t")) {
//            return;
//        }
//        if (instance != null) {
//            instance.toFront();
//            return;
//        }
//        //        instance = this;
//        addKeyListener(IJ.getInstance());
//
//        all_fields = new JPanel();
//        panel_buttons = new JPanel();
//        panel_all = new JPanel(new GridLayout(2, 1));
//
//        text_firstN = new JTextField("");
//        text_lastN = new JTextField("");
//        text_empNum = new JTextField("");
//        text_dept = new JTextField("");
//        text_userN = new JTextField("");
//        text_email = new JTextField("");
//        text_pWord = new JPasswordField("");
//        text_re_pWord = new JPasswordField("");
//
//        text_firstN.addKeyListener(this);
//        text_lastN.addKeyListener(this);
//        text_empNum.addKeyListener(this);
//        text_dept.addKeyListener(this);
//        text_userN.addKeyListener(this);
//        text_email.addKeyListener(this);
//        text_pWord.addKeyListener(this);
//        text_re_pWord.addKeyListener(this);
//
//        label_firstN = new JLabel("First Name:");
//        label_lastN = new JLabel("Last Name:");
//        label_empNum = new JLabel("Employee #:");
//        label_dept = new JLabel("Dept:");
//        label_userN = new JLabel("Username:");
//        label_pWord = new JLabel("Password:");
//        label_re_pWord = new JLabel("Re-type Password:");
//        label_CTL = new JLabel();
//        label_email = new JLabel("Email:");
//        label_allFields = new JLabel();
//
//        b_register = new JButton();
//        b_cancel = new JButton();
//
//        //	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        label_CTL.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
//        label_CTL.setText("CTL_trainer");
//
//        label_allFields.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
//        label_allFields.setText("All fields are required.");
//
//        GroupLayout all_fieldsLayout = new GroupLayout(all_fields);
//        all_fields.setLayout(all_fieldsLayout);
//        all_fieldsLayout.setHorizontalGroup(
//                all_fieldsLayout.createParallelGroup(Alignment.LEADING)
//                .addGroup(all_fieldsLayout.createSequentialGroup()
//                        .addGap(104, 104, 104)
//                        .addComponent(label_allFields)
//                        .addGap(0, 0, Short.MAX_VALUE))
//                .addGroup(all_fieldsLayout.createSequentialGroup()
//                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.LEADING)
//                                .addGroup(all_fieldsLayout.createSequentialGroup()
//                                        .addContainerGap()
//                                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.TRAILING)
//                                                .addComponent(label_re_pWord)
//                                                .addComponent(label_pWord)
//                                                .addComponent(label_userN)
//                                                .addComponent(label_email)
//                                                .addComponent(label_dept)
//                                                .addGroup(all_fieldsLayout.createParallelGroup(Alignment.LEADING)
//                                                        .addComponent(label_empNum)
//                                                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.TRAILING)
//                                                                .addComponent(label_firstN)
//                                                                .addComponent(label_lastN))))
//                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.LEADING, false)
//                                                .addComponent(text_firstN, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
//                                                .addComponent(text_lastN)
//                                                .addComponent(text_empNum)
//                                                .addComponent(text_dept)
//                                                .addComponent(text_email)
//                                                .addComponent(text_userN)
//                                                .addComponent(text_pWord)
//                                                .addComponent(text_re_pWord)))
//                                .addGroup(all_fieldsLayout.createSequentialGroup()
//                                        .addGap(106, 106, 106)
//                                        .addComponent(label_CTL)))
//                        .addContainerGap(70, Short.MAX_VALUE))
//        );
//        all_fieldsLayout.setVerticalGroup(
//                all_fieldsLayout.createParallelGroup(Alignment.LEADING)
//                .addGroup(all_fieldsLayout.createSequentialGroup()
//                        .addGap(11, 11, 11)
//                        .addComponent(label_CTL)
//                        .addGap(18, 18, 18)
//                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.BASELINE)
//                                .addComponent(label_firstN)
//                                .addComponent(text_firstN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
//                                        GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.BASELINE)
//                                .addComponent(label_lastN)
//                                .addComponent(text_lastN, GroupLayout.PREFERRED_SIZE,
//                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.BASELINE)
//                                .addComponent(label_empNum)
//                                .addComponent(text_empNum,
//                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
//                                        GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.BASELINE)
//                                .addComponent(label_dept)
//                                .addComponent(text_dept, GroupLayout.PREFERRED_SIZE,
//                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.BASELINE)
//                                .addComponent(label_email)
//                                .addComponent(text_email, GroupLayout.PREFERRED_SIZE,
//                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.BASELINE)
//                                .addComponent(label_userN)
//                                .addComponent(text_userN, GroupLayout.PREFERRED_SIZE,
//                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.BASELINE)
//                                .addComponent(label_pWord)
//                                .addComponent(text_pWord, GroupLayout.PREFERRED_SIZE,
//                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(all_fieldsLayout.createParallelGroup(Alignment.BASELINE)
//                                .addComponent(label_re_pWord)
//                                .addComponent(text_re_pWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
//                                        GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                        .addComponent(label_allFields)
//                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//
//        b_register.setText("Register");
//        b_register.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                b_registerActionPerformed(evt);
//            }
//        });
//        b_cancel.setText("Cancel");
//        b_cancel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                b_cancelActionPerformed(evt);
//            }
//        });
//
//        GroupLayout panel_buttonsLayout = new GroupLayout(panel_buttons);
//        panel_buttons.setLayout(panel_buttonsLayout);
//        panel_buttonsLayout.setHorizontalGroup(
//                panel_buttonsLayout.createParallelGroup(Alignment.LEADING)
//                .addGroup(panel_buttonsLayout.createSequentialGroup()
//                        .addContainerGap(41, Short.MAX_VALUE)
//                        .addComponent(b_register)
//                        .addGap(55, 55, 55)
//                        .addComponent(b_cancel)
//                        .addGap(65, 65, 65))
//        );
//        panel_buttonsLayout.setVerticalGroup(
//                panel_buttonsLayout.createParallelGroup(Alignment.LEADING)
//                .addGroup(panel_buttonsLayout.createSequentialGroup()
//                        .addGap(15, 15, 15)
//                        .addGroup(panel_buttonsLayout.createParallelGroup(Alignment.BASELINE)
//                                .addComponent(b_register)
//                                .addComponent(b_cancel))
//                        .addContainerGap(16, Short.MAX_VALUE))
//        );
//
//        GroupLayout panel_allLayout = new GroupLayout(panel_all);
//        panel_all.setLayout(panel_allLayout);
//        panel_allLayout.setHorizontalGroup(
//                panel_allLayout.createParallelGroup(Alignment.LEADING)
//                .addComponent(all_fields, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(panel_buttons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        panel_allLayout.setVerticalGroup(
//                panel_allLayout.createParallelGroup(Alignment.LEADING)
//                .addGroup(panel_allLayout.createSequentialGroup()
//                        .addComponent(all_fields, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(panel_buttons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                        .addContainerGap())
//        );
//
//        Vector<Component> order = new Vector<Component>(10);
//        text_firstN.setActionCommand("first");
//        text_lastN.setActionCommand("last");
//        text_empNum.setActionCommand("empNum");
//        text_dept.setActionCommand("dept");
//        text_userN.setActionCommand("user");
//        text_email.setActionCommand("email");
//        text_pWord.setActionCommand("pass");
//        text_re_pWord.setActionCommand("repass");
//
//        text_firstN.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
//        text_lastN.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
//        text_empNum.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
//        text_dept.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
//        text_userN.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
//        text_email.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
//        text_pWord.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
//        text_re_pWord.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
//
//        order.add(text_firstN);
//        order.add(text_lastN);
//        order.add(text_empNum);
//        order.add(text_dept);
//        order.add(text_email);
//        order.add(text_userN);
//        order.add(text_pWord);
//        order.add(text_re_pWord);
//        order.add(b_register);
//        order.add(b_cancel);
//
//        //	newPolicy = new MyOwnFocusTraversalPolicy(order);
//        //	setDefaultCloseOperation(DISPOSE_ON_CLOSE);//WindowConstants.DISPOSE_ON_CLOSE);
//        add(panel_all);
//        //	instance.setSize(250,250);
//        //	GUI.center(instance);
//        GUI.center(this);
//        addWindowListener(this);
//        //setOpaque(true);
//        pack();
//        this.setVisible(true);
//        //	this.setOpaque(true); //content panes must be opaque
//        //	set_button_states();
//        //	pack();
//        //instance.setVisible(true);
//        //	instance.pack();
//        fileName = System.getProperty("user.home") + "/CTL_viewer/Users/accounts.ser";
//        filePath = System.getProperty("user.home") + "/CTL_viewer/Users/";
//        fileNameText = System.getProperty("user.home") + "/CTL_viewer/Users/accounts.txt";
//        fileNameLog = System.getProperty("user.home") + "/CTL_viewer/Users/history.log";
//        fileNameUserLog = System.getProperty("user.home") + "/CTL_viewer/Users";
//        flag_isOpen[0] = false;
//        flag_isOpen[1] = false;
//    }
//
//    public void keyPressed(KeyEvent ee) {
//
//        if (ee.getKeyCode() == KeyEvent.VK_TAB) {
//
//            String label = "";// = ee.getActionCommand();
//
//            if (ee.getSource().equals(text_firstN)) {
//                text_firstN.select(0, 0);
//                text_lastN.requestFocusInWindow();
//                text_lastN.selectAll();
//            } else if (ee.getSource().equals(text_lastN)) {
//                text_lastN.select(0, 0);
//                text_empNum.requestFocusInWindow();
//                text_empNum.selectAll();
//            } else if (ee.getSource().equals(text_empNum)) {
//                text_empNum.select(0, 0);
//                text_dept.requestFocusInWindow();
//                text_dept.selectAll();
//            } else if (ee.getSource().equals(text_dept)) {
//                text_dept.select(0, 0);
//                text_email.requestFocusInWindow();
//                text_email.selectAll();
//            } else if (ee.getSource().equals(text_userN)) {
//                text_userN.select(0, 0);
//                text_pWord.requestFocusInWindow();
//                text_pWord.selectAll();
//            } else if (ee.getSource().equals(text_email)) {
//                text_email.select(0, 0);
//                text_userN.requestFocusInWindow();
//                text_userN.selectAll();
//            } else if (ee.getSource().equals(text_pWord)) {
//                text_pWord.select(0, 0);
//                text_re_pWord.requestFocusInWindow();
//                text_re_pWord.selectAll();
//            } else if (ee.getSource().equals(text_re_pWord)) {
//                text_re_pWord.select(0, 0);
//                text_firstN.requestFocusInWindow();
//                text_firstN.selectAll();
//            }
//        }
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function called when 'cancel' was pressed on the CTLregister. It hides
//     * the GUI, and the user will essentially be back at the CTL_trainer
//     * interface.
//     * *********************************************************************
//     */
//    private void b_cancelActionPerformed(ActionEvent evt) {
//        current.setVisible(true);
//        this.setVisible(false);
//    }
//
//    public void mouseClicked(MouseEvent e) {
//    }
//
//    public void mouseMoved(MouseEvent e) {
//    }
//
//    public void mouseDragged(MouseEvent e) {
//    }
//
//    public void mousePressed(MouseEvent e) {
//    }
//
//    public void mouseReleased(MouseEvent e) {
//    }
//
//    public void mouseEntered(MouseEvent e) {
//    }
//
//    public void mouseExited(MouseEvent e) {
//    }
//
//    public void actionPerformed(ActionEvent e) {
//    }
//
//    public void textValueChanged(TextEvent t) {
//    }
//
//    public void itemStateChanged(ItemEvent e) {
//    }
//
//    public void processWindowEvent(WindowEvent e) {
//        super.processWindowEvent(e);
//        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
//            instance = null;
//        }
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function called when 'register' was pressed on the CTLregister. This
//     * function fascilitates the process of adding a new user's record to the
//     * users' database through function calls. After each function call,
//     * conditions are checked to see that the process is working properly, as
//     * the sequence of function calls are set in a serial dependant fashion. In
//     * other words, in order for the next function in line to work, the one
//     * prior must have executed completely. For i.e, a file cannot be read that
//     * hasn't been open. Return type void. Clears register fields, closes
//     * CTLregister and
//     * *********************************************************************
//     */
//    private void b_registerActionPerformed(ActionEvent evt) {
//        int success;
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): process registration");
//        }
//
//        success = 0;
//        success = registerUser();
//        if (success == 0) {
//            return;
//        }
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): open binary to read");
//        }
//
//        openFile();
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): read binary database");
//        }
//
//        success = 0;
//        success = readRecords();
//        if (success == 0) {
//            return;
//        }
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): close binary");
//        }
//
//        success = 0;
//        success = closeFile();
//        if (success == 0) {
//            return;
//        }
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): open binary to write");
//        }
//
//        success = 0;
//        success = openFileWriter();
//        if (success == 0) {
//            return;
//        }
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): write binary record");
//        }
//
//        success = 0;
//        success = writeRecord();
//        if (success == 0) {
//            return;
//        }
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): close binary");
//        }
//
//        success = 0;
//        success = closeFileWriter();
//        if (success == 0) {
//            return;
//        }
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): open text to write record");
//        }
//
//        success = 0;
//        success = writeTextOpen();
//        if (success == 0) {
//            return;
//        }
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): write text record");
//        }
//
//        success = writeText();
//
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): close text");
//        }
//
//        success = 0;
//        success = writeTextClose();
//        if (success == 0) {
//            return;
//        }
//        writeLog();
//        text_firstN.setText("");
//        text_lastN.setText("");
//        text_empNum.setText("");
//        text_dept.setText("");
//        text_email.setText("");
//        text_pWord.setText("");
//        text_re_pWord.setText("");
//        text_userN.setText("");
//
//        this.setVisible(false);
//
//        IJ.showMessage("CTLregister", "Username created.");
//
////        new CTLTrainer(user);
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function designed to getText() from all the involved fields in the
//     * CTLregister(): first its checks whether all fields have values; next it
//     * checks that the two passwords are equivalent; then it creates an instance
//     * of CTLUser() by passing the user defined fields to the constructor of the
//     * class; lastly it adds the object (new CTLUser) to the accounts vector.
//     * *********************************************************************
//     */
//    public int registerUser() {
//        String dept = text_dept.getText();
//        String empNum = text_empNum.getText();
//        String email = text_email.getText();
//        String firstN = text_firstN.getText();
//        String lastN = text_lastN.getText();
//        String pWord = new String(text_pWord.getPassword());
//        String re_pWord = new String(text_re_pWord.getPassword());
//        String userN = text_userN.getText();
//        registerName = firstN + " " + lastN;
//
//        if (firstN.isEmpty() || lastN.isEmpty() || empNum.isEmpty() || dept.isEmpty()
//                || email.isEmpty() || userN.isEmpty() || pWord.isEmpty() || re_pWord.isEmpty()) {
//            IJ.showMessage("CTLregister", "Please fill out all fields!");
//            text_pWord.setText("");
//            text_re_pWord.setText("");
//
//            return 0;
//        }
//        if (!(pWord.equals(re_pWord))) {
//            IJ.showMessage("CTLregister", "Passwords do not match!");
//            text_pWord.setText("");
//            text_re_pWord.setText("");
//            return 0;
//        }
//
//        //create an instance of CTLUser and add it to accounts <CTL_user>
////        user = new CTLUser(firstN, lastN, empNum, dept, email, userN, pWord, filePath);
//        fileNameUserLog += "/" + firstN.substring(0, 1).toLowerCase() + lastN + "/"
//                + firstN.substring(0, 1).toLowerCase() + lastN + "History.log";
//
//        return 1;
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function to open users' database for reading. More specifically, it
//     * creates a new instance of the the ObjectInputStream. If stream throws an
//     * exception it is likely due to the file not being in the path directed.
//     * *********************************************************************
//     */
//    public void openFile() {
//        try {
//            IJ.showMessage("tempRegister", fileName);
//            input = new ObjectInputStream(new FileInputStream(fileName));
//        }//end try
//        catch (IOException ioException) {//Catch exception if any
//            IJ.log("Error opening account records" + fileName);
//            flag_isOpen[1] = false;
//            return;
//        }// end catch
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function to read users' database. After checking whether the directory
//     * assigned for the database exists, it reads in on an object-by-object
//     * basis. each object gets stored into the vector accounts in a sequential
//     * fashion. Hence, order is irrelevant with respect to the read/write
//     * configuration shared between the CTLregister() and the CTL_logIn. Returns
//     * 1 if successful, 0 otherwise (int).
//     * *********************************************************************
//     */
//    public int readRecords() {
//        File ff = new File(fileName);
////        CTLUser users;
////
////        int ss = 0;
//////        accounts.add(user);
////        registeringUser = new CTLUser(user);
////        if (ff.exists()) {
////            try { //store objects from file into vector
////                while (true) {
////                    users = (CTLUser) input.readObject();
////
////                    if (user.getUserN().equals(users.getUserN())) {
////                        IJ.showMessage("CTL_trainer", "user name already exists");
////                        return 0;
////                    } else {
////                        accounts.add(users);
////                    }
////                }
////            } catch (EOFException endOfFileException) {//Catch exception if any
////                IJ.log("Exception: endOfFile [CTL_record().writeRecord()].");
////                return 1;
////            } catch (ClassNotFoundException classNotFoundException) {
////                IJ.log("Unable to create object.");
////                return 0;
////            } catch (IOException ioException) {//Catch exception if any
////                IJ.showMessage("CTLregister", "Error during read from file.");
////                return 0;
////            }
////        } else {
////            if (do_debug == 1) {
////                IJ.log("Users' database not found. One will be created.");
////            }
////        }
//        return 1;
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function to close users' database after reading. More specifically, it
//     * closes the ObjectInputStream. Returns 1 if successful, 0 otherwise (int).
//     * *********************************************************************
//     */
//    public int closeFile() {
//        try {
//            if (input != null) {
//                input.close();
//                if (do_debug == 1) {
//                    IJ.log("'output' stream has closed");
//                }
//            }
//        } catch (IOException ioException) {
//            IJ.showMessage("CTLregister", "Error closing file.");
//            return 0;
//        }
//        return 1;
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function to open users' database for writing. More specifically, it
//     * creates a new instance of the the ObjectOutputStream. Returns 1 if
//     * successful, 0 otherwise (int).
//     * *********************************************************************
//     */
//    public int openFileWriter() {
//        try {
//            output = new ObjectOutputStream(new FileOutputStream(fileName));
//        } catch (IOException ioException) {
//            IJ.showMessage("Error opening file to write");
//            return 0;
//        }
//        return 1;
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function to write the users' database. After have read in objects
//     * (CTLUsers) and storing the objects in the global vector [see
//     * readRecord()], it is the job of this function to re-write the database of
//     * records by getting the vector components in a sequential manner. Hence,
//     * order can be disregarded due to the nature of the I/O configuration
//     * shared between the CTLregister() and the CTL_logIn. Returns 1 if
//     * successful; returns 0 otherwise (int). Returns 1 if successful, 0
//     * otherwise (int).
//     * *********************************************************************
//     */
//    public int writeRecord() {
////        int lastInLine = accounts.size();
////        CTLUser goingIn;
////        int ss;
////
////        //get an Iterator object for Vector using iterator() method.
////        e = accounts.elements();
////        Iterator itr = accounts.iterator();
////
////        if (do_debug == 1) {
////            IJ.log("Number of accounts: " + Integer.toString(lastInLine));
////        }
////        while (e.hasMoreElements()) {
////            //	goingIn = accounts.elementAt(i);
////
////            //		if (do_debug == 1)
////            //		    IJ.log(itr.next().toString());
////            goingIn = (CTLUser) e.nextElement();
////            //		IJ.log("user: " + goingIn.toString());
////            //output.writeObject(goingIn);
////            output.writeObject(goingIn);
////            //	ss = i;
////            //	IJ.log("The number of records: " + Integer.toString(ss));
////        }
//        return 1;
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function to close users' database after writing. More specifically, it
//     * closes the ObjectOutputStream. Returns 1 if successful, 0 otherwise
//     * (int).
//     * *********************************************************************
//     */
//    public int closeFileWriter() {
//        if (do_debug == 1) {
//            IJ.log("accounts<CTLUser> has been cleared");
//        }
//        try {
//            if (output != null) {
//                output.close();
//                if (do_debug == 1) {
//                    IJ.log("stream, 'output,' has closed");
//                }
//            }
//        } catch (IOException ioException) {
//            IJ.showMessage("CTLregister", "Error closing file.");
//            return 0;
//        }
//        return 1;
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function to open users' database for writing. More specifically, it
//     * creates a new instance of the the ObjectOutputStream. Returns 1 if
//     * successful, 0 otherwise (int).
//     * *********************************************************************
//     */
//    public int writeTextOpen() {
//        try {	    // Create file or access file     java.io.
//            outText = new BufferedWriter(new FileWriter(fileNameText, false));
//
//        } catch (IOException ioException) {
//            IJ.showMessage("CTLregister", "Error opening file to write");
//            return 0;
//        }
//        return 1;
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     *
//     **********************************************************************
//     */
//    public int writeText() {
//        if (do_debug == 1) {
//            IJ.log("CTLregister(): just entered writeText()");
//        }
//
//        File ff = new File(fileNameText);
////        int numAccounts = accounts.size();
////        CTLUser who;
////        String whos;
////
////        String format = "|%1$ -10s|%2$-10s|%3$-10s|%4$-10s|%5$-20s|%6$-10s|%7$-10s|%8$-10s|\n";
////
////        try {
////
////            if (do_debug == 1) {
////                IJ.log("CTLregister(): still trying... writeText()");
////            }
////
////            //Write to file.
////            Iterator itr = accounts.iterator();
////	    //while(itr.hasNext())
////
////            //   for(int i = 0; i < numAccounts; i++)
////            // {
////            while (itr.hasNext()) {
////                if (do_debug == 1) {
////                    IJ.log("CTLregister(): looping through users to write text file");
////                }
////
////                who = (CTLUser) itr.next();
////                //	who = new CTLUser((CTL_user)accounts.get(i));
////                outText.write("\n");
////                for (int i = 0; i < 72; i++) {
////                    outText.write("*");
////                }
////                outText.write("\n");
////
////                outText.write("Username: " + who.getUserN() + "\n");
////                outText.write("Password: " + who.getpWord() + "\n");
////                outText.write("Clearance: " + who.getClearance(1) + "\n");
////                outText.write("Date created: " + who.getDateCreated() + "\n");
////                outText.write("User's account directory: " + who.getUsersDir() + "\n");
////                outText.write(who.getFirstName() + " " + who.getLastName() + "   Employee# " + who.getEmpNum() + "   Dept. " + who.getDept() + "\n");
////
////                int j;
////                outText.write("Tutorial 1: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.tutorial_counters1.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.tutorial_scores1.get(j)) + " ");
////                }
////
////                outText.write("\n\nTutorial 2: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.tutorial_counters2.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.tutorial_scores2.get(j)) + " ");
////                }
////
////                outText.write("\n\nTutorial 3: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.tutorial_counters3.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.tutorial_scores3.get(j)) + " ");
////                }
////
////                outText.write("\n\nTutorial 4: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.tutorial_counters4.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.tutorial_scores4.get(j)) + " ");
////                }
////
////                outText.write("\n\nTutorial 5: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.tutorial_counters5.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.tutorial_scores5.get(j)) + " ");
////                }
////
////                outText.write("\n\nTutorial 6: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.tutorial_counters6.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.tutorial_scores6.get(j)) + " ");
////                }
////
////                outText.write("\n\nTutorial 7: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.tutorial_counters7.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.tutorial_scores7.get(j)) + " ");
////                }
////
////                outText.write("\n\nTest 1: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.test_counters1.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.test_scores1.get(j)) + " ");
////                }
////
////                outText.write("\n\nTest 2: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.test_counters2.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.test_scores2.get(j)) + " ");
////                }
////
////                outText.write("\n\nTest 3: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.test_counters3.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.test_scores3.get(j)) + " ");
////                }
////
////                outText.write("\n\nTest 4: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.test_counters4.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.test_scores4.get(j)) + " ");
////                }
////
////                outText.write("\n\nTest 5: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.test_counters5.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.test_scores5.get(j)) + " ");
////                }
////
////                outText.write("\n\nTest 6: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.test_counters6.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.test_scores6.get(j)) + " ");
////                }
////
////                outText.write("\n\nTest 7: \n");
////                outText.write("Counters:\n");
////                for (j = 0; j < 5; j++) {
////                    outText.write(Integer.toString(who.test_counters7.get(j)) + " ");
////                }
////                outText.write("\nScores:\n");
////                for (j = 0; j < 3; j++) {
////                    outText.write(Double.toString(who.test_scores7.get(j)) + " ");
////                }
////
////                /*
////                 outText.write("Tutorial 1: \n");
////                 outText.write("Counters:\n");
////                 for(j = 0; j < 5; j++)
////                 outText.write(Integer.toString(who.tutorial_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 0; j < 3; j++)
////                 outText.write(Double.toString(who.tutorial_scores.get(j)) + " ");
////
////                 outText.write("\n\nTutorial 2: \n");
////                 outText.write("Counters:\n");
////                 for(j = 6; j <11; j++)
////                 outText.write(Integer.toString(who.tutorial_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 4; j < 7; j++)
////                 outText.write(Double.toString(who.tutorial_scores.get(j)) + " ");
////
////                 outText.write("\n\nTutorial 3: \n");
////                 outText.write("Counters:\n");
////                 for(j = 12; j <17; j++)
////                 outText.write(Integer.toString(who.tutorial_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 8; j < 11; j++)
////                 outText.write(Double.toString(who.tutorial_scores.get(j)) + " ");
////
////                 outText.write("\n\nTutorial 4: \n");
////                 outText.write("Counters:\n");
////                 for(j = 18; j <23; j++)
////                 outText.write(Integer.toString(who.tutorial_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 12; j < 15; j++)
////                 outText.write(Double.toString(who.tutorial_scores.get(j)) + " ");
////
////                 outText.write("\n\nTutorial 5: \n");
////                 outText.write("Counters:\n");
////                 for(j = 24; j <29; j++)
////                 outText.write(Integer.toString(who.tutorial_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 16; j < 19; j++)
////                 outText.write(Double.toString(who.tutorial_scores.get(j)) + " ");
////
////                 outText.write("\n\nTutorial 6: \n");
////                 outText.write("Counters:\n");
////                 for(j = 30; j <35; j++)
////                 outText.write(Integer.toString(who.tutorial_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 20; j < 23; j++)
////                 outText.write(Double.toString(who.tutorial_scores.get(j)) + " ");
////
////                 outText.write("\n\nTutorial 7: \n");
////                 outText.write("Counters:\n");
////                 for(j = 36; j <41; j++)
////                 outText.write(Integer.toString(who.tutorial_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 24; j < 27; j++)
////                 outText.write(Double.toString(who.tutorial_scores.get(j)) + " ");
////
////
////
////                 outText.write("\n\nTest 1: \n");
////                 outText.write("Counters:\n");
////                 for(j = 0; j < 5; j++)
////                 outText.write(Integer.toString(who.test_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 0; j < 3; j++)
////                 outText.write(Double.toString(who.test_scores.get(j)) + " ");
////
////                 outText.write("\n\nTest 2: \n");
////                 outText.write("Counters:\n");
////                 for(j = 6; j <11; j++)
////                 outText.write(Integer.toString(who.test_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 4; j < 7; j++)
////                 outText.write(Double.toString(who.test_scores.get(j)) + " ");
////
////                 outText.write("\n\nTest 3: \n");
////                 outText.write("Counters:\n");
////                 for(j = 12; j <17; j++)
////                 outText.write(Integer.toString(who.test_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 8; j < 11; j++)
////                 outText.write(Double.toString(who.test_scores.get(j)) + " ");
////
////                 outText.write("\n\nTest 4: \n");
////                 outText.write("Counters:\n");
////                 for(j = 18; j <23; j++)
////                 outText.write(Integer.toString(who.test_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 12; j < 15; j++)
////                 outText.write(Double.toString(who.test_scores.get(j)) + " ");
////
////                 outText.write("\n\nTest 5: \n");
////                 outText.write("Counters:\n");
////                 for(j = 24; j <29; j++)
////                 outText.write(Integer.toString(who.test_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 16; j < 19; j++)
////                 outText.write(Double.toString(who.test_scores.get(j)) + " ");
////
////                 outText.write("\n\nTest 6: \n");
////                 outText.write("Counters:\n");
////                 for(j = 30; j <35; j++)
////                 outText.write(Integer.toString(who.test_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 20; j < 23; j++)
////                 outText.write(Double.toString(who.test_scores.get(j)) + " ");
////
////                 outText.write("\n\nTest 7: \n");
////                 outText.write("Counters:\n");
////                 for(j = 36; j <41; j++)
////                 outText.write(Integer.toString(who.test_counters.get(j)) + " ");
////                 outText.write("\nScores:\n");
////                 for(j = 24; j < 27; j++)
////                 outText.write(Double.toString(who.test_scores.get(j)) + " ");
////                 */
////                if (do_debug == 1) {
////                    IJ.log("CTLregister(): end of loop, but could loop again");
////                }
////            }
////
////            //	    outText.close();	//Close the output stream
////        } catch (Exception e) {//Catch exception if any
////            // IJ.showMessage("Error: " + e.getMessage());
////
////            if (do_debug == 1) {
////                IJ.log("CTLregister(): Exception writeText(): " + e.getMessage());
////            }
////            return 0;
////        }
//        return 1;
//    }
//
//    /**
//     * *****************************************************************
//     */
//    /**
//     * Function to close users' database after writing. More specifically, it
//     * closes the ObjectOutputStream. Returns 1 if successful, 0 otherwise
//     * (int).
//     * *********************************************************************
//     */
//    public int writeTextClose() {
//        try {
//            outText.close();
//
//            if (do_debug == 1) {
//                IJ.log("stream, 'output,' has closed");
//            }
//
//        } catch (IOException ioException) {
//            IJ.showMessage("CTLregister", "Error closing file.");
//            return 0;
//        }
//        return 1;
//    }
//
//    public void writeLog() {
//        FileWriter fwrite;
//        Calendar calendar = new GregorianCalendar();
//        String am_pm;
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int hour = calendar.get(Calendar.HOUR);
//        int minute = calendar.get(Calendar.MINUTE);
//        int second = calendar.get(Calendar.SECOND);
//        if (calendar.get(Calendar.AM_PM) == 0) {
//            am_pm = "AM";
//        } else {
//            am_pm = "PM";
//        }
//
//        String date = Integer.toString(month) + "/" + Integer.toString(day) + "/"
//                + Integer.toString(year) + " " + Integer.toString(hour) + ":"
//                + Integer.toString(minute) + ":" + Integer.toString(second) + am_pm;
//
//        String poi = fileNameUserLog;
//
//        if (do_debug == 1) {
//            IJ.log(poi);
//        }
//        try {
//
//            fwrite = new FileWriter(new File(poi));
//            for (int i = 0; i < 72; i++) {
//                fwrite.write("*");
//            }
//            fwrite.write("\n");
//            fwrite.write(date + "\n" + registerName + " has created an account\n");
//
//            fwrite.close();
//        } catch (Exception ee) {
//            ee.printStackTrace();
//        }
//        poi = fileNameLog;
//        try {
//            fwrite = new FileWriter(new File(poi), true);
//            fwrite.write("\n");
//            for (int i = 0; i < 72; i++) {
//                fwrite.write("*");
//            }
//            fwrite.write("\n");
//            for (int i = 0; i < 72; i++) {
//                fwrite.write("*");
//            }
//            fwrite.write("\n");
//
//            fwrite.write(date + " account created:" + "\n");
////            fwrite.write("Name: " + registeringUser.getFirstName() + " " + registeringUser.getLastName() + "\n");
////            fwrite.write("Employee# " + registeringUser.getEmpNum() + ", Dept." + registeringUser.getDept() + ", Email: " + registeringUser.getEmail() + "\n");
////            fwrite.write("Username: " + registeringUser.getUserN() + ", Password: " + registeringUser.getpWord() + "\n");
//
//            for (int i = 0; i < 72; i++) {
//                fwrite.write("*");
//            }
//            fwrite.write("\n");
//
//        } catch (Exception ee) {
//            if (do_debug == 1) {
//                IJ.log("CTLregister(): Error creating history.log");
//            }
//            IJ.log("CTLregister(): same error:" + ee.getMessage());
//        }
//    }
//
//    //accounts.clear();
//    public void keyReleased(KeyEvent e) {
//    }
//
//    public void keyTyped(KeyEvent e) {
//    }
//
//    public void keyListener(KeyEvent e) {
//    }
//}
//
//// end class CTLregister
///*
//
//
// public static class MyOwnFocusTraversalPolicy
// extends FocusTraversalPolicy
// {
// Vector<Component> order;
// public MyOwnFocusTraversalPolicy(Vector<Component> order) {
// this.order = new Vector<Component>(order.size());
// this.order.addAll(order);
// }
// /*public Component getComponentAfter(Container focusCycleRoot,
// Component aComponent)
// {
// int idx = (order.indexOf(aComponent) + 1) % order.size();
// return order.get(idx);
// }
//
// public Component getComponentBefore(Container focusCycleRoot,
// Component aComponent)
// {
// int idx = order.indexOf(aComponent) - 1;
// if (idx < 0) {
// idx = order.size() - 1;
// }
// return order.get(idx);
// }
// public Component getComponentAfter(Container focusCycleRoot,
// Component aComponent) {
// if (aComponent.equals(text_firstN)) {
// return text_lastN;
// } else if (aComponent.equals(text_lastN)) {
// return text_empNum;
// } else if (aComponent.equals(text_empNum)) {
// return text_dept;
// } else if (aComponent.equals(text_dept)) {
// return text_email;
// } else if (aComponent.equals(text_email)) {
// return text_userN;
// } else if (aComponent.equals(text_userN)) {
// return text_pWord;
// } else if (aComponent.equals(text_pWord)) {
// return text_re_pWord;
// }else if (aComponent.equals(text_re_pWord)) {
// return b_register;
// }else if (aComponent.equals(b_register)) {
// return b_cancel;
// }else if (aComponent.equals(b_cancel)) {
// return text_firstN;
// }
// return text_firstN;
// }
//
// public Component getComponentBefore(Container focusCycleRoot,
// Component aComponent) {
// if (aComponent.equals(tf1)) {
// return table;
// } else if (aComponent.equals(tf2)) {
// return tf1;
// } else if (aComponent.equals(tf3)) {
// return tf2;
// } else if (aComponent.equals(tf4)) {
// return tf3;
// } else if (aComponent.equals(tf5)) {
// return tf4;
// } else if (aComponent.equals(tf6)) {
// return tf5;
// } else if (aComponent.equals(table)) {
// return tf6;
// }
// return text_firstN;
// }
//
// public Component getDefaultComponent(Container focusCycleRoot) {
// return text_firstN;
// }
// public Component getLastComponent(Container focusCycleRoot) {
// return text_lastN;
// }
// public Component getFirstComponent(Container focusCycleRoot) {
// return text_firstN;
// }
// }
// }
//
// void writeRecord(CTLUser user)
// {
// File ff = new File(fileName);
// int ss = 0;
// if(ff.exists())
// {
// openFile();   //open temp file to copy existing records to, and then appen new record.
// ss = 1;
// }
//
// boolean[] get_out = new boolean[1];
// get_out[0] = false;
//
// if(ss == 1)// && flag_isOpen[0])
// {
// try{
// CTLUser users;
// openCurrentFile();   //open existing database to read->copy into temp file
//
// while(!get_out[0])
// {
// users = (CTLUser) input.readObject();
// output.writeObject(users);
// //		    IJ.log(users.toString());
// }
// }
// catch (EOFException endOfFileException){//Catch exception if any
// IJ.log("Exception: endOfFile [CTL_record().writeRecord()].");
// get_out[0] = true;
// }
// catch(ClassNotFoundException classNotFoundException){
// IJ.log("Exception: classNotFound [CTL_record().writeRecord()].");}
// catch (IOException ioException){//Catch exception if any
// IJ.showMessage("CTLregister", "Error writing to file.");
// IJ.log("Exception: io [CTL_record().writeRecord()].");
// return;
// }
// finally{
// IJ.log("close File");
// closeFile();
//
// if(ss == 1)
// {
// IJ.log("copy File");
// copyFile();
// }
// }
// }else
// {
// try{
// output = new ObjectOutputStream(
// new FileOutputStream(fileName));
// output.writeObject(user);
// }//end try
// catch (FileNotFoundException ex){
// IJ.showMessage("CTLregister", "Error records' directory not found.");
// flag_isOpen[0] = false;
// }
// catch (IOException ioException){//Catch exception if any
// IJ.showMessage("CTLregister", "Error opening account records.");
// flag_isOpen[0] = false;
// return;
// }
// //	 }
// //	try{
// //	    output.writeObject(user);
// //	}catch(IOException ioException)
// //	    {IJ.log("Error closing file [1.0]");}//end catch
// finally{
// IJ.log("close File");
// closeFile();
// }
// }
// text_firstN.setText("");
// text_lastN.setText("");
// text_empNum.setText("");
// text_dept.setText("");
// text_email.setText("");
// text_pWord.setText("");
// text_re_pWord.setText("");
// text_userN.setText("");
//
// this.setVisible(false);
// IJ.showMessage("CTLregister", "Username created.");
// }*/
