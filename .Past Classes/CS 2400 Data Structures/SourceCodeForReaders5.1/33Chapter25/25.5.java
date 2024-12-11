
/** Copies the subtree rooted at this node.
    @return  The root of a copy of the subtree rooted at this node.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0 */
public BinaryNode<T> copy()
{
   BinaryNode<T> newRoot = new BinaryNode<>(data);
   if (leftChild != null)
      newRoot.setLeftChild(leftChild.copy());

   if (rightChild != null)
      newRoot.setRightChild(rightChild.copy());

   return newRoot;
} // end copy

private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
{
   root = new BinaryNode<>(rootData);
   if ((leftTree != null) && !leftTree.isEmpty())
      root.setLeftChild(leftTree.root.copy());
   if ((rightTree != null) && !rightTree.isEmpty())
      root.setRightChild(rightTree.root.copy());
} // end initializeTree


