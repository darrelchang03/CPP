   /** Adds a new entry to this bag.
       @param newEntry  The object to be added as a new entry.
       @return  True.
       @author Frank M. Carrano, Timothy M. Henry
       @version 5.0
   */
   public boolean add(T newEntry)
   {
      checkIntegrity();
      boolean result = true;
      if (isArrayFull())
      {
         doubleCapacity();
      } // end if

      bag[numberOfEntries] = newEntry;
      numberOfEntries++;

      return true;
   } // end add
