// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T peek()
{
   if (isEmpty())
      throw new EmptyStackException();
   else
      return topNode.getData();
} // end peek

