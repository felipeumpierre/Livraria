package repositorio;

import classe.Item;
import java.util.ArrayList;

public class ItemRepo
{
	private ArrayList<Item> itemArrayList;

	public ItemRepo()
	{
		itemArrayList = new ArrayList<Item>();
	}

	public boolean addItem( Item item )
	{
		return itemArrayList.add( item );
	}

    public Item getItem( int index )
    {
        return itemArrayList.get( index );
    }
    
    public String getItens()
    {
    	for( Item item: itemArrayList )
    	{
    		item.toString();
    	}
    	
    	return "";
    }
}
