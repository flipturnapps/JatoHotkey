package com.flipturnapps.jatohotkey.lib;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;


public class TestMain 
{
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
		
		

		//System.out.println(NativeKeyEvent.getKeyText(NativeKeyEvent.VC_CONTROL_L));
	//	System.out.println(NativeKeyEvent.getKeyText(NativeKeyEvent.VC_CONTROL_R));
		//System.out.println(NativeKeyEvent.getKeyText(NativeKeyEvent.ALT_MASK));
		//System.out.println(NativeKeyEvent.getKeyText(NativeKeyEvent.VC_ALT_L));
		//System.out.println(NativeKeyEvent.getKeyText(NativeKeyEvent.VC_ALT_R));
		
		BasicTest lc = new BasicTest(new KeyInput(Key.constructKey("Left Control", kListener)));
		BasicTest rc = new BasicTest(new KeyInput(Key.constructKey("Right Control", kListener)));

		OrTest controls = new OrTest(lc,rc);
		
		BasicTest ralt = new BasicTest(new KeyInput(Key.constructKey("Left Alt", kListener)));
		BasicTest lalt = new BasicTest(new KeyInput(Key.constructKey("Right Alt", kListener)));
		OrTest alts = new OrTest(ralt,lalt);
		
		AndTest ctrl_and_alt = new AndTest(controls,alts);
		
		BasicTest j = new BasicTest(new KeyInput(Key.constructKey("j", kListener)));
		
		AndTest combined = new AndTest(ctrl_and_alt,j);
		
		
		BasicTest mButton = new BasicTest(new MouseInput(MouseButton.constructMB(1, mListener)));
		

		
		while(true)
		{
			if(combined.isPassing())
			{
				System.out.println("true");
				Toolkit.getDefaultToolkit().beep();
			}
			else if(mButton.isPassing())
			{
				System.out.println("mouse");
			}
			else
				System.out.println("false");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

	
