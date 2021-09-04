package data_structure;

import java.util.Arrays;

/**
 * @author prateek.bangre on 21/07/21.
 * @Project Algorithm_Study
 */
public class Adjacency_Matrix_Graph {

    private boolean[][] adjMatrix;
    private int numVertices;

    // Initialize the matrix
    Adjacency_Matrix_Graph(int numVertices){
        this.numVertices = numVertices;
        this.adjMatrix = new boolean[numVertices][numVertices];
    }

    // Add edges
    private void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    // Remove edges
    private void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    // Print the matrix
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            sb.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                sb.append((j ? 1 : 0) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Adjacency_Matrix_Graph g = new Adjacency_Matrix_Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());
    }
}
