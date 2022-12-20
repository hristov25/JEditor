/**
 * 
 */
package com.jeditor.main;

import com.jeditor.main.gui.JEditorGui;
import com.jeditor.main.utils.JEditorConstance;

/**
 * <code>JTextEditor</code> is main class for JTextEditor application.
 * 
 * @author Hristo
 *
 * @version 1.0
 */
public class JTextEditor {

	/**
	 * @param args
	 */
	 
	private static JEditorGui jEditorGui;
	
	
	
	/**
	 * @return the jEditorGui
	 */
	public static JEditorGui getjEditorGui() {
		return jEditorGui;
	}



	public static void main(String[] args) {
		
		JTextEditor.jEditorGui = new JEditorGui(JEditorConstance.EDITOR_TITLE, JEditorConstance.EDITOR_WIDTH, JEditorConstance.EDITTOR_HEIGHT);
		
		jEditorGui.setVisible(true);

	}

}
