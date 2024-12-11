/** Sorts an array into ascending order. Uses quick sort with
    median-of-three pivot selection for arrays of at least 
    MIN_SIZE entries, and uses insertion sort for other arrays.
    @author Frank M. Carrano
    @author Timothy M. Henry
    @version 5.0
*/
public static <T extends Comparable<? super T>>
       void quickSort(T[] a, int first, int last)
{
   if (last - first + 1 < MIN_SIZE)
   {
      insertionSort(a, first, last);
   }
   else
   {
      // Create the partition: Smaller | Pivot | Larger
      int pivotIndex = partition(a, first, last);

      // Sort subarrays Smaller and Larger
      quickSort(a, first, pivotIndex - 1);
      quickSort(a, pivotIndex + 1, last);
   } // end if
} // end quickSort

