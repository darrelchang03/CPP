// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T getFront()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyQueueException();
   else
      return queue[frontIndex];
} // end getFront

