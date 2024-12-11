	/** Retrieves all entries that are in this bag.
	    @return  A newly allocated array of all the entries in the bag.
       @author Frank M. Carrano, Timothy M. Henry
       @version 5.0
   */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.data;
         index++;
         currentNode = currentNode.next;
      } // end while
      	
		return result;
	} // end toArray
