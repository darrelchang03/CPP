// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T getFront()
{
   if (isEmpty())
      throw new EmptyQueueException();
   else
      return firstNode.getData();
} // end getFront

