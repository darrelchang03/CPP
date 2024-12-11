// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(T newEntry)
{
   isRemoveOrSetLegal = false;

   // Insert newEntry immediately before the the iterator's current position
   ArrayListWithListIterator.this.add(nextIndex, newEntry);
   nextIndex++;
} // end add


