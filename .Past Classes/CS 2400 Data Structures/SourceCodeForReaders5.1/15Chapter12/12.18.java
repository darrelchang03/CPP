// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T getEntry(int givenPosition)
{
   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
   {
      // Assertion: !isEmpty()
      return getNodeAt(givenPosition).getData();
   }
   else
      throw new IndexOutOfBoundsException(
                "Illegal position given to getEntry operation.");
} // end getEntry

