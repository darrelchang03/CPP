// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public static void countDown(int integer)
{
   if (integer == 1)
      System.out.println(integer);
   else
   {
      System.out.println(integer);
      countDown(integer - 1);
   } // end if
} // end countDown

