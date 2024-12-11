// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(T newEntry)
{
   Node newNode = new Node(newEntry);
   Node nodeBefore = getNodeBefore(newEntry);

   if (isEmpty() || (nodeBefore == null))
   {
      // Add at beginning
      newNode.setNextNode(firstNode);
      firstNode = newNode;
   }
   else
   {
      // Add after nodeBefore
      Node nodeAfter = nodeBefore.getNextNode();
      newNode.setNextNode(nodeAfter);
      nodeBefore.setNextNode(newNode);
   } // end if

   numberOfEntries++;
} // end add
