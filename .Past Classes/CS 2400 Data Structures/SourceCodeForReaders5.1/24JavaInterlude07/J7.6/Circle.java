/**
   A class that represents a circle.
      
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Circle extends CircularBase
{
	public double getArea()
	{
		double circleRadius = getRadius();
      return Math.PI * circleRadius * circleRadius;
 	} // end getArea
} // end Circle
