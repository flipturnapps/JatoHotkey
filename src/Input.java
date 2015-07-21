
public abstract class Input 
{
	private boolean down;
	private int id;
	private String name;
	public Input(int id) 
	{
		this.id = id;
		this.name = "id"+id;
	}
	public Input(int id, String name) 
	{
		this.id = id;
		this.setName(name);
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}	
	public abstract String getTypeName();
	public abstract boolean isKey();
	public abstract boolean isMouse();
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) 
	{
		this.down = down;
	}
	public void modifyDown(int compId, boolean setTo)
	{
		if(id == compId)
			this.setDown(setTo);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Input [down=" + down + ", id=" + id + ", name=" + name + "]";
	}
	
}
