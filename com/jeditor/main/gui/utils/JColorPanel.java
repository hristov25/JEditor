/**
 * 
 */
package com.jeditor.main.gui.utils;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.jeditor.main.utils.JEditorConstance;

/**
 * @author Hrtisto
 *
 */
public class JColorPanel extends JPanel {
	
	private JColorChooser colorChooser;
	
	/**
	 * 
	 */
	public JColorPanel(JComponent comp) {
		
		this.initColorPanel(comp);
		
	}
	
	
	private void initColorPanel(JComponent comp) {
		
		colorChooser = new JColorChooser(JEditorConstance.TEXT_COLOR);
		
		colorChooser.setBorder(BorderFactory.createTitledBorder("Choose color"));
		
		Color color = colorChooser.getColor();
		
		add(colorChooser);
		
	}

}
