// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T dequeue()
{
   T front = getFront();  // Might throw EmptyQueueException
   // Assertion: Queue is not empty
   queueNode.setData(null);
   queueNode = queueNode.getNextNode();

   return front;
} // end dequeue

