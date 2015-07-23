import java.util.ArrayList;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;

public class EventGenHook extends Hook
{
	private ArrayList<Input> inputs;
	private ArrayList<Event> events;
	private InputKeeperHook ikh;
	public EventGenHook()
	{
		inputs = new ArrayList<Input>();
		events = new ArrayList<Event>();
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e)
	{
		if(e.getKeyCode() != e.VC_ENTER)
		{
			Input input = new KeyInput(e.getKeyCode());
			inputs.add(input);
			System.out.println("added keyinput " + input);
		}
		else
		{
			if(!inputs.isEmpty())
			{
				if(ikh == null)
					ikh = new InputKeeperHook();
				Event event = new Event(ikh);
				for(int i = 0; i <inputs.size(); i++)
				{
					Input input = inputs.get(i);
					event.addTo(input);
					
				}
				events.add(event);
				inputs.clear();
				System.out.println("Added event " + event);
			}
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) 
	{
		inputs.clear();
		System.out.println("cleared");
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent e) 
	{
		Input input = new MouseInput(e.getButton());
		inputs.add(input);
		System.out.println("added mouseinput " + input);
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent e) 
	{
		inputs.clear();	
		System.out.println("cleared");
	}

	public ArrayList<Input> getInputs() { return inputs; }
	public void setInputs(ArrayList<Input> inputs) { this.inputs = inputs; }

	public ArrayList<Event> getEvents() { return events; }
	public void setEvents(ArrayList<Event> events) { this.events = events; }	
}
