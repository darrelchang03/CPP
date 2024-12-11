@author Frank M. Carrano, Timothy M. Henry
@version 5.0
   public boolean contains(T anEntry)
   {
      checkIntegrity();
      return getIndexOf(anEntry) > -1; // or >= 0
   } // end contains
