package com.flipturnapps.jatohotkey.mcbinds2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.flipturnapps.kevinLibrary.helper.FlushWriter;

public class CommandOutput extends FlushWriter 
{

	public CommandOutput(File e) throws FileNotFoundException 
	{
		super(e);
	}
	
	public void runAsKevlar(String command)
	{
		this.println("run Kevlar " + command);
	}

}
