package com.automation.CustomisedExceptions;

public class FrameworkExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FrameworkExceptions()
	{
		super();
	}
	
	public FrameworkExceptions(String ExceptionMSg)
	{
		super(ExceptionMSg);
	}

}
