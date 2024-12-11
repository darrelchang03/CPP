import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a resizable array.
   The dictionary is sorted and has distinct search keys. Search keys and
   associated values are not null.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SortedArrayDictionary<K extends Comparable<? super K>, V>
             implements DictionaryInterface<K, V>
{
	private Entry<K, V>[] dictionary; // Array of entries sorted by search key
	private int numberOfEntries; 
   private boolean integrityOK = false;
	private final static int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

/* < Constructors analogous to those in Listing 21-1.
     . . .
     Implementations of methods in DictionaryInterface.
      . . .
     The private class Entry, as shown in Listing 21-1.
     . . .
 */
} // end SortedArrayDictionary
