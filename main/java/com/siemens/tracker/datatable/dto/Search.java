package com.siemens.tracker.datatable.dto;

/**
 * The Class Search.
 */
public class Search {
	
	/** The value. */
	private String value;
    
    /** The regex. */
    private boolean regex;
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Checks if is regex.
	 *
	 * @return true, if is regex
	 */
	public boolean isRegex() {
		return regex;
	}
	
	/**
	 * Sets the regex.
	 *
	 * @param regex the new regex
	 */
	public void setRegex(boolean regex) {
		this.regex = regex;
	}
    
}
