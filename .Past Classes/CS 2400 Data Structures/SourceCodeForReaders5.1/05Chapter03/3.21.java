	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal was successful, or null
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0 */
	public T remove()
	{
		T result = null;
      if (firstNode != null)
      {
         result = firstNode.data; 
         firstNode = firstNode.next; // Remove first node from chain
         numberOfEntries--;
      } // end if

		return result;
	} // end remove
