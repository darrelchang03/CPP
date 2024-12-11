// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(T newEntry)
{
   checkIntegrity();        // Ensure initialization of data fields
   int newIndex = lastIndex + 1;
   int parentIndex = newIndex / 2;
   while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
   {
      heap[newIndex] = heap[parentIndex];
      newIndex = parentIndex;
      parentIndex = newIndex / 2;
   } // end while

   heap[newIndex] = newEntry;
   lastIndex++;
   ensureCapacity();
} // end add

