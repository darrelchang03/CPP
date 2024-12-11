// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(T newEntry)
{
   Node theNode = new Node(newEntry);
   Node nodeBefore = getNodeBefore(newEntry);

   if (nodeBefore == null) // No need to call isEmpty
      addFirstNode(theNode);
   else
      addAfterNode(nodeBefore, theNode);
} // end add

