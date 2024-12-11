// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

// Precondition: checkIntegrity has been called.
private void enlargeHashTable()
{
   Entry<K, V>[] oldTable = hashTable;
   int oldSize = hashTable.length;
   int newSize = getNextPrime(oldSize + oldSize);
   checkSize(newSize);

   // The cast is safe because the new array contains null entries
   @SuppressWarnings("unchecked")
   Entry<K, V>[] temp = (Entry<K, V>[])new Entry[newSize];
   hashTable = temp;
   numberOfEntries = 0; // Reset number of dictionary entries, since
                        // it will be incremented by add during rehash
   // Rehash dictionary entries from old array to the new and bigger array;
   // skip elements that contain null or AVAILABLE
   for (int index = 0; index < oldSize; index++)
   {
      if ( (oldTable[index] != null) && oldTable[index] != AVAILABLE )
         add(oldTable[index].getKey(), oldTable[index].getValue());
   } // end for
} // end enlargeHashTable
