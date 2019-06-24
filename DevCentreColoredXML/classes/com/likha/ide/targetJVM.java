/*
 * saveYesNo.java
 *
 * Created on December 28, 2002, 11:02 AM
 */
package com.likha.ide;

import java.io.*;

/**
 *
 * @author  test1
 */
public class targetJVM extends javax.swing.JDialog {
    
    /** Creates new form saveYesNo */
    public targetJVM(mainForm parent, boolean modal) {
        super(parent, modal);
        initComponents();
        main = parent;
        
        versionTextField.setText( main.readJvmSetting() );
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        versionTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setTitle("Target JVM Version");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Default", 0, 11));
        jLabel1.setText("Compile Target JVM ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        versionTextField.setFont(new java.awt.Font("Default", 0, 11));
        versionTextField.setText("default");
        versionTextField.setPreferredSize(new java.awt.Dimension(100, 19));
        jPanel1.add(versionTextField, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        okButton.setFont(new java.awt.Font("Default", 0, 11));
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jPanel3.add(okButton);

        cancelButton.setFont(new java.awt.Font("Default", 0, 11));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel3.add(cancelButton);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new java.awt.Dimension(272, 133));
        setLocation((screenSize.width-272)/2,(screenSize.height-133)/2);
    }//GEN-END:initComponents
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // Add your handling code here:
        String version = versionTextField.getText().trim();
        
        if( version.length() != 0 ) {
            String fileName = main.getBuildDirectory() + "\\jvmversion.properties";
            String[] config = new String[2];
            config[0] = "# Compilation Target JVM";
            config[1] = "jvmVersion = " + version;
            
            main.createConfigFile( fileName, config );
            
            setVisible(false);
            dispose();
        } else {
            versionTextField.setText( "default" );
        }
        
    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // Add your handling code here:
        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_cancelButtonActionPerformed
    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField versionTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    private mainForm main;    
        
    
}
