// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
Iterator<String> nameIterator = namelist.iterator();
while (nameIterator.hasNext())
{
   String currentName = nameIterator.next();

   int nameCount = 0;

   Iterator<String> countingIterator = namelist.iterator();
   while (countingIterator.hasNext())
   {
      String nextName = countingIterator.next();
      if (currentName.equals(nextName))
         nameCount++;
      /*
      if (currentName.equals(nextName))
      {
         nameCount++;
         if (nameCount > 1)
            countingIterator.remove();
      } // end if
      */
   } // end while

   System.out.println(currentName + " occurs " + nameCount + " times.");
} // end while
