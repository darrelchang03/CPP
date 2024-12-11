package com.example;
import java.util.*;

public interface GraphInterface {

    void addEdge (Integer begin, Integer end);

    List<Set<Integer>> findConnectedComponents();
    
    void dfs(int v, boolean[] visited, Set<Integer> component);
}
