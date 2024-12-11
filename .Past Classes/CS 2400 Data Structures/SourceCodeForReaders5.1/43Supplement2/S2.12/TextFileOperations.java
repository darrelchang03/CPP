import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
   A class of static methods that create and display a text file of
   user-supplied data.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class TextFileOperations
{
   /** Writes a given number of lines to the named text file.
       @param fileName  The file name as a string.
       @param howMany  The positive number of lines to be written.
       @return  True if the operation is successful. */
   public static boolean createTextFile(String fileName, int howMany)
   {
      boolean fileOpened = true;
      PrintWriter toFile = null;
      try
      {
         toFile = new PrintWriter(fileName);
      }
      catch (FileNotFoundException e)
      {
         fileOpened = false; // Error opening the file
      }
      
      if (fileOpened)
      {
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Enter " + howMany + " lines of data:");
         for (int counter = 1; counter <= howMany; counter++)
         {
            System.out.print("Line " + counter + ": ");
            String line = keyboard.nextLine();
            toFile.println(line);
         } // end for
         
         toFile.close();
      } // end if
      
      return fileOpened;
   } // end createTextFile
} // end TextFileOperations
