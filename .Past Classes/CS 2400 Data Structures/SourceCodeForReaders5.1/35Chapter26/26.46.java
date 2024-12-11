// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public V add(K key, V value)
{
   Entry<K, V> newEntry = new Entry<>(key, value);
   Entry<K, V> returnedEntry = bst.add(newEntry);

   V result = null;
   if (returnedEntry != null)
      result = returnedEntry.getValue();

   return result;
} // end add

public V remove(K key)
{
   Entry<K, V> findEntry = new Entry<>(key, null);
   Entry<K, V> returnedEntry = bst.remove(findEntry);

   V result = null;
   if (returnedEntry != null)
      result = returnedEntry.getValue();

   return result;
} // end remove

