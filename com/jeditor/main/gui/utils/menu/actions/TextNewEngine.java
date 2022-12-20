/**
 * 
 */
package com.jeditor.main.gui.utils.menu.actions;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.jeditor.main.gui.utils.JTextNew;

/**
 * @author Hristo
 * 
 * @version 1.0
 *
 */
public class TextNewEngine implements PropertyChangeListener{

	private JTextNew textNew;
	
	/**
	 * 
	 */
	public TextNewEngine(JTextNew tNew) {
		
		this.textNew = tNew;
		
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		
		
	}

}
