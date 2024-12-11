// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T dequeue()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyQueueException();
   else
   {
      T front = queue[frontIndex];
      queue[frontIndex] = null;
      frontIndex = (frontIndex + 1) % queue.length;
      return front;
   } // end if
} // end dequeue

