// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean isEmpty()
{
   boolean result;
      
   if (numberOfEntries == 0) // Or getLength() == 0
   {
      // Assertion: firstNode == null
      result = true;
   }
   else
   {
      // Assertion: firstNode != null
      result = false;
   } // end if
      
   return result;
} // end isEmpty

