// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

/** Displays this object after skipping numberOfLines lines. */
public void displayAt(int numberOfLines)
{
   for (int count = 0; count < numberOfLines; count++)
      System.out.println();
   display();
} // end displayAt
