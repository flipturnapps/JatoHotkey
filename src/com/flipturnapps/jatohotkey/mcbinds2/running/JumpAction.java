package com.flipturnapps.jatohotkey.mcbinds2.running;

import com.flipturnapps.jatohotkey.lib.BasicTest;
import com.flipturnapps.jatohotkey.lib.KeyListener;
import com.flipturnapps.jatohotkey.lib.MouseButton;
import com.flipturnapps.jatohotkey.lib.MouseInput;
import com.flipturnapps.jatohotkey.lib.MouseListener;
import com.flipturnapps.jatohotkey.lib.Test;

public class JumpAction extends McAction {

	private BasicTest test;

	public JumpAction(KeyListener kl, MouseListener ml, CommandOutput output)
	{
		super(kl, ml, output);
	}

	@Override
	protected Test getTest() 
	{
		if(test == null)
		{
		 test = new BasicTest(new MouseInput(MouseButton.constructMB(4, getMouseListener())));
		}
		return test;
	}

	@Override
	protected void runAction() 
	{
		this.getOutput().runAsKevlar("jump");

	}

}
