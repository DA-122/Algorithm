// »ØËİ·¨
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracing(1,k,n);
        return res;
    }
    public void backtracing(int cur, int k , int n){
        if(list.size() == k){
            int sum = 0;
            for(int i  = 0 ; i < list.size(); i++){
                sum+= list.get(i);
            }
            if(sum == n){
                res.add(new ArrayList(list));
            }
            return;
        }   
        for(int i = cur ; i <= 9 - k + list.size()+1; i++){
            list.add(i);
            backtracing(i+1,k,n);
            list.removeLast();
        }
    }
}

public class Main{
    public static void main(String[] args){
        Solution solution = new Solution();
        int n = 45, k = 9;
        solution.combinationSum3(k,n);
    }
}