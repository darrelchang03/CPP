/**
 A class that implements the ADT list by using a chain of
 linked nodes that has a head reference.
 
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
public class LList<T> implements ListInterface<T>
{
	private Node firstNode;            // Reference to first node
	private int  numberOfEntries;
   
	public LList()
	{
		initializeDataFields();
	} // end default constructor
   
   public int clear()
   {
      initializeDataFields();
   } // end clear

/*  < Implementations of the public methods add, remove, replace, getEntry, contains,
      getLength, isEmpty, and toArray go here. >
   . . . */

   // Initializes the class’s data fields to indicate an empty list.
   private void initializeDataFields()
   {
      firstNode = null;
      numberOfEntries = 0;
   } // end initializeDataFields
   
   // Returns a reference to the node at a given position. 
   private Node getNodeAt(int givenPosition)
   {
//    . . .
   } // end getNodeAt

   private class Node
   {
      private T data;
      private Node next;
//    . . .

   } // end Node
} // end LList
