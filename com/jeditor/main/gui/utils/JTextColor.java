package com.jeditor.main.gui.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;

import com.jeditor.main.JTextEditor;

public class JTextColor extends JDialog implements ChangeListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JColorChooser ccTextColor;
	
	private JTextComponent componetText;
	
	private JFrame fMain;
	
	private Color defColor;
	
	private Color textColor;
	
	private JButton bOK;
	
	private JButton bCancel;
	
	/**
	 * 
	 */
	public JTextColor(JFrame aFrame, JTextComponent compText) {
		
		super(aFrame, true);
		
		this.componetText = compText;
		
		this.initColorDialog();
		
	}

	/**
	 * @return the ccTextColor
	 */
	public JColorChooser getCcTextColor() {
		return ccTextColor;
	}

	
	private void initColorDialog() {
		
		fMain = JTextEditor.getjEditorGui();
		
		JPanel pColor = new JPanel();
		
		JPanel pButtons = new JPanel();
		
		bOK = new JButton("OK");
		
		bCancel = new JButton("Cancel");
		
		defColor = componetText.getForeground();
		
		ccTextColor = new JColorChooser(componetText.getForeground());
		
		ccTextColor.setBorder(BorderFactory.createTitledBorder("Choose color"));
		
		ccTextColor.getSelectionModel().addChangeListener(this);
		
		bOK.addActionListener(this);
		
		bCancel.addActionListener(this);
		
		pColor.add(ccTextColor);
		
		pColor.setVisible(true);
		
		BorderLayout layout = new BorderLayout(20, 20);
		
		setLayout(layout); 
		
		pButtons.add(bOK);
		
		pButtons.add(bCancel);
		
		add(pButtons, BorderLayout.PAGE_END);
		
		add(pColor, BorderLayout.CENTER);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		setTitle("Select color");
		
		setSize(200, 200); 
		
		pack();
	
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		Color textColor = ccTextColor.getColor();
		
		componetText.setForeground(textColor);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton clickButton = (JButton) e.getSource();
		
		if(clickButton.getText() == "OK") {
			
			componetText.setForeground(textColor);
			
			setVisible(false);
			
		}else if(clickButton.getText() == "Cancel") {
			
			componetText.setForeground(defColor);
			
			setVisible(false);
			
		}
				
	}
	
}
