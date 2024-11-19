package com.hexaware.hotpot.exception;

public class ResourceNotFoundException extends Exception{

	private String resourceName;
	private String feildName;
	private Long feildValue;
	
	
	public ResourceNotFoundException(String resourceName, String feildName, Long feildValue) {
		super(String.format("%s not found with %s : %s",resourceName,feildName,feildValue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
	
}
