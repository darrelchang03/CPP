// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public T remove(T anEntry)
{
   ReturnObject oldEntry = new ReturnObject(null);
   BinaryNode<T> newRoot = removeEntry(getRootNode(), anEntry, oldEntry);
   setRootNode(newRoot);

   return oldEntry.get();
} // end remove

