import java.util.ArrayList;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;

public class Event extends Hook
{
	private ArrayList<Input> inputs = new ArrayList<Input>();
	private boolean didTrigger;

	public Event(ArrayList<Input> inputs) 
	{
		super();
		this.inputs = inputs;
	}
	public Event()
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
	
	public boolean isTriggered()
	{
		if(this.getInputs().isEmpty())
			return false;
		for(int i = 0; i < this.getInputs().size(); i++)
		{
			if(!(this.getInputs().get(i).isDown()))
				return false;
		}
		return true;
	}
	public boolean shouldTriggerAction()
	{
		boolean triggered = isTriggered();
		if((!(didTrigger)) && triggered)
		{
			didTrigger = true;
			return true;
		}
		if(!triggered)
		{
			didTrigger = false;
		}
		return false;
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
	@Override
	public String toString() {
		return "Event [inputs=" + inputs + ", didTrigger=" + didTrigger + ", isTriggered()=" + isTriggered()
				+ ", shouldTriggerAction()=" + shouldTriggerAction() + "]";
	}
}
