/**
 * 
 */
package com.jeditor.main.gui.utils.menu.actions;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.text.JTextComponent;

import com.jeditor.main.JTextEditor;
import com.jeditor.main.gui.utils.JEditorTextArea;
import com.jeditor.main.gui.utils.JTextNew;
import com.jeditor.main.gui.utils.menu.JEditorMenu;
import com.jeditor.main.gui.utils.menu.JEditorPopMenu;
import com.jeditor.main.utils.JEditorConstance;
import com.jeditor.main.utils.JEditorUtils;

/**
 * @author Hristo
 *
 */
public class MenuEngine implements ActionListener {

	private JEditorMenu editorMenu;

	private JEditorPopMenu editorPopMenu;

	private JFrame fMain;

	private JTabbedPane taPane;

	/**
	 * Constructor
	 * 
	 * @param
	 */
	public MenuEngine(JEditorMenu menu) {

		this.editorMenu = menu;

	}

	/**
	 * 
	 */
	public MenuEngine(JEditorPopMenu menu) {

		this.editorPopMenu = menu;

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JMenuItem menuItem = (JMenuItem) e.getSource();

		JFileChooser fileChooser = new JFileChooser();

		taPane = JTextEditor.getjEditorGui().getTabbedPane();

		int iTab = 0;
		
		JTextComponent textComp;
		
		JScrollPane sPane;

		JViewport viewport;

		if(taPane.getSelectedIndex() != -1) {

			sPane = (JScrollPane) taPane.getSelectedComponent();

			viewport = sPane.getViewport();
			
			textComp = (JTextComponent) viewport.getView();

		}else {

			sPane = null;

			viewport = null;
			
			textComp = null;

		}

		JTextComponent comp;

		int retValue;

		Font font = new Font(JEditorConstance.FONT_FAMILY, JEditorConstance.FONT_STYLE, JEditorConstance.FONT_SIZE);

		JEditorTextArea textArea = new JEditorTextArea(font, JEditorConstance.TEXT_COLOR);

		JScrollPane scrollPane = new JScrollPane(textArea);

		String itemText = menuItem.getActionCommand();

		switch (itemText) {

		case "New":

			fMain = JTextEditor.getjEditorGui();

			JTextNew textNew = new JTextNew(fMain);

			textNew.setVisible(true);

			break;

		case "Open":

			retValue = fileChooser.showOpenDialog(fMain);

			if(retValue == JFileChooser.APPROVE_OPTION) {

				File file = fileChooser.getSelectedFile();

				taPane.addTab(file.getName(), scrollPane);

				iTab = taPane.indexOfComponent(scrollPane);

				taPane.setSelectedIndex(iTab);

				taPane.getComponentAt(iTab).requestFocus();

				JTextEditor.getjEditorGui().getpTools()
				.getCbSelectFont().setSelectedItem(JEditorConstance.FONT_FAMILY);

				JTextEditor.getjEditorGui().getpTools()
				.getTfSizeChange().setText(String.valueOf(JEditorConstance.FONT_SIZE));

				JTextEditor.getjEditorGui().getpTools()
				.getbTextColor().setForeground(JEditorConstance.TEXT_COLOR);

				retValue = 0;

				JEditorUtils.readFile(file, textArea, fMain); 


			}

			break;

		case "Save":

			fileChooser.setSelectedFile(new File(taPane.getTitleAt(taPane.getSelectedIndex())));

			if(fileChooser.getSelectedFile().exists() && fileChooser.getSelectedFile().isFile()) {


				if(viewport.getView() instanceof JEditorTextArea) {

					comp = (JEditorTextArea) viewport.getView();

					JEditorUtils.writeFile(fileChooser.getSelectedFile(), comp, fMain);

				}else if(viewport.getView() instanceof JTextPane){

					comp = (JTextPane) viewport.getView();

				}
				
			}else {

				retValue = fileChooser.showSaveDialog(fMain);

				if (retValue == JFileChooser.APPROVE_OPTION) {

					File file = fileChooser.getSelectedFile();

					if(viewport.getView() instanceof JEditorTextArea) {

						comp = (JEditorTextArea) viewport.getView();

						JEditorUtils.writeFile(file, comp, fMain);

						taPane.setTitleAt(taPane.getSelectedIndex(), fileChooser.getSelectedFile().getName());

					}else if(viewport.getView() instanceof JTextPane){

						comp = (JTextPane) viewport.getView();

					}

				}

			}

			break;

		case "Save as":

			fileChooser.setDialogTitle("Save as");

			retValue = fileChooser.showSaveDialog(fMain);

			File file = fileChooser.getSelectedFile();

			if (retValue == JFileChooser.APPROVE_OPTION) {


				if(viewport.getView() instanceof JEditorTextArea) {

					comp = (JEditorTextArea) viewport.getView();

					JEditorUtils.writeFile(file, comp, fMain);

					taPane.setTitleAt(taPane.getSelectedIndex(), fileChooser.getSelectedFile().getName());

				}else if(viewport.getView() instanceof JTextPane){

					comp = (JTextPane) viewport.getView();

				}

			}

			break;

		case "Exit":

			System.exit(0);

			break;

		case "Cut":
						
			JEditorUtils.cutCopyPaste(textComp, itemText);
						
			break;

		case "Copy":
			
			JEditorUtils.cutCopyPaste(textComp, itemText);
			
			break;

		case "Paste":
			
			JEditorUtils.cutCopyPaste(textComp, itemText);
			
			break;

		case "Edit text":

			break;

		case "Select All":

			comp = (JTextComponent) viewport.getView();

			comp.selectAll();

			break;

		case "Clear All" :

			comp = (JTextComponent) viewport.getView();

			comp.setText("");

			break;

		case "Close" :

			if(taPane.getSelectedIndex() != -1) {

				taPane.remove(taPane.getSelectedIndex());

			}else {

				JOptionPane.showMessageDialog(fMain, "All Tabs are clossed!");

			}

			break;

		case "Close All":

			if(taPane.getSelectedIndex() != -1) {

				taPane.removeAll();

			}else {

				JOptionPane.showMessageDialog(fMain, "All Tabs are clossed!");

			}

			break;

		case "About JTextEditor":

			JPanel pInfo = new JPanel();

			BoxLayout layout = new BoxLayout(pInfo, BoxLayout.PAGE_AXIS);

			pInfo.setLayout(layout);

			String[] sData = {

					"Author",

					"Rights",

					"Year",

					"Version"
			};

			String[] sInfo = {

					"Hristo Hristov", 

					"All rights reserved.",

					"2022", 

			"1.0"}; 

			JLabel[] lInfo = new JLabel[sInfo.length];

			JLabel[] lData = new JLabel[sData.length];

			Font fLabel = new Font(JEditorConstance.FONT_FAMILY, 
					JEditorConstance.FONT_STYLE, 
					JEditorConstance.FONT_SIZE);

			for (int i = 0; i < sInfo.length; i++) {

				lInfo[i] = new JLabel(sInfo[i]);

				lInfo[i].setFont(fLabel);

			}

			for (int i = 0; i < sData.length; i++) {

				lData[i] = new JLabel(sData[i]);

				lData[i].setFont(fLabel);

			}

			for(int i = 0; i <sInfo.length && i < sData.length; i++) {

				pInfo.add(lData[i]);

				pInfo.add(lInfo[i]);

			}

			GridLayout gr = new GridLayout(sInfo.length, 2);

			pInfo.setLayout(gr);

			Object[] array = {"J TEXT EDITOR", pInfo};

			JOptionPane.showMessageDialog(fMain, 
					array, 
					"About JTextEditor", 
					JOptionPane.INFORMATION_MESSAGE);

			break;

		}

	}



}
