// @author Frank M. Carrano
// @author Timothy M. Henry
// @version 5.0
int i = 0;
while (i < 20)
{
   try
   {
      if (i == 10)
         throw new Exception();
      else if (i % 2 == 0)
         System.out.print1n(i + " is even.");
   }
   catch(Exception e)
   {
      System.out.println("Exception: " + i + " is too large.");
   }
   i++;
} // end while
//................................................................
int i = 0;
try
{
   while (i < 20)
   {
      if (i == 10)
         throw new Exception();
      else if (i % 2 == 0)
         System.out.print1n(i + " is even.");
      i++;
   } // end while
}
catch(Exception e)
{
   System.out.println("Exception: " + i + " is too large.");
}
