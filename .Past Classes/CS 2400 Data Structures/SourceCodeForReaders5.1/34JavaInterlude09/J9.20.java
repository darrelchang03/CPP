/** Makes a clone of this node and its subtrees.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
    @return  The clone of the subtree rooted at this node. */
public Object clone()
{
   BinaryNode<T> theCopy = null;
   try
   {
      @SuppressWarnings("unchecked")
      BinaryNode<T> temp = (BinaryNode<T>)super.clone();
      theCopy = temp;
   }
   catch (CloneNotSupportedException e)
   {
      throw new Error("BinaryNode cannot clone: " + e.toString());
   }

   theCopy.data = (T)data.clone();

   if (left != null)
      theCopy.left = (BinaryNode<T>)left.clone();

   if (right != null)
      theCopy.right = (BinaryNode<T>)right.clone();

   return theCopy;
} // end clone

