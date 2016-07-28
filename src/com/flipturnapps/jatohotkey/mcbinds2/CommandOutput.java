package com.flipturnapps.jatohotkey.mcbinds2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.flipturnapps.kevinLibrary.helper.FlushWriter;

public class CommandOutput extends FlushWriter 
{

	private String username;

	public CommandOutput(File e, String username) throws FileNotFoundException 
	{
		super(e);
		this.setUsername(username);
	}
	
	public void runAsKevlar(String command)
	{
		this.println("run " + getUsername() + " " + command);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
