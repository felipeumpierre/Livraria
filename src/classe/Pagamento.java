package classe;

public abstract class Pagamento
{
	private boolean available;
	
	public boolean isAvailable()
	{
		return this.available;
	}
	
	public void setAvailable( boolean available )
	{
		this.available = available;
	}
}