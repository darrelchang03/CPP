// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

protected final Node getFirstNode()
{
   return firstNode;
} // end getFirstNode

/** Adds a node to the beginning of a chain. */
protected final void addFirstNode(Node theNode)
{
   // Assertion: theNode != null
   theNode.setNextNode(firstNode);
   firstNode = theNode;
   numberOfEntries++;
} // end addFirstNode

/** Adds a node to a chain after a given node. */
protected final void addAfterNode(Node nodeBefore, Node theNode)

/** Removes a chain’s first node. */
protected final T removeFirstNode()

/** Removes the node after a given one. */
protected final T removeAfterNode(Node nodeBefore)

public T remove(int givenPosition)
{
   T result = null;

   if ((givenPosition >= 1) && (givenPosition <= getLength()))
   {
      // Assertion: The list is not empty
      if (givenPosition == 1)         // Case 1: Remove first entry
         result = removeFirstNode();
      else                            // Case 2: givenPosition > 1
      {
         Node nodeBefore = getNodeAt(givenPosition - 1);
         result = removeAfterNode(nodeBefore);
      } // end if
      return result;                  // Return removed entry
   }
   else
      throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
} // end remove
