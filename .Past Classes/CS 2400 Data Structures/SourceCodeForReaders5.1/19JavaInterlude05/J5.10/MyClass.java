/**
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public MyClass
{
   // First draft and INCORRECT:
   public static <T> T arrayMinimum(T[] anArray)
   {
      T minimum = anArray[0];
      for (T arrayEntry : anArray)
      {
         if (arrayEntry.compareTo(minimum) < 0)
            minimum = arrayEntry;
      } // end for

      return minimum;
   } // end arrayMinimum
} // end MyClass
