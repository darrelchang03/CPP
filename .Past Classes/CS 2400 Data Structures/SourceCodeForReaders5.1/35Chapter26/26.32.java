// Removes the entry in a given root node of a subtree.
// rootNode is the root node of the subtree.
// Returns the root node of the revised subtree.
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
{
   // Case 1: rootNode has two children
   if (rootNode.hasLeftChild() && rootNode.hasRightChild())
   {
      // Find node with largest entry in left subtree
      BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
      BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);

      // Replace entry in root
      rootNode.setData(largestNode.getData());

      // Remove node with largest entry in left subtree
      rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
   } // end if

   // Case 2: rootNode has at most one child
   else if (rootNode.hasRightChild())
      rootNode = rootNode.getRightChild();
   else
      rootNode = rootNode.getLeftChild();

   // Assertion: If rootNode was a leaf, it is now null

   return rootNode;
} // end removeFromRoot

