// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T remove(int givenPosition)
{
   checkIntegrity();
   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
   {
      // Assertion: The list is not empty
      T result = list[givenPosition]; // Get entry to be removed
      // Move subsequent entries towards entry to be removed,
      // unless it is last in list
      if (givenPosition < numberOfEntries)
         removeGap(givenPosition);
      list[numberOfEntries] = null;
      numberOfEntries--;
      return result; // Return reference to removed entry
   }
   else
      throw new IndexOutOfBoundsException(
                "Illegal position given to remove operation.");
} // end remove

