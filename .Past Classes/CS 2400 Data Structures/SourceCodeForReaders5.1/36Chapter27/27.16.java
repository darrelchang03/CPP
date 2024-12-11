/** @author Frank M. Carrano, Timothy M. Henry
    @version 5.0 */
public MaxHeap(T[] entries)
{
   this(entries.length); // Call other constructor
   lastIndex = entries.length;
   // Assertion: integrityOK = true

   // Copy given array to data field
   for (int index = 0; index < entries.length; index++)
      heap[index + 1] = entries[index];

   // Create heap
   for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
      reheap(rootIndex);
} // end constructor

