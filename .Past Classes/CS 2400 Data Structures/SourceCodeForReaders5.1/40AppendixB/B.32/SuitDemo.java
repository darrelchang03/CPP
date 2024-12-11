/** A demonstration of the enumeration Suit. 
    @author Frank M. Carrano
    @author Timothy M. Henry
    @version 4.0
*/
public class SuitDemo
{
   private enum Suit
   {
      CLUBS("black"), DIAMONDS("red"), HEARTS("red"), SPADES("black");

      private final String color;

      private Suit(String suitColor)
      {
         color = suitColor;
      } // end constructor

      public String getColor()
      {
         return color;
      } // end getColor
   } // end Suit

   public static void main(String[] args)
   {
      for (Suit nextSuit : Suit.values())
      {
         System.out.println(nextSuit + " are " + nextSuit.getColor() +
                            " and have an ordinal value of " + 
                            nextSuit.ordinal());
      } // end for
   } // end main
} // end SuitDemo
