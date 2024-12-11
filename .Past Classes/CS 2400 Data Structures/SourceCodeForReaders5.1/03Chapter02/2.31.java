@author Frank M. Carrano, Timothy M. Henry
@version 5.0
 	// Locates a given entry within the array bag.
	// Returns the index of the entry, if located, or -1 otherwise.
	// Precondition: checkIntegrity has been called.
   private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
      int index = 0;

      while (!found && (index < numberOfEntries))
      {
         if (anEntry.equals(bag[index]))
         {
            found = true;
            where = index;
         } // end if
         index++;
      } // end while

      // Assertion: If where > -1, anEntry is in the array bag, and it
      // equals bag[where]; otherwise, anEntry is not in the array
      
		return where;
	} // end getIndexOf
