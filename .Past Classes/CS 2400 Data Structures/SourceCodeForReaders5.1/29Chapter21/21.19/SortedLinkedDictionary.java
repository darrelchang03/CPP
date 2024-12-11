import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a chain of linked nodes.
   The dictionary is sorted and has distinct search keys.
   Search keys and associated values are not null.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SortedLinkedDictionary<K extends Comparable<? super K>, V> 
             implements DictionaryInterface<K, V>
{
	private Node firstNode; // Reference to first node of chain
	private int  numberOfEntries; 
	
	public SortedLinkedDictionary()
	{
      initializeDataFields();
	} // end default constructor
	
   public V add(K key, V value)
	{
		V result = null;
      if ((key == null) || (value == null))
         throw new IllegalArgumentException("Cannot add null to a dictionary.");
      else
      {
         // Search chain until you either find a node containing key
         // or locate where it should be
         Node currentNode = firstNode;
         Node nodeBefore = null;
         
         while ( (currentNode != null) && (key.compareTo(currentNode.getKey()) > 0) )
         {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
         } // end while
         
         if ( (currentNode != null) && key.equals(currentNode.getKey()) )
         {
            // Key in dictionary; replace corresponding value
            result = currentNode.getValue(); // Get old value
            currentNode.setValue(value);     // Replace value
         }
         else // Key not in dictionary; add new node in proper order
         {
            // Assertion: key and value are not null
            Node newNode = new Node(key, value); // Create new node
            
            if (nodeBefore == null)
            {                                    // Add at beginning (includes empty chain)
               newNode.setNextNode(firstNode);
               firstNode = newNode;
            }
            else                                 // Add elsewhere in non-empty chain
            {
               newNode.setNextNode(currentNode); // currentNode is after new node
               nodeBefore.setNextNode(newNode);  // nodeBefore is before new node
            } // end if

            numberOfEntries++;                   // Increase length for both cases
         } // end if
      } // end if

		return result;
	} // end add

/* Implementations of other methods in DictionaryInterface.
   . . .
   Private classes KeyIterator and ValueIterator (see Segment 21.20). >
   . . . */
   
	private class Node
	{
		private K key;
		private V value;
		private Node next;

/*    Constructors and the methods getKey, getValue, setValue, getNextNode,
      and setNextNode are here. There is no setKey.
      . . . */

	} // end Node
} // end SortedLinkedDictionary
		
