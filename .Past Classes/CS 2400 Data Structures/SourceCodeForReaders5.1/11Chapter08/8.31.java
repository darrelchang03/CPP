// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T removeFront()
{
   T front = getFront();  // Might throw EmptyQueueException
   // Assertion: firstNode != null
   firstNode = firstNode.getNextNode();

   if (firstNode == null)
      lastNode = null;
   else
      firstNode.setPreviousNode(null);

   return front;
} // end removeFront

public T removeBack()
{
   T back = getBack();  // Might throw EmptyQueueException
   // Assertion: lastNode != null
   lastNode = lastNode.getPreviousNode();

   if (lastNode == null)
      firstNode = null;
   else
      lastNode.setNextNode(null);
   } // end if

   return back;
} // end removeBack

