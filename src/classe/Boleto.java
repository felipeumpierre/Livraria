package classe;

public class Boleto implements Pagamento
{
	private boolean available = false;
	
	public boolean isAvailable()
	{
		return this.available;
	}
}