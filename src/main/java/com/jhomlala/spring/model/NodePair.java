package com.jhomlala.spring.model;

public class NodePair 
{
	int from;
	int to;
	
	public NodePair() {};
	/**
	 * @param from
	 * @param to
	 */
	public NodePair(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	
}
