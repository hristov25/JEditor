package com.jeditor.main.utils;

import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;

import com.jeditor.main.gui.utils.JEditorTextArea;

/**
 * {@code JEditorUtils} contains all common functions for JTextEditor;
 * 
 * @author Hristo
 * 
 * @version 1.0
 * 
 */

public abstract class JEditorUtils {

	private static Font fFontEditor;

	/**
	 * 
	 * Function <code>setEditorLooks</code> set default Look and Feel for editor.
	 * 
	 * Default System Look And Fell is based on system properties.
	 * 
	 * @exception ClassNotFoundException 
	 * 
	 * @exception InstantiationException 
	 * 
	 * @exception IllegalAccessException 
	 * 
	 * @exception  UnsupportedLookAndFeelException
	 * 
	 */

	public static void setEditorLooks() {

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {

			e.printStackTrace();

		}

	}

	/**
	 * Create font for Jeditor
	 * 
	 * @param iStyle
	 * @return fEditor
	 */

	public static Font setFont( JComponent comp, int iStyle) {

		JEditorUtils.fFontEditor = new Font(comp.getFont().getFamily(), iStyle, comp.getFont().getSize());

		return fFontEditor;

	}

	public static Font setDefaultFont(int iStyle) {

		JEditorUtils.fFontEditor = new Font(JEditorConstance.FONT_FAMILY, iStyle, JEditorConstance.FONT_SIZE);

		return fFontEditor;

	}
	
	public static Font getDefaultFont() {
		
		return new Font(JEditorConstance.FONT_FAMILY,
				JEditorConstance.FONT_STYLE,
				JEditorConstance.FONT_SIZE);
		
	}

	public static Font setFontAndSize( JComponent comp, int iStyle, int iSize) {

		JEditorUtils.fFontEditor = new Font(comp.getFont().getFamily(), iStyle, iSize);

		return fFontEditor;

	}

	/**
	 * Change font size if it is not negative, else show error message
	 * and set Font to default value;
	 * 
	 * @param size
	 * @param sign
	 * @param cont
	 * @return iSize
	 */

	public static int changeFontSize(int size, String sign, Container cont) {

		int iSize = size;

		switch (sign) {

		case "+":

			if(iSize > (JEditorConstance.MAX_SIZE_TEXT - 1)) {

				JOptionPane.showMessageDialog(cont, 
						"Font maximum size is " + JEditorConstance.MAX_SIZE_TEXT, 
						"Error mesage", 
						JOptionPane.ERROR_MESSAGE);

				iSize = JEditorConstance.MAX_SIZE_TEXT;

			}else {

				iSize++;

			}

			break;

		case "-":

			if(iSize < (JEditorConstance.MIN_SIZE_TEXT + 1)) {

				JOptionPane.showMessageDialog(cont, 
						"Font minimum size is " + JEditorConstance.MIN_SIZE_TEXT, 
						"Error mesage", 
						JOptionPane.ERROR_MESSAGE);

				iSize = JEditorConstance.MIN_SIZE_TEXT;

			}else {

				iSize--;

			}

			break;

		}

		return iSize;

	}
	
	/**
	 * 
	 * @return sFonts String[]
	 */
	
	public static String[] FontsName() {

		Font[] fLocalFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();


		String[] sFonts = new String[fLocalFonts.length];

		for (int i = 0; i <fLocalFonts.length; i++) {

			sFonts[i] = fLocalFonts[i].getName();

		}

		return sFonts;

	}
	
	public static void underlineText(JTextComponent comp) {
		
		comp.setText(comp.getText());
		
	}

	public static void readFile(File f, JTextComponent comp, JFrame fr) {
		
		Path p = Paths.get(f.getPath());
				
		try(BufferedReader reader = Files.newBufferedReader(p)){
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				if (comp instanceof JTextArea) {
															
					((JTextArea) comp).append(line + "\n");
					
					
				}else if(comp instanceof JTextPane) {
					
					
					
				}
				
			}
			
			
		}catch (IOException e) {
			
			JOptionPane.showMessageDialog(fr, "Couldn't read selected file!", "Error message", JOptionPane.ERROR_MESSAGE);
			
		}

	}

	public static void writeFile(File f, JTextComponent comp, JFrame fr) {
		
		Path p = Paths.get(f.getPath());
				
		String s;
		
		byte[] data;
		
		if(comp instanceof JEditorTextArea) {
			
			s = comp.getText();
						
			data = s.getBytes();
			
			try(OutputStream out = new BufferedOutputStream(
					Files.newOutputStream(p,StandardOpenOption.CREATE, StandardOpenOption.APPEND))){
								
				out.write(data, 0, data.length);
				
			}catch (IOException e) {
				
				JOptionPane.showMessageDialog(fr, "Error during writing a file.", "Error message", JOptionPane.ERROR_MESSAGE);
				
			}
			
			
		}else if(comp instanceof JTextPane) {
			
			
			
		}
		
	}
	
	public static String colorText(JTextComponent comp) {
		
		String sColorRGB;
		
		int ired = comp.getForeground().getRed();
		
		int igreen = comp.getForeground().getGreen();
		
		int iblue = comp.getForeground().getBlue();
		
		sColorRGB = "RGB" + "(" + ired + " , " + igreen + " , " + iblue + ")";
		
		return sColorRGB;
		
	} 

}
