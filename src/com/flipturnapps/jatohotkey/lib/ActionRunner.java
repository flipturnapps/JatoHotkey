package com.flipturnapps.jatohotkey.lib;
import java.util.ArrayList;

public class ActionRunner implements Runnable
{
	private ArrayList<Action> actions;
	
	public ActionRunner()
	{
		setActions(new ArrayList<Action>());
	}
	private void setActions(ArrayList<Action> arrayList) 
	{
		actions = arrayList;
		
	}
	@Override
	public void run() 
	{
		while(true)
		{
			for(int i = 0; i < this.getActions().size(); i++)
			{
				actions.get(i).spotlight();
			}
			
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Thread startRunning()
	{
		Thread thread = new Thread(this);
		thread.start();
		return thread;
	}
	public ArrayList<Action> getActions()
	{
		return actions;
	}
	

}
