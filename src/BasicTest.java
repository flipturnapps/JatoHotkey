
public class BasicTest implements Test
{
	private Input input;
	public BasicTest(Input givenInput)
	{
		input = givenInput;
	}
	@Override
	public boolean isPassing() 
	{
		return input.isDown();
	}

}
