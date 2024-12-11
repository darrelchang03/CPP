// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public int getPosition(T anEntry)
{
   int position = 1;
   int length = list.getLength();

   // Find position of anEntry
   while ( (position <= length) &&
           (anEntry.compareTo(list.getEntry(position)) > 0) )
   {
      position++;
   } // end while

   // See whether anEntry is in list
   if ( (position > length) ||
        (anEntry.compareTo(list.getEntry(position)) != 0) )
   {
      position = -position; // anEntry is not in list
   } // end if

   return position;
} // end getPosition
