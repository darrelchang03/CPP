   @author Frank M. Carrano, Timothy M. Henry
   @version 5.0
   public boolean add(T newEntry)
   {
      if (integrityOK)
      {
         boolean result = true;
         if (isArrayFull())
         {
            result = false;
         }
         else
         { // Assertion: result is true here
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
         } // end if

         return result;
      }
      else
         throw new SecurityException("ArrayBag object is corrupt.");
   } // end add
//================================
   // Throws an exception if this object is not initialized.
   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException("ArrayBag object is corrupt.");
   } // end checkIntegrity

   public boolean add(T newEntry)
   {
      checkIntegrity();
      boolean result = true;
      if (isArrayFull())
      {
         result = false;
      }
      else
      {  // Assertion: result is true here
         bag[numberOfEntries] = newEntry;
         numberOfEntries++;
      } // end if

      return result;
   } // end add
