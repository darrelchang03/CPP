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

      if ( (keyIndex < numberOfEntries) &&
            key.equals(dictionary[keyIndex].getKey()) )
      {
         // Key found, return and replace entry's value
         result = dictionary[keyIndex].getValue(); // Get old value
         dictionary[keyIndex].setValue(value);     // Replace value
      }
      else // Key not found; add new entry to dictionary
      {
         makeRoom(keyIndex); // Make room for new entry
         dictionary[keyIndex] = new Entry<>(key, value); // Insert new entry in array
         numberOfEntries++;
         ensureCapacity(); // Ensure enough room for next add
      } // end if

      return result;
   } // end if
} // end add
