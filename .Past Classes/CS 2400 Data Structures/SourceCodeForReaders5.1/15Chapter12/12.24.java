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
         firstNode = firstNode.getNextNode();
         if (numberOfEntries == 1)
            lastNode = null;                  // Solitary entry was removed
      }
      else                                    // Case 2: Not first entry
      {
         Node nodeBefore = getNodeAt(givenPosition - 1);
         Node nodeToRemove = nodeBefore.getNextNode();
         Node nodeAfter = nodeToRemove.getNextNode();
         nodeBefore.setNextNode(nodeAfter);
         result = nodeToRemove.getData();
         if (givenPosition == numberOfEntries)
            lastNode = nodeBefore;            // Last node was removed
      } // end if
      numberOfEntries--;
   }
   else
      throw new IndexOutOfBoundsException(
                "Illegal position given to remove operation.");

   return result;                             // Return removed entry
} // end remove

