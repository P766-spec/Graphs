package Graphs;

import java.util.LinkedList;

// DFS traversal:  STACK Implementation
public class Graph1 {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph1(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v ; i++) {
            adj[i] = new LinkedList();
        }
    }
    void addEdge(int v, int w){
        adj[v].add(w);
    }
    void DFSUtil(int vertex, boolean nodes[])
    {
        nodes[vertex] = true;
        System.out.println(vertex + " ");
        int a  = 0;

        for (int i = 0; i < adj[vertex].size(); i++) {
            a  =adj[vertex].get(i);
            if(!nodes[a])
            {
                DFSUtil(a, nodes);
            }
        }
    }
    void DFS(int v)
    {
        boolean already[] = new boolean[V];
        DFSUtil(v, already);
    }

    public static void main(String[] args) {
        Graph1 g = new Graph1(6);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,0);
        g.addEdge(1,3);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,3);
        g.addEdge(5,3);

        System.out.println("Following is the Depth First Search Traversal: ");

        g.DFS(0);
    }



}
