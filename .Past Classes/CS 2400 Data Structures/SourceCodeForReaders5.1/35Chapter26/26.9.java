// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public T getEntry(T anEntry)
{
   return findEntry(getRootNode(), anEntry);
} // end getEntry

private T findEntry(BinaryNode<T> rootNode, T anEntry)
{
   T result = null;

   if (rootNode != null)
   {
      T rootEntry = rootNode.getData();

      if (anEntry.equals(rootEntry))
         result = rootEntry;
      else if (anEntry.compareTo(rootEntry) < 0)
         result = findEntry(rootNode.getLeftChild(), anEntry);
      else
         result = findEntry(rootNode.getRightChild(), anEntry);
   } // end if

   return result;
} // end findEntry

