// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(int givenPosition, T newEntry)
{
   checkIntegrity();
   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
   {
      if (givenPosition <= numberOfEntries)
         makeRoom(givenPosition);
      list[givenPosition] = newEntry;
      numberOfEntries++;
      ensureCapacity(); // Ensure enough room for next add
   }
   else
      throw new IndexOutOfBoundsException(
                "Given position of add's new entry is out of bounds.");
} // end add

private void makeRoom(int givenPosition)
{
   int newIndex = givenPosition;
   int lastIndex = numberOfEntries;
   for (int index = lastIndex; index >= newIndex; index--)
      list[index + 1] = list[index];
}  // end makeRoom


