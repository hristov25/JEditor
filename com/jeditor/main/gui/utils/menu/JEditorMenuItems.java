/**
 * 
 */
package com.jeditor.main.gui.utils.menu;

/**
 * @author Hristo
 * 
 * @version 1.0
 *
 */
public class JEditorMenuItems {

	private String nameItem;
	
	private String menuBelong;
	
	private boolean isSeparator;
	
	/**
	 * 
	 */
	public JEditorMenuItems(String nameItem, String menu, boolean separator) {
		
		this.nameItem = nameItem;
		
		this.menuBelong = menu;
		
		this.isSeparator = separator;
		
	}

	/**
	 * @return the nameItem
	 */
	public String getNameItem() {
		return nameItem;
	}

	/**
	 * @param nameItem the nameItem to set
	 */
	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	/**
	 * @return the menuBelong
	 */
	public String getMenuBelong() {
		return menuBelong;
	}

	/**
	 * @param menuBelong the menuBelong to set
	 */
	public void setMenuBelong(String menuBelong) {
		this.menuBelong = menuBelong;
	}

	/**
	 * @return the isSeparator
	 */
	public boolean isSeparator() {
		return isSeparator;
	}

	/**
	 * @param isSeparator the isSeparator to set
	 */
	public void setSeparator(boolean isSeparator) {
		this.isSeparator = isSeparator;
	}
	
}
