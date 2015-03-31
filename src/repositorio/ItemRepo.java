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

	/**
	 * Add a new Item
	 * 
	 * @param item Item instance of Item
	 * @return boolean
	 */
	public boolean addItem( Item item )
	{
		return itemArrayList.add( item );
	}

	/**
	 * Get a item by the index
	 * 
	 * @param index int index of the ArrayList
	 * @return
	 */
    public Item getItem( int index )
    {
        return itemArrayList.get( index );
    }
    
    /**
     * Get a list of itens
     * 
     * @return String
     */
    public String getItens()
    {
    	for( Item item: itemArrayList )
    	{
    		item.toString();
    	}
    	
    	return "";
    }
}
