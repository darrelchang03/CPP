// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public Object clone()
{
   AList<T> theCopy = null;

   // Clone the list
   try
   {
      @SuppressWarnings("unchecked")
      AList<T> temp = (AList<T>)super.clone();
      theCopy = temp;
   }
   catch (CloneNotSupportedException e)
   {
      throw new Error(e.toString());
   }

   // Clone the list's array
   theCopy.list = list.clone();

   // Clone the entries in the array (list[0] is unused and ignored)
   for (int index = 1; index <= numberOfEntries; index++)
   {
      @SuppressWarnings("unchecked")
      T temp = (T)list[index].clone();
      theCopy.list[index] = temp;
   } // end for

   return theCopy;
} // end clone

