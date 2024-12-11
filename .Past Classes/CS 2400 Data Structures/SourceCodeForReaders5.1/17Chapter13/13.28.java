// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public int nextIndex()
{
   int result;

   if (hasNext())
      result = nextIndex - 1;   // Change to zero-based numbering of iterator
   else
      result = numberOfEntries; // End-of-list flag

   return result;
} // end nextIndex

// 15.28
public int previousIndex()
{
   int result;

   if (hasPrevious())
      result = nextIndex - 2; // Change to zero-based numbering of iterator
   else
      result = -1;            // Beginning-of-list flag

   return result;
} // end previousIndex

