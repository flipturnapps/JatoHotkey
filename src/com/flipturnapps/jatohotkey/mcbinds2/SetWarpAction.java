package com.flipturnapps.jatohotkey.mcbinds2;

import com.flipturnapps.jatohotkey.lib.AndTest;
import com.flipturnapps.jatohotkey.lib.BasicTest;
import com.flipturnapps.jatohotkey.lib.Key;
import com.flipturnapps.jatohotkey.lib.KeyInput;
import com.flipturnapps.jatohotkey.lib.KeyListener;
import com.flipturnapps.jatohotkey.lib.MouseListener;
import com.flipturnapps.jatohotkey.lib.OrTest;
import com.flipturnapps.jatohotkey.lib.Test;

public class SetWarpAction extends McAction
{
	private int num;
	private AndTest finalTest;
	
	public SetWarpAction(KeyListener kl, MouseListener ml, int num, CommandOutput output) 
	{
		super(kl, ml, output);
		this.num = num;
	}
	
	@Override
	protected Test getTest() 
	{
		if(finalTest== null)
		{
		Key numKey = Key.constructKey(num+"", this.getKeyListener());
		KeyInput numKeyInput = new KeyInput(numKey);
		BasicTest numKeyTest = new BasicTest(numKeyInput);
		
		BasicTest lc = new BasicTest(new KeyInput(Key.constructKey("Left Control", this.getKeyListener())));
		BasicTest rc = new BasicTest(new KeyInput(Key.constructKey("Right Control", this.getKeyListener())));

		OrTest controlTest = new OrTest(lc,rc);
		
		
		
		BasicTest ralt = new BasicTest(new KeyInput(Key.constructKey("Left Alt", this.getKeyListener())));
		BasicTest lalt = new BasicTest(new KeyInput(Key.constructKey("Right Alt", this.getKeyListener())));
		OrTest alts = new OrTest(ralt,lalt);
		
		AndTest ctrl_and_alt = new AndTest(controlTest,alts);
		
		finalTest = new AndTest(ctrl_and_alt,numKeyTest);
		
		}
		
		return finalTest;
	}

	@Override
	protected void runAction() 
	{
		this.getOutput().runAsKevlar("setwarp ktemp" + num);
	}

}
