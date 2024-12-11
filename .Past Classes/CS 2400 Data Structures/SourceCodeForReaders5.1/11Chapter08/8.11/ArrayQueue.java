/**
   A class that implements a queue of objects by using an array.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class ArrayQueue<T> implements QueueInterface<T>
{
   private T[] queue; // Circular array of queue entries and one unused element
   private int frontIndex;
   private int backIndex;
   private boolean integrityOK;
   private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
   
   public ArrayQueue()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
   
   public ArrayQueue(int initialCapacity)
   {
      integrityOK = false;
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempQueue = (T[]) new Object[initialCapacity + 1];
      queue = tempQueue;
      frontIndex = 0;
      backIndex = initialCapacity;
      integrityOK = true;
   } // end constructor

//  < Implementations of the queue operations go here. >
//  . . .
  
} // end ArrayQueue
