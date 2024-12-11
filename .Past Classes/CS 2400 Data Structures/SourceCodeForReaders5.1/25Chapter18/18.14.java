// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private Node getNodeBefore(T anEntry)
{
  Node currentNode = getFirstNode();
  Node nodeBefore = null;
  
  while ((currentNode != null) && 
         (anEntry.compareTo(currentNode.getData()) > 0))
  {
      nodeBefore = currentNode;
      currentNode = currentNode.getNextNode();
  } // end while
  
  return nodeBefore;
} // end getNodeBefore

