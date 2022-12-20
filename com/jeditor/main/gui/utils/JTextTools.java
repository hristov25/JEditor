/**
 * 
 */
package com.jeditor.main.gui.utils;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.jeditor.main.JTextEditor;
import com.jeditor.main.gui.JEditorGui;
import com.jeditor.main.gui.utils.menu.actions.ButtonsEngine;
import com.jeditor.main.utils.JEditorConstance;
import com.jeditor.main.utils.JEditorUtils;


/**
 * @author Hrtisto
 *
 */
public class JTextTools extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame fMain;
	
	private JButton bBoldText;
	
	private JButton bItalicText;
	
	private JButton bUnderlineText;
	
	private JButton bTextColor;
	
	private JComboBox<String> cbSelectFont;
	
	private String[] sFonts;
	
	private JPanel pTextSize;
	
	private JButton bIncSize;
	
	private JButton bDecSize;
	
	private JTextField tfSizeChange;
	
	public JTextTools() {
		
		this.intiPanel();
		
	}
	
	

	/**
	 * @return the cbSelectFont
	 */
	public JComboBox<String> getCbSelectFont() {
		return cbSelectFont;
	}



	/**
	 * @param cbSelectFont the cbSelectFont to set
	 */
	public void setCbSelectFont(JComboBox<String> cbSelectFont) {
		this.cbSelectFont = cbSelectFont;
	}



	/**
	 * @return the tfSizeChange
	 */
	public JTextField getTfSizeChange() {
		return tfSizeChange;
	}



	/**
	 * @param tfSizeChange the tfSizeChange to set
	 */
	public void setTfSizeChange(JTextField tfSizeChange) {
		this.tfSizeChange = tfSizeChange;
	}



	/**
	 * @return the bTextColor
	 */
	public JButton getbTextColor() {
		return bTextColor;
	}



	private void intiPanel() {
		
		ButtonsEngine buttonsEngine = new ButtonsEngine(this);
		
		cbSelectFont = new JComboBox<String>(JEditorUtils.FontsName());
				
		cbSelectFont.setSelectedItem(JEditorConstance.FONT_FAMILY);
		
		bBoldText = new JButton(); 
		
		bItalicText = new JButton();
		
		bUnderlineText = new JButton();
		
		bTextColor = new JButton("Color Select");
				
		cbSelectFont.setSelectedIndex(1);
		
		pTextSize = new JPanel();
		
		bIncSize = new JButton("+");
		
		bDecSize = new JButton("-");
				
		tfSizeChange = new JTextField(String.valueOf(JEditorConstance.FONT_SIZE), 3);
		
		tfSizeChange.setEditable(false);
		
		bBoldText.setContentAreaFilled(false);
		
		bItalicText.setContentAreaFilled(false);
		
		bUnderlineText.setContentAreaFilled(false);
		
		bIncSize.setContentAreaFilled(false);
		
		bDecSize.setContentAreaFilled(false);
		
		bIncSize.addActionListener(buttonsEngine);
		
		bDecSize.addActionListener(buttonsEngine);
		
		bBoldText.addActionListener(buttonsEngine);
		
		bItalicText.addActionListener(buttonsEngine);
		
		bUnderlineText.addActionListener(buttonsEngine);
		
		cbSelectFont.addActionListener(buttonsEngine); 
		
		bTextColor.addActionListener(buttonsEngine);
		
		bBoldText.setText("B");
		
		bItalicText.setText("I");
		
		bUnderlineText.setText("U"); 
		
		bBoldText.setFont(JEditorUtils.setDefaultFont(Font.BOLD)); 
		
		bItalicText.setFont(JEditorUtils.setDefaultFont(Font.ITALIC));
		
		bTextColor.setBackground(JEditorConstance.TEXT_COMP_BACKGROUND);
				
		pTextSize.add(bIncSize);
		
		pTextSize.add(tfSizeChange);
		
		pTextSize.add(bDecSize);
				
		add(Box.createGlue());
		
		add(bBoldText);
		
		add(Box.createGlue());
		
		add(bItalicText);
		
		add(Box.createGlue());
		
		add(bUnderlineText);	
		
		add(Box.createGlue());
		
		add(bTextColor);
		
		add(Box.createGlue());
		
		add(new JSeparator(SwingConstants.VERTICAL));
		
		add(new JLabel("Change size"));

		add(pTextSize);
		
		add(new JSeparator(SwingConstants.VERTICAL));	
				
		add(new JLabel("Select font family"));
		
		add(Box.createGlue());
		
		add(cbSelectFont);
		
		add(Box.createGlue());
		
	}
	
}
