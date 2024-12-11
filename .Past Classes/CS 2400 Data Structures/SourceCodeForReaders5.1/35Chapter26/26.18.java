// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

private T addEntry(T anEntry)
{
   BinaryNode<T> currentNode = getRootNode();
   // Assertion: currentNode != null
   T result = null;
   boolean found = false;

   while (!found)
   {
      T currentEntry = currentNode.getData();
      int comparison = anEntry.compareTo(currentEntry);

      if (comparison == 0)
      {  // anEntry matches currentEntry;
         // return and replace currentEntry
         found = true;
         result = currentEntry;
         currentNode.setData(anEntry);
      }
      else if (comparison < 0)
      {
         if (currentNode.hasLeftChild())
            currentNode = currentNode.getLeftChild();
         else
         {
            found = true;
            currentNode.setLeftChild(new BinaryNode<>(anEntry));
         } // end if
      }
      else
      {
         // Assertion: comparison > 0

         if (currentNode.hasRightChild())
            currentNode = currentNode.getRightChild();
         else
         {
            found = true;
            currentNode.setRightChild(new BinaryNode<>(anEntry));
         } // end if
      } // end if
   } // end while

   return result;
} // end addEntry

