@author Frank M. Carrano, Timothy M. Henry
@version 5.0
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry) 
	{
		checkIntegrity();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);		
		return anEntry.equals(result);
	} // end remove
