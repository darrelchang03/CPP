// Corrects an imbalance at the node closest to a structural
// change in the left subtree of the node's left child.
// nodeN is a node, closest to the newly added leaf, at which
// an imbalance occurs and that has a left child.
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private BinaryNode<T> rotateRight(BinaryNode<T> nodeN)
{
   BinaryNode<T> nodeC = nodeN.getLeftChild();
   nodeN.setLeftChild(nodeC.getRightChild());
   nodeC.setRightChild(nodeN);
   return nodeC;
} // end rotateRight

// Corrects an imbalance at the node closest to a structural
// change in the left subtree of the node's right child.
// nodeN is a node, closest to the newly added leaf, at which
// an imbalance occurs and that has a right child.
private BinaryNode<T> rotateRightLeft(BinaryNode<T> nodeN)
{
   BinaryNode<T> nodeC = nodeN.getRightChild();
   nodeN.setRightChild(rotateRight(nodeC));
   return rotateLeft(nodeN);
} // end rotateRightLeft

