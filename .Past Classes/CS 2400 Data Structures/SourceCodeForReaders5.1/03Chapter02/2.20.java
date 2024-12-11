@author Frank M. Carrano, Timothy M. Henry
@version 5.0
	public int getFrequencyOf(T anEntry)
	{
      checkIntegrity();
		int counter = 0;

		for (int index = 0; index < numberOfEntries; index++) 
		{
			if (anEntry.equals(bag[index]))
			{
				counter++;
			} // end if
		} // end for

		return counter;
	} // end getFrequencyOf

