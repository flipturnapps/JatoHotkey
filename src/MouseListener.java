import java.util.ArrayList;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class MouseListener implements NativeMouseListener 
{
	private ArrayList<MouseButton> registeredButtons = new ArrayList<MouseButton>();
	private int[] registeredCodes;
	private boolean locked;
	
	private boolean shouldCheckEvent(int code)
	{
		
		if(!locked && code >= registeredCodes[0] && code <= registeredCodes[registeredCodes.length -1])
		{
			
			return true;
		}
		return false;
	}


	public ArrayList<MouseButton> getRegisteredButtons() 
	{
		return registeredButtons;
	}

	public void regenIdList() 
	{
		locked = true;
		registeredCodes = new int[registeredButtons.size()];		
		ArrayList<MouseButton> buttonsCopy = new ArrayList<MouseButton>(registeredButtons);
		registeredButtons.clear();
		
		int idsCount = 0;
		while(!buttonsCopy.isEmpty())
		{
			int lowestIdSoFar = Integer.MAX_VALUE;
			int index = 0;
			for(int i = 0; i < buttonsCopy.size(); i++)
			{
				if(buttonsCopy.get(i).getCode() < lowestIdSoFar)
				{
					lowestIdSoFar = buttonsCopy.get(i).getCode();
					index = i;
				}
			}
			registeredButtons.add(buttonsCopy.get(index));
			registeredCodes[idsCount] = buttonsCopy.get(index).getCode();
			buttonsCopy.remove(index);
			idsCount++;
		}
		
		locked = false;
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent ev) 
	{
		
		
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent ev)
	{
		int buttonCode = ev.getButton();
		if(!shouldCheckEvent(buttonCode))
		{
			return;
			
		}
		
		for (int i = 0; i < registeredCodes.length; i++) 
		{
			if(buttonCode == registeredCodes[i])
			{
				registeredButtons.get(i).setDown(true);
			}
		}
		
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent ev) 
	{
		int buttonCode = ev.getButton();
		if(!shouldCheckEvent(buttonCode))
		{
			return;
			
		}
		
		for (int i = 0; i < registeredCodes.length; i++) 
		{
			if(buttonCode == registeredCodes[i])
			{
				registeredButtons.get(i).setDown(false);
			}
		}
	}

}
