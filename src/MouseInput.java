
public class MouseInput extends Input 
{
	public MouseInput(int id)
	{
		super(id);

	}
	public MouseInput(int id, String name) 
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
		return false;
	}

	@Override
	public boolean isMouse() 
	{
		return true;
	}

}
