
public class MouseInput implements Input 
{
	private MouseButton button;
	public MouseInput(MouseButton givenButton)
	{
		this.button = givenButton;
	}

	public boolean isDown() 
	{
		return button.isDown();
	}

}
