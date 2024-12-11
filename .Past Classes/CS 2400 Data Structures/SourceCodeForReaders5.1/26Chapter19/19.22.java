// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean contains(T anEntry)
{
   Node currentNode = firstNode;

   while ( (currentNode != null) && 
           (anEntry.compareTo(currentNode.getData()) > 0) )
   {
      currentNode = currentNode.getNextNode();
   } // end while

   return (currentNode != null) && 
           anEntry.equals(currentNode.getData());
} // end contains

