   @author Frank M. Carrano, Timothy M. Henry
   @version 5.0
   public ArrayBag(int desiredCapacity)
   {
      if (desiredCapacity <= MAX_CAPACITY)
      {
         // The cast is safe because the new array contains null entries
         @SuppressWarnings("unchecked")
         T[] tempBag = (T[])new Object[capacity]; // Unchecked cast
         bag = tempBag;
         numberOfEntries = 0;
         initialized = true;
      }
      else
         throw new IllegalStateException("Attempt to create a bag whose " +
                                         "capacity exceeds allowed maximum.");
   } // end constructor
