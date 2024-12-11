// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public Object clone()
{
   LList<T> theCopy = null;
   try
   {
      @SuppressWarnings("unchecked")
      LList<T> temp = (LList<T>)super.clone();
      theCopy = temp;
   }
   catch (CloneNotSupportedException e)
   {
      throw new Error(e.toString());
   }
   // Copy underlying chain of nodes
   if (firstNode == null) // If chain is empty
   {
      theCopy.firstNode = null;
   }
   else
   {
      // Make a copy of the first node
      @SuppressWarnings("unchecked")
      Node temp = (Node)firstNode.clone();
      theCopy.firstNode = temp;

      // Make a copy of the rest of chain
      Node newRef = theCopy.firstNode;
      Node oldRef = firstNode.getNextNode();
      for (int count = 2; count <= numberOfEntries; count++)
      {
         // Clone node and its data; link clone to new chain
         @SuppressWarnings("unchecked")
         Node temp2 = (Node)oldRef.clone();
         newRef.setNextNode(temp2);
         newRef = newRef.getNextNode();
         oldRef = oldRef.getNextNode();
      } // end for
   } // end if

   return theCopy;
} // end clone

