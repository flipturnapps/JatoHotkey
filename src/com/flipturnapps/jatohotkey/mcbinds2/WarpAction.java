package com.flipturnapps.jatohotkey.mcbinds2;

import com.flipturnapps.jatohotkey.lib.Action;
import com.flipturnapps.jatohotkey.lib.AndTest;
import com.flipturnapps.jatohotkey.lib.BasicTest;
import com.flipturnapps.jatohotkey.lib.Key;
import com.flipturnapps.jatohotkey.lib.KeyInput;
import com.flipturnapps.jatohotkey.lib.KeyListener;
import com.flipturnapps.jatohotkey.lib.MouseListener;
import com.flipturnapps.jatohotkey.lib.OrTest;
import com.flipturnapps.jatohotkey.lib.Test;
import com.flipturnapps.kevinLibrary.helper.FlushWriter;

public class WarpAction extends McAction
{
	private int num;
	
	public WarpAction(KeyListener kl, MouseListener ml, int num, CommandOutput output) 
	{
		super(kl, ml, output);
		this.num = num;
	}
	
	@Override
	protected Test getTest() 
	{
		Key numKey = Key.constructKey(num+"", this.getKeyListener());
		KeyInput numKeyInput = new KeyInput(numKey);
		BasicTest numKeyTest = new BasicTest(numKeyInput);
		
		BasicTest lc = new BasicTest(new KeyInput(Key.constructKey("Left Control", this.getKeyListener())));
		BasicTest rc = new BasicTest(new KeyInput(Key.constructKey("Right Control", this.getKeyListener())));

		OrTest controlTest = new OrTest(lc,rc);
		
		AndTest finalTest = new AndTest(controlTest,numKeyTest);
		return finalTest;
	}

	@Override
	protected void runAction() 
	{
		this.getOutput().runAsKevlar("warp ktemp" + num);
	}

}
