// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public Object clone()
{
   AList<T> theCopy = null;

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

/* For a deep copy, we need to do more here, as you will see 
   . . . */

   return theCopy;
} // end clone

