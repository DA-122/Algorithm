// 131.分割回文串
// 复杂度分析：C(1,16) + .... +C(1,1) O(n^2)
// 思路分析： 回溯，回溯切割点
// 回文判断：朴素判断/动态规划预处理判断所有子串
// 动规分析 f(i,j) = f(i+1, j-1) && s[i] == s[j]
// 需要提前初始化所有的 j = i + 1
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<String>> res  = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backTracing(s,0);
        return res;
    }
    public void backTracing(String s, int index){
        if(index == s.length()){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index; i < s.length(); i++){
            String str = s.substring(index, i+1);
            if(!isPali(str)){
                continue;
            }
            list.add(str);
            backTracing(s, i+1);
            list.removeLast();
        }
    }

    public boolean isPali(String s){
        if(s.length() == 1){
            return true;
        }
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left)!= s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}