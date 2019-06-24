/*
 * projectOpen.java
 *
 * Created on December 16, 2002, 7:05 AM
 */
package com.likha.ide;

import java.io.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.filechooser.*;

import java.awt.*;
//import java.io.File;
import java.awt.event.*;
import java.beans.*;
import java.util.*;

import java.io.*;
import java.awt.Point;
import java.net.*;

//import HTTPClient.*;
import java.io.*;
import encryptor.*;
/**
 *
 * @author  test1
 */
public class externalBrowserHome extends javax.swing.JDialog {
    
    
    
    /** Creates new form projectOpen */
    public externalBrowserHome(mainForm parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myParent = parent;
        
        previewer = new FilePreviewer( chooser );
        
        displayBrowserHome();
        
        try {
            UIManager.setLookAndFeel( LnF );
            SwingUtilities.updateComponentTreeUI( this );
            //if(chooser != null) {
            SwingUtilities.updateComponentTreeUI( chooser );
            //}
        } catch (UnsupportedLookAndFeelException exc) {
        } catch (IllegalAccessException exc) {
            myParent.printMessage("IllegalAccessException Error:" + exc);
        } catch (ClassNotFoundException exc) {
            myParent.printMessage("ClassNotFoundException Error:" + exc);
        } catch (InstantiationException exc) {
            myParent.printMessage("InstantiateException Error:" + exc);
        }
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        chooser = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        getJDBC = new javax.swing.JButton();
        browserHomeTextField = new javax.swing.JTextField();

        chooser.setDialogTitle("Select executable");
        chooser.setFont(new java.awt.Font("Default", 0, 11));

        setTitle("External Web Browser");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel5, java.awt.BorderLayout.WEST);

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

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel6.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(1, 1, 1, 1)));
        jPanel6.setPreferredSize(new java.awt.Dimension(400, 125));
        getJDBC.setFont(new java.awt.Font("Default", 0, 11));
        getJDBC.setText("Select browser executable ...");
        getJDBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getJavaHomeActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(getJDBC, gridBagConstraints);

        browserHomeTextField.setFont(new java.awt.Font("Default", 0, 11));
        browserHomeTextField.setMinimumSize(new java.awt.Dimension(350, 19));
        browserHomeTextField.setPreferredSize(new java.awt.Dimension(350, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel6.add(browserHomeTextField, gridBagConstraints);

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-451)/2, (screenSize.height-203)/2, 451, 203);
    }//GEN-END:initComponents
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // Add your handling code here:
        if( writeBrowserHomeConfig() ) {
            myParent.storeBrowserHome();
            setVisible(false);
            dispose();
        }
        
    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // Add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private void getJavaHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getJavaHomeActionPerformed
        
        if (chooser.isMultiSelectionEnabled()) {
            chooser.setSelectedFiles(null);
        } else {
            chooser.setSelectedFile(null);
        }
        
        // clear the preview from the previous display of the chooser
        JComponent accessory = chooser.getAccessory();
        if (accessory != null) {
            ((FilePreviewer)accessory).loadImage(null);
        }
        int retval = chooser.showDialog(this, null);
        if (retval == JFileChooser.APPROVE_OPTION) {
            
            File theFile = chooser.getSelectedFile();
            if( theFile != null ) {
                if( theFile.isFile() ) {
                    browserHomeTextField.setText( theFile.getAbsolutePath() );
                }
            }
            
        } else if (retval == JFileChooser.CANCEL_OPTION) {
            myParent.printMessage( "Canceled");
        } else if (retval == JFileChooser.ERROR_OPTION) {
            myParent.printMessage( "Error");
        } else {
            
        }
        
    }//GEN-LAST:event_getJavaHomeActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // new projectOpen( new mainForm(), true ).show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField browserHomeTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JFileChooser chooser;
    private javax.swing.JButton getJDBC;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    
    private boolean valid = false;
    private FilePreviewer previewer;
    private String LnF = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    private String browserHome = "browser.properties";
    mainForm myParent; // mainForm parent
    DataInputStream in;
    
    class FilePreviewer extends JComponent implements PropertyChangeListener {
        ImageIcon thumbnail = null;
        
        public FilePreviewer(JFileChooser fc) {
            setPreferredSize(new Dimension(100, 50));
            fc.addPropertyChangeListener(this);
        }
        
        public void loadImage(File f) {
            if (f == null) {
                thumbnail = null;
            } else {
                ImageIcon tmpIcon = new ImageIcon(f.getPath());
                if(tmpIcon.getIconWidth() > 90) {
                    thumbnail = new ImageIcon(
                    tmpIcon.getImage().getScaledInstance(90, -1, Image.SCALE_DEFAULT));
                } else {
                    thumbnail = tmpIcon;
                }
            }
        }
        
        public void propertyChange(PropertyChangeEvent e) {
            String prop = e.getPropertyName();
            if(prop == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
                if(isShowing()) {
                    loadImage((File) e.getNewValue());
                    repaint();
                }
            }
        }
        
    }
    
    private boolean writeBrowserHomeConfig() {
        
        boolean rvalue = false;
        
        String fileName = myParent.getArchiverBaseDir() + browserHome;
        String file = browserHomeTextField.getText().trim();
        
        if( file.length() > 2 ) {
            
            String[] configline = { file };
            myParent.createConfigFile( fileName, configline );
            rvalue = true;
                        
        } else {
            rvalue = false;
        }
        
        return rvalue;
    }
    
    // read j2sdkhome.properties file
    private void displayBrowserHome() {
        
        String fileName = myParent.getArchiverBaseDir() + browserHome;
        
        if( new File( fileName ).exists() ) {
            browserHomeTextField.setText( getConfigLine() );
        }
        
    }
    
    
    
    
    // read data
    public String getConfigLine() {
        
        String fileName = myParent.getArchiverBaseDir() + browserHome;
        String rvalue = new String();
        
        try {
            in = new DataInputStream( new BufferedInputStream( new FileInputStream( fileName ) ) );
            try {
                rvalue = in.readLine();
                //DataInputStream in;
            } catch( IOException e ){
            }
        } catch( IOException e){
        }
        
        return rvalue;
        
    }
    
    
}
