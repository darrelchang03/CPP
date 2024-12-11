// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void enqueue(T newEntry)
{
   freeNode.setData(newEntry);

   if (isNewNodeNeeded())
   {
      // Allocate a new node and insert it after the node that
      // freeNode references
      Node newNode = new Node(null, freeNode.getNextNode());
      freeNode.setNextNode(newNode);
   } // end if

   freeNode = freeNode.getNextNode();
} // end enqueue

