import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
   A driver that demonstrates the class FrequencyCounter.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Driver
{
   public static void main(String[] args) 
   {
      FrequencyCounter wordCounter = new FrequencyCounter();
      String fileName = "Data.txt"; // Or file name could be read

      try
      {
         Scanner data = new Scanner(new File(fileName));
         wordCounter.readFile(data);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found: " + e.getMessage());
      }

      wordCounter.display();
   }  // end main
}  // end Driver

