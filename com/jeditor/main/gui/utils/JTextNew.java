/**
 * 
 */
package com.jeditor.main.gui.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jeditor.main.JTextEditor;
import com.jeditor.main.gui.utils.menu.actions.TextNewEngine;
import com.jeditor.main.utils.JEditorConstance;
import com.jeditor.main.utils.JEditorUtils;

/**
 * <code>JTextNew</code> creates Dialog for creating new text file with selected
 * 
 * font from user.
 * 
 * 
 * @author Hristo
 * 
 * @version 1.0
 *
 */

///FIXME If there is no selection, gives problem and new textarea is not active; 
@SuppressWarnings("serial")
public class JTextNew extends JDialog implements ChangeListener, ActionListener, ItemListener,PropertyChangeListener{

	private JOptionPane optionPane;

	private String btnStringOk = "OK";

	private String btnStringCancel = "Cancel";

	JTextField tfSize;

	JTextField tfFileName;

	JColorChooser colorChooser;

	JComboBox<String> cbSelectFamily;

	JComboBox<String> cbFileType;

	JCheckBox cBoxBold;

	JCheckBox cBoxItalic;

	JCheckBox cBoxUnderLine;

	JLabel lSimpleText;

	Color colorTetxt = JEditorConstance.TEXT_COLOR;

	String sFamily = JEditorConstance.FONT_FAMILY;

	int iStyle = JEditorConstance.FONT_SIZE;

	int iTextSize = JEditorConstance.FONT_SIZE;

	String sFName = "Untitled";

	String sFType = JEditorConstance.TXT;

	JScrollPane spTextArea;

	JEditorTextArea taEditorNew;

	JTextTools textTools;

	/**
	 * 
	 * @param aFrame
	 */

	public JTextNew(Frame aFrame) {

		super(aFrame, true);

		this.initTextNew();

	}

	/**
	 * 
	 */
	public JTextNew(JTextTools tt) {

		this.textTools = tt;

	}

	private void initTextNew() {

		TextNewEngine engine = new TextNewEngine(this);

		JPanel pFile = new JPanel();

		JPanel pFont = new JPanel();

		JPanel pCom = new JPanel();

		JLabel lFileName = new JLabel("File name: ");

		JLabel lFileType = new JLabel("File type: ");

		JLabel lSelectFontStyle = new JLabel("Select style");

		JLabel lSelectFontFamily = new JLabel("Select Family");

		JLabel lSelectSize = new JLabel("Select text size");

		lSimpleText = new JLabel();

		JLabel lBold = new JLabel("B");

		JLabel lItalic = new JLabel("I");

		JLabel lUnderLine = new JLabel("U");

		tfSize = new JTextField(String.valueOf(JEditorConstance.FONT_SIZE), 4);

		tfFileName = new JTextField("Untitled", 20);

		colorChooser = new JColorChooser(JEditorConstance.TEXT_COLOR);

		String[] stFileTypes = {JEditorConstance.TXT, JEditorConstance.RTF};

		cbSelectFamily = new JComboBox<String>(JEditorUtils.FontsName());

		cbFileType = new JComboBox<String>(stFileTypes);

		cBoxBold = new JCheckBox();

		cBoxItalic = new JCheckBox();

		cBoxUnderLine = new JCheckBox();

		JButton btnInc = new JButton("+");

		JButton btnDec = new JButton("-");

		lSimpleText.setSize(650, 95);

		pFile.setFont(JEditorUtils.getDefaultFont());

		colorChooser.setBorder(BorderFactory.createTitledBorder("Choose color"));

		pFile.setBorder(BorderFactory.createTitledBorder("New File"));

		pFont.setBorder(BorderFactory.createTitledBorder("Font select"));

		lSimpleText.setBorder(BorderFactory.createTitledBorder("Example"));

		tfSize.setEditable(false);

		GroupLayout gLayoutFile = new GroupLayout(pFile);

		GroupLayout gLayoutFont = new GroupLayout(pFont);

		GridLayout gridLayout = new GridLayout(1, 2, 20, 20); 

		pFile.setLayout(gLayoutFile);

		pFont.setLayout(gLayoutFont);

		pCom.setLayout(gridLayout);

		gLayoutFile.setAutoCreateGaps(true);

		gLayoutFont.setAutoCreateGaps(true);

		gLayoutFile.setAutoCreateContainerGaps(true);

		gLayoutFont.setAutoCreateContainerGaps(true);

		GroupLayout.SequentialGroup hGroupFile = gLayoutFile.createSequentialGroup();

		GroupLayout.SequentialGroup vGroupFile = gLayoutFile.createSequentialGroup();

		GroupLayout.SequentialGroup hGroupFont = gLayoutFont.createSequentialGroup();

		GroupLayout.SequentialGroup vGroupFont = gLayoutFont.createSequentialGroup();

		hGroupFile.addGroup(gLayoutFile.createParallelGroup().
				addComponent(lFileName).
				addComponent(lFileType));

		hGroupFile.addGroup(gLayoutFile.createParallelGroup().
				addComponent(tfFileName).
				addComponent(cbFileType, 
						GroupLayout.DEFAULT_SIZE, 
						GroupLayout.DEFAULT_SIZE, 
						Short.SIZE));

		gLayoutFile.setHorizontalGroup(hGroupFile);

		vGroupFile.addGroup(gLayoutFile.createParallelGroup(Alignment.BASELINE).
				addComponent(lFileName).
				addComponent(tfFileName));

		vGroupFile.addGroup(gLayoutFile.createParallelGroup(Alignment.BASELINE).
				addComponent(lFileType).
				addComponent(cbFileType));

		gLayoutFile.setVerticalGroup(vGroupFile);

		hGroupFont.addGroup(gLayoutFont.createParallelGroup(Alignment.LEADING).
				addComponent(lSelectFontFamily, 
						GroupLayout.DEFAULT_SIZE, 
						GroupLayout.DEFAULT_SIZE, 
						Short.SIZE).
				addComponent(lSelectFontStyle, 
						GroupLayout.DEFAULT_SIZE, 
						GroupLayout.DEFAULT_SIZE, 
						Short.SIZE).
				addComponent(lSelectSize, 
						GroupLayout.DEFAULT_SIZE, 
						GroupLayout.DEFAULT_SIZE, 
						Short.SIZE));

		hGroupFont.addGroup(gLayoutFont.createParallelGroup().
				addComponent(cbSelectFamily, 
						GroupLayout.DEFAULT_SIZE, 
						GroupLayout.DEFAULT_SIZE, 
						Short.SIZE).
				addGroup(gLayoutFont.createSequentialGroup().
						addComponent(lBold).
						addComponent(cBoxBold).
						addComponent(lItalic).
						addComponent(cBoxItalic).
						addComponent(lUnderLine).
						addComponent(cBoxUnderLine)).
				addGroup(gLayoutFont.createSequentialGroup().
						addComponent(btnInc).
						addComponent(tfSize).
						addComponent(btnDec)));

		vGroupFont.addGroup(gLayoutFont.createParallelGroup(Alignment.BASELINE)
				.addComponent(lSelectFontFamily).addComponent(cbSelectFamily));

		vGroupFont.addGroup(gLayoutFont.createParallelGroup(Alignment.BASELINE).
				addComponent(lSelectFontStyle).
				addComponent(lBold).
				addComponent(cBoxBold).
				addComponent(lItalic).
				addComponent(cBoxItalic).
				addComponent(lUnderLine).
				addComponent(cBoxUnderLine));

		vGroupFont.addGroup(gLayoutFont.createParallelGroup(Alignment.BASELINE).
				addComponent(lSelectSize).
				addComponent(btnInc).
				addComponent(tfSize).
				addComponent(btnDec));

		gLayoutFont.setHorizontalGroup(hGroupFont);

		gLayoutFont.setVerticalGroup(vGroupFont);

		pFile.add(lFileName);

		pFile.add(tfFileName);

		pFile.add(lFileType);

		pFile.add(cbFileType);

		pFont.add(lSelectFontFamily);

		pFont.add(cbSelectFamily);

		pFont.add(lSelectFontStyle);

		pFont.add(lBold);

		pFont.add(cBoxBold);

		pFont.add(lItalic);

		pFont.add(cBoxItalic);

		pFont.add(lUnderLine);

		pFont.add(cBoxUnderLine);

		pFont.add(lSelectSize);

		pFont.add(btnInc);

		pFont.add(tfSize);

		pFont.add(btnDec);

		pCom.add(pFile);

		pCom.add(pFont);
		
		cbSelectFamily.setSelectedItem(JEditorConstance.FONT_FAMILY);
		
		lSimpleText.setText("qwertyuiopasdfghjklzxcvbnm 1234567890");

		lSimpleText.setFont(new Font(JEditorConstance.FONT_FAMILY,
				JEditorConstance.FONT_STYLE,
				JEditorConstance.FONT_SIZE));

		lSimpleText.setForeground(JEditorConstance.TEXT_COLOR);

		Object[] array = {pCom, colorChooser, lSimpleText};

		Object[] options = {btnStringOk, btnStringCancel};

		setTitle("New File");		

		optionPane = new JOptionPane(array, 
				JOptionPane.PLAIN_MESSAGE,
				JOptionPane.YES_NO_OPTION,
				null,
				options,
				options[0]);

		setContentPane(optionPane);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		pack();

		optionPane.addPropertyChangeListener(engine);

		colorChooser.getSelectionModel().addChangeListener(this);

		btnInc.addActionListener(this);

		btnDec.addActionListener(this);

		cbSelectFamily.addActionListener(this);

		cbFileType.addActionListener(this);

		cBoxBold.addItemListener(this);

		cBoxItalic.addItemListener(this);

		cBoxUnderLine.addItemListener(this);

		optionPane.addPropertyChangeListener(this);

	}

	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(ChangeEvent e) {

		Color labelColor = colorChooser.getColor();

		lSimpleText.setForeground(labelColor);

		colorTetxt = labelColor;

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		Object eventSource = e.getSource();

		if(eventSource instanceof JButton) {

			JButton clickedButton = (JButton) e.getSource();

			int iSize = Integer.parseInt(tfSize.getText());

			iSize = JEditorUtils.changeFontSize(iSize, clickedButton.getText(), optionPane);

			tfSize.setText(String.valueOf(iSize));

			lSimpleText.setFont(new Font(lSimpleText.getFont().getFamily(), 
					lSimpleText.getFont().getStyle(), 
					iSize));

			iTextSize = iSize;

		}else if(eventSource instanceof JComboBox<?>) {

			if (eventSource.equals(cbSelectFamily)) {

				cbSelectFamily = (JComboBox<String>)e.getSource();

				lSimpleText.setFont(new Font(cbSelectFamily.getSelectedItem().toString(), 
						lSimpleText.getFont().getStyle(),
						lSimpleText.getFont().getSize()));

				sFamily = cbSelectFamily.getSelectedItem().toString();

			}else if (eventSource.equals(cbFileType)) {

				cbFileType = (JComboBox<String>)e.getSource();

				sFType = cbFileType.getSelectedItem().toString();

			}

		}

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {

		Object source = e.getItemSelectable();

		int style = lSimpleText.getFont().getStyle();

		if(source == cBoxBold) {

			if(style == Font.PLAIN) {

				lSimpleText.setFont(new Font(lSimpleText.getFont().getFamily(),
						Font.BOLD, 
						lSimpleText.getFont().getSize()));
			}else if(style == Font.ITALIC) {

				lSimpleText.setFont(new Font(lSimpleText.getFont().getFamily(),
						style + Font.BOLD, 
						lSimpleText.getFont().getSize()));

			}else if(style == (Font.BOLD + Font.ITALIC) || style == Font.BOLD) {

				lSimpleText.setFont(new Font(lSimpleText.getFont().getFamily(),
						style, 
						lSimpleText.getFont().getSize()));

			}

		}else if(source == cBoxItalic) {

			if(style == Font.PLAIN) {

				lSimpleText.setFont(new Font(lSimpleText.getFont().getFamily(),
						Font.ITALIC, 
						lSimpleText.getFont().getSize()));
			}else if(style == Font.BOLD) {

				lSimpleText.setFont(new Font(lSimpleText.getFont().getFamily(),
						style + Font.ITALIC, 
						lSimpleText.getFont().getSize()));

			}else if(style == (Font.BOLD + Font.ITALIC) || style == Font.ITALIC) {

				lSimpleText.setFont(new Font(lSimpleText.getFont().getFamily(),
						style, 
						lSimpleText.getFont().getSize()));

			}

		}else if(source == cBoxUnderLine) {



		}

		if (e.getStateChange() == ItemEvent.DESELECTED) {

			if(e.getItem().equals(cBoxBold)) {

				lSimpleText.setFont(new Font(lSimpleText.getFont().getFamily(),
						style - Font.BOLD, 
						lSimpleText.getFont().getSize()));


			}else if(e.getItem().equals(cBoxItalic)) {

				lSimpleText.setFont(new Font(lSimpleText.getFont().getFamily(),
						style - Font.ITALIC, 
						lSimpleText.getFont().getSize()));

			}else if(e.getItem().equals(cBoxUnderLine)) {



			}

		}

		iStyle = style;

	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		String prop = evt.getPropertyName();

		if(isVisible() 
				&& evt.getSource() == optionPane
				&& (JOptionPane.VALUE_PROPERTY.equals(prop) 
						||JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {

			Object value = optionPane.getValue();

			if(value == JOptionPane.UNINITIALIZED_VALUE) {

				return;

			}

			optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

			if(btnStringOk.equals(value)) {
				
				int iTab = 0;
								
				sFName = tfFileName.getText();

				Font font = new Font(sFamily, iStyle, iTextSize);

				taEditorNew = new JEditorTextArea(font, colorTetxt);

				spTextArea = new JScrollPane(taEditorNew);

				JTextEditor.getjEditorGui().getTabbedPane().add(sFName + "." + sFType, spTextArea);
				
				iTab = JTextEditor.getjEditorGui().getTabbedPane().indexOfComponent(spTextArea);
				
				JTextEditor.getjEditorGui().getTabbedPane().setSelectedIndex(iTab);
				
				JTextEditor.getjEditorGui().getTabbedPane().getComponentAt(iTab).requestFocus();
				
				JTextEditor.getjEditorGui().getpTools().getCbSelectFont().setSelectedItem(sFamily);

				JTextEditor.getjEditorGui().getpTools().getTfSizeChange().setText(String.valueOf(iTextSize));

				JTextEditor.getjEditorGui().getpTools().getbTextColor().setForeground(colorTetxt);

				setVisible(false);

			}else {

				setVisible(false);

			}

		}


	}

}
