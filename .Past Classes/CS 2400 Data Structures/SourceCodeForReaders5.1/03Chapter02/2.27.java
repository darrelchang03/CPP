@author Frank M. Carrano, Timothy M. Henry
@version 5.0
	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal was successful,
                or null otherwise. */
	public T remove()
	{
		checkIntegrity();
      T result = removeEntry(numberOfEntries - 1);		
		return result;
	} // end remove
