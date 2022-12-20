/**
 * 
 */
package com.jeditor.main.gui.utils.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.jeditor.main.gui.utils.menu.actions.MenuEngine;

/**
 * @author Hristo
 * 
 * @version 1.0
 *
 */
public class JEditorMenu extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JEditorMenu() {

		this.setMenu();

	}

	private void setMenu() {

		MenuEngine engine = new MenuEngine(this);

		JMenu mFile = new JMenu("File");

		JMenu mEdit = new JMenu("Edit");

		JMenu mHelp = new JMenu("Help");

		String[] sNameItems = {"New", "Open", "Close", "Close All", "Save","Save as","Print","Exit","About JTextEditor","Copy","Cut","Paste","Select All","Clear All","Edit text"};

		String[] iMenuBelong = {"File","File","File","File","File","File","File","File","Help","Edit","Edit","Edit","Edit","Edit","Edit"};

		boolean[] bSeparator = {true,true,false,true,false,true,true,false,false,false,false,true,false,true,false};
		
		final int arLength = 15;

		JEditorMenuItems[] arMenuItems = new JEditorMenuItems[arLength];

		for(int i = 0; i < arMenuItems.length; i++) {

			arMenuItems[i] = new JEditorMenuItems(sNameItems[i], iMenuBelong[i], bSeparator[i]);

			JMenuItem miEditor = new JMenuItem(arMenuItems[i].getNameItem());

			if(miEditor.getText().equals("New")){

				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

			}else if(miEditor.getText().equals("Open")){

				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK | ActionEvent.ALT_MASK));

			}else if(miEditor.getText().equals("Close")){

				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

			}else if(miEditor.getText().equals("Close All")){

				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));

			}else if(miEditor.getText().equals("Save")){

				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

			}else if(miEditor.getText().equals("Print")){

				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

			}else if(miEditor.getText().equals("Exit")){

				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));

			}else if(miEditor.getText().equals("Select All")){

				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
			
			}else if(miEditor.getText().equals("Copy")){
		
				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			
			}else if(miEditor.getText().equals("Cut")){
			
				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
			
			}else if(miEditor.getText().equals("Paste")){
			
				miEditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
			
			}

			miEditor.addActionListener(engine);

			if(arMenuItems[i].getMenuBelong().equals("File")) {

				mFile.add(miEditor);

				if(arMenuItems[i].isSeparator()) {

					mFile.add(new JSeparator(SwingConstants.HORIZONTAL));

				}

			}else if(arMenuItems[i].getMenuBelong().equals("Edit")) {

				mEdit.add(miEditor);

				if(arMenuItems[i].isSeparator()) {

					mEdit.add(new JSeparator(SwingConstants.HORIZONTAL));

				}

			}else if(arMenuItems[i].getMenuBelong().equals("Help")) {

				mHelp.add(miEditor);

				if(arMenuItems[i].isSeparator()) {

					mHelp.add(new JSeparator(SwingConstants.HORIZONTAL));

				}

			}

		}

		mFile.setMnemonic(KeyEvent.VK_ALT);

		mFile.setMnemonic(KeyEvent.VK_ALT);

		mFile.setMnemonic(KeyEvent.VK_ALT);

		add(mFile);

		add(mEdit);

		add(mHelp);

	}

}
