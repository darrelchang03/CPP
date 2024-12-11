/**
   A class that represents a student.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Student
{
	private Name   fullName;
	private String id;   // Identification number

	public Student()
	{
		fullName = new Name();
      id = "";
	} // end default constructor

	public Student(Name studentName, String studentId)
	{
		fullName = studentName;
		id = studentId;
	} // end constructor

	public void setStudent(Name studentName, String studentId)
	{
		setName(studentName); // Or fullName = studentName;
		setId(studentId);     // Or id = studentId;
	} // end setStudent

	public void setName(Name studentName)
	{
		fullName = studentName;
   } // end setName

	public Name getName()
	{
		return fullName;
	} // end getName

	public void setId(String studentId)
	{
		id = studentId;
	} // end setId

	public String getId()
	{
		return id;
	} // end getId

	public String toString()
	{
		return id + " " + fullName.toString();
	} // end toString
}  // end Student
