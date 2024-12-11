// Removes the node containing the largest entry in a given tree.
// rootNode is the root node of the tree.
// Returns the root node of the revised tree.
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private BinaryNode<T> removeLargest(BinaryNode<T> rootNode)
{
   if (rootNode.hasRightChild())
   {
      BinaryNode<T> rightChild = rootNode.getRightChild();
      rightChild = removeLargest(rightChild);
      rootNode.setRightChild(rightChild);
   }
   else
      rootNode = rootNode.getLeftChild();

   return rootNode;
} // end removeLargest

