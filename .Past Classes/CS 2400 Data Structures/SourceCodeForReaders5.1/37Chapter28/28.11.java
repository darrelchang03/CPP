// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private BinaryNode<T> rebalance(BinaryNode<T> nodeN)
{
   int heightDifference = getHeightDifference(nodeN);

   if (heightDifference > 1)
   {
      // Left subtree is taller by more than 1,
      // so addition was in left subtree
      if (getHeightDifference(nodeN.getLeftChild()) > 0)
         // Addition was in left subtree of left child
         nodeN = rotateRight(nodeN);
      else
         // Addition was in right subtree of left child
         nodeN = rotateLeftRight(nodeN);
   }
   else if (heightDifference < -1)
   {
      // Right subtree is taller by more than 1,
      // so addition was in right subtree
      if (getHeightDifference(nodeN.getRightChild()) < 0)
         // Addition was in right subtree of right child
         nodeN = rotateLeft(nodeN);
      else
         // Addition was in left subtree of right child
         nodeN = rotateRightLeft(nodeN);
   } // end if
   // Else nodeN is balanced

   return nodeN;
} // end rebalance

