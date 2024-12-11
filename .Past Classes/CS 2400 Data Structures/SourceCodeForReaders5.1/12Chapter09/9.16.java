// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public static void displayArray(int array[], int first, int last) 
{
   System.out.print(array[first] + " ");
   if (first < last)
      displayArray(array, first + 1, last);
} // end displayArray

