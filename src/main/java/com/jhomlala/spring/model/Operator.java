package com.jhomlala.spring.model;

public class Operator 
{
	private int id;
	private String operatorName;
	private String operatorDescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getOperatorDescription() {
		return operatorDescription;
	}
	public void setOperatorDescription(String operatorDescription) {
		this.operatorDescription = operatorDescription;
	}
	/**
	 * @param id
	 * @param operatorName
	 * @param operatorDescription
	 */
	public Operator(int id, String operatorName, String operatorDescription) {
		super();
		this.id = id;
		this.operatorName = operatorName;
		this.operatorDescription = operatorDescription;
	}
	
	
}
