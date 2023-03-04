/*---------------------------------------------------------------------------
                                KruskalPath.java
This program finds the minimum cost spanning tree of a given undirected graph 
using Kruskal’s Algorithm.
                    
@author Adelicia
@date   11/11/22
---------------------------------------------------------------------------*/

package DAA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.PriorityQueue;

public class KruskalPath {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }

        public void kruskalMST() {
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(),
                    Comparator.comparingInt(o -> o.weight));
            pq.addAll(allEdges);
            int[] parent = new int[vertices];
            makeSet(parent);
            ArrayList<Edge> mst = new ArrayList<>();
            int index = 0;
            while (index < vertices - 1) {
                Edge edge = pq.remove();
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);
                if (x_set == y_set) {
                } else {
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }
            System.out.println("Minimum Spanning Tree: ");
            printGraph(mst);
        }

        public void makeSet(int[] parent) {
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        public int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex)
                return find(parent, parent[vertex]);
            return vertex;
        }

        public void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            parent[y_set_parent] = x_set_parent;
        }

        public void printGraph(ArrayList<Edge> edgeList) {
            for (int i = 0; i < edgeList.size(); i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source + " destination: " + edge.destination
                        + " weight: " + edge.weight);
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices initially");
        int n = sc.nextInt();
        Graph graph = new Graph(n);

        System.out.println("Enter the number of edges present");
        int edges = sc.nextInt();

        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the source, destination and weight of edge " + (i + 1));
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            graph.addEgde(s, d, w);
        }

        graph.kruskalMST();

        sc.close();

    }
}