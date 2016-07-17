import java.util.ArrayList;

import org.jnativehook.keyboard.NativeKeyEvent;

public class MouseButton
{
	
	private int code;
	//private String name;
	private boolean down;
	/*
	public static MouseButton constructMB(String givenName, MouseListener list)
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
		return constructMB(testId,list);
	}
	*/
	public static MouseButton constructMB(int givenCode, MouseListener list) 
	{
		ArrayList<MouseButton> keys = list.getRegisteredButtons();
		if(keys == null)
			keys = new ArrayList<MouseButton>();
		for(int i = 0; i < keys.size(); i++)
		{
			if(keys.get(i).code == givenCode)
			{
				return keys.get(i);
			}
		}
		MouseButton newKey = new MouseButton(givenCode);
		keys.add(newKey);
		list.regenIdList();
		return newKey;
	}
	private MouseButton (int id)
	{
		//name = NativeKeyEvent.getKeyText(id);
		code = id;
	}
	
	public int getCode() 
	{
		return code;
	}
/*
	public String getName() 
	{
		return name;
	}
*/
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
		return "MB [code=" + code +  ", down=" + down + "]";
	}	
	
}
