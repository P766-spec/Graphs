package Questions;
// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

public class SameLabel {
    private int[] ans;
    private List<Integer>[] adj;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        adj = new List[n];
        for(int i =0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        ans = new int[n];
        dfs(0, -1, labels);
        return ans;

    }
    private int[] dfs(int currNode, int parent, String labels){
        int[] currSubtree = new int[26];
        for(int child : adj[currNode]){
            if(child == parent){
                continue;
            }
            int[] childSubtree = dfs(child, currNode, labels);

            for(int i =0; i< 26; i++) {
                currSubtree[i] += childSubtree[i];
            }
        }
        currSubtree[labels.charAt(currNode) -'a']++;
        ans[currNode] = currSubtree[labels.charAt(currNode) - 'a'];
        return currSubtree;
}
