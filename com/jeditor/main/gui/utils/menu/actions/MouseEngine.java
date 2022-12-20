/**
 * 
 */
package com.jeditor.main.gui.utils.menu.actions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;

import com.jeditor.main.gui.utils.JEditorTextArea;
import com.jeditor.main.gui.utils.menu.JEditorPopMenu;

/**
 * @author Hristo
 *
 */
public class MouseEngine extends MouseAdapter {
	
	private JEditorPopMenu popMenu;

	public MouseEngine(JEditorPopMenu popMenu) {

		this.popMenu = popMenu;

	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		super.mousePressed(e);
		
		popShowUp(e);
		
	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

		super.mouseReleased(e);
		
		popShowUp(e); 
	
	}

	private void popShowUp(MouseEvent e) {
		
		if(e.isPopupTrigger()) {
			
			popMenu.show(e.getComponent(), e.getX(), e.getY());
			
		}
		
	}

}
