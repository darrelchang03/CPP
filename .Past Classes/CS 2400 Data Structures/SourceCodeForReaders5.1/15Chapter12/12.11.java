// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(int givenPosition, T newEntry)
{
   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
   {
      Node newNode = new Node(newEntry);
      if (givenPosition == 1)                // Case 1
      {
         newNode.setNextNode(firstNode);
         firstNode = newNode;
      }
      else									         // Case 2: list is not empty
      {                                      // and givenPosition > 1
         Node nodeBefore = getNodeAt(givenPosition - 1);
         Node nodeAfter = nodeBefore.getNextNode();
         newNode.setNextNode(nodeAfter);
         nodeBefore.setNextNode(newNode);
      } // end if
      numberOfEntries++;
   }
   else
      throw new IndexOutOfBoundsException(
                "Illegal position given to add operation.");
} // end add

