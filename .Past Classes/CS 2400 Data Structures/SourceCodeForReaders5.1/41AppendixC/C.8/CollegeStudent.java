/**
   A class that represents a college student.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class CollegeStudent extends Student
{
	private int    year;   // Year of graduation
	private String degree; // Degree sought

	public CollegeStudent()
	{
		super();     // Must be first statement in constructor
		year = 0;
		degree = "";
		// Or replace the previous three statements with
      // this(studentName, studentId, 0, ""); (see Segment C.10)
	} // end default constructor

	public CollegeStudent(Name studentName, String studentId,
	                      int graduationYear, String degreeSought)
	{
		super(studentName, studentId); // Must be first
		year = graduationYear;
		degree = degreeSought;
	} // end constructor

	public void setStudent(Name studentName, String studentId,
	                       int graduationYear, String degreeSought)
	{
		setName(studentName); // NOT fullName = studentName;
		setId(studentId);     // NOT id = studentId;
   // Or setStudent(studentName, studentId); (see Segment C.16)

		year = graduationYear;
		degree = degreeSought;
	} // end setStudent

/* The methods setYear, getYear, setDegree, and getDegree go here.
   . . . */

	public String toString()
	{
		return super.toString() + ", " + degree + ", " + year;
	} // end toString
} // end CollegeStudent
