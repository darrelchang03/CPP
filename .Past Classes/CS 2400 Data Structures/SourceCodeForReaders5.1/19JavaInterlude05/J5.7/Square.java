/**
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Square<T>
{
   private T side;
   
   public Square(T initialSide)
   {
      side = initialSide;
   } // end constructor
   
   public T getSide()
   {
      return side;
   } // end getSide
} // end Square
