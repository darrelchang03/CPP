// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T pop()
{
   checkInitegrity();
   if (isEmpty())
      throw new EmptyStackException();
   else
      return stack.remove(stack.size() - 1);
} // end pop

