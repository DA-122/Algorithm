import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Solution {
    public static void main(String[] args) {
        int nums[] = {50,40,30,0,10,50,50,60,60};
        System.out.println(function(nums));
    }   
    public int getNum(List<Integer> nums){
        int res = 0;
        for(int num : nums){
            if(num > 10){
                res = num;
                break;
            }
        }
        return res;
    } 
    public static int function(int [] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int res = 0;
        for(int num: nums){
            map.put(num,map.get(num) - 1);
            if(map.containsKey(100 - num)){
                res += map.get(100 -num);
            }
        }
        return res;
    }
}
