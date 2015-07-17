
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.SwingUtilities;

// Imports.
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;
public class Hook implements NativeKeyListener, NativeMouseListener
{
	private Script script;
	private HashMap<Input, Boolean> iStates = new HashMap<Input,Boolean>();
	public Hook(Script script) 
	{
		this.script = script;
		try {
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(this);
			GlobalScreen.addNativeMouseListener(this);
		} catch (NativeHookException e) 
		{
			System.out.println("Couldn't register hook!");
		}
	}
	/*
	private void writeString(String s) 
	{
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (Character.isUpperCase(c)) {
				robot.keyPress(KeyEvent.VK_SHIFT);
			}
			robot.keyPress(Character.toUpperCase(c));
			robot.keyRelease(Character.toUpperCase(c));

			if (Character.isUpperCase(c)) {
				robot.keyRelease(KeyEvent.VK_SHIFT);
			}
		}
	}
	 */
	public void exit() 
	{
		try {
			GlobalScreen.unregisterNativeHook();
		}
		catch (NativeHookException ex) {
			ex.printStackTrace();
		}
		System.runFinalization();
		System.exit(0);
	}
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new Hook(new TestScript());
			}
		});
	}	
	public void nativeKeyPressed(NativeKeyEvent e)
	{
		System.out.println(e.getKeyText(e.getKeyCode()));
		Input input = new Input(InputType.KEY, e.getKeyCode());
		if(script.caresAboutInput(input))
		{
			iStates.put(input, true);
		}
	}	
	public void nativeKeyReleased(NativeKeyEvent e) 
	{
		Input input = new Input(InputType.KEY, e.getKeyCode());
		if(script.caresAboutInput(input))
		{
			iStates.put(input, false);
		}
	}
	@Override
	public void nativeMouseClicked(NativeMouseEvent e) 
	{
	

	}
	@Override
	public void nativeMousePressed(NativeMouseEvent e)
	{
		System.out.println(e.getButton());
		Input input = new Input(InputType.MOUSECLICK, e.getButton());
		if(script.caresAboutInput(input))
		{
			iStates.put(input, true);
		}
	}
	@Override
	public void nativeMouseReleased(NativeMouseEvent e) 
	{
		Input input = new Input(InputType.MOUSECLICK, e.getButton());
		if(script.caresAboutInput(input))
		{
			iStates.put(input, false);
		}
	}



	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub

	}
}
