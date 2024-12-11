// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T remove(int givenPosition)
{
   T result = null;                           // Return value
   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
   {
      // Assertion: !isEmpty()
      if (givenPosition == 1)                 // Case 1: Remove first entry
      {
         result = firstNode.getData();        // Save entry to be removed
         firstNode = firstNode.getNextNode(); // Remove entry
      }
      else                                    // Case 2: Not first entry
      {
         Node nodeBefore = getNodeAt(givenPosition - 1);
         Node nodeToRemove = nodeBefore.getNextNode();
         result = nodeToRemove.getData();    // Save entry to be removed
         Node nodeAfter = nodeToRemove.getNextNode();
         nodeBefore.setNextNode(nodeAfter);  // Remove entry
      } // end if
      numberOfEntries--;                     // Update count
      return result;                         // Return removed entry
   }
   else
      throw new IndexOutOfBoundsException(
                "Illegal position given to remove operation.");
} // end remove

