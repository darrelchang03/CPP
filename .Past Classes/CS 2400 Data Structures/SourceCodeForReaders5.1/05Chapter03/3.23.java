// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
 	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry)
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
     
		return currentNode;
	} // end getReferenceTo


	/** Removes one occurrence of a given entry from this bag, if possible.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false otherwise. */
   public boolean remove(T anEntry) 
	{
		boolean result = false;
      Node nodeN = getReferenceTo(anEntry);
      
      if (nodeN != null)
      {
         nodeN.data = firstNode.data; // Replace located entry with entry in first node
         firstNode = firstNode.next;  // Remove first node
         numberOfEntries--;
         result = true;
      } // end if
         
		return result;
	} // end remove
