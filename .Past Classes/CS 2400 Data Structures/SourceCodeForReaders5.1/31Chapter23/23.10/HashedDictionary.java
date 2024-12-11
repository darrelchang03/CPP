import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using hashing and
   linear probing to resolve collisions.
   The dictionary is unsorted and has distinct search keys.
   Search keys and associated values are not null.
 
   Notes: Uses probe for add, but locate for remove and getValue.
   Uses linear probing, but includes code for quadratic probing.
   Has a display method for illustration and testing.

   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
 */
public class HashedDictionary<K, V> implements DictionaryInterface<K, V>
{
   // The dictionary:
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 5; // Must be prime
	private static final int MAX_CAPACITY = 10000;
   
   // The hash table:
	private Entry<K, V>[] hashTable;
   private int tableSize;                         // Must be prime
   private static final int MAX_SIZE = 2 * MAX_CAPACITY;
   private boolean integrityOK = false;
	private static final double MAX_LOAD_FACTOR = 0.5; // Fraction of hash table
                                                      // that can be filled
	protected final Entry<K, V> AVAILABLE = new Entry<>(null, null);
   
	public HashedDictionary()
	{
		this(DEFAULT_CAPACITY); // Call next constructor
	} // end default constructor
   
	public HashedDictionary(int initialCapacity)
	{
      initialCapacity = checkCapacity(initialCapacity);
		numberOfEntries = 0;    // Dictionary is empty
      
      // Set up hash table:
		// Initial size of hash table is same as initialCapacity if it is prime;
		// otherwise increase it until it is prime size
		int tableSize = getNextPrime(initialCapacity);
      checkSize(tableSize);   // Check that size is not too large
		
		// The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      Entry<K, V>[] temp = (Entry<K, V>[])new Entry[tableSize];
      hashTable = temp;
      integrityOK = true;
	} // end constructor

/* Implementations of methods in DictionaryInterface are here.
   . . .

   Implementations of private methods are here.
   . . . */

   protected final class Entry<S, T>
   {
      /* See Listing 21-1 in Chapter 21.
      . . . */
   } // end Entry
} // end HashedDictionary
