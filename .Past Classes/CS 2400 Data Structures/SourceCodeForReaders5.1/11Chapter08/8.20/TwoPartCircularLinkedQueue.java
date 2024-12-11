/**
   A class that implements the ADT queue by using
   a two-part circular chain of linked nodes.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class TwoPartCircularLinkedQueue<T> implements QueueInterface<T>
{
   private Node queueNode; // References first node in queue
   private Node freeNode;  // References node after back of queue
   
   public TwoPartCircularLinkedQueue()
   {
      freeNode = new Node(null, null);
      freeNode.setNextNode(freeNode);
      queueNode = freeNode;
   } // end default constructor

   //  < Implementations of the queue operations go here. >
   //  . . .

	private class Node
	{
		private T    data;  // Queue entry
		private Node next;  // Link to next node
      
		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor
		
		private Node(T dataPortion, Node linkPortion)
		{
			data = dataPortion;
			next = linkPortion;
		} // end constructor
      
		private T getData()
		{
			return data;
		} // end getData
      
		private void setData(T newData)
		{
			data = newData;
		} // end setData
      
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end TwoPartCircularLinkedQueue
