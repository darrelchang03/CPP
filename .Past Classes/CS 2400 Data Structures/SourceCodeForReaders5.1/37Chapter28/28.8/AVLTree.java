package TreePackage;

/**
   A class that implements the ADT AVL tree by extending BinarySearchTree.
   The remove operation is not supported.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
 */
public class AVLTree<T extends Comparable<? super T>>
             extends BinarySearchTree<T> 
//           implements SearchTreeInterface<T>  // Optional since BinarySearchTree implements this interface
{
	public AVLTree()
	{
		super();
	} // end default constructor
	
	public AVLTree(T rootEntry)
	{
		super(rootEntry);
	} // end constructor

/*   Implementations of add and remove are here. A definition of add appears in Segment 28.12 of
     this chapter. Other methods in SearchTreeInterface are inherited.
   . . .

     Implementations of private methods to rebalance the tree using rotations are here.
   . . . */

} // end AVLTree
