/**
   A class of runtime exceptions thrown when an attempt
   is made to find the square root of a negative number.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SquareRootException extends RuntimeException
{
   public SquareRootException()
   {
      super("Attempted square root of a negative number.");
   } // end default constructor
 
   public SquareRootException(String message)
   {
      super(message);
   } // end constructor
} // end SquareRootException
