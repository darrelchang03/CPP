import java.util.Iterator;
import java.util.Scanner;
/**
   A class that counts the number of times each word occurs in a document.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class FrequencyCounter
{
   private DictionaryInterface<String, Integer> wordTable;

   public FrequencyCounter() 
   {
      wordTable = new SortedDictionary<>();
   } // end default constructor
   
   // 20.16
   /** Reads a text file of words and counts their frequencies of occurrence.
       @param data  A text scanner for the text file of data. */
   public void readFile(Scanner data)
   {
      data.useDelimiter("\\W+");

      while (data.hasNext())
      {
         String nextWord = data.next();
         nextWord = nextWord.toLowerCase();
         Integer frequency = wordTable.getValue(nextWord);

         if (frequency == null)
         { // Add new word to table
            wordTable.add(nextWord, Integer.valueOf(1));
         }
         else
         {  // Increment count of existing word; replace wordTable entry
            frequency++;
            wordTable.add(nextWord, frequency);
         } // end if
      } // end while

      data.close();
   } // end readFile
   
   // 20.17
   /** Displays words and their frequencies of occurrence. */
   public void display()
   {
      Iterator<String>  keyIterator   = wordTable.getKeyIterator();
      Iterator<Integer> valueIterator = wordTable.getValueIterator();

      while (keyIterator.hasNext())
      {
         System.out.println(keyIterator.next() + " " + valueIterator.next());
      } // end while    
   } // end display
} // end FrequencyCounter
