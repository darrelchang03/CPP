// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public T add(T anEntry)
{
   T result = null;

   if (isEmpty())
      setRootNode(new BinaryNode<>(anEntry));
   else
      result = addEntry(getRootNode(), anEntry);
    
   return result;
} // end add


