/**
   An abstract base class that represents a circle.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public abstract class CircularBase
{
	private double radius;

	public void setRadius(double newRadius)
	{
		radius = newRadius;
	} // end setRadius

	public double getRadius()
	{
		return radius;
	} // end getRadius

	public abstract double getArea(); 
} // end CircularBase
