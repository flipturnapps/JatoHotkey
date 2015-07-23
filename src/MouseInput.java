
public class MouseInput extends Input 
{
	public MouseInput(int id)
	{ 
		super(id);
	}

	@Override
	public String getTypeName() { return this.getClass().getName(); }

	@Override
	public boolean isKey() { return false; }

	@Override
	public boolean isMouse() { return true; }

	@Override
	public String getAsParsableString() { return "Mouse" + this.getId(); }
}
