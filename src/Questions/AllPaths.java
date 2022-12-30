package Questions;
import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/all-paths-from-source-to-target/

public class AllPaths {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        List<Integer> path = new ArrayList<>();
        dfs(graph, path, 0);
        return res;
    }
    private void dfs(int[][] graph, List<Integer> path, int u){
        path.add(u);
        if(u == graph.length - 1)
            res.add(new ArrayList(path));
        else {
            for(int v : graph[u]) {
                dfs(graph, path, v);
                path.remove(path.size() - 1);
            }
        }
    }
}
