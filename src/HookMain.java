import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class HookMain
{
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);		
		EventGenHook hook = new EventGenHook();
		try {
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(hook);
			GlobalScreen.addNativeMouseListener(hook);
		} catch (NativeHookException e) {
			System.out.println("Couldn't register hook!");
		}
		
		long sTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - sTime < 10000)
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-g
				e.printStackTrace();
			}
		System.out.println("events: " + hook.getEvents());
		exit();
	}

	public static void exit() 
	{
		try {
			GlobalScreen.unregisterNativeHook();
		} catch (NativeHookException ex) {
			ex.printStackTrace();
		}
		System.runFinalization();
		System.exit(0);
	}
}
