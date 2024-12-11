// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean contains(T anEntry)
{
   checkIntegrity();
   boolean found = false;
   int index = 1;
   while (!found && (index <= numberOfEntries))
   {
      if (anEntry.equals(list[index]))
         found = true;
      index++;
   } // end while
   return found;
} // end contains

