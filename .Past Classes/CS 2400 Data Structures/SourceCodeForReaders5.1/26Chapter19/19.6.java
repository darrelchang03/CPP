// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

/** Searches an array for anEntry. */
public static <T> boolean inArray(T[] anArray, T anEntry)
{
   return search(anArray, 0, anArray.length - 1, anEntry);
} // end inArray

// Searches anArray[first] through anArray[last] for desiredItem.
// first >= 0 and < anArray.length.
// last >= 0 and < anArray.length.
private static <T> boolean search(T[] anArray, int first, int last, T desiredItem)
{
   boolean found;
   if (first > last)
      found = false; // No elements to search
   else if (desiredItem.equals(anArray[first]))
      found = true;
   else
      found = search(anArray, first + 1, last, desiredItem);
      
   return found;
} // end search

