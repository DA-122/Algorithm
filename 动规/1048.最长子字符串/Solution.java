// ����1048 ����ַ���
// ˼·�����������ַ���s��������Ǵ��������һ�����ʣ�ȥ��s��һ����ĸ�������ַ���Ϊt���ͱ����t��β�Ĵ����������
// dp[s] = max(dp[j]) + 1
 
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution{
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        Map<String, Integer> cnt = new HashMap<>();
        int result = 0;
        for(int i = 0; i < words.length; i++){
            cnt.put(words[i],1);
            for(int j  = 0;j <words[i].length(); j++){
                String prev = words[i].substring(0, j) + words[i].substring(j + 1);
                if (cnt.containsKey(prev)) {
                    cnt.put(words[i], Math.max(cnt.get(words[i]), cnt.get(prev) + 1));
                }
            }
            result = Math.max(result,cnt.get(words[i]));
        }
        return result;
    }
    public static void main(String[] args){
        String []words = {"a","bas","ba","bca","bda","bdca"};
        longestStrChain(words);
    }
}