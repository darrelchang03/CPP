@author Frank M. Carrano, Timothy M. Henry
@version 5.0
   // Removes and returns the entry at a given index within the array bag.
   // If no such entry exists, returns null.
	// Preconditions: 0 <= givenIndex < numberOfEntries;
   //                checkIntegrity has been called.
   private T removeEntry(int givenIndex)
	{
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];                   // Entry to remove
         bag[givenIndex] = bag[numberOfEntries - 1]; // Replace entry with last entry
         bag[numberOfEntries - 1] = null;            // Remove last entry
         numberOfEntries--;
		} // end if
      
      return result;
	} // end removeEntry   
