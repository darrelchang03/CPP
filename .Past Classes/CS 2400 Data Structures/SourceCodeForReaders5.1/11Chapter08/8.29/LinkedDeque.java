/**
   A class that implements the a deque of objects by using 
   a chain of doubly linked nodes.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class LinkedDeque<T> implements DequeInterface<T>
{
   private DLNode firstNode; // References node at front of deque
   private DLNode lastNode;  // References node at back of deque
	
	public LinkedDeque()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor
  
//  < Implementations of the deque operations go here. >
//  . . .
  
   private class DLNode
   {
		private T      data;  	 // Deque entry
		private DLNode next;  	 // Link to next node
		private DLNode previous; // Link to previous node
    
//    < Constructors and the methods getData, setData, getNextNode, setNextNode, 
//      getPreviousNode, and setPreviousNode are here. >
//    . . .
    
  } // end DLNode
} // end LinkedDeque
