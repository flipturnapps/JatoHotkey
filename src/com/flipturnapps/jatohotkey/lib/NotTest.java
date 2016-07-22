package com.flipturnapps.jatohotkey.lib;

public class NotTest implements Test
{
	private Test test;
	public NotTest(Test test)
	{
		this.test = test;
	}
	@Override
	public boolean isPassing() 
	{
		return !test.isPassing();
	}

}
