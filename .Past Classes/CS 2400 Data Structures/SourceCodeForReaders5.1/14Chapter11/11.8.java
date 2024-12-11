// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(int newPosition, T newEntry)
{
   checkIntegrity();
   // Assertion: The array list has room for another entry.
   if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
   {
      if (newPosition <= numberOfEntries)
         makeRoom(newPosition);
      list[newPosition] = newEntry;
      numberOfEntries++;
      ensureCapacity(); // Ensure enough room for next add
   }
   else
      throw new IndexOutOfBoundsException(
                "Given position of add's new entry is out of bounds.");
} // end add
