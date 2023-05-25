import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<String> set = new HashSet<>();
    int [] visited;
    public int numTilePossibilities(String tiles) {
        visited = new int[tiles.length()];
        backTracing(tiles,new StringBuffer(), 0);
        return set.size();
    }   
    // index是tiles的length，指示现在buffer有多少位
    public void backTracing(String tiles,StringBuffer buffer, int index){
        if(index == tiles.length()){
            set.add(buffer.toString());
            return;
        }
        for(int i = 0; i < tiles.length(); i++){
            if(visited[i] == 1){
                continue;
            }
            buffer.append(tiles.charAt(i));
            visited[i] = 1;
            set.add(buffer.toString());
            backTracing(tiles,buffer,index+1);
            buffer.deleteCharAt(index);
            visited[i] = 0;
        }
    }
}
