package com.flipturnapps.jatohotkey.mcbinds2.running;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;

import com.flipturnapps.kevinLibrary.helper.FileHelper;
import com.flipturnapps.kevinLibrary.net.KClient;

public class Spammer extends KClient implements Runnable
{
	private File commandFile;
	public Spammer(String ip, int port) throws UnknownHostException, IOException
	{
		super(ip, port);
		File dir = new File(FileHelper.getAppDataDir("flipturnapps", "jatohotkey-mcbinds"));
		dir.mkdirs();
		File file = new File(FileHelper.fileInDir(dir,"commands.out"));
		if(!file.exists())
		file.createNewFile();
		this.commandFile = file;
		start();
		
	}

	public void start() 
	{
		new Thread(this).start();
	}

	@Override
	protected void disconnectedFromServer() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void readMessage(String read) {
		// TODO Auto-generated method stub

	}
	@Override
	public void run() 
	{
		long time = System.currentTimeMillis();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(commandFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true)
		{
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(System.currentTimeMillis() - time > 5000 && line != null)
			{
				System.out.println(line);
				this.sendMessage(line);
			}
			else
			{
				System.out.println("blocked");
			}
			
		}		
	}

}
