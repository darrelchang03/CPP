import java.util.Iterator;
import java.util.Scanner;
/**
   A class that represents a concordance.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Concordance
{
   private DictionaryInterface<String, ListWithIteratorInterface<Integer>> wordTable;
          
   public Concordance()
   {
      wordTable = new SortedDictionary<>();
   } // end default constructor
   
   // 20.20
   /** Reads a text file of words and creates a concordance.
       @param data  A text scanner for the text file of data. */
   public void readFile(Scanner data) 
   {
      int lineNumber = 1;

      while (data.hasNext())
      {
         String line = data.nextLine();
         line = line.toLowerCase();

         Scanner lineProcessor = new Scanner(line);
         lineProcessor.useDelimiter("\\W+");
         while (lineProcessor.hasNext())
         {
            String nextWord = lineProcessor.next();
            ListWithIteratorInterface<Integer> lineList = wordTable.getValue(nextWord);
                                        
            if (lineList == null)
            { // Create new list for new word; add word and list to index
               lineList = new LinkedListWithIterator<>();
               wordTable.add(nextWord, lineList);
            } // end if

            // Add line number to end of list so list is sorted
            lineList.add(lineNumber);
         } // end while

         lineNumber++;
      } // end while

      data.close();    
   } // end readFile
   
   // 20.21
   /** Displays words and the lines in which they occur. */
   public void display()
   {
      Iterator<String> keyIterator = wordTable.getKeyIterator();
      Iterator<ListWithIteratorInterface<Integer>> valueIterator = wordTable.getValueIterator();
      
      while (keyIterator.hasNext())
      {
         // Display the word
         System.out.print(keyIterator.next() + " ");

         // Get line numbers and iterator
         ListWithIteratorInterface<Integer> lineList = valueIterator.next();
         Iterator<Integer> listIterator = lineList.getIterator();

         // Display line numbers
         while (listIterator.hasNext())
         {
            System.out.print(listIterator.next() + " ");
         } // end while
         
         System.out.println();
      } // end while    
   } // end display
} // end Concordance
