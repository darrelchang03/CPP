package TreePackage;
import java.util.Iterator;
/**
   A class that implements the ADT binary search tree by extending BinaryTree.
   Recursive version.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class BinarySearchTree<T extends Comparable<? super T>>
             extends BinaryTree<T> implements SearchTreeInterface<T>
{
   public BinarySearchTree()
   {
      super();
   } // end default constructor
   
   public BinarySearchTree(T rootEntry)
   {
      super();
      setRootNode(new BinaryNode<T>(rootEntry));
   } // end constructor
   
   // Disable setTree (see Segment 26.6)
   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      throw new UnsupportedOperationException();
   } // end setTree

/* Implementations of contains, getEntry, add, and remove are here.
   . . .
   Other methods in SearchTreeInterface are inherited from BinaryTree.  */
} // end BinarySearchTree
