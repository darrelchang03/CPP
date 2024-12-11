// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean remove(T anEntry)
{
   boolean result = false;
   int position = getPosition(anEntry);

   if (position > 0)
   {
      list.remove(position);
      result = true;
   } // end if

   return result;
} // end remove
