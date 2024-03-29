/*
 * treePopUp.java
 *
 * Created on March 29, 2003, 2:11 PM
 */

package com.likha.ide;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.tree.*;
import javax.swing.event.*;
import java.io.*;

/**
 *
 * @author  test1
 */
public class clearMessagePopUp extends JPopupMenu implements ActionListener, ItemListener {
        
    popUpMenu clearMenuItem = new popUpMenu("Clear messages");
       
    JSeparator separator;
    mainForm main;
    
    /** Creates a new instance of treePopUp */
    public clearMessagePopUp( mainForm parentFrame ) {
            
        main = parentFrame;
        
        setBorder( new javax.swing.border.LineBorder( new java.awt.Color( 147,139,125 ) ) );
        
        clearMenuItem.addActionListener(this);
        clearMenuItem.setEnabled( true );
        add( clearMenuItem );
                
    }
    
    public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
        
        String actionCmd = actionEvent.getActionCommand();
        
        if( actionCmd.equalsIgnoreCase( "Clear messages" ) ) {
            main.clearMessages();
        } 
        
    }
    
    public void itemStateChanged(java.awt.event.ItemEvent itemEvent) {
    }
    
    
    // popUpMenu
    private class popUpMenu extends JMenuItem  {
        
        public popUpMenu( String label) {
            super( label );
            setBackground( new java.awt.Color( 235,234,231 ) );
        }
        
        
    }
            
    
}
