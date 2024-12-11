// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
// Precondition: checkIntegrity has been called.
private int linearProbe(int index, K key)
{
   boolean found = false;
   int availableStateIndex = −1; // Index of first element in available state
   while ( !found && (hashTable[index] != null) )
   {
      if (hashTable[index] != AVAILABLE)
      {
         if (key.equals(hashTable[index].getKey()))
            found = true; // Key found
         else             // Follow probe sequence
            index = (index + 1) % hashTable.length; // Linear probing
      }
      else // Element in available state; skip it, but mark the first one encountered
      {
         // Save index of first element in available state
         if (availableStateIndex == −1)
            availableStateIndex = index;
         index = (index + 1) % hashTable.length;   // Linear probing
      } // end if
   } // end while
   // Assertion: Either key or null is found at hashTable[index]

   if (found || (availableStateIndex == −1) )
      return index;               // Index of either key or null
   else
      return availableStateIndex; // Index of an available element
} // end linearProbe
