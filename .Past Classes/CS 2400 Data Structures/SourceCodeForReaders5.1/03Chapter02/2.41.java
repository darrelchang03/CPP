   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose " +
                                         "capacity exeeds allowed " +
                                         "maximum of " + MAX_CAPACITY);
   } // end checkCapacity

   // Doubles the size of the array bag.
   // Precondition: checkIntegrity has been called.
   private void doubleCapacity()
   {
      int newLength = 2 * bag.length;
      checkCapacity(newLength);
      bag = Arrays.copyOf(bag, newLength);
   } // end doubleCapacity
