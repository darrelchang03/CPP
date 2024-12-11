// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

// Returns the index of either the entry that contains key or
// the location that should contain key, if no such entry exists.
private int locateIndex(K key)
{
   // Search until you either find an entry containing key or
   // pass the point where it should be
   int index = 0;
   while ( (index < numberOfEntries) &&
           key.compareTo(dictionary[index].getKey()) > 0 )
   {
      index++;
   } // end while

   return index;
} // end locateIndex

// Makes room for a new entry at a given index by shifting
// array entries towards the end of the array.
private void makeRoom(int keyIndex)
{
   // Exercise!
} // end makeRoom
