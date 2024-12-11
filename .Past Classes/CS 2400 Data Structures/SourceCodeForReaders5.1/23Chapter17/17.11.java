// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
// Finds the node that is before the node that should or does
// contain a given entry.
// Returns either a reference to the node that is before the node
// that contains--or should contain--anEntry, or null if no prior node exists
// (that is, if anEntry is or belongs at the beginning of the list).
private Node getNodeBefore(T anEntry)
{
   Node currentNode = firstNode;
   Node nodeBefore = null;

   while ( (currentNode != null) && 
           (anEntry.compareTo(currentNode.getData()) > 0) )
   {
      nodeBefore = currentNode;
      currentNode = currentNode.getNextNode();
   } // end while

   return nodeBefore;
} // end getNodeBefore
