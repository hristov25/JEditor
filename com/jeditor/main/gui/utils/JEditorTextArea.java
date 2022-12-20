/**
 * 
 */
package com.jeditor.main.gui.utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import com.jeditor.main.gui.utils.menu.JEditorPopMenu;
import com.jeditor.main.gui.utils.menu.actions.MouseEngine;

/**
 * @author Hristo
 *
 */
public class JEditorTextArea extends JTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JEditorPopMenu popupMenu;
	
	public JEditorTextArea(Font f, Color c) {
		
		this.intTextArea(f, c);
		
	}
	
	private void intTextArea(Font f, Color c) {
		
		setFont(f);
		
		setForeground(c); 
				
		popupMenu = new JEditorPopMenu();
		
		MouseEngine mouseEngine = new MouseEngine(popupMenu);
		
		setRows(40);
		
		setColumns(100); 
				
		addMouseListener(mouseEngine);
		
		setLineWrap(true);
		
		setWrapStyleWord(true);
		
	}

}
