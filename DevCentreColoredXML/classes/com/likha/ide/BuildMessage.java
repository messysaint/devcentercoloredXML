/*
 * BuildMessage.java
 *
 * Created on June 21, 2003, 7:20 AM
 */

package com.likha.ide;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPopupMenu;

import java.io.*;


/**
 *
 * @author  test1
 */
public class BuildMessage extends JTextArea {
    
    /** Creates a new instance of BuildMessage */
    public BuildMessage() {
        addMouseListener( new PopupListener() );
        setBorder( new javax.swing.border.EmptyBorder(new java.awt.Insets(1, 1, 1, 1)) );
        //setBackground( new java.awt.Color(205, 205, 205) );        
    }
    
    
    public void clearMessages() {
        setText( "" );
    }
    
    public void copyMessages() {
        setSelectionStart(0);
        setSelectionEnd( getText().length() );
        copy();
    }
    
    // popUp Listener for each cell
    class PopupListener extends MouseAdapter {
        
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }
        
        public void mouseReleased(MouseEvent e) {
            //maybeShowPopup(e);
        }
        
        private void maybeShowPopup(MouseEvent e) {
            
            /*
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            treePopUp popup = new treePopUp( main, DynamicTree.getCurrentPath(), node );
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
             */
            if( e.getButton() == MouseEvent.BUTTON3 ) { // right click
                buildMessagePopUp popup = new buildMessagePopUp();
                //if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                //}
            }
            
            
            
        }
        
    }
    
    
    
    
    /**
     *
     * @author  test1
     */
    class buildMessagePopUp extends JPopupMenu implements ActionListener, ItemListener {
        
        popUpMenu clearMenuItem = new popUpMenu("Clear messages");
        popUpMenu copyMenuItem = new popUpMenu("Copy messages");        
        
        /** Creates a new instance of treePopUp */
        public buildMessagePopUp() {                        
            
            setBorder( new javax.swing.border.LineBorder( new java.awt.Color( 147,139,125 ) ) );
            
            clearMenuItem.addActionListener(this);
            clearMenuItem.setEnabled( true );
            add( clearMenuItem );
            
            JSeparator separator = new javax.swing.JSeparator();
            add( separator );
        
            copyMenuItem.addActionListener(this);
            copyMenuItem.setEnabled( true );
            add( copyMenuItem );
            
        }
        
        
        public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
            
            String actionCmd = actionEvent.getActionCommand();
            
            if( actionCmd.equalsIgnoreCase( "clear messages" ) ) {
                clearMessages();
            } else if( actionCmd.equalsIgnoreCase( "copy messages" ) ) {
                copyMessages();
            } else {
                System.out.println( "Error: Action not defined: " + actionEvent.toString() );
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
    
    
    
}


