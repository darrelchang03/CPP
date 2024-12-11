/** @author Frank M. Carrano, Timothy M. Henry
   @version 5.0 */
public T remove(T entry)
{
   T result = null;

   // Locate node (and its parent) that contains a match for entry
   NodePair pair = findNode(entry);
   BinaryNode<T> currentNode = pair.getFirst();
   BinaryNode<T> parentNode = pair.getSecond();

   if (currentNode != null) // Entry is found
   {
      result = currentNode.getData(); // Get entry to be removed

      // Case 1: currentNode has two children
      if (currentNode.hasLeftChild() && currentNode.hasRightChild())
      {
         // Replace entry in currentNode with the entry in another node
         // that has at most one child; that node can be deleted

         // Get node to remove (contains inorder predecessor; has at
         // most one child) and its parent
         pair = getNodeToRemove(currentNode);
         BinaryNode<T> nodeToRemove = pair.getFirst();
         parentNode = pair.getSecond();

         // Copy entry from nodeToRemove to currentNode
         currentNode.setData(nodeToRemove.getData());

         currentNode = nodeToRemove;
         // Assertion: currentNode is the node to be removed; it has at
         //            most one child
         // Assertion: Case 1 has been transformed to Case 2
      } // end if

      // Case 2: currentNode has at most one child; delete it
      removeNode(currentNode, parentNode);
   } // end if

   return result;
} // end remove


