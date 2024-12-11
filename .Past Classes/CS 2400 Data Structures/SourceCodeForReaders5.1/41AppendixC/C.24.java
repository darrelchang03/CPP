// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

// The method equals in the class Object:
public boolean equals(Object other)
{
   return (this == other);
} // end equals

// The method equals in the class Name:
public boolean equals(Object other)
{
   boolean result;

   if (other instanceof Name)
   {
      Name otherName = (Name)other;
      result = first.equals(otherName.first) && 
               last.equals(otherName.last);
   } // end if

   return result;
} // end equals

