public class Main {
    public static void main(String[] args){
        int n = 7;
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        int t = 2;
        int target = 4;
        Solution solution = new Solution();
        solution.frogPosition(n, edges, t, target);
    }

}
