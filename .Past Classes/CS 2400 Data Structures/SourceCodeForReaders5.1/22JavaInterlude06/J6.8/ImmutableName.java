/**
   An immutable class that represents a person's name.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
 public final class ImmutableName
{
   private String first; // First name
   private String last;  // Last name

   public ImmutableName(String firstName, String lastName)
   {
      first = firstName;
      last = lastName;
   } // end constructor

   public String getFirst()
   {
      return first;
   } // end getFirst

   public String getLast()
   {
      return last;
   } // end getLast

   public String getName()
   {
      return toString();
   } // end getName

   public String toString()
   {
      return first + " " + last;
   } // end toString
} // end ImmutableName
