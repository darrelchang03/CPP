/**
   A class that represents a circle.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Circle implements Comparable<Circle>, Measurable
{
   private double radius;

   // Definitions of constructors and methods are here.
   // . . .

   public int compareTo(Circle other)
   {
      int result;
      if (this.equals(other))
         result = 0;
      else if (radius < other.radius)
         result = -1;
      else 
         result = 1;

      return result;
   } // compareTo
} // end Circle
