// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T pop()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyStackException();
   else
   {
      T top = stack[topIndex];
      stack[topIndex] = null;
      topIndex--;
      return top;
   } // end if
} // end pop

