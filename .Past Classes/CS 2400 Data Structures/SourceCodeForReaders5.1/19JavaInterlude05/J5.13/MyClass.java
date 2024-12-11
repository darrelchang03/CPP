/**
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public MyClass
{
   public static <T extends Comparable<T>> T arrayMinimum(T[] anArray)
   //public static <T extends Comparable<? super T>> void arrayMinimum(T[] anArray)
   {
      T minimum = anArray[0];
      for (T arrayEntry : anArray)
      {
         if (arrayEntry.compareTo(minimum) < 0)
            minimum = arrayEntry;
      } // end for

      return minimum;
   } // end arrayMinimum
   // . . .
} // end MyClass
