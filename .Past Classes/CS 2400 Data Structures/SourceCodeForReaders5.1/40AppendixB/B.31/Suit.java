/** An enumeration of card suits. 
    @author Frank M. Carrano
    @author Timothy M. Henry
    @version 5.0
*/
enum Suit
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
