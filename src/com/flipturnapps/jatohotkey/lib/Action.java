package com.flipturnapps.jatohotkey.lib;

public abstract class Action 
{
	private boolean ranAction;
	
	
	public void spotlight()
	{
		if(getTest().isPassing() && !ranAction)
		{
			ranAction = true;
			runAction();
			return;
		}
		if(!getTest().isPassing())
			ranAction = false;
	}
	protected abstract Test getTest();
	protected abstract void runAction();
}
