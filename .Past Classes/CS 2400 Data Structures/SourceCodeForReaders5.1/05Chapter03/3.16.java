	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag.
       @author Frank M. Carrano, Timothy M. Henry
       @version 5.0 */
	public int getFrequencyOf(T anEntry)
	{
		int frequency = 0;
      int loopCounter = 0;
      Node currentNode = firstNode;

      while ((loopCounter < numberOfEntries) && (currentNode != null))
      {
         if (anEntry.equals(currentNode.data))
         {
            frequency++;
         } // end if
         
         loopCounter++;
         currentNode = currentNode.next;
      } // end while

		return frequency;
	} // end getFrequencyOf
