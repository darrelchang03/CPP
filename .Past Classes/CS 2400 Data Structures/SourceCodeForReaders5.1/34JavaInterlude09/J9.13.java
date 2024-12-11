// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

private class Node implements Cloneable
{
   private T    data;
   private Node next;

/* Constructors
   . . .

   Accessor and mutator methods getData, setData, getNextNode, and setNextNode
   . . . */

   protected Object clone()
   {
      Node theCopy = null;
      try
      {
         @SuppressWarnings("unchecked")
         Node temp = (Node)super.clone();
         theCopy = temp;
      }
      catch (CloneNotSupportedException e)
      {
         throw new Error(e.toString());
      }
      
      @SuppressWarnings("unchecked")
      T temp = (T)data.clone();
      theCopy.data = temp;
      theCopy.next = null; // Don't clone link; it's set later
      
      return theCopy;
   } // end clone
} // end Node


