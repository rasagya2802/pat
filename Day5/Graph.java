
import java.util.*;

//leetcode 1791
//leetcode 200
//leetcode 130
public class Graph {
    static List<Integer> adj[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        graph g = new graph(V);
        for(int i=0; i<E; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            insert(s, d);
        }
        System.out.print("BFS Traversal: ");
        bfs(V,0);
        System.out.print("\nDFS Traversal: ");
        dfs(V,0);
    }

    static class graph{
        graph(int V) {
            adj = new LinkedList[V];
            for(int i=0; i<V; i++) adj[i] = new LinkedList<>();
    }

}

    static void insert(int s, int d) {
        adj[s].add(d);
        adj[d].add(s);
    }

    static void bfs(int V, int sr) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(sr);
        visited[sr] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for(int neighbor : adj[node]) {
                if(!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
               }
             }
          }
       }

       static void dfs(int V, int sr) {
        boolean visited[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        s.push(sr);
        visited[sr] = true;
        while(!s.isEmpty()) {
            int node = s.pop();
            System.out.print(node + " ");
            for(int neighbor : adj[node]) {
                if(!visited[neighbor]) {
                    s.push(neighbor);
                    visited[neighbor] = true;
               }
             }
          }
       }
    }
 
