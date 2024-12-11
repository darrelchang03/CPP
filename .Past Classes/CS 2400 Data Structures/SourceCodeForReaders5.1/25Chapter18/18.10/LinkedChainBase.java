/**
   An abstract base class for use in implementing the ADT list
   by using a chain of nodes. All methods are implemented, but
   since the class is abstract, no instances can be created.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @author Charles Hoot
   @version 5.0
*/
public abstract class LinkedChainBase<T>
{
	private Node firstNode; // Reference to first node
	private int  numberOfEntries;

	public LinkedChainBase()
	{
		initializeDataFields();
	} // end default constructor

/* < Implementations of the public methods clear, getLength, isEmpty, and toArray go here. >
   . . .
   
   < Implementations of the protected, final methods getFirstNode, addFirstNode,
     addAfterNode, removeFirstNode, removeAfterNode, getNodeAt, and
     initializeDataFields go here. >
   . . . */

	protected final class Node
	{
		private T data;     // Entry in list
		private Node next;  // Link to next node

		protected Node(T dataPortion)
		{
			data = dataPortion;
			next = null;	
		} // end constructor

		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor

/*    < Implementations of the protected methods getData, setData, and getNextNode go here. >
      . . .
      
      < Implementation of the private method setNextNode goes here. >
      . . . */
	} // end Node
} // end LinkedChainBase



