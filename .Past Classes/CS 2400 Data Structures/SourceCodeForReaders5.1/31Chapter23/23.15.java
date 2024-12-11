// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

private class KeyIterator implements Iterator<K>
{
   private int currentIndex; // Current position in hash table
   private int numberLeft;   // Number of entries left in iteration
   
   private KeyIterator()
   {
      currentIndex = 0;
      numberLeft = numberOfEntries;
   } // end default constructor
   
   public boolean hasNext()
   {
      return numberLeft > 0;
   } // end hasNext
   
   public K next()
   {
      K result = null;
      
      if (hasNext())
      {
         // Skip table locations that do not contain a current entry
         while ( (hashTable[currentIndex] == null) || (hashTable[currentIndex] == AVAILABLE) )
         {
            currentIndex++;
         } // end while
         
         result = hashTable[currentIndex].getKey();
         numberLeft--;
         currentIndex++;
      }
      else
         throw new NoSuchElementException();
      
      return result;
   } // end next
   
   public void remove()
   {
      throw new UnsupportedOperationException();
   } // end remove
} // end KeyIterator


