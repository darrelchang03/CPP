// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T peek()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyStackException();
   else
      return stack[topIndex];
} // end peek

