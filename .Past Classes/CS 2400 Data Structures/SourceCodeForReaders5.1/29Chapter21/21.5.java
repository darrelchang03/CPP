// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public V add(K key, V value)
{
   checkIntegrity();
   if ((key == null) || (value == null))
      throw new IllegalArgumentException("Cannot add null to this dictionary.");
   else
   {
      V result = null;
      int keyIndex = locateIndex(key);
      if (keyIndex < numberOfEntries)
      {
         // Key found, return and replace entry's value
         result = dictionary[keyIndex].getValue(); // Get old value
         dictionary[keyIndex].setValue(value); 		// Replace value
      }
      else // Key not found; add new entry to dictionary
      {
         // Add at end of array
         dictionary[numberOfEntries] = new Entry<>(key, value);
         numberOfEntries++;
         ensureCapacity(); // Ensure enough room for next add
      } // end if
      return result;
   } // end if
} // end add

// Returns the array index of the entry that contains key, or
// returns numberOfEntries if no such entry exists.
// Precondition: key is not null.
private int locateIndex(K key)
{
   // Sequential search
   int index = 0;
   while ( (index < numberOfEntries) &&
           !key.equals(dictionary[index].getKey()) )
      index++;
   return index;
} // end locateIndex
