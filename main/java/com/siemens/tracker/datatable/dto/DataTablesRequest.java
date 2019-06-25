package com.siemens.tracker.datatable.dto;

import java.util.List;

/**
 * The Class DataTablesRequest.
 */
public class DataTablesRequest {
	
	/** The draw. */
	private int draw;
    
    /** The start. */
    private int start;
    
    /** The length. */
    private int length;

    /** The search. */
    private Search search;

    /** The order. */
    private List<Order> order;

    /** The columns. */
    private List<Column> columns;

	/**
	 * Gets the draw.
	 *
	 * @return the draw
	 */
	public int getDraw() {
		return draw;
	}

	/**
	 * Sets the draw.
	 *
	 * @param draw the new draw
	 */
	public void setDraw(int draw) {
		this.draw = draw;
	}

	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Sets the start.
	 *
	 * @param start the new start
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Sets the length.
	 *
	 * @param length the new length
	 */
	public void setLength(int length) {
		this.length = length;
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

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public List<Order> getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(List<Order> order) {
		this.order = order;
	}

	/**
	 * Gets the columns.
	 *
	 * @return the columns
	 */
	public List<Column> getColumns() {
		return columns;
	}

	/**
	 * Sets the columns.
	 *
	 * @param columns the new columns
	 */
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
    
}
