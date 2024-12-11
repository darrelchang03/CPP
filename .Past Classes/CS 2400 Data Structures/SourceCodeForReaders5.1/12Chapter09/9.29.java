// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void displayArray(int first, int last)
{
   if (first == last)
      System.out.print(array[first] + " ");
   else 
   {
      int mid = first + (last - first) / 2; // Improved calculation of midpoint
      displayArray(first, mid);
      displayArray(mid + 1, last);
   } // end if
} // end displayArray

