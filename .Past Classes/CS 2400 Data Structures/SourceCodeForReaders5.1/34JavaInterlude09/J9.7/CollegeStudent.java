/**
   A class that represents a college student.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class CollegeStudent extends Student implements Cloneable
{
	private int    year;   // Year of graduation
	private String degree; // Degree sought

/* Constructors and the methods setStudent, setYear, getYear,
     setDegree, getDegree, toString, and clone go here. 
   . . . */
   
	public Object clone()
	{
      CollegeStudent theCopy = (CollegeStudent)super.clone();
	   
      return theCopy;
	} // end clone
} // end CollegeStudent
