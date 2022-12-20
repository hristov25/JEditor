/**
 * 
 */
package com.jeditor.main.gui.utils.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.jeditor.main.gui.utils.menu.actions.MenuEngine;
import com.jeditor.main.gui.utils.menu.actions.MouseEngine;

/**
 * @author Hristo
 *
 * @version 1.0
 */
public class JEditorPopMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuItem miSelect;

	private JMenuItem miCut;

	private JMenuItem miCopy;

	private JMenuItem miPaste;

	private JMenuItem miEditText;

	private JMenuItem miSave;

	public JEditorPopMenu() {

		this.initPopMenu();

	}

	private void initPopMenu() {

		MenuEngine engine = new MenuEngine(this);

		miSelect = new JMenuItem("Select All", KeyEvent.VK_A);

		miCopy = new JMenuItem("Copy", KeyEvent.VK_C);

		miCut = new JMenuItem("Cut", KeyEvent.VK_X);

		miPaste = new JMenuItem("Paste", KeyEvent.VK_V);

		miEditText = new JMenuItem("Edit text");

		miSave = new JMenuItem("Save", KeyEvent.VK_S);

		miSelect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

		miCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

		miCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		miPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		miSelect.addActionListener(engine);

		miCopy.addActionListener(engine);

		miCut.addActionListener(engine);

		miPaste.addActionListener(engine);

		miEditText.addActionListener(engine);

		miSave.addActionListener(engine);

		add(miCopy);

		add(miCut);

		add(miPaste);

		add(new JSeparator(SwingConstants.HORIZONTAL));

		add(miSave);

		add(new JSeparator(SwingConstants.HORIZONTAL));

		add(miEditText);

	}

}
