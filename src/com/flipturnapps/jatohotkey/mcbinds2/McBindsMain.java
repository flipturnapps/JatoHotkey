package com.flipturnapps.jatohotkey.mcbinds2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import com.flipturnapps.jatohotkey.lib.ActionRunner;
import com.flipturnapps.jatohotkey.lib.KeyListener;
import com.flipturnapps.jatohotkey.lib.MouseListener;
import com.flipturnapps.kevinLibrary.helper.FileHelper;
import com.flipturnapps.kevinLibrary.helper.FlushWriter;

public class McBindsMain {

	public static void main(String[] args) 
	{
		// Clear previous logging configurations.
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);

		KeyListener kListener = new KeyListener();
		MouseListener mListener = new MouseListener();
		try {
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(kListener);
			GlobalScreen.addNativeMouseListener(mListener);
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommandOutput fileOutput = null;
		try {
			File dir = new File(FileHelper.getAppDataDir("flipturnapps", "jatohotkey-mcbinds"));
			dir.mkdirs();
			File file = new File(FileHelper.fileInDir(dir,"commands.out"));
			file.createNewFile();
			fileOutput = new CommandOutput(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionRunner runner = new ActionRunner();
		
		for(int i = 0; i < 10; i++)
		{
			WarpAction wAct = new WarpAction(kListener, mListener, i, fileOutput);
			SetWarpAction swAct = new SetWarpAction(kListener, mListener, i, fileOutput);
			runner.getActions().add(swAct);
			runner.getActions().add(wAct);
		}
		
		runner.startRunning();
		
	}

}
