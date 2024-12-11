// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T dequeue()
{
   T front = getFront();  // Might throw EmptyQueueException
   // Assertion: firstNode != null
   firstNode.setData(null);
   firstNode = firstNode.getNextNode();

   if (firstNode == null)
      lastNode = null;

   return front;
} // end dequeue

