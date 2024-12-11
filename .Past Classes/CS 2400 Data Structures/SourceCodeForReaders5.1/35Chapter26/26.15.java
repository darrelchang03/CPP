// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

// Adds anEntry to the nonempty subtree rooted at rootNode.
private T addEntry(BinaryNode<T> rootNode, T anEntry)
{
   // Assertion: rootNode != null
   T result = null;
   int comparison = anEntry.compareTo(rootNode.getData());

   if (comparison == 0)
   {
      result = rootNode.getData();
      rootNode.setData(anEntry);
   }
   else if (comparison < 0)
   {
      if (rootNode.hasLeftChild())
         result = addEntry(rootNode.getLeftChild(), anEntry);
      else
         rootNode.setLeftChild(new BinaryNode<>(anEntry));
   }
   else
   {
      // Assertion: comparison > 0

      if (rootNode.hasRightChild())
         result = addEntry(rootNode.getRightChild(), anEntry);
      else
         rootNode.setRightChild(new BinaryNode<>(anEntry));
   } // end if

   return result;
} // end addEntry

