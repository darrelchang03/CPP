import java.util.Iterator;
/**
   An interface for a dictionary with distinct search keys.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface DictionaryInterface<K, V>
{  // See Segment 20.4 for a commented version.
   public V add(K key, V value);
   public V remove(K key);
   public V getValue(K key);
   public boolean contains(K key);
   public Iterator<K> getKeyIterator();
   public Iterator<V> getValueIterator();
   public boolean isEmpty();
   public int getSize();
   public void clear();
} // end DictionaryInterface
