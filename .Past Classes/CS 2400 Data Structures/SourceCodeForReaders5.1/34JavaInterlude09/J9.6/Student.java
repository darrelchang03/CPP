/**
   A class that represents a student that can be cloned.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Student implements Cloneable
{
	private Name   fullName;
	private String id;      // Identification number

/* Constructors and the methods setStudent, setName, setId,
        getName, getId, and toString go here. 
   . . . */
   
	public Object clone()
	{
      Student theCopy = null;

      try
      {
         theCopy = (Student)super.clone(); // Object can throw an exception
      }
      catch (CloneNotSupportedException e)
      {
         throw new Error(e.toString());
      }

      theCopy.fullName = (Name)fullName.clone();
      return theCopy;
	} // end clone
}  // end Student
