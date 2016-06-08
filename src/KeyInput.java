
public class KeyInput implements Input 
{
	private Key key;
	public KeyInput(Key givenKey)
	{
		this.key = givenKey;
	}

	public boolean isDown() 
	{
		return key.isDown();
	}

}
