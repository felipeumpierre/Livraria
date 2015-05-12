package list;

public class Node<T>
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
