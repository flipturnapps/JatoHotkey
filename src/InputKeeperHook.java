import java.util.ArrayList;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;

public class InputKeeperHook extends Hook
{
	private ArrayList<Input> inputs = new ArrayList<Input>();

	public InputKeeperHook(ArrayList<Input> inputs) 
	{
		super();
		this.inputs = inputs;
	}
	public InputKeeperHook()
	{
		super();
		inputs = new ArrayList<Input>();
	}
	public ArrayList<Input> getInputs() 
	{
		return inputs;
	}
	public void setInputs(ArrayList<Input> inputs) 
	{
		this.inputs = inputs;
	}
	public void runModifications(int id, boolean isKey, boolean isMouse, boolean setTo)
	{
		for(int i = 0; i < this.getInputs().size(); i++)
		{
			Input input = this.getInputs().get(i);
			if((input.isKey() && isKey) || (input.isMouse() && isMouse))
				input.modifyDown(id, setTo);
		}
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e)
	{
		this.runModifications(e.getID(), true, false, true);
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) 
	{
		this.runModifications(e.getID(), true, false, false);
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent e) 
	{
		this.runModifications(e.getButton(), false, true, true);
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent e) 
	{
		this.runModifications(e.getButton(), false, true, false);
	}

	public Input addTo(Input input)
	{
		for(int i = 0; i < this.getInputs().size(); i++)
		{
			if(this.getInputs().get(i).equals(input))
				return this.getInputs().get(i);			
		}
		this.getInputs().add(input);
		return input;
	}
}
