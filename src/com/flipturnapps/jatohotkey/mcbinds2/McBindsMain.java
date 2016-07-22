package com.flipturnapps.jatohotkey.mcbinds2;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import com.flipturnapps.jatohotkey.lib.KeyListener;
import com.flipturnapps.jatohotkey.lib.MouseListener;

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

	}

}
