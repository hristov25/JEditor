/**
 * 
 */
package com.jeditor.main.gui.utils.menu.actions;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JViewport;

import com.jeditor.main.JTextEditor;
import com.jeditor.main.gui.utils.JEditorTextArea;
import com.jeditor.main.gui.utils.JTextColor;
import com.jeditor.main.gui.utils.JTextTools;
import com.jeditor.main.utils.JEditorUtils;

/**
 * {@code ButtonsActions} implements actions logic of buttons from
 * JTextEditor
 * 
 * @author Hrtisto
 * 
 * @version 1.0
 *
 */
public class ButtonsEngine implements ActionListener{

	private JFrame fMain;

	private JTextField tfSize;

	private JEditorTextArea taEdit;

	private JComboBox<String> cbFontFamily;

	private JTextTools textTools;

	private JTextColor colorSelect;
	
	private JScrollPane sPane;

	public ButtonsEngine(JTextTools tt) {

		this.textTools = tt;

	}


	/**
	 * {@code actionPerformed}
	 * 
	 * @param e {@code e} is from type {@link ActionEvent};
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		Object eventSource = e.getSource();
		
		sPane = (JScrollPane) JTextEditor.getjEditorGui().getTabbedPane().getSelectedComponent();
		
		JViewport view = sPane.getViewport();
		
		if(view.getView() instanceof JEditorTextArea) {
			
			taEdit = (JEditorTextArea) view.getView();
			
		}else if(view.getView() instanceof JTextPane) {
			
			
		}
		
		int style = taEdit.getFont().getStyle();

		if(eventSource instanceof JButton) {

			JButton clickedButton =  (JButton) e.getSource();

			int size;

			fMain = JTextEditor.getjEditorGui();

			tfSize = JTextEditor.getjEditorGui().getpTools().getTfSizeChange(); 

			tfSize.setText(String.valueOf(taEdit.getFont().getSize()));

			int sizeFont = Integer.parseInt(tfSize.getText());

			switch(clickedButton.getText()) {

			case "+" :

				size = JEditorUtils.changeFontSize(sizeFont, clickedButton.getText(), fMain);

				tfSize.setText(String.valueOf(size));

				taEdit.setFont(new Font(taEdit.getFont().getFamily(), taEdit.getFont().getStyle(), size));

				break;

			case "-" :

				size = JEditorUtils.changeFontSize(sizeFont, clickedButton.getText(), fMain);

				tfSize.setText(String.valueOf(size));

				taEdit.setFont(new Font(taEdit.getFont().getFamily(), taEdit.getFont().getStyle(), size));

				break;

			case "B" :

				if(style == Font.PLAIN) {

					taEdit.setFont(new Font(taEdit.getFont().getFamily(),
							Font.BOLD, 
							taEdit.getFont().getSize()));

				}else if(style == Font.ITALIC) {

					taEdit.setFont(new Font(taEdit.getFont().getFamily(),
							style + Font.BOLD, 
							taEdit.getFont().getSize()));

				}else if(style == (Font.BOLD + Font.ITALIC) || style == Font.BOLD) {

					taEdit.setFont(new Font(taEdit.getFont().getFamily(),
							style, 
							taEdit.getFont().getSize()));

				}

				break;

			case "I":

				if(style == Font.PLAIN) {

					taEdit.setFont(new Font(taEdit.getFont().getFamily(),
							Font.ITALIC, 
							taEdit.getFont().getSize()));
				}else if(style == Font.BOLD) {

					taEdit.setFont(new Font(taEdit.getFont().getFamily(),
							style + Font.ITALIC, 
							taEdit.getFont().getSize()));

				}else if(style == (Font.BOLD + Font.ITALIC) || style == Font.ITALIC) {

					taEdit.setFont(new Font(taEdit.getFont().getFamily(),
							style, 
							taEdit.getFont().getSize()));

				}

				break;
				
			case "U" :
				
				JEditorUtils.underlineText(taEdit);
				
				break;

			case "Color Select" :

				colorSelect = new JTextColor(fMain, taEdit);

				colorSelect.setVisible(true);

				Color newColor = colorSelect.getCcTextColor().getColor();

				taEdit.setForeground(newColor);

				clickedButton.setForeground(newColor);

				clickedButton.setBackground(taEdit.getBackground()); 

				break;

			}

		}else if(eventSource instanceof JComboBox<?>) {

			cbFontFamily = (JComboBox<String>) e.getSource();

			taEdit.setFont(new Font(cbFontFamily.getSelectedItem().toString(), taEdit.getFont().getStyle(), taEdit.getFont().getSize()));

		}

	}
}
