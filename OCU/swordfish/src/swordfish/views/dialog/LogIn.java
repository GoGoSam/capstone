/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swordfish.views.dialog;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author jrob
 */
public class LogIn extends javax.swing.JDialog {

    @SuppressWarnings("UseOfObsoleteCollectionType")
    private ArrayList<JButton> butts = new ArrayList<JButton>();

    public LogIn(int[] pointer) {
        this.pointer = pointer;
        initComponents();
//        pack();
//        butts = new Vector();
        butts.add(b_cancel);
        butts.add(b_logon);
        butts.add(b_register);
        this.setResizable(false);
    }

    public LogIn(int[] pointer, ArrayList<JLabel> labs) {
        this.pointer = pointer;
        initComponents();
//        pack();
//        butts = new Vector();
        this.labs = labs;
        butts.add(b_cancel);
        butts.add(b_logon);
        butts.add(b_register);
        this.setResizable(false);
    }

    /**
     * Creates new form LogIn
     *
     * @param parent
     * @param modal
     */
    public LogIn(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        butts.add(b_cancel);
        butts.add(b_logon);
        butts.add(b_register);
    }

    public ArrayList<JButton> getButtons() {
        return butts;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_root = new JPanel();
        l_massID = new javax.swing.JLabel();
        l_password = new javax.swing.JLabel();
        tf_massID = new javax.swing.JTextField();
        tf_password = new javax.swing.JTextField();
        l_massDOT_logo = new javax.swing.JLabel();
        b_logon = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();
        b_register = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        l_massID.setText("MassDOT ID:");

        l_password.setText("Password:");

        l_massDOT_logo.setIcon(new javax.swing.ImageIcon("/Users/jrob/capstoneECE/capstone/OCU/swordfish/resources/massDot_log_small.jpg")); // NOI18N

        b_logon.setText("Log-on");
        b_logon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_logonActionPerformed(evt);
            }
        });

        b_cancel.setText("Cancel");
        b_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        b_register.setText("Register");
        b_register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_registerActionPerformed(evt);
            }
        });

        GroupLayout p_rootLayout = new GroupLayout(p_root);
        p_root.setLayout(p_rootLayout);
        p_rootLayout.setHorizontalGroup(
                p_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, p_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(p_rootLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(b_logon, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(b_cancel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(b_register, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                        .addGroup(p_rootLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(l_massDOT_logo)))
                .addGroup(p_rootLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(p_rootLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(l_massID)
                                .addComponent(l_password))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_massID, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(tf_password)))
        );
        p_rootLayout.setVerticalGroup(
                p_rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, p_rootLayout.createSequentialGroup()
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addGroup(p_rootLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(l_massID)
                                .addComponent(tf_massID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(p_rootLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(l_password)
                                .addComponent(tf_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(p_rootLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(b_cancel)
                                .addComponent(b_logon)
                                .addComponent(b_register))
                        .addGap(3, 3, 3)
                        .addComponent(l_massDOT_logo)
                        .addGap(12, 12, 12))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(p_root, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(p_root, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_registerActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_registerActionPerformed
        pointer[0] = 3;
    }//GEN-LAST:event_b_registerActionPerformed

    private void b_cancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        pointer[0] = 2;
        this.dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_logonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_b_logonActionPerformed
        pointer[0] = 1;
    }//GEN-LAST:event_b_logonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final LogIn dialog = new LogIn(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
//                        System.exit(0);
                        dialog.setVisible(false);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    /**
     *
     */
    int[] pointer = new int[1];

    private ArrayList<JLabel> labs;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_logon;
    private javax.swing.JButton b_register;
    private javax.swing.JLabel l_massDOT_logo;
    private javax.swing.JLabel l_massID;
    private javax.swing.JLabel l_password;
    private javax.swing.JPanel p_root;
    private javax.swing.JTextField tf_massID;
    private javax.swing.JTextField tf_password;
    // End of variables declaration//GEN-END:variables
}
