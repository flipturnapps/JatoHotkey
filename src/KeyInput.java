import org.jnativehook.keyboard.NativeKeyEvent;

public class KeyInput extends Input 
{
	public KeyInput(int id) 
	{ 
		super(id); 
	}

	@Override
	public String getTypeName() { return this.getClass().getName(); }

	@Override
	public boolean isKey() { return true; }

	@Override
	public boolean isMouse() { return false; }

	@Override
	public String getAsParsableString() 
	{
		return NativeKeyEvent.getKeyText(this.getId()).toLowerCase()
				.replace("left ", "").replace("right ", "");
	}
}
