import java.util.Iterator;
import java.util.NoSuchElementException;
/**
   A linked implementation of the ADT list that
   includes iterator operations as ADT operations.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class ListWithTraversal<T> implements ListInterface<T>, Iterator<T>
{
	private Node firstNode;
	private int  numberOfEntries;
	private Node nextNode; // Node containing next entry in iteration
	
	public ListWithTraversal()
	{
		initializeDataFields();
	} // end default constructor
	
/* < Implementations of the remaining methods of the ADT list go here;
     you can see them in Chapter 12, beginning at Segment 12.7.>
     . . . */
   
   // Initializes the class's data fields to indicate an empty list.
   private void initializeDataFields()
   {
		firstNode = null;
		numberOfEntries = 0;
		nextNode = null;
   } // end initializeDataFields
   
// Methods in the interface Iterator go here:
// 13.11
   public T next()
   {
      if (hasNext())
      {
         Node returnNode = nextNode;        // Get next node
         nextNode = nextNode.getNextNode(); // Advance iterator
         
         return returnNode.getData();       // Return next entry in iteration
      }
      else
         throw new NoSuchElementException("Illegal call to next(); " +
                                          "iterator is after end of list.");
   } // end next
   
   // 13.12
   public boolean hasNext()
   {
      return nextNode != null;
   } // end hasNext
   
   // 13.13
   public void remove()
   {
      throw new UnsupportedOperationException("remove() is not " +
                                              "supported by this iterator");
   } // end remove

	/** Sets the traversal to the beginning of the list. 
	    This method is NOT in the interface Iterator. */
   public void resetTraversal()
   {
      nextNode = firstNode;
   } // end resetTraversal
   
	private class Node
	{
      private T    data; // Entry in list
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      } // end constructor
      
      private Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
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
} // end ListWithTraversal



