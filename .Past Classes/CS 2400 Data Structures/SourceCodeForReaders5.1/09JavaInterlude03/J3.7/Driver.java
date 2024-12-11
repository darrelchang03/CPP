/**
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Driver
{
   public static void main(String[] args)
   {
      SuperClass superObject = new SubClass();
      try
      {
         superObject.someMethod();
      }
      catch (Exception1 e)
      {
         System.out.println(e.getMessage());
      }
   } // end main
} // end Driver
