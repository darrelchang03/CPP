// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public static <T extends Comparable<? super T>>
       void selectionSort(T[] a, int n)
{
   selectionSort(a, 0, n - 1); // Invoke recursive method
} // end selectionSort

