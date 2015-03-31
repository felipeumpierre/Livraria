package classe;

public class Boleto extends Pagamento
{
private boolean available = false;
	
	@Override
	public boolean isAvailable()
	{
		return this.available;
	}
}
