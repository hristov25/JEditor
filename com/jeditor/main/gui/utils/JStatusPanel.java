/**
 * 
 */
package com.jeditor.main.gui.utils;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Hrtisto
 *
 */
public class JStatusPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel lFamily;

	JLabel lStyle;

	JLabel lSize;
	
	JLabel lColor;
	
	JLabel lCaretPos;

	/**
	 * @return the lFamily
	 */
	public JLabel getlFamily() {
		return lFamily;
	}

	/**
	 * @return the lStyle
	 */
	public JLabel getlStyle() {
		return lStyle;
	}

	/**
	 * @return the lSize
	 */
	public JLabel getlSize() {
		return lSize;
	}

	/**
	 * @return the lColor
	 */
	public JLabel getlColor() {
		return lColor;
	}

	/**
	 * @return the lCaretPos
	 */
	public JLabel getlCaretPos() {
		return lCaretPos;
	}

	/**
	 * 
	 */
	public JStatusPanel() {

		this.initPanel();

	}
	
	private void initPanel() {

		lFamily = new JLabel();

		lStyle = new JLabel();

		lSize = new JLabel();
		
		lColor = new JLabel();
		
		lCaretPos = new JLabel();
				
		add(lFamily);
		
		add(lStyle);
		
		add(lSize);
		
		add(Box.createGlue());
		
		add(lColor);
		
		add(Box.createGlue());
		
		add(lCaretPos);
		
		add(Box.createGlue());

	}
	
	public void setLabelText(String f, String st, String size, String Color) {
		
		lFamily.setText(f);
		
		lStyle.setText(st);
		
		lSize.setText(size);
		
		lColor.setText(Color);
		
	}

}
