// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(T newEntry)
{
   checkIntegrity();
   list[numberOfEntries + 1] = newEntry;
   numberOfEntries++;
   ensureCapacity();
} // end add

