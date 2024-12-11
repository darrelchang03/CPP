// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public V getValue(K key)
{
   checkIntegrity();
   V result = null;

   int index = getHashIndex(key);
   if ((hashTable[index] != null) && (hashTable[index] != AVAILABLE))
      result = hashTable[index].getValue(); // Key found; get value
   // Else key not found; return null

   return result;
} // end getValue

