// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private void removeNode(BinaryNode<T> nodeToRemove, BinaryNode<T> parentNode)
{
   BinaryNode<T> childNode;

   if (nodeToRemove.hasLeftChild())
      childNode = nodeToRemove.getLeftChild();
   else
      childNode = nodeToRemove.getRightChild();

   // Assertion: if nodeToRemove is a leaf, childNode is null

   if (nodeToRemove == getRootNode())
      setRootNode(childNode);
   else if (parentNode.getLeftChild() == nodeToRemove)
      parentNode.setLeftChild(childNode);
   else
      parentNode.setRightChild(childNode);
} // end removeNode

