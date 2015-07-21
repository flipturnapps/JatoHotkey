
public abstract class Input 
{
	private boolean down;
	private int id;
	public Input(int id) 
	{
		this.id = id;
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
	
	public abstract String getAsParsableString();	
	
	@Override
	public String toString() {
		return "Input [down=" + down + ", id=" + id + "]";
	}
	public boolean equals(Object o)
	{
		if(!(o instanceof Input))
			return false;
		Input input = (Input) o;
		if(input.getId() != this.getId())
			return false;
		if(input.isKey() != this.isKey())
			return false;
		if(input.isMouse() != this.isMouse())
			return false;
		return true;
	}

}
