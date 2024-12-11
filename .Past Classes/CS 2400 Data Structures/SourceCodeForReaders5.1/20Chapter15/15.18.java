// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private void insertionSort()
{
   // If fewer than two items are in the list, there is nothing to do
   if (length > 1)
   {
      // Assertion: firstNode != null

      // Break chain into 2 pieces: sorted and unsorted
      Node unsortedPart = firstNode.getNextNode();
      // Assertion: unsortedPart != null
      firstNode.setNextNode(null);

      while (unsortedPart != null)
      {
         Node nodeToInsert = unsortedPart;
         unsortedPart = unsortedPart.getNextNode();
         insertInOrder(nodeToInsert);
      } // end while
   } // end if
} // end insertionSort

