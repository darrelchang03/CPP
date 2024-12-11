// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean isEmpty()
{
   return queueNode == freeNode;
} // end isEmpty

private boolean isNewNodeNeeded()
{
   return queueNode == freeNode.getNextNode();
} // end isNewNodeNeeded

