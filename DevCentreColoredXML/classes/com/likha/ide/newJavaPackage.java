/*
 * saveYesNo.java
 *
 * Created on December 28, 2002, 11:02 AM
 */
package com.likha.ide;

import java.util.*;
import java.awt.*;
import javax.swing.tree.*;
import java.io.*;

/**
 *
 * @author  test1
 */
public class newJavaPackage extends javax.swing.JDialog {
    
    /** Creates new form saveYesNo */
    public newJavaPackage(mainForm parent, boolean modal) {
        super(parent, modal);
        initComponents();
        main = parent;
        //directory = dir;
        //directoryLabel.setText( "Creating in " + dir.substring( main.getBuildDirectory().length() ) );                       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        selectionGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        newPackageTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setTitle("New Java Package");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(1, 1, 1, 1)));
        jLabel11.setFont(new java.awt.Font("Default", 0, 11));
        jLabel11.setText("File Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel11, gridBagConstraints);

        newPackageTextField.setFont(new java.awt.Font("Default", 0, 11));
        newPackageTextField.setMinimumSize(new java.awt.Dimension(200, 19));
        newPackageTextField.setPreferredSize(new java.awt.Dimension(200, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel1.add(newPackageTextField, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        createButton.setFont(new java.awt.Font("Default", 0, 11));
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        jPanel3.add(createButton);

        doneButton.setFont(new java.awt.Font("Default", 0, 11));
        doneButton.setText("Close");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        jPanel3.add(doneButton);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel5, java.awt.BorderLayout.WEST);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-421)/2, (screenSize.height-201)/2, 421, 201);
    }//GEN-END:initComponents
    
    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // Add your handling code here:
        
        String newPackage = newPackageTextField.getText().trim();
                
        if( newPackage.length() == 0 ) {
            return;
        } else {            

            if( newPackage.trim().length() > 0 ) {
                newPackage = main.getTreeCurrentPath() + '\\' + newPackage;    
                if( !new File( newPackage ).exists() ) {
                    File dir = new File( newPackage );
                    dir.mkdir();                              
                    main.printMessage( "Created " + newPackage );
                } else {
                    main.printMessage( "Error: " + newPackage + " already exists");
                }                
            }
        }
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_createButtonActionPerformed
    
    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // Add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_doneButtonActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //new saveYesNo( mainForm parent, true).show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField newPackageTextField;
    private javax.swing.ButtonGroup selectionGroup;
    // End of variables declaration//GEN-END:variables
    
    private mainForm main;
    private String directory;;
    
       
}
