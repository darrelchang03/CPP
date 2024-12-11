// Finds the node containing the largest entry in a given tree.
// rootNode is the root node of the tree.
// Returns the node containing the largest entry in the tree.
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private BinaryNode<T> findLargest(BinaryNode<T> rootNode)
{
   if (rootNode.hasRightChild())
      rootNode = findLargest(rootNode.getRightChild());

   return rootNode;
} // end findLargest

