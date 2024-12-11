// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(int givenPosition, T newEntry)
{
   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
   {
      Node newNode = new Node(newEntry);
      if (isEmpty())
      {
         firstNode = newNode;
         lastNode = newNode;
      }
      else if (givenPosition == 1)
      {
         newNode.setNextNode(firstNode);
         firstNode = newNode;
      }
      else if (givenPosition == numberOfEntries + 1)
      {
         lastNode.setNextNode(newNode);
         lastNode = newNode;
      }
      else
      {
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

