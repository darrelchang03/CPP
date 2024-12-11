@author Frank M. Carrano, Timothy M. Henry
@version 5.0
	/** Adds a new entry to this bag.
	    @param newEntry  the object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry) 
	{
		boolean result = true;
		if (isArrayFull())
		{
			result = false;
		}
		else
		{  // Assertion: result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		} // end if
		
		return result;
	} // end add
