package data_structure;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author prateek.bangre on 21/07/21.
 * @Project Algorithm_Study
 */
public class Adjacency_List_Graph {

    private int numVertices;
    private LinkedList<Integer> adjLists[];;

    Adjacency_List_Graph(int numVertices){
        this.numVertices = numVertices;
        this.adjLists = new LinkedList[numVertices];

        for (int i=0; i<numVertices; ++i){
            this.adjLists[i] = new LinkedList<>();
        }
    }

    // Add edge
    private void addEdge(int s, int d) {
        adjLists[s].add(d);
        adjLists[d].add(s);
    }

    // Print the graph
    private void printGraph() {
        for (int i = 0; i < adjLists.length; i++) {
            System.out.print("Vertex " + i + ":");
            for (int j = 0; j < adjLists[i].size(); j++) {
                System.out.print(" -> " + adjLists[i].get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create the graph
        int vertex = 5;
        Adjacency_List_Graph graph = new Adjacency_List_Graph(vertex);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);

        graph.printGraph();
    }
}
