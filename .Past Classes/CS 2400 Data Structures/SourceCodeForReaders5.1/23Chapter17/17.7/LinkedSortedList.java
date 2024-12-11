/**
   A class that implements the ADT sorted list by using a chain of linked nodes.
   Duplicate entries are allowed.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedSortedList<T extends Comparable<? super T>>
             implements SortedListInterface<T>
{
   private Node firstNode;       // Reference to first node of chain
   private int numberOfEntries;

   public LinkedSortedList()
   {
      firstNode = null;
      numberOfEntries = 0;
   } // end default constructor

/* < Implementations of the sorted list operations go here.>
   . . . */
   
   private class Node
   {
      private T     data;  // Entry in list
      private Node	next; // Link to next node

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
} // end LinkedSortedList
