
public class KeyInput extends Input 
{
	public KeyInput(int id)
	{
		super(id);

	}
	public KeyInput(int id, String name) 
	{
		super(id,name);
	}

	@Override
	public String getTypeName() 
	{
		return this.getClass().getName();
	}

	@Override
	public boolean isKey()
	{
		return true;
	}

	@Override
	public boolean isMouse() 
	{
		return false;
	}

}
