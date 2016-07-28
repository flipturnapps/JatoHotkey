package com.flipturnapps.jatohotkey.mcbinds2.running;

import com.flipturnapps.jatohotkey.lib.Action;
import com.flipturnapps.jatohotkey.lib.KeyListener;
import com.flipturnapps.jatohotkey.lib.MouseListener;
import com.flipturnapps.jatohotkey.lib.Test;
import com.flipturnapps.kevinLibrary.helper.FlushWriter;

public abstract class McAction extends Action 
{

	private CommandOutput output;

	public McAction(KeyListener kl, MouseListener ml, CommandOutput output) 
	{
		super(kl, ml);
		this.setOutput(output);
	}

	public CommandOutput getOutput() {
		return output;
	}

	private void setOutput(CommandOutput output) {
		this.output = output;
	}

}
