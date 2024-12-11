/**
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedGroup<T extends Comparable<? super T>>
{
   private Node firstNode;
   int length; // Number of objects in the group
   
   //  . . .

   private void insertInOrder(Node nodeToInsert)
   {
      T item = nodeToInsert.getData();
      Node currentNode = firstNode;
      Node previousNode = null;

      // Locate insertion point
      while ( (currentNode != null) && 
              (item.compareTo(currentNode.getData()) > 0) )
      {
         previousNode = currentNode;
         currentNode = currentNode.getNextNode();
      } // end while

      // Make the insertion
      if (previousNode != null)
      {  // Insert between previousNode and currentNode
         previousNode.setNextNode(nodeToInsert);
         nodeToInsert.setNextNode(currentNode);
      }
      else // Insert at beginning
      {
         nodeToInsert.setNextNode(firstNode);
         firstNode = nodeToInsert;
      } // end if
   } // end insertInOrder
   
   private class Node
   {
      private T data;    // Entry in bag
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
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
} // end LinkedChainList

