/** 
   A driver that uses a list to track the runners in a race
   as they cross the finish line.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class RoadRace
{
	public static void main(String[] args) 
	{
		recordWinners();
	}  // end main

	public static void recordWinners()
	{
      ListInterface<String> runnerList = new AList<>();
  //  runnerList has only methods in ListInterface

      runnerList.add("16"); // Winner
      runnerList.add(" 4"); // Second place
      runnerList.add("33"); // Third place
      runnerList.add("27"); // Fourth place
      displayList(runnerList);
   } // end recordWinners
   
   public static void displayList(ListInterface<String> list)
   {
      int numberOfEntries = list.getLength();
      System.out.println("The list contains " + numberOfEntries +
                         " entries, as follows:");
      for (int position = 1; position <= numberOfEntries; position++)
         System.out.println(list.getEntry(position) +
                            " is entry " + position);
      System.out.println();
   } // end displayList
} // end RoadRace

/*
The list contains 4 entries, as follows:
16 is entry 1
 4 is entry 2
33 is entry 3
27 is entry 4
*/
