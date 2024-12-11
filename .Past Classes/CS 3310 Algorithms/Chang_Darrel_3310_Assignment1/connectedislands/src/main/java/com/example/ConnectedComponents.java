package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConnectedComponents {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Usage: java ConnectedComponents inputFileName.txt");
            return;
        }

        String filename = args[0];

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int graphNumber = 1;
            String currentLine;

            while((currentLine = br.readLine()) != null) {
                String[] tokens = currentLine.split("\\s+");
                int verticies = Integer.parseInt(tokens[0]);
                AdjacencyListGraphImplementation graph = new AdjacencyListGraphImplementation(verticies);

                


                for(int i = 1; i < tokens.length; i++) {
                    String token = tokens[i];
                    Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");
                    Matcher matcher = pattern.matcher(token);
                    int begin = 0;
                    int end = 0;
                    if(matcher.matches()) {
                        begin = Integer.parseInt(matcher.group(1)) - 1;
                        end = Integer.parseInt(matcher.group(2)) - 1;
                        graph.addEdge(begin, end);
                    }

                }

                List<Set<Integer>> components = graph.findConnectedComponents();
                System.out.println("Graph " + graphNumber + ":");
                System.out.println(components.size() + " connected component(s):");

                // Since our verticies are zero-based indexed,
                // print vertices with +1 added to each vertex number
                for (Set<Integer> component : components) {
                    System.out.print("{");
                    boolean isFirst = true;
                    for (int vertex : component) {
                        if (!isFirst) {
                            System.out.print(" ");
                        }
                        System.out.print((vertex + 1)); // Add 1 to convert to one-based indexing
                        isFirst = false;
                    }
                    System.out.println("}");
                }
                System.out.println();
                graphNumber++;
        }
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
