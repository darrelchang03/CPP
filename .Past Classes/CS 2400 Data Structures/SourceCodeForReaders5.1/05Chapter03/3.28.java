// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0 
package BagPackage;
public class LinkedBag<T> implements BagInterface<T>
{
   private Node<T> firstNode;

   public boolean add(T newEntry)
   {
      Node<T> newNode = new Node<T>(newEntry);
      newNode.setNextNode(firstNode);
      firstNode = newNode;
      numberOfEntries++;
      
      return true;
   } // end add
   
   // . . .
} // end LinkedBag
