	/** Removes one unspecified entry from this bag, if possible.
       @return either the removed entry, if the removal was successful,
               or null otherwise */
	public T remove()
	{
		checkIntegrity();
      T result = null;
		
		if (numberOfEntries > 0))
		{
         result = bag[numberOfEntries - 1];
         bag[numberOfEntries - 1] = null;
         numberOfEntries--;
		} // end if
      
      return result;
	} // end remove
