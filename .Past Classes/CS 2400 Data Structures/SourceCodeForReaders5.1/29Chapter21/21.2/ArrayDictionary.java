import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a resizable array.
   The dictionary is unsorted and has distinct search keys.
   Search keys and associated values are not null.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class ArrayDictionary<K, V> implements DictionaryInterface<K, V>
{
	private Entry<K, V>[] dictionary; // Array of unsorted entries
	private int numberOfEntries;
   private boolean integrityOK = false;
	private final static int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayDictionary()
	{
		this(DEFAULT_CAPACITY);        // Call next constructor
	} // end default constructor
	
	public ArrayDictionary(int initialCapacity)
	{
      checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      Entry<K, V>[] tempDictionary = (Entry<K, V>[])new Entry[initialCapacity];
      dictionary = tempDictionary;
		numberOfEntries = 0;
      integrityOK = true;
	} // end constructor

/* < Implementations of methods in DictionaryInterface. >
   . . . */
   
	private class Entry<K, V>
	{
		private K key;
		private V value;
		
		private Entry(K searchKey, V dataValue)
		{
         key = searchKey;
         value = dataValue;
		} // end constructor
		
		private K getKey()
		{
			return key;
		} // end getKey
		
		private V getValue()
		{
			return value;
		} // end getValue
		
		private void setValue(V dataValue)
		{
		 	value = dataValue;
		} // end setValue
	} // end Entry
} // end ArrayDictionary
