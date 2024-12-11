/**
   A linked implemention of the ADT list.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LList<T> implements ListInterface<T>
{
	private Node firstNode;            // Reference to first node of chain
	private int  numberOfEntries;
   
	public LList()
	{
		initializeDataFields();
	} // end default constructor
	
	public void clear()
	{
		initializeDataFields();
	} // end clear
   
/*  < Implementations of the public methods add, remove, replace, getEntry, contains,
      getLength, isEmpty, and toArray go here. >
   . . . */
  
   // Initializes the class's data fields to indicate an empty list.
   private void initializeDataFields()
   {
		firstNode = null;
		numberOfEntries = 0;
   } // end initializeDataFields
   
   // Returns a reference to the node at a given position.
   // Precondition: The chain is not empty;
   //               1 <= givenPosition <= numberOfEntries.
   private Node getNodeAt(int givenPosition)
   {
      // Assertion: (firstNode != null) &&
      //            (1 <= givenPosition) && (givenPosition <= numberOfEntries)
      Node currentNode = firstNode;
      
      // Traverse the chain to locate the desired node
      // (skipped if givenPosition is 1)
      for (int counter = 1; counter < givenPosition; counter++)
         currentNode = currentNode.getNextNode();
      // Assertion: currentNode != null
      return currentNode;
   } // end getNodeAt
  
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
} // end LList
