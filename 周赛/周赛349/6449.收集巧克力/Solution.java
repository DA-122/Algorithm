import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args){
        int [] nums = {20,1,15};
        int x = 5;
        minCost(nums, x);
    }
    public static long minCost(int[] nums, int x) {
        long result = 0L;
        int n = nums.length;
        Map<Integer,Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= x){
                result+=nums[i];
            }else{
                map.put(i,(long)nums[i]);
            }
        }
        int moveRound = 0;
        int realMoveRound = 0;
        while(!map.isEmpty()){
            moveRound++;
            Iterator<Map.Entry<Integer, Long>> it = map.entrySet().iterator();  
            while(it.hasNext()){
                Map.Entry<Integer, Long> entry = it.next();  
                int pos = entry.getKey();
                long value = entry.getValue();
                long curValue = nums[(pos+moveRound)%n];
                if((moveRound - realMoveRound)*x + curValue < value){
                    map.put(pos,curValue);
                    value = curValue;
                    realMoveRound = moveRound;
                }else{
                    result+=value;
                    it.remove();
                }
            }
        }
        return result+realMoveRound*x;
    }
}