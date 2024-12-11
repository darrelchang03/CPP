@author Frank M. Carrano, Timothy M. Henry
@version 5.0
	public boolean contains(T anEntry)
	{
      checkIntegrity();
      boolean found = false;
      int index = 0;
      while (!found && (index < numberOfEntries))
      {
         if (anEntry.equals(bag[index]))
         {
            found = true;
         } // end if
         index++;
      } // end while
      
      return found;
	} // end contains
