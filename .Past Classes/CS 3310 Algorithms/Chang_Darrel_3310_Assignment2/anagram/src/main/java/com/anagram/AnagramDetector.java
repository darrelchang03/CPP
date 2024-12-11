
/**************************************************************/
/* Darrel Chang */
/* Bronco ID: 015612623 */
/* CS 3310, Fall 2023 */
/* Programming Assignment 2 */
/* Anagram Detector: Detects words that are anagrams of each other from an input file*/
/**************************************************************/

package com.anagram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramDetector {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java AnagramDetector <file_path_to_input_txt>");
            return;
        }

        // Get filepath as string from command line argument
        String filePath = args[0];

        try {
            List<String> lines = readLinesFromFile(filePath);
            
            // Hashmap of sets of words that are anagrams
            Map<String, List<String>> anagramGroups = new HashMap<>();
            // List of words to be put in as they are not anagrams
            List<String> nonAnagrams = new ArrayList<>();

            for (String line : lines) {
                
                // processing lines from text file
                String preprocessed = preprocessString(line);
                String sorted = sortString(preprocessed);

                // If the preprocessed string is not in a set, put it in a new set
                if (!anagramGroups.containsKey(sorted)) {
                    anagramGroups.put(sorted, new ArrayList<String>());
                }
                
                anagramGroups.get(sorted).add(line);
            }

            for (List<String> group : anagramGroups.values()) {
                // If set has more than one word in it, those words are anagrams of each other, else that word does not have any anagrams
                if (group.size() > 1) {
                    // Output the original strings within anagrams group
                    String anagramSet = String.join(", ", group);
                    System.out.println("[" + anagramSet + "]");
                    // System.out.println("-----"); // Line of hyphens between sets
                } else {
                    nonAnagrams.add(group.get(0));
                }
            }

            // // Output strings that are not anagrams of any other string
            // System.out.println("Non-Anagrams:");
            // for (String nonAnagram : nonAnagrams) {
            //     System.out.println(nonAnagram);
            // }
        
        
        } catch (IOException e) {
            // Output file reading error
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

/**************************************************************/
/* Method: readLinesFromFile */
/* Purpose: takes in lines one by one from input file */
/* to find a particular book */
/* Parameters: String: filepath to the text file to be processed*/
/* Returns: String: Lines from the input file */
/**************************************************************/

    private static List<String> readLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

/**************************************************************/
/* Method: preprocessString */
/* Purpose: Removes accents/special character and converts strings to lowercase */
/* Parameters: String string*/
/* Returns: String: Without special chars/accents and lowercase */
/**************************************************************/

    private static String preprocessString(String string) {
        // Normalize to remove accents and convert to lowercase
        string = Normalizer.normalize(string, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();

        // Remove special characters and spaces
        string = string.replaceAll("[^a-z0-9\\s']", "");

        return string;
    }
    
/**************************************************************/
/* Method: sortString */
/* Purpose: Sorts input string into alphabetical order */
/* Parameters: String str */
/* Returns: String sorted alphabetically */
/**************************************************************/

    private static String sortString(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
