// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public void inorderTraverse()
{
   inorderTraverse(root);
} // end inorderTraverse

private void inorderTraverse(BinaryNode<T> node)
{
   if (node != null)
   {
      inorderTraverse(node.getLeftChild());
      System.out.println(node.getData());
      inorderTraverse(node.getRightChild());
   } // end if
} // end inorderTraverse

