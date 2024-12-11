   /** Tests whether this bag contains a given entry.
       @param anEntry  The entry to locate.
    @return  True if the bag contains anEntry, or false otherwise.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0 */
	public boolean contains(T anEntry)
	{
      boolean found = false;
      Node currentNode = firstNode;
      
      while (!found && (currentNode != null))
      {
         if (anEntry.equals(currentNode.data))
            found = true;
         else
            currentNode = currentNode.next;
      } // end while
      return found;
   } // end contains
