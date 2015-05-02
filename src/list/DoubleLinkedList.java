package list;

public class DoubleLinkedList<T>
{
	private static class DLNode<E> 
	{
		private E elem;
	    private DLNode<E> next;
	    private DLNode<E> prev;
	
	    public DLNode( E elem, DLNode<E> next, DLNode<E> prev )
	    {
	    	this.elem = elem;
	    	this.next = next;
	    	this.prev = prev;
	    }
  	}

	private DLNode<T> first, last;

	public DoubleLinkedList()
	{
		this.first = null;
		this.last = null;
	}

	public boolean isEmpty()
	{
		return this.first == null && this.last == null;
	}

	public int listSize()
	{
		DLNode<T> node = this.first;
		int result = 0;

		while( node != null ) 
		{
			node = node.next;
			result++;
		}
		
		return result;
	}
	
	public T first()
	{
		return this.first.elem;
	}

	public T last()
	{
		return this.last.elem;
	}

	private void verifySize( int size, int position ) throws DoubleLinkedListException 
	{
		if( size <= position || position < 0 )
		{
			throw new DoubleLinkedListException( "Requested position is not in the list." );
		}
	}

	// Positions from 0 to (size-1)
	private DLNode<T> getNodeAtPosition( int position ) throws DoubleLinkedListException
	{
	    verifySize( this.listSize(), position );
	    DLNode<T> result = this.first;
	    
	    for( int counter = 0; counter < position; counter++ )
	    {
	    	result = result.next;
	    }
	    
	    return result;
	}
	
	public DLNode<T> getElements() throws DoubleLinkedListException 
	{
		return this.first;
	}

	public T getElementAtPosition( int position ) throws DoubleLinkedListException 
	{
		return this.getNodeAtPosition( position ).elem;
	}

	public void setElementAtPosition( int position, T element ) throws DoubleLinkedListException
	{
		this.getNodeAtPosition( position ).elem = element;
	}

	private void insertElementAtEmpty( T element )
	{
	    DLNode<T> newNode = new DLNode<T>( element, null, null );
	    this.first = newNode;
	    this.last = newNode;
	}

	public void insertElementBeforePosition( T element, int position ) throws DoubleLinkedListException
	{
	    if( this.listSize() == 0 )
	    {
    		insertElementAtEmpty( element );
	    } 
	    else
	    {
	    	verifySize( this.listSize(), position );
	    	
	    	DLNode<T> newNode = new DLNode<T>( element, null, null );
	    	DLNode<T> nodePosition = this.first;
	    	
	    	for( int counter = 0; counter < position; counter++ )
	    	{
	    		nodePosition = nodePosition.next;
	    	}
	    	
	    	if( position == 0 )
	    	{
	    		this.first = newNode;
	    		newNode.next = nodePosition;
	    		nodePosition.prev = newNode;
	    	}
	    	else
	    	{
	    		newNode.prev = nodePosition.prev;
	    		newNode.next = nodePosition;
	    		nodePosition.prev.next = newNode;
	    		nodePosition.prev = newNode;
	    	}
	    }
	}

	public void insertElementAfterPosition( T element, int position ) throws DoubleLinkedListException 
	{
	    if( this.listSize() == 0 )
	    {
	    	insertElementAtEmpty( element );
	    }
	    else
	    {
	    	verifySize( this.listSize(), position );
	    	
	    	DLNode<T> newNode = new DLNode<T>( element, null, null );
	    	DLNode<T> nodePosition = this.first;
	    	
	    	for( int counter = 0; counter < position; counter++)
	    	{
	    		nodePosition = nodePosition.next;
	    	}
	    	
	    	if( position == this.listSize() - 1 )
	    	{
	    		this.last = newNode;
	    		newNode.prev = nodePosition;
	    		nodePosition.next = newNode;
	    	}
	    	else
	    	{
	    		newNode.next = nodePosition.next;
	    		newNode.prev = nodePosition;
	    		nodePosition.next.prev = newNode;
	    		nodePosition.next = newNode;
	    	}
	    }
	}

	public void insertFirst( T element ) throws DoubleLinkedListException 
	{
		insertElementBeforePosition( element, 0 );
	}

	public void insertLast( T element ) throws DoubleLinkedListException
	{
		insertElementAfterPosition( element, this.listSize() - 1 );
	}

	public void deleteFirst()
	{
	    if( this.first == this.last )
	    {
	    	this.first = null;
	    	this.last = null;
	    }
	    else 
	    {
	    	this.first = this.first.next;
	    	this.first.prev = null;
	    }
	}

	public void deleteLast()
	{
	    if( this.first == this.last ) 
	    {
	    	this.first = null;
	    	this.last = null;
	    } 
	    else 
	    {
	    	this.last = this.last.prev;
	    	this.last.next = null;
	    }
	}

	public void deleteElementAtPosition( int position ) throws DoubleLinkedListException
	{
	    verifySize( this.listSize(), position );
	    
	    if( position == 0 ) 
	    {
	    	this.deleteFirst();
	    }
	    else if( position == this.listSize() - 1 )
	    {
	    	this.deleteLast();
	    } 
	    else
	    {
	    	DLNode<T> actualNode = this.first;
	    	
	    	int counter = 0;
	    	
	    	while( counter < position )
	    	{
		        actualNode = actualNode.next;
		        counter++;
	    	}
	    	
	    	actualNode.prev.next = actualNode.next;
	    	actualNode.next.prev = actualNode.prev;
	    	actualNode = null;
	    }
	}

	@Override
	public String toString() 
	{
		String result = "(";
	    DLNode<T> node = this.first;
	    
	    while( node != null )
	    {
	    	result += node.elem.toString();
	    	
	    	if( node.next != null ) 
	    	{
	    		result += ",";
	    	}
	    	
	    	node = node.next;
	    }
	    
	    result += ")";
	    
	    return result;
	}

	public String toStringReverse() 
	{
	    String result = "(";
	    DLNode<T> node = this.last;
	    
	    while( node != null ) 
	    {
	    	result += node.elem.toString();
	    	
	    	if( node.prev != null )
	    	{
	    		result += ",";
	    	}
	    	
	    	node = node.prev;
	    }
	    
	    result += ")";
	    
	    return result;	
    }

	public void showList()
	{
	    System.out.println( this.toString() );
	}
	  
	public void showReverseList()
	{
	    System.out.println( this.toStringReverse() );
	}
}