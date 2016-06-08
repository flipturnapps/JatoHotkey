import java.awt.AWTException;
import java.awt.Robot;

public class ChromeAction implements Action
{
	private Robot robot;
	public ChromeAction ()
	{
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
