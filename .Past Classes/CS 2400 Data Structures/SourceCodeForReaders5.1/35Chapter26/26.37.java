// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private NodePair findNode(T entry)
{
   NodePair result = new NodePair();
   boolean found = false;

//  . . .

   if (found)
      result = new NodePair(currentNode, parentNode);
      // Located entry is currentNode.getData()

   return result;
} // end findNode

