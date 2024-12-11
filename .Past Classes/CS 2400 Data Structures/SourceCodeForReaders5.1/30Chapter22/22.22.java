// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private int getHashIndex(K key)
{
   int hashIndex = key.hashCode() % hashTable.length;

   if (hashIndex < 0)
      hashIndex = hashIndex + hashTable.length;
   hashIndex = probe(hashIndex, key);

   return hashIndex;
} // end getHashIndex
