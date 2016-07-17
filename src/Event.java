
public class Event 
{
	private Test condition;
	private Action action;
	public Event(AndTest combined, ChromeAction action2) {
		// TODO Auto-generated constructor stub
	}
	public void testAndDo()
	{
		if(condition.isPassing())
			action.doAction();
	}
	public Test getCondition() {
		return condition;
	}
	public void setCondition(Test condition) {
		this.condition = condition;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	
}
