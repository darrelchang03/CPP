// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void enqueue(T newEntry)
{
   Node newNode = new Node(newEntry, null);

   if (isEmpty())
      firstNode = newNode;
   else
      lastNode.setNextNode(newNode);
    
   lastNode = newNode;
} // end enqueue

