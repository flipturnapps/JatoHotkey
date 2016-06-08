import java.util.ArrayList;

import org.jnativehook.keyboard.NativeKeyEvent;

public class Key
{
	
	private int code;
	private String name;
	private boolean down;
	
	public static Key constructKey(String givenName, KeyListener list)
	{
		int testId = 0;
		String name = null;
		while(name == null && testId < 10000)
		{
			testId++;
			String testName = NativeKeyEvent.getKeyText(testId);
			if(givenName.toLowerCase().equals(testName.toLowerCase()))
				name = testName;
		}
		if(name==null)
		{
			System.out.println("Key init failed for " + givenName );
			return null;
		}
		return constructKey(testId,list);
	}
	
	private static Key constructKey(int givenCode, KeyListener list) 
	{
		ArrayList<Key> keys = list.getRegisteredKeys();
		if(keys == null)
			keys = new ArrayList<Key>();
		for(int i = 0; i < keys.size(); i++)
		{
			if(keys.get(i).code == givenCode)
			{
				return keys.get(i);
			}
		}
		Key newKey = new Key(givenCode);
		keys.add(newKey);
		list.regenIdList();
		return newKey;
	}
	private Key (int id)
	{
		name = NativeKeyEvent.getKeyText(id);
		code = id;
	}
	
	public int getCode() 
	{
		return code;
	}

	public String getName() 
	{
		return name;
	}

	public void setDown(boolean b) 
	{
		down = b;		
	}

	public boolean isDown() 
	{
		return down;
	}

	@Override
	public String toString() {
		return "Key [code=" + code + ", name=" + name + ", down=" + down + "]";
	}	
	
}
