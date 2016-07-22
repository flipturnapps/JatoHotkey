package com.flipturnapps.jatohotkey.lib;

public abstract class Action 
{
	private boolean ranAction;
	private KeyListener keyListener;
	private MouseListener mouseListener;
	
	public Action (KeyListener kl, MouseListener ml)
	{
		this.setKeyListener(kl);
		this.setMouseListener(ml);
	}
	
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
	public KeyListener getKeyListener() {
		return keyListener;
	}
	private void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}
	public MouseListener getMouseListener() {
		return mouseListener;
	}
	private void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}
}
