/**
 * 
 */
package com.jeditor.main.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jeditor.main.gui.utils.JEditorTextArea;
import com.jeditor.main.gui.utils.JStatusPanel;
import com.jeditor.main.gui.utils.JTextTools;
import com.jeditor.main.gui.utils.menu.JEditorMenu;
import com.jeditor.main.utils.JEditorConstance;
import com.jeditor.main.utils.JEditorUtils;

/**
 * An extended version of {@link JFrame} modified for Editor;
 * 
 * @author Hristo
 * 
 * @version 1.0
 *
 */
public class JEditorGui extends JFrame {

	private static final long serialVersionUID = 1L;

	private JEditorMenu jEditorMenu;

	private JStatusPanel pStatus;

	private JScrollPane pTextArea;

	private JTextTools pTools;	

	private JEditorTextArea taEditor;

	private JTabbedPane tabbedPane;

	/**
	 * Constructor for class <code>JEditorGui</code>
	 * 
	 * @param title The title of Editor
	 * @param width The width of Editor
	 * @param height The height of Editor
	 */
	public JEditorGui(String title, int width, int height) {
		
		Dimension dScreen = Toolkit.getDefaultToolkit().getScreenSize();
		
		Dimension dFrame = new Dimension(width, height);
		
		int x = (int) ((dScreen.getWidth() - width)/4);
		
		int y = (int) ((dScreen.getHeight() - height)/4);
				
		setSize(dFrame);
		
		setLocation(x, y);
		
		this.initEditorSettings();

		this.pack();

	}

	/**
	 * @return the pTools
	 */
	public JTextTools getpTools() {
		return pTools;
	}

	/**
	 * @return the taEditor
	 */
	public JEditorTextArea getTaEditor() {
		return taEditor;
	}



	/**
	 * @param taEditor the taEditor to set
	 */
	public void setTaEditor(JEditorTextArea taEditor) {
		this.taEditor = taEditor;
	}



	/**
	 * @return the tabbedPane
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	/**
	 * Functions <code>initEditorSettings</code> set all necessary components 
	 * for <b>JEditor</b>
	 * 
	 */
	private void initEditorSettings() {

		JEditorUtils.setEditorLooks();

		taEditor = new JEditorTextArea(JEditorUtils.getDefaultFont(),
				JEditorConstance.TEXT_COLOR);

		pStatus = new JStatusPanel();

		pTools = new JTextTools();

		pTextArea = new JScrollPane(taEditor);

		tabbedPane = new JTabbedPane();

		pStatus.setBorder(BorderFactory.createTitledBorder("Info"));

		pStatus.setLabelText(taEditor.getFont().getFamily(), 
				String.valueOf(taEditor.getFont().getStyle()),
				String.valueOf(taEditor.getFont().getSize()), 
				JEditorUtils.colorText(taEditor));

		tabbedPane.addTab("Untitled.txt", pTextArea);

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				if(e.getSource() instanceof JTabbedPane) {

					JTabbedPane tbp = (JTabbedPane) e.getSource();

					if(tbp.getSelectedIndex() != -1) {

						JScrollPane sPane = (JScrollPane) tbp.getSelectedComponent();

						JViewport viewport = sPane.getViewport();

						JEditorTextArea area = (JEditorTextArea) viewport.getView();

						pTools.getCbSelectFont().setSelectedItem(area.getFont().getFamily());

						pTools.getTfSizeChange().setText(String.valueOf(area.getFont().getSize()));

						pTools.getbTextColor().setForeground(area.getForeground());

						pStatus.setLabelText(area.getFont().getFamily(), 
								String.valueOf(area.getFont().getStyle()),
								String.valueOf(area.getFont().getSize()), 
								JEditorUtils.colorText(area));

					}

				}

			}

		});

		pTools.setLayout(new BoxLayout(pTools, BoxLayout.LINE_AXIS));

		pStatus.setLayout(new BoxLayout(pStatus, BoxLayout.LINE_AXIS));

		jEditorMenu = new JEditorMenu();

		setLayout(new BorderLayout());

		setJMenuBar(jEditorMenu);

		add(BorderLayout.PAGE_START, pTools);

		add(BorderLayout.CENTER, tabbedPane);

		add(BorderLayout.PAGE_END, pStatus);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		


	}

}
