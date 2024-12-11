/**
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Example
{
   public static <T> void displayArray(T[] anArray)
   {
      for (T arrayEntry : anArray)
      {
         System.out.print(arrayEntry);
         System.out.print(' ');
      } // end for
      System.out.println();
    } // end displayArray

    public static void main(String args[])
    {
       String[] stringArray = {"apple", "banana", "carrot", "dandelion"};
       System.out.print("stringArray contains ");
       displayArray(stringArray);

       Character[] characterArray = {'a', 'b', 'c', 'd'};
       System.out.print("characterArray contains ");
       displayArray(characterArray);
    } // end main
} // end Example
/*
 stringArray contains apple banana carrot dandelion
 characterArray contains a b c d
*/
