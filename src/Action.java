
public abstract class Action 
{
	private Test test;
	private boolean ranAction;
	
	
	public void spotlight()
	{
		if(test.isPassing() && !ranAction)
		{
			ranAction = true;
			runAction();
			return;
		}
		if(!test.isPassing())
			ranAction = false;
	}
	protected void runAction()
	{
		
	}
}
