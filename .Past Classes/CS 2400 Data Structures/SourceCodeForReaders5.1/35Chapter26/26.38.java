// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private NodePair getNodeToRemove(BinaryNode<T> currentNode)
{
   // Find node with largest entry in left subtree by
   // moving as far right in the subtree as possible
   BinaryNode<T> leftSubtreeRoot = currentNode.getLeftChild();
   BinaryNode<T> rightChild = leftSubtreeRoot;
   BinaryNode<T> priorNode = currentNode;

   while (rightChild.hasRightChild())
   {
      priorNode = rightChild;
      rightChild = rightChild.getRightChild();
   } // end while

   // rightChild contains the inorder predecessor and is the node to
   // remove; priorNode is its parent

   return new NodePair(rightChild, priorNode);
} // end getNodeToRemove

