package com.flipturnapps.jatohotkey;
import java.util.ArrayList;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyListener implements NativeKeyListener 
{
	private ArrayList<Key> registeredKeys = new ArrayList<Key>();
	private int[] registeredCodes;
	private boolean locked;

	
	public void nativeKeyPressed(NativeKeyEvent ev)
	{
		int keyCode = ev.getKeyCode();
		if(!shouldCheckEvent(keyCode))
		{
			return;
			
		}
		
		for (int i = 0; i < registeredCodes.length; i++) 
		{
			if(keyCode == registeredCodes[i])
			{
				registeredKeys.get(i).setDown(true);
			}
		}
	}

	private boolean shouldCheckEvent(int code)
	{
		
		if(!locked && code >= registeredCodes[0] && code <= registeredCodes[registeredCodes.length -1])
		{
			
			return true;
		}
		return false;
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent ev) 
	{
		int keyCode = ev.getKeyCode();
		if(!shouldCheckEvent(keyCode))
		{
			return;
		}
		
		for (int i = 0; i < registeredCodes.length; i++) 
		{
			if(keyCode == registeredCodes[i])
			{
				registeredKeys.get(i).setDown(false);
			}
		}

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent ev) 
	{
		
	}

	public ArrayList<Key> getRegisteredKeys() 
	{
		return registeredKeys;
	}

	public void regenIdList() 
	{
		locked = true;
		registeredCodes = new int[registeredKeys.size()];		
		ArrayList<Key> keysCopy = new ArrayList<Key>(registeredKeys);
		registeredKeys.clear();
		
		int idsCount = 0;
		while(!keysCopy.isEmpty())
		{
			int lowestIdSoFar = Integer.MAX_VALUE;
			int index = 0;
			for(int i = 0; i < keysCopy.size(); i++)
			{
				if(keysCopy.get(i).getCode() < lowestIdSoFar)
				{
					lowestIdSoFar = keysCopy.get(i).getCode();
					index = i;
				}
			}
			registeredKeys.add(keysCopy.get(index));
			registeredCodes[idsCount] = keysCopy.get(index).getCode();
			keysCopy.remove(index);
			idsCount++;
		}
		
		locked = false;
	}

}
