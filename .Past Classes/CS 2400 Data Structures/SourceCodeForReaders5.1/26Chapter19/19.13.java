// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private static <T extends Comparable<? super T>>
        boolean binarySearch(T[] anArray, int first, int last, T desiredItem)
{
   boolean found;
   int mid = first + (last - first) / 2;
      
   if (first > last)
      found = false;
   else if (desiredItem.equals(anArray[mid]))
      found = true;
   else if (desiredItem.compareTo(anArray[mid]) < 0)
      found = binarySearch(anArray, first, mid - 1, desiredItem);
   else
      found = binarySearch(anArray, mid + 1, last, desiredItem);

   return found;
} // end binarySearch

public static <T extends Comparable<? super T>> boolean inArray(T anEntry)
{
   return binarySearch(anArray, 0, anArray.length - 1, anEntry);
} // end inArray

