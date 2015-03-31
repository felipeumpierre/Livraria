package classe;

public class Cartao implements Pagamento
{
	private boolean available = true;
	
	public boolean isAvailable()
	{
		return this.available;
	}
}
