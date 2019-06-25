package com.siemens.tracker.datatable.dto;


/**
 * The Class Column.
 */
public class Column {
	
	/** The data. */
	private String data;
    
    /** The name. */
    private String name;
    
    /** The searchable. */
    private boolean searchable;
    
    /** The orderable. */
    private boolean orderable;
    
    /** The search. */
    private Search search;
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Checks if is searchable.
	 *
	 * @return true, if is searchable
	 */
	public boolean isSearchable() {
		return searchable;
	}
	
	/**
	 * Sets the searchable.
	 *
	 * @param searchable the new searchable
	 */
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}
	
	/**
	 * Checks if is orderable.
	 *
	 * @return true, if is orderable
	 */
	public boolean isOrderable() {
		return orderable;
	}
	
	/**
	 * Sets the orderable.
	 *
	 * @param orderable the new orderable
	 */
	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}
	
	/**
	 * Gets the search.
	 *
	 * @return the search
	 */
	public Search getSearch() {
		return search;
	}
	
	/**
	 * Sets the search.
	 *
	 * @param search the new search
	 */
	public void setSearch(Search search) {
		this.search = search;
	}
    
    
}
