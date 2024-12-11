// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T removeMax()
{
   checkIntegrity();             // Ensure initialization of data fields
   T root = null;

   if (!isEmpty())
   {
      root = heap[1];            // Return value
      heap[1] = heap[lastIndex]; // Form a semiheap
      lastIndex--;               // Decrease size
      reheap(1);                 // Transform to a heap
   } // end if

   return root;
} // end removeMax

