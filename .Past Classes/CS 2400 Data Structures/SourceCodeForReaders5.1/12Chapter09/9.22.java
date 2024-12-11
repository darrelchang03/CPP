// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public static void countDown(int n)
{
   System.out.println(n);
   if (n > 1)
      countDown(n - 1);
} // end countDown

