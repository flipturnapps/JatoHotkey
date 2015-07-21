
public class Input 
{
	private int id;
	private InputType type;
	public Input(InputType type, int id) {
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InputType getType() {
		return type;
	}
	public void setType(InputType type) {
		this.type = type;
	}
	
}
