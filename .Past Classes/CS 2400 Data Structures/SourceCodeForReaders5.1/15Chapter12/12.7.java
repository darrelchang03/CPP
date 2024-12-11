// Returns a reference to the node at a given position.
// Precondition: The chain is not empty;
//               1 <= givenPosition <= numberOfEntries.
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
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

