// Removes an entry from the tree rooted at a given node.
// Parameters:
//    rootNode A reference to the root of a tree.
//    anEntry  The object to be removed.
//    oldEntry An object whose data field is null.
//    Returns: The root node of the resulting tree; if anEntry matches
//             an entry in the tree, oldEntry's data field is the entry
//             that was removed from the tree; otherwise it is null.
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T anEntry,
                                  ReturnObject oldEntry)
{
   if (rootNode != null)
   {
      T rootData = rootNode.getData();
      int comparison = anEntry.compareTo(rootData);

      if (comparison == 0)       // anEntry == root entry
      {
         oldEntry.set(rootData);
         rootNode = removeFromRoot(rootNode);
      }
      else if (comparison < 0)   // anEntry < root entry
      {
         BinaryNode<T> leftChild = rootNode.getLeftChild();
         BinaryNode<T> subtreeRoot = removeEntry(leftChild, anEntry, oldEntry);
         rootNode.setLeftChild(subtreeRoot);
      }
      else                       // anEntry > root entry
      {
         BinaryNode<T> rightChild = rootNode.getRightChild();
         // A different way of coding than for left child:
         rootNode.setRightChild(removeEntry(rightChild, anEntry, oldEntry));
      } // end if
   } // end if

   return rootNode;
} // end removeEntry

