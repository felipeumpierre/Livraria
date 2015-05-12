package list;

public class DoublyLinked<T>
{
	public static class Node<T>
	{
		private T element;
		private Node<T> before;
		private Node<T> after;
		
		public Node( T element, Node<T> before, Node<T> after )
		{
			this.element = element;
			this.before = before;
			this.after = after;
		}
	}
	
	private Node<T> first, last;
	
	public int size()
	{
		Node<T> node = this.first;
		int total = 0;
		
		while( node != null )
		{
			node = node.after;
			total++;
		}
		
		return total;
	}
	
	public void add( T element )
	{
		if( size() == 0 )
		{
			this.first = new Node( element, null, null );
		}
		else
		{
			
		}
	}
}
