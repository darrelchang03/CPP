@author Frank M. Carrano, Timothy M. Henry
@version 5.0
/** Retrieves all entries that are in this bag.
		 @return  A newly allocated array of all the entries in the bag. */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

		for (int index = 0; index < numberOfEntries; index++) 
		{
			result[index] = bag[index];
		} // end for
			
		return result;
	} // end toArray
