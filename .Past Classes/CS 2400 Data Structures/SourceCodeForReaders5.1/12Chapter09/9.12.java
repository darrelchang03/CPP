/** @param n  An integer > 0.
    @return  The sum 1 + 2 + ... + n.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public static int sumOf(int n)
{
   int sum;
   if (n == 1)
      sum = 1;                // Base case
   else
      sum = sumOf(n - 1) + n; // Recursive call
    
   return sum;
} // end sumOf

