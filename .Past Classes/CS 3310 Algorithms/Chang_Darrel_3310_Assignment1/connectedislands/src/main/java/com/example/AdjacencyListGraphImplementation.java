package com.example;
import java.util.*;

public class AdjacencyListGraphImplementation implements GraphInterface{
    
    private int V;
    private List<Integer>[] adjacencyList;

    public AdjacencyListGraphImplementation(int V) {
        this.V = V;
        adjacencyList = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    } // main contructor

    public void addEdge(Integer begin, Integer end) {
        // if statment for edge case where there are duplicate edges eg. (2,1) (1,2)
        if(!adjacencyList[begin].contains(end)) {
            adjacencyList[begin].add(end);
            adjacencyList[end].add(begin); // add both ways since its undirected graph
        }
    }

    public List<Set<Integer>> findConnectedComponents() {
        boolean[] visited = new boolean[V];
        List<Set<Integer>> components = new ArrayList<>();

        //iterate through verticies in graph, if it is unvisted start a new connected component and perform dfs
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                Set<Integer> component = new HashSet<>();
                dfs(i, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    public void dfs(int v, boolean[] visited, Set<Integer> component) {
        visited[v] = true;
        component.add(v);
        for(int neighbor : adjacencyList[v]) {
            if(!visited[neighbor]) {
                dfs(neighbor, visited, component);
            }
        }
    }
}
